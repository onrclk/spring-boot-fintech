package tr.com.fintech.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import tr.com.fintech.common.utils.LocalDateTimeDeserializer;
import tr.com.fintech.common.utils.LocalDateTimeSerializer;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Merchant implements Serializable {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("originalAmount")
    private Integer originalAmount;

    @JsonProperty("originalCurrency")
    private String originalCurrency;

    @JsonProperty("referenceNo")
    private String referenceNo;

    @JsonProperty("merchantId")
    private Integer merchantId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("channel")
    private String channel;

    @JsonProperty("customData")
    private String customData;

    @JsonProperty("chainId")
    private String chainId;

    @JsonProperty("agentInfoId")
    private Integer agentInfoId;

    @JsonProperty("operation")
    private String operation;

    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("fxTransactionId")
    private Integer fxTransactionId;

    @JsonProperty("acquirerTransactionId")
    private Integer acquirerTransactionId;

    @JsonProperty("transactionId")
    private String transactionId;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonProperty("updated_at")
    private LocalDateTime  updated_at;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonProperty("created_at")
    private LocalDateTime  created_at;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(Integer originalAmount) {
        this.originalAmount = originalAmount;
    }

    public String getOriginalCurrency() {
        return originalCurrency;
    }

    public void setOriginalCurrency(String originalCurrency) {
        this.originalCurrency = originalCurrency;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        this.customData = customData;
    }

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId;
    }

    public Integer getAgentInfoId() {
        return agentInfoId;
    }

    public void setAgentInfoId(Integer agentInfoId) {
        this.agentInfoId = agentInfoId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getFxTransactionId() {
        return fxTransactionId;
    }

    public void setFxTransactionId(Integer fxTransactionId) {
        this.fxTransactionId = fxTransactionId;
    }

    public Integer getAcquirerTransactionId() {
        return acquirerTransactionId;
    }

    public void setAcquirerTransactionId(Integer acquirerTransactionId) {
        this.acquirerTransactionId = acquirerTransactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
