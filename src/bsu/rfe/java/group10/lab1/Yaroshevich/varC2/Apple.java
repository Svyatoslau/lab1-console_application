package bsu.rfe.java.group10.lab1.Yaroshevich.varC2;

public class Apple extends Food {

    private String size=null;

    public Apple(String size){
        super("Яблоко");
        this.size=size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object arg0) {
        if(super.equals(arg0)) {
            if(!(arg0 instanceof Apple)) return false;
            return size.equals(((Apple)arg0).size);
        }
        else return false;
    }

    @Override
    public String toString(){
        return super.toString() + " размера '" + size.toUpperCase() + "'";
    }

    @Override
    public void consume() {
        System.out.println(this + " съеденно");
    }

    @Override
    public int calculateCalories() {
        int small = 26;
        int stan = 52;
        int big = 108;
        if (this.size.equals("малое")) return small;
        else if (this.size.equals("стандартное")) return stan;
        else if (this.size.equals("большое")) return big;

        //System.out.println("Неизвестный размер. Калорийность возьмёться стандартной");
        return stan;
    }
}
