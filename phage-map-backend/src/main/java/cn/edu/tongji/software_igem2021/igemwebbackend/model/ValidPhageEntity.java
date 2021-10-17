package cn.edu.tongji.software_igem2021.igemwebbackend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "valid_phage", schema = "iGEM_database", catalog = "")
public class ValidPhageEntity {
    private String name;
    private String seqId;
    private Integer taxonId;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "seq_id")
    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValidPhageEntity that = (ValidPhageEntity) o;
        return Objects.equals(name, that.name) && Objects.equals(seqId, that.seqId) && Objects.equals(taxonId, that.taxonId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, seqId, taxonId);
    }
}
