package cz.bernhard.playground.java.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/META-INF/application-context-root.xml");
        IRunner runner = ctx.getBean("runner", IRunner.class);
        runner.run();
    }
}
