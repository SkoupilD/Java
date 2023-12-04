import java.util.ArrayList;
import java.util.List;

public class Bookings {
    List<Booking> bookings = new ArrayList<>();
    public void addBooking(Booking newBooking) {
        bookings.add(newBooking);
    }
    public List<Booking> getBookings() {
        return new ArrayList<>(bookings);
    }
    public Booking getBooking(int index) {
        return bookings.get(index);
    }
    public void clearBookings() {
        bookings.clear();
    }
    public void printBookings() {
        for (Booking booking : bookings) {
            System.out.println(booking.getDescription());
        }
    }
    public int getNumberOfBookings() {
        return bookings.size();
    }

    public int getNumberOfWorkingBookings() {
        int c = 0;
        for (Booking b : bookings)
            if (b.getType() == TypeOfStay.WORKING) {
                c++;
            }
        return c;
    }

    public int getNumberOfHolidayBookings() {
        int e = 0;
        for (Booking b : bookings) {
            if (b.getType() == TypeOfStay.HOLIDAY) {
                e++;
            }
        }
        return e;
    }

    public double getAverageGuests(){
        double totalGuests = 0;
        for (Booking booking : bookings){
            System.out.println(booking.getNumberOfGuests());
            totalGuests += booking.getNumberOfGuests();
            System.out.println(totalGuests);
            System.out.println(bookings.size());
        }
        return  totalGuests / bookings.size();
    }
}