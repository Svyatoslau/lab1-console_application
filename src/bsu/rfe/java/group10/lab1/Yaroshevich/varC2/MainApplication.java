package bsu.rfe.java.group10.lab1.Yaroshevich.varC2;

import java.lang.reflect.Constructor;

public class MainApplication {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception{

        Food[] breakfast = new Food[20];//резервируем память для хранения 20 ссылок на объект

        int i=0;
        for (String arg: args){
            try {
                String[] parts = arg.split("/");
                Class myClass = Class.forName("bsu.rfe.java.group10.lab1.Yaroshevich.varC2." + parts[0]);
                if (parts.length == 1){
                    Constructor constructor =myClass.getConstructor();
                    breakfast[i]=(Food)constructor.newInstance();
                    i++;
                } else
                    if(parts.length==2){
                        Constructor constructor =myClass.getConstructor(String.class);
                        breakfast[i]=(Food)constructor.newInstance(parts[1]);
                        i++;
                    }else
                        if(parts.length==3){
                            Constructor constructor= myClass.getConstructor(String.class,String.class);
                            breakfast[i]=(Food)constructor.newInstance(parts[1],parts[2]);
                            i++;
                        }else throw new NoSuchMethodException();
            }//Java reflection API
            catch (NoSuchMethodException e) {
                System.out.println(arg+" не может быть включён в завтрак");
                continue;
            }//исключение для getConstructor
            catch (ClassNotFoundException ex){
                System.out.println(arg+" не может быть включён в завтрак");
                continue;
            }

        }

    }
}
