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
 *   Specialization {@link Lident#getVariable}
 *     Activation probability: 1.00000
 *     With/without class size: 16/0 bytes
 * </pre>
 */
@GeneratedBy(Lident.class)
@SuppressWarnings("javadoc")
public final class LidentNodeGen extends Lident {

    @Child private StringLiteral name_;
    /**
     * State Info: <pre>
     *   0: SpecializationActive {@link Lident#getVariable}
     * </pre>
     */
    @CompilationFinal private int state_0_;

    private LidentNodeGen(StringLiteral name) {
        this.name_ = name;
    }

    @Override
    public Object executeGeneric(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object nameValue_ = this.name_.executeGeneric(frameValue);
        if (state_0 != 0 /* is SpecializationActive[Lident.getVariable(String)] */ && nameValue_ instanceof String) {
            String nameValue__ = (String) nameValue_;
            return getVariable(nameValue__);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(nameValue_);
    }

    @Override
    public int executeInt(VirtualFrame frameValue) throws UnexpectedResultException {
        return expectInteger(executeGeneric(frameValue));
    }

    @Override
    public String executeString(VirtualFrame frameValue) {
        return (String) executeGeneric(frameValue);
    }

    @Override
    public boolean executeBool(VirtualFrame frameValue) {
        return (boolean) executeGeneric(frameValue);
    }

    private Object executeAndSpecialize(Object nameValue) {
        int state_0 = this.state_0_;
        if (nameValue instanceof String) {
            String nameValue_ = (String) nameValue;
            state_0 = state_0 | 0b1 /* add SpecializationActive[Lident.getVariable(String)] */;
            this.state_0_ = state_0;
            return getVariable(nameValue_);
        }
        throw new UnsupportedSpecializationException(this, new Node[] {this.name_}, nameValue);
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if (state_0 == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            return NodeCost.MONOMORPHIC;
        }
    }

    private static int expectInteger(Object value) throws UnexpectedResultException {
        if (value instanceof Integer) {
            return (int) value;
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnexpectedResultException(value);
    }

    @NeverDefault
    public static Lident create(StringLiteral name) {
        return new LidentNodeGen(name);
    }

}
