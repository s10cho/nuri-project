package com.nuri.flowchart.domain.node;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class FlowNode<K> {

    private Map<K, FlowNode> flowNodeMap;

    private Supplier<K> supplier;

    public FlowNode(Supplier<K> supplier) {
        this.flowNodeMap = new HashMap<K, FlowNode>();
        this.supplier = supplier;
    }

    public FlowNode next(K k, FlowNode flowNode) {
        flowNodeMap.put(k, flowNode);
        return this;
    }

    public void execute() {
        Optional.ofNullable(supplier)
            .map(Supplier::get)
            .map(flowNodeMap::get)
            .ifPresent(FlowNode::execute);
    }
}
