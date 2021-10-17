package cn.edu.tongji.software_igem2021.igemwebbackend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bacteria_taxon", schema = "iGEM_database", catalog = "")
public class BacteriaTaxonEntity {
    private int taxonId;
    private Integer parentId;
    private String rank;
    private String name;

    @Id
    @Column(name = "taxon_id")
    public int getTaxonId() {
        return taxonId;
    }

    public void setTaxonId(int taxonId) {
        this.taxonId = taxonId;
    }

    @Basic
    @Column(name = "parent_id")
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "rank")
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
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
        BacteriaTaxonEntity that = (BacteriaTaxonEntity) o;
        return taxonId == that.taxonId && Objects.equals(parentId, that.parentId) && Objects.equals(rank, that.rank) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taxonId, parentId, rank, name);
    }
}
