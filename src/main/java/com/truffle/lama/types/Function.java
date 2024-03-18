package com.truffle.lama.types;

import com.oracle.truffle.api.RootCallTarget;

public class Function {
    //RootCallTarget is a Truffle’s class that encapsulates a function
    public final RootCallTarget callTarget;

    public Function(RootCallTarget callTarget) {
        this.callTarget = callTarget;
    }
}
