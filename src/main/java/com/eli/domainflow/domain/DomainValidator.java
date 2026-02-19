package com.eli.domainflow.domain;

public class DomainValidator {

    public void validate(DomainNode root) {
        if (root == null) {
            throw new IllegalArgumentException("Root node cannot be null.");
        }

        if (root.getName() == null) {
            throw new IllegalArgumentException("Each node must contain a 'name' attribute.");
        }

        for (DomainNode child : root.getChildren()) {
            validate(child);
        }
    }
}
