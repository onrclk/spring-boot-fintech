package tr.com.fintech.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Transaction implements Serializable {

    @JsonProperty("merchant")
    private Merchant merchant;

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "merchant=" + merchant +
                '}';
    }
}
