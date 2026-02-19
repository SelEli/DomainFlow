package com.eli.domainflow.domain;

public class DomainCompiler {

    private final DomainValidator validator = new DomainValidator();

    public DomainGraph compile(DomainNode root) {
        validator.validate(root);
        return new DomainGraph(root);
    }
}
