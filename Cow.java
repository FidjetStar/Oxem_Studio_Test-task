import java.util.Random;

public class Cow extends Animal {
    private Random random = new Random();
    public Cow(int id) {
        super(id, "Корова");
    }
    @Override
    public int collectProduct() {
        // От 8 до 12 литров включительно
        return random.nextInt(5) + 8;
    }
}
