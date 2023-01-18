package com.tiennln.itwcdg;

/**
 * @author TienNLN on 18/01/2023
 */
public class Segment
{
    // r is radius
    public static Areas areas(double r, double a) {
        double inside = (Math.pow(r, 2)/2) * ((a * (Math.PI/180)) - Math.sin(a * (Math.PI/180)));

        double outside = (Math.PI * Math.pow(r, 2)) - inside;

        return new Areas(inside, outside);
    }

    public static class Areas {
        public final double inside, outside;

        public Areas(double inside, double outside) {
            this.inside = inside;
            this.outside = outside;
        }
    }

    public static void main(String[] args) {
        Areas areas = Segment.areas(10, 90);
        System.out.println("Areas: " + areas.inside + ", " + areas.outside);
    }
}