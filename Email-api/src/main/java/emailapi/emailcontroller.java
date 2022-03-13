package emailapi;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class emailcontroller {
	
	@Autowired
	emailservice service;

		
	@PostMapping("/simpleEmail")
	public String sendEmail(@RequestBody email es) {
		return service.sendSimpleEmail(es);
	
}
	
	@PostMapping("/attachmentEmail")
	public String sendEmailWithAttachment(@RequestBody email es) throws MessagingException {
		return service.emailWithAttachment(es);
}
}
