import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Guest adela = new Guest("Adela", "Malikova", LocalDate.of(1993, 3, 13));
        Guest jan = new Guest("Jan", "Dvoracek", LocalDate.of(1995, 5, 5));
        Room room1 = new Room(1, 1, true, true, BigDecimal.valueOf(1000));
        System.out.println(room1.getDescription());
        Room room2 = new Room(2, 1, true, true, BigDecimal.valueOf(1000));
        System.out.println(room2.getDescription());
        Room room3 = new Room(3, 3, false, true, BigDecimal.valueOf(2400));
        System.out.println(room3.getDescription());

        Bookings bookings = new Bookings();
        Booking booking1 = new Booking(adela, room1, LocalDate.of(2021, 7, 19), LocalDate.of(2021, 7, 19), TypeOfStay.HOLIDAY);
        bookings.addBooking(booking1);
        Booking booking2 = new Booking(adela, room3, LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 14), TypeOfStay.WORKING);
        booking2.otherGuests.add(jan);
        booking2.otherGuests.add(jan);
        booking2.otherGuests.add(jan);
        booking2.otherGuests.add(jan);
        bookings.addBooking(booking2);
        bookings.printBookings();
        System.out.println("-----------------------------");
        System.out.println(bookings.getBooking(1));
        bookings.addBooking(new Booking(new Guest("Karel","Dvorak", LocalDate.of(1990,5,15)),room3, LocalDate.of(2023,6,1), LocalDate.of(2023,6,7), TypeOfStay.WORKING));
        bookings.addBooking(new Booking(new Guest("Karel", "Dvorak", LocalDate.of(1979,1,3)), room2, LocalDate.of(2023,8,18), LocalDate.of(2023,8,21), TypeOfStay.HOLIDAY));
        Guest kar = new Guest("Karolina", "Tmava", LocalDate.of(1990,4,21));

        for (int i = 0; i < 29 ; i++) {
            bookings.addBooking(new Booking(kar,room2, LocalDate.of(2023,6,i+1),LocalDate.of(2023,6,i+2),TypeOfStay.HOLIDAY));
        }
        bookings.printBookings();
        System.out.println(bookings.getNumberOfBookings());
        System.out.println(bookings.getNumberOfWorkingBookings());
        System.out.println(bookings.getNumberOfHolidayBookings());
        System.out.println(bookings.getNumberOfBookings() == bookings.getNumberOfHolidayBookings() + bookings.getNumberOfWorkingBookings());
        System.out.println(booking2.getNumberOfGuests());
        System.out.println(bookings.getAverageGuests());
        System.out.println(bookings.getBooking(1).getNumberOfGuests());
    }
}
