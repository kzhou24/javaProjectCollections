import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Set;

public class traverse {

    public static record Place(String name , int distance){

        @Override
        public String toString() {
            return String.format("%s,(%d)",name,distance);
        }
    }


    private  static Scanner scanner;
    public static void main(String[] args) {

        scanner = new Scanner(System.in);

    boolean flag = true;

    boolean forward = true;

        LinkedList<Place> placesToVisit = new LinkedList<>();

        Place adelaide = new Place("Adelaide", 1374);
        addPlace(placesToVisit, adelaide);
        addPlace(placesToVisit, new Place("adelaide", 1374));
        addPlace(placesToVisit, new Place("Brisbane", 917));
        addPlace(placesToVisit, new Place("Perth", 3923));
        addPlace(placesToVisit, new Place("Alice Springs", 2771));
        addPlace(placesToVisit, new Place("Darwin", 3972));
        addPlace(placesToVisit, new Place("Melbourne", 877));

        placesToVisit.addFirst(new Place("Sydney", 0));
        System.out.println(placesToVisit);

        ListIterator iterator = placesToVisit.listIterator(0);

        menu();

        while (flag){

            String s = scanner.nextLine().substring(0,1);

            if(!iterator.hasNext()){

                System.out.println("final stop : " +iterator.previous());

                forward = false;
            }

            if(!iterator.hasPrevious()){
                System.out.println(" The first stop : "+ iterator.next());

                forward = true;
            }



            switch (s){

                default :
                    System.out.println("Thank u for your time");

                    flag = false;

                    break;

                case "F":

                    if(!forward){

                        forward= true;

                        if(iterator.hasNext()){

                            iterator.next();
                        }
                    }

                    if(iterator.hasNext()){

                        System.out.println(" The next stop is "+ iterator.next());
                    }

                    break;


                case "B":

                    if(forward){

                        forward = false;

                        if(iterator.hasPrevious()){

                            iterator.previous();
                        }

                    }

                    if(iterator.hasPrevious()){

                        System.out.println(" The previous stop is "+ iterator.previous());
                    }

                    break;

                case "M":

                    menu();
                    break;
            }

        }




    }

    public static void addPlace(LinkedList<Place>list,Place place){

        if(list.contains(place)){

            System.out.println("Duplicate place contained "+ place.name());

            return;
        }

        for(Place p: list){

            if(p.name().equalsIgnoreCase(place.name())){
                System.out.println("Duplicate place contained "+p.name());

                return;

            }
        }

        int i = 0;

        for(Place p: list){

            if(place.distance()<p.distance()){

                list.add(i,place);

                return;
            }
            i++;
        }
        list.add(place);

    }


    private static void menu(){

     String s = """
             Available actions (select word or letter):
             (F)orward
             (B)ackwards
             (L)ist Places
             (M)enu
             (Q)uit
                 
             """;
        System.out.println(s);
    }



}
