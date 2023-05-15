import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import java.util.ArrayList;
/**
* clase Central
*/
public class Central {
    private final ArrayList<Sensor> zones;
    private final ArrayList<Person> people;
    private CentralState state;
    private final Siren siren;
    private final Timeline periodicCheck;
    private final CentralView view;
    /**
    * Constructor de la clase Central
    * @param siren Sirena con la que se creará la central
    */
    public Central(Siren siren){
        view = new CentralView(this);
        zones = new ArrayList<Sensor>();
        people = new ArrayList<Person>();
        state = CentralState.DISARMED;
        this.siren = siren;
        view.setCentralModel(this);
        periodicCheck = new Timeline(new KeyFrame(Duration.millis(200),
                e-> checkZones()));
        periodicCheck.setCycleCount(Animation.INDEFINITE);
        periodicCheck.play();
    }
    /**
    * Función para obtener la vista
    * @return La vista de central
    */
    public VBox getView (){
        return view;
    }
    /**
    * Función para verificar las zonas de la central
    */
    private void checkZones(){
        boolean[] close = checkCloseZones();
        String msg = "Open zone(s): ";
        switch (state) {
            case ALL_ARMED -> {
                //zona 0,1 y 2
                msg += (!close[0]?"0":"-") + (!close[1]?",1":"");
                if (close[0] && close[1]){
                    view.setDisplay("There's no Doméstico :D");
                    siren.stop();
                }
                else {
                    siren.play();
                    view.setDisplay(msg);
                }
            }
            case PERIMETER_ARMED -> {
                //zona 0 y 1
                //Etapa4
            }
        }
    }
    /**
    * Función que verifica si las zonas están cerradas
    * @return un boolean que indica si están cerradas
    */
    private boolean[] checkCloseZones() {
        boolean[] close = {true, true, true};
        for (Sensor sensor : zones) {
            close[sensor.getZone()] &= sensor.isClose();
        }
        return close;
    }
    /**
    * Función para armar todas las zonas de la central
    */
    public void armAll() {
        boolean[] close = checkCloseZones();
        String msg = "Open zone(s): ";
        msg += (!close[0]?"0":"-") + (!close[1]?",1":"");
        if(close[0] && close[1]) {
            state = CentralState.ALL_ARMED;
            view.setDisplay("Perimeter is armed!");
        }
        else{
            view.setDisplay(msg);
        }
    }
    /**
    * Función para desarmar la alarma
    */
    public void disarm() {
        state = CentralState.DISARMED;
        view.setDisplay("Alarm was disarmed!");
    }
    /**
    * Función para agregar un sensor a la zona
    * @param s Es el sensor a agregar
    */
    public void addNewSensor(Sensor s){
        zones.add(s);
    }
    /**
    * Función para agregar una persona a la zona
    * @param p Es la persona a agregar
    */
    public void addNewPerson(Person p){
        people.add(p);
    }
    /**
    * Función para comprobar el estado de la alarma, si está armada o desarmada
    */
    enum CentralState {
        ALL_ARMED, PERIMETER_ARMED, DISARMED
    }
}
