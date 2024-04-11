package com.truffle.lama.nodes.variables;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.truffle.lama.nodes.LamaNode;

@NodeChild("value")
@NodeField(name = "slot", type = int.class)
public abstract class WriteLocal extends LamaNode {

    @Specialization
    protected boolean writeBoolean(VirtualFrame frame, boolean value) {
        frame.getFrameDescriptor().setSlotKind(getSlot(), FrameSlotKind.Boolean);
        frame.setBoolean(getSlot(), value);
        return value;
    }

    @Specialization
    protected int writeInt(VirtualFrame frame, int value) {
        frame.getFrameDescriptor().setSlotKind(getSlot(), FrameSlotKind.Int);
        frame.setInt(getSlot(), value);
        return value;
    }

    @Specialization
    protected Object writeGeneric(VirtualFrame frame, Object value) {
        frame.getFrameDescriptor().setSlotKind(getSlot(), FrameSlotKind.Object);
        frame.setObject(getSlot(), value);
        return value;
    }
}
