package com.truffle.lama.nodes.expression;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;

import java.util.Map;
import java.util.function.IntBinaryOperator;

@NodeChild("left")
@NodeChild("operand")
@NodeChild("right")
public abstract class Infix extends Expression {

    private final Map<String, IntBinaryOperator> integerOperations = Map.of(
            "+", Integer::sum,
            "-", (a, b) -> a - b,
            "multiply", (a, b) -> a * b,
            "divide", (a, b) -> a / b
    );

    @Specialization
    protected int intOperation(int leftValue, String operandView, int rightValue) {
        IntBinaryOperator op = integerOperations.getOrDefault(operandView, null);
//        if (op == null) {
//            throw new Exception("Unsupported int operation " + operandView);
//        }
        return op.applyAsInt(leftValue, rightValue);
    }
//    @SuppressWarnings("FieldMayBeFinal")
//    @Child
//    private Expression left, right, operator;
//
//    public Infix(Expression left, Expression right, Expression operator) {
//        this.left = left;
//        this.right = right;
//        this.operator = operator;
//    }
//
//
//    @Override
//    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
//        return super.executeGeneric(frame);
//    }
//
//    @Override
//    public int executeInt(VirtualFrame frame) throws LamaInterpreterException, UnexpectedResultException {
//        int leftVal = left.executeInt(frame);
//        int rightVal = right.executeInt(frame);
//        String opView = operator.executeString(frame);
//        IntBinaryOperator op = integerOperations.getOrDefault(opView, null);
//        if (op == null) {
//            throw new UnexpectedResultException("Unsupported int operation " + opView);
//        }
//        return op.applyAsInt(leftVal, rightVal);
//    }
//
//    @Override
//    public boolean executeBool(VirtualFrame frame) throws UnexpectedResultException {
//        return super.executeBool(frame);
//    }
}
