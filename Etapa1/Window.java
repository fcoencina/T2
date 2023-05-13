/**
 * A window with its magnetic sensor.
 */
public class Window {
    private final WindowView wView;
    private final MagneticSensor magneticSensor;
    private State state;
    public Window(int zone, WindowView view) {
        magneticSensor = new MagneticSensor(zone);
        state = State.CLOSE;
        wView = view;
        wView.addMagneticSensorView(magneticSensor.getView());
        wView.setWindowModel(this);
    }
    public void changeState(State state) {  // is called when this window's view is clicked
        this.state = state;
    }
    public void finishMovement() { // is called when this window ends closing or opening
        //....
    }
    public WindowView getView(){
        return wView;
    }
    public State getState() {
        return state;
    }
}
