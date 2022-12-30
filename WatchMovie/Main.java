package WacthMovie;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Movie movie = Movie.getMovie("Adventure","First Blood");

        movie.move();

        Object object = Movie.getMovie("Comedy","Christmas Evening");

        Comedy newComedy = ((Comedy) object);

        newComedy.move();

        while (true){

            System.out.println(" Please Enter the type of the movie (Q(q)->exit)");

            String type = scanner.nextLine();

            if("Qq".contains(type)){
                System.out.println("Thank you for the joining");
                break;
            }

            System.out.println(" Please Enter the name of the movie : ");

            String name = scanner.nextLine();

            Movie movie1 = Movie.getMovie(type,name);

            movie1.move();
        }

        Object unknownObject = Movie.getMovie("Comedy","Muse");

        if(unknownObject instanceof Comedy){

            ((Comedy)unknownObject).move();
        }


    }
}
