public class student {
    private int index;
    private long id;
    private String name;
    private double cpi;

    student(int index,long id,String name,double cpi){
        this.index = index;
        this.id = id;
        this.name = name;
        this.cpi = cpi;
    }

    public int getIndex(){return this.index;}
    public long getId(){return this.id;}
    public String getName(){return this.name;}
    public double getCpi(){return this.cpi;}
}
