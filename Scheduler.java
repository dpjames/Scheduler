
public class Scheduler{
   private Time openTime, closeTime;
   private int openDays, shiftLength;
   private Employee[] employee;
   private String[] schedule;
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
      this.schedule = new String[openDays];
      for(int i = 0; i < schedule.length; i++){
         schedule[i] = "";
      }
   }
   /**
    * This stores the employee to the time in the schedule
    * @param employee the employee to be stored
    * @param t the time to schedule the employee at
    */
   public void sched(int empl, Time t, int day){
      //System.out.println(employee[empl].getName() + " " + t + " " + day);
      schedule[day]+= t + "| " + employee[empl].getName() + "\n";
      //System.out.println(schedule[day]);
   }
   public String[] getSched(){
      return this.schedule;
   }
   /**
    * This is the scheduling algorithm. To be expanded upon
    * it currently walks though each day looking for openings and
    * adding employees accordingly.
    * 
    *
    */
   public void schedule(){
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
                  sched(currentEmployee, currentTime, currentDay);    
                  scheduled = true;
                  currentTime.add(shiftLength);
               }else{
                  currentEmployee = (currentEmployee + 1) % employee.length;
                  //System.out.println(currentTime);
               }
            }
         }
         currentDay++;
      }
   }
}
