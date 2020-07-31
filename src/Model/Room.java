package Model;

import java.util.Date;

public class Room {
    private int RoomId, pricePerDay, accountId, numberOfBeds;
    private Date startDate, endDate;
    private String img;
    private boolean wifi, tv, hotWater;

    public Room(int id, Date sDate, Date eData, int pricePerDay, String img, int accountId,
                int numberOfBeds, boolean wifi, boolean tv, boolean hotWater) {
        this.RoomId = id;
        this.accountId = accountId;
        startDate = sDate;
        endDate = eData;
        this.img = img;
        this.pricePerDay = pricePerDay;
        this.numberOfBeds = numberOfBeds;
        this.wifi = wifi;
        this.tv = tv;
        this.hotWater = hotWater;
    }

    public int getRoomId() {
        return RoomId;
    }

    public void setRoomId(int roomId) {
        RoomId = roomId;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isHotWater() {
        return hotWater;
    }

    public void setHotWater(boolean hotWater) {
        this.hotWater = hotWater;
    }

    @Override
    public String toString() {
        return "Room{" +
                "RoomId=" + RoomId +
                ", pricePerDay=" + pricePerDay +
                ", accountId=" + accountId +
                ", numberOfBeds=" + numberOfBeds +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", img='" + img + '\'' +
                ", wifi=" + wifi +
                ", tv=" + tv +
                ", hotWater=" + hotWater +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Room)) return false;
        Room second = (Room) obj;
        return this.toString().equals(second.toString());
    }
}