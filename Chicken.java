import java.util.Random;

public class Chicken extends Animal {
    private Random random = new Random();
    public Chicken(int id) {
        super(id, "Курица");
    }
    @Override
    public int collectProduct() {
        // От 0 до 1 яйца включительно
        return random.nextInt(2);
    }
}
