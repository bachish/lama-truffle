// CheckStyle: start generated
package com.truffle.lama.nodes.expression;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.NeverDefault;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

/**
 * Debug Info: <pre>
 *   Specialization {@link Infix#intOperation}
 *     Activation probability: 0.65000
 *     With/without class size: 11/0 bytes
 *   Specialization {@link Infix#boolOperation}
 *     Activation probability: 0.35000
 *     With/without class size: 8/0 bytes
 * </pre>
 */
@GeneratedBy(Infix.class)
@SuppressWarnings("javadoc")
public final class InfixNodeGen extends Infix {

    @Child private Expression left_;
    @Child private Expression operand_;
    @Child private Expression right_;
    /**
     * State Info: <pre>
     *   0: SpecializationActive {@link Infix#intOperation}
     *   1: SpecializationActive {@link Infix#boolOperation}
     * </pre>
     */
    @CompilationFinal private int state_0_;

    private InfixNodeGen(Expression left, Expression operand, Expression right) {
        this.left_ = left;
        this.operand_ = operand;
        this.right_ = right;
    }

    @Override
    public Object executeGeneric(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b10) == 0 /* only-active SpecializationActive[Infix.intOperation(int, String, int)] */ && (state_0 != 0  /* is-not SpecializationActive[Infix.intOperation(int, String, int)] && SpecializationActive[Infix.boolOperation(boolean, String, boolean)] */)) {
            return executeGeneric_int_int0(state_0, frameValue);
        } else if ((state_0 & 0b1) == 0 /* only-active SpecializationActive[Infix.boolOperation(boolean, String, boolean)] */ && (state_0 != 0  /* is-not SpecializationActive[Infix.intOperation(int, String, int)] && SpecializationActive[Infix.boolOperation(boolean, String, boolean)] */)) {
            return executeGeneric_boolean_boolean1(state_0, frameValue);
        } else {
            return executeGeneric_generic2(state_0, frameValue);
        }
    }

    private Object executeGeneric_int_int0(int state_0__, VirtualFrame frameValue) {
        int state_0 = state_0__;
        int leftValue_;
        try {
            leftValue_ = this.left_.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            Object operandValue = this.operand_.executeGeneric(frameValue);
            Object rightValue = this.right_.executeGeneric(frameValue);
            return executeAndSpecialize(ex.getResult(), operandValue, rightValue);
        }
        Object operandValue_ = this.operand_.executeGeneric(frameValue);
        int rightValue_;
        try {
            rightValue_ = this.right_.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(leftValue_, operandValue_, ex.getResult());
        }
        assert (state_0 & 0b1) != 0 /* is SpecializationActive[Infix.intOperation(int, String, int)] */;
        if (operandValue_ instanceof String) {
            String operandValue__ = (String) operandValue_;
            return intOperation(leftValue_, operandValue__, rightValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftValue_, operandValue_, rightValue_);
    }

    private Object executeGeneric_boolean_boolean1(int state_0__, VirtualFrame frameValue) {
        int state_0 = state_0__;
        boolean leftValue_ = this.left_.executeBool(frameValue);
        Object operandValue_ = this.operand_.executeGeneric(frameValue);
        boolean rightValue_ = this.right_.executeBool(frameValue);
        assert (state_0 & 0b10) != 0 /* is SpecializationActive[Infix.boolOperation(boolean, String, boolean)] */;
        if (operandValue_ instanceof String) {
            String operandValue__ = (String) operandValue_;
            return boolOperation(leftValue_, operandValue__, rightValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftValue_, operandValue_, rightValue_);
    }

    private Object executeGeneric_generic2(int state_0__, VirtualFrame frameValue) {
        int state_0 = state_0__;
        Object leftValue_ = this.left_.executeGeneric(frameValue);
        Object operandValue_ = this.operand_.executeGeneric(frameValue);
        Object rightValue_ = this.right_.executeGeneric(frameValue);
        if (state_0 != 0 /* is SpecializationActive[Infix.intOperation(int, String, int)] || SpecializationActive[Infix.boolOperation(boolean, String, boolean)] */ && operandValue_ instanceof String) {
            String operandValue__ = (String) operandValue_;
            if ((state_0 & 0b1) != 0 /* is SpecializationActive[Infix.intOperation(int, String, int)] */ && leftValue_ instanceof Integer) {
                int leftValue__ = (int) leftValue_;
                if (rightValue_ instanceof Integer) {
                    int rightValue__ = (int) rightValue_;
                    return intOperation(leftValue__, operandValue__, rightValue__);
                }
            }
            if ((state_0 & 0b10) != 0 /* is SpecializationActive[Infix.boolOperation(boolean, String, boolean)] */ && leftValue_ instanceof Boolean) {
                boolean leftValue__ = (boolean) leftValue_;
                if (rightValue_ instanceof Boolean) {
                    boolean rightValue__ = (boolean) rightValue_;
                    return boolOperation(leftValue__, operandValue__, rightValue__);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftValue_, operandValue_, rightValue_);
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        int leftValue_;
        try {
            leftValue_ = this.left_.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            Object operandValue = this.operand_.executeGeneric(frameValue);
            Object rightValue = this.right_.executeGeneric(frameValue);
            return expectInteger(executeAndSpecialize(ex.getResult(), operandValue, rightValue));
        }
        Object operandValue_ = this.operand_.executeGeneric(frameValue);
        int rightValue_;
        try {
            rightValue_ = this.right_.executeInt(frameValue);
        } catch (UnexpectedResultException ex) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return expectInteger(executeAndSpecialize(leftValue_, operandValue_, ex.getResult()));
        }
        if ((state_0 & 0b1) != 0 /* is SpecializationActive[Infix.intOperation(int, String, int)] */ && operandValue_ instanceof String) {
            String operandValue__ = (String) operandValue_;
            return intOperation(leftValue_, operandValue__, rightValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return expectInteger(executeAndSpecialize(leftValue_, operandValue_, rightValue_));
    }

    @Override
    public String executeString(VirtualFrame frameValue) {
        throw CompilerDirectives.shouldNotReachHere("Delegation failed.");
    }

    @Override
    public boolean executeBool(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        boolean leftValue_ = this.left_.executeBool(frameValue);
        Object operandValue_ = this.operand_.executeGeneric(frameValue);
        boolean rightValue_ = this.right_.executeBool(frameValue);
        if ((state_0 & 0b10) != 0 /* is SpecializationActive[Infix.boolOperation(boolean, String, boolean)] */ && operandValue_ instanceof String) {
            String operandValue__ = (String) operandValue_;
            return boolOperation(leftValue_, operandValue__, rightValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return (boolean) executeAndSpecialize(leftValue_, operandValue_, rightValue_);
    }

    private Object executeAndSpecialize(Object leftValue, Object operandValue, Object rightValue) {
        int state_0 = this.state_0_;
        if (operandValue instanceof String) {
            String operandValue_ = (String) operandValue;
            if (leftValue instanceof Integer) {
                int leftValue_ = (int) leftValue;
                if (rightValue instanceof Integer) {
                    int rightValue_ = (int) rightValue;
                    state_0 = state_0 | 0b1 /* add SpecializationActive[Infix.intOperation(int, String, int)] */;
                    this.state_0_ = state_0;
                    return intOperation(leftValue_, operandValue_, rightValue_);
                }
            }
            if (leftValue instanceof Boolean) {
                boolean leftValue_ = (boolean) leftValue;
                if (rightValue instanceof Boolean) {
                    boolean rightValue_ = (boolean) rightValue;
                    state_0 = state_0 | 0b10 /* add SpecializationActive[Infix.boolOperation(boolean, String, boolean)] */;
                    this.state_0_ = state_0;
                    return boolOperation(leftValue_, operandValue_, rightValue_);
                }
            }
        }
        throw new UnsupportedSpecializationException(this, new Node[] {this.left_, this.operand_, this.right_}, leftValue, operandValue, rightValue);
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if (state_0 == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if ((state_0 & (state_0 - 1)) == 0 /* is-single  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    private static int expectInteger(Object value) throws UnexpectedResultException {
        if (value instanceof Integer) {
            return (int) value;
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnexpectedResultException(value);
    }

    @NeverDefault
    public static Infix create(Expression left, Expression operand, Expression right) {
        return new InfixNodeGen(left, operand, right);
    }

}
