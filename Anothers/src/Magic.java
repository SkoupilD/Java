public class Magic {
    public static void main(String[] args) {

        int myNumber = 1; // my number is original number, whatever it means.
        int stepOne = myNumber*myNumber;
        int stepTwo = stepOne+myNumber;
        int stepTree = stepTwo / myNumber;
        int stepFour = stepTree + 17;
        int stepFive = stepFour - myNumber;
        int stepSix = stepFive / 6;
        System.out.println(stepSix);
    }
}