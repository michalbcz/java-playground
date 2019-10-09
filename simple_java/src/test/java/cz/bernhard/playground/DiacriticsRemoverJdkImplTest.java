package cz.bernhard.playground;
import cz.bernhard.playground.DiacriticsRemover;
import cz.bernhard.playground.DiacriticsRemoverIcuImpl;

public class DiacriticsRemoverJdkImplTest extends DiacriticsRemoverTest {

    @Override
    protected DiacriticsRemover getDiacriticsRemover() {
        return new DiacriticsRemoverIcuImpl();
    }

}
