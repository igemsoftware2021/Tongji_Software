package cn.edu.tongji.software_igem2021.igemwebbackend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bacteria_phage_score", schema = "iGEM_database", catalog = "")
@IdClass(BacteriaPhageScoreEntityPK.class)
public class BacteriaPhageScoreEntity {
    private String genebankId;
    private String seqNcbiId;
    private Integer bacteriaTxid;
    private String phageId;
    private Integer phageTxid;
    private Double blastScore;
    private Double phpScore;
    private Double thirdScore;
    private Double score;

    @Id
    @Column(name = "genebank_id")
    public String getGenebankId() {
        return genebankId;
    }

    public void setGenebankId(String genebankId) {
        this.genebankId = genebankId;
    }

    @Basic
    @Column(name = "seq_ncbi_id")
    public String getSeqNcbiId() {
        return seqNcbiId;
    }

    public void setSeqNcbiId(String seqNcbiId) {
        this.seqNcbiId = seqNcbiId;
    }

    @Basic
    @Column(name = "bacteria_txid")
    public Integer getBacteriaTxid() {
        return bacteriaTxid;
    }

    public void setBacteriaTxid(Integer bacteriaTxid) {
        this.bacteriaTxid = bacteriaTxid;
    }

    @Id
    @Column(name = "phage_id")
    public String getPhageId() {
        return phageId;
    }

    public void setPhageId(String phageId) {
        this.phageId = phageId;
    }

    @Basic
    @Column(name = "phage_txid")
    public Integer getPhageTxid() {
        return phageTxid;
    }

    public void setPhageTxid(Integer phageTxid) {
        this.phageTxid = phageTxid;
    }

    @Basic
    @Column(name = "blast_score")
    public Double getBlastScore() {
        return blastScore;
    }

    public void setBlastScore(Double blastScore) {
        this.blastScore = blastScore;
    }

    @Basic
    @Column(name = "php_score")
    public Double getPhpScore() {
        return phpScore;
    }

    public void setPhpScore(Double phpScore) {
        this.phpScore = phpScore;
    }

    @Basic
    @Column(name = "third_score")
    public Double getThirdScore() {
        return thirdScore;
    }

    public void setThirdScore(Double thirdScore) {
        this.thirdScore = thirdScore;
    }

    @Basic
    @Column(name = "score")
    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BacteriaPhageScoreEntity that = (BacteriaPhageScoreEntity) o;
        return Objects.equals(genebankId, that.genebankId) && Objects.equals(seqNcbiId, that.seqNcbiId) && Objects.equals(bacteriaTxid, that.bacteriaTxid) && Objects.equals(phageId, that.phageId) && Objects.equals(phageTxid, that.phageTxid) && Objects.equals(blastScore, that.blastScore) && Objects.equals(phpScore, that.phpScore) && Objects.equals(thirdScore, that.thirdScore) && Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genebankId, seqNcbiId, bacteriaTxid, phageId, phageTxid, blastScore, phpScore, thirdScore, score);
    }
}
