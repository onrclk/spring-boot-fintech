package tr.com.fintech.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class JwtUserToken implements Serializable {

    @JsonProperty("merchantUserId")
    private Integer merchantUserId;

    @JsonProperty("role")
    private String role;

    @JsonProperty("merchantId")
    private Integer merchantId;

    @JsonProperty("subMerchantIds")
    private List<Integer> subMerchantIds = new ArrayList<>();

    @JsonFormat(shape=JsonFormat.Shape.NUMBER, pattern="s")
    public Timestamp timestamp;


    public Integer getMerchantUserId() {
        return merchantUserId;
    }

    public void setMerchantUserId(Integer merchantUserId) {
        this.merchantUserId = merchantUserId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public List<Integer> getSubMerchantIds() {
        return subMerchantIds;
    }

    public void setSubMerchantIds(List<Integer> subMerchantIds) {
        this.subMerchantIds = subMerchantIds;
    }
}
