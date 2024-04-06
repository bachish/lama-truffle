package com.truffle.lama.nodes.expression;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.truffle.lama.nodes.LamaNode;

import java.util.Arrays;
import java.util.List;

public class DefinitionSequence extends LamaNode {
    @Children
    VariableDefinition[] children;

    public DefinitionSequence(List<VariableDefinition> childList) {
        children = childList.toArray(new VariableDefinition[0]);
    }


    @Override
    public Object executeGeneric(VirtualFrame frame) {
        var res = Arrays.stream(children)
                .map(it -> it.executeGeneric(frame))
                .toList();
        return res.getLast();
    }

}
