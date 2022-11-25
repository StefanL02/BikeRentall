package Pro;

import java.io.Serializable;

public class Staff implements Serializable {


   private String PPS;
   private String staffName;
   private String staffSurname;
   private String phone;
   private String gender;
   private String jobType;

  public Staff(String PPS, String staffName, String staffSurname, String phone, String gender, String jobType){

    setPPS(PPS);
    setStaffName(staffName);
    setStaffSurname(staffSurname);
    setPhone(phone);
    setGender(gender);
    setJobType(jobType);


  }


    public String getPPS() {
        return PPS;
    }

    public void setPPS(String PPS) {
        this.PPS = PPS;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffSurname() {
        return staffSurname;
    }

    public void setStaffSurname(String staffSurname) {
        this.staffSurname = staffSurname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String toString(){

      return  "\nPPS " + getPPS() +
              "\nName: "  + getStaffName() +
              "\nSurname: " + getStaffSurname() +
              "\nPhone: " + getPhone() +
              "\nGender: " + getGender() +
              "\nJob Type: " + getJobType();
    }
}
