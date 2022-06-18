/* ATM Project (T10) */


//Name             Roll no.

//Aryan Ruia       21124010
//Bhavesh Gupta    21124017
//Parangat Aditya  21124038
//Utkarsh Rai      21124050


/*
    In the terminal on running the program, please enter the inputs in the same order and press enter in the fields asked sequentially to see the results

    SAMPLE INPUT 1 (To simply check all the required functions):

    770803              //Acc no. of 3rd user
    password2           //Password
    1                   //To show balance
    2                   //To deposit
    2000                //Deposition amount
    3                   //To withdraw
    1000                //Withdrawal amount
    4                   //To exit


    SAMPLE INPUT 2 (To witness exception handling):

    461103              //Acc no. of 4th user
    password3           //Password
    2                   //To deposit
    one thousand        //Throws exception (InputMismatchException) which is handled by try catch statement
    
*/


import java.util.*;

public class Main{
    static int checkifreturn=0;
    public  static void main(String[] args){
        Main obj=new Main();//Created an object for our Main class

        System.out.println("WELCOME TO ATM");
        int noOfUsers = 5;//Our sample spcae has 5 inputs
        int attempt = 0;
        Account[] acc = new Account[noOfUsers];
        //Constructor parameters: Name, Account No., Password
        acc[0] = new Account("Aman Singh", "981174", "password0");//person 1
        acc[1] = new Account("Reena Jaisawal", "190803", "password1");//person 2
        acc[2] = new Account("Manoj Solanki ", "770803", "password2");//person 3
        acc[3] = new Account("Pallavi Mishra", "461103", "password3");//person 4
        acc[4] = new Account("Ravi Anand", "140203", "password4");//person 5
        while(true){
            System.out.print("ENTER USER ID: ");
            String s1, s2;
            Scanner sc = new Scanner(System.in);
            s1 = sc.nextLine();
            System.out.print("ENTER PASSWORD: ");
            s2 = sc.nextLine();//taking account number and password as input from user
            Boolean flag = false;
            for(int i = 0; i < noOfUsers; i++){
                if(s1.equals(acc[i].acc_no) && s2.equals(acc[i].pw)){//checking if the provided account number and password matches our sample space
                    if(i%2 == 0)
                        System.out.println("WELOCME, Mr. "+acc[i].name);
                    else if(i%2 == 1)
                        System.out.println("WELCOME, Ms. "+acc[i].name);
                   
                    obj.showMainMenu(acc[i]);
                    flag = true;
                }
            }
            if(flag == false){
                System.out.println("WRONG INPUT,PLEASE TRY AGAIN"+" ATTEMPTS LEFT"+" "+(2-(attempt)));
                attempt++;
            }
            if(attempt == 3){
                attempt = 0;
                System.out.println("YOUR CARD HAS BEEN TEMPORARILY BLOCKED,PLEASE TRY AGAIN IN 24 HOURS");
                break;
            }
            if(checkifreturn==-1){
                System.out.println("THANK YOU FOR USING OUR SERVICES");
              break;
            }
           
            
        }
        

    }

    public  void showMainMenu(Account a){
        System.out.println(" ");
        
        System.out.println("ATM (Automated Teller Machine)");
        System.out.println("Choose your desired action:");
        System.out.println("1. Show current balance");
        System.out.println("2. Deposit amount");
        System.out.println("3. Withdraw amount");
         System.out.println("Press Any other number To exit Our service");
        String ch="";
        Scanner sc2 = new Scanner(System.in);
        ch = sc2.nextLine();
        switch(ch){
            case "1": 
                a.showBal();
               
                showMainMenu(a);
                break;
            case "2": 
                a.deposit();
                a.showBal();
                
                showMainMenu(a);
                break;
            case "3": 
                a.withdraw();
                a.showBal();
                
                
                showMainMenu(a);
                break;
            default:    //to end our procces and return back to main menu
                
                checkifreturn=-1;
                sc2.close();
                return;
        }
    }
}