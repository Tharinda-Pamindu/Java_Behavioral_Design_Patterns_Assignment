public class TVDisplay implements Observer {

    @Override
    public void update(int temp, int humidity) {
        System.out.println("TV Display : Temp = " + temp + " Humidity = " + humidity + "%");
    }
}
