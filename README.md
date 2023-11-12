# CS2001_W10 Practical

Implementation of W10 Practical. Included is a verion of both Merge and Selection sorting algorithms. Another class is
provided, Test.java. This class can be run multiple times and will test both sort functions according to defined bounds.
Output of such tests will be deposited into csv files in /data directory. These files can be used for graphical representation
of time and size correlation.

How to run program:
1. Load src directory.
2. Open Test.java class.
3. Change first two global attributes to be of a desired choice.
    - runTime corresponds to the max bound size array that will be tested (500 default)
    - accuracy corresponds to the number of iterations each sorting algorithm will be averaged on (20000 default)
4. Compile code in terminal using: javac *.java
5. Run Test.java code in terminal using: java Test.java
6. Data output is placed into the directory data/ which is in the same bin as src/. An output
   file corresponding to the test just run will show up here.
7. Load csv data file in graphing application of choice (I recommend Xcel)
8. Insert graph of data for analysis.
