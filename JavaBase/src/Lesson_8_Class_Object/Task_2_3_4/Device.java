package Lesson_8_Class_Object.Task_2_3_4;

class Device {
    private final String manufacturer, serialNumber;
    private float price;
    Device (String manufacturer, float price, String serialNumber){
        this.manufacturer = manufacturer;
        this.serialNumber = serialNumber;
        this.setPrice(price);
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public String getSerialNumber() {
        return serialNumber;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return String.format("Device: manufacturer = %s, price = %.0f, serialNumber = %s", getManufacturer(), getPrice(), getSerialNumber());
    }
    @Override
    public boolean equals (Object obj){
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Device device = (Device) obj;
        if(this.manufacturer == null){if(device.manufacturer != null) return false;
        }else if (!manufacturer.equals(device.manufacturer)) return false;
        if(this.serialNumber == null){if(device.serialNumber != null) return false;
        }else if (!serialNumber.equals(device.serialNumber)) return false;
        return price == device.price;
    }
    @Override
    public int hashCode (){
        int result = 17;
        result = 37 * result + (manufacturer == null ? 0 : manufacturer.hashCode());
        result = 37 * result + (serialNumber == null ? 0 : serialNumber.hashCode());
        result = 37 * result + Float.floatToIntBits(price);
        return result;
    }
}
