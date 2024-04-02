package com.truffle.lama.nodes;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

public class LamaRootNode extends RootNode {
    @SuppressWarnings("FieldMayBeFinal")
    @Child
    private LamaNode compilationUnit;

    public LamaRootNode(LamaNode expr) {
        super(null);
        compilationUnit = expr;
    }

    protected LamaRootNode(TruffleLanguage<?> language) {
        super(language);
    }

    protected LamaRootNode(TruffleLanguage<?> language, FrameDescriptor frameDescriptor) {
        super(language, frameDescriptor);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return compilationUnit.executeGeneric(frame);
    }
}
