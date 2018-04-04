# comp3270
algorithms


Page

1
of 5
Page 1of 5
COMP 3270 SPRING2018PROGRAMMING HOMEWORKDUE BY 11:59 pmFridayApril, 6, 2018 
Late submissions will not be accepted. Not submitting this HW will result in the F grade
Empirical analysis of algorithms involves implementing, running and then analyzing the 
run-time data collected against theoretical predictions. This homework asks you to implement,
and theoreticallyand empiricallycompute the complexities of algorithms with different 
orders of complexity to solve the problem of Maximum Sum Contiguous Subvector defined as 
follows: Maximum Sum Contiguous Subvector(MSCS) Problem: Compute the sum of the subsequence 
of numbers (a subsequence is a consecutive set of one or more numbers) in an array of 
numbers(for this HW, we will use integers) that sum to the largest value possible; but 
if this value is negative, MSCS is defined to be zero. E.g., in an array of all positive 
(or all negative) numbers, the Maximum Contiguous Subvectorconsists of allnumbersin the 
array (or zero). There may bemultiple Maximum Subsequencesin an array, all of which sum 
to the same largestsum. E.g., in an array of all zeroes, MSCS =0 and any 0 in the array 
is a Maximum Subsequence. Remember that the input array may contain zeroes, negative 
and/or positive integers. For example, if the input is [1,2,-4,3,-5,2,0] then MSCS =3 and 
there are two Maximum Subsequences that sum to the same MSCS: A[1]+A[2]=1+2=3 or A[4]=3.
Requirements: 
  1.  Implement the provided algorithms of different complexity orders to solve this problem.
      The implementation should be faithful to the algorithms provided in this homework; 
      use the same variable names; if you turn in code that implements different algorithms, 
      perhaps you find on the web, then you will get a zero.

  2.  CalculateT(n) and the order of complexityofeach algorithm in the big-Ohor Theta 
      notation using any of the methods we discussed in class. 
      (a) Show your calculationsin the provided tables, then 
      (b) determine and state the polynomial T(n) and 
      (c) the complexity order of the algorithm. Incomplete answers to this part will 
          get zero, not a partial grade.
  3.  You must program in C, Java or C++. With prior permission, other languages may be 
      acceptable–talk to the TAand obtain his permission. 
  4.  Write a main program that carries out the following tasks, one after the other:
  5.  First, the mainprogram should read from a file named “phw_input.txt” containing 
      10 comma-delimited integersin the first line,create an arraycontaining these 10 
      integers, andrun each of the algorithms on that input array, and print out the 
      answer produced by each on the console as follows:"algorithm-1: <answer>; 
      algorithm-2:<answer>;algorithm-3:<answer>; algorithm-4:<answer> where <answer> 
      is the MSCS as determined by eachof the algorithms.
  6.  Next,create 19integer sequences of length10,15,20,25,......90,95,100, containing 
      randomly generated negative, zero and positive integers, and store these in 19 
      arrays of size 10,15,...,95,100:A1-A19.
  7.  Then use the system clock to measure time t1, run one of the fouralgorithms on 
      array Ai(starting withi=1)N times (where N is at least100, but if your system 
      clock does not have a good resolution you may need N to be larger, like 500 or 
      1000 in order to get meaningful running times), then measure time t2, and compute 
      average time needed by that algorithm to solve the problemwith input size = size 
      of Ai. Do this for eachofthe algorithmsexecuting on eachof the 19input arrays to 
      fill the first fourcolumns of a19X8matrix of integerswithaverage execution times.
      Each rowof this matrix corresponds to one input size, from 10-100.
  8.  Fill the last fourcolumns of this matrix with values ceiling(T1(n)), 
      ceiling(T2(n)), ceiling(T3(n)),and ceiling(T4(n)) where n=each input size and T(n) 
      arethe polynomialsrepresenting the theoretically calculated complexity of the three 
      algorithms that you determinedin step 2part (b). So,column 1 will have measured 
      running times of your first algorithm and column 5will have the calculated 
      complexityfor the same algorithm; similarly for columns 2 & 6, 3 & 7, and 4&8.You 
      may need to scale the complexity values (or use an appropriate time unit such as 
      nano/micro/milli secondsfor the measured running times) in order to bring alldata 
      into similar ranges.
  9.  Your main program should writeone text line of algorithm and complexity order 
      titlesseparated by commas (e.g., "algorithm-1,algorithm-2,algorithm-3,algorithm-4,
      T1(n),T2(n),T3(n),T4(n)"), followed by the above matrix alsoin comma-delimited 
      format (19lines of 8integersseparated bycommas) to a file called 
      "yourname_phw_output.txt".
  10. Open yourname_phw_output.txtwith a spreadsheetand produce a labeled graph with 
      10-100 on the x-axis and 8curves showing the actual time taken and predicted time 
      (the complexity order) for each algorithm. Label the curves appropriately.


Page 2of 5SUBMISSION INSTRUCTIONSIf you have any doubts/questions,ask theinstructor or the TA before you code.Our expectation is that you know how to program by now. So,the instructor or TAwill not debug your source codefor you. We can help you with logic and algorithms. Your submission mustinclude: 1.Source code that is properly commented (if you reuse code fragments from another source such as the text, web site, etc., clearly identify the fragments and their source in comments) including all procedures, functions, classes, etc. and the main program -in short everything we need tocompile and run it. 2.A doc or pdf file with:a.Details of the complexity order calculationas shown by filled tablesfrom p.4-5of this homework.b.The graphand anexplanation of what it shows: Did the actual time taken match predicted complexity of each algorithm as the input size increased from 10to 100? Why or why not?Submit via Canvas, following the instructions below (you may loose points otherwise), all required items before the deadline on the due date. Late submissions will not be graded.Do not send any executables. •Include all files as a single zipped attachment. •The body of the email should contain your name, the names of all filesin the zipped archive, an explanationof how you compiled your program (what IDE or command line compilation command for the compiler you used), andthe following certificationstatement (verbatim): “I certify that I wrote the code I am submitting. I did not copy whole or parts of it from another student or have another person write the code for me. Any code I am reusing in my program is clearly marked as such with its source clearly identified in comments.”Without this certification, your grade will be zero.If the TAhas trouble with your attachments you will get an email. It is up to you to check your Canvascourse accountandsort out any such problem cooperatively with the TA. If this is not done in a timely manner, your homework will not be graded. Caution:Your work should follow the academic integrity guidelines stated in the syllabus. Do your own work; do not copy that of another. If we suspect copying, we will compare suspected submissions using plagiarism detection tools. If we find evidence of copying, besides giving you a zero in the assignment, we will refer your caseto appropriate authorities and your certification will be used in the proceedings.GRADING POLICYWe will test your program with our ownphw_input.txt fileand generate a graph from the yourname_phw_output.txtthat your program produces when we run it.Your grade will depend on how your programworks when we test it. We will not try to debug your program; it is your responsibility to send a correct program that will compile, run, will not crash,and produce the correct output. Programs that are not well-organized, not commented properly, and not written following the directions are likely to lose points. If you make any additional assumptions aboutthe input, beyond the ones stated in this document, your program may not run correctly duringour test. The homework will be graded out of a maximum of 100 points. The minimum requirement is to turn in everythingasked for. If you do not meet this requirement, you will get 0 points. If you do, your grade will be determined as follows: 8points for correct complexity order calculation of each algorithm: total 32points max.10points for the graphand 8points for its explanation: total 18points max.If your source does not compile, you will get 0 pointsout of the remaining50points. If the source compiles correctly but the executable does not run or crashes, you will get 5points.If the executable runs, but produces no output file or completely wrongoutput, you will get 10 points.If the output is partially correct, you will get a partial grade higher than 10. If the output is fully correct, you will get an additional 50points.
Page 3of 5Algorithm-1(X : array[P..Q] of integer)1maxSoFar = 02forL = Pto Q3forU = L to Q4sum =05forI = L to U 6sum = sum + X[I]/* sum now contains the sum of X[L..U]*/7                      maxSoFar = max (maxSoFar, sum)8return maxSoFarAlgorithm-2(X : array[P..Q] of integer)1maxSoFar = 02forL = P to Q3sum =04forU = L to Q5sum = sum + X[U]/* sum now contains the sum of X[L..U]*/6maxSoFar = max(maxSoFar,sum)7return maxSoFarAlgorithm-3recursive function MaxSum(X[L..U]: arrayof integer, L, U: integer)1if L > U then return 0   /* zero-element vector */2if L=U then return max(0,X[L]) /* one-element vector */3M = (L+U)/2  /* A is X[L..M], B is X[M+1..U] *//* Find max crossing to left */4sum = 0; maxToLeft =05forI = M downto L do6sum =sum+X[I]7maxToLeft = max(maxToLeft,sum)/* Find max crossing to right */8sum=0; maxToRight=09forI = M+1 to U10sum=sum+X[I]11maxToRight = max(maxToRight, sum)12maxCrossing = maxToLeft + maxToRight13maxInA = maxSum(X, L, M)14maxInB = maxSum(X,M+1,U)15return max(maxCrossing, maxInA, maxInB)Algorithm-4(X : array[P..Q] of integer)1maxSoFar = 02maxEndingHere= 03forI = P to Q 4maxEndingHere = max(0,maxEndingHere + X[I])5maxSoFar = max(maxSoFar, maxEndingHere)6return maxSoFar
Page 4of 5Algorithm-1StepCost of each executionTotal # of times executed12345678Multiply col.1 with col.2, add across rows and simplifyT1(n) = Algorithm-2StepCost of each executionTotal # of times executed1234567Multiply col.1 withcol.2, add across rows and simplifyT2(n) = Algorithm-3StepCost of each executionTotal # of times executed in any single recursive call12Steps executed when the input is a base case:First recurrence relation: T(n=1or n=0) =345678910111213(cost excluding the recursive call)14(cost excluding the recursive call)15Steps executed when input is NOT a base case:Second recurrence relation: T(n>1) =Simplified second recurrence relation (ignore the constant term): T(n>1) =Solve the two recurrence relations using any method (recommended method is the Recursion Tree). Show your work below:T3(n) = 
Page 5of 5Algorithm-4StepCost of each executionTotal # of times executed123456Multiply col.1 with col.2, add across rows and simplifyT4(n) = 
