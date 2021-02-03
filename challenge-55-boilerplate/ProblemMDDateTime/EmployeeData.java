import java.time.LocalDate;
import java.time.LocalTime;

public class EmployeeData {
    private String employeeName;
    private LocalDate workDate;
    private LocalTime loginTime;
    private LocalTime logoutTime;
    private int lunchTime;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getWorkDate() {
        return workDate;
    }

    public void setWorkDate(LocalDate workDate) {
        this.workDate = workDate;
    }

    public LocalTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalTime loginTime) {
        this.loginTime = loginTime;
    }

    public LocalTime getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(LocalTime logoutTime) {
        this.logoutTime = logoutTime;
    }

    public int getLunchTime() {
        return lunchTime;
    }

    public void setLunchTime(int lunchTime) {
        this.lunchTime = lunchTime;
    }

    public EmployeeData(String employeeName, LocalDate workDate, LocalTime loginTime, LocalTime logoutTime,
            int lunchTime) {
        this.employeeName = employeeName;
        this.workDate = workDate;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
        this.lunchTime = lunchTime;
    }

    @Override
    public String toString() {
        return "EmployeeData [employeeName=" + employeeName + ", loginTime=" + loginTime + ", logoutTime=" + logoutTime
                + ", lunchTime=" + lunchTime + ", workDate=" + workDate + "]";
    }
    
}
