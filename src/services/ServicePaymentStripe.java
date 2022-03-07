/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Card;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Token;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author anwer
 */
public class ServicePaymentStripe {
    private String email;
    private String name;
    private int ammount;
    private String card;

    public ServicePaymentStripe() {
    }

    public ServicePaymentStripe(String email, String name, int ammount, String card) {
        this.email = email;
        this.name = name;
        this.ammount = ammount;
        this.card = card;
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }
    
    public void payer() throws StripeException{
        
        Stripe.apiKey = "sk_test_51J0o1TJskwqPn1t8oizrAyuzGP7lZtqMYlJB4XeGGj3lkiRR2f8dE1tJMfjxSwPkOMdeVoS70WD1V0i62yC3qAv8003a71SlNh";
        
        Map<String, Object> EmailOptions = new HashMap<>();
            EmailOptions.put("email", email);
            List<Customer> customersEmailEx = Customer.list(EmailOptions).getData();
            
            
            if(customersEmailEx.size()>0){
                
               if(customersEmailEx.get(0).getDefaultSource()==null){
                            Map<String, Object> retrieveParams =
                              new HashMap<>();
                            List<String> expandList = new ArrayList<>();
                            expandList.add("sources");
                            retrieveParams.put("expand", expandList);
                             Customer customerEx =
                                      Customer.retrieve(
                                        customersEmailEx.get(0).getId(),
                                        retrieveParams,
                                        null
                                      );
                             System.out.println(customerEx);
                             Map<String, Object> cardParam = new HashMap<String, Object>(); //add card details
                            cardParam.put("number", card);
                            cardParam.put("exp_month", "11");
                            cardParam.put("exp_year", "2026");
                            cardParam.put("cvc", "123");

                            Map<String, Object> tokenParam = new HashMap<String, Object>();
                            tokenParam.put("card", cardParam);

                            Token token = Token.create(tokenParam); // create a token

                            Map<String, Object> source = new HashMap<String, Object>();
                            source.put("source", token.getId()); //add token as source

                            Card card =(Card) customerEx.getSources().create(source);

                            Map<String, Object> chargePram = new HashMap<>();
                            chargePram.put("amount", ammount);
                            chargePram.put("currency", "usd");
                            chargePram.put("customer", customerEx.getId());
                            Charge.create(chargePram);
                            //System.out.println("qscqscqs");
                }else{
                   Map<String, Object> retrieveParams =
                              new HashMap<>();
                            List<String> expandList = new ArrayList<>();
                            expandList.add("sources");
                            retrieveParams.put("expand", expandList);
                             Customer customer =
                                      Customer.retrieve(
                                        customersEmailEx.get(0).getId(),
                                        retrieveParams,
                                        null
                                      );
                             Map<String, Object> chargePram = new HashMap<>();
                            chargePram.put("amount", ammount);
                            chargePram.put("currency", "usd");
                            chargePram.put("customer", customer.getId());
                            Charge.create(chargePram);
                            System.out.println(customer);
               }
               
               
            }else{
                Map<String, Object> params = new HashMap<>();
                params.put("email", email);
                params.put("name", name);

                Customer customer = Customer.create(params);
                
                Map<String, Object> EmailOptions2 = new HashMap<>();
                EmailOptions2.put("email", email);
                List<Customer> customersEmailNew = Customer.list(EmailOptions).getData();
                System.out.println(customersEmailNew);
                Map<String, Object> retrieveParams =
                              new HashMap<>();
                            List<String> expandList = new ArrayList<>();
                            expandList.add("sources");
                            retrieveParams.put("expand", expandList);
                             Customer customerNew =
                                      Customer.retrieve(
                                        customersEmailNew.get(0).getId(),
                                        retrieveParams,
                                        null
                                      );
                             Map<String, Object> cardParam = new HashMap<String, Object>(); //add card details
                            cardParam.put("number", card);//4111111111111111
                            cardParam.put("exp_month", "11");
                            cardParam.put("exp_year", "2026");
                            cardParam.put("cvc", "123");

                            Map<String, Object> tokenParam = new HashMap<String, Object>();
                            tokenParam.put("card", cardParam);

                            Token token = Token.create(tokenParam); // create a token

                            Map<String, Object> source = new HashMap<String, Object>();
                            source.put("source", token.getId()); //add token as source

                            Card card =(Card) customerNew.getSources().create(source);

                            Map<String, Object> chargePram = new HashMap<>();
                            chargePram.put("amount", ammount);
                            chargePram.put("currency", "usd");
                            chargePram.put("customer", customerNew.getId());
                            Charge.create(chargePram);
                
            }
    }
    
}
