package com.truffle.lama;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.TruffleLanguage;

public final class LamaLanguage extends TruffleLanguage<LamaContext> {

    @Override
    protected LamaContext createContext(Env env) {
        return new LamaContext();
    }

    @Override
    protected CallTarget parse(ParsingRequest request) throws Exception {
        return super.parse(request);
    }

}