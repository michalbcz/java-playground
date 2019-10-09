package cz.bernhard.playground.xml;

public class RecordElementIsNotValid extends RuntimeException {
	
	public RecordElementIsNotValid(String invalidElementDebugInfo) {
		super(invalidElementDebugInfo);
	}

}
