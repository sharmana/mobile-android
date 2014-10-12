package com.sharmana.db.dto;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by MandM on 12.10.2014.
 */
public class CheckoutDTO {

        @JsonProperty("who")
        private String who;
        @JsonProperty("to")
        private String to;
        @JsonProperty("count")
        private Double count;
        @JsonProperty("yamoney_url")
        private String yamoneyUrl;


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

        public CheckoutDTO withWho(String who) {
            this.who = who;
            return this;
        }

        /**
         *
         * @return
         *     The to
         */
        @JsonProperty("to")
        public String getTo() {
            return to;
        }

        /**
         *
         * @param to
         *     The to
         */
        @JsonProperty("to")
        public void setTo(String to) {
            this.to = to;
        }

        public CheckoutDTO withTo(String to) {
            this.to = to;
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

        public CheckoutDTO withCount(Double count) {
            this.count = count;
            return this;
        }

        /**
         *
         * @return
         *     The yamoneyUrl
         */
        @JsonProperty("yamoney_url")
        public String getYamoneyUrl() {
            return yamoneyUrl;
        }

        /**
         *
         * @param yamoneyUrl
         *     The yamoney_url
         */
        @JsonProperty("yamoney_url")
        public void setYamoneyUrl(String yamoneyUrl) {
            this.yamoneyUrl = yamoneyUrl;
        }

        public CheckoutDTO withYamoneyUrl(String yamoneyUrl) {
            this.yamoneyUrl = yamoneyUrl;
            return this;
        }

}
