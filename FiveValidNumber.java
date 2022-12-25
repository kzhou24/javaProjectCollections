import java.util.Scanner;

public class FiveValidNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int sum = 0;

        for(int i =0;i<5;i++){

            boolean valid = false;

            int num = 0;



            do{
                System.out.println("Please Enter Number#"+i);
                try {

                    num = checkInteger(scanner.nextLine());
                    valid= num>=0? true: false;
                }
                catch (NumberFormatException badInput){

                    System.out.println("It is not a number, no character !");
                }
            }while(!valid);

            sum+=num;


        }

        System.out.println("The total number is "+ sum);
    }

    public static int checkInteger(String val){

        int num = Integer.valueOf(val);

        if(num<0){

            return -1;
        }

        return num;

    }




}
