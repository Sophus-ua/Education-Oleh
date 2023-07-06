package Lesson_8_Class_Object.Task_2_3_4;

class Monitor extends Device{
    private final int resolutionX, resolutionY;
    Monitor (String manufacturer, float price, String serialNumber, int resolutionX, int resolutionY){
        super(manufacturer,price,serialNumber);
        this.resolutionX = resolutionX;
        this.resolutionY = resolutionY;
    }
    public int getResolutionX() {
        return resolutionX;
    }
    public int getResolutionY() {
        return resolutionY;
    }

    @Override
    public String toString (){
        return super.toString().replaceFirst("Device:", "Monitor:") + String.format(", X= %d, Y= %d", getResolutionX(), getResolutionY());
    }

    @Override
    public boolean equals (Object obj){
        if (this == obj) return  true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return  false;
        Monitor monitor = (Monitor) obj;
        if (resolutionX != monitor.resolutionX) return false;
        return resolutionY == monitor.resolutionY;
    }

    @Override
    public int hashCode (){
        int result = super.hashCode();
        result = 37 * result + resolutionX;
        result = 37 * result + resolutionY;
        return result;
    }
}
