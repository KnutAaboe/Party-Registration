package Klasser;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "javathing", name="deltagere")
public class Deltager {

    @Id
    private String tlf;
    private String fn;
    private String en;
    private String kjonn;
    private String passord;

    public Deltager(){}

    public Deltager(String tlf, String fn, String en, String kjonn, String passord) {
        this.tlf = tlf;
        this.fn = fn;
        this.en = en;
        this.kjonn = kjonn;
        this.passord = passord;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getKjonn() {
        return kjonn;
    }

    public void setKjonn(String kjønn) {
        this.kjonn = kjønn;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }
}
