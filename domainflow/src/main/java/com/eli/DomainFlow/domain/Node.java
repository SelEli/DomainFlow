package com.eli.domainflow.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomainNode {

    private Map<String, Object> attributes = new HashMap<>();
    private List<DomainNode> children = new ArrayList<>();

    public DomainNode() {
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public List<DomainNode> getChildren() {
        return children;
    }

    public void setChildren(List<DomainNode> children) {
        this.children = children;
    }

    public String getName() {
        Object name = attributes.get("name");
        return name != null ? name.toString() : null;
    }
}
