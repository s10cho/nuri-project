package com.nuri.flowchart.domain.node;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FlowLine<R> {
    private Map<R, Node> toMap;

    private Node to;

    public FlowLine() {
        this.toMap = new HashMap<>();
    }

    public void to(Node node) {
        to = node;
    }
    public void to(R r, Node node) {
        toMap.put(r, node);
    }

    public Node getNextNode(R r) {
        return Objects.nonNull(to)
            ? to
            : toMap.get(r);
    }
}
