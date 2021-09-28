import java.util.Scanner;

public class ComputerDriver {
    int size = 5;
    Computer[] inventory = new Computer[size];
    String password = "password";

    public void mainMenu(){

        System.out.println("What do you want to do?");
        System.out.println("1. Enter new computers");
        System.out.println("2. Change information of a computer");
        System.out.println("3. Display all computers by a specific brand");
        System.out.println("4. Display all computers under a certain a price.");
        System.out.println("5. Quit");
        System.out.println("Please enter your choice > ");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option){
            case 1:
                passwordAuthentication();
                addComputer();
                break;
            case 2:
                passwordAuthentication();
                updateComputer();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                System.out.println("Wrong option!");
        }
    }

    public void passwordAuthentication(){
        int NoOfTries=0;
        Scanner sc = new Scanner(System.in);
        int flag =0;
        do{
            System.out.println("Enter your password");
            String EnteredPass = sc.next();
            if(EnteredPass.equals(password)){
                System.out.println("Authentication Successful");
                flag=1;
                break;
            }
            NoOfTries++;
        }while (NoOfTries<3);
        if(flag==0){
            mainMenu();
        }
    }

    public void addComputer(){
        int i=0;
        while(i<size && inventory[i]!=null){
            i++;
        }
        System.out.println("I : "+i);
        System.out.println("Number of Computers to enter in the inventory");
        Scanner sc = new Scanner(System.in);
        int noOfComp = sc.nextInt();
        if(size-i>=noOfComp){
         for(int x=i; x<noOfComp; x++){
             System.out.println("Enter the Brand name of the computer");
             String l_brand = sc.next();
             System.out.println("Enter the Model of the Computer");
             String l_model = sc.next();
             System.out.println("Enter the Serial Number of the Computer");
             Long l_sn = sc.nextLong();
             System.out.println("Enter the Price of the Computer");
             double l_pr = sc.nextDouble();
             Computer l_c = new Computer(l_brand, l_model, l_sn, l_pr);
             inventory[x] = l_c;
         }
        }else{
            System.out.println("Cannot add "+ noOfComp+ " computers, Only "+(size-i)+" places remaining in inventory!");
            mainMenu();
        }
        mainMenu();
    }
    public void updateComputer(){
        int choice=0;
        System.out.println("Enter the computer number in inventory to update");
        Scanner sc = new Scanner(System.in);
        int indexToUpdate = sc.nextInt();
        if(inventory[indexToUpdate]!=null){
            System.out.println("Entered");
            System.out.println(inventory[indexToUpdate].toString());
            while (choice!=5) {
                System.out.println("What information would you like to\n" +
                        "change?\n" +
                        "1. brand\n" +
                        "2. model\n" +
                        "3. SN\n" +
                        "4. price\n" +
                        "5. Quit\n" +
                        "Enter your choice >");
                choice = sc.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("Enter the new brand name");
                        String newBrand = sc.next();
                        inventory[indexToUpdate].setBrand(newBrand);
                        System.out.println(inventory[indexToUpdate].toString());
                        break;
                    case 2:
                        System.out.println("Enter the new model name");
                        String newModel = sc.next();
                        inventory[indexToUpdate].setModel(newModel);
                        System.out.println(inventory[indexToUpdate].toString());
                        break;
                    case 3:
                        System.out.println("Enter the new Serial Number");
                        Long newSn = sc.nextLong();
                        inventory[indexToUpdate].setSN(newSn);
                        System.out.println(inventory[indexToUpdate].toString());
                        break;
                    case 4:
                        System.out.println("Enter the new Price");
                        double newPr = sc.nextDouble();
                        inventory[indexToUpdate].setPrice(newPr);
                        System.out.println(inventory[indexToUpdate].toString());
                        break;
                    case 5:
                        break;
                    default:
                        break;
                }
            }
        } else{
            Scanner st = new Scanner(System.in);
            System.out.println("No computer found at this location, do you want to add computer ?");
            String yn = st.next();
            if(yn.equals("yes") || yn.equals("Yes") || yn.equals("Y") || yn.equals("y")){
                addComputer();
            }
        }
    }

    public static void main(String[] args) {
        ComputerDriver cd = new ComputerDriver();
        cd.mainMenu();
    }
}
