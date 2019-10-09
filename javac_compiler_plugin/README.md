# About
Simple javac compiler plugin. javac compiler plugin was introduced in Java8

Created following tutorial on https://www.baeldung.com/java-build-compiler-plugin
Some more tutorial-like information are on:
  * http://blog.harmonysoft.tech/2017/10/how-to-write-javac-plugin.html?view=classic
  * API https://docs.oracle.com/javase/8/docs/jdk/api/javac/tree/com/sun/source/util/Plugin.html
  * OpenJDK's [The Hitchhiker's Guide to javac](https://openjdk.java.net/groups/compiler/doc/hhgtjavac/index.html)

# How to run it? 
Steps:

1. compile plugins code (output will be in target/classes) 
  
  ```
   mvn build
   ```
2. run compilation of example java class with 2 plugins enabled.
   
   ```
   javac -Xplugin:bernhard_simple_plugin -Xplugin:MyLessSimplePlugin -cp ./target/classes ./src/main/java/Main.java
   ```
   
   *This run your 2 plugins compiled in step 1 and compile Main.java again with this javac plugin enabled. Note that on  1.8.0_211
    there is compilation error, when i tried openjdk version "12.0.2" 2019-07-16 it works fine.*

