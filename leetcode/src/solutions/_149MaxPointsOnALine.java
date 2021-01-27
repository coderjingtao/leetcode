package solutions;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * NO.149 Max Points on a Line
 * Keywords:   HashMap, Math
 * Difficulty: Hard
 * Company:    Linkedin, Apple
 */
public class _149MaxPointsOnALine {
    /**
     * Thought: 三个点在一条直线上的前提是斜率一致
     * 遍历每一个点，求一下这个点到其余所有点到这个点的斜率，并存储到map中：<slope: frequency>
     * 再比较每一个点频率的最大值，就是最后的结果
     * 注意：会出现重复点位，例如[1,1],[1,1]
     */
    public int maxPoints(Point[] points) {
        if(points.length == 0 )
            return 0;
        if(points.length == 1 )
            return 1;
        if(points.length == 2)
            return 2;
        int res = 0;

        for(int i = 0; i < points.length; i++){
            //1. create a lookup table for each point
            Map<Double,Integer> map = new HashMap<Double,Integer>();
            int repetition = 0; //针对每个点记录重复的数量
            for(int j = 0; j < points.length; j++){
                if(j != i){
                    //重复点
                    if(points[i].x==points[j].x && points[i].y==points[j].y){
                        repetition++;
                    }else{
                        double slope = slopeRate2(points[i],points[j]);
                        int freq = map.getOrDefault(slope, 0);
                        map.put(slope, freq+1);
                    }
                }
            }
            //2. search the maximum from the created table, +1 include the original point
            if(map.isEmpty())
                res = repetition;
            else
                res = Math.max(res, Collections.max(map.values()) + repetition);
        }
        return res+1;
    }

    private double slopeRate(Point a, Point b){
//    	if(a.x == b.x)
//    		return (Double) null;
//    	else
//    		return (double)(a.y - b.y) / (double)(a.x - b.x); //注意精度丢失问题，必须写两个double
        return Math.atan2(b.y-a.y, b.x-a.x); //不能判断重复点位
    }

    //解决Math.atan2丢失精度问题
    private double slopeRate2(Point a, Point b){
        if(a.x == b.x)
            return Math.atan2(b.y-a.y, b.x-a.x);
        else{
            BigDecimal b1 = new BigDecimal(Double.toString(b.y-a.y));
            BigDecimal b2 = new BigDecimal(Double.toString(b.x-a.x));
            return b1.divide(b2, 16, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
    }

    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    private Point createOnePoint(int x, int y){
        Point point = new Point(x,y);
        return point;
    }

    public static void main(String[] args) {
        _149MaxPointsOnALine m = new _149MaxPointsOnALine();
        //Point a = new Point(1,1); 静态内部类才可以这样调用

        // case 1:
//		Point a = m.createOnePoint(0,0);
//		Point b = m.createOnePoint(0,0);
//		Point c = m.createOnePoint(0,0);
//		Point d = m.createOnePoint(0,0);
//		Point[] points = new Point[]{ a,b,c,d };
//		System.out.println(m.maxPoints(points));

        //case 2:
//		Point a = m.createOnePoint(0,0);
//		Point b = m.createOnePoint(1,1);
//		Point c = m.createOnePoint(0,0);
//		Point[] points = new Point[]{ a,c,b };
//		System.out.println(m.maxPoints(points));

        //case 3:
//		Point a = m.createOnePoint(0,0);
//		Point b = m.createOnePoint(1,1);
//		Point c = m.createOnePoint(0,0);
//		Point d = m.createOnePoint(1,1);
//		Point[] points = new Point[]{ a,b,c,d };
//		System.out.println(m.maxPoints(points));

        //case 4:
//		Point a = m.createOnePoint(1,1);
//		Point b = m.createOnePoint(3,2);
//		Point c = m.createOnePoint(5,3);
//		Point d = m.createOnePoint(4,1);
//		Point e = m.createOnePoint(2,3);
//		Point f = m.createOnePoint(1,4);
//		Point[] points = new Point[]{ a,b,c,d,e,f };
//		System.out.println(m.maxPoints(points));

        //case 5:
//		Point a = m.createOnePoint(1,1);
//		Point b = m.createOnePoint(2,2);
//		Point c = m.createOnePoint(3,3);
//		Point[] points = new Point[]{ a,b,c };
//		System.out.println(m.maxPoints(points));

        //case 6:
        Point a = m.createOnePoint(0,0);
        Point b = m.createOnePoint(94911151,94911150);
        Point c = m.createOnePoint(94911152,94911151);
        Point[] points = new Point[]{ a,b,c };
        System.out.println(m.maxPoints(points));

//		System.out.println(Math.atan2(94911150, 94911151));
//		System.out.println(Math.atan2(94911151, 94911152));
//
//		System.out.println( (double)(94911150) / (double)(94911151) );
//		System.out.println( (double)(94911151) / (double)(94911152) );
//
//		BigDecimal b1 = new BigDecimal(Double.toString(94911150));
//		BigDecimal b2 = new BigDecimal(Double.toString(94911151));
//		System.out.println( b1.divide(b2, 16, BigDecimal.ROUND_HALF_UP) );
//
//		BigDecimal b3 = new BigDecimal(Double.toString(94911151));
//		BigDecimal b4 = new BigDecimal(Double.toString(94911152));
//		System.out.println( b3.divide(b4, 16, BigDecimal.ROUND_HALF_UP) );
    }
}
