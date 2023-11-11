package com.springBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.Exception.Reg_NoIsNotFound;
import com.springBoot.Repositery.Reg_FormRepositery;
import com.springBoot.model.Reg_FormModel;


@Service
public class Reg_FormServiceImpl  implements IReg_Form{
	
	@Autowired
	private Reg_FormRepositery repo;

	@Override
	public Integer saveRegForm(Reg_FormModel regf) {

		regf=repo.save(regf);
		return regf.getSid();
	}

	@Override
	public void updateRegForm(Reg_FormModel id) {

		repo.save(id);
	}

	@Override
	public void deleteRegFormById(Integer id) {

		repo.deleteById(id);
	}

	@Override
	public Reg_FormModel getRegFormOneById(Integer id) {

		Optional<Reg_FormModel> geto=repo.findById(id);
		if(geto.isPresent()) {
			return geto.get();
		}else {
			 throw new Reg_NoIsNotFound(" Id "+id+" is not Exist in Database.");
		}
		//return null;
	}

	@Override
	public List<Reg_FormModel> getRegFormAllById() {

		List<Reg_FormModel> reg=repo.findAll();
		
		return reg;
	}

	@Override
	public boolean isRegModelExist(Integer id) {
		
		return repo.existsById(id);
	}

	

}
