import java.time.LocalDate;

public class teacher {
    private String name;
    private String phoneNumber;
    private int startYear;
    private String specialUnit;

    public String getSpecialUnit() {
        return specialUnit;
    }

    public void setSpecialUnit(String specialUnit) {
        this.specialUnit = specialUnit;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public teacher(String name, String phoneNumber, int startYear, String specialUnit) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.startYear = startYear;
        this.specialUnit = specialUnit;
    }

}
