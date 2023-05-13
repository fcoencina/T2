public class Door {
    private final DoorView dView;
    private final MagneticSensor magneticSensor;
    private State state;
    public Door(MagneticSensor sensor, DoorView view) {
        magneticSensor = sensor;
        state = State.CLOSE;
        dView = view;
        dView.addMagneticSensorView(magneticSensor.getView());
        dView.setDoorModel(this);
    }
    public void changeState() {
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
    public State getState() {
        return state;
    }
}