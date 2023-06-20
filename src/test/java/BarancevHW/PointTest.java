package BarancevHW;


import org.junit.Assert;
import org.junit.Test;

public class PointTest {
@Test
    public void getSqrtPoint(){
    Point a = new Point(20,30);
    Point b = new Point(70,50);
    Assert.assertEquals(53.851,Point.distance(a,b),0.001);
}
}
