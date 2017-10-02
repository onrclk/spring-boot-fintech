package tr.com.fintech.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ReportResponseData implements Serializable {

    @JsonProperty("count")
    private Integer count;

    @JsonProperty("total")
    private Integer total;

    @JsonProperty("currency")
    private String currency;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "ReportResponseData{" +
                "count=" + count +
                ", total=" + total +
                ", currency='" + currency + '\'' +
                '}';
    }
}
