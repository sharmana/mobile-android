package com.sharmana.db.dto;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by MandM on 11.10.2014.
 */
public class TransactionDTO {

    @JsonProperty("_id")
    private String id;
    @JsonProperty("who")
    private String who;
    @JsonProperty("count")
    private Double count;
    @JsonProperty("date")
    private Long date;
    @JsonProperty("comment")
    private String comment;

    /**
     *
     * @return
     *     The id
     */
    @JsonProperty("_id")
    public String getId
    () {
        return id;
    }

    /**
     *
     * @param id
     *     The who
     */
    @JsonProperty("_id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     *     The who
     */
    @JsonProperty("who")
    public String getWho() {
        return who;
    }

    /**
     *
     * @param who
     *     The who
     */
    @JsonProperty("who")
    public void setWho(String who) {
        this.who = who;
    }

    public TransactionDTO withWho(String who) {
        this.who = who;
        return this;
    }

    /**
     *
     * @return
     *     The count
     */
    @JsonProperty("count")
    public Double getCount() {
        return count;
    }

    /**
     *
     * @param count
     *     The count
     */
    @JsonProperty("count")
    public void setCount(Double count) {
        this.count = count;
    }

    public TransactionDTO withCount(Double count) {
        this.count = count;
        return this;
    }

    /**
     *
     * @return
     *     The date
     */
    @JsonProperty("date")
    public Long getDate() {
        return date;
    }

    /**
     *
     * @param date
     *     The date
     */
    @JsonProperty("date")
    public void setDate(Long date) {
        this.date = date;
    }

    public TransactionDTO withDate(Long date) {
        this.date = date;
        return this;
    }

    /**
     *
     * @return
     *     The comment
     */
    @JsonProperty("comment")
    public String getComment() {
        return comment;
    }

    /**
     *
     * @param comment
     *     The comment
     */
    @JsonProperty("comment")
    public void setComment(String comment) {
        this.comment = comment;
    }

    public TransactionDTO withComment(String comment) {
        this.comment = comment;
        return this;
    }
}
