package assignment4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dictionary {
	String file;
	ArrayList<String> Dict;
	Dictionary(){
		Dict = new ArrayList<String>();
	}
	
	public void createDict(String infile){
		try 
		{
			FileReader freader = new FileReader(infile);
			BufferedReader reader = new BufferedReader(freader);
			
			for (String s = reader.readLine(); s != null; s = reader.readLine()) 
			{
				if(!s.substring(0,1).equals("*")){
					Dict.add(s.substring(0,5));
				}
			}
			reader.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println ("Error: File not found. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) 
		{
			System.err.println ("Error: IO exception. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public boolean search(String word){
		boolean valid = false;
		if(Dict.contains(word)){
			valid = true;
		}
		return valid;
	}
	
	// returns all words from the dictionary that vary from word by the letter at index
	public ArrayList<String> searchOneLetter(String word, int index){
		ArrayList<String> solList = new ArrayList<String>();
		for(String s: Dict){
			// split up word that you are looking for
			String letter = word.substring(index, index+1);
			String beforeLetter = word.substring(0, index);
			String afterLetter = word.substring(index+1,word.length());
			// split up the test word
			String testLetter = s.substring(index, index+1);
			String testBeforeLetter = s.substring(0, index);
			String testAfterLetter = s.substring(index+1,word.length());
			
			String originalWord = beforeLetter + afterLetter;
			String testWord = testBeforeLetter + testAfterLetter;
			if(!letter.equals(testLetter) && originalWord.equals(testWord)){
				solList.add(s);
			}
		}
		return solList;
	}
	
}
