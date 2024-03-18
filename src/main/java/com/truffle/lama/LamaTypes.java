package com.truffle.lama;

import com.oracle.truffle.api.dsl.TypeSystem;
import com.truffle.lama.types.Function;

// Lists out all our types, order matters.
// Graal will go down the list in order and return the first datatype that succeeds.
@TypeSystem({boolean.class, Function.class})
public class LamaTypes {

}
