package cz.bernhard.javacpluginsample;

import com.sun.source.util.JavacTask;
import com.sun.source.util.Plugin;
import com.sun.tools.javac.api.BasicJavacTask;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Log;

public class SimpleJavacPlugin implements Plugin {

    @Override
    public String getName() {
        /* this name is used in javac -Xplugin:<getName()> */
        /* name cannot contain spaces */
        return "bernhard_simple_plugin";
    }

    @Override
    public void init(JavacTask javacTask, String... strings) {
        System.out.println("sysout from SimpleJavacPlugin#init method"); // you will see this as output of javac
        Context context = ((BasicJavacTask) javacTask).getContext();
        Log.instance(context).printRawLines(Log.WriterKind.NOTICE, "Ahoy from " + getName()); // you will see this as output of javac
    }

}
