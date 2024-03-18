# Implementation of Lama language on Graal Truffle

Usefully references:

* Simple Language
*
    * graalvm.org/graalvm-as-a-platform/implement-language
*
    * https://github.com/graalvm/simplelanguage
* Mumbler
*
    * http://cesquivias.github.io
*
    * https://github.com/cesquivias/mumbler

* https://chrisseaton.com/truffleruby/tenthings/
* https://www.endoflineblog.com/graal-truffle-tutorial-part-0-what-is-truffle

Nodes of recursive interpreter from Lama [??] are used.

The syntax is described using ANTLR in language/src/main/java/com/oracle/truffle/sl/parser/SimpleLanguage.g4

Native C functions rewritten in Java

## Truffle 

Truffle is a Java library that helps you to write an abstract syntax tree (AST) interpreter for a language. The Truffle framework allows you to run programming languages efficiently on GraalVM 

To build and run project use java-21-graalvm. Simple way for arch -- set this jmv as default

Install `jdk21-graalvm-bin`

See al VM on machine `archlinux-java status`  

Choose graalvm `sudo archlinux-java set java-21-graalvm`
