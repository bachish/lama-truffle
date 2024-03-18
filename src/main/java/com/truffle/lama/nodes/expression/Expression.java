package com.truffle.lama.nodes.expression;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.truffle.lama.nodes.LamaNode;

public abstract class Expression extends LamaNode {

    public abstract int executeInt(VirtualFrame frame) throws UnexpectedResultException;

    public abstract String executeString(VirtualFrame frame);

    public abstract boolean executeBool(VirtualFrame frame);
}
