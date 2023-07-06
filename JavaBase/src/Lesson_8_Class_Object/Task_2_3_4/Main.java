package Lesson_8_Class_Object.Task_2_3_4;

public class Main {
    public static void main(String[] args) {
        Device mikrotik = new EthernetAdapter("MikroTik", 30,"CD1257LM",  820, "00-aa-00-64-c8-09");
        System.out.println(mikrotik);

        Device device = new Device("Samsung",120,"AB1234567CD");
        System.out.println(device);

        Device monitor = new Monitor("Samsung",120,"AB1234567CD",1280,1024);
        System.out.println(monitor);
        Monitor monitor2 = new Monitor("Samsung",120,"AB1234567CD",1280,1024);

        System.out.println("____________________________________________");
        System.out.println("Порівняння monitor і device : " + monitor.equals(device));
        System.out.println("Порівняння monitor і monitor2 : " + monitor.equals(monitor2));
        System.out.println("device hashCode = " + device.hashCode());
        System.out.println("monitor hashCode = " + monitor.hashCode());
        System.out.println("monitor2 hashCode = " + monitor2.hashCode());
    }
}
