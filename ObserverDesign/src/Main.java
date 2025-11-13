import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Observer[] observers = {new TVDisplay(), new PhoneDisplay(), new WebDashboard()};
        WeatherStation station = new WeatherStation();


        try {
            //Add Observers in runtime
            for (int i = 0; i < 3; i++) {
                station.addObserver(observers[i]);
                station.notifyObservers(rand.nextInt(20, 100), rand.nextInt(100));
                Thread.sleep(2000);
                System.out.println("-------------------------------------------------------");
            }

            for (int i = 0; i <= 3; i++) {
                station.notifyObservers(rand.nextInt(20, 100), rand.nextInt(100));
                Thread.sleep(2000);
                System.out.println("-------------------------------------------------------");
            }

            //Remove observers in runtime
            for (int i = 0; i < 3; i++) {
                station.removeObserver(observers[i]);
                station.notifyObservers(rand.nextInt(20, 100), rand.nextInt(100));
                Thread.sleep(2000);
                System.out.println("-------------------------------------------------------");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}