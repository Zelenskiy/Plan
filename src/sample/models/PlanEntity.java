package sample.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PLAN_", schema = "", catalog = "")
public class PlanEntity {
    private int ident;
    private String zmist;
    private String stroki;
    private String forma;
    private String vidpov;
    private String primitka;
    private String sort;
    private String tmp;
    private Short show;

    @Id
    @Column(name = "IDENT")
    public int getIdent() {
        return ident;
    }

    public void setIdent(int ident) {
        this.ident = ident;
    }

    @Basic
    @Column(name = "ZMIST")
    public String getZmist() {
        return zmist;
    }

    public void setZmist(String zmist) {
        this.zmist = zmist;
    }

    @Basic
    @Column(name = "STROKI")
    public String getStroki() {
        return stroki;
    }

    public void setStroki(String stroki) {
        this.stroki = stroki;
    }

    @Basic
    @Column(name = "FORMA")
    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    @Basic
    @Column(name = "VIDPOV")
    public String getVidpov() {
        return vidpov;
    }

    public void setVidpov(String vidpov) {
        this.vidpov = vidpov;
    }

    @Basic
    @Column(name = "PRIMITKA")
    public String getPrimitka() {
        return primitka;
    }

    public void setPrimitka(String primitka) {
        this.primitka = primitka;
    }

    @Basic
    @Column(name = "SORT_")
    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "TMP")
    public String getTmp() {
        return tmp;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp;
    }

    @Basic
    @Column(name = "SHOW")
    public Short getShow() {
        return show;
    }

    public void setShow(Short show) {
        this.show = show;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanEntity that = (PlanEntity) o;
        return ident == that.ident &&
                Objects.equals(zmist, that.zmist) &&
                Objects.equals(stroki, that.stroki) &&
                Objects.equals(forma, that.forma) &&
                Objects.equals(vidpov, that.vidpov) &&
                Objects.equals(primitka, that.primitka) &&
                Objects.equals(sort, that.sort) &&
                Objects.equals(tmp, that.tmp) &&
                Objects.equals(show, that.show);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ident, zmist, stroki, forma, vidpov, primitka, sort, tmp, show);
    }
}
