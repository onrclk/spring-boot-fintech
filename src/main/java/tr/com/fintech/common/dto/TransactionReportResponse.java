package tr.com.fintech.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import tr.com.fintech.common.StatusType;

import java.io.Serializable;
import java.util.List;

public class TransactionReportResponse implements Serializable{

    @JsonProperty("status")
    private StatusType status;

    @JsonProperty("response")
    private List<ReportResponseData> response;

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public List<ReportResponseData> getResponse() {
        return response;
    }

    public void setResponse(List<ReportResponseData> response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "TransactionReportResponse{" +
                "status=" + status +
                ", response=" + response +
                '}';
    }
}
