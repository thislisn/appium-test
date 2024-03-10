package com.appium.step_defs;

import com.appium.core.ContextManager;
import com.appium.core.app.AndroidDriverManager;
import com.appium.core.app.AppiumServerManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before()
    public void init() {
        ContextManager.initContext();
        AppiumServerManager.startServer();
        AndroidDriverManager.init();
    }

    @After(order = 1)
    public void close() {
        ContextManager.destroyContext();
        AndroidDriverManager.quit();
        AppiumServerManager.stopServer();
    }
}
