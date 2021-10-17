package cn.edu.tongji.software_igem2021.igemwebbackend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "super_bug", schema = "iGEM_database", catalog = "")
public class SuperBugEntity {
    private String bugSeqId;
    private String bugId;
    private Integer txid;
    private String txidRank;
    private String name;

    @Id
    @Column(name = "bug_seq_id")
    public String getBugSeqId() {
        return bugSeqId;
    }

    public void setBugSeqId(String bugSeqId) {
        this.bugSeqId = bugSeqId;
    }

    @Basic
    @Column(name = "bug_id")
    public String getBugId() {
        return bugId;
    }

    public void setBugId(String bugId) {
        this.bugId = bugId;
    }

    @Basic
    @Column(name = "txid")
    public Integer getTxid() {
        return txid;
    }

    public void setTxid(Integer txid) {
        this.txid = txid;
    }

    @Basic
    @Column(name = "txid_rank")
    public String getTxidRank() {
        return txidRank;
    }

    public void setTxidRank(String txidRank) {
        this.txidRank = txidRank;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperBugEntity that = (SuperBugEntity) o;
        return Objects.equals(bugSeqId, that.bugSeqId) && Objects.equals(bugId, that.bugId) && Objects.equals(txid, that.txid) && Objects.equals(txidRank, that.txidRank) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bugSeqId, bugId, txid, txidRank, name);
    }
}
