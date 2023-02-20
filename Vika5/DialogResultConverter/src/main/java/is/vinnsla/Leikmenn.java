
package is.vinnsla;

/**
 * Inniheldur nöfn tveggja leikmanna 
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class Leikmenn {
    private String nafnLeikmanns1;
    private String nafnLeikmanns2;

    public Leikmenn(String leikmadur1Nafn, String leikmadur2Nafn) {
        nafnLeikmanns1 = leikmadur1Nafn;
        nafnLeikmanns2 = leikmadur2Nafn;
    }

    // Dæmi um gettera -
    public String getNafnLeikmanns1() {
        return nafnLeikmanns1;
    }

    public void setNafnLeikmanns1(String nafnLeikmanns1) {
        this.nafnLeikmanns1 = nafnLeikmanns1;
    }

    public String getNafnLeikmanns2() {
        return nafnLeikmanns2;
    }

    public void setNafnLeikmanns2(String nafnLeikmanns2) {
        this.nafnLeikmanns2 = nafnLeikmanns2;
    }
   
}
