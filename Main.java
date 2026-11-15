import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Создаём ферму
        Farm farm = new Farm();
        System.out.println("========== СОЗДАНИЕ ФЕРМЫ ==========");
        // Добавляем 10 коров
        for (int i = 0; i < 10; i++) {
            farm.addAnimal(Cow::new);
        }
        // Добавляем 20 кур
        for (int i = 0; i < 20; i++) {
            farm.addAnimal(Chicken::new);
        }
        // Выводим количество животных
        farm.showAnimalsCount();
        // Первая неделя
        System.out.println("\n========== ПЕРВАЯ НЕДЕЛЯ ==========");

        Map<String, Integer> firstWeek = farm.collectWeekProducts();
        farm.showProducts(firstWeek);
        // Покупаем новых животных
        System.out.println("\n========== ПОКУПКА ЖИВОТНЫХ ==========");
        // Добавляем 5 кур
        for (int i = 0; i < 5; i++) {
            farm.addAnimal(Chicken::new);
        }
        // Добавляем 1 корову
        farm.addAnimal(Cow::new);
        // Выводим новое количество животных
        farm.showAnimalsCount();
        // Вторая неделя
        System.out.println("\n========== ВТОРАЯ НЕДЕЛЯ ==========");

        Map<String, Integer> secondWeek = farm.collectWeekProducts();
        farm.showProducts(secondWeek);
        System.out.println("\n========== ПРОГРАММА ЗАВЕРШЕНА ==========");
    }
}
