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
 *   Specialization {@link VariableDefinition#assignVariable(Object, StringLiteral)}
 *     Activation probability: 0.65000
 *     With/without class size: 11/0 bytes
 *   Specialization {@link VariableDefinition#assignVariable(Object, String)}
 *     Activation probability: 0.35000
 *     With/without class size: 8/0 bytes
 * </pre>
 */
@GeneratedBy(VariableDefinition.class)
@SuppressWarnings("javadoc")
public final class VariableDefinitionNodeGen extends VariableDefinition {

    @Child private Expression initializerExpr_;
    @Child private StringLiteral name_;
    /**
     * State Info: <pre>
     *   0: SpecializationActive {@link VariableDefinition#assignVariable(Object, StringLiteral)}
     *   1: SpecializationActive {@link VariableDefinition#assignVariable(Object, String)}
     * </pre>
     */
    @CompilationFinal private int state_0_;

    private VariableDefinitionNodeGen(Expression initializerExpr, StringLiteral name) {
        this.initializerExpr_ = initializerExpr;
        this.name_ = name;
    }

    @Override
    public Object executeGeneric(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object initializerExprValue_ = this.initializerExpr_.executeGeneric(frameValue);
        Object nameValue_ = this.name_.executeGeneric(frameValue);
        if (state_0 != 0 /* is SpecializationActive[VariableDefinition.assignVariable(Object, StringLiteral)] || SpecializationActive[VariableDefinition.assignVariable(Object, String)] */) {
            if ((state_0 & 0b1) != 0 /* is SpecializationActive[VariableDefinition.assignVariable(Object, StringLiteral)] */ && nameValue_ instanceof StringLiteral) {
                StringLiteral nameValue__ = (StringLiteral) nameValue_;
                return assignVariable(initializerExprValue_, nameValue__);
            }
            if ((state_0 & 0b10) != 0 /* is SpecializationActive[VariableDefinition.assignVariable(Object, String)] */ && nameValue_ instanceof String) {
                String nameValue__ = (String) nameValue_;
                return assignVariable(initializerExprValue_, nameValue__);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(initializerExprValue_, nameValue_);
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

    private Object executeAndSpecialize(Object initializerExprValue, Object nameValue) {
        int state_0 = this.state_0_;
        if (nameValue instanceof StringLiteral) {
            StringLiteral nameValue_ = (StringLiteral) nameValue;
            state_0 = state_0 | 0b1 /* add SpecializationActive[VariableDefinition.assignVariable(Object, StringLiteral)] */;
            this.state_0_ = state_0;
            return assignVariable(initializerExprValue, nameValue_);
        }
        if (nameValue instanceof String) {
            String nameValue_ = (String) nameValue;
            state_0 = state_0 | 0b10 /* add SpecializationActive[VariableDefinition.assignVariable(Object, String)] */;
            this.state_0_ = state_0;
            return assignVariable(initializerExprValue, nameValue_);
        }
        throw new UnsupportedSpecializationException(this, new Node[] {this.initializerExpr_, this.name_}, initializerExprValue, nameValue);
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
    public static VariableDefinition create(Expression initializerExpr, StringLiteral name) {
        return new VariableDefinitionNodeGen(initializerExpr, name);
    }

}
