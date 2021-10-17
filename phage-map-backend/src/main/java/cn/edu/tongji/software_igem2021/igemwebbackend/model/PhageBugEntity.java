package cn.edu.tongji.software_igem2021.igemwebbackend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "phage_bug", schema = "iGEM_database", catalog = "")
public class PhageBugEntity {
    private String phageId;
    private String name;
    private Integer txid;
    private String txidRank;
    private Integer genusTxid;
    private Integer familyTxid;
    private Integer orderTxid;

    @Id
    @Column(name = "phage_id")
    public String getPhageId() {
        return phageId;
    }

    public void setPhageId(String phageId) {
        this.phageId = phageId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "genus_txid")
    public Integer getGenusTxid() {
        return genusTxid;
    }

    public void setGenusTxid(Integer genusTxid) {
        this.genusTxid = genusTxid;
    }

    @Basic
    @Column(name = "family_txid")
    public Integer getFamilyTxid() {
        return familyTxid;
    }

    public void setFamilyTxid(Integer familyTxid) {
        this.familyTxid = familyTxid;
    }

    @Basic
    @Column(name = "order_txid")
    public Integer getOrderTxid() {
        return orderTxid;
    }

    public void setOrderTxid(Integer orderTxid) {
        this.orderTxid = orderTxid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhageBugEntity that = (PhageBugEntity) o;
        return Objects.equals(phageId, that.phageId) && Objects.equals(name, that.name) && Objects.equals(txid, that.txid) && Objects.equals(txidRank, that.txidRank) && Objects.equals(genusTxid, that.genusTxid) && Objects.equals(familyTxid, that.familyTxid) && Objects.equals(orderTxid, that.orderTxid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phageId, name, txid, txidRank, genusTxid, familyTxid, orderTxid);
    }
}
