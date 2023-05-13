public class MagneticSensor extends Sensor {
    private final MagneticSensorView view;
    public MagneticSensor(int z){
        super(z);
        view = new MagneticSensorView();
    }
    public void setSensorOpen() {
        setClose(false);
    }
    public void setSensorClose() {
        setClose(true);
    }
    public MagneticSensorView getView(){ return view;}
}
