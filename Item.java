import java.text.DecimalFormat;
class Item{
    private String name;
    private int id;
    private double avgBuy;
    private double avgSell;

    //  Constructor
    public Item(int id, String name, double avgBuy, double avgSell){
        setId(id);
        setName(name);
        setAvgBuy(avgBuy);
        setAvgSell(avgSell);
    }
    
    
    //  Getters
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getAvgBuy(){
        return avgBuy;
    }
    public double getAvgSell(){
        return avgSell;
    }
    
    //  Setters
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAvgBuy(double avgBuy){
        this.avgBuy = avgBuy;
    }
    public void setAvgSell(double avgSell){
        this.avgSell = avgSell;
    }
    DecimalFormat df = new DecimalFormat("###,###,###,###,###.00");
    //toString
    public String toString(){//d
        return String.format( "ID:%d\tItem:%s\tAvgBuyOrder:%s\tAvgSellOrder:%s" , id , name.trim(), df.format(avgBuy), df.format(avgSell));
    }
    
    
}