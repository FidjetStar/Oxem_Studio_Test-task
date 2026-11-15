import java.util.Random;

public class Cow extends Animal {
    private final Random random = new Random();
    public Cow(int id) {
        super(id, "Корова");
    }
    @Override
    public String getProductName() {
        return "Молоко (литров)";
    }
    @Override
    public int collectProduct() {
        // От 8 до 12 литров включительно
        return random.nextInt(5) + 8;
    }
}
