package com.aiways.cases.iosapplicationtest;

import com.aiways.Invokers.iosInvokers.IOSCommonInvoker;
import com.aiways.Invokers.iosInvokers.IOSLoginOutInvoker;
import com.aiways.Invokers.iosInvokers.IOSNewsInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;


@ContextConfiguration(locations = { "classpath:spring-test-config.xml" })
public abstract class AbstractIOSTestCase extends AbstractTestNGSpringContextTests {

    @Autowired
    protected IOSCommonInvoker _ioscommonInvoker;

    @Autowired
    protected IOSLoginOutInvoker _iosloginoutInvoker;

    @Autowired
    protected IOSNewsInvoker _iosnewsInvoker;

    @BeforeClass
    public void setTestContext(ITestContext context) {
        if (null == context.getAttribute(IOSCommonInvoker.class.getTypeName())) {
            context.setAttribute(IOSCommonInvoker.class.getTypeName(), _ioscommonInvoker);
        }

        if (null == context.getAttribute(IOSLoginOutInvoker.class.getTypeName())) {
            context.setAttribute(IOSLoginOutInvoker.class.getTypeName(), _iosloginoutInvoker);
        }

        if (null == context.getAttribute(IOSNewsInvoker.class.getTypeName())) {
            context.setAttribute(IOSNewsInvoker.class.getTypeName(), _iosnewsInvoker);
        }
    }
}

