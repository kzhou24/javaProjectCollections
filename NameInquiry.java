import java.util.Scanner;

public class NameInquiry {

    public static void main(String[] args) {

        getAgeFromScanner(2022);

    }

    public static void getAgeFromScanner(int currentYear){

        Scanner scanner = new Scanner(System.in);

        System.out.println(" Hello, what is your name ? ");

        String name = scanner.nextLine();

        System.out.println(" Thank you, "+name+" for joining in our investigation");

        boolean isValid = false;

        int age = 0;

        do{
            System.out.println(" Please enter the year of your birth before "+ currentYear+" and the year after "+(currentYear-125));
            try {
               age = checkYear(currentYear,scanner.nextLine());

                isValid =age>-1?true:false;
            }catch (NumberFormatException badInput){

                System.out.println(" Wrong Input ! Please re-enter it");
            }

        }while (!isValid);

        System.out.println(" So, your are " + age + " years old");

    }

    public static int checkYear(int currentYear, String yearOfBirth){

            int yOB = Integer.parseInt(yearOfBirth);

            if(currentYear<yOB||currentYear-yOB>125){
                return -1;
            }

            int age  = currentYear-yOB;


            return age;
    }

}
