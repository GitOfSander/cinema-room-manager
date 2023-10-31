# Cinema room manager
Cinema room manager programmed with Java while following the Introduction to Java course from the Jetbrains Academy on Hyperskill.

# Overview
The program works as described in the following step-by-step guide:

1. Enter the number of rows and the amount of seats in each row.
2. Choose an option:
   - Show the seats | Will display an overview of the cinema room.
   - Buy a ticket | Asks which row and seat you would like to have and gives you the price.
   - Statistics | Shows the amount of sold seats, total seats, current income and maximum reachable income.
   - exit | Will close the program.
3. Program repeats step 2 till the program is exited.

<pre>
Enter the number of rows:
8

Enter the number of seats in each row:
7

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
2

Enter a row number:
1

Enter a seat number in that row:
4
Ticket price: $10

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
2

Enter a row number:
1

Enter a seat number in that row:
4
That ticket has already been purchased!

Enter a row number:
1

Enter a seat number in that row:
5
Ticket price: $10

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
1

Cinema:
  1 2 3 4 5 6 7 
1 S S S B B S S 
2 S S S S S S S 
3 S S S S S S S 
4 S S S S S S S 
5 S S S S S S S 
6 S S S S S S S 
7 S S S S S S S 
8 S S S S S S S 

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
3

Number of purchased tickets: 2
Percentage: 3.57%
Current income: $20
Total income: $560

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
0


Process finished with exit code 0
</pre>

# Usage
Download the release and go in your terminal where you placed cinema-room-manager.jar and run:

<pre>java -jar cinema-room-manager.jar</pre>