package com.eli.domainflow.infrastructure;

import com.eli.domainflow.domain.DomainNode;

import java.util.List;

public interface DomainRepository {

    String save(DomainNode root);

    DomainNode find(String id);

    List<String> list();

    void delete(String id);
}
