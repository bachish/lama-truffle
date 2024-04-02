package com.truffle.lama.nodes.expression;

import com.oracle.truffle.api.dsl.NodeChild;

@NodeChild(value = "basicExpression", type = Expression.class)
@NodeChild(value = "expression", type = Expression.class)
public abstract class MainExpression extends Expression {
}
