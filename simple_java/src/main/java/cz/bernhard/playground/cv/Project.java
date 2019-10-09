package cz.bernhard.playground.cv;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Project {
	
	private static final DateFormat DATE_FORMATTER_INSTANCE = new SimpleDateFormat("dd.MM.yyyy");
	
	private String companyName;
	private Date from;
	private Date to = new Date(); /* NOW AS DEFAULT */
	private String companyWorkedFor;
	private final String projectName;
	private String[] technologies;
	private String responsibilities;
	
	public Project(String projectName) {
		this.projectName = projectName;
	}

	public Project inTheNameOf(String companyWorkedFor) {
		this.companyWorkedFor = companyWorkedFor;
		return this;
	}

	public Project forCompany(String companyName) {
		this.companyName = companyName;
		return this;
	}

	public Project inTechnologies(String... technologies) {
		this.technologies = technologies;
		return this;
	}

	public Project startedAt(String from) {
		try {
			this.from = DATE_FORMATTER_INSTANCE.parse(from);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return this;
	}

	public Project andEndedAt(String to) {
		try {
			this.to = DATE_FORMATTER_INSTANCE.parse(to);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return this;
	}

	public Project withResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
		return this;
	}
	


}
