package com.aiways.cases.androidapplicationtest;

import com.aiways.Invokers.CommonInvoker;
import com.aiways.Invokers.LoginInvoker;
import com.aiways.Invokers.NewsInvoker;
import com.aiways.Invokers.SetCapabilitiesInvoker;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;


@ContextConfiguration(locations = { "classpath:spring-test-config.xml" })
public abstract class AbstractTestCase extends AbstractTestNGSpringContextTests {

    @Autowired
    protected CommonInvoker _commonInvoker;

    @Autowired
    protected LoginInvoker _loginInvoker;

    @Autowired
    protected NewsInvoker _newsInvoker;

    @BeforeClass
    public void setTestContext(ITestContext context) {

        if (null == context.getAttribute(LoginInvoker.class.getTypeName())) {
            context.setAttribute(LoginInvoker.class.getTypeName(), _loginInvoker);
        }

        if (null == context.getAttribute(NewsInvoker.class.getTypeName())) {
            context.setAttribute(NewsInvoker.class.getTypeName(), _newsInvoker);
        }

        if (null == context.getAttribute(CommonInvoker.class.getTypeName())) {
            context.setAttribute(CommonInvoker.class.getTypeName(), _commonInvoker);
        }
    }

}

