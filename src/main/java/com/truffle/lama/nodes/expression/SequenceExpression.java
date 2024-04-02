package com.truffle.lama.nodes.expression;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

import java.util.Arrays;
import java.util.List;

public class SequenceExpression extends Expression {
    @Children
    Expression[] children;

    public SequenceExpression(List<Expression> childList) {
        children = childList.toArray(new Expression[0]);
    }


    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return Arrays.stream(children)
                .map(it -> it.executeGeneric(frame))
                .toList().getLast();
    }

    @Override
    public int executeInt(VirtualFrame frame) throws UnexpectedResultException {
        return (int) Arrays.stream(children)
                .map(it -> it.executeGeneric(frame))
                .toList().getLast();
    }

    @Override
    public String executeString(VirtualFrame frame) {
        return Arrays.stream(children)
                .map(it -> it.executeGeneric(frame))
                .toList().getLast().toString();
    }

    @Override
    public boolean executeBool(VirtualFrame frame) {
        return (boolean) Arrays.stream(children)
                .map(it -> it.executeGeneric(frame))
                .toList().getLast();
    }
}
