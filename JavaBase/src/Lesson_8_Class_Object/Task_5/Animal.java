package Lesson_8_Class_Object.Task_5;

class Animal {
    private String name;
    private int age;
    private final boolean tail;
    Animal (String name, int age, boolean tail){
        setName(name);
        setAge(age);
        this.tail = tail;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString (){
        String tailString;
        if (tail) tailString = "є";
        else tailString = "ні";
        return String.format("Ім'я: %s, вік: %d, хвіст: %s", this.name, this.age, tailString);
    }

    @Override
    public boolean equals (Object obj){
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Animal check = (Animal)obj;
        if (name == null){if(check.name != null) return false;
        } else if (!name.equals(check.name)) return  false;
        if (age != check.age) return false;
        return tail == check.tail;
    }

    @Override
    public int hashCode (){
        int result = 17;
        result = 31 * result + (name == null ? 0 : name.hashCode());
        result = 31 * result + age;
        result = 31 * result + (tail ? 1 : 0);
        return result;
    }
}
