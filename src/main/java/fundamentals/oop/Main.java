package fundamentals.oop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount bankAccount = new BankAccount();
        System.out.println("Type: " + bankAccount.getType());
        System.out.println("Balance: " + bankAccount.getBalance());
        System.out.println("Curreny: " + bankAccount.getCurrency());
        //case 1 : give bank account to the client created on outside ( BankAccount )
        Client client1 = new Client("Alex", "1345412340763", bankAccount);
        System.out.println(client1.toString());


        client1.getBankAccount().addMoney(12);
        client1.getBankAccount().withdrawMoney(13);
        System.out.println(client1.toString());
        client1.getBankAccount().setType("SPENDING");
        client1.getBankAccount().addMoney(1);
        double x = bankAccount.convertMoneyToCurrency(10, "EUR", "USD");
        System.out.println(bankAccount.convertMoneyToCurrency(10, "EUR", "USD"));
        System.out.println(x);

        BankAccount bankAccount1 = new BankAccount("SAVING", "USD");
        BankAccount bankAccount2 = new BankAccount("SPENDING","USD");
        BankAccount[] myArray = {bankAccount1,bankAccount2};
        client1.setBankAccounts(myArray);
        System.out.println(myArray[0]);
        BankAccount[] clientBankAccounts = client1.getBankAccounts();
        System.out.println(clientBankAccounts[0]);
//        client1.getBankAccounts()[1].addMoney(30);
        System.out.println(client1.getBankAccounts()[0]);




//        System.out.println("Input client s  name:");
//        String name = scanner.next();
//        System.out.println("Input client s cnp");
//        String cnp = scanner.next();
//        //case 2 : client has asigned by default an account - create bank account inside the constructor
//        Client client2 = new Client(name, cnp);
//        System.out.println(client2.toString());

    }
}
