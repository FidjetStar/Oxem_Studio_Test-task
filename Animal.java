public abstract class Animal {
    private int id;
    private String type;
    public Animal(int id, String type) {
        this.id = id;
        this.type = type;
    }
    public int getId() {return id;}
    public String getType() { return type;}
    // Каждый вид животного самостоятельно производит продукцию
    public abstract int collectProduct();
}
