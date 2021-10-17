package cn.edu.tongji.software_igem2021.igemwebbackend.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class BugScoreWithNameEntityPK implements Serializable {
    private String bugSeqId;
    private String phageId;

    @Column(name = "bug_seq_id")
    @Id
    public String getBugSeqId() {
        return bugSeqId;
    }

    public void setBugSeqId(String bugSeqId) {
        this.bugSeqId = bugSeqId;
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
        BugScoreWithNameEntityPK that = (BugScoreWithNameEntityPK) o;
        return Objects.equals(bugSeqId, that.bugSeqId) && Objects.equals(phageId, that.phageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bugSeqId, phageId);
    }
}
