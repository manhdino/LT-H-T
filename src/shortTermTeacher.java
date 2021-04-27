public class shortTermTeacher extends teacher {
    private double teachingTime;
    public double salary(){
        return 1000000 + 500000*teachingTime;
    }

    public shortTermTeacher(String name, String phoneNumber, int startYear, String specialUnit, double teachingTime) {
        super(name, phoneNumber, startYear, specialUnit);
        this.teachingTime = teachingTime;
    }

    public void setTeachingTime(double teachingTime) {
        this.teachingTime = teachingTime;
    }

    public double getTeachingTime() {
        return teachingTime;
    }

    public void setTeachingTime(int teachingTime) {
        this.teachingTime = teachingTime;
    }
}
