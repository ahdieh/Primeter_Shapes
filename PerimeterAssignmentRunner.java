
import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int count = 0;
        for (Point currPt : s.getPoints()){
            count++;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        double averageLength;
        averageLength = getPerimeter(s) / getNumPoints(s);
        return averageLength;
    }

    public double getLargestSide(Shape s) {
        double largestDistance = 0;
        Point prevPt = s.getLastPoint();      
        for (Point currPt : s.getPoints()) {             
            double currDist = prevPt.distance(currPt);            
            if (currDist > largestDistance) largestDistance = currDist;
            prevPt = currPt;
        }
        return largestDistance;
    }

    public double getLargestX(Shape s) {
        double largestX = 0;
        Point prevPt = s.getLastPoint();      
        for (Point currPt : s.getPoints()) {   
            if (currPt.getX() > largestX) largestX = currPt.getX();
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        double largestPerimeter = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double primeter = getPerimeter(s);
            if (primeter > largestPerimeter) 
                largestPerimeter = primeter;
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        double largestPerimeter = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if (getPerimeter(s) > largestPerimeter){ 
                largestPerimeter = getPerimeter(s);
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.println("This shape has " + getNumPoints(s) + " points.");
        System.out.println("The average of the length of all sides of the " + 
        "shape = " + getAverageLength(s));
        System.out.println("The longest side of the shape = " + 
        getLargestSide(s));
        System.out.println("The largest x of the points in the shape s = " + 
        getLargestX(s));
    }
    
    public void testPerimeterMultipleFiles() {
        double largestPrimeter = getLargestPerimeterMultipleFiles();
        System.out.println("The largest primeter = " + largestPrimeter);          
    }

    public void testFileWithLargestPerimeter() {
        String fileName = getFileWithLargestPerimeter();
        System.out.println("The file with the largest perimeter = " + fileName);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        //pr.testPerimeterMultipleFiles();
        //pr.testFileWithLargestPerimeter();
        System.out.println();
    }
}
