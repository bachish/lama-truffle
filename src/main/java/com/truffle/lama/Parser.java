package com.truffle.lama;

import com.truffle.lama.grammar.LamaParser;
import org.antlr.v4.runtime.TokenStream;

public class Parser extends LamaParser {
    public Parser(TokenStream input) {
        super(input);
    }

}
