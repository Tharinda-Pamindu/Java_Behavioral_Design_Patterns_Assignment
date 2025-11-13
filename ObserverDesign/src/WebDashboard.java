public class WebDashboard implements Observer {

    @Override
    public void update(int temp, int humidity) {
        System.out.println("Web Dashboard : Temp = " + temp + " Humidity = " + humidity + "%");
    }
}
