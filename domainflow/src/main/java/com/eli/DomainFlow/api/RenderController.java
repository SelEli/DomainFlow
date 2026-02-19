package com.eli.domainflow.api;

import com.eli.domainflow.domain.DomainCompiler;
import com.eli.domainflow.domain.DomainNode;
import com.eli.domainflow.render.JsonRenderer;
import com.eli.domainflow.render.SvgRenderer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/render")
public class RenderController {

    private final DomainCompiler compiler = new DomainCompiler();
    private final JsonRenderer jsonRenderer = new JsonRenderer();
    private final SvgRenderer svgRenderer = new SvgRenderer();

    @PostMapping("/json")
    public String renderJson(@RequestBody DomainNode root) {
        return jsonRenderer.render(compiler.compile(root));
    }

    @PostMapping("/svg")
    public String renderSvg(@RequestBody DomainNode root) {
        return svgRenderer.render(compiler.compile(root));
    }
}
