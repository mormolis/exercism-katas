class Triangle {

    private double side1;
    private double side2;
    private double side3;

    Triangle(double side1, double side2, double side3) throws TriangleException {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        if (!isTriangle()){
            throw new TriangleException();
        }
    }

    boolean isEquilateral() {
        return side1 == side2 && side2 == side3;
    }

    boolean isIsosceles() {
        return  side1 == side2 || side1 == side3 || side2 == side3;
    }

    boolean isScalene() {
        return side1 != side2 && side1 !=side3 && side3 != side2;
    }

    private boolean isTriangle(){
        return isSidesGreaterThan0() && sumOfTheTwoAreGreaterOrEqualToTheThird() ;
    }

    private boolean isSidesGreaterThan0() {
        return side1 > 0 && side2 > 0 && side3 > 0;
    }

    private boolean sumOfTheTwoAreGreaterOrEqualToTheThird(){
        double sum12 = side1 + side2;
        double sum13 = side1 + side3;
        double sum23 = side2 + side3;

        return sum12 >= side3 && sum13 >= side2 && sum23 >= side1;
    }

}
