import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntFunction;

public class Farm {
    private final List<Animal> animals = new ArrayList<>();
    // Следующий регистрационный номер
    private int nextId = 1;
    // Добавление животного с автоматическим ID
    public Animal addAnimal(IntFunction<? extends Animal> creator) {
        if (creator == null) {
            throw new IllegalArgumentException("Создатель животного не может быть null"); }
        Animal animal = creator.apply(nextId);
        if (animal == null) {
            throw new IllegalArgumentException("Нельзя добавить пустое животное"); }
        animals.add(animal);
        nextId++;
        System.out.println( animal.getType() + " добавлена на ферму. ID: " + animal.getId());
        return animal;
    }
    // Подсчёт количества животных
    public void showAnimalsCount() {
        Map<String, Integer> count = new LinkedHashMap<>();
        for (Animal animal : animals) {
            String type = animal.getType();
            count.put(type, count.getOrDefault(type, 0) + 1);
        }
        System.out.println("\nКоличество животных на ферме:");
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Всего животных: " + animals.size());
    }
    // Сбор продукции у всех животных за один день
    public Map<String, Integer> collectProducts() {
        Map<String, Integer> products = new LinkedHashMap<>();
        for (Animal animal : animals) {
            // Полиморфизм: вызывается метод конкретного животного
            ProductProducer producer = animal;
            String product = producer.getProductName();
            int amount = producer.collectProduct();
            products.put(product, products.getOrDefault(product, 0) + amount
            );
        }
        return products;
    }
    // Сбор продукции за 7 дней
    public Map<String, Integer> collectWeekProducts() {
        Map<String, Integer> totalProducts = new LinkedHashMap<>();
        for (int day = 1; day <= 7; day++) {
            System.out.println("\nДень " + day);
            Map<String, Integer> dailyProducts = collectProducts();
            for (Map.Entry<String, Integer> entry : dailyProducts.entrySet()) {
                String product = entry.getKey();
                int amount = entry.getValue();
                totalProducts.put(product, totalProducts.getOrDefault(product, 0) + amount
                );
                System.out.println(product + ": " + amount);
            }
        }
        return totalProducts;
    }
    // Вывод общего количества продукции
    public void showProducts(Map<String, Integer> products) {
        System.out.println("\nИТОГ СБОРА ПРОДУКЦИИ ЗА НЕДЕЛЮ:");
        for (Map.Entry<String, Integer> entry :
                products.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
