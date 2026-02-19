package com.eli.domainflow.render;

import com.eli.domainflow.domain.DomainGraph;
import com.eli.domainflow.domain.DomainNode;

public class SvgRenderer implements Renderer {

    private static final int X_STEP = 200;
    private static final int Y_STEP = 80;

    @Override
    public String render(DomainGraph graph) {
        StringBuilder sb = new StringBuilder();
        sb.append("<svg xmlns='http://www.w3.org/2000/svg'>");
        renderNode(graph.getRoot(), 20, 40, sb);
        sb.append("</svg>");
        return sb.toString();
    }

    private void renderNode(DomainNode node, int x, int y, StringBuilder sb) {
        sb.append("<rect x='").append(x).append("' y='").append(y)
                .append("' width='150' height='40' fill='lightgray' stroke='black'/>");

        sb.append("<text x='").append(x + 10).append("' y='").append(y + 25)
                .append("' font-size='14'>")
                .append(node.getName())
                .append("</text>");

        int childY = y + Y_STEP;
        int childX = x;

        for (DomainNode child : node.getChildren()) {
            sb.append("<line x1='").append(x + 75).append("' y1='").append(y + 40)
                    .append("' x2='").append(childX + 75).append("' y2='").append(childY)
                    .append("' stroke='black'/>");

            renderNode(child, childX, childY, sb);
            childX += X_STEP;
        }
    }
}
