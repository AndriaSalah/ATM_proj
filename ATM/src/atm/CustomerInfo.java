package atm;

public class CustomerInfo {
int    [] pins          = {1919,5115,2019,8888};
public static int    [] balance    = {19990,15000,25000,60000};
public static  String [] account_id  = {"a394458dj","a38jd849jf","hjhdu29973","smohd87162"};
public static String [] holders    = {"Andria","Habiba","Ibrahim","Mohab"} ;
//String [] History    = {"amazon  300$","supermarket  200$", "pharmacy  50$"};
public static int index=0  ;

    public int getBalance(int index) {
        return balance[index];
    }

    public void setBalance(int balance,int index) {
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