import java.util.*;

class Account extends User{
    private long curr_bal, dep, wthdr;
    Account(){
        Random rn = new Random();
        curr_bal = rn.nextInt((20000-10000)+1)+10000;
    }
    Account(String s1, String s2, String s3){
        Random rn = new Random();
        curr_bal = rn.nextInt((20000-10000)+1)+10000;
        name = s1;
        acc_no = s2;
        pw = s3;
    }
    public void deposit(){
        System.out.println("Enter the amount you want to deposit in your bank account: ");
        Scanner sc2 = new Scanner(System.in);
        try{
            dep = sc2.nextInt();
        }
        catch(InputMismatchException ime){
            System.out.println("ERROR! Wrong format");
        }
        curr_bal += dep;       
    }
    public void withdraw(){
        System.out.println("Enter the amount you want to withdraw from your bank account: ");
        Scanner sc3 = new Scanner(System.in);
        try{
            wthdr = sc3.nextInt();
        }
        catch(InputMismatchException ime){
            System.out.println("ERROR! Wrong format");
        }
        if(wthdr<10000 && wthdr<curr_bal){
            curr_bal -= wthdr;
        }
        else {
            System.out.println("Insufficient Amount requested");
        }
    }
    public void showBal(){
        System.out.println("Your current balance is: "+curr_bal);
    }
}