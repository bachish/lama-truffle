package com.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.truffle.lama.LamaContext;

//this info will be used at debug
@NodeInfo(language = "Lama Language", description = "The abstract base node for all expressions")
public abstract class LamaNode extends Node {

    public abstract Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException;
}
