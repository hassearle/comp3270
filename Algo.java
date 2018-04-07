/*
I certify that I wrote the code I
am submitting. I did not copy whole or parts of it from another student or have another person write the
code for me. Any code I am reusing in my program is clearly marked as such with its source clearly
identified in comments.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.lang.Math;
import java.io.PrintWriter;

public class Algo {

   public static void main(String[] args) throws Exception {
         
      Algo a = new Algo();
      
      ArrayList<Integer> arr = new ArrayList<Integer>();
      ArrayList<ArrayList<Integer>> arrList = new ArrayList<ArrayList<Integer>>();
      ArrayList<ArrayList<Long>> timeMatrix = new ArrayList<ArrayList<Long>>();
      String file = "phw_input.txt";
      String outFile = "";
       
      arr = a.scanFile(file, arr);  //scans ints in file to array
      
      a.printMaxSum(arr); //runs ints in file with algo's, prints to console
      
   
      
      for(int i = 1; i < 20; i++){
         arrList.add(new ArrayList<Integer>(5*i+5)); //creates empty ArrayList for random nums
         a.fillList(arrList.get(i-1),5*i+5);         //fills list with random num's
         timeMatrix.add(new ArrayList<Long>(5*i+5));//creates empty ArrList for timeMatrix
      
      }
      
      a.timeAlgo(arrList, timeMatrix); //runs arrList against algos 100 times, takes the avg
      a.timeComplex(timeMatrix);
      a.printTimeVertex(timeMatrix);
   }
   
   
   //scans file and reads into program
   public ArrayList scanFile(String fileName, ArrayList<Integer> arr) throws Exception{
      int count = 0;
      
      BufferedReader buff = new BufferedReader(new FileReader(fileName));
      String line = null;
   
      while ((line = buff.readLine()) != null) {
         String[] values = line.split(",");
         for (String str : values) {
            arr.add(count, Integer.parseInt(str));
            count++;
         }
      }
      buff.close();
      
      return arr;
   }
   
   //runs file agains algorithms 
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
   
   
   //imputs all times into time vector
   public void timeAlgo(ArrayList<ArrayList<Integer>> aryList, 
                           ArrayList<ArrayList<Long>> timeMtrx){
      long  start, 
            end;
      long  t1=0,
            t2=0,
            t3=0,
            t4=0;
      int   N = 1000;
      
      for(int i=0; i<19; i++){
         for(int j=0; j<N; j++){    
            start = System.nanoTime();//currentTimeMillis();
            algo1(aryList.get(i));
            end = System.nanoTime();//currentTimeMillis();
            t1 += (end - start);
            //converts nano to micro
            //takes the avg of the running times
                          
            start = System.nanoTime();
            algo2(aryList.get(i));
            end = System.nanoTime();
            t2 += end - start;
                        
            start = System.nanoTime();
            maxSum(aryList.get(i), 0, aryList.get(i).size()-1);
            end = System.nanoTime();
            t3 += end - start;
                           
            start = System.nanoTime();
            algo4(aryList.get(i));
            end = System.nanoTime();
            t4 += end - start;
         }
         t1 /= 10;
         t1 /= N;//gets avg
         timeMtrx.get(i).add(0, t1);
      
         t2 /= 10;  
         t2 /= N;
         timeMtrx.get(i).add(1, t2);
            
         t3 /= 10;
         t3 /= N;
         timeMtrx.get(i).add(2, t3);
            
         t4 /= 10;
         t4 /= N;
         timeMtrx.get(i).add(3, t4);
      }   
   }
   
   //finds max (duh)
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
   
   //fills vector with random numbers
   public void fillList(ArrayList<Integer> aryList, int listSize){
      Random rand = new Random();
      for(int i=0; i < listSize; i++){
         aryList.add(i, rand.nextInt());
      }
   }

   //determines time complexities 
   public void timeComplex(ArrayList<ArrayList<Long>> tv){
      long t_n = 0;
      long n = 0;
      for(int i=1; i < 20; i++){
         for(int j=0; j<4; j++){
            n = i * 5 + 5; 
            int constant = 0;
            switch(j){
               case 0:
                  
                  t_n = ((7/6)*n*n*n)+(7*n*n)+((41/6)*n)+6;
                  tv.get(i-1).add(4, t_n);
                  break;
               case 1:
                  t_n = (6*n*n)+(8*n)+5;
                  tv.get(i-1).add(5, t_n);
                  break;
               case 2:
                  if(tv.get(i-1).isEmpty()){
                     constant += 4;
                  }else{
                     constant += 13;
                  }
                  t_n = (n*constant) + ((12*n)+38)*(n-1);
                  tv.get(i-1).add(6, t_n);
                  break;
               case 3:
                  t_n = (14*n)+5;
                  tv.get(i-1).add(7, t_n);
                  break;   
               default:
            }
         }
      }
   }
   
   //prints time complexities from vertex
   public void printTimeVertex(ArrayList<ArrayList<Long>> t_v)throws Exception{
      PrintWriter writer = new PrintWriter("searle_phw_output.txt", "UTF-8");
      writer.println("algorithm-1,algorithm-2,algorithm-3,algorithm-4,T1(n),T2(n),T3(n),T4(n)");
      for(int i=1; i < 20; i++){
         int listSz = t_v.get(i-1).size();
         for(int j=0; j<listSz; j++){
            
            writer.print(t_v.get(i-1).get(j) + ",");
              
         }
         writer.println("");
      }
      writer.close();
   }
}