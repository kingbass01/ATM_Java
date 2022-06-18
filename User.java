/*User.java*/

import java.util.Scanner;

class User extends Person{
    protected String acc_no, pw;    //Keeping these attributes protected to use in Account.java
    public void getKYC(){
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        sc.close();
        state = sc.nextLine();
        sc.close();
    }
    public void createAcc(){
        Scanner sc = new Scanner(System.in);
        pw = sc.nextLine();
        sc.close();
    }
}
