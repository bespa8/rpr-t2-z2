package ba.unsa.etf.rpr.tutorijal02;

import org.jetbrains.annotations.NotNull;

public class Interval {
    double v,v1;
boolean b,b1;

    public Interval(double v, double v1, boolean b, boolean b1) {
        if (v>v1) throw new IllegalArgumentException("Pocetna tacka veca od krajnje");
        this.v = v;
        this.v1 = v1;
        this.b = b;
        this.b1 = b1;
    }
    public Interval(){
        v=0;
        v1=0;
        b=false;
        b1=false;
    }

    public static @NotNull
    Interval intersect(Interval i, Interval i2) {
    Interval temp = new Interval();
    if (i.v == i2.v) {
        temp.v = i.v;
        if (i.b && i2.b) temp.b = true;
        else temp.b = false;
    }
    if (i.v1 == i2.v1) {
        temp.v1 = i.v1;
        if (i.b1 && i2.b1) temp.b1 = true;
        else temp.b1 = false;
    }
    if (i.v > i2.v) {
        temp.v = i.v;
        temp.b = i.b;
    }
    else if (i.v < i2.v) {
        temp.v = i2.v;
        temp.b = i2.b;
    }
    if (i.v1 < i2.v1) {
        temp.v1 = i.v1;
        temp.b1 = i.b1;
    }
    else if (i.v1 > i2.v1) {
        temp.v1 = i2.v1;
        temp.b1 = i2.b1;
    }
    return temp;
    }

    public boolean isIn(double v) {

        if (this.v < v && v < v1) return true;
        if (this.v==v && !b) return false;
        if (this.v1==v && !b1) return false;
        if (this.v == v && b) return true;
        if (this.v1 == v && b1) return true;
        return false;
    }


    public boolean isNull() {
        if (v==0 && v1==0) return true;
        return false;
    }


    public Interval intersect(Interval interval) {
        Interval temp = new Interval();
        temp = Interval.intersect(this,interval);
        return temp;
    }

    @Override
    public String toString() {
        String s;
        if (this.isNull()) {
            return "()";
        }
        if (b && b1) {
            s = "[" + v + "," + v1 + "]";
        }
        else if (b && !b1) {
            s = "[" + v + "," + v1 + ")";
        }
        else if (!b && b1) {
            s = "(" + v + "," + v1 + "]";
        }
        else
            s = "(" + v + "," + v1 + ")";
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        Interval temp = (Interval)obj;
        if (v==temp.v && v1==temp.v1 && b == temp.b && b1 == temp.b1) return true;
        else return false;
    }
}
