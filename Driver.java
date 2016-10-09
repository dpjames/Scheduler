public class Driver{
   private static Employee[] empls;
   public static void main(String[] args){
      makeEmployees();
      Time openTime = new Time(12,00);
      Time closeTime = new Time(17,00);
      int openDays = 1;
      int shiftLength = 30;
      Scheduler scheduler = new Scheduler(openTime, closeTime, openDays, shiftLength, empls);
      scheduler.schedule();
      String[] s = scheduler.getSched();
      for(int i = 0; i < s.length; i++){
         System.out.println(s[i]);
      }
   }


   public static void makeEmployees(){
      empls = new Employee[3];
      Time[][] e1t = new Time[1][3];
      int[][] e1d = new int[1][3];
      e1t[0][0] = new Time(12,00);
      e1d[0][0] = 30;

      e1t[0][1] = new Time(13,30);
      e1d[0][1] = 30;

      e1t[0][2] = new Time(15,00);
      e1d[0][2] = 2*60;

      empls[0] = new Employee(e1t, e1d, "employee 1");
      empls[1] = new Employee(e1t,e1d, "employee 2");

      Time[][] e2t = new Time[1][2];
      int[][] e2d = new int[1][2];

      e2t[0][0] = new Time(12,30);
      e2d[0][0] = 60;

      e2t[0][1] = new Time(14,00);
      e2d[0][1] = 60;

      empls[2] = new Employee(e2t,e2d,"Employee 3");
     
   }
}
