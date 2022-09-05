# Atm project File system

This is an Atm gui project which contains the following features:
- Depositing
- Withdrawing
- Credit-card payment
- Balance history
- Login page
- Dynamic data which is read from files and saved to it 
- Sigin Up 
- Transfer between accounts
Depositing and Withdrawing are basically the same code just some minor differences like the change of the withdraw button into deposit ad vice versa

### Account logging in
is basically done by cross refrencing the entered pin with a corresponding file that is named after that pin
for example when you enter 1001 into the login page and press login, the program then starts looking in the Data/ folder for a file named 1001.txt
if the 1001.txt file cannot be found that will give an error message saying the entered pin is incorrect.

### Account Creation
is done by pressing the sign up button in the login frame which opens a new frame containing three textfields 
there is error handlers on every text field :

    > name            --> numbers checker
    > mobile number   --> letters checker
    > pin             --> length and letter checker
        
so when you press the sign up button two text files are then created both are named after the entered pin 

#### example:
pin entered is 1001 --> a 1001.txt will be created and then 1001.history.txt

pin.txt will contain all the account information in the following order
   
    1 - name
    2 - account balance
    3 - randomly generated account number generated from this string (abcdefghijklmnopqrstuvwxyz0123456789)
    4 - randomly generated card number ranges from 100000000 to 999999999
    5 - mobile number
    6 - owed balance (amount of money to be payed for the credit card)
   
-----
final example:

    Andria
    1000000
    account no
    credit card no
    phone number
    0(owed balance)
---

pin.history.txt will contain all the transactions made in the programs and everything is saved in the following order:

    1-place (which funtction was it from for ex: deposit,withdraw or credit payment)
    2-price (amount payed in that specific transaction
        
    final example:
    withdraw (place)
    10000    (price)
    amazon
    100
