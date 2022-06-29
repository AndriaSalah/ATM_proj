This is an Atm gui project which contains the following features:
1-Depositing
2-Withdrawing
3-Credit-card payment
4-Balance history
5-Login page
6-Dynamic data which is read/written from sql server(mssms) 
7-Sigin Up 
8-Transfer between accounts

Depositing and Withdrawing are basically the same code just some minor differences like the change of the withdraw button into deposit ad vice versa.
The database used is relativley simple, here is the erd for it
![Untitled Diagram drawio](https://user-images.githubusercontent.com/74527457/176364883-7e3caaf0-33f7-43b9-a61c-7a56ebde084d.png)

as you can see it's just two entities with a primary key account_id which is the main key for how everything in this application works.

The account_id is basically like your account number in the bank consists of 9 characters 5 random and the pin code is appended to the bank account to make a full acount number of 9 characters ex.(e2ydh3010)

we have a somewhat different and easier approach using sql rather than the file system as it had to be structured and alot of other restricitons so we have

Getfromdb(){}
FlushTodb(){}
FlushHistorytodb(){}
GetTempfromdb(){}
FlushTempTodb(){}

every one of these functions only exectue one sql statment 
getfromdb for example uses :
SELECT * FROM CUSTOMER WHERE ACCOUNT_ID LIKE ('%PIN') to login

