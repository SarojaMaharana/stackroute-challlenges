public class Route {
    private String schedule_no;
    private String route_no;
    private long ticket_from_stop_id;
    private int ticket_from_stop_seq_no;
    private long ticket_till_stop_id;
    private int ticket_till_stop_seq_no;
    private String ticket_date;
    private String ticket_time;
    private int total_ticket_amount;
    private float travelled_KM;

    public Route(String schedule_no, String route_no, long ticket_from_stop_id, int ticket_from_stop_seq_no,
            long ticket_till_stop_id, int ticket_till_stop_seq_no, String ticket_date, String ticket_time,
            int total_ticket_amount, float travelled_KM) {
        this.schedule_no = schedule_no;
        this.route_no = route_no;
        this.ticket_from_stop_id = ticket_from_stop_id;
        this.ticket_from_stop_seq_no = ticket_from_stop_seq_no;
        this.ticket_till_stop_id = ticket_till_stop_id;
        this.ticket_till_stop_seq_no = ticket_till_stop_seq_no;
        this.ticket_date = ticket_date;
        this.ticket_time = ticket_time;
        this.total_ticket_amount = total_ticket_amount;
        this.travelled_KM = travelled_KM;
    }

    public String getSchedule_no() {
        return schedule_no;
    }

    public String getRoute_no() {
        return route_no;
    }

    public long getTicket_from_stop_id() {
        return ticket_from_stop_id;
    }

    public int getTicket_from_stop_seq_no() {
        return ticket_from_stop_seq_no;
    }

    public long getTicket_till_stop_id() {
        return ticket_till_stop_id;
    }

    public int getTicket_till_stop_seq_no() {
        return ticket_till_stop_seq_no;
    }

    public String getTicket_date() {
        return ticket_date;
    }

    public String getTicket_time() {
        return ticket_time;
    }

    public int getTotal_ticket_amount() {
        return total_ticket_amount;
    }

    public float getTravelled_KM() {
        return travelled_KM;
    }

}
