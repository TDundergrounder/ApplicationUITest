package com.aiways.config;

import org.testng.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestConfiguration {

    private static final  String FILE = "/test-config.properties";

    private static final  String PROPERTY_PLATFORM= "platform";

    private static final String PROPERTY_APPIUMREMOTEHOST = "appium_remoteHost";

    private static final String PROPERTY_APPIUMREMOTEPATH = "appium_remotePath";

    private static final String PROPERTY_APPIUMREMOTEPORT = "appium_remotePort";

    public String get_platform() {
        return _platform;
    }

    public String get_appium_remoteHost() {
        return _appium_remoteHost;
    }

    public String get_appium_remotePath() {
        return _appium_remotePath;
    }

    public String get_appium_remotePort() {
        return _appium_remotePort;
    }

    private String _platform;

    private String _appium_remoteHost;

    private String _appium_remotePath;

    private String _appium_remotePort;



    private static final  TestConfiguration _configuration = new TestConfiguration();

    private TestConfiguration()
    {
        super();

        try {
            load();
        }
        catch (FileNotFoundException e)
        {
            Assert.fail(e.getMessage());
        }
        catch (IOException e)
        {
            Assert.fail(e.getMessage());
        }
    }

    public static TestConfiguration  instance()
    {
        return _configuration;
    }

    public  void load() throws FileNotFoundException, IOException {
        InputStream stream=getClass().getResourceAsStream(FILE);

        Properties properties = new Properties();
        properties.load(stream);

        _platform = properties.getProperty(PROPERTY_PLATFORM);
        _appium_remoteHost = properties.getProperty(PROPERTY_APPIUMREMOTEHOST);
        _appium_remotePath = properties.getProperty(PROPERTY_APPIUMREMOTEPATH);
        _appium_remotePort = properties.getProperty(PROPERTY_APPIUMREMOTEPORT);


        stream.close();
    }
}
