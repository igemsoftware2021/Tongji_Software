package cn.edu.tongji.software_igem2021.igemwebbackend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bacteria_spacer", schema = "iGEM_database", catalog = "")
@IdClass(BacteriaSpacerEntityPK.class)
public class BacteriaSpacerEntity {
    private String genebankId;
    private int spacerStart;
    private Integer spacerLength;
    private String spacerSeq;

    @Id
    @Column(name = "genebank_id")
    public String getGenebankId() {
        return genebankId;
    }

    public void setGenebankId(String genebankId) {
        this.genebankId = genebankId;
    }

    @Id
    @Column(name = "spacer_start")
    public int getSpacerStart() {
        return spacerStart;
    }

    public void setSpacerStart(int spacerStart) {
        this.spacerStart = spacerStart;
    }

    @Basic
    @Column(name = "spacer_length")
    public Integer getSpacerLength() {
        return spacerLength;
    }

    public void setSpacerLength(Integer spacerLength) {
        this.spacerLength = spacerLength;
    }

    @Id
    @Column(name = "spacer_seq")
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
        BacteriaSpacerEntity that = (BacteriaSpacerEntity) o;
        return spacerStart == that.spacerStart && Objects.equals(genebankId, that.genebankId) && Objects.equals(spacerLength, that.spacerLength) && Objects.equals(spacerSeq, that.spacerSeq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genebankId, spacerStart, spacerLength, spacerSeq);
    }
}
