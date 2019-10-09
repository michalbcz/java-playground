import org.junit.Assert;
import org.junit.Test;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;

public class MainTest {

    @Test
    public void compilationWithOurPluginsShouldSucceedAndOuputExpectedText() throws IOException {
        /* GIVEN */
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ByteArrayOutputStream err = new ByteArrayOutputStream();

        /* we need absolute path Main.java file with java source code  */
        InputStream mainJavaFile = this.getClass().getClassLoader().getResourceAsStream("Main.java");
        File file = new File(System.getProperty("java.io.tmpdir"), "Main.java");
        FileWriter fileWriter = new FileWriter(file);
        ByteArrayInputStream bios = new ByteArrayInputStream(new byte[256]);
        fileWriter.write(new String(bios.readAllBytes(), "UTF-8"));

        /* WHEN */
        int compilationStatusCode = compiler.run(mainJavaFile, output, err, new String[]{"-verbose", "-Xplugin:AnotherSimpleJavacPlugin", "-Xplugin:bernhard_simple_plugin", file.getAbsolutePath()});

        /* have to output it otherwise we wouldn't see output on test runner console */
        String outputText = new String(err.toByteArray(), "UTF-8");
        System.out.println(output);
        System.out.println(err);

        /* THEN */
        Assert.assertTrue("should compile without any error", compilationStatusCode == 0);

        /* for some reason all outputs are in error output stream */
        /* only text outputted through com.sun.tools.javac.util.Log is in error output stream (sysout can be viewed in test console ouput but are not in stream */

        Assert.assertTrue("output doesn't contain what is expected", outputText.contains("Ahoy from bernhard_simple_plugin"));

    }


}
