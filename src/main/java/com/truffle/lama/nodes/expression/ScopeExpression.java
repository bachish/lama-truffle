package com.truffle.lama.nodes.expression;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.truffle.lama.nodes.LamaNode;

import java.util.Arrays;
import java.util.List;


public class ScopeExpression extends LamaNode {
    @Children
    DefinitionSequence[] defs;

    public ScopeExpression(List<DefinitionSequence> defs, Expression expressions) {
        this.defs = defs.toArray(new DefinitionSequence[0]);
        this.expressions = expressions;
    }

    @Child
    Expression expressions;

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        Arrays.stream(defs).forEach(it -> it.executeGeneric(frame));
        return expressions.executeGeneric(frame);
    }
}
