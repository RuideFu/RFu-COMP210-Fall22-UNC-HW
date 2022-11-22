package assn07;

import java.util.Scanner;
import java.util.List;
import java.util.Set;
import java.util.Iterator;


public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,String> passwordManager = new PasswordManager<>();

        String masterPwd = null;

        while(true){
            if (!passwordManager.checkMasterPassword(masterPwd)) {
                System.out.println("Enter Master Password");
                masterPwd = scanner.nextLine();
            } else {
                String cmd = scanner.nextLine();
                if (cmd.equals("New password")){
                    String site = scanner.nextLine();
                    String pwd = scanner.nextLine();
                    passwordManager.put(site, pwd);
                    System.out.println("New password added");
                }
                else if (cmd.equals("Get password")){
                    String site = scanner.nextLine();
                    String pwd = passwordManager.get(site);
                    if (pwd == null){
                        System.out.println("Account does not exist");
                    } else {
                        System.out.println(pwd);
                    }
                }
                else if (cmd.equals("Delete account")){
                    String site = scanner.nextLine();
                    String pwd = passwordManager.remove(site);
                    if (pwd == null){
                        System.out.println("Account does not exist");
                    } else {
                        System.out.println("Account deleted");
                    }
                }
                else if (cmd.equals("Check duplicate password")){
                    String pwd = scanner.nextLine();
                    List<String> sites = passwordManager.checkDuplicate(pwd);
                    if (sites.size() == 0){
                        System.out.println("No account uses that password");
                    } else {
                        System.out.println("Websites using that password:");
                        for (int i = 0; i < sites.size(); i++) {
                            System.out.println(sites.get(i));
                        }
                    }
                }
                else if (cmd.equals("Get accounts")){
                    Set<String> sites = passwordManager.keySet();
                    Iterator<String> sitesIterator = sites.iterator();
                    System.out.println("Your accounts:");
                    while (sitesIterator.hasNext()) {
                        System.out.println(sitesIterator.next());
                    }
                }
                else if (cmd.equals("Generate random password")){
                    int len = Integer.parseInt(scanner.nextLine());
                    System.out.println(passwordManager.generateRandomPassword(len));
                }
                else if (cmd.equals("Exit")){
                    masterPwd = null;
                    break;
                } else {
                    System.out.println("Command not found");
                }
            }
        }



    }
}
