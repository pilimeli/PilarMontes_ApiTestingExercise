package globant.api;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Unit test for simple App.
 */
public class EjercicioApiTesting {
    private static final String API_URL = "https://60846c479b2bed0017040f8d.mockapi.io/Transaction";


    /**
     * Verify the endpoint is empty first exercise
     */

    @Test (priority = 0)
    public void testGetDataAndDelete() throws InterruptedException {
        int statusCode = 200;
        Transaction[] transactions;
        transactions = given().contentType("application/json")
                .when().get(API_URL)
                .then().statusCode(statusCode)
                .extract().as(Transaction[].class);

        if (transactions.length > 0) {
            for (Transaction transaction : transactions) {
                given().contentType("application/json")
                        .when().delete(API_URL + "/" + transaction.getId())
                        .then().statusCode(statusCode);
                Thread.sleep(1000);
            }
        }
    }

    /**
     * Verify the data random avoiding duplicate emails
     */
    @Test (priority = 1)
    public void testCreateData () throws InterruptedException {
        List<Transaction> txs = TransactionGenerator.generate().objects(Transaction.class, 20).collect(Collectors.toList());

        for (Transaction tx : txs) {
            int indexTx = txs.indexOf(tx);

            //check if email exists
            for (Transaction txChecked : txs) {
                if (indexTx != txs.indexOf(txChecked) && tx.getEmail().equals(txChecked.getEmail())) {
                    tx.setEmail(tx.getEmail() + TransactionGenerator.generate().nextObject(String.class));
                }
                break;
            }

            tx.setEmail(tx.getEmail() + "@mockmail.com");

            given().
                    contentType("application/json").
                    body(tx).
                    when().
                    post(API_URL);
            Thread.sleep(1000);


        }
    }
    @Test (priority = 2)
    public static void negativeTest(){
        int statusCode = 200;
        Transaction[] transactions;
        transactions = given().contentType("application/json")
                .when().get(API_URL)
                .then().statusCode(statusCode)
                .extract().as(Transaction[].class);

        if (transactions.length > 0) {
            Transaction txToSend = transactions[0];
            for (int i=1; i < transactions.length; i++) {
               if (txToSend.getEmail().equals(transactions[i].getEmail())){
                   System.out.println("Email Exists");
               }


            }
        }

    }

    @Test (priority = 3)
    public static void updateAccountNumber(){
        int statusCode = 200;
        Transaction[] transactions;
        transactions = given().contentType("application/json")
                .when().get(API_URL)
                .then().statusCode(statusCode)
                .extract().as(Transaction[].class);

        if (transactions.length > 0) {
            Transaction txToSend = transactions[0];
           txToSend.setAccountNumber("123");
            given().
                    contentType("application/json").
                    body(txToSend).
                    when().
                    put(API_URL + "/" + txToSend.getId());
        }

    }


}
