package bsu.rfe.java.group10.lab1.Yaroshevich.varC2;

public class Cocktail extends Food{

    private String drink=null;
    private String fruit=null;

    public Cocktail(String drink,String fruit){
        super("Коктейль");
        this.drink=drink;
        this.fruit=fruit;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    @Override
    public boolean equals(Object arg0){
        if(super.equals(arg0))
        {
            if(!(arg0 instanceof Cocktail)) return false;
            return (drink.equals(((Cocktail)arg0).drink) && fruit.equals(((Cocktail)arg0).fruit));
        }
        else return false;
    }

    @Override
    public String toString(){
        return super.toString()+" из '"+drink.toUpperCase()+"' с '"+fruit.toUpperCase()+"'";
    }

    @Override
    public void consume(){
        System.out.println(this+" выпит");
    }

    @Override
    public int calculateCalories() {
        int water = 0;
        int or_juice = 51;
        int pin_juice = 47;
        int red_wine = 76;
        int white_wine = 78;
        int cognac = 239;
        int liquor = 345;
        int peach = 66;
        int banana = 60;
        int kiwi = 46;
        int arg1 = water, arg2 = peach;

        if (this.drink.equals("вода")) arg1 = water;
        else if (this.drink.equals("апельсиновый сок")) arg1 = or_juice;
        else if (this.drink.equals("ананасовый сок")) arg1 = pin_juice;
        else if (this.drink.equals("красное вино")) arg1 = red_wine;
        else if (this.drink.equals("белое вино")) arg1 = white_wine;
        else if (this.drink.equals("коньяк")) arg1 = cognac;
        else if (this.drink.equals("ликёр")) arg1 = liquor;

        if (this.fruit.equals("персик")) arg2 = peach;
        else if (this.fruit.equals("банан")) arg2 = banana;
        else if (this.fruit.equals("киви")) arg2 = kiwi;

        return arg1 + arg2;
    }
}
