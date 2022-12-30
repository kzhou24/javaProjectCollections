package WacthMovie;

public class Movie {
    private String name;

    public Movie(String name) {
        this.name = name;
    }
    public void  move(){
        System.out.println( name +" is a "+ this.getClass().getSimpleName()+ " kind of movie");

    }

    public static Movie getMovie(String type, String title){

        return switch (type.toUpperCase().charAt(0)){

            default -> new Movie(title);
            case 'A'-> new Adventure(title);
            case 'S'-> new ScienceFiction(title);
            case 'C'->new Comedy(title);
        };
    }
}
class Adventure extends Movie{
    public Adventure(String name) {
        super(name);
    }

    @Override
    public void  move() {
        super.move();
        System.out.printf("..%s%n".repeat(3),"Pleasant Scene","Scary Music","Something Bad Happens"); // %d->digit %s->String
    }
    public void moveAdventure(){
        System.out.println("Watching an Adventure");
    }
}

class Comedy extends Movie{
    public Comedy(String name) {
        super(name);
    }

    @Override
    public void  move() {
        super.move();
        System.out.printf("..%s%n".repeat(3),"Something funny happens","Something even funnier happens","Happy Ending");

    }
    public void moveComedy(){

        System.out.println("Watching a comedy");
    }
}

class ScienceFiction extends Movie{
    public ScienceFiction(String name) {
        super(name);
    }

    @Override
    public void move() {
        super.move();
        System.out.printf("..%s%n".repeat(3),"Pleasant Scene","Scary Music","Something Surprising Happens");

    }

    public void moveScienceFiction(){

        System.out.println("Watch a science fiction movie");
    }
}
