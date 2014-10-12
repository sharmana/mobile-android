package com.sharmana.db.dto;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MandM on 11.10.2014.
 */
public class EventDTO {

    public static enum Status {

        OPEN("open"),
        CLOSED("closed");
        private final String value;
        private static Map<String, Status> constants = new HashMap<String, Status>();

        static {
            for (EventDTO.Status c: values()) {
                constants.put(c.value, c);
            }
        }

        private Status(String value) {
            this.value = value;
        }

        @JsonValue
        @Override
        public String toString() {
            return this.value;
        }

        @JsonCreator
        public static EventDTO.Status fromValue(String value) {
            EventDTO.Status constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }
//
//    public enum Status {
//        OPEN,
//        CLOSED
//    }
//
//    @JsonProperty(value = "_id")
//    public String getId() {
//        return _id;
//    }
//
//    @JsonProperty(value = "_id")
//    public void setId(String _id) {
//        this._id = _id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getCurrency() {
//        return currency;
//    }
//
//    public void setCurrency(String currency) {
//        this.currency = currency;
//    }
//
//    public double getTotal() {
//        return total;
//    }
//
//    public void setTotal(double total) {
//        this.total = total;
//    }
//
//    public Long getCreated() {
//        return created;
//    }
//
//    public void setCreated(Long created) {
//        this.created = created;
//    }
//
//    public List<String> getEmails() {
//        return emails;
//    }
//
//    public void setEmails(List<String> emails) {
//        this.emails = emails;
//    }
//
//    
//    public List<TransactionDTO> getTransactions() {
//        return transactions;
//    }
//
//    public void setTransactions(List<TransactionDTO> transactions) {
//        this.transactions = transactions;
//    }
//
//    public Status getStatus() {
//        return status;
//    }
//
//    public void setStatus(Status status) {
//        this.status = status;
//    }
//
//    private String _id;
//    private String name;
//    private String currency;
//    private double total;
//    private Long created;
//    private List<String> emails;
//    private List<TransactionDTO> transactions;
//    private Status status;

   @JsonProperty("_id")
    private String Id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("total")
    private Double total;
    @JsonProperty("created")
    private Long created;
    @JsonProperty("emails")
    private List<String> emails = new ArrayList<String>();
    @JsonProperty("transactions")
    private List<TransactionDTO> transactions = new ArrayList<TransactionDTO>();
    @JsonProperty("checkouts")
    private List<CheckoutDTO> checkouts = new ArrayList<CheckoutDTO>();
    @JsonProperty("status")
    private EventDTO.Status status = Status.fromValue("open");


    /**
     *
     * @return
     *     The Id
     */
    @JsonProperty("_id")
    public String getId() {
        return Id;
    }

    /**
     *
     * @param Id
     *     The _id
     */
    @JsonProperty("_id")
    public void setId(String Id) {
        this.Id = Id;
    }

    public EventDTO withId(String Id) {
        this.Id = Id;
        return this;
    }

    /**
     *
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public EventDTO withName(String name) {
        this.name = name;
        return this;
    }

    /**
     *
     * @return
     *     The currency
     */
    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    /**
     *
     * @param currency
     *     The currency
     */
    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public EventDTO withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     *
     * @return
     *     The total
     */
    @JsonProperty("total")
    public Double getTotal() {
        return total;
    }

    /**
     *
     * @param total
     *     The total
     */
    @JsonProperty("total")
    public void setTotal(Double total) {
        this.total = total;
    }

    public EventDTO withTotal(Double total) {
        this.total = total;
        return this;
    }

    /**
     *
     * @return
     *     The created
     */
    @JsonProperty("created")
    public Long getCreated() {
        return created;
    }

    /**
     *
     * @param created
     *     The created
     */
    @JsonProperty("created")
    public void setCreated(Long created) {
        this.created = created;
    }

    public EventDTO withCreated(Long created) {
        this.created = created;
        return this;
    }

    /**
     *
     * @return
     *     The emails
     */
    @JsonProperty("emails")
    public List<String> getEmails() {
        return emails;
    }

    /**
     *
     * @param emails
     *     The emails
     */
    @JsonProperty("emails")
    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public EventDTO withEmails(List<String> emails) {
        this.emails = emails;
        return this;
    }

    /**
     *
     * @return
     *     The transactions
     */
    @JsonProperty("transactions")
    public List<TransactionDTO> getTransactions() {
        return transactions;
    }

    /**
     *
     * @param transactions
     *     The transactions
     */
    @JsonProperty("transactions")
    public void setTransactions(List<TransactionDTO> transactions) {
        this.transactions = transactions;
    }

    public EventDTO withTransactions(List<TransactionDTO> transactions) {
        this.transactions = transactions;
        return this;
    }

    /**
     *
     * @return
     *     The checkouts
     */
    @JsonProperty("checkouts")
    public List<CheckoutDTO> getCheckouts() {
        return checkouts;
    }

    /**
     *
     * @param checkouts
     *     The checkouts
     */
    @JsonProperty("checkouts")
    public void setCheckouts(List<CheckoutDTO> checkouts) {
        this.checkouts = checkouts;
    }

    public EventDTO withCheckouts(List<CheckoutDTO> checkouts) {
        this.checkouts = checkouts;
        return this;
    }

    /**
     *
     * @return
     *     The status
     */
    @JsonProperty("status")
    public EventDTO.Status getStatus() {
        return status;
    }

    /**
     *
     * @param status
     *     The status
     */
    @JsonProperty("status")
    public void setStatus(EventDTO.Status status) {
        this.status = status;
    }

    public EventDTO withStatus(EventDTO.Status status) {
        this.status = status;
        return this;
    }
}
