package com.truffle.lama.nodes.expression;


import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;

//call variable by name,  evaluate to this value
@NodeChild(value = "name", type = StringLiteral.class)
public abstract class Lident extends Expression {
    @Specialization
    protected Object getVariable(String variableName) {
        return this.getContext().vars.getVariable(variableName);
    }

}
