package com.nuri.flowchart.domain.node;

import org.junit.jupiter.api.Test;

class NodeTest {

    @Test
    void sampleFlow() {
        Node node1 = Node.of("node1", () -> true);
        Node node2 = Node.of("node2", () -> false);
        Node node3 = Node.of("node3", () -> true);
        Node node4 = Node.of("node4", () -> false);
        Node node5 = Node.of("node5", () -> true);
        Node node6 = Node.of("node6", () -> true);
        Node node7 = Node.of("node7", () -> true);

        node1.next(true, node2).next(false, node3);
        node2.next(true, node3).next(false, node4);
        node3.next(true, node4).next(false, node5);
        node4.next(node5);
        node5.next(node6);
        node6.next(node7);

        node1.execute();

    }
}