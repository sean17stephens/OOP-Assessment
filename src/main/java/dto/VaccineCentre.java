//Sean Stephens D00211442
package dto;

public class VaccineCentre {
    private String centre_id;
    private String location;

    public VaccineCentre(String centre_id, String location){
        this.centre_id = centre_id;
        this.location = location;

    }

    public String getCentre_id() {
        return centre_id;
    }

    public void setCentre_id(String centre_id) {
        this.centre_id = centre_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "VaccineCentre{" +
                "centre_id='" + centre_id + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
