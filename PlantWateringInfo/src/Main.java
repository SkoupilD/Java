import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    private static final String INPUT_FILE = "plantiny.txt";
    private static final String OUTPUT_FILE =  "plants.txt";

    public static void main(String[] args) {
        PlantList plantList = new PlantList();
        try {
            plantList.importListFromFile(INPUT_FILE);
        } catch (PlantException ex){
            System.err.println(ex.getLocalizedMessage());
        }
        for (int i = 0; i < plantList.size() ; i++) {
            System.out.println(plantList.getPlant(i).getWateringInfo());
        }
        plantList.addPlant(new Plant("Rakoska"));
        plantList.addPlant(new Plant("Bumbuku", LocalDate.now(), 5));

        try {
            plantList.exportToFile(OUTPUT_FILE);
        } catch(PlantException ex) {
            System.err.println(ex.getLocalizedMessage());
        }
        ArrayList<Plant> list = plantList.asList();
        Collections.sort(list);
        System.out.println("--------------------------------------------");
        for (int i = 0; i < list.size() ; i++) {
            System.out.println(list.get(i).getWateringInfo());
        }
        System.out.println("--------------------------------------------");
        Collections.sort(list,new WateringComparator());
        for (int i = 0; i < list.size() ; i++) {
            System.out.println(list.get(i).getWateringInfo());
        }

    }
}