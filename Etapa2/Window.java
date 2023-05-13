/**
 * A window with its magnetic sensor.
 */
public class Window {
    private final WindowView wView;
    private final MagneticSensor magneticSensor;
    private State state;
    public Window(MagneticSensor sensor, WindowView view) {
        magneticSensor = sensor;
        state = State.CLOSE;
        wView = view;
        wView.addMagneticSensorView(magneticSensor.getView());
        wView.setWindowModel(this);
    }
    public void changeState() {  // is called when this window's view is clicked
        switch (state) {  // this is the enhanced version of switch statement. It does not require breaks.
            case OPEN, OPENING -> {
                state = State.CLOSE;
                magneticSensor.setSensorClose();
            }
            case CLOSE, CLOSING -> {
                state = State.OPEN;
                magneticSensor.setSensorOpen();
            }
        }
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
