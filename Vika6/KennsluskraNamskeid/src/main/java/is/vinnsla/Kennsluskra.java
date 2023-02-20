package is.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Geymir gögn fyrir kennsluskrá
 * Listi af námskeiðum
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class Kennsluskra {
    private final ObservableList<Namskeid> namskeid;  // Model fyrir lista. Væri líka hægt að láta
                                // Kennsluskra erfa frá DefaultListModel 
    
    public Kennsluskra () {
        // hluturinn sem geymir gögnin, þ.e. listann af námskeiðunum. 
        this.namskeid = FXCollections.observableArrayList();
        
        // Bætum gögnunum við 
        // Venjulega mundum við hér lesa úr skrá eða gagnagrunni 
        
        namskeid.add(new Namskeid("HBV","201",'G', "Viðmótsforritun"));
        namskeid.add(new Namskeid("REI","201",'G', "Stærðfræði og reiknifræði"));
        namskeid.add(new Namskeid("TÖL","203",'G', " Tölvunarfræði 2"));
        namskeid.add(new Namskeid("TÖV","201",'G', " Greining og hönnun stafrænna rása"));
        namskeid.add(new Namskeid("TÖV","202",'G', " Greining og hönnun stafrænna rása - verklegt"));
        
    }
    
    /**
     * Skilar heiti á námskeiði sem er nr. index á listanum
     * @param index nr. námskeiðs
     * @return heiti námskeiðs
     */
    public Namskeid getNamskeid (int index) {
        return (Namskeid)namskeid.get(index);
    }

    /**
     * Eyða námskeiði sem er númer index á listanum
     * @param index númer námskeiðs á lista 
     */
    public void eydaNamskeidi(int index) {
        namskeid.remove(index);
    }
    
    public ObservableList<Namskeid> getOllNamskeid() {
        return namskeid;
    }
}
