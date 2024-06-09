public class Programm {

    public static void main(String[] args) {
        BottleOfWater pepsi = new BottleOfWater("pepsi", 10.01, 0.5);
        BottleOfWater sprite = new BottleOfWater("sprite",  10.06, 0.6);
        BottleOfWater fanta = new BottleOfWater("fanta",  10.04, 0.6);
        CupOfCoffee espresso = new CupOfCoffee("espresso",  10.04, 0.3 , 60);
    
        

        VendingMachine vMachine = new BottleOfWaterVendingMachine();
        vMachine.addProduct(pepsi);
        vMachine.addProduct(sprite);
        vMachine.addProduct(fanta);
        System.out.println(vMachine.getProduct("pepsi"));

        VendingMachine cMachine = new CupOfCoffeeVendingMachine();
        cMachine.addProduct(espresso);
        System.out.println(cMachine.getProduct("espresso"));
    }
}