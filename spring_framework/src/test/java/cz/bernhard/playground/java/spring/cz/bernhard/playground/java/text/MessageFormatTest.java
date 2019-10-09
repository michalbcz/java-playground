package cz.bernhard.playground.java.spring.cz.bernhard.playground.java.text;


import static org.junit.Assert.assertEquals;

import java.text.MessageFormat;

import org.junit.Test;

public class MessageFormatTest {

    @Test
    public void singleQuoteResultInEmptyString() {
        MessageFormat mf = new MessageFormat("'");
        assertEquals("", mf.format(null));
    }

    @Test
    public void toGetSingleQuoteYouHaveToDoubleIt() {
        MessageFormat mf = new MessageFormat("''");
        assertEquals("'", mf.format(null));
    }

    @Test
    public void quotedString() {
        MessageFormat mf = new MessageFormat("'{0}'");
        assertEquals("{0}", mf.format(new Object[]{ "test" }));
    }

    @Test
    public void replacement() {
        MessageFormat mf = new MessageFormat("{0} {1}");
        assertEquals("first second", mf.format(new Object[]{ "first", "second" }));
    }

}
