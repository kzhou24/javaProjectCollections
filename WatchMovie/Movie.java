package WacthMovie;

public class Movie {

    private String name;
    public Movie(String name){
        this.name = name;
    }

    public void watchMovie(){

        System.out.println( name + " is a "+this.getClass().getSimpleName()+" movie");

    }

}

class Adventure extends Movie{
    public Adventure(String name) {
        super(name);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf("  %s%n".repeat(3),"Pleasant Scene",
                "Scary Music",
                "Something Bad Happens");
    }
}
class Comedy extends Movie {

    public Comedy(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf(".. %s%n".repeat(3),
                "Something funny happens",
                "Something even funnier happens",
                "Happy Ending");
    }
}

class ScienceFiction extends Movie {

    public ScienceFiction(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf(".. %s%n".repeat(3),
                "Bad Aliens do Bad Stuff",
                "Space Guys Chase Aliens",
                "Planet Blows Up");
    }
}