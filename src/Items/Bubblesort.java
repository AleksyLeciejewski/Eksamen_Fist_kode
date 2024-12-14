package Items; // Angiver, at denne klasse tilhører "Items"-pakken
import java.util.List; // Importerer Java's List-interface, der bruges til at håndtere samlinger
import java.util.Comparator; // Importerer Comparator til sammenligning af elementer

// Klasse, der implementerer Bubble Sort algoritmen
public class Bubblesort {

    // En generisk metode til at sortere en liste ved hjælp af en Comparator
    public static <T> void sort(List<T> list, Comparator<T> comparator) {
        int n = list.size(); // Få antallet af elementer i listen for at vide, hvor mange iterationer der kræves
        boolean swapped = true; // Variabel, der holder styr på, om der blev byttet elementer i denne iteration

        // Ydre for-løkke: Går igennem listen flere gange for at sikre, at den bliver sorteret
        for (int i = 0; i < n - 1; i++) {
            // `i` starter på 0 og øges med 1 i hver iteration
            // `i` repræsenterer antallet af allerede sorterede elementer i bunden af listen
            swapped = false; // Sætter `swapped` til false, da vi endnu ikke har byttet nogen elementer i denne iteration

            // Indre for-løkke: Går igennem de usorterede dele af listen
            for (int j = 0; j < n - i - 1; j++) {
                // `j` starter på 0 og går op til det sidste usorterede element
                // `n - i - 1` sikrer, at vi ikke tjekker de allerede sorterede elementer i bunden af listen

                // Comparatoren bruges til at sammenligne to nabo-elementer
                if (comparator.compare(list.get(j), list.get(j + 1)) > 0) {
                    // Hvis det første element er "større" end det næste ifølge Comparatoren:
                    T temp = list.get(j); // Gem det første element midlertidigt
                    list.set(j, list.get(j + 1)); // Flyt det andet element til det første elements plads
                    list.set(j + 1, temp); // Flyt det midlertidige element til det andet elements plads
                    swapped = true; // Marker, at der er foretaget en bytte
                }
            }

            // Hvis der ikke blev foretaget nogen bytte i hele denne iteration, er listen sorteret
            if (!swapped) break; // Bryder ud af den ydre løkke og afslutter sorteringen
        }
    }
}
