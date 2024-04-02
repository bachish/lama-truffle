package com.truffle.lama.nodes.expression;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.truffle.lama.nodes.LamaNode;

public class VariableDefinitionItem extends LamaNode {
    @Child
    StringLiteral name;
    @Child
    Expression valueExpr;

    Object value;

    public VariableDefinitionItem(StringLiteral name, Expression value) {
        this.name = name;
        this.valueExpr = value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        value = valueExpr.executeGeneric(frame);
        return null;
    }
}
