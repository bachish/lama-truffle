package com.truffle.lama.nodes;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

public class CompilationUnitNode extends RootNode {
    @SuppressWarnings("FieldMayBeFinal")
    @Child
    private LamaNode scopes;

    public CompilationUnitNode(LamaNode expr) {
        super(null);
        scopes = expr;
    }
    protected CompilationUnitNode(TruffleLanguage<?> language) {
        super(language);
    }

    protected CompilationUnitNode(TruffleLanguage<?> language, FrameDescriptor frameDescriptor) {
        super(language, frameDescriptor);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return scopes.executeGeneric(frame);
    }
}
