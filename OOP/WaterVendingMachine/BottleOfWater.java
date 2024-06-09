public class BottleOfWater extends Product {
    private double volume;


    public BottleOfWater(String name, double cost, double volume) {
        super(name, cost);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Do you want a bottle of" + " " + super.getName() + ", with cost: " + super.getCost() + ", and volume: " + this.volume + "?";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BottleOfWater)) {
            return false;
        }

        BottleOfWater that = (BottleOfWater) o;

        return super.getName().equalsIgnoreCase(that.getName())
               && super.getCost() == that.getCost()
               && getVolume() == that.getVolume();
    }
}
