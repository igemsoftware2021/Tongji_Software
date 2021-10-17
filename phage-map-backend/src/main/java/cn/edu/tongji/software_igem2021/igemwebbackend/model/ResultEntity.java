package cn.edu.tongji.software_igem2021.igemwebbackend.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "result", schema = "iGEM_database", catalog = "")
@IdClass(ResultEntityPK.class)
public class ResultEntity {
    private String genebankId;
    private String spacerSeq;
    private int spacerStart;
    private String phageSeqId;
    private BigDecimal identity;
    private Integer alignmentLength;
    private Integer mismatches;
    private Integer gapOpenings;
    private Integer queryStart;
    private Integer queryEnd;
    private int subjectStart;
    private Integer subjectEnd;
    private Double eValue;
    private BigDecimal bitScore;

    @Id
    @Column(name = "genebank_id")
    public String getGenebankId() {
        return genebankId;
    }

    public void setGenebankId(String genebankId) {
        this.genebankId = genebankId;
    }

    @Id
    @Column(name = "spacer_seq")
    public String getSpacerSeq() {
        return spacerSeq;
    }

    public void setSpacerSeq(String spacerSeq) {
        this.spacerSeq = spacerSeq;
    }

    @Id
    @Column(name = "spacer_start")
    public int getSpacerStart() {
        return spacerStart;
    }

    public void setSpacerStart(int spacerStart) {
        this.spacerStart = spacerStart;
    }

    @Id
    @Column(name = "phage_seq_id")
    public String getPhageSeqId() {
        return phageSeqId;
    }

    public void setPhageSeqId(String phageSeqId) {
        this.phageSeqId = phageSeqId;
    }

    @Basic
    @Column(name = "identity")
    public BigDecimal getIdentity() {
        return identity;
    }

    public void setIdentity(BigDecimal identity) {
        this.identity = identity;
    }

    @Basic
    @Column(name = "alignment_length")
    public Integer getAlignmentLength() {
        return alignmentLength;
    }

    public void setAlignmentLength(Integer alignmentLength) {
        this.alignmentLength = alignmentLength;
    }

    @Basic
    @Column(name = "mismatches")
    public Integer getMismatches() {
        return mismatches;
    }

    public void setMismatches(Integer mismatches) {
        this.mismatches = mismatches;
    }

    @Basic
    @Column(name = "gap_openings")
    public Integer getGapOpenings() {
        return gapOpenings;
    }

    public void setGapOpenings(Integer gapOpenings) {
        this.gapOpenings = gapOpenings;
    }

    @Basic
    @Column(name = "query_start")
    public Integer getQueryStart() {
        return queryStart;
    }

    public void setQueryStart(Integer queryStart) {
        this.queryStart = queryStart;
    }

    @Basic
    @Column(name = "query_end")
    public Integer getQueryEnd() {
        return queryEnd;
    }

    public void setQueryEnd(Integer queryEnd) {
        this.queryEnd = queryEnd;
    }

    @Id
    @Column(name = "subject_start")
    public int getSubjectStart() {
        return subjectStart;
    }

    public void setSubjectStart(int subjectStart) {
        this.subjectStart = subjectStart;
    }

    @Basic
    @Column(name = "subject_end")
    public Integer getSubjectEnd() {
        return subjectEnd;
    }

    public void setSubjectEnd(Integer subjectEnd) {
        this.subjectEnd = subjectEnd;
    }

    @Basic
    @Column(name = "e_value")
    public Double geteValue() {
        return eValue;
    }

    public void seteValue(Double eValue) {
        this.eValue = eValue;
    }

    @Basic
    @Column(name = "bit_score")
    public BigDecimal getBitScore() {
        return bitScore;
    }

    public void setBitScore(BigDecimal bitScore) {
        this.bitScore = bitScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultEntity that = (ResultEntity) o;
        return spacerStart == that.spacerStart && subjectStart == that.subjectStart && Objects.equals(genebankId, that.genebankId) && Objects.equals(spacerSeq, that.spacerSeq) && Objects.equals(phageSeqId, that.phageSeqId) && Objects.equals(identity, that.identity) && Objects.equals(alignmentLength, that.alignmentLength) && Objects.equals(mismatches, that.mismatches) && Objects.equals(gapOpenings, that.gapOpenings) && Objects.equals(queryStart, that.queryStart) && Objects.equals(queryEnd, that.queryEnd) && Objects.equals(subjectEnd, that.subjectEnd) && Objects.equals(eValue, that.eValue) && Objects.equals(bitScore, that.bitScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genebankId, spacerSeq, spacerStart, phageSeqId, identity, alignmentLength, mismatches, gapOpenings, queryStart, queryEnd, subjectStart, subjectEnd, eValue, bitScore);
    }
}
