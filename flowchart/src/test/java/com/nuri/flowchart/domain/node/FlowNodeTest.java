package com.nuri.flowchart.domain.node;

import org.junit.jupiter.api.Test;

class FlowNodeTest {

    @Test
    void sampleFlow() {
        FlowNode<Boolean> node1 = newNode("node1", true);
        FlowNode<Boolean> node2 = newNode("node2", false);
        FlowNode<Boolean> node3 = newNode("node3", true);
        FlowNode<Boolean> node4 = newNode("node4", false);
        FlowNode<Boolean> node5 = newNode("node5", true);

        node1
            .next(true, node2)
            .next(false, node3);
        node2
            .next(true, node3)
            .next(false, node4);
        node3
            .next(true, node4)
            .next(false, node5);
        node4
            .next(true, node5);

        node1.execute();

    }

    private static <T> FlowNode<T> newNode(String message, T t) {
        return new FlowNode<>(() -> {
            System.out.println(message);
            return t;
        });
    }
}