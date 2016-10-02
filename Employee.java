public class Employee{
   private Time[][] startTimes;
   private int[][] durations;
   private String name; 
   public Employee(Time[][] startTimes, int[][] durations, String name){
      this.startTimes = startTimes;
      this.durations = durations;
      this.name = name;
   }
   public String getName(){
      return name;
   }


   /**
    * Will let return true if and only if the employee is free from the start
    * time t to the end time (t + length).
    * @param t the start time of the duration
    * @param length the duration of the time
    * @param day the day to be tested
    */
   public boolean canWork(Time t, int length, int day){
      Time[] emplday = startTimes[day];
      int[] dur = durations[day];
      Time endTime = new Time(t);
      endTime.add(length);
      //System.out.println("Start time: " + t + " EndTime = " + endTime);
      for(int i = 0; i < emplday.length; i++){
         Time emplEnd = new Time(emplday[i]);
         emplEnd.add(dur[i]);
         System.out.println(emplday[i] + ">" + t + "--" + emplEnd + ">" + endTime);
         //emplday[] -> emplEnd     t -> endTime
         //emplday[] < t && emplEnd>endTime
         if(emplday[i].compareTo(t) <= 0 && (emplEnd.compareTo(endTime) >= 0)){
            return true; 
         }
      }
      return false;
   }



   public static void main(String[] args){
      
      Time[] mon = new Time[2];
      mon[0] = new Time(13,00);
      mon[1] = new Time(16,00);
      int[] mondur = new int [2];
      mondur[0] = 60*2;
      mondur[1] = 60*3+30;
      Time[][] week = new Time[1][2];
      week[0] = mon;
      int[][] weekdur = new int[1][2];
      weekdur[0] = mondur;
      Employee e1 = new Employee(week, weekdur, "e1");
      System.out.println(e1.canWork(new Time(15,00),60, 0) + " false");
      System.out.println(e1.canWork(new Time(15,30),60, 0) + " false");
      System.out.println(e1.canWork(new Time(16,00),60,0) + " true");
      System.out.println(e1.canWork(new Time(14,30),60,0) + " false");
      System.out.println(e1.canWork(new Time(14,00),60,0) + " true");
      System.out.println(e1.canWork(new Time(13,30),60,0) + " true");
   
   
   }  
}
