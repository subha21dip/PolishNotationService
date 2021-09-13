package com.sinch.polishnotationservice.controller;

import com.sinch.polishnotationservice.manager.ExpressionManager;
import com.sinch.polishnotationservice.model.ErrorResponseBodyVO;
import com.sinch.polishnotationservice.model.ExpressionsVO;
import com.sinch.polishnotationservice.model.ResultsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class EvaluationController {

    private static final Logger logger = LoggerFactory.getLogger(EvaluationController.class);
    ExpressionManager expressionManager = new ExpressionManager();
    private final String FAILURE_STATUS = "fail";

    /*
    Get a list of expressions in polish notation
    evaluate the results and return as json data
    */
    @PostMapping("/v1/expressions")
    public ResponseEntity<?> evaluateExpressions(@RequestBody ExpressionsVO expressions) throws IOException {
        logger.info("Got expression list with : " + expressions.getExpressions().size() + " expressions using API : /v1/expressions");
        try {
            ResultsVO results = expressionManager.evaluate(expressions);
            return new ResponseEntity<>(results, HttpStatus.OK);
        }catch (Exception e){
            logger.error("Got exception " + e.getMessage() + " when evaluating expression. ");
            return new ResponseEntity<>(new ErrorResponseBodyVO(FAILURE_STATUS, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
