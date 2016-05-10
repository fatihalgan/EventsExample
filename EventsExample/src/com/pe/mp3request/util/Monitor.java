package com.pe.mp3request.util; 

/**
 * A monitor so that classes can block and unblock 
 * each other
 */
public class Monitor {
   /**
    * Block indefinately until a notify is reached
    */
   public synchronized void block(){
      try {
         wait();
      } catch (InterruptedException ie) {
         ie.printStackTrace();
      }
   }

   /**
    * Block with a maximum block time of millis
    * @param millis is a long indicating the maximum amount of time to
    * block, 0 indicates indefinately.
    */
   public synchronized void block(long millis){
      try {
         wait(millis);
      } catch (InterruptedException ie) {
         ie.printStackTrace();
      }
   }

   /**
    * Unblock the next in line from the block
    */
   public synchronized void unblock(){
      notify();
   }

   /**
    * Unblock all processes that are blocked
    */
   public synchronized void unblockAll(){
      notifyAll();
   }

}
