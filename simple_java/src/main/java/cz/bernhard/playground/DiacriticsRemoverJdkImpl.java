package cz.bernhard.playground;

import java.text.Normalizer;

public class DiacriticsRemoverJdkImpl implements DiacriticsRemover {

    @Override
    public String removeDiacritics(String text) {
        String normalizedText = Normalizer.normalize(text, Normalizer.Form.NFD);
        normalizedText = normalizedText.replaceAll("[^\\p{ASCII}]", "");

        return normalizedText;
    }

}
