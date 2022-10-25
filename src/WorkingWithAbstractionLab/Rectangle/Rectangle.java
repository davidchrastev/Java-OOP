package WorkingWithAbstractionLab.Rectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public void setTopRight(Point topRight) {
        this.topRight = topRight;
    }

    public boolean contains (Point point) {
        //проверка дали е вътре спрямо Х
        boolean isInsideX = point.getX() >= bottomLeft.getX() && point.getX() <= topRight.getX();
        //проверка дали е вътре спрямо У
        boolean isInsideY = point.getY() >= bottomLeft.getY() && point.getY() <= topRight.getY();
        //ако двете проверки са true ,значи нашата точка влиза в правоъгълника
        return isInsideX && isInsideY;
    }
}
