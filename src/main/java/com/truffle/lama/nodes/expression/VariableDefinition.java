package com.truffle.lama.nodes.expression;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;

/**
 *
 */
@NodeChild(value = "initializerExpr")
@NodeChild(value = "name", type = StringLiteral.class)
public abstract class VariableDefinition extends Expression {

    @Specialization
    protected Object assignVariable(Object value, StringLiteral variableName) {
        this.getContext().vars.updateVariable(variableName.executeString(null), value);
        return value;
    }

    @Specialization
    protected Object assignVariable(Object value, String variableName) {
        this.getContext().vars.updateVariable(variableName, value);
        return value;
    }
}
