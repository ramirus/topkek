package com.example.chet.config.t3;

import com.example.chet.config.t3.helpers.AuthHelp;
import com.example.chet.config.t3.helpers.ChangeHelp;
import com.example.chet.config.t3.helpers.NavHelp;
import lombok.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

@Getter
public class AppMan {
    WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    private AuthHelp authHelp;
    private ChangeHelp changeHelp;
    private NavHelp navHelp;

    private static ThreadLocal<AppMan> app=new ThreadLocal<>();

    public static AppMan getInstance(){
        if(app.get()==null){
            System.out.println("ALARM");
            AppMan newInst=new AppMan();
            app.set(newInst);
            newInst.navHelp.OpenMainPage();
            return app.get();
        }
        return  app.get();
    }
    public AppMan() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\oleji\\Downloads\\geckodriver.exe");
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        authHelp = new AuthHelp(this);
        changeHelp = new ChangeHelp(this);
        String baseUrl = "https://hub.docker.com";
        navHelp = new NavHelp(this,baseUrl );

    }
}
