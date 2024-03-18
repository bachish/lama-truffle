package com.truffle.lama.nodes.expression;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;

/**
 * Constant literal for a primitive {@code int} value. The unboxed value can be returned when the
 * parent expects a int value and calls {@link DecimalLiteral#executeInt}.
 * In the generic case, the value is automatically boxed by Java.
 */
@NodeInfo(shortName = "const int")
public class DecimalLiteral extends Expression {
    private final int value;

    public DecimalLiteral(int value) {
        this.value = value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }

    @Override
    public int executeInt(VirtualFrame frame) {
        return value;
    }

    @Override
    public String executeString(VirtualFrame frame) {
        return null;
    }

    @Override
    public boolean executeBool(VirtualFrame frame) {
        return false;
    }
}
