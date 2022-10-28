package com.brilworks.demo.DTO;

public class UserDTO {

	private Integer id ;

	private String name ;

	public UserDTO(){
		super();
	}

	public Integer getId(){
		return this.id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

}