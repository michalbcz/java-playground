package cz.bernhard.playground.cv;

import lombok.Data;

import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

@Data
public class Skill {

	public static final String JAVASCRIPT = "Javascript";
	public static final String JAVA = "Java";
	public static final String GROOVY = "Groovy";
	
	private final String name;
	private final Level level;
	private final Period timeOfExperience;	

	private Skill(String skillName, Level skillLevel, Period timeOfExperience) {
		this.name = skillName;
		this.level = skillLevel;
		this.timeOfExperience = timeOfExperience;
	}

	public static Skill of(String skillName, Level skillLevel, Period timeOfExperience) {
		return new Skill(skillName, skillLevel, timeOfExperience);
	}
	

	/**
	 * Defaults time of experience (see of(skillName, skillLevel, timeOfExperience)) to zero.
	 * Its when there is no significant experience (eg. when you are beginner or you work
	 * with it only occasionally when its needed)...
	 * 
	 * @param skillName
	 * @param skillLevel
	 * @return
	 */
	public static Skill of(String skillName, Level skillLevel) {
		return of(skillName, skillLevel, Period.ZERO);
	}
	
	@Override
	public String toString() {
		return name + " on " + level + " level with " + formatPeriod(timeOfExperience);
	}

	private String formatPeriod(Period period) {
		
		PeriodFormatterBuilder builder = 
			new PeriodFormatterBuilder()
					.appendYears().appendSuffix(" year", " years").appendSeparator(" and ")
					.appendMonths().appendSuffix(" month", " months")
					.appendLiteral(" of experiences ");
											
		PeriodFormatter periodFormatter = builder.toFormatter();
		
		String periodFormatted = 
					Period.ZERO.equals(period) ? 
							"no significant experiences" : periodFormatter.print(timeOfExperience);
		
		return periodFormatted;
	}
	
	
}
