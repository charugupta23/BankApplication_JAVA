package bankaccountapp;

import utilities.CSV;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) throws IOException {
        /*Checking ch1 = new Checking("Tom Willson","123467890", 10000);
        Savings sv1 = new Savings("Jack Hill", "1234567890",20000);

        ch1.showInfo();
        ch1.deposit(500);
        ch1.compound();
        System.out.println("***********************");
        sv1.showInfo();
        sv1.withdraw(500);
        sv1.compound();*/
        List<Account> accounts = new LinkedList<Account>();


        String file =
                "src/main/resources/BankAccounts.csv";
        List<String[]> newAccountHolder = CSV.raedData(file);
        for(String[] accountHolder : newAccountHolder){
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            //System.out.println(name);
            if (accountType.equals("Savings"))
                accounts.add(new Savings(name,sSN,initDeposit));
            else if (accountType.equals("Checking"))
                accounts.add(new Checking(name,sSN,initDeposit));
            else
                System.out.println("Error reading Account");

        }
        for (Account acc :accounts){
            System.out.println("\n*****************");
            acc.showInfo();

        }

    }
}
