/**
 * copyright © 2019 Techpert It Solutions Private Limited
 */
package bahikhata.utilities.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Techpert:Bahikhata : 0.0.1 :This class is used
 * 
 * @author Rudhra Koul
 * @since 11 Oct 2020
 * @version 1.0
 */
@RestController
public class BahikhataUtilitiesCommonController {

	/**
	 * 
	 */
	public BahikhataUtilitiesCommonController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping(value = "/error", produces = { MediaType.TEXT_HTML_VALUE })

	public ResponseEntity<String> error() {
		return new ResponseEntity<String>(
				"<html><body><h1>Bahikhata Error Page</h1><p>An Internal Server error has occured.</p><div>GENERAL</div></body></html>",
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
