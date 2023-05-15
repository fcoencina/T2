/**
*  Clase Sensor magnético
*/
public class MagneticSensor extends Sensor {
    private final MagneticSensorView view;
    /**
    * Constructo de la clase Sensor magnético
    */
    public MagneticSensor(int z){
        super(z);
        view = new MagneticSensorView();
    }
    /**
    * Función colocar el sensor en modo abierto 
    */
    public void setSensorOpen() {
        setClose(false);
    }
     /**
    * Función colocar el sensor en modo cerrado 
    */
    public void setSensorClose() {
        setClose(true);
    }
    /**
    * Función obtener la vista del sensor magnético
    * @return Vista del sensor magnético
    */
    public MagneticSensorView getView(){ return view;}
}
