

public class ParkingSpot {
    public String spotId;
    private boolean isOccupied;
    public Ticket ticket;
    VehicleType vehicleType;

    public ParkingSpot(VehicleType type){
        this.spotId = UUIDGenerator.generate();
        this.isOccupied = false;
        this.vehicleType = type;
    }

    public ParkingSpot checkAndReserve(VehicleType vehicleType) {
        if(!this.isOccupied && this.vehicleType == vehicleType){
            this.isOccupied = true;
            return this;
        }
        return null;
    }

    public void unpark() {
        this.isOccupied = false;
    }

    public String getId(){
        return this.spotId;
    }

}