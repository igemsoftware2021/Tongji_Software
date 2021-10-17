package cn.edu.tongji.software_igem2021.igemwebbackend.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class BacteriaSpacerEntityPK implements Serializable {
    private String genebankId;
    private int spacerStart;
    private String spacerSeq;

    @Column(name = "genebank_id")
    @Id
    public String getGenebankId() {
        return genebankId;
    }

    public void setGenebankId(String genebankId) {
        this.genebankId = genebankId;
    }

    @Column(name = "spacer_start")
    @Id
    public int getSpacerStart() {
        return spacerStart;
    }

    public void setSpacerStart(int spacerStart) {
        this.spacerStart = spacerStart;
    }

    @Column(name = "spacer_seq")
    @Id
    public String getSpacerSeq() {
        return spacerSeq;
    }

    public void setSpacerSeq(String spacerSeq) {
        this.spacerSeq = spacerSeq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BacteriaSpacerEntityPK that = (BacteriaSpacerEntityPK) o;
        return spacerStart == that.spacerStart && Objects.equals(genebankId, that.genebankId) && Objects.equals(spacerSeq, that.spacerSeq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genebankId, spacerStart, spacerSeq);
    }
}
