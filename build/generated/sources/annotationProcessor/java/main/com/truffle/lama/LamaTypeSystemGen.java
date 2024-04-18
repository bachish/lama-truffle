// CheckStyle: start generated
package com.truffle.lama;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.truffle.lama.types.Function;

@GeneratedBy(LamaTypeSystem.class)
public final class LamaTypeSystemGen extends LamaTypeSystem {

    protected LamaTypeSystemGen() {
    }

    public static boolean isBoolean(Object value) {
        return value instanceof Boolean;
    }

    public static boolean asBoolean(Object value) {
        assert value instanceof Boolean : "LamaTypeSystemGen.asBoolean: boolean expected";
        return (boolean) value;
    }

    public static boolean expectBoolean(Object value) throws UnexpectedResultException {
        if (value instanceof Boolean) {
            return (boolean) value;
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnexpectedResultException(value);
    }

    public static boolean isFunction(Object value) {
        return value instanceof Function;
    }

    public static Function asFunction(Object value) {
        assert value instanceof Function : "LamaTypeSystemGen.asFunction: Function expected";
        return (Function) value;
    }

    public static Function expectFunction(Object value) throws UnexpectedResultException {
        if (value instanceof Function) {
            return (Function) value;
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnexpectedResultException(value);
    }

}
