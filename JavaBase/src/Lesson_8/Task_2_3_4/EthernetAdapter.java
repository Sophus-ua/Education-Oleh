package Lesson_8.Task_2_3_4;

class EthernetAdapter extends Device{
    private final int speed;
    private String mac;
    EthernetAdapter (String manufacturer,float price, String serialNumber,int speed, String mac){
        super(manufacturer,price,serialNumber);
        this.speed = speed;
        this.setMac(mac);
    }
    public int getSpeed() {
        return speed;
    }
    public void setMac(String mac){
        this.mac = mac;
    }
    public String getMac() {
        return mac;
    }

    @Override
    public String toString (){
        return super.toString().replaceFirst("Device:", "EthernetAdapter:") + String.format(", speed %d мб/с, MAC address %s", getSpeed(), getMac());
    }

    @Override
    public boolean equals (Object obj){
       if (this == obj) return true;
       if(obj == null || this.getClass() != obj.getClass()) return false;
       if(!super.equals(obj)) return false;
       EthernetAdapter adapter = (EthernetAdapter) obj;
       if (speed != adapter.speed) return false;
       if (mac == null ) {return adapter.mac == null;
       } else return mac.equals(adapter.mac);
    }

    @Override
    public int hashCode (){
        int result = super.hashCode();
        result = 37 * result + speed;
        result = 37 * result + (mac == null ? 0 : mac.hashCode());
        return result;
    }
}
