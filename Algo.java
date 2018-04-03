import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

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
      
      int[] arr = new int[10];
      int count = 0;
      
      BufferedReader br = new BufferedReader(new FileReader("phw_input.txt"));
      String line = null;
   
      while ((line = br.readLine()) != null) {
         String[] values = line.split(",");
         for (String str : values) {
            //System.out.println(str);
            arr[count] = Integer.parseInt(str);
            count++;
         }
      }
      br.close();
      
      Algo a = new Algo();
      ArrayList<ArrayList> arrList = new ArrayList<ArrayList>();
      ArrayList<ArrayList> timeMatrix = new ArrayList<ArrayList>();
       
      int algo1 = a.algo1(arr);
      int algo2 = a.algo2(arr);
      int algo3 = a.maxSum(arr, 0, 9);
      int algo4 = a.algo4(arr);
   
      System.out.println("algorithm-1: " + algo1);
      System.out.println("algorithm-2: " + algo2);
      System.out.println("algorithm-3: " + algo3);
      System.out.println("algorithm-4: " + algo4 
         + " where " + algo4 + " is the MSCS as " +
         "determined by each of the algorithms.");
      
      for(int i = 1; i < 20; i++){
         arrList.add(new ArrayList<Integer>(5*i+5)); //creates empty ArrayList for random nums
         a.fillList(arrList.get(i-1),5*i+5);         //fills list with random num's
         
         timeMatrix.add(new ArrayList<Integer>(5*i+5));//creates empty ArrList for timeMatrix
         if(i < 5){ //fills out first 4 col with avg exe times
            timeMatrix.get(0).add(i-1, 0);//insert avg exe time
         }
      }
   }
   
   public int max(int x, int y){
      if(x > y){ 
         return x;
      }
      return y;
   }
   public int max(int x, int y, int z){
      if(x >= y || x >= z){
         return x;
      }
      else if (y >= z || y >= x){
         return y;
      }
      return z; 
   }
   
   public int algo1(int[] X){
      int P = 0;
      int Q = X.length;
      int maxSoFar = 0;
      for(int L=P; L<Q; L++){
         for(int U=L; U<Q; U++){
            int sum = 0; 
            for(int I=L; I<=U; I++){
               sum = sum + X[I];
            //sum now contains the sum of X[L..U]
            }
            maxSoFar = max(maxSoFar, sum);
         }
      }
      return maxSoFar;
   }

   public int algo2(int[] X){
      int maxSoFar = 0; 
      int P = 0;
      int Q = X.length;//-1;
      for(int L=P; L<Q; L++){
         int sum = 0;
         for(int U=L; U<Q; U++){
            sum = sum + X[U];
            // sum now contains the sum of X[L..U]
            maxSoFar = max(maxSoFar, sum);
         }
      }
      return maxSoFar;
   }
   
   //algo3
   public int maxSum(int[] X, int L, int U){
      //int L = X[0];
      //int U = X[X.length];
      if(L > U){
         return 0; //zero-element vector
      }
      if(L == U){
         return max(0,X[L]); //one-element vector
      }
      int M = (L+U)/2; //A is X[L..M], B is X[M+1..U]
      //Find max crossing to left
      int sum = 0; 
      int maxToLeft = 0;
      for(int I=M; I>=L; I--){
         sum = sum + X[I];
         maxToLeft = max(maxToLeft, sum);
      }
      //Find max crossing to right
      sum = 0; 
      int maxToRight = 0;
      for(int I = M+1; I<=U; I++){
         sum = sum + X[I];
         maxToRight = max(maxToRight, sum);
      }
      int maxCrossing = maxToLeft + maxToRight;
      int maxInA = maxSum(X,L,M);
      int maxInB = maxSum(X,M+1,U);
      
      return max(maxCrossing, maxInA, maxInB);
   }
   
   public int algo4(int[] X){
      int maxSoFar = 0;
      int maxEndingHere = 0;
      int P = 0;
      int Q = X.length;//-1;
      for(int I=P; I<Q; I++){
         maxEndingHere = max(0, maxEndingHere + X[I]);
         maxSoFar = max(maxSoFar, maxEndingHere);
      }
      return maxSoFar;
   }
   
   public void fillList(ArrayList aryList, int listSize){
      Random rand = new Random();
      for(int i=0; i < listSize; i++){
         aryList.add(i, rand.nextInt());
      }
   }
}