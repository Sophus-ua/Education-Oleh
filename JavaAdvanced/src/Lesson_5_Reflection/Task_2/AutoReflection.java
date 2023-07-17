package Lesson_5_Reflection.Task_2;

import java.lang.reflect.*;

public class AutoReflection {
    Class<?> reflectionLink;
    public AutoReflection (String nameOfClass) throws ClassNotFoundException {
        reflectionLink = Class.forName(nameOfClass);
    }
    public void modifiersShow() throws NullPointerException {
        System.out.print("\033[0;35mМодифікатори класу\033[0m \033[0;97m" + reflectionLink.getName() + "\033[0m:");

        String message = "\033[1;33m";
        int modifiers = reflectionLink.getModifiers();
        if (Modifier.isAbstract(modifiers)){
            message += " abstract";
        }
        if (Modifier.isFinal(modifiers)){
            message += " final";
        }
        if (Modifier.isInterface(modifiers)){
            message += " interface";
        }
        if (Modifier.isStatic(modifiers)){
            message += " static";
        }
        if (Modifier.isPrivate(modifiers)){
            message += " private";
        }
        if (Modifier.isProtected(modifiers)){
            message += " protected";
        }
        if (Modifier.isPublic(modifiers)){
            message += " public";
        }
        System.out.println(message + "\033[0m;");
    }
    public void fieldsShow() throws NullPointerException {
        System.out.println("\033[4;35mПоля в класі:\033[0m");
        Field[] fields = reflectionLink.getDeclaredFields();
        for(Field temp : fields){
            System.out.println("\tІм'я поля: \033[0;97m" + temp.getName() + "\033[0m тип: \033[0;97m" + temp.getType().getName() +";\033[0m");
        }
    }
    public void constructorsShow() throws NullPointerException {
        System.out.println("\033[4;35mСписок конструкторів:\033[0m");
        Constructor<?>[] constructors = reflectionLink.getDeclaredConstructors();
        int i = 0;
        for(Constructor<?> constructor : constructors) {
            System.out.print("\t"+ ++i + "-ий конструктор в классі приймає параметр(и) типу(ів):");
            Parameter[] parameters = constructor.getParameters();
            if (parameters.length == 0) System.out.print(" \033[0;97mбез параметрів;\033[0m");
            for (Parameter parameter : parameters) {
                System.out.print("\033[0;97m " + parameter.getType().getName() + ";\033[0m");
            }
            System.out.println();
        }
    }
    public void methodsShow() throws NullPointerException {
        System.out.println("\033[4;35mСписок методів в класі:\033[0m");
        Method[] methods = reflectionLink.getDeclaredMethods();
        for(Method method : methods){
            System.out.println("\tМетод \033[0;93m" + method.getName() + "\033[0m:");
            System.out.println("\t\tтип параметру який повертає: \033[0;97m" + method.getReturnType().getName() + ";\033[0m");
            Parameter[] parameters = method.getParameters();
            if (parameters.length != 0) System.out.print("\t\tтип параметру який приймає:");
            for (Parameter parameter : parameters) {
                System.out.print(" \033[0;97m" + parameter.getType().getName() + ";\033[0m");
            }
            if (parameters.length != 0) System.out.println();
        }
    }
}
