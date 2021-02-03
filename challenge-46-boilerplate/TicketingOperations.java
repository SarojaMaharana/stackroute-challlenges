import java.util.Collections;
import java.util.List;

public class TicketingOperations {
    public static void main(String[] args) {
        RoutesReader rr = new RoutesReader("sample.csv");
        List<Route> routeList = rr.getRouteList();

        Collections.sort(routeList, (o1, o2) -> {
            return o1.getRoute_no().compareTo(o2.getRoute_no());
        });

        routeList.forEach(r -> System.out.println(r.getSchedule_no()+", "+r.getRoute_no()+", "+r.getTicket_from_stop_id()+", "+r.getTicket_from_stop_seq_no()+", "+r.getTicket_till_stop_id()+", "+r.getTicket_till_stop_seq_no()+", "+r.getTicket_date()+", "+r.getTicket_time()+", "+r.getTotal_ticket_amount()+", "+r.getTravelled_KM()));
        System.out.println();
        AvgTotalTicketAmount atta = (rList) -> {
            float total = 0f;
            for(Route r:rList)
                total = total + r.getTotal_ticket_amount();
            return (total/rList.size());
        };
        System.out.println("The average of total ammount collected is: "+atta.avgTotalTicketAmount(routeList));
    }
}
