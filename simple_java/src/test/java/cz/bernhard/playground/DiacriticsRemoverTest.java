package cz.bernhard.playground;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import cz.bernhard.playground.DiacriticsRemover;
import org.junit.Test;

public abstract class DiacriticsRemoverTest {

    @Test
    public void shouldRemoveDiacritis() {
        assertThat(getDiacriticsRemover().removeDiacritics("žlutoučký"), is("zlutoucky"));
    }

    protected abstract DiacriticsRemover getDiacriticsRemover();
    
}
