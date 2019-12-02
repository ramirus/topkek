package com.example.chet.config.t3.helpers;

import com.example.chet.config.t3.AppMan;
import com.example.chet.config.t3.User;
import org.openqa.selenium.By;

public class AuthHelp extends BasHelp {
    public AuthHelp(AppMan appMan) {
        super(appMan);
    }

    public void EnterLoginAndPassword() {
        User user = new User("olejiksin", "QaZWsXEdC99");
        driver.findElement(By.id("log_in")).click();
        driver.findElement(By.id("nw_username")).sendKeys(user.getLogin());
        driver.findElement(By.id("nw_password")).click();
        driver.findElement(By.id("nw_password")).sendKeys(user.getPassword());
//        SubmitData();
    }

    public User getCreatedUser() {
        String name = driver.findElement(By.id("nw_username")).getText();
        String password = driver.findElement(By.id("nw_password")).getText();
        return User.builder()
                .login("olejiksin")
                .password("QaZWsXEdC99")
                .build();
    }

    public void SubmitData() {
        driver.findElement(By.id("nw_submit")).click();
    }
}
