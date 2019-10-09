package cz.bernhard.javacpluginsample;

import com.sun.source.util.JavacTask;
import com.sun.source.util.Plugin;

public class AnotherSimpleJavacPlugin implements Plugin {

    @Override
    public String getName() {
        return "AnotherSimpleJavacPlugin";
    }

    @Override
    public void init(JavacTask javacTask, String... strings) {
        System.out.println("sysout from " + this.getClass().getSimpleName() + "#init method"); // you will see this as output of javac
    }
}
