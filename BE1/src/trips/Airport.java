package trips;

public class Airport {
    private String name;
    private String iata;

    public Airport(String name, String iata){
        this.name = name;
        this.iata = iata;
    }

    public String getName(){
        return this.name;
    }
    
    public String getIata(){
        return this.iata;
    }

    public String toString(){
        return this.name + " ( " + this.iata + " )";
    }

    public boolean isSameAs(Airport that){
        return this.getIata() == that.getIata();
    }
}
