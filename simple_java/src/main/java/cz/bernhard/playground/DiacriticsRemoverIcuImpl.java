package cz.bernhard.playground;


public final class DiacriticsRemoverIcuImpl implements DiacriticsRemover {

    
    /**
     * @param text
     * @return text without diacritics
     */
    public String removeDiacritics(String text)
    {
        // \p{} regexp viz http://perldoc.perl.org/perluniprops.html
        return com.ibm.icu.text.Normalizer.decompose(text, false, 0).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    } 
    
}
