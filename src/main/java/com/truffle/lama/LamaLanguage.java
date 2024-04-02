package com.truffle.lama;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.TruffleLanguage;
import com.truffle.lama.grammar.gen.LamaLexer;
import com.truffle.lama.grammar.gen.LamaParser;
import com.truffle.lama.nodes.LamaNode;
import com.truffle.lama.nodes.LamaRootNode;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public final class LamaLanguage extends TruffleLanguage<LamaContext> {

    @Override
    protected LamaContext createContext(Env env) {
        return new LamaContext();
    }

    @Override
    protected CallTarget parse(ParsingRequest request) throws Exception {
        var sourceCode = CharStreams.fromReader(request.getSource().getReader());
        var compilationUnit = parse(sourceCode);
        var root = new LamaRootNode(compilationUnit);
        return root.getCallTarget();
    }

    public static LamaNode parse(CharStream sourceCode) {
        var lexer = new LamaLexer(sourceCode);

        var tokens = new CommonTokenStream(lexer);
        tokens.fill();

        var parser = new LamaParser(tokens);

        parser.removeErrorListeners();
        parser.setErrorHandler(new BailErrorStrategy());

        var compUnit = parser.compilationUnit();

        var visitor = new LamaVisitor();
        return visitor.visitCompilationUnit(compUnit);
    }

    public static LamaNode parse(String sourceCode) {
        return parse(CharStreams.fromString(sourceCode));
    }

}