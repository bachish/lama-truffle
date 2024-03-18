package com.truffle.lama.nodes.expression;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

/**
 * Constant literal for a primitive {@code boolean} value. The unboxed value can be returned when the
 * parent expects a int value and calls {@link BooleanLiteral#executeBool}.
 * In the generic case, the value is automatically boxed by Java.
 */
@NodeInfo(shortName = "const int")
public class BooleanLiteral extends Expression {
    private final boolean value;

    public BooleanLiteral(boolean value) {
        this.value = value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }

    @Override
    public int executeInt(VirtualFrame frame) throws UnexpectedResultException {
        throw new UnexpectedResultException("Excepted int, but was boolean");
    }

    @Override
    public String executeString(VirtualFrame frame) {
        return String.valueOf(value);
    }

    @Override
    public boolean executeBool(VirtualFrame frame) {
        return value;
    }
}
