package com.truffle.lama.nodes.expression;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;

/**
 * Constant literal for a primitive {@code int} value. The unboxed value can be returned when the
 * parent expects a int value and calls {@link StringLiteral#executeInt}.
 * In the generic case, the value is automatically boxed by Java.
 */
@NodeInfo(shortName = "const string")
public class StringLiteral extends Expression {
    private final String value;

    public StringLiteral(String value) {
        this.value = value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }

    @Override
    public int executeInt(VirtualFrame frame) {
        return 1;
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
