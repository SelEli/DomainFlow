package com.eli.domainflow.domain;

public class DomainGraph {

    private final DomainNode root;

    public DomainGraph(DomainNode root) {
        this.root = root;
    }

    public DomainNode getRoot() {
        return root;
    }
}
