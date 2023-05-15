/**
* clase para las puertas
*/
public class Door {
    private final DoorView dView;
    private final MagneticSensor magneticSensor;
    private State state;
    /**
    * Constructor de la clase puerta, crea puertas
    * @param sensor Es el sensor magnetico que tiene la puerta
    * @param view Es la vista gráfica de la puerta
    */
    public Door(MagneticSensor sensor, DoorView view) {
        magneticSensor = sensor;
        state = State.CLOSE;
        dView = view;
        dView.addMagneticSensorView(magneticSensor.getView());
        dView.setDoorModel(this);
    }
    /**
    * Función para cambiar el estado de la puerta, entre abierta y cerrada
    */
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
    /**
    * Función para obtener el estado de la puerta, entre abierta y cerrada
    */
    public State getState() {
        return state;
    }
}
