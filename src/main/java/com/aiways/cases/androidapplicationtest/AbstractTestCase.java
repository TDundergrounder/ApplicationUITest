package com.aiways.cases.androidapplicationtest;

import com.aiways.Invokers.androidInvokers.CommonInvoker;
import com.aiways.Invokers.androidInvokers.LoginInvoker;
import com.aiways.Invokers.androidInvokers.NewsInvoker;
import com.aiways.Invokers.androidInvokers.TopicsInvoker;
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

    @Autowired
    protected TopicsInvoker _topicsInvoker;

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

        if (null == context.getAttribute(TopicsInvoker.class.getTypeName())) {
            context.setAttribute(TopicsInvoker.class.getTypeName(), _topicsInvoker);
        }
    }

}

