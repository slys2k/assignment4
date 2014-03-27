package assignment4;

import java.util.ArrayList;
import java.util.Iterator;

/** This class represents a possible solution list  used by a recursive method. 
  * The purpose of this class is to maintain a progressive list until the
  * recursion either finds a solution or determines that no solution is possible.
  *
  * @author K. Cyr, J. Ngo, S. Cooney, K. Subramanian
  */
public class SolutionList
{
   // Data Fields

   /** The actual solution list. 
     */
   private ArrayList<String> wordLadder;

   /** Flag gets set when the ladder is a complete solution. 
     */
   private boolean complete;

   // Constants

   // Constructors

   /** Construct a solutionList with an empty ladder marked incomplete.
     */
   public SolutionList()
   {
      complete = false;
   }

   // Modifier Methods

   /** Sets the complete flag.
     * @param state The completion status of the word ladder 
     */
   public void setSecondDataField(boolean state)
   {
      complete = state;
   }

   // Access Methods

   /** Gets the current completion status of the word ladder.
     * @return The completion flag.
     */
   public boolean getComplete() { return complete; }

   /** Gets the solutionList
     * @return The entire solution list.
     */
   public ArrayList<String> getWordLadder() { return wordLadder; }

   // Other Methods
   
}