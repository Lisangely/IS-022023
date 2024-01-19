package Reto15;

public class TurnOnDevices {
    public static void main(String[] args) {
        turnOnDevice(new Lamp());
        turnOnDevice(new Computer());
        turnOnDevice(new AdapterCoffeMaker());
        }
        private static void turnOnDevice(Connectable device) {
        device.turnOn();
        System.out.println(device.isOn());
        }
}
    class Connectable {
        void turnOn(){}
        void turnOff(){}
        boolean isOn(){
          return false;
    }
}
class Lamp extends Connectable {
    boolean enable;
    public void turnOn(){
        enable = true;
    }
    void turnOff(){
        enable = true;
    }
    boolean isOn(){
        if(enable){
            System.out.println("Lamp is on");
        }else{
            System.out.println("Lamp is off");
        }
        return enable;
}
}
class Computer extends Connectable{
    boolean enable;
    void turnOn(){
        enable = true;
    }
    void turnOff(){
        enable = true;
    }
    boolean isOn(){
        if(enable){
            System.out.println("Computer is on");
        }else{
            System.out.println("Computer is off");
        }
      return enable;
    }
}
    class CoffeMaker {
        boolean enable = false;
    boolean isOff() {
        return !enable;
    }
    void on() {
        if (isOff()) {
            enable = true;
            System.out.println("CoffeMaker is on");
        }
    }
    void off() {
        if (!isOff()) {
            enable = false;
            System.out.println("CoffeMaker is off");
        }
    }
}

 class Adapter extends Connectable {
    CoffeMaker coffeMaker = new CoffeMaker();
    public void turnOn() {
        coffeMaker.on();
    }
    public void turnOff() {
        coffeMaker.off();
    }
    public boolean isOn() {
        return !coffeMaker.isOff();
    }
}
