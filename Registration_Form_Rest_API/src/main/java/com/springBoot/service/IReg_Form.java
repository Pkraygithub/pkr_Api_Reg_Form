package com.springBoot.service;

import java.util.List;

import com.springBoot.model.Reg_FormModel;

public interface IReg_Form {
	
	Integer saveRegForm(Reg_FormModel regf);
	
	void updateRegForm(Reg_FormModel id);
	
	void deleteRegFormById(Integer id);
	
	Reg_FormModel getRegFormOneById(Integer id);
	
	List<Reg_FormModel> getRegFormAllById();

	boolean isRegModelExist(Integer id);

}
