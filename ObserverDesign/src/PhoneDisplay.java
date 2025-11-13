public class PhoneDisplay implements Observer {

    @Override
    public void update(int temp, int humidity) {
        System.out.println("Phone Display : Temp = " + temp + " Humidity = " + humidity + "%");
    }
}
