package com.truffle.lama.nodes.expression;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.truffle.lama.nodes.LamaNode;

import java.util.Arrays;
import java.util.List;

public class DefinitionSequence extends LamaNode {
    @Children
    VariableDefinitionItem[] children;

    public DefinitionSequence(List<VariableDefinitionItem> childList) {
        children = childList.toArray(new VariableDefinitionItem[0]);
    }


    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return Arrays.stream(children)
                .map(it -> it.executeGeneric(frame))
                .toList().getLast();
    }

}
