package com.truffle.lama.nodes.expression;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.truffle.lama.nodes.LamaNode;


public class ScopeExpression extends LamaNode {
    @Child
    Expression expressions;

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return expressions.executeGeneric(frame);
    }
}
