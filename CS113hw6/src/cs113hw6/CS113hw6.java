package cs113hw6;
import java.text.DecimalFormat;
/**
 *
 * @author mahigada
 */
public class CS113hw6 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Shapes3D shapes[]={new Cube(5),new Cylinder(3,5),new Sphere(7.0)};
for(int i=0;i<shapes.length;i++)
{
System.out.println(shapes[i]);
}
}
    }   
abstract class Shapes3D {
private final String name;
public Shapes3D(String name) {
super();
this.name = name;
}
public abstract double volume();
public abstract double surfaceArea();
@Override
public String toString() {
return "Name: " + name;
}
}
class Cube extends Shapes3D {
private double side;
public Cube(double side) {
super("Cube ");
this.side = side;
}
public double getSide() {
return side;
}
public void setSide(double side) {
this.side = side;
}
@Override
public double volume() {
return Math.pow(side,3);
}
@Override
public double surfaceArea() {
return  6 * Math.pow(side,2);
}
@Override
public String toString() {
return super.toString()+"Side: " + side + ", Surface area: "+surfaceArea()+", Volume: "+volume();
}
}    
class Cylinder extends Shapes3D {
private double radius;
private double height;
public Cylinder(double radius, double height) {
super("Cylinder ");
this.radius = radius;
this.height = height;
}
@Override
public double volume() {
return Math.PI*height*Math.pow(radius,2);
}
@Override
public double surfaceArea() {
return 2*Math.PI*radius*(radius+height);
}
@Override
public String toString() {
return super.toString()+"Radius: " + radius + ", Height: " + height + ", Surface area: "+surfaceArea()+", Volume: "+volume();
}
}
class Sphere extends Shapes3D {
private double radius;
public Sphere(double radius) {
super("Sphere ");
this.radius = radius;
}
@Override
public double volume() {
return (4/3)*Math.PI*Math.pow(radius,3);
}
@Override
public double surfaceArea() {
return 4*Math.PI*Math.pow(radius,2);
}
@Override
public String toString() {
return super.toString()+"Radius: " + radius + ", Surface area: "+surfaceArea()+", Volume: "+volume();
}
}