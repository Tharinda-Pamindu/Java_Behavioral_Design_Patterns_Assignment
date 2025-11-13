import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class WeatherStation implements Subject {

    private List<Observer> observers;

    {
        observers = new CopyOnWriteArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(int temp, int humidity) {
        for (Observer observer : observers) {
            observer.update(temp, humidity);
        }
    }
}
