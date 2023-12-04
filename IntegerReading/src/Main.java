import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void readOneIntFromInputAndPrintIt() {
        int input = Support.safeReadInt();
        System.out.println("You entered: "+input);
    }

    public static void readIntsFromInputAndPrintItUntilNegative() {
        do {
            int input = Support.safeReadInt();
            if (input < 0) break;
            System.out.println("You entered: " + input);
        } while (true);
    }
    public static int sumAllInputUntilNegative() {
        int input = 0, sum = 0;
        do {
            sum += input;
            input = Support.safeReadInt();
        } while (input >= 0);
        return sum;
    }

    public static List<Integer> storeAllInputInArrayListUntilNegative() {
        List<Integer> inputs = new ArrayList<>();
        do {
            int input = Support.safeReadInt();
            if (input < 0) break;
            inputs.add(input);
        } while (true);
        return inputs;
    }

    public static void printAllIntegersFromList(List<Integer> list) {
        for (Integer i: list){
            System.out.println(i);
        }
    }
    public static Integer sumAllIntegersFromList(List<Integer> list) {
        int sum = 0;
        for (Integer i: list){
            sum += i;
        }
        return sum;
    }
    public static void printIntegersUnderLimit(List<Integer> list, int limit) {
        for (Integer i: list){
            if (i >= limit ) {
                System.out.println(i);
            }
        }
    }
    public static void printIntegersWithReplace(List<Integer> list) {
        int count = 0;
        for (Integer i: list) {
            count ++;
            switch(i){
                case 1:
                    System.out.print("one");
                    break;
                case 2:
                    System.out.print("two");
                    break;
                case 3:
                    System.out.print("tree");
                    break;
                default :
                    System.out.print(i);
                    break;
            } if (count == list.size()) {
                System.out.println(".");
            }  else {
                System.out.print(", ");
            }
        }
    }
    //endregion

    public static void main(String[] args) {
        // Příklad:
        System.out.println("--- Example - read and print one integer ---");
        readOneIntFromInputAndPrintIt();
        // ---
        System.out.println("--- Task 1 - read and print integers until negative ---");
        readIntsFromInputAndPrintItUntilNegative();
        // ---
        System.out.println("--- Task 2 - sum all integers until negative ---");
        System.out.println("Total sum: " + sumAllInputUntilNegative());
        // ---
        System.out.println("--- Task 3 - read integers to list until negative ---");
        List<Integer> list = storeAllInputInArrayListUntilNegative();
        System.out.println(list);
        // ---
        System.out.println("--- Task 4 - print all integers from list ---");
        printAllIntegersFromList(list);
        // ---
        System.out.println("--- Task 5 - sum all integers in list ---");
        System.out.println("Total sum: " + sumAllIntegersFromList(list));
        // ---
        System.out.println("--- Task 6 - print integers under 5 from list ---");
        printIntegersUnderLimit(list, 5);
        // ---
        System.out.println("--- Task 7 - print integers - replace: 1 => \"one\", 2 => \"two\", 3 => \"three\" ---");
        printIntegersWithReplace(list);
    }
}