package com.truffle.lama;

import com.truffle.lama.nodes.LamaNode;
import com.truffle.lama.nodes.scopes.GlobalContext;

public class LamaContext {
    public final GlobalContext vars = new GlobalContext();
    //???
    private static final LamaLanguage.ContextReference<LamaContext> REF =
            LamaLanguage.ContextReference.create(LamaLanguage.class);

    public static LamaContext get(LamaNode node) {
        return REF.get(node);
    }
}
