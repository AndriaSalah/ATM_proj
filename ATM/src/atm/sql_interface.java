package atm;

public interface sql_interface {
    final static String url = "jdbc:sqlserver://localhost:1433;databaseName=atm;integratedSecurity=true;encrypt = false";

    public void flushtodb();
    boolean getfromdb(String buffer);
    public void GetHistoryfromdb(String buffer);
    public void GetTempfromdb(String transit);
    public void FlushTemptodb();
    public void GetTempHistoryfromdb(String buffer);

}
