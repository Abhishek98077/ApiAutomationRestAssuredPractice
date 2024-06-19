package org.example.tests.listner;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class tc001 {
    @Test(groups = "sanity")
        public void test001(){
            System.out.println("Test1");
        }

    @Test(groups = "regr")
    public void test002(){
        System.out.println("Test2");
    }
}
