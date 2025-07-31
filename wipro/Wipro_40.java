package wipro;

import java.util.*;

// CD class implementing Comparable based on singer name
class CD implements Comparable<CD> {
    private String title;
    private String singer;

    public CD(String title, String singer) {
        this.title = title;
        this.singer = singer;
    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }

    // Compare based on singer name
    @Override
    public int compareTo(CD other) {
        return this.singer.compareToIgnoreCase(other.singer);
    }

    public void display() {
        System.out.println("Title: " + title + ", Singer: " + singer);
    }
}

public class Wipro_40 {
    public static void main(String[] args) {
        List<CD> cdList = new ArrayList<>();

        // Sample CDs
        cdList.add(new CD("Melody Vibes", "Arijit Singh"));
        cdList.add(new CD("Rock On", "KK"));
        cdList.add(new CD("Classical Tunes", "Shreya Ghoshal"));
        cdList.add(new CD("Golden Hits", "Lata Mangeshkar"));

        // Sorting CDs based on singer name
        Collections.sort(cdList);

        System.out.println("CDs sorted by singer name:");
        for (CD cd : cdList) {
            cd.display();
        }
    }
}
