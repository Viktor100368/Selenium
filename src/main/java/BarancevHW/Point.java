package BarancevHW;

public class Point {
    private int x;
    private int y;
    Point(int x,int y){
        this.x=x;
        this.y=y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public static double distance(Point p1,Point p2){
        int a= p2.x-p1.x;
        int b= p2.y-p1.y;
        return (Math.sqrt(a*a + b*b));
    }
}
