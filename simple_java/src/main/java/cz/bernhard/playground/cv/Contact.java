package cz.bernhard.playground.cv;

import org.apache.commons.lang.builder.StandardToStringStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Contact {

	private String email;
	private String blogUrl;
	private String twitterUrl;
	private String githubUrl;

		
	public Contact blog(String blogUrl) {
		this.blogUrl = blogUrl;
		return this;		
	}
	
	public Contact email(String email) {
		this.email = email;
		return this;		
	}

	public Contact twitter(String twitterUrl) {
		this.twitterUrl = twitterUrl;
		return this;
	}

	public Contact github(String githubUrl) {
		this.githubUrl = githubUrl;
		return this;
	}
	
	@Override
	public String toString() {
		ToStringBuilder tsb = new ToStringBuilder(this, toStringStyle());
		
		/* 
		 * I am not using chaining because of maintenance is more easier.
		 * Eg. When I want to rearrange order of fields I just move the
		 * appropriate line up or down and no other editing is needed.
		 * With chaining (tsb.append("email").append("icq")
		 * you would have to cut, paste and create/delete dots to change
		 * order of appending texts... It's just easier ALT + UP/DOWN (eclipse ide) 
		 * to move lines...
		 **/
		tsb.append("Email", email);
		tsb.append("Twitter", twitterUrl);
		tsb.append("Github", githubUrl);
		tsb.append("Blog", blogUrl);
						
		return tsb.toString();
	}


	private ToStringStyle toStringStyle() {
		StandardToStringStyle toStringStyle = new StandardToStringStyle();
		toStringStyle.setFieldSeparator("\n");
		toStringStyle.setFieldNameValueSeparator(": ");
		toStringStyle.setContentStart("");
		toStringStyle.setContentEnd("");
		toStringStyle.setUseClassName(false);
		toStringStyle.setUseIdentityHashCode(false);
		return toStringStyle;
	}
}