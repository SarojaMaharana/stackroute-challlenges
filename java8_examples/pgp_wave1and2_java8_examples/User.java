public class User {
    int mobileNo;
    String name;
    boolean active;
    boolean dndEnabled;
    String sms;

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDndEnabled() {
        return dndEnabled;
    }

    public void setDndEnabled(boolean dndEnabled) {
        this.dndEnabled = dndEnabled;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public User(int mobileNo, String name, boolean active, boolean dndEnabled) {
        this.mobileNo = mobileNo;
        this.name = name;
        this.active = active;
        this.dndEnabled = dndEnabled;
    }
    

}
