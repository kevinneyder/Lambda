import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

public class Lambda {
    static PrintStream out = new PrintStream(System.out);

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ana");list.add("agua");list.add("Ojo");list.add("ala");list.add("Aaa");list.add("hola");list.add("abc");
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);list1.add(3);list1.add(5);list1.add(6);list1.add(2);list1.add(8);list1.add(100);list1.add(0);
        Map<String, Integer> map = new HashMap<>();
        map.put("Key1",1);map.put("Key2",2);map.put("Key3",3);map.put("Key4",4);map.put("Key5",5);
        //Ejercicio 1
        out.println("Ejercicio1:  " +search(list));
        //Ejercicio 2
        out.println("Ejercicio2:  " +getString(list1));
        //Ejercicio 3
        out.println("Ejercicio3:  " +ejercicio3(list));
        //Ejercicio 4
        out.println("Ejercicio4:  " +ejercicio4(list));
        //Ejercicio 5
        out.println("Ejercicio5:  " +ejercicio5(list));
        //Ejercicio 6
        out.println("Ejercicio6:  " +ejercicio6(map));
        //Ejercicio7
        out.print("Ejercicio7:  Thread -> ");
        ejercicio7(list1,out);
    }

    public static List<String> search(List<String> list){
        out.print("Ejercicio-----------");

        return list.stream().filter(s -> s.startsWith("a") && s.length() == 3).collect(Collectors.toList());
    }

    public static String getString(List<Integer> list){
        out.print("Ejercicio-----------2");

        return list.stream().map(i -> i % 2 == 0 ? "e" + i : "o" + i).collect(Collectors.joining(","));
    }

    public static String ejercicio3(List<String> list){
        return list.stream().map(s -> s.substring(0,1)).collect(Collectors.joining());
    }

    public static List<String> ejercicio4(List<String> list){
        return list.stream().filter(s -> s.length() % 2 != 0).collect(Collectors.toList());
    }

    public static List<String> ejercicio5(List<String> list){
        return list.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    public static String ejercicio6(Map<String, Integer> map){
        return map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                  .map(entry -> entry.getKey() + "=" + entry.getValue()).collect(Collectors.joining(", "));
    }

    public static void ejercicio7(List<Integer> list, PrintStream out){
        Thread t = new Thread(() -> list.forEach(i -> out.print(i+ " ")));
        t.start();
//        Thread con sleep de 1 segundo
//        Thread t2 = new Thread(() -> list.forEach(i -> {
//            out.print(i + " ");
//            try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
//        }));
//        t2.start();
    }
}
