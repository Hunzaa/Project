public class Appointment {

    //1. private variables
    private int appNo;      // appointment number
    private int id;         // patient id
    private Date appDate;   //appointment date

    //no-argument constructor
    public Appointment()
    {
        appNo = 0;
        id = 0;
        //appDate = 2018/01/01;
    }

    //3. argument constructor
    public Appointment(int appNo, int id, Date appDate) {
        this.appNo = appNo;
        this.id = id;
        this.appDate = appDate;
    }


    //4. getters
    public int getAppNo() { return appNo; }
    public int getId() { return id; }
    public Date getAppDate() { return appDate; }

    //5. setters
    public void setAppNo(int appNo) { this.appNo = appNo; }
    public void setId(int id) { this.id = id; }
    public void setAppDate(Date appDate) { this.appDate = appDate; }

    //6. toString
    @Override
    public String toString() {
        return "Appointment{" +
                "appNo=" + appNo +
                ", id=" + id +
                ", appDate=" + appDate +
                '}';
    }
}
