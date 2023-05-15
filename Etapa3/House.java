import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.Scanner;

/**
* Clase casa
*/
public class House extends Pane {
    /**
    * Constructor de la clase casa
    * @param in Inpur del usuario para la creación de la clase
    * @param central Central que tendrá la casa
    */
    public House(Scanner in, Central central) {
        // reading <#_doors> <#_windows> <#_PIRs>
        int numDoors = in.nextInt();
        int numWindows = in.nextInt();
        int numPirs = in.nextInt(); // just to conform the first line format
        for (int i = 0; i < numDoors; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            int angle = in.nextInt();
            int zone = in.nextInt();
            DoorView doorView= new DoorView(x, y, angle);
            MagneticSensor sensor = new MagneticSensor(zone);
            central.addNewSensor(sensor);
            new Door(sensor, doorView);
            getChildren().add(doorView);
        }
        for (int i = 0; i < numWindows; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            int angle = in.nextInt();
            int zone = in.nextInt();
            WindowView windowView= new WindowView(x, y, angle);
            MagneticSensor sensor = new MagneticSensor(zone);
            central.addNewSensor(sensor);
            new Window(sensor, windowView);
            getChildren().add(windowView);
        }
        for (int i = 0; i < numPirs; i++){
            double x = Double.parseDouble(in.next());
            double y = Double.parseDouble(in.next());
            int direction_angle = in.nextInt();
            int sensing_angle = in.nextInt();
            int sensing_range = in.nextInt();
            int zone = in.nextInt();
            PIR_Detector sensor = new PIR_Detector(x, y, direction_angle, sensing_angle, sensing_range, zone);
            central.addNewSensor(sensor);
            getChildren().add(sensor.getpView());
        }
        setMinWidth(700);
    }
}
