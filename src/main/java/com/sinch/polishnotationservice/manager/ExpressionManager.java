package com.sinch.polishnotationservice.manager;

import com.sinch.polishnotationservice.exception.UnsupportedOperatorException;
import com.sinch.polishnotationservice.model.ExpressionVO;
import com.sinch.polishnotationservice.model.ExpressionsVO;
import com.sinch.polishnotationservice.model.ResultVO;
import com.sinch.polishnotationservice.model.ResultsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionManager {
    private static final Logger logger = LoggerFactory.getLogger(ExpressionManager.class);

    public Double calculate(double op1, double op2, char operator, int number) throws UnsupportedOperatorException {
        switch (operator) {
            case '+':
                return op1 + op2;
            case '-':
                return op2 - op1;
            case '*':
                return op1 * op2;
            case '/':
                if (op1 == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return op2 / op1;
            default: throw new
                    UnsupportedOperatorException(" unsupported operator " + operator + " in expression number : " + number);
        }
    }
    public ResultsVO evaluate(ExpressionsVO expressionList) {
        ResultsVO results = new ResultsVO();
        List<ResultVO> resultList = new ArrayList<>();
        for (ExpressionVO expression : expressionList.getExpressions()) {
            ResultVO result = new ResultVO();
            int number = expression.getNumber();
            result.setNumber(number);

            // Treat space as separator
            String input[] = expression.getExpression().split(" ");
            Stack<Double> stack = new Stack<>();

            boolean isError = false;

            for (int index = input.length - 1; index >= 0; index--) {
                String element = input[index];
                try {
                    if (element.equals("*") || element.equals("/") || element.equals("+") || element.equals("-")) {
                        double s1 = stack.pop();
                        double s2 = stack.pop();
                        double temp = calculate(s2, s1, element.charAt(0), number);
                        stack.push(temp);
                    } else {
                        //if here means, its a digit or exponential value
                        //extract the characters and store it in num
                        double num = Double.parseDouble(element);
                        stack.push(num);
                    }
                } catch (Exception e) {
                    logger.debug("problem evaluating expression number : " +  + number + e.getMessage());
                    isError = true;
                    break;
                }
            }
            if (!isError && stack.size() == 1) {
                double value = stack.pop();
                DecimalFormat df = new DecimalFormat("####0.00");
                result.setResult(df.format(value));
            } else
                result.setResult("error");
            resultList.add(result);
        }
        results.setResults(resultList);
        return results;
    }
}
