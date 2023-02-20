package is.vinnsla;

/******************************************************************************
 *  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *
 *  Lýsing  :
 *
 *
 *****************************************************************************/
public class Leikmadur {
    private  int stig;
    private final String nafn;

    public String getNafn() {
        return nafn;
    }

    public int getStig() {
        return stig;
    }



    public Leikmadur(String nafn) {
        this.nafn = nafn;
        stig=0;
    }


    public void haekkaStig() {
        stig++;
    }
}
