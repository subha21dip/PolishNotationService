package com.sinch.polishnotationservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExpressionVO {

    @JsonProperty("exp_no")
    private int number;
    @JsonProperty("expression")
    private String expression;

    public ExpressionVO(int number, String expression) {
        this.number = number;
        this.expression = expression;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
