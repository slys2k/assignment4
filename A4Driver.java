package assignment4;

import java.util.ArrayList;
import java.util.Iterator;

/** This class represents a Driver class that will find word ladders between a
  * given pair of words if possible. It will first process a file containing a
  * given dictionary of valid words, and then compare input word pairs against
  * the dictionary in an attempt to find word ladders. The resulting word
  * ladders will be output to the console. Any errors or failures will be
  * presented on the console.
  *
  * @author K. Cyr, J. Ngo, S. Cooney, K. Subramanian
  */
public class A4Driver
{
/*########################REMOVE AFTER COMPLETING CODE##########################
 # main() algorithm:                     #   calls to class:                   #
 ###############################################################################
 # Process the Dictionary File           #   File I/O in Dictionary            #
 # Loop:                                 #                                     #
 #    Get a Word Pair                    #   File I/O in A4Driver              #
 #    Check if Words are Valid           #   Dictionary                        #
 #       Invalid Throws Exception        #   A4Driver                          #
 #    Try to Find a Word Ladder          #   recursionMethod() in A4Driver     #
 #                                       #      creates solutionList Objects   #
 #                                       #      until it completes a ladder    #
 #       No Solution Throws Exception    #   A4Driver                          #
 #    Report the Word Ladder to Console  #   A4Driver                          #
 #########################REMOVE AFTER COMPLETING CODE########################*/
   // Data Fields

   // Constants

   // Constructors

   // Modifier Methods

   // Access Methods

   // Other Methods

   /** This is the main method.
     */
   public static void main(String[] args) {
      Dictionary dict = new Dictionary();
      ArrayList<String> solList = new ArrayList<String>();
      String word = "bakes";
      if (args.length != 1) 
      {
         System.err.println ("Error: Incorrect number of command line arguments");
         System.exit(-1);
      }
      dict.createDict(args[0]);     // SHOULD THIS BE args[1]???????? check w/ pdf
      boolean valid = dict.search(word);
      if(valid){
         solList = dict.searchOneLetter(word, 0);
      }
      solList = dict.searchOneLetter(word, 1);
      solList = dict.searchOneLetter(word, 2);
      solList = dict.searchOneLetter(word, 3);
      solList = dict.searchOneLetter(word, 4);	// isn't this overwriting solList each time until here?
      int x = 0;
   }
   
   public static Integer MakeLadder(String fromWord,
                                    String toWord,
                                    Integer position)
   {
      Dictionary dict = new Dictionary();
      ArrayList<String> sol	= new ArrayList<String>(); // for ladder
      ArrayList<String> temp	= new ArrayList<String>(); // for candidates
      ArrayList<String> tempList	= new ArrayList<String>(); // for candidates (prepended)
      Integer i = 0;
      Integer prepend = 0;
      Integer recurse = 0;
      
      sol.add(fromWord);   // add starting word to solution list (to be displayed)
      
      if(fromWord.equals(toWord)){
         System.out.print(toWord);  // optimistic base case
         return 1;
      }
      
      prepend = dict.difLetters(fromWord, toWord);
      if(prepend.equals(1)){        // second base case
         System.out.print(fromWord);   // word differs by just one letter
         System.out.print(toWord);  // ex: dears -> fears
         return 1;
      }
      
      for(i = 0; i<5; i++){      // search dictionary 5 times (1 time for each letter position)
         temp.addAll(dict.searchOneLetter(fromWord, i)); // and add all candidates to temp List (to be recursed)
      }
      Iterator<String> t = temp.iterator();
      while(t.hasNext()){        // prepend the candidate words (moving them all to a new list)
         String nextWord = t.next();
         prepend = dict.difLetters(nextWord, toWord); // number of differing letters
         tempList.add("(" + prepend + ")" + nextWord);   // add number to front of candidate word
      }
      
      t = tempList.iterator();   // recurse through candidates
      while(t.hasNext()){
         String nextWord = t.next();
         recurse = MakeLadder(nextWord, toWord, 0);   // recurse nextWord
         if(recurse.equals(1)){     // if ladder is finished
            System.out.print(sol);  // display word ladder
            return 1;            // THE WORD LADDER IS GOING TO BE PRINTED OUT OF ORDER. NEED TO FIX THIS
         }
      }
      
      return 0;
   }

}
