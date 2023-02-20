/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package is.vinnsla;

/**
 * Námskeið inniheldur kóða sem samanstendur af
 * auðkenni námsleiðar, númeri og G, M eða F sem 
 * segir til um á hvaða stigi námskeið er. 
 * @author Ebba Þóra Hvannberg ebba@hi.is 
 * @date 
 * Háskóli Íslands
 */
public class Namskeid {
    private final String namsleid;
    private final String numer;
    private final char   stig;
    private final String heiti;

    public Namskeid(String namsleid, String numer, char stig, String heiti) {
        this.namsleid = namsleid;
        this.numer = numer;
        this.stig = stig;
        this.heiti = heiti;
    }

    public String getNamsleid() {
        return namsleid;
    }

    public String getNumer() {
        return numer;
    }

    public char getStig() {
        return stig;
    }
   
    public String getHeiti() {
        return heiti;
    }

    
    @Override
    public String toString() {
        return (getNamsleid()+
                getNumer()+ 
                getStig()+ " " +
                getHeiti());
                
    }

}
