
public class Ticket {

    public String ticketId;
    public ParkingSpot spot;
    public Vehicle vehicle;
    private long entryTime;
    private long exitTime;

    public Ticket(ParkingSpot spot, Vehicle vehicle){
        this.spot = spot;
        this.vehicle = vehicle;
        this.entryTime = System.currentTimeMillis();
        this.ticketId = UUIDGenerator.generate();
    }

    public void setExitTime(){
        this.exitTime = System.currentTimeMillis();
    }

    public String getId(){
        return this.ticketId;
    }

    public ParkingSpot getSpot(){
        return this.spot;
    }

}