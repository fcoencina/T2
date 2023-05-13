import javafx.animation.Timeline;

public class PIR_Detector extends Sensor{
    private final PIR_DetectorView pView;
    private double x;
    private double y;
    private int direction_angle;
    private int sensing_angle;
    private int sensing_range;
    private int zone;
    public PIR_Detector(double x, double y, int direction_angle, int sensing_angle, int sensing_range, int zone){
        super(zone);
        this.x = x;
        this.y = y;
        this.direction_angle = direction_angle;
        this.sensing_angle = sensing_angle;
        this.sensing_range = sensing_range;
        pView = new PIR_DetectorView(this.x, this.y, this.direction_angle);
    }
    public void checkZone(){
        System.out.println("All good");
    }
    public PIR_DetectorView getpView() {
        return pView;
    }
}
