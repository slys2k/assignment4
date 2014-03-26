package assignment4;

/** A stopwatch accumulates time when it is running. You can 
  * repeatedly start and stop the stopwatch. You can use a
  * stopwatch to measure the running time of a program.
  *
  * Constructs a stopwatch that is in the stopped state and has no time 
  * accumulated.
  * 
  * Here is an example of how to use stopwatch to time a segment of your program
  * 
  * StopWatch timer = new StopWatch();
  * timer.start();
  * // the segment to be timed goes in here
  * timer.stop();
  * System.out.println("Elapsed time: " + timer.getElapsedTime() +
  *    " milliseconds");
  */

public class StopWatch
{
   // Data Fields

   /** The value of the time since the last reset. 
     */
   private long elapsedTime;

   /** The value used as the initial clock reading, in milliseconds. 
     */
   private long startTime;

   /** Acts as a flag to indicate that the stopwatch is currently running.
     */
   private boolean isRunning;

   // Constants

   /** There are currently no constants in the Stopwatch class.
     */

   // Constructors

   /** Utilizing the default, zero-parameter constructor.
     */

   // Modifier Methods

   /** None
     */

   // Access Methods

   /** None
     */

   // Other Methods

   /** Resets the stopwatch to zero milliseconds.
     */
   public StopWatch()
   {
      reset();
   }

   /** Starts the stopwatch. Time begins accumulating. Will not interfere with
     * an already running stopwatch.
     */
   public void start()
   {
      if (isRunning) { return; }

      isRunning = true;
      startTime = System.currentTimeMillis();
   }
   
   /** Stops the stopwatch. Time stops accumulating and is added to the elapsed
     * time.
     */
   public void stop()
   {
      if (!isRunning) { return; }

      isRunning = false;
      long endTime = System.currentTimeMillis();
      elapsedTime = elapsedTime + endTime - startTime;
   }
   
   /** Returns the total elapsed time.
     * @return the total elapsed time
   */
   public long getElapsedTime()
   {
      if (isRunning) 
      {
         long endTime = System.currentTimeMillis();
         return elapsedTime + endTime - startTime;
      }
      else
         return elapsedTime;
   }
   
   /** Stops the watch and resets the elapsed time to 0.
     */
   public void reset()
   {
      elapsedTime = 0;
      isRunning = false;
   }
}

