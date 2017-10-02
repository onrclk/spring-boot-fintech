package tr.com.fintech.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionGetResponse {

    @JsonProperty("fx")
    private FX fx;

    @JsonProperty("customerInfo")
    private CustomerInfo customerInfo;

    @JsonProperty("merchant")
    private Merchant merchant;

    @JsonProperty("transaction")
    private Transaction transaction;

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

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "TransactionGetResponse{" +
                "fx=" + fx +
                ", customerInfo=" + customerInfo +
                ", merchant=" + merchant +
                ", transaction=" + transaction +
                '}';
    }
}
