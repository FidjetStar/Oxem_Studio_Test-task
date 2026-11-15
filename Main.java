import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Создаём ферму
        Farm farm = new Farm();
        System.out.println("========== СОЗДАНИЕ ФЕРМЫ ==========");
        // Добавляем 10 коров
        for (int i = 0; i < 10; i++) {
            farm.addAnimal(new Cow(farm.generateId()));
        }
        // Добавляем 20 кур
        for (int i = 0; i < 20; i++) {
            farm.addAnimal(new Chicken(farm.generateId()));
        }
        // Показываем количество животных
        farm.showAnimalsCount();
        // Первая неделя сбора продукции
        System.out.println("\n========== ПЕРВАЯ НЕДЕЛЯ ==========");
        Map<String, Integer> firstWeek =
                farm.collectWeekProducts();
        farm.showProducts(firstWeek);
        // Покупаем новых животных
        System.out.println("\n========== ПОКУПКА ЖИВОТНЫХ ==========");
        // Добавляем 5 кур
        for (int i = 0; i < 5; i++) {
            farm.addAnimal(new Chicken(farm.generateId()));
        }
        // Добавляем 1 корову
        farm.addAnimal(new Cow(farm.generateId()));
        // Показываем новое количество животных
        farm.showAnimalsCount();
        // Вторая неделя сбора продукции
        System.out.println("\n========== ВТОРАЯ НЕДЕЛЯ ==========");
        Map<String, Integer> secondWeek = farm.collectWeekProducts();
        farm.showProducts(secondWeek);
        System.out.println("\n========== ПРОГРАММА ЗАВЕРШЕНА ==========");
    }
}
