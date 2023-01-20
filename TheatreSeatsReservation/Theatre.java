package Theatre;

import javax.swing.*;
import java.util.*;

public class Theatre {
    private final String name;
    private List<Seat>seats;

    static Comparator<Seat>check = new Comparator<Seat>() {
            @Override
            public int compare(Seat seat1, Seat seat2) {
                if (seat1.getPrice() < seat2.getPrice()) {
                    return -1;
                } else if (seat1.getPrice() > seat2.getPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };

    public Theatre(String name, int rows,int numPerRow) {

        this.name = name;
        this.seats = new ArrayList<>();

        int lastRow = 'A' + (rows - 1);

        double price = 12.0;
        for (char row = 'A'; row <= lastRow; row++) {
            for (int i = 1; i <= numPerRow; i++) {
                if ((row < 'D') && (i >= 4 && i <= 9)) {
                    price = 14.00;
                } else if ((row > 'F') || (i < 4 || i > 9)) {
                    price = 7.00;
                }

                Seat seat = new Seat(price, ""+row+String.format("%02d", i));

                seats.add(seat);

                Collections.sort(seats,check);
            }
        }
    }

        public boolean reverse(String seatNum){

        Seat seat = new Seat(12.0,seatNum);

        int index = Collections.binarySearch(seats,seat);

        if(index<0){

            System.out.println(" There is no such a seat "+ seatNum);

            return false;
        }

        return seat.reserve();
        }


    public String getName() {
        return name;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public class Seat implements Comparable<Seat>{
        private String seatNum;
        boolean isReserve = false;
        double price;

        public Seat(double price,String seatNum) {
            this.seatNum = seatNum;
            this.price = price;
        }

        public boolean reserve(){

            if(!this.isReserve){

                System.out.println(seatNum+" is reserved.");

                this.isReserve = true;

                return true;
            }

            return false;
        }

        public boolean cancel(){

            if(this.isReserve){
                this.isReserve = false;
                System.out.println(seatNum + " is cancelled");
                return true;
            }
            return false;
        }


        @Override
        public int compareTo(Seat o) {
            return this.seatNum.compareTo(o.seatNum);
        }

        public String getSeatNum() {
            return seatNum;
        }

        public double getPrice() {
            return price;
        }
    }


}
