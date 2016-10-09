public class Time{
   private int h,m;
   public Time(Time other){
      this.h = other.h;
      this.m = other.m;
   }
   public Time(int h, int m){
      this.h = h;
      this.m = m;
   }
   /**
    *This method compares two times to find which one comes first
    *@param - other the time to be compared with
    *@return - 1 if this time is > other. 0  if they are equal. -1 if other is > this time.
    */
   public int compareTo(Time other){
      if(this.h>other.h){
         return 1;
      }
      if (this.h<other.h){
         return -1;
      }
      if(this.m>other.m){
         return 1;
      }
      if(this.m<other.m){
         return -1;
      }
      return 0;
   }
   /**
    *this method adds a specified minute amount to the time.
    *@param i - the amount of time (in minutes) to add.
    */
   public void add(int i){
      m+=i;
      if(m>=60){
         int n = m/60;
         m%=60;
         h+=n;
      }
      h = h%24;
      //System.out.println(h + "h " + m + "m");
   }
   /**
    *Returns the represented minutes of the time
    *@return the minutes of the time
    */
   public int getMinutes(){
      return m;
   }
   /**
    *Returns the represented hours of the time.
    *@return the hours of the time.
    */
   public int getHours(){
      return h;
   }
   
   //Testing
   public static void main(String[] args){
      Time t = new Time(10,10);
      t.add(10);
      //System.out.println("10h 20m");
      t.add(20);
      System.out.println("10h 40m");
      t.add(30);
      System.out.println("11h 10m");
      t.add(60);
      System.out.println("12h 10m");
      t.add(60*14);
      System.out.println("2h 10m");

      System.out.println();
      System.out.println("_________________________");

      Time o = new Time(1,10);
      t.h = 0;
      t.m = 0;
      
      System.out.println(t.compareTo(o));
      System.out.println("-1");
      System.out.println(o.compareTo(t));
      System.out.println("1");
      t.add(65);
      System.out.println(t.compareTo(o));
      System.out.println("-1");
      System.out.println(o.compareTo(t));
      System.out.println("1");
      t.add(5);
      System.out.println(t.compareTo(o));
      System.out.println("0");
   }
   @Override
   public String toString(){
      return h+"h " +m + "m"; 
   }
}
