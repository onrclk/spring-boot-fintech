package tr.com.fintech.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class TransactionsListResponse implements Serializable {

    @JsonProperty("per_page")
    private Integer per_page;

    @JsonProperty("current_page")
    private Integer current_page;

    @JsonProperty("next_page_url")
    private String next_page_url;

    @JsonProperty("prev_page_url")
    private String prev_page_url;

    @JsonProperty("from")
    private Integer from;

    @JsonProperty("to")
    private Integer to;

    @JsonProperty("data")
    private List<TransactionInfo> data;


    public Integer getPer_page() {
        return per_page;
    }

    public void setPer_page(Integer per_page) {
        this.per_page = per_page;
    }

    public Integer getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(Integer current_page) {
        this.current_page = current_page;
    }

    public String getNext_page_url() {
        return next_page_url;
    }

    public void setNext_page_url(String next_page_url) {
        this.next_page_url = next_page_url;
    }

    public String getPrev_page_url() {
        return prev_page_url;
    }

    public void setPrev_page_url(String prev_page_url) {
        this.prev_page_url = prev_page_url;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public List<TransactionInfo> getData() {
        return data;
    }

    public void setData(List<TransactionInfo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TransactionsListResponse{" +
                "per_page=" + per_page +
                ", current_page=" + current_page +
                ", next_page_url='" + next_page_url + '\'' +
                ", prev_page_url='" + prev_page_url + '\'' +
                ", from=" + from +
                ", to=" + to +
                ", data=" + data +
                '}';
    }
}
