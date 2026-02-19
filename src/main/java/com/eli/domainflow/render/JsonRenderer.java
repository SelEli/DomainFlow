package com.eli.domainflow.render;

import com.eli.domainflow.domain.DomainGraph;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonRenderer implements Renderer {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String render(DomainGraph graph) {
        try {
            return mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(graph.getRoot());
        } catch (Exception e) {
            throw new RuntimeException("Failed to render JSON", e);
        }
    }
}
