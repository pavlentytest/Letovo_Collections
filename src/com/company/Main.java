package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*
        Collections
        List-ы (Списки)
            List(интерфейс) => ArrayList, LinkedList (классы)
        Set-ы (Множества)
            Set(интерфейс) => TreeSet, HashSet... (классы)
        Map-ы (Словарь, ассоц. массив, ключ=>значение) - интерфейс
            => Hashtable, HashMap, LinkedHashMap, TreeMap

        https://habr.com/ru/post/188010/

         */

        ArrayList<Integer> arrayList = new ArrayList<>(); // 20
        LinkedList<Integer> linkedList = new LinkedList<>();

        //List<Integer> array1 = new ArrayList<>();
       // Collection<Integer> array2 = new ArrayList<>();

 /*       long start = System.nanoTime();
        for(int i=0;i<100000;i++) {
            arrayList.add(0,i);
        }
        long end = System.nanoTime();
        System.out.println("ArrayList add begin: "+(end-start));
        start = System.nanoTime();
        for(int i=0;i<100000;i++) {
            linkedList.add(0,i);
        }
        end = System.nanoTime();
        System.out.println("LinkedList add begin:"+(end-start));


        start = System.nanoTime();
        for(int i=30000;i<60000;i++) {
            arrayList.get(i);
        }
        end = System.nanoTime();
        System.out.println("ArrayList get middle:"+(end-start));

        start = System.nanoTime();
        for(int i=30000;i<60000;i++) {
            linkedList.get(i);
        }
        end = System.nanoTime();
        System.out.println("LinkedList get middle:"+(end-start));


        start = System.nanoTime();
        for(int i=0;i<30000;i++) {
            arrayList.add(i);
        }
        end = System.nanoTime();
        System.out.println("ArrayList add end: "+(end-start));

        start = System.nanoTime();
        for(int i=0;i<30000;i++) {
            linkedList.add(i);
        }
        end = System.nanoTime();
        System.out.println("LinkedList add end:"+(end-start));
*/
        //Collections.binarySearch();
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(new City("Moscow",345345345));
        cities.add(new City("Berlin",345));
        cities.add(new City("Astrahan",123123));

        Comparator<City> sort_by = new Comparator<City>() {
            @Override
            public int compare(City t2, City t1) {
                    return t1.getPopulation()-t2.getPopulation();
                //return t2.getName().compareTo(t1.getName());
            }
        };

        Collections.sort(cities,sort_by);
        for(City c: cities) {
            System.out.println(c.getName() + "; "+ c.getPopulation());
        }


        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Germany");
        treeSet.add("Russia");
        treeSet.add("USA");
        treeSet.add("Finland");

        for(String s: treeSet) {
            System.out.println(s);
        }




        ArrayList<Integer> arrayList2 = new ArrayList<>();
        TreeSet<Integer> treeSet2 = new TreeSet<>();
        for(int i=0;i<100000;i++) {
            arrayList.add(i);
            treeSet2.add(i);
        }

        long startTime = System.nanoTime();
        for(int i=0;i<100000;i++) {
            arrayList2.contains(i);
        }
        long endTime = System.nanoTime();
        long elapsed = endTime - startTime;
        System.out.println("ArrayList Contains: "+elapsed);
        startTime = System.nanoTime();
        for(int i=0;i<100000;i++) {
            treeSet2.contains(i);
        }
        endTime = System.nanoTime();
        elapsed = endTime - startTime;
        System.out.println("TreeSet Contains:   "+elapsed);

        /*
        Имеется список учеников (Имя, оценка). Получить список учеников где балл > 20
         */

        TreeSet<Student> students = new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student t0, Student t1) {
                return t0.getMark() - t1.getMark();
            }
        });
        students.add(new Student("Ivan",20));
        students.add(new Student("Petr",30));
        students.add(new Student("Max",44));
        students.add(new Student("Olga",50));
        students.add(new Student("Marina",11));

        for(Student s: students) {
            System.out.println(s.getMark() + " " + s.getName());
        }

        // students.headSet();
        //students.subSet()
        //students.tailSet()

        //SortedSet<Student> result = students.tailSet(new Student("",4));
        SortedSet<Student> result = students.subSet(new Student("",20),new Student("",Integer.MAX_VALUE));
        System.out.println(result);

        /* Map-ы */
        /*
        Hashtable - хэш таблица
        Пары = ключ-значение
        выполнение всех операции начинается с вычисленяи хэша от ключа - это фактически есть индекс
        Неупорядочено (зависит от хэш функции)
        все методы - synchronized
        null нельзя
         */

        Hashtable phoneBook = new Hashtable();
        phoneBook.put("Ivan","345345345");
        phoneBook.put("Petr","123123");
        phoneBook.put("Max","678678");
        phoneBook.put("Andrey","23553685");

        Enumeration keys = phoneBook.keys();

        while(keys.hasMoreElements()) {
            String user = (String) keys.nextElement();
            String value = (String) phoneBook.get(user);
            System.out.println("key: "+user+"; value: "+value);
        }


        /*HashMap
        Аналогично с Hashtable, можно null и потоконебезопасный
         */

        Map<String,String> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");

        Map<String,String> map2 = new HashMap<>();
        map.put("key4","value4");
        map.put("key5","value5");
        map.put("key6","value6");

        // добавление набора данных
        map.putAll(map2);

        map.remove("key2");

        map.containsKey("key2");

        map.containsValue("value3");

        // перебор значение

        Set<Map.Entry<String,String>> set = map.entrySet();
        for(Map.Entry<String,String> m: set) {
            System.out.println(m.getKey() + "; "+m.getValue());
        }
        String str = "Hello";
        System.out.println(str.hashCode());

        /*TreeMap - сортируется по ключам - natural ordering
        * Comparator - своя сортировка
        * */

        TreeMap<Integer,String> week = new TreeMap<>();
        week.put(1,"Monday");
        week.put(2,"Tuesday");
        week.put(3,"Wednesday");
        week.put(4,"Thursday");

        System.out.println(week.keySet());
        System.out.println(week.values());

        // получаем первый элемент
        System.out.println(week.get(week.firstKey()));

    }
}
