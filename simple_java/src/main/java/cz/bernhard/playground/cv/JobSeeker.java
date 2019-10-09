package cz.bernhard.playground.cv;

import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.joda.time.Period;

import com.google.common.collect.Sets;


public class JobSeeker {

	private static final Money CODING_FOR_BEER = Money.czk(45000); 

	private String firstName;
	private String lastname;
	private Contact contact;
	private Money requestedSalary;
	private Set<Skill> skills = Sets.newHashSet();
	private Set<Project> projects = Sets.newHashSet();

	private void requestedSalary(Money salary) {
		this.requestedSalary = salary;		
	}

	private void skills(Skill... skills) {
		this.skills = Sets.newHashSet(skills);		
	}

	private Contact contact() {
		if (contact == null) {
			contact = new Contact();
		}
		
		return contact;
	}
	
	private static Project project(String projectName) {
		return new Project(projectName);
	}


	private JobSeeker firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	/**
	 * @param lastname
	 * @return
	 */
	private JobSeeker lastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	
	private JobSeeker projects(Project... projects) {
		this.projects = Sets.newHashSet(projects);
		return this;
	}
	
	@Override
	public String toString() {
		return firstName + " " + lastname + " would like " + requestedSalary + " per month " + 
			   "for: \n" + StringUtils.join(skills, "\n") + "\n" + 
			   "If you are interested, here is a contact:\n" + contact.toString();
	}
	
	public static void main(String[] args) {
		
		JobSeeker mb = new JobSeeker();
		
		mb.firstName("Michal").lastname("Bernhard");		
		mb.contact().email("michal@bernhard.cz")
					.blog("mbernhard.blogspot.com")
					.twitter("http://twitter.com/#michalb_cz")
					.github("http://github.com/michalbcz");
		
		mb.skills(
			Skill.of(Skill.JAVA, Level.INTERMEDIATE, Period.years(4)),
			Skill.of(Skill.JAVASCRIPT, Level.BEGINNER),
			Skill.of(Skill.GROOVY, Level.BEGINNER)
		);
		
		mb.projects(
			project("AGOS Prognose - intranet web app for prognosis of failure rate of new vehicles")
				.inTheNameOf("Tigra, s.r.o.")
				.forCompany("Skoda Auto, a.s.")
				.inTechnologies("Java", "Apache Wicket", "Websphere", "Spring IoC")
				.startedAt("1.6.2007")
				.andEndedAt("1.8.2010")
				.withResponsibilities("developing"),
				
			project("SPL - eclispe rcp based desktop app for monitoring of quality of QA measurements"),
			
			project("Mojebanka.cz - internet banking platform of Komercni Banka, a.s."),
			
			project("Mojebanka.cz NEW VERSION")
		);
		
		mb.requestedSalary(CODING_FOR_BEER);
		
		System.out.println(mb);
	}

	
}
