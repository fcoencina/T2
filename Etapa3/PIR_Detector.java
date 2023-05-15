import javafx.animation.Timeline;

public class PIR_Detector extends Sensor{
    private final PIR_DetectorView pView;
    private double x;
    private double y;
    private int direction_angle;
    private int sensing_angle;
    private int sensing_range;
    private int zone;
    /**
    * Constructor de detector PIR
    * @param x osición en el eje x del sensor
    * @param y Posición en el eje y del sensor
    * @param direction_angle Dirección del sensor
    * @param sensing_angle Ángulo de detección del sensor
    * @param sensing_range Rango de detección del sensor
    * @param zone Zona en la que esta el sensor 
    */
    public PIR_Detector(double x, double y, int direction_angle, int sensing_angle, int sensing_range, int zone){
        super(zone);
        this.x = x;
        this.y = y;
        this.direction_angle = direction_angle;
        this.sensing_angle = sensing_angle;
        this.sensing_range = sensing_range;
        pView = new PIR_DetectorView(this.x, this.y, this.direction_angle);
    }
    /**
    * Función para verificar zona
    */
    public void checkZone(){
        System.out.println("All good");
    }
    public PIR_DetectorView getpView() {
        return pView;
    }
}
