public class CupOfCoffee extends Product {
    private double temperature;
    private double volume;


    public CupOfCoffee(String name, double cost, double volume, double temperature) {
        super(name, cost);
        this.temperature = temperature;
        this.volume = volume;
    }

    public double getVolume(){
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Do you want cap of" + " " + super.getName() + ", with cost: " + super.getCost() + ", temp: " + this.temperature + ", and volume of: "  + this.volume + "?";
    }

}
