//public class InterfaceTest {
//
//}
//interface Centered {
//    void setCenter(double x, double y);
//    double getCenterX();
//    double getCenterY();
//}
//
//public class CenteredRectangle implements Centered {
//    // New instance fields
//    private double cx, cy;
//
//    // implementations of all the Centered methods.
//    public void setCenter (double x, double y) { cx = x;  cy = y; }
//    public double getCenterX()  { return cx; }
//    public double getCenterY()  { return cy; }
//}
//
//interface Positionable extends Centered {
//    void setUpperRightCorner(double x, double y);
//    double getUpperRightX();
//    double getUpperRightY();
//}
//
//interface Transformable extends Scalable, Translatable, Rotatable {}
//interface SuperShape extends Positionable, Transformable {}
//
//public class CenteredRectangle extends Rectangle implements Centered {
//		...   inherit
//		...   implement
//}