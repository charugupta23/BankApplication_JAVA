package bankaccountapp;

public abstract class Account implements IBaseRate{

    private String name;
    private String sSn;
    private double balance;

    private static int index = 10000;
    private int randomNo;
    protected  String accountNumber;
    protected double rate;

    public Account(String name,String sSN, double deposit){
        this.name = name;
        this.sSn = sSN;
        balance = deposit;
        index++;
        this.accountNumber = setAccountNumber();
        setRate();
    }

    public abstract void setRate();

    public String setAccountNumber(){
        String lastTwoOfSSN = sSn.substring(sSn.length()-2,sSn.length());
        int uniqeID = index;
        randomNo = (int) (Math.random()*Math.pow(10,3));
        return lastTwoOfSSN + uniqeID + randomNo;
    }

    public void deposit(double amount){
        balance=balance+amount;
        System.out.println("Deposit $"+amount+ " to the account");
        printBalance();
    }

    public void withdraw(double amount){
        balance=balance-amount;
        System.out.println("Withdraw $"+amount+ " from the account");
        printBalance();
    }

    public void transfer(String toWhere,double amount){
        balance=balance-amount;
        System.out.println("Withdraw $"+amount+ " to "+toWhere);
        printBalance();
    }

    public void compound(){
        double accuredInterest= balance*(rate/100);
        balance = balance+accuredInterest;
        System.out.println("Accured Interest $"+accuredInterest);
        printBalance();
    }

    public void printBalance(){
        System.out.println("Amount available in your account : "+balance);
    }

    public void showInfo(){
        System.out.println(
                "NAME : "+ name+
                        "\nACCOUNT NUMBER : "+ accountNumber+
                        "\nBALANCE : "+"$"+balance+
                        "\nRate : "+rate+"%"
        );
    }
}

