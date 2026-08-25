
import java.util.List;
import java.util.ArrayList;

public class ParkingFloor {
    public int floorNo;
    public List<ParkingSpot> spots;

    public ParkingFloor(int floorNo){
        this.floorNo = floorNo;
        this.spots = new ArrayList<>();
    }

    public ParkingSpot reserveAvailableSpot(VehicleType vehicleType){
        for(ParkingSpot parkingSpot : spots) {
            if(parkingSpot.checkAndReserve(vehicleType) != null){
                return parkingSpot;
            }
        }
        return null;
    }

    public void addSpot(VehicleType type){
        ParkingSpot spot = new ParkingSpot(type);
        this.spots.add(spot);
    }
}