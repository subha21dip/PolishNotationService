# PolishNotationService

Configure and Run project

Java 11 and maven is needed to compile and run this code.

1. Clone the repository to local disk
2. navigate to PolishNotationService folder and execute :
        
        mvn spring-boot:run

    it will compile and start the service at the port 8080
   
API request example : 

    POST : http://localhost:8080/api/v1/expressions
    sample body (json):
        {
        "expressions" : [{
            "exp_no" : 1,
            "expression" : "- 2e3 - 700 + 7 * 2 15"
            },
            {
            "exp_no" : 1,
            "expression" : "+ + 0.5 1.5 * 4 10"
            },
            {
            "exp_no" : 1,
            "expression" : "1 2"
            },
            {
            "exp_no" : 1,
            "expression" : "+ 1"
            }]
        }

    Expected result : 
        {
        "results": [
            {
            "exp_no": 1,
            "result": "1337,00"
            },
            {
            "exp_no": 1,
            "result": "42,00"
            },
            {
            "exp_no": 1,
            "result": "error"
            },
            {
            "exp_no": 1,
            "result": "error"
            }
            ]
        }
        
 
