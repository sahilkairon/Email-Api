package emailapi;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class emailservice {

	
	@Autowired
	private JavaMailSender javamailsender;
	
	
	
	public ResponseEntity<String> sendSimpleEmail(email e) {
		try {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("springboot020@gmail.com");
		message.setTo(e.getToEmail());
		message.setText(e.getBody());
		message.setSubject(e.getSubject());
		
		javamailsender.send(message);
		return new ResponseEntity<String>("Email Sent Successfully", HttpStatus.OK);
		}catch(Exception ek) {
			ek.printStackTrace();
			return new ResponseEntity<String>("error encountered while sending the email", HttpStatus.BAD_REQUEST);
			
			
		}
		
	}
	
	public ResponseEntity<String> emailWithAttachment(email e) throws MessagingException {
		
		try {
		MimeMessage mimemessage = javamailsender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(mimemessage, true);
		
		helper.setFrom("springboot020@gmail.com");
		helper.setTo(e.getToEmail());
		helper.setText(e.getBody());
		helper.setSubject(e.getSubject());
		
		FileSystemResource file = new FileSystemResource(new File(e.getAttachment()));
		
		helper.addAttachment(file.getFilename(), file);
		javamailsender.send(mimemessage);
		return new ResponseEntity<String>("Email Sent Successfully", HttpStatus.OK);
		}catch(Exception ek) {
			ek.printStackTrace();
			return new ResponseEntity<String>("error encountered while sending the email", HttpStatus.BAD_REQUEST);
		}
				
		
	}
	
	
}
