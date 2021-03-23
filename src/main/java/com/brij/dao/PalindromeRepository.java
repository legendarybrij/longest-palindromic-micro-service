package com.brij.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.brij.model.Palindrome;



public interface PalindromeRepository extends JpaRepository<Palindrome,Integer> {
	
	Palindrome findById(int id);
	int deleteByLongestWord(String word);

}
