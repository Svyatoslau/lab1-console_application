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
        return super.toString()+" из '"+drink+"' с '"+fruit+"'";
    }

    @Override
    public void consume(){
        System.out.println(this+" выпит");
    }
}
