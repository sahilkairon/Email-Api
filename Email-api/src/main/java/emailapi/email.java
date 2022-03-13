package emailapi;

import org.springframework.stereotype.Component;

@Component
public class email {
	
	private String toEmail;
	private String body;
	private String subject;
	private String attachment;
	
	
	
	public email() {}
	
	
	
	public email(String toEmail, String body, String subject, String attachment) {
		super();
		this.toEmail = toEmail;
		this.body = body;
		this.subject = subject;
		this.attachment = attachment;
	}
	public email(String toEmail, String body, String subject) {
		super();
		this.toEmail = toEmail;
		this.body = body;
		this.subject = subject;
	}
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
	
	
}
