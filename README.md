quick note , there are two branches for this project one with sql and one with file system
This is an Atm gui project which contains the following features:
1-Depositing
2-Withdrawing
3-Credit-card payment
4-Balance history
5-Login page
6-Dynamic data which is read from files and saved to it 
7-Sigin Up 
8-Transfer between accounts

Depositing and Withdrawing are basically the same code just some minor differences like the change of the withdraw button into deposit ad vice versa

Account logging in
is basically done by cross refrencing the entered pin with a corresponding file that is named after that pin
for example when you enter 1001 into the login page and press login, the program then starts looking in the Data/ folder for a file named 1001.txt
if the 1001.txt file cannot be found that will give an error message saying the entered pin is incorrect.

Account Creation
is done by pressing the sign up button in the login frame which opens a new frame containing three textfields 
there is error handlers on every text field :
        1-name            --> numbers checker
        2-mobile number   --> letters checker
        3-pin             --> length and letter checker
        
so when you press the sign up button two text files are then created both are named after the entered pin 

ex:
pin entered is 1001 --> a 1001.txt will be created and then 1001.history.txt

pin.txt will contain all the account information in the following order:
        1-name
        2-account balance
        3-randomly generated account number generated from this string (abcdefghijklmnopqrstuvwxyz0123456789)
        4-randomly generated card number ranges from 100000000 to 999999999
        5-mobile number
        6-owed balance (amount of money to be payed for the credit card)
      
      final example:
      Andria
      1000000
      account no
      credit card no
      phone number
      0(owed balance)
      
pin.history.txt will contain all the transactions made in the programs and everything is saved in the following order:
        1-place (which funtction was it from for ex: deposit,withdraw or credit payment)
        2-price (amount payed in that specific transaction
        
      final example:
      withdraw (place)
      10000    (price)
      amazon
      100
      
After adding  the Transfer class the logic behind Generating account number changed as of now till i find a better way to make the pin unoticable as much
for now the Randomly generated account number will have 5 randomly generated letters or numbers and the last 4 characters are your pin , why did i do that?

in order to find the pin.txt that conatins all of the info about the other account , it's name , account balance and etc. and load it into the application
by cutting the string (Account number) using substring(5,9) to get the pin that the program will look for in the Data/ directory to load the the balance 
of all of it's information and add the transfer to the balance history as Transfer-in (receiving a transfer) or transfer out ( Sending a transfer )
then flushes both temp data and acctual account data on press
