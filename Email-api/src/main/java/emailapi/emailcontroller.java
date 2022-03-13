package emailapi;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class emailcontroller {
	
	@Autowired
	emailservice service;

		
	@PostMapping("/simpleEmail")
	public ResponseEntity<String> sendEmail(@RequestBody email es) {
		return service.sendSimpleEmail(es);
	
}
	
	@PostMapping("/attachmentEmail")
	public ResponseEntity<String> sendEmailWithAttachment(@RequestBody email es){
		return service.emailWithAttachment(es);
}
}
