import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Algo {

   public static void main(String[] args) throws Exception {
         
      Algo a = new Algo();
      
      ArrayList<Integer> arr = new ArrayList<Integer>();
      ArrayList<ArrayList<Integer>> arrList = new ArrayList<ArrayList<Integer>>();
      ArrayList<ArrayList<Long>> timeMatrix = new ArrayList<ArrayList<Long>>();
      String file = "phw_input.txt";
       
      arr = a.scanFile(file, arr);  //scans ints in file to array
      
      a.printMaxSum(arr); //runs ints in file with algo's, prints to console
      
      for(int i = 1; i < 20; i++){
         arrList.add(new ArrayList<Integer>(5*i+5)); //creates empty ArrayList for random nums
         a.fillList(arrList.get(i-1),5*i+5);         //fills list with random num's
         
         timeMatrix.add(new ArrayList<Long>(5*i+5));//creates empty ArrList for timeMatrix
         if(i < 5){ //fills out first 4 col with avg exe times
            //timeMatrix.get(0).add(i-1, 0);//insert avg exe time
         }
      }
      
      a.timeAlgo(arrList, timeMatrix); //runs arrList against algos 100 times, takes the avg
   }
   
   public ArrayList scanFile(String fileName, ArrayList<Integer> arr) throws Exception{
      int count = 0;
      
      BufferedReader br = new BufferedReader(new FileReader(fileName));
      String line = null;
   
      while ((line = br.readLine()) != null) {
         String[] values = line.split(",");
         for (String str : values) {
            //System.out.println(str);
            arr.add(count, Integer.parseInt(str));
            count++;
         }
      }
      br.close();
      
      return arr;
   }
   
   public void printMaxSum(ArrayList<Integer> ary){
      int algo1 = algo1(ary);
      int algo2 = algo2(ary);
      int algo3 = maxSum(ary, 0, 9);
      int algo4 = algo4(ary);
      
      System.out.println("algorithm-1: " + algo1);
      System.out.println("algorithm-2: " + algo2);
      System.out.println("algorithm-3: " + algo3);
      System.out.println("algorithm-4: " + algo4 
         + " where " + algo4 + " is the MSCS as " +
         "determined by each of the algorithms.");
   }
   
   public void timeAlgo(ArrayList<ArrayList<Integer>> aryList, 
                           ArrayList<ArrayList<Long>> timeMtrx){
      long  start, 
            end;
      long  t1=0,
            t2=0,
            t3=0,
            t4=0;
      int   N = 100;
      
      for(int i=0; i<N; i++){
         for(int j=0; j<18; j++){    
            start = System.nanoTime();//currentTimeMillis();
            algo1(aryList.get(j));
            end = System.nanoTime();//currentTimeMillis();
            t1 += (end - start);
            
            start = System.nanoTime();
            algo2(aryList.get(j));
            end = System.nanoTime();
            t2 += end - start;
         
            start = System.nanoTime();
            maxSum(aryList.get(j), 0, aryList.get(j).size()-1);
            end = System.nanoTime();
            t3 += end - start;
            
            start = System.nanoTime();
            algo4(aryList.get(j));
            end = System.nanoTime();
            t4 += end - start;
         }
      }
      
      //converts nano to micro
      //takes the avg of the running times
      t1 /= 100000;//= TimeUnit.NANOSECONDS.toMillis(t1);
      t1 /= N;
      timeMtrx.get(0).add(0, t1);//insert avg exe time 
      
      t2 /= 100000;//= TimeUnit.NANOSECONDS.toMillis(t2);
      t2 /= N; 
      timeMtrx.get(0).add(1, t2);//insert avg exe time
      
      t3 /= 100000;//= TimeUnit.NANOSECONDS.toMillis(t3);
      t3 /= N; 
      timeMtrx.get(0).add(2, t3);//insert avg exe time
      
      t4 /= 100000;//= TimeUnit.NANOSECONDS.toMillis(t4);
      t4 /= N;
      timeMtrx.get(0).add(3, t4);//insert avg exe time
      
      System.out.println(t1 + "\n" + t2 + "\n" + t3 + "\n" + t4);
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
   
   public int algo1(ArrayList<Integer> X){
      int P = 0;
      int Q = X.size();
      int maxSoFar = 0;
      for(int L=P; L<Q; L++){
         for(int U=L; U<Q; U++){
            int sum = 0; 
            for(int I=L; I<=U; I++){
               sum = sum + X.get(I);
            //sum now contains the sum of X[L..U]
            }
            maxSoFar = max(maxSoFar, sum);
         }
      }
      return maxSoFar;
   }

   public int algo2(ArrayList<Integer> X){
      int maxSoFar = 0; 
      int P = 0;
      int Q = X.size();//-1;
      for(int L=P; L<Q; L++){
         int sum = 0;
         for(int U=L; U<Q; U++){
            sum = sum + X.get(U);
            // sum now contains the sum of X[L..U]
            maxSoFar = max(maxSoFar, sum);
         }
      }
      return maxSoFar;
   }
   
   //algo3
   public int maxSum(ArrayList<Integer> X, int L, int U){
      //int L = X[0];
      //int U = X[X.length];
      if(L > U){
         return 0; //zero-element vector
      }
      if(L == U){
         return max(0,X.get(L)); //one-element vector
      }
      int M = (L+U)/2; //A is X[L..M], B is X[M+1..U]
      //Find max crossing to left
      int sum = 0; 
      int maxToLeft = 0;
      for(int I=M; I>=L; I--){
         sum = sum + X.get(I);
         maxToLeft = max(maxToLeft, sum);
      }
      //Find max crossing to right
      sum = 0; 
      int maxToRight = 0;
      for(int I = M+1; I<=U; I++){
         sum = sum + X.get(I);
         maxToRight = max(maxToRight, sum);
      }
      int maxCrossing = maxToLeft + maxToRight;
      int maxInA = maxSum(X,L,M);
      int maxInB = maxSum(X,M+1,U);
      
      return max(maxCrossing, maxInA, maxInB);
   }
   
   public int algo4(ArrayList<Integer> X){
      int maxSoFar = 0;
      int maxEndingHere = 0;
      int P = 0;
      int Q = X.size();//-1;
      for(int I=P; I<Q; I++){
         maxEndingHere = max(0, maxEndingHere + X.get(I));
         maxSoFar = max(maxSoFar, maxEndingHere);
      }
      return maxSoFar;
   }
   
   public void fillList(ArrayList<Integer> aryList, int listSize){
      Random rand = new Random();
      for(int i=0; i < listSize; i++){
         aryList.add(i, rand.nextInt());
      }
   }
}