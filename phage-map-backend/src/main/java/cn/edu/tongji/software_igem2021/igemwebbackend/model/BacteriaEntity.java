package cn.edu.tongji.software_igem2021.igemwebbackend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bacteria", schema = "iGEM_database", catalog = "")
public class BacteriaEntity {
    private String genebankId;
    private String refseqId;
    private String name;
    private Integer seqLength;
    private String seqNcbiId;
    private Integer taxonId;

    @Id
    @Column(name = "genebank_id")
    public String getGenebankId() {
        return genebankId;
    }

    public void setGenebankId(String genebankId) {
        this.genebankId = genebankId;
    }

    @Basic
    @Column(name = "refseq_id")
    public String getRefseqId() {
        return refseqId;
    }

    public void setRefseqId(String refseqId) {
        this.refseqId = refseqId;
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
    @Column(name = "seq_length")
    public Integer getSeqLength() {
        return seqLength;
    }

    public void setSeqLength(Integer seqLength) {
        this.seqLength = seqLength;
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
    @Column(name = "taxon_id")
    public Integer getTaxonId() {return taxonId;}

    public void setTaxonId(Integer taxonId) { this.taxonId = taxonId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BacteriaEntity that = (BacteriaEntity) o;
        return Objects.equals(genebankId, that.genebankId) && Objects.equals(refseqId, that.refseqId) && Objects.equals(name, that.name) && Objects.equals(seqLength, that.seqLength) && Objects.equals(seqNcbiId, that.seqNcbiId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genebankId, refseqId, name, seqLength, seqNcbiId);
    }
}
