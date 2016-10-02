
public class Scheduler{
   private Time openTime, closeTime;
   private int openDays, shiftLength;
   private Employee[] employee;
   /**
    *create a scheduler class and assign the needed variabhles to schedule
    *@param openTime the time when the buisness opens every day
    *@param closeTime the time when the buisness closes every day
    *@param openDays how many days per week the buisness is open
    *@param shiftLength how long the minimum shift is
    *@param employee an array of all employees available to be scheduled
    */
   public Scheduler(Time openTime, Time closeTime, int openDays, int shiftLength, Employee[] employee){
      this.openTime = openTime;
      this.closeTime = closeTime;
      this.openDays = openDays;
      this.shiftLength = shiftLength;
      this.employee = employee;
   }
   /**
    * This stores the employee to the time in the schedule
    * @param employee the employee to be stored
    * @param t the time to schedule the employee at
    */
   public void schedule(int employee, Time t){
      //fill in data type here
   }

   /**
    * This is the scheduling algorithm. To be expanded upon
    * it currently walks though each day looking for openings and
    * adding employees accordingly.
    * 
    *
    */
   public void Schedule(){
      int currentDay = 0; //0 is monday, 1 is tuesday.. etc
      int currentEmployee = 0;
      //loop through each day scheduling by half hour
      while(currentDay < openDays){
         Time currentTime = openTime;
         //while there is still time to be scheduled, continue scheduleing.
         while(currentTime.compareTo(closeTime) < 0){
            boolean scheduled = false;
            
            while(!scheduled){
               if(employee[currentEmployee].canWork(currentTime, shiftLength, currentDay)){
                  schedule(currentEmployee, currentTime);    
                  scheduled = true;
                  currentTime.add(shiftLength);
               }else{
                  currentEmployee = (currentEmployee + 1) % employee.length;
               }
            }
            

         }
      }
   }
}
