package com.example.chet.config.tests.tests;// Generated by Selenium IDE
import com.example.chet.config.tests.AuthBase;
import com.example.chet.config.tests.TestBasClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

public class DeleteTest extends AuthBase {

  @Test
  public void delete() {
//    appMan.getNavHelp().OpenMainPage();
//    appMan.getAuthHelp().EnterLoginAndPassword();
    appMan.getChangeHelp().DeleteRep();
    appMan.getNavHelp().OpenMainPage();
  }

}