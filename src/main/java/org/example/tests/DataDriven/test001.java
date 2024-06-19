package org.example.tests.DataDriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class test001 {

    @DataProvider
    public Object[][] getData(){
      return new Object[][]{
              new Object[]{"adegregmin" ,"password"},
              new Object[]{"admergin" ,"padssword"},
              new Object[]{"adgmin" ,"passsword"},
              new Object[]{"admerin" ,"pasgsswofrd"},
              new Object[]{"adeemin" ,"pasesword"},
              new Object[]{"adgrmin" ,"passswgord"},
              new Object[]{"adgrmien" ,"paergergssword"},
              new Object[]{"adrevfmin" ,"pgetgbvassword"},

        };

    }

    @Test(dataProvider = "getData")
    public void loginTest(String username , String password){
        System.out.println(username);
        System.out.println(password);
    }

}
