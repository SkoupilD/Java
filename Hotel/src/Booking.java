import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    Guest mainGuest;
    List<Guest> otherGuests = new ArrayList<>();
    Room room;
    LocalDate begin;
    LocalDate finish;
    TypeOfStay type;

    public Booking(Guest mainGuest, Room room, LocalDate begin, LocalDate finish,TypeOfStay type) {
        this.mainGuest = mainGuest;
        this.otherGuests = otherGuests;
        this.room = room;
        this.begin = begin;
        this.finish = finish;
        this.type = type;
    }

    public Guest getMainGuest() {
        return mainGuest;
    }

    public void setMainGuest(Guest mainGuest) {
        this.mainGuest = mainGuest;
    }

    public List<Guest> getOtherGuests() {
        return otherGuests;
    }

    public void setOtherGuests(List<Guest> otherGuests) {
        this.otherGuests = otherGuests;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getBegin() {
        return begin;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    public LocalDate getFinish() {
        return finish;
    }

    public void setFinish(LocalDate finish) {
        this.finish = finish;
    }

    public TypeOfStay getType() {
        return type;
    }

    public void setType(TypeOfStay type) {
        this.type = type;
    }
    public String getDescription(){
        StringBuilder result = new StringBuilder("Booking for: " + mainGuest.getFullName()+ ", Type of Stay: " + type
                + ", From: " + begin.toString()+ ", Until: " + finish.toString()+ ", Stays with guests: ");
        for (Guest guest: otherGuests) {
            result.append(guest.getFullName()+", ");
        }
        return result.toString();
    }
    public int getNumberOfGuests(){
        return otherGuests.size()+1;
    }
}
