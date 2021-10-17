package cn.edu.tongji.software_igem2021.igemwebbackend.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class BacteriaPhageScoreEntityPK implements Serializable {
    private String genebankId;
    private String phageId;

    @Column(name = "genebank_id")
    @Id
    public String getGenebankId() {
        return genebankId;
    }

    public void setGenebankId(String genebankId) {
        this.genebankId = genebankId;
    }

    @Column(name = "phage_id")
    @Id
    public String getPhageId() {
        return phageId;
    }

    public void setPhageId(String phageId) {
        this.phageId = phageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BacteriaPhageScoreEntityPK that = (BacteriaPhageScoreEntityPK) o;
        return Objects.equals(genebankId, that.genebankId) && Objects.equals(phageId, that.phageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genebankId, phageId);
    }
}
