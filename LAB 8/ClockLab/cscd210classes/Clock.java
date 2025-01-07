//PKG STATEMENT
package cscd210classes;

/**
 * This class sets the time to times from main
 * Contains DVC & EVC
 */
public class Clock{

   // FIELDS
   private int hour;
   private int minute;
   private int second;

   
   // CONSTRUCTORS

   /**
    * Sets default time to 12:00:00
    */
   public Clock(){ // DVC

      this.hour = 12;
      this.minute = 0;
      this.second = 0;
   } // end DVC



   /**
    * This binds private ints to allow Main to read data
    * @param hour representing the hours passed
    * @param minute representing the minutes passed
    * @param second representing the seconds passed
    * @throws IllegalArgumentException throw if hr < 12 || min > 59 || sec > 59
    */
   public Clock(final int hour, final int minute, final int second) throws IllegalArgumentException{ // EVC
   
      this.hour = hour;
      if (hour > 12 || hour < 0){
         throw new IllegalArgumentException("hour must be in range 0-12");
      }

      this.minute = minute;
      if (minute > 59 || minute < 0){
         throw new IllegalArgumentException("minute must in range 0-59");
      }

      this.second = second;
      if (second > 59 || second < 0){
         throw new IllegalArgumentException("second must be in range 0-59");
      }
   } // end EVC


   // METHODS

    /**
    * This method gets the current hours value
    * @return int the current hour setting for the Clock
    */
   public int getHour(){
      return this.hour;
   } // end getHour



   /**
   * This method gets the current minutes value.
   * @return int the current minute setting for the Clock.
   */
   public int getMinutes(){
      return this.minute;
   } // end getMins



    /**
    * This method gets the current Seconds value.
    * @return int the current second setting for the Clock
    */
   public int getSeconds(){
      return this.second;
   } // end getSeconds



    /**
    * This adds # of hours to current time
    * @param hour representing the current hour
    * @throws IllegalArgumentException throw if the hour < 0
    */
   public void setHour(final int hour) throws IllegalArgumentException{
      if (hour < 0){
         throw new IllegalArgumentException("hour must be greater than 0");
      }

         // Add # of hours
         this.hour = (this.hour + hour);

      if (this.hour > 12 || this.hour > 24){
         this.hour = (this.hour % 12);
      }
   }


   /**
    * This adds # of minutes to current time and rolls over hrs when applicable
    * @param minute representing the current minutes
    * @throws IllegalArgumentException throws if min < 0
    */
   public void setMinutes(final int minute) throws IllegalArgumentException{
      if (minute < 0){
         throw new IllegalArgumentException("minute must be greater than 0");
      }

      // Add min
      this.minute = (this.minute + minute);

      // Pass to setHour as an arg & Carry min when applicable
      int numHours = (this.minute / 60);
      this.minute %= 60;
      setHour(numHours);

      // Check if min > 59
      if (this.minute > 59){

         // Get overflow minutes value on clock
         this.minute = (this.minute % 60);

         // Summon setHour
         setHour(numHours);
      }
   }



   /**
    * This method converts time values into a single formatted string to show usr
    * @return String of Clock's current time
    */
   @Override
   public String toString(){

       return String.format("%02d:%02d:%02d",hour,minute,second);
   }
} // EoC


