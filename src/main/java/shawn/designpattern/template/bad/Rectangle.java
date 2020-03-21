package shawn.designpattern.template.bad;

public abstract class Rectangle {

    abstract void setHeight(int height);
    abstract void setWidth(int width);
    abstract int getHeight();
    abstract int getWidth();

    int getArea() {
        return getHeight() * getWidth();
    }
}

class Square extends Rectangle {

    private int length;

    @Override
    void setHeight(int height) {
        this.length = height;
    }

    @Override
    void setWidth(int width) {
        this.length = width;
    }

    @Override
    int getHeight() {
        return this.length;
    }

    @Override
    int getWidth() {
        return this.length;
    }
}