import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class ParkingLot {

    private List<ParkingFloor> floors;
    private Map<String, Ticket> tickets;

    public ParkingLot(){
        this.floors = new ArrayList<>();
        this.tickets = new HashMap<>();
    }

    public void addFloor(ParkingFloor floor){
        this.floors.add(floor);
    }

    public Ticket park(Vehicle vehicle){
        for(ParkingFloor floor : floors ){
            ParkingSpot spot = floor.reserveAvailableSpot(vehicle.getType());
            if(spot != null){
                Ticket ticket = new Ticket(spot, vehicle);
                spot.ticket = ticket;
                tickets.put(ticket.getId(), ticket);
                return ticket;
            }
        }
        return null;
    }

    public void unPark(String ticketId){
        Ticket ticket = tickets.get(ticketId);
        if(ticket != null){
            ParkingSpot spot = ticket.getSpot();
            spot.unpark();
            ticket.setExitTime();
            tickets.remove(ticketId);
        }
    }

}