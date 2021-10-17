package cn.edu.tongji.software_igem2021.igemwebbackend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NamedStoredProcedureQuery(name = "PhageEntity.getTaxonIdOfName",
        procedureName = "bacteria_taxon_id_of_name",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "s", type = String.class)
        }
)
@Table(name = "phage", schema = "iGEM_database", catalog = "")
public class PhageEntity {
    private String seqId;
    private Integer taxonId;
    private String scientificName;
    private String taxonRank;
    private Integer orderTxid;
    private Integer familyTxid;
    private Integer genusTxid;

    @Id
    @Column(name = "seq_id")
    public String getSeqId() {
        return seqId;
    }

    public void setSeqId(String seqId) {
        this.seqId = seqId;
    }

    @Basic
    @Column(name = "taxon_id")
    public Integer getTaxonId() {
        return taxonId;
    }

    public void setTaxonId(Integer taxonId) {
        this.taxonId = taxonId;
    }

    @Basic
    @Column(name = "scientific_name")
    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    @Basic
    @Column(name = "taxon_rank")
    public String getTaxonRank() {
        return taxonRank;
    }

    public void setTaxonRank(String taxonRank) {
        this.taxonRank = taxonRank;
    }

    @Basic
    @Column(name = "order_txid")
    public Integer getOrderTxid() {
        return orderTxid;
    }

    public void setOrderTxid(Integer orderTxid) {
        this.orderTxid = orderTxid;
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
    @Column(name = "genus_txid")
    public Integer getGenusTxid() {
        return genusTxid;
    }

    public void setGenusTxid(Integer genusTxid) {
        this.genusTxid = genusTxid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhageEntity that = (PhageEntity) o;
        return Objects.equals(seqId, that.seqId) && Objects.equals(taxonId, that.taxonId) && Objects.equals(scientificName, that.scientificName) && Objects.equals(taxonRank, that.taxonRank) && Objects.equals(orderTxid, that.orderTxid) && Objects.equals(familyTxid, that.familyTxid) && Objects.equals(genusTxid, that.genusTxid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seqId, taxonId, scientificName, taxonRank, orderTxid, familyTxid, genusTxid);
    }
}
