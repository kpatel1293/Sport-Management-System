package edu.depaul.cdm.se.sportmanagementsystem.controler;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.cdm.se.sportmanagementsystem.DTO.ManagerDTO;
import edu.depaul.cdm.se.sportmanagementsystem.service.ManagersService;



@RestController
@RequestMapping("/managers")
public class ManagersControler {
	
	@Autowired ManagersService iManagersService;

	// @GetMapping use for find by ID
	// @PostMapping use for add new or update (player or manager)
	// @DeleteMapping use for delete (player or manager)
	
	//@RequestBody /for saving 
	 // @RequestParam
//	@PathVariable
	
	 @GetMapping
	 public ResponseEntity<List<ManagerDTO>> findAll() {
		return new ResponseEntity<>(ManagerDTO.listEntityToDTOWithRelation(iManagersService.findAll()),  HttpStatus.OK);
	}


}
