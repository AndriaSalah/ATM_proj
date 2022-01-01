package atm;

public class CustomerInfo {
int    [] pins          = {1919,5115,2019,8888};
int    [] balance    = {19990,15000,25000,60000};
String [] account_id = {"a394458dj","a38jd849jf","hjhdu29973","smohd87162"};
String [] holders    = {"Andria","Habiba","Ibrahim","Mohab"} ;
String [] History    = {"amazon  300$","supermarket  200$", "pharmacy  50$"};
int index  ;

    public int getBalance() {
        return balance[index];
    }

    public void setBalance(int balance) {
        this.balance[index] = balance;
    }

    public String getAccount_id() {
        return account_id[index];
    }

    public String getHolders() {
        return holders[index];
    }
    public boolean set_index(int num){
        for (int i = 0 ; i < 4 ; i++){
            if (num == pins[i]){
                index = i;
                System.out.println(num+""+i);
                return true;
            }

        }
        return false;

    }
}
