package Theatre;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Theatre theatre = new Theatre("Olympian", 8, 12);

        List<Theatre.Seat>list = theatre.getSeats();

        printList(list);

    }

    public static void printList(List<Theatre.Seat> list) {
        for(Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNum() + " $" + seat.getPrice());
        }
        System.out.println();
        System.out.println("======================================================================");
    }
}