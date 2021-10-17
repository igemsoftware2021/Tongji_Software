package cn.edu.tongji.software_igem2021.igemwebbackend.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ResultEntityPK implements Serializable {
    private String genebankId;
    private String spacerSeq;
    private int spacerStart;
    private String phageSeqId;
    private int subjectStart;

    @Column(name = "genebank_id")
    @Id
    public String getGenebankId() {
        return genebankId;
    }

    public void setGenebankId(String genebankId) {
        this.genebankId = genebankId;
    }

    @Column(name = "spacer_seq")
    @Id
    public String getSpacerSeq() {
        return spacerSeq;
    }

    public void setSpacerSeq(String spacerSeq) {
        this.spacerSeq = spacerSeq;
    }

    @Column(name = "spacer_start")
    @Id
    public int getSpacerStart() {
        return spacerStart;
    }

    public void setSpacerStart(int spacerStart) {
        this.spacerStart = spacerStart;
    }

    @Column(name = "phage_seq_id")
    @Id
    public String getPhageSeqId() {
        return phageSeqId;
    }

    public void setPhageSeqId(String phageSeqId) {
        this.phageSeqId = phageSeqId;
    }

    @Column(name = "subject_start")
    @Id
    public int getSubjectStart() {
        return subjectStart;
    }

    public void setSubjectStart(int subjectStart) {
        this.subjectStart = subjectStart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultEntityPK that = (ResultEntityPK) o;
        return spacerStart == that.spacerStart && subjectStart == that.subjectStart && Objects.equals(genebankId, that.genebankId) && Objects.equals(spacerSeq, that.spacerSeq) && Objects.equals(phageSeqId, that.phageSeqId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genebankId, spacerSeq, spacerStart, phageSeqId, subjectStart);
    }
}
