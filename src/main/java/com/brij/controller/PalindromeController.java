package com.brij.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brij.dao.PalindromeRepository;
import com.brij.model.Palindrome;
import com.brij.model.TestPalindrome;

@CrossOrigin(origins = "*")
@RestController
public class PalindromeController {

	@Autowired
	PalindromeRepository repo;

	@PostMapping(path = "/findPalindromeFromString/{palindrome}")
	public String createPalindrome(@PathVariable("palindrome") String input) {

		// Method that converts long string to longest palindrome string
		// String s = "hello you are rotor rotor rotor redivider redivider redivider
		// redivider madam refer refer refer refer refer refer refer madam madam madam
		// madam madam madam madam";
		String lowerCase = input.toLowerCase();
		Stream<String> wordStream = Arrays.asList(lowerCase.split(" ")).stream();

		List<String> palindrome = wordStream.filter(TestPalindrome::isPalindrome) // find all palindromes
				.collect(Collectors.toList());
		

		Set<String> unique = new HashSet<String>();
		palindrome.stream().forEach(x -> unique.add(x));

		//for testing purposes
		System.out.println(unique); //this is output on console unique palindromes that it finds  from the input we get from postman
		
		List<Integer> lengthPalin = new ArrayList<Integer>();
		unique.stream().forEach(x -> lengthPalin.add(x.length()));

		Integer max = Collections.max(lengthPalin);
		List<String> result = unique.stream().filter(x -> x.length() == max).collect(Collectors.toList());
		for (int i = 0; i < result.size(); i++) {
			Palindrome newPalindrome = new Palindrome(result.get(i));
			repo.save(newPalindrome);
		}
		// System.out.println(input);

		return "Created";

	}

	@GetMapping(path = "/findAllPalindromes")
	public List<Palindrome> findAllPalindromes() {
		return repo.findAll();

	}

	@GetMapping(path = "/binary/{input}")
	public int BinaryReversal(@PathVariable("input") String str) {

		Integer input = Integer.parseInt(str);
		String binaryString = Integer.toBinaryString(input);
		while (binaryString.length() < 8) { // pad with 16 0's
			binaryString = "0" + binaryString;
		}
		String reverseBinary = invert(binaryString);
		Integer result = Integer.parseInt(reverseBinary, 2);

		return result;

	}

	private static String invert(String word) {
		String input = word;
		String output = "";

		StringBuilder input1 = new StringBuilder();

		// append a string into StringBuilder input1
		input1.append(input);

		// reverse StringBuilder input1
		input1.reverse();
		output = input1.toString();

		return output;
	}

}
