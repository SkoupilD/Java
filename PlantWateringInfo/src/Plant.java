import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Plant implements Comparable<Plant>{
    static final int DEFAULT_FREQUENCY = 7;
    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate watering;
    private int frequency;

    public Plant(String name) {
        this(name, LocalDate.now(), DEFAULT_FREQUENCY);
    }

    public Plant(String name,LocalDate planted, int frequency) {
        this(name, "", planted,LocalDate.now(), frequency);
    }

    public Plant(String name, String notes, LocalDate planted, LocalDate watering, int frequency) {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.watering = watering;
        this.frequency = frequency;
    }
    public static Plant parse(String text,String delimiter)throws PlantException{
        String[] items = text.split(delimiter);
        int numberOfItems = items.length;
        if (numberOfItems != 5) throw new PlantException("Nespravny format pre import");
        String name = items[0];
        String notes = items[1];
        try {
            LocalDate planted = LocalDate.parse(items[2]);
            LocalDate watering = LocalDate.parse(items[3]);
            int frequency = Integer.parseInt(items[4]);
            return new Plant(name, notes, planted, watering, frequency);
        }
        catch (DateTimeParseException ex) { throw new PlantException("Špatně zadané datum na řádku: \""+text+"\"\n\t"+ex.getLocalizedMessage()); }
        catch (NumberFormatException ex) { throw new PlantException("Špatně zadané číslo na řádku: \""+text+"\"\n\t"+ex.getLocalizedMessage()); }
    }
    public String prepareOutputString(String delimiter) {
        return getName() + delimiter + getNotes() + delimiter + getPlanted() + delimiter + getWatering() + delimiter + getFrequency();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public void setWatering(LocalDate watering) throws PlantException{
        LocalDate datePlanted = getPlanted();
        if (watering.isBefore(datePlanted)) throw new PlantException("It isn't possible last watering date: " + watering + " was before plant was planted: " + datePlanted);
        this.watering = watering;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) throws PlantException {
        if(frequency <= 0) throw new PlantException("Watering frequency should by more then zero. You iserted: " + frequency);
        this.frequency = frequency;
    }
    public String getWateringInfo(){
        String finalString = "Plant: " + getName() +", Last watered: "  + getWatering().toString()+ ", Has Watering Frequency: every " + getFrequency() + "days";
        return finalString;
    }

    @Override
    public int compareTo(Plant second) {
        return this.name.compareTo(second.getName());
    }
}
