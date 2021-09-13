package com.sinch.polishnotationservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExpressionsVO {

    @JsonProperty("expressions")
    List<ExpressionVO> expressions;

    public List<ExpressionVO> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<ExpressionVO> expressions) {
        this.expressions = expressions;
    }
}
