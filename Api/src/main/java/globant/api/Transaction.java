package globant.api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Crecion de Transacion ( https://www.jsonschema2pojo.org/)pojo
 */

public class Transaction implements Serializable {

    private String id;
    private String name;
    private String lastName;
    private String accountNumber;
    private String amount;
    private String transactionType;
    private String email;
    private Boolean active;
    private String country;
    private String telephone;

    /**
     * No args constructor for use in serialization
     */
    public Transaction() {
    }

    /**
     * @param transactionType
     * @param lastName
     * @param country
     * @param amount
     * @param name
     * @param active
     * @param telephone
     * @param id
     * @param accountNumber
     * @param email
     */
    public Transaction(String id, String name, String lastName, String accountNumber, String amount, String transactionType, String email, Boolean active, String country, String telephone) {
        super();
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionType = transactionType;
        this.email = email;
        this.active = active;
        this.country = country;
        this.telephone = telephone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


}
