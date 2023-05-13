import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PersonView extends Circle {
    private Person personModel;
    public PersonView(double x, double y){
        this.setCenterX(x);
        this.setCenterY(y);
        this.setRadius(10);
        this.setFill(Color.BROWN);
        this.setStrokeWidth(2);
        this.setStroke(Color.BLACK);
    }
    public void setPersonModel(Person model) {
        personModel = model;
        this.setOnMousePressed(event -> {
            //// Al presionar el ratón, guardamos la posición inicial
            this.setUserData(new double[]{event.getSceneX(), event.getSceneY()});
        });
        this.setOnMouseDragged(event -> {
            // Al arrastrar el ratón, calculamos la diferencia de posición y movemos
            double[] data = (double[]) this.getUserData();
            double offsetX = event.getSceneX() - data[0];
            double offsetY = event.getSceneY() - data[1];
            this.setLayoutX(this.getLayoutX() + offsetX);
            this.setLayoutY(this.getLayoutY() + offsetY);
            this.setUserData(new double[]{event.getSceneX(), event.getSceneY()});
        });
    }
}
