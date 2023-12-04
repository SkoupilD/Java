import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PlantList {
    public static final String DELIMITER = ";";
    ArrayList<Plant> plantList = new ArrayList<>();

    public void addPlant(Plant newPlant){
        plantList.add(newPlant);
    }
    public Plant getPlant(int index){
        return plantList.get(index);
    }
    public void deletePlant(int index){
        plantList.remove(index);
    }
    public int size(){
        return plantList.size();
    }

    public void importListFromFile(String fileName) throws PlantException {
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))){
            int lineNumber = 0;
            while(scanner.hasNextLine()){
                String record = scanner.nextLine();
                lineNumber++;
                try {
                    this.addPlant(Plant.parse(record, DELIMITER));
                } catch (PlantException ex) {
                    throw new PlantException("Neplatný vstupní soubor " + fileName + " na řádku " + lineNumber + ":\n\t" + ex.getLocalizedMessage());
                }
            }
        } catch (FileNotFoundException ex){
            throw new PlantException("Vstupní soubor "+fileName+" nebyl nalezen: "+ex.getLocalizedMessage());
        }
    }
    public void exportToFile(String fileName) throws PlantException{
        int lineNumber = 0;
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))){
            for (Plant plant: plantList){
                String plantFileLine = plant.prepareOutputString(";");
                writer.println(plantFileLine);
                lineNumber++;
            }
        } catch (IOException ex) {
            throw new PlantException("Error writing to : "+fileName+" line "+lineNumber+": "+ex.getLocalizedMessage());
        }
    }
    public ArrayList<Plant> asList(){
        return new ArrayList<Plant>(plantList);
    }
}

