package tr.com.fintech.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class TransactionInfo implements Serializable {

    @JsonProperty("fx")
    private FX fx;

    @JsonProperty("customerInfo")
    private CustomerInfo customerInfo;

    @JsonProperty("merchant")
    private Merchant merchant;

    @JsonProperty("ipn")
    private Ipn ipn;

    @JsonProperty("transaction")
    private Transaction transaction;

    @JsonProperty("acquirer")
    private Acquirer acquirer;

    @JsonProperty("refundable")
    private Boolean refundable;


    public FX getFx() {
        return fx;
    }

    public void setFx(FX fx) {
        this.fx = fx;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public Ipn getIpn() {
        return ipn;
    }

    public void setIpn(Ipn ipn) {
        this.ipn = ipn;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Acquirer getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(Acquirer acquirer) {
        this.acquirer = acquirer;
    }

    public Boolean getRefundable() {
        return refundable;
    }

    public void setRefundable(Boolean refundable) {
        this.refundable = refundable;
    }

    @Override
    public String toString() {
        return "TransactionInfo{" +
                "fx=" + fx +
                ", customerInfo=" + customerInfo +
                ", merchant=" + merchant +
                ", ipn=" + ipn +
                ", transaction=" + transaction +
                ", acquirer=" + acquirer +
                ", refundable=" + refundable +
                '}';
    }
}
