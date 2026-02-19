package com.eli.domainflow.api;

import com.eli.domainflow.domain.DomainNode;
import com.eli.domainflow.infrastructure.DomainRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/domains")
public class DomainController {

    private final DomainRepository repository;

    public DomainController(DomainRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public String create(@RequestBody DomainNode root) {
        return repository.save(root);
    }

    @GetMapping
    public List<String> list() {
        return repository.list();
    }

    @GetMapping("/{id}")
    public DomainNode get(@PathVariable String id) {
        return repository.find(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repository.delete(id);
    }
}
