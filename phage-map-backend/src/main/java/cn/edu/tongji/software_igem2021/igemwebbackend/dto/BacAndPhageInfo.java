package cn.edu.tongji.software_igem2021.igemwebbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BacAndPhageInfo {

    @JsonProperty("name")
    private String name;

    @JsonProperty("seqId")
    private String seqId;

    @JsonProperty("taxonId")
    private Integer taxonId;

}
