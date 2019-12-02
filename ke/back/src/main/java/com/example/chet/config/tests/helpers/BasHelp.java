package com.example.chet.config.t3.helpers;

import com.example.chet.config.t3.AppMan;
import org.openqa.selenium.WebDriver;

public class BasHelp {
    WebDriver driver ;
    private AppMan appMan;
    public BasHelp(AppMan appMan1){
        this.appMan=appMan1;
        this.driver=appMan1.getDriver();
    }
}
