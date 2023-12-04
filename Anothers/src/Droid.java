public class Droid {

    String name;
    int batteryLevel;
    public Droid(String droidName){
        name = droidName;
        batteryLevel = 100;
    }
    public String toString(){
        return "Hello, my name is " + name;
    }
    public void performTask(String task){
        System.out.println(name + " is performing task: " + task);
        batteryLevel -= 10;
        System.out.println(name + "has battery level after task: " + batteryLevel);
    }
    public static void main(String[] args){
        Droid droid1 = new Droid("Codey");
        System.out.println(droid1.name);
        droid1.performTask("Cooking");
    }
}