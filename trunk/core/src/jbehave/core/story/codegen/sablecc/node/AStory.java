/* This file was generated by SableCC (http://www.sablecc.org/). */

package jbehave.core.story.codegen.sablecc.node;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import jbehave.core.story.codegen.sablecc.analysis.Analysis;

public final class AStory extends PStory
{
    private PTitle _title_;
    private PRole _role_;
    private PFeature _feature_;
    private PBenefit _benefit_;
    private final LinkedList _scenario_ = new TypedLinkedList(new Scenario_Cast());

    public AStory()
    {
    }

    public AStory(
        PTitle _title_,
        PRole _role_,
        PFeature _feature_,
        PBenefit _benefit_,
        List _scenario_)
    {
        setTitle(_title_);

        setRole(_role_);

        setFeature(_feature_);

        setBenefit(_benefit_);

        {
            this._scenario_.clear();
            this._scenario_.addAll(_scenario_);
        }

    }
    public Object clone()
    {
        return new AStory(
            (PTitle) cloneNode(_title_),
            (PRole) cloneNode(_role_),
            (PFeature) cloneNode(_feature_),
            (PBenefit) cloneNode(_benefit_),
            cloneList(_scenario_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAStory(this);
    }

    public PTitle getTitle()
    {
        return _title_;
    }

    public void setTitle(PTitle node)
    {
        if(_title_ != null)
        {
            _title_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _title_ = node;
    }

    public PRole getRole()
    {
        return _role_;
    }

    public void setRole(PRole node)
    {
        if(_role_ != null)
        {
            _role_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _role_ = node;
    }

    public PFeature getFeature()
    {
        return _feature_;
    }

    public void setFeature(PFeature node)
    {
        if(_feature_ != null)
        {
            _feature_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _feature_ = node;
    }

    public PBenefit getBenefit()
    {
        return _benefit_;
    }

    public void setBenefit(PBenefit node)
    {
        if(_benefit_ != null)
        {
            _benefit_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _benefit_ = node;
    }

    public LinkedList getScenario()
    {
        return _scenario_;
    }

    public void setScenario(List list)
    {
        _scenario_.clear();
        _scenario_.addAll(list);
    }

    public String toString()
    {
        return ""
            + toString(_title_)
            + toString(_role_)
            + toString(_feature_)
            + toString(_benefit_)
            + toString(_scenario_);
    }

    void removeChild(Node child)
    {
        if(_title_ == child)
        {
            _title_ = null;
            return;
        }

        if(_role_ == child)
        {
            _role_ = null;
            return;
        }

        if(_feature_ == child)
        {
            _feature_ = null;
            return;
        }

        if(_benefit_ == child)
        {
            _benefit_ = null;
            return;
        }

        if(_scenario_.remove(child))
        {
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_title_ == oldChild)
        {
            setTitle((PTitle) newChild);
            return;
        }

        if(_role_ == oldChild)
        {
            setRole((PRole) newChild);
            return;
        }

        if(_feature_ == oldChild)
        {
            setFeature((PFeature) newChild);
            return;
        }

        if(_benefit_ == oldChild)
        {
            setBenefit((PBenefit) newChild);
            return;
        }

        for(ListIterator i = _scenario_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set(newChild);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

    }

    private class Scenario_Cast implements Cast
    {
        public Object cast(Object o)
        {
            PScenario node = (PScenario) o;

            if((node.parent() != null) &&
                (node.parent() != AStory.this))
            {
                node.parent().removeChild(node);
            }

            if((node.parent() == null) ||
                (node.parent() != AStory.this))
            {
                node.parent(AStory.this);
            }

            return node;
        }
    }
}
