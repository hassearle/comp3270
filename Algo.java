import java.io.BufferedReader;
import java.io.FileReader;

public class Algo {

   public static void main(String[] args) throws Exception {
      /*
      First, the mainprogram should read from a 
      file named “phw_input.txt”containing 10 
      comma-delimited integersin the first line,
      create an arraycontaining these 10 integers, 
      andrun each of the algorithms on that input 
      array, and print out the answer produced by 
      eachon the consoleas follows:"algorithm-1: 
      <answer>; algorithm-2:<answer>;algorithm-3:
      <answer>; algorithm-4:<answer> where <answer> 
      is the MSCS as determined by eachof the 
      algorithms.
      */
      
      //fix
      int[] arr = new int[10];
      
      BufferedReader br = new BufferedReader(new FileReader("phw_input.txt"));
      String line = null;
   
      while ((line = br.readLine()) != null) {
         String[] values = line.split(",");
         for (String str : values) {
            System.out.println(str);
         }
      }
      br.close();
      
      
      int algo1 = algo1(arr);
      int algo2 = algo2(arr);
      int algo3 = maxSum(arr, 0, 0);
      int algo4 = algo4(arr);
      // for(int i=0; i < arr.length ; i++){
   //       System.out.println(arr[i]);
   //    };
   
      System.out.println("algorithm-1: " + algo1);
      System.out.println("algorithm-2: " + algo2);
      System.out.println("algorithm-3: " + algo3);
      System.out.println("algorithm-4: " + algo4 
         + " where " + algo4 + "is the MSCS as " +
         "determined by each of the algorithms.");
      
   }
   
   public static int algo1(int[] X){
      int P = X[0];
      int Q = X[X.length];
      int maxSoFar = 0;
      for(int L=P; L<Q; L++){
         for(int U=L; U<Q; U++){
            int sum = 0; 
            for(int I=L; I<U; I++){
               sum = sum + X[I];
            //sum now contains the sum of X[L..U]
            }
         //maxSoFar = max(maxSoFar, sum)
         }
      }
      return maxSoFar;
   }

   public static int algo2(int[] X){
      int maxSoFar = 0; 
      int P = X[0];
      int Q = X[X.length];
      for(int L=P; L<Q; L++){
         int sum = 0;
         for(int U=L; U<Q; U++){
            sum = sum + X[U];
            // sum now contains the sum of X[L..U]
            //maxSoFar = max(maxSoFar, sum);
         }
      }
      return 0;
   }
   
   //algo3
   public static int maxSum(int[] X, int L, int U){
      //int L = X[0];
      //int U = X[X.length];
      if(L > U){
         return 0; //zero-element vector
      }
      if(L == U){
         return 0;//max(0,X[L]); //one-element vector
      }
      int M = (L+U)/2; //A is X[L..M], B is X[M+1..U]
      //Find max crossing to left
      int sum = 0; 
      int maxToLeft = 0;
      for(int I=M; I>L; I--){
         sum = sum + X[I];
         maxToLeft = 0;//max(maxToLeft, sum);
      }
      //Find max crossing to right
      sum = 0; 
      int maxToRight = 0;
      for(int I = M+1; I<U; I++){
         sum = sum + X[I];
         maxToRight = 0;//max(maxToRight, sum);
      }
      int maxCrossing = maxToLeft + maxToRight;
      int maxInA = maxSum(X,L,M);
      int maxInB = maxSum(X,M+1,U);
      
      return 0;//max(maxCrossing, maxInA, maxInB);
   }
   
   public static int algo4(int[] X){
      int maxSoFar = 0;
      int maxEndingHere = 0;
      int P = X[0];
      int Q = X[X.length];
      for(int I=P; I<Q; I++){
         //maxEndingHere = max(0, maxEndingHere + X[I])
         //maxSoFar = max(maxSoFar, maxEndingHere)
      }
      return 0;
   }
}