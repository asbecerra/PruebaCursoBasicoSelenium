package MailChimpTest;

import org.testng.annotations.Factory;

public class FactoryMailChimpTest {
    @Factory
    public Object[] mailChimpFactoryTest(){
        return new Object[]{
                new MailChimpTest(),
                new MailChimpTest(),
        };
    }


}
