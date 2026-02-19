package com.eli.domainflow.render;

import com.eli.domainflow.domain.DomainGraph;

public interface Renderer {
    String render(DomainGraph graph);
}
