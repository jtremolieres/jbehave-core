package org.jbehave.core.io;

import org.jbehave.core.io.CodeLocations.InvalidCodeLocation;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CodeLocationsBehaviour {

    @Test
    public void shouldCreateCodeLocationFromPath() {
        String path = "target/classes/";
        URL codeLocation = CodeLocations.codeLocationFromPath(path);
        assertThat(codeLocation.getFile(), endsWith(path));
    }

    @Test
    public void shouldCreateCodeLocationFromURL() {
        String url = "http://company.com/stories/";
        URL codeLocation = CodeLocations.codeLocationFromURL(url);
        assertThat(codeLocation.toString(), equalTo(url));
        assertThat(codeLocation.toExternalForm(), equalTo(url));
    }

    @Test
    public void shouldCreateCodeLocationFromJarClass() {
        // wrong output looks like this:
        // "C:/Projects/jbehave/file:/C:/Users/Name/.m2/repository/junit/junit-dep/4.8.2/junit-dep-4.8.2.jar!"
        assertThat(CodeLocations.codeLocationFromClass(this.getClass()).getFile(), not(containsString("/file:")));
        final String filename = CodeLocations.codeLocationFromClass(JUnitCore.class).getFile();
        assertThat(filename, not(containsString("/file:")));
        assertThat(filename, not(containsString("/jar:")));
        assertThat(filename, not(endsWith("!")));
        assertThat(new File(filename).exists(), is(true));
    }

    @Test(expected = InvalidCodeLocation.class)
    public void shouldNotCreateCodeLocationFromPathIfInvalid() {
        CodeLocations.codeLocationFromPath(null);
    }

    @Test(expected = InvalidCodeLocation.class)
    public void shouldNotCreateCodeLocationFromURLIfInvalid() {
        CodeLocations.codeLocationFromURL("htp://company.com/stories/");
    }

    @Test
    public void shouldAllowInstantiation() {
        assertThat(new CodeLocations(), is(notNullValue()));
    }

    @Test
    public void shouldHandleSpacesAndSpecialChars() throws MalformedURLException, URISyntaxException {
        assertThat(CodeLocations.getPathFromURL(CodeLocations.codeLocationFromPath("some Path")), not(containsString("%20")));
        assertThat(CodeLocations.getPathFromURL(pathToURL("c:/a b c+++/")), endsWith("/c:/a b c+++"));
        assertThat(CodeLocations.getPathFromURL(pathToURL("/home/user/foo bar/+++/")), endsWith("/home/user/foo bar/+++"));
        assertThat(CodeLocations.getPathFromURL(CodeLocations.codeLocationFromURL("http://www.example.com/stories/")), equalTo("http://www.example.com/stories/"));
        assertThat(CodeLocations.getPathFromURL(CodeLocations.codeLocationFromPath("äöü")), endsWith("/äöü"));
    }

    private URL pathToURL(final String path) throws MalformedURLException {
        return new File(path).toURI().toURL();
    }

}
