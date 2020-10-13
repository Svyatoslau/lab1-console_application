package bsu.rfe.java.group10.lab1.Yaroshevich.varC2;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Comparator;

public class MainApplication {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {

        Food[] breakfast = new Food[20];//резервируем память для хранения 20 ссылок на объект

        boolean special_param_calories = false;
        boolean special_param_sort = false;
        int numFood = 0;
        for (String arg : args) {
            try {
                int par = 0;
                if (arg.startsWith("-calories"))
                    special_param_calories = true;//проверка на специальный параметр -calories
                String[] parts = arg.split("/");
                for (int k = 0; k < parts.length; k++) {
                    if (parts[k].startsWith("-")) {
                        par++;
                        if (parts[k].startsWith("-calories"))
                            special_param_calories = true;//проверка на специальный параметр -calories
                        if (parts[k].startsWith("-sort"))
                            special_param_sort = true;//проверка на специальный параметр -sort
                    }
                }
                Class myClass = Class.forName("bsu.rfe.java.group10.lab1.Yaroshevich.varC2." + parts[par]);
                if (parts.length == par + 1) {
                    Constructor constructor = myClass.getConstructor();
                    breakfast[numFood] = (Food) constructor.newInstance();
                    numFood++;
                } else if (parts.length == par + 2) {
                    Constructor constructor = myClass.getConstructor(String.class);
                    breakfast[numFood] = (Food) constructor.newInstance(parts[par + 1]);
                    numFood++;
                } else if (parts.length == par + 3) {
                    Constructor constructor = myClass.getConstructor(String.class, String.class);
                    breakfast[numFood] = (Food) constructor.newInstance(parts[par + 1], parts[par + 2]);
                    numFood++;
                } else throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                System.out.println(arg + " не может быть включён в завтрак");
                continue;
            }//исключение для getConstructor
            catch (ClassNotFoundException ex) {
                System.out.println(arg + " не может быть включён в завтрак");
                continue;
            }//исключение для myClass
        }//Java reflection API

        int[] num = new int[20];//массив для нахождения индексов существующих элементов и их не повторения
        for (int i = 0; i < num.length; i++)
            num[i] = i;
        for (int i = 0; i < breakfast.length; i++) {
            if (breakfast[i] != null && num[i] != -1) {
                num[i] = -1;
                int countFoot = 1;
                for (int k = i + 1; k < breakfast.length; k++) {
                    if (breakfast[i].equals(breakfast[k])) {
                        num[k] = -1;
                        countFoot++;
                    }
                }
                System.out.print("В колличестве " + countFoot + ": ");
                breakfast[i].consume();
            }
        }//процедура подсчёта продуктов, с методом equals()

        if (special_param_calories) {
            int countOfCalories = 0;
            int i = 0;
            while (breakfast[i] != null) {
                countOfCalories += breakfast[i].calculateCalories();
                i++;
            }
            System.out.println("Общая каллорийность завтрака " + countOfCalories);
        }//нахождение калорий во всём завтраке

        if (special_param_sort) {
            Arrays.sort(breakfast, new Comparator<Food>() {
                @Override
                public int compare(Food o1, Food o2) {
                    if (o1 == null) return 1;
                    if (o2 == null) return -1;
                    return -(o1.calculateCalories() - o2.calculateCalories());
                }
            });
            System.out.println(Arrays.toString(breakfast));
        }//сортировка по каллорийности в обратном порядке
    }
}
