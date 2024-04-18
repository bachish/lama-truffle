// CheckStyle: start generated
package com.truffle.lama.nodes.variables;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.NeverDefault;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.truffle.lama.nodes.LamaNode;

/**
 * Debug Info: <pre>
 *   Specialization {@link WriteLocal#writeBoolean}
 *     Activation probability: 0.48333
 *     With/without class size: 9/0 bytes
 *   Specialization {@link WriteLocal#writeInt}
 *     Activation probability: 0.33333
 *     With/without class size: 8/0 bytes
 *   Specialization {@link WriteLocal#writeGeneric}
 *     Activation probability: 0.18333
 *     With/without class size: 6/0 bytes
 * </pre>
 */
@GeneratedBy(WriteLocal.class)
@SuppressWarnings("javadoc")
public final class WriteLocalNodeGen extends WriteLocal {

    private final int slot;
    @Child private LamaNode value_;
    /**
     * State Info: <pre>
     *   0: SpecializationActive {@link WriteLocal#writeBoolean}
     *   1: SpecializationActive {@link WriteLocal#writeInt}
     *   2: SpecializationActive {@link WriteLocal#writeGeneric}
     * </pre>
     */
    @CompilationFinal private int state_0_;

    private WriteLocalNodeGen(LamaNode value, int slot) {
        this.slot = slot;
        this.value_ = value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object valueValue_ = this.value_.executeGeneric(frameValue);
        if (state_0 != 0 /* is SpecializationActive[WriteLocal.writeBoolean(VirtualFrame, boolean)] || SpecializationActive[WriteLocal.writeInt(VirtualFrame, int)] || SpecializationActive[WriteLocal.writeGeneric(VirtualFrame, Object)] */) {
            if ((state_0 & 0b1) != 0 /* is SpecializationActive[WriteLocal.writeBoolean(VirtualFrame, boolean)] */ && valueValue_ instanceof Boolean) {
                boolean valueValue__ = (boolean) valueValue_;
                return writeBoolean(frameValue, valueValue__);
            }
            if ((state_0 & 0b10) != 0 /* is SpecializationActive[WriteLocal.writeInt(VirtualFrame, int)] */ && valueValue_ instanceof Integer) {
                int valueValue__ = (int) valueValue_;
                return writeInt(frameValue, valueValue__);
            }
            if ((state_0 & 0b100) != 0 /* is SpecializationActive[WriteLocal.writeGeneric(VirtualFrame, Object)] */) {
                return writeGeneric(frameValue, valueValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue, valueValue_);
    }

    private Object executeAndSpecialize(VirtualFrame frameValue, Object valueValue) {
        int state_0 = this.state_0_;
        if (valueValue instanceof Boolean) {
            boolean valueValue_ = (boolean) valueValue;
            state_0 = state_0 | 0b1 /* add SpecializationActive[WriteLocal.writeBoolean(VirtualFrame, boolean)] */;
            this.state_0_ = state_0;
            return writeBoolean(frameValue, valueValue_);
        }
        if (valueValue instanceof Integer) {
            int valueValue_ = (int) valueValue;
            state_0 = state_0 | 0b10 /* add SpecializationActive[WriteLocal.writeInt(VirtualFrame, int)] */;
            this.state_0_ = state_0;
            return writeInt(frameValue, valueValue_);
        }
        state_0 = state_0 | 0b100 /* add SpecializationActive[WriteLocal.writeGeneric(VirtualFrame, Object)] */;
        this.state_0_ = state_0;
        return writeGeneric(frameValue, valueValue);
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if (state_0 == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if ((state_0 & (state_0 - 1)) == 0 /* is-single  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    @NeverDefault
    public static WriteLocal create(LamaNode value, int slot) {
        return new WriteLocalNodeGen(value, slot);
    }

}
