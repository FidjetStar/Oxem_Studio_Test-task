public abstract class Animal implements ProductProducer {
    private final int id;
    private final String type;
    public Animal(int id, String type) {
        this.id = id;
        this.type = type;
    }
    public int getId() {
        return id;
    }
    public String getType() {
        return type;
    }
}
