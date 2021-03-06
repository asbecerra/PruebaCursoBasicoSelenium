package MailChimpTest;

import org.testng.annotations.DataProvider;

public class DataProviderMailChimp {
    @DataProvider(name="emails")
    public Object[][] email(){
        return new Object[][] {
                {"olci34@as.com"},
                {"dine3@dh.com"},
                {"mrkd@and.com"}
        };
    }
}
