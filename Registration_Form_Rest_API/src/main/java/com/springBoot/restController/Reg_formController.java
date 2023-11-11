package com.springBoot.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.Exception.Reg_NoIsNotFound;
import com.springBoot.model.Reg_FormModel;
import com.springBoot.service.IReg_Form;

@RestController
@RequestMapping("/Reg")
public class Reg_formController {

	
	@Autowired
	private IReg_Form service;

	
	
	@PostMapping("/home")
	public ResponseEntity<String> saveRegForm(@RequestBody Reg_FormModel formModel) {

		Integer id = service.saveRegForm(formModel);

		return ResponseEntity.ok(formModel.getSname()+" Registration id " + id + " is Successfully Registered.");

	}
	
	@GetMapping("/showall")
	public ResponseEntity<List<Reg_FormModel>> showAllRecords(@RequestBody Reg_FormModel formMods){
		
		List<Reg_FormModel> showallrecords=service.getRegFormAllById();
		
		return ResponseEntity.ok(showallrecords);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Reg_FormModel> showOneById(@PathVariable Integer id){
		
		Reg_FormModel reo=service.getRegFormOneById(id);
		
		return ResponseEntity.ok(reo);
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteRecords(@PathVariable Integer id){
		
		service.deleteRegFormById(id);

		
		return ResponseEntity.ok(id +" is Deleted Successfully");
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateRegForm(@PathVariable Integer id, @RequestBody Reg_FormModel ids){
		
		
		  if(service.isRegModelExist(id)) { 
			  ids.setSid(id); 
			  service.updateRegForm(ids);
		  
		  return ResponseEntity.ok(" Id "+id+" is Updated Sucessfully."); 
		  }else { 
			  throw new Reg_NoIsNotFound(" Id "+id+" is no Found in Database.");
		  
		  }		
	}
	
	

}
