package com.truffle.lama.nodes.expression;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;

import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

@NodeChild("left")
@NodeChild("operand")
@NodeChild("right")
public abstract class Infix extends Expression {

    private final Map<String, IntBinaryOperator> integerOperations = Map.of(
            "+", Integer::sum,
            "-", (a, b) -> a - b,
            "*", (a, b) -> a * b,
            "/", (a, b) -> a / b,
            "%", (a, b) -> a % b,
            ":=", (a, b) -> {
                assignment(a, b);
                return 0;
            }

    );

    private final Map<String, BinaryOperator<Boolean>> logicalOperations = Map.of(
            "!!", (a, b) -> a || b,
            "&", (a, b) -> a && b,
            "!", (a, b) -> a != b,
            "^", (a, b) -> a ^ b,
            ":=", (a, b) -> {
                assignment(a, b);
                return false;
            }
    );

    @Specialization
    protected int intOperation(int leftValue, String operandView, int rightValue) {
        IntBinaryOperator op = integerOperations.getOrDefault(operandView, null);
        return op.applyAsInt(leftValue, rightValue);
    }

    @Specialization
    protected boolean boolOperation(boolean leftValue, String operandView, boolean rightValue) {
        var op = logicalOperations.getOrDefault(operandView, null);
        return op.apply(leftValue, rightValue);
    }


    protected void assignment(Object leftValue, Object rightValue) {
        String varName = leftValue.toString();
        this.getContext().vars.updateVariable(varName, rightValue);
    }

}