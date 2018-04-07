package codemo.iroads_mobile.Reorientation;

import android.widget.TextView;

/**
 * Created by Pivithuru 26/03/2018.
 */

public class NericellMechanism implements Reorientation{

    //private double teta;
    //private double pie;
    private boolean stable = true;

    @Override
    public void reorient() {

        //accelerometer xyx
        TextView xValueA, yValueA, zValueA;

    }

    public double teta(double y){
        double teta = Math.acos(y/9.800); // gravity is taken as 9.8 m/s2
        return teta;
    }

    public double pie(double x, double z){
        double pie = Math.atan(z/x);
        return pie;
    }

    public void setStable(boolean stable) {
        this.stable = stable;
    }

    public double reOrientX (double x, double y, double z) {
        double teta = 0;
        double pie = 0;
        if (this.stable) {
            teta = this.teta(y);
            pie = this.pie(x, z);
            //this.setStable(false);
        }
        double xPie = x*Math.cos(pie) - z*Math.sin(pie);
        double yPie = y;
        double zPie = x*Math.sin(pie) + z*Math.cos(pie);
        double xTeta = xPie*Math.cos(teta) + yPie*Math.sin(teta);
        double zTeta = zPie;
        double alpha = Math.atan(xPie/zPie);
        double xAplha = xTeta*Math.cos(alpha) - zTeta*Math.sin(alpha);
        return xAplha;
    }

    public double reOrientY (double x, double y, double z) {
        double teta = 0;
        double pie = 0;
        if (this.stable) { // calculate teta and pie if vehicle is stopped.
            teta = this.teta(y);
            pie = this.pie(x, z);
            //this.setStable(false);
        }
        double xPie = x*Math.cos(pie) - z*Math.sin(pie);
        double yPie = y;
        double yTeta = -xPie*Math.sin(teta) + yPie*Math.cos(teta);
        return yTeta;

    }

    public double reorientZ (double x, double y, double z) {
        double teta = 0;
        double pie = 0;
        if (this.stable) {
            teta = this.teta(y);
            pie = this.pie(x, z);
            //this.setStable(false);
        }
        double xPie = x*Math.cos(pie) - z*Math.sin(pie);
        double yPie = y;
        double zPie = x*Math.sin(pie) + z*Math.cos(pie);
        double xTeta = xPie*Math.cos(teta) + yPie*Math.sin(teta);
        double zTeta = zPie;
        double alpha = Math.atan(xPie/zPie);
        double zAlpha = xTeta*Math.sin(alpha) + zTeta*Math.cos(alpha);
        return zAlpha;

    }
}
