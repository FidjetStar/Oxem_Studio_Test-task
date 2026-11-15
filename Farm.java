import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Farm {
    private List<Animal> animals = new ArrayList<>();
    // Следующий свободный регистрационный номер
    private int nextId = 1;
    // Добавление животного на ферму
    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println(animal.getType() + " добавлена на ферму. ID: " + animal.getId());
    }
    // Создание регистрационного номера
    public int generateId() {
        return nextId++;
    }
    // Подсчёт количества животных каждого типа
    public void showAnimalsCount() {
        Map<String, Integer> count = new HashMap<>();
        for (Animal animal : animals) {
            String type = animal.getType();
            count.put(type, count.getOrDefault(type, 0) + 1);
        }
        System.out.println("\nКоличество животных на ферме:");
        for (String type : count.keySet()) {
            System.out.println(type + ": " + count.get(type));
        }
        System.out.println("Всего животных: " + animals.size());
    }
    // Сбор продукции у всех животных
    public Map<String, Integer> collectProducts() {
        Map<String, Integer> products = new HashMap<>();
        for (Animal animal : animals) {
            int amount = animal.collectProduct();
            String product;
            if (animal instanceof Cow) {
                product = "Молоко (литров)";
            }
            else {
                product = "Яйца (штук)";
            }
            products.put(
                    product,
                    products.getOrDefault(product, 0) + amount
            );
        }
        return products;
    }
    // Сбор продукции за неделю
    public Map<String, Integer> collectWeekProducts() {
        Map<String, Integer> totalProducts = new HashMap<>();
        for (int day = 1; day <= 7; day++) {
            System.out.println("\nДень " + day);
            Map<String, Integer> dailyProducts = collectProducts();
            for (String product : dailyProducts.keySet()) {
                int amount = dailyProducts.get(product);
                totalProducts.put(
                        product,
                        totalProducts.getOrDefault(product, 0) + amount
                );
                System.out.println(product + ": " + amount);
            }
        }
        return totalProducts;
    }
    // Вывод общего количества продукции
    public void showProducts(Map<String, Integer> products) {
        System.out.println("\nИТОГ СБОРА ПРОДУКЦИИ ЗА НЕДЕЛЮ:");
        for (String product : products.keySet()) {
            System.out.println(product + ": " + products.get(product));
        }
    }
}

