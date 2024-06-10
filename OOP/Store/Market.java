import java.util.ArrayList;
import java.util.List;

public class Market implements MarketBehaviour, QueueBehaviour {
    private final List<Actor> queue;

    public Market(){
        this.queue = new ArrayList<>();
    }

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + " came to store");
        takeInQueue(actor);
    }

    @Override
    public void takeInQueue(Actor actor) {
        System.out.println(actor.getName() + " got in line");
        this.queue.add(actor);
    }

    @Override
    public void takeOrders() {
        for(Actor actor: queue){
            if(!actor.isMakeOrder()){
                actor.setMakeOrder(true);
                System.out.println(actor.getName() + " make order");
            }
        }
    }

    @Override
    public void giveOrders() {
        for(Actor actor: queue){
            if(actor.isMakeOrder()){
                actor.setTakeOrder(true);
                System.out.println(actor.getName() + " received order");
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> releasedActors = new ArrayList<>();
        for(Actor actor: queue){
            if(actor.isTakeOrder()){
                releasedActors.add(actor);
                System.out.println(actor.getName() + " out of queue");
            }
        }
        releaseFromMarket(releasedActors);
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for(Actor actor: actors){
            System.out.println(actor.getName() + " out of store");
            queue.remove(actor);
        }
    }

    @Override
    public void update() {
        takeOrders();
        giveOrders();
        releaseFromQueue();
    }
}
