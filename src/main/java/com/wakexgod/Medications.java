package com.wakexgod;

// Интерфейс для действующего вещества
interface ActiveIngredient {
    void addIngredient(String name);
    void setStatus(String status); // Метод для изменения статуса (запрещенное, по рецепту, разрешенное)
    String getInfo();
}

// Интерфейс для лекарственного препарата
interface Medication {
    void calculateDosage(double weight);
    void conductStudy(); // Метод для проведения исследования
    String getDetails();
}

// Интерфейс для расчета дозировки
interface DosageCalculator {
    double calculate(double weight, double concentration);
}

// Класс для действующего вещества
class Substance implements ActiveIngredient {
    private String name;
    private String status;

    @Override
    public void addIngredient(String name) {
        this.name = name;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getInfo() {
        return "Ingredient: " + name + ", Status: " + status;
    }
}

// Абстрактный класс для общего лекарства (на основе него созданы Мази, Таблетки и Растворы)
abstract class Medicine implements Medication {
    protected String name;
    protected ActiveIngredient activeIngredient;

    public Medicine(String name, ActiveIngredient activeIngredient) {
        this.name = name;
        this.activeIngredient = activeIngredient;
    }

    @Override
    public String getDetails() {
        return "Medicine: " + name + ", " + activeIngredient.getInfo();
    }
}

// Класс для мази
class Ointment extends Medicine {
    private double standardDosePerKg = 0.05; // 0.05 грамма на килограмм

    public Ointment(String name, ActiveIngredient activeIngredient) {
        super(name, activeIngredient);
    }

    @Override
    public void calculateDosage(double weight) {
        double dosage = weight * standardDosePerKg; // Расчет дозировки
        System.out.println("Recommended dosage for " + name + ": " + dosage + " grams.");
    }

    @Override
    public void conductStudy() {
        System.out.println("Conducting study for ointment...");
    }
}

// Класс для таблеток
class Tablet extends Medicine {
    private double standardDosePerKg = 0.1; // 0.1 грамма на килограмм

    public Tablet(String name, ActiveIngredient activeIngredient) {
        super(name, activeIngredient);
    }

    @Override
    public void calculateDosage(double weight) {
        double dosage = weight * standardDosePerKg; // Расчет дозировки
        System.out.println("Recommended dosage for " + name + ": " + dosage + " grams.");
    }

    @Override
    public void conductStudy() {
        System.out.println("Conducting study for tablet...");
    }
}

// Класс для раствора
class Solution extends Medicine {
    private double standardDosePerKg = 0.02; // 0.02 грамма на килограмм

    public Solution(String name, ActiveIngredient activeIngredient) {
        super(name, activeIngredient);
    }

    @Override
    public void calculateDosage(double weight) {
        double dosage = weight * standardDosePerKg; // Расчет дозировки
        System.out.println("Recommended dosage for " + name + ": " + dosage + " grams.");
    }

    @Override
    public void conductStudy() {
        System.out.println("Conducting study for solution...");
    }
}

// Пример использования
public class Medications {
    public static void execute() {
        ActiveIngredient ingredient = new Substance();
        ingredient.addIngredient("Paracetamol");
        ingredient.setStatus("Разрешенное");

        Medicine ointment = new Ointment("Ointment A", ingredient);
        ointment.calculateDosage(70);
        ointment.conductStudy();
        System.out.println(ointment.getDetails());

        Medicine tablet = new Tablet("Tablet B", ingredient);
        tablet.calculateDosage(70);
        tablet.conductStudy();
        System.out.println(tablet.getDetails());

        Medicine solution = new Solution("Solution C", ingredient);
        solution.calculateDosage(70);
        solution.conductStudy();
        System.out.println(solution.getDetails());
    }
}

