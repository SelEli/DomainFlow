package com.eli.domainflow.infrastructure;

import com.eli.domainflow.domain.DomainNode;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryDomainRepository implements DomainRepository {

    private final Map<String, DomainNode> store = new HashMap<>();

    @Override
    public String save(DomainNode root) {
        String id = UUID.randomUUID().toString();
        store.put(id, root);
        return id;
    }

    @Override
    public DomainNode find(String id) {
        return store.get(id);
    }

    @Override
    public List<String> list() {
        return new ArrayList<>(store.keySet());
    }

    @Override
    public void delete(String id) {
        store.remove(id);
    }
}
