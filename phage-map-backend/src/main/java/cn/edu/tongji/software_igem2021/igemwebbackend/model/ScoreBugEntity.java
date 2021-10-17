package cn.edu.tongji.software_igem2021.igemwebbackend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "score_bug", schema = "iGEM_database", catalog = "")
@IdClass(ScoreBugEntityPK.class)
public class ScoreBugEntity {
    private String bugSeqId;
    private String phageId;
    private Integer phageClusterId;
    private Double firstScore;
    private Double secondScore;
    private Double thirdScore;
    private Double score;

    @Id
    @Column(name = "bug_seq_id")
    public String getBugSeqId() {
        return bugSeqId;
    }

    public void setBugSeqId(String bugSeqId) {
        this.bugSeqId = bugSeqId;
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
    @Column(name = "phage_cluster_id")
    public Integer getPhageClusterId() {
        return phageClusterId;
    }

    public void setPhageClusterId(Integer phageClusterId) {
        this.phageClusterId = phageClusterId;
    }

    @Basic
    @Column(name = "first_score")
    public Double getFirstScore() {
        return firstScore;
    }

    public void setFirstScore(Double firstScore) {
        this.firstScore = firstScore;
    }

    @Basic
    @Column(name = "second_score")
    public Double getSecondScore() {
        return secondScore;
    }

    public void setSecondScore(Double secondScore) {
        this.secondScore = secondScore;
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
        ScoreBugEntity that = (ScoreBugEntity) o;
        return Objects.equals(bugSeqId, that.bugSeqId) && Objects.equals(phageId, that.phageId) && Objects.equals(phageClusterId, that.phageClusterId) && Objects.equals(firstScore, that.firstScore) && Objects.equals(secondScore, that.secondScore) && Objects.equals(thirdScore, that.thirdScore) && Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bugSeqId, phageId, phageClusterId, firstScore, secondScore, thirdScore, score);
    }
}
