package bankaccountapp;

public class Savings extends Account{
    private int safetyDepositeBoxID;
    private int safetyDepositeBoxKey;
    
    public Savings(String name, String sSN, double deposit) {
        super(name, sSN,deposit);
        accountNumber = "1"+accountNumber;
        setSafetyDepositeBoxID();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() - 0.25;
    }

    private void setSafetyDepositeBoxID() {
        safetyDepositeBoxID = ((int) (Math.random()*Math.pow(10,3)));
        safetyDepositeBoxKey = (int) (Math.random()*Math.pow(10,4));
    }

    public void showInfo(){
        super.showInfo();
        System.out.println(" Your Savings Account Features : "+
        "\n Safety Deposite Box ID : "+safetyDepositeBoxID+
        "\n Safety Deposite Box Key : "+safetyDepositeBoxKey);
    }


}
