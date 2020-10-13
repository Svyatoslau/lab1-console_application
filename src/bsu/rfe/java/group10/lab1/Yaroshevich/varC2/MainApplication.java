package bsu.rfe.java.group10.lab1.Yaroshevich.varC2;

import java.lang.reflect.Constructor;

public class MainApplication {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception{

        Food[] breakfast = new Food[20];//резервируем память для хранения 20 ссылок на объект

        int numFood=0;
        for (String arg: args){
            try {
                String[] parts = arg.split("/");
                Class myClass = Class.forName("bsu.rfe.java.group10.lab1.Yaroshevich.varC2." + parts[0]);
                if (parts.length == 1){
                    Constructor constructor =myClass.getConstructor();
                    breakfast[numFood]=(Food)constructor.newInstance();
                    numFood++;
                } else
                    if(parts.length==2){
                        Constructor constructor =myClass.getConstructor(String.class);
                        breakfast[numFood]=(Food)constructor.newInstance(parts[1]);
                        numFood++;
                    }else
                        if(parts.length==3){
                            Constructor constructor= myClass.getConstructor(String.class,String.class);
                            breakfast[numFood]=(Food)constructor.newInstance(parts[1],parts[2]);
                            numFood++;
                        }else throw new NoSuchMethodException();
            }
            catch (NoSuchMethodException e) {
                System.out.println(arg+" не может быть включён в завтрак");
                continue;
            }//исключение для getConstructor
            catch (ClassNotFoundException ex){
                System.out.println(arg+" не может быть включён в завтрак");
                continue;
            }//исключение для myClass
        }//Java reflection API

        /*int[] num = new int[20];//процедура подсчёта с методом equals()
        for(int i=0;i<num.length;i++)
            num[i]=i;

        for(int i=0;i<breakfast.length;i++)
        {

            if(breakfast[i]!=null){
                num[i]=-1;
                for(int k=i+1;k<)

            }
        }*/

    }
}
