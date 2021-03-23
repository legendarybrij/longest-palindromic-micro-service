package com.brij.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "palindrome")
public class Palindrome {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String longestWord;
	

	
	public Palindrome() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Palindrome(String longestWord) {
		super();
		this.longestWord = longestWord;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	public String getLongestWord() {
		return longestWord;
	}



	public void setLongestWord(String longestWord) {
		this.longestWord = longestWord;
	}
	
	
	
	
	
	
	

}
