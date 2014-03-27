package assignment4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/** This class represents a Dictionary. 
  * The purpose of this class is to create a word list from an input file to be
  * used as a reference. This list must be searchable in a number of different
  * ways as determined by its class methods.
  *
  * @author K. Cyr, J. Ngo, S. Cooney, K. Subramanian
  */
public class Dictionary 
{
   // Data Fields

   /** The name of the input file. 
     */
   String file;

   /** The word list generated from the input file. 
     */
   ArrayList<String> dictionary;

   // Constants

   /** There are currently no constants in the Dictionary class.
     */

   // Constructors

   /** Construct a new Dictionary object.
     */
   Dictionary()
   {
      dictionary = new ArrayList<String>();
   }

   // Modifier Methods

   /** Processes the dictionary file into a word list.
     * @param inFile The name of the dictionary file being processed.
     */
   public void createDict(String inFile)
   {
      try 
      {
         FileReader freader = new FileReader(inFile);
         BufferedReader reader = new BufferedReader(freader);
         
         for (String s = reader.readLine(); s != null; s = reader.readLine()) 
         {
            if(!s.substring(0,1).equals("*"))
            {
               dictionary.add(s.substring(0,5));
            }
         }
         reader.close();
      } 
      catch (FileNotFoundException e) 
      {
         System.err.println ("Error: File not found. Exiting...");
         e.printStackTrace();
         System.exit(-1);
      } 
      catch (IOException e) 
      {
         System.err.println ("Error: IO exception. Exiting...");
         e.printStackTrace();
         System.exit(-1);
      }
   }

   // Access Methods

   /** None. The word list is not currently able to be modified outside of the
     * the words provided in the word list processed from the input file.
     */

   // Other Methods

   /** Searches the Dictionary word list for the word provided to determine if
     * the word is valid.
     * @param word The word that needs to be verified.
     * @return Returns true if the word matches a ditionary entry.
     */
   public boolean search(String word)
   {
      boolean valid = false;
      if(dictionary.contains(word))
      {
         valid = true;
      }
      return valid;
   }

   /** Searches for all words from the dictionary that vary from word by the
     * letter at a given index.
     * @param word Base word to start from.
     * @param index The index of the character that is allowed to vary during
     *    this search.
     * @return Returns a a list of all the possibble one-off words from the
     *    dictionary.
     */
   public ArrayList<String> searchOneLetter(String word, int index)
   {
      ArrayList<String> solList = new ArrayList<String>();
      for(String s: dictionary)
      {
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
         if(!letter.equals(testLetter) && originalWord.equals(testWord))
         {
            solList.add(s);
         }
      }
      return solList;
   }
}
