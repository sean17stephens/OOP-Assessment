package dto;

public class VaccineAppointment {
    private int user_id;
    private String centre_id;
    private String appointment_time;

    public VaccineAppointment(int user_id, String centre_id, String appointment_time) {
        this.user_id = user_id;
        this.centre_id = centre_id;
        this.appointment_time = appointment_time;

    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCentre_id() {
        return centre_id;
    }

    public void setCentre_id(String centre_id) {
        this.centre_id = centre_id;
    }

    public String getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(String appointment_time) {
        this.appointment_time = appointment_time;
    }

    @Override
    public String toString() {
        return "VaccineAppointment{" +
                "user_id=" + user_id +
                ", centre_id='" + centre_id + '\'' +
                ", appointment_time='" + appointment_time + '\'' +
                '}';
    }
}
