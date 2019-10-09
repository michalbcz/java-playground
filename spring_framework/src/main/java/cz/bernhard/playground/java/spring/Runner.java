package cz.bernhard.playground.java.spring;

import cz.bernhard.playground.java.spring.logger.Logger;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;


public class Runner implements IRunner {

    private IBean1 bean1;

    @Logger private Log log;

    @Override
    public void run() {
        log.info(bean1.hello("world"));
    }

    @Autowired
    @Override
    public void setBean1(IBean1 bean1) {
        this.bean1 = bean1;
    }
}
