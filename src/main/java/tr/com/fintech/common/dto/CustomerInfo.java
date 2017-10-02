package tr.com.fintech.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import tr.com.fintech.common.utils.LocalDateDeserializer;
import tr.com.fintech.common.utils.LocalDateSerializer;
import tr.com.fintech.common.utils.LocalDateTimeDeserializer;
import tr.com.fintech.common.utils.LocalDateTimeSerializer;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CustomerInfo implements Serializable {

    @JsonProperty("id")
    private Integer id;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonProperty("created_at")
    private LocalDateTime created_at;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonProperty("updated_at")
    private LocalDateTime updated_at;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonProperty("deleted_at")
    private LocalDateTime deleted_at;

    @JsonProperty("expiryMonth")
    private String expiryMonth;

    @JsonProperty("expiryYear")
    private String expiryYear;

    @JsonProperty("startMonth")
    private String startMonth;

    @JsonProperty("startYear")
    private String startYear;

    @JsonProperty("issueNumber")
    private String issueNumber;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonProperty("birthday")
    private LocalDateTime birthday;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("billingTitle")
    private String billingTitle;

    @JsonProperty("billingCompany")
    private String billingCompany;

    @JsonProperty("billingAddress1")
    private String billingAddress1;

    @JsonProperty("billingAddress2")
    private String billingAddress2;

    @JsonProperty("billingCity")
    private String billingCity;

    @JsonProperty("billingPostcode")
    private String billingPostcode;

    @JsonProperty("billingState")
    private String billingState;

    @JsonProperty("billingCountry")
    private String billingCountry;

    @JsonProperty("billingPhone")
    private String billingPhone;

    @JsonProperty("billingFax")
    private String billingFax;

    @JsonProperty("shippingTitle")
    private String shippingTitle;

    @JsonProperty("shippingFirstName")
    private String shippingFirstName;

    @JsonProperty("shippingLastName")
    private String shippingLastName;

    @JsonProperty("shippingCompany")
    private String shippingCompany;

    @JsonProperty("shippingAddress1")
    private String shippingAddress1;

    @JsonProperty("shippingAddress2")
    private String shippingAddress2;

    @JsonProperty("shippingCity")
    private String shippingCity;

    @JsonProperty("shippingPostcode")
    private String shippingPostcode;

    @JsonProperty("shippingState")
    private String shippingState;

    @JsonProperty("shippingCountry")
    private String shippingCountry;

    @JsonProperty("shippingPhone")
    private String shippingPhone;

    @JsonProperty("shippingFax")
    private String shippingFax;

    @JsonProperty("number")
    private String number;

    @JsonProperty("email")
    private String email;

    @JsonProperty("billingFirstName")
    private String billingFirstName;

    @JsonProperty("billingLastName")
    private String billingLastName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public LocalDateTime getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDateTime deleted_at) {
        this.deleted_at = deleted_at;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBillingTitle() {
        return billingTitle;
    }

    public void setBillingTitle(String billingTitle) {
        this.billingTitle = billingTitle;
    }

    public String getBillingCompany() {
        return billingCompany;
    }

    public void setBillingCompany(String billingCompany) {
        this.billingCompany = billingCompany;
    }

    public String getBillingAddress1() {
        return billingAddress1;
    }

    public void setBillingAddress1(String billingAddress1) {
        this.billingAddress1 = billingAddress1;
    }

    public String getBillingAddress2() {
        return billingAddress2;
    }

    public void setBillingAddress2(String billingAddress2) {
        this.billingAddress2 = billingAddress2;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingPostcode() {
        return billingPostcode;
    }

    public void setBillingPostcode(String billingPostcode) {
        this.billingPostcode = billingPostcode;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public String getBillingPhone() {
        return billingPhone;
    }

    public void setBillingPhone(String billingPhone) {
        this.billingPhone = billingPhone;
    }

    public String getBillingFax() {
        return billingFax;
    }

    public void setBillingFax(String billingFax) {
        this.billingFax = billingFax;
    }

    public String getShippingTitle() {
        return shippingTitle;
    }

    public void setShippingTitle(String shippingTitle) {
        this.shippingTitle = shippingTitle;
    }

    public String getShippingFirstName() {
        return shippingFirstName;
    }

    public void setShippingFirstName(String shippingFirstName) {
        this.shippingFirstName = shippingFirstName;
    }

    public String getShippingLastName() {
        return shippingLastName;
    }

    public void setShippingLastName(String shippingLastName) {
        this.shippingLastName = shippingLastName;
    }

    public String getShippingCompany() {
        return shippingCompany;
    }

    public void setShippingCompany(String shippingCompany) {
        this.shippingCompany = shippingCompany;
    }

    public String getShippingAddress1() {
        return shippingAddress1;
    }

    public void setShippingAddress1(String shippingAddress1) {
        this.shippingAddress1 = shippingAddress1;
    }

    public String getShippingAddress2() {
        return shippingAddress2;
    }

    public void setShippingAddress2(String shippingAddress2) {
        this.shippingAddress2 = shippingAddress2;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    public String getShippingPostcode() {
        return shippingPostcode;
    }

    public void setShippingPostcode(String shippingPostcode) {
        this.shippingPostcode = shippingPostcode;
    }

    public String getShippingState() {
        return shippingState;
    }

    public void setShippingState(String shippingState) {
        this.shippingState = shippingState;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    public String getShippingPhone() {
        return shippingPhone;
    }

    public void setShippingPhone(String shippingPhone) {
        this.shippingPhone = shippingPhone;
    }

    public String getShippingFax() {
        return shippingFax;
    }

    public void setShippingFax(String shippingFax) {
        this.shippingFax = shippingFax;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBillingFirstName() {
        return billingFirstName;
    }

    public void setBillingFirstName(String billingFirstName) {
        this.billingFirstName = billingFirstName;
    }

    public String getBillingLastName() {
        return billingLastName;
    }

    public void setBillingLastName(String billingLastName) {
        this.billingLastName = billingLastName;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "number='" + number + '\'' +
                ", email='" + email + '\'' +
                ", billingFirstName='" + billingFirstName + '\'' +
                ", billingLastName='" + billingLastName + '\'' +
                '}';
    }
}
