package com.truffle.lama;

import com.truffle.lama.grammar.gen.LamaBaseVisitor;
import com.truffle.lama.grammar.gen.LamaParser;
import com.truffle.lama.nodes.LamaNode;
import com.truffle.lama.nodes.expression.*;
import com.truffle.lama.nodes.variables.WriteLocalNodeGen;

public class LamaVisitor extends LamaBaseVisitor<LamaNode> {
    @Override
    public LamaNode visitScopeExpression(LamaParser.ScopeExpressionContext ctx) {
        var defs = ctx.definition().stream().map(it -> (DefinitionSequence) it.accept(this)).toList();
        return new ScopeExpression(defs, (SequenceExpression) ctx.seqExpression().accept(this));
    }

    @Override
    public LamaNode visitSeqExpression(LamaParser.SeqExpressionContext ctx) {
        return new SequenceExpression(ctx.children.stream()
                .map(it -> (Expression) it.accept(this)).toList());
    }

    @Override
    public LamaNode visitVariableDefinitionItem(LamaParser.VariableDefinitionItemContext ctx) {
        return VariableDefinitionNodeGen.create((Expression) ctx.binaryExpression().accept(this),
                new StringLiteral(ctx.LIDENT().getText()));
    }

    @Override
    public LamaNode visitBinaryOperation(LamaParser.BinaryOperationContext ctx) {
        Expression left = (Expression) ctx.left.accept(this);
        Expression right = (Expression) ctx.right.accept(this);
        String operandView = ctx.INFIX().getText();
        switch (operandView) {
            case ":=":
                return WriteLocalNodeGen.create(right, 0);
            default:
                return InfixNodeGen.create(left, new StringLiteral(operandView), right);
        }
    }

    @Override
    public LamaNode visitVariableDefinitions(LamaParser.VariableDefinitionsContext ctx) {
        return new DefinitionSequence(ctx.variableDefinitionItem().stream()
                .map(it -> (VariableDefinition) it.accept(this))
                .toList());

    }

    @Override
    public LamaNode visitLident(LamaParser.LidentContext ctx) {
        return LidentNodeGen.create(new StringLiteral(ctx.LIDENT().getText()));
    }

    @Override
    public LamaNode visitDecimal(LamaParser.DecimalContext ctx) {
        return new DecimalLiteral(Integer.parseInt(ctx.DECIMAL().getText()));
    }

    @Override
    public LamaNode visitTrue(LamaParser.TrueContext ctx) {
        return new BooleanLiteral(true);
    }

    @Override
    public LamaNode visitStr(LamaParser.StrContext ctx) {
        return new StringLiteral(ctx.getText().substring(1, ctx.getText().length() - 1));
    }

    @Override
    public LamaNode visitFalse(LamaParser.FalseContext ctx) {
        return new BooleanLiteral(false);
    }
}
