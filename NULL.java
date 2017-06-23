public class Testing {             
   public static void main(String args[]){
      Testing myObject = null;
      myObject.iAmStaticMethod();
      myObject.iAmNonStaticMethod();                             
   }
 
   private static void iAmStaticMethod(){
        System.out.println("I am static method, can be called by null reference");
   }
   }
