package com.appium.core.app;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AppiumServerManager {
    private static AppiumDriverLocalService service;

    public static void startServer(){
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File(System.getProperty("user.home") + "\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723).build();
        service.start();
    }

    public static void stopServer(){
        service.stop();
    }
}
