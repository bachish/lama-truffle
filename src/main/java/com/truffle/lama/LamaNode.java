package com.truffle.lama;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeInfo;

//this info will be used at debug
@NodeInfo(language = "Lama Language", description = "The abstract base node for all expressions")
public abstract class LamaNode extends Node {
    public Object eval(LamaContext ctx){
        return null;
    }

    public boolean executeBoolean(VirtualFrame virtualFrame){
        return  LamaTypesGen.LAMATYPES.e

    }
}
