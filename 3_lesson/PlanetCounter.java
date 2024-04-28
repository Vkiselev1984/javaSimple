// Программа заполняет список названиями планет Солнечной системы в произвольном порядке с повторениями.
// Выводит название каждой планеты и количество его повторений в списке.

import java.util.ArrayList;
import java.util.HashMap;

public class PlanetCounter {
    public static void main(String[] args) {
        ArrayList<String> planets = new ArrayList<>();
        planets.add("Mercury");
        planets.add("Venus");
        planets.add("Earth");
        planets.add("Mars");
        planets.add("Jupiter");
        planets.add("Saturn");
        planets.add("Uranus");
        planets.add("Neptune");
        planets.add("Earth"); // Добавляем повторение для теста

        HashMap<String, Integer> planetCounts = new HashMap<>();

        for (String planet : planets) {
            if (planetCounts.containsKey(planet)) {
                planetCounts.put(planet, planetCounts.get(planet) + 1);
            } else {
                planetCounts.put(planet, 1);
            }
        }

        for (String planet : planetCounts.keySet()) {
            System.out.println("Planet: " + planet + ", Count: " + planetCounts.get(planet));
        }
    }
}