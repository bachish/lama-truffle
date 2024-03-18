package com.truffle.lama.nodes.expression;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.truffle.lama.nodes.LamaNode;

public abstract class Expression extends LamaNode {
    @Override
    public abstract Object executeGeneric(VirtualFrame frame);

    public abstract int executeInt(VirtualFrame frame);

    public abstract String executeString(VirtualFrame frame);

    public abstract boolean executeBool(VirtualFrame frame);
}
