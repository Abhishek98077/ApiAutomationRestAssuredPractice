package org.example.tests.DataDriven;

import org.testng.annotations.Test;

public class DDT01 {
    // to use excel we use apache poi lobrary
    @Test(dataProvider = "getData" , dataProviderClass = UtilExcel.class)
    public void testLogin( String username , String password) {
        System.out.println("Username:" + username);
        System.out.println("password:" + password);

    }
}
