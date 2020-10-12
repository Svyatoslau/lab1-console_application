package bsu.rfe.java.group10.lab1.Yaroshevich.varC2;

public class Cheese extends Food{

    public Cheese(){
        super("Сыр");
    }

    @Override
    public void consume() {
        System.out.println(this+" съеден");
    }
}
