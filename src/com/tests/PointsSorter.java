package com.tests;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PointsSorter {

    public static void main(String[] args) {


        ArrayList<Point> listOfPoints = new ArrayList<>();

        listOfPoints.add(new Point(8, 2));
        listOfPoints.add(new Point(2, 7));
        listOfPoints.add(new Point(9, 10));
        listOfPoints.add(new Point(11, 6));
        listOfPoints.add(new Point(4, 3));
        listOfPoints.add(new Point(7, 7));
        listOfPoints.add(new Point(13, 4));
        listOfPoints.add(new Point(2, 2));
        listOfPoints.add(new Point(1, 8));

        // Sort list through Comparator with <Point> type
        Collections.sort(listOfPoints, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {

                // Sort by X value
                int compereX = p1.getX().compareTo(p2.getX());

                // If X values are different, return smaller value
                if (compereX != 0)
                    return compereX;
                // If X values are the same, sort by Y
                else {
                    //return smaller value of Y
                    return p1.getY().compareTo(p2.getY());
                }
            }
        });

        for (Point listOfPoint : listOfPoints) {
            System.out.println(listOfPoint.getX() + " : " + listOfPoint.getY());
        }
    }

    private static class Point {

        private Integer x;
        private Integer y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Integer getX() {
            return x;
        }

        public Integer getY() {
            return y;
        }
    }

}
