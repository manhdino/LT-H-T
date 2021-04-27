public class longTermTeacher extends teacher {
    private double basicPayment;

    public longTermTeacher(String name, String phoneNumber, int startYear, String specialUnit, double basicPayment) {
        super(name, phoneNumber, startYear, specialUnit);
        this.basicPayment = basicPayment;
    }

    public double getBasicPayment() {
        return basicPayment;
    }

    public void setBasicPayment(double basicPayment) {
        this.basicPayment = basicPayment;
    }

    public double salary(){
        return 3000000*basicPayment;
    }
}
