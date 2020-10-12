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
}
