package com.ahold.ecommerce.definitions;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = {"classpath:spring-properties/cucumber-context.xml"})
public abstract class BaseStepDef {

    @Autowired
    protected WebDriver webDriver;

    // NOTE!!
    // "You're not allowed to extend classes that define Step Definitions or hooks."
    // So don't add any steps here.
}