public class Main {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        
        Light livingRoomLight = new Light();
        Fan ceilingFan = new Fan();
        
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        Command fanOn = new FanOnCommand(ceilingFan);
        Command fanOff = new FanOffCommand(ceilingFan);

        // Set commands in the remote slots
        remote.setCommand(0, lightOn, lightOff);
        remote.setCommand(1, fanOn, fanOff);

        System.out.println("--- Testing Remote Control ---");

        // Demonstrate pressing buttons
        remote.onButtonWasPushed(0);
        remote.onButtonWasPushed(1);
        remote.undoButtonWasPushed();

        System.out.println("------------------------------");

        remote.offButtonWasPushed(0);
        remote.onButtonWasPushed(1);
        remote.undoButtonWasPushed();
        remote.undoButtonWasPushed();
    }
}