public class Person {
    private final PersonView pView;
    private double x;
    private double y;
    public Person(){
        x = 50;
        y = 50;
        pView = new PersonView(x, y);
        pView.setPersonModel(this);
    }

    public PersonView getpView() {
        return pView;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
}
