package com.aiways.config;

import com.aiways.utilities.DataGenera;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TestConfiguration {

    private static final String FILE = "/test-config.properties";

    private static final String PROPERTY_PLATFORM = "platform";

    private static final String PROPERTY_APPIUMREMOTEHOST = "appium_remoteHost";

    private static final String PROPERTY_APPIUMREMOTEPATH = "appium_remotePath";

    private static final String PROPERTY_APPIUMREMOTEPORT = "appium_remotePort";


    private static final String PROPERTY_APPIUMCAP_PLATFORMNAME = "capabilities_platformName";

    private static final String PROPERTY_APPIUMCAP_PLATFORMVERSION = "capabilities_platformVersion";

    private static final String PROPERTY_APPIUMCAP_DEVICENAME = "capabilities_deviceName";

    private static final String PROPERTY_APPIUMCAP_APPPACKAGE = "capabilities_appPackage";

    private static final String PROPERTY_APPIUMCAP_APPACTIVITY = "capabilities_appActivity";

    private static final String PROPERTY_APPIUMCAP_UDID = "capabilities_udid";

    private static final String PROPERTY_APPIUMCAP_BUNDLEID = "capabilities_bundleId";

    private static final String PROPERTY_APPIUMCAP_AUTONAME = "capabilities_automationName";

    public String get_platform() {
        return _platform;
    }

    private String _platform;

    private String _appium_remoteHost;

    private String _appium_remotePath;

    private String _appium_remotePort;

    public String get_appium_remoteServer() {
        return _appium_remoteHost + ":" + _appium_remotePort + "" + _appium_remotePath;
    }

    private String _cap__platformName;

    private String _cap_platformVersion;

    private String _cap_deviceName;

    private String _cap_appPackage;

    private String _cap_appActivity;

    private String _cap_udid;

    private String _cap_bundleId;

    private String _cap__automationName;

    private Map<String, String> _capabilitiesMap = new HashMap<String, String>();

    public Map<String, String> get_capabilitiesMap() {
        return _capabilitiesMap;
    }

    private static final TestConfiguration _configuration = new TestConfiguration();

    private TestConfiguration() {
        super();

        try {
            load();
            capabilitiesMap();
        } catch (FileNotFoundException e) {
            Assert.fail(e.getMessage());
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }

    public static TestConfiguration instance() {
        return _configuration;
    }

    public void capabilitiesMap() throws IOException {
        InputStream stream = getClass().getResourceAsStream(FILE);
        Properties properties = new Properties();
        properties.load(stream);

        String indexStr = "_";
        _capabilitiesMap.put(DataGenera.subStrToEnd(PROPERTY_APPIUMCAP_PLATFORMNAME, indexStr), _cap__platformName);
        _capabilitiesMap.put(DataGenera.subStrToEnd(PROPERTY_APPIUMCAP_PLATFORMVERSION, indexStr), _cap_platformVersion);
        _capabilitiesMap.put(DataGenera.subStrToEnd(PROPERTY_APPIUMCAP_DEVICENAME, indexStr), _cap_deviceName);

        if (_platform.contains("ios")) {
            _capabilitiesMap.put(DataGenera.subStrToEnd(PROPERTY_APPIUMCAP_UDID, indexStr), _cap_udid);
            _capabilitiesMap.put(DataGenera.subStrToEnd(PROPERTY_APPIUMCAP_BUNDLEID, indexStr), _cap_bundleId);
            _capabilitiesMap.put(DataGenera.subStrToEnd(PROPERTY_APPIUMCAP_AUTONAME, indexStr), _cap__automationName);
        } else {
            _capabilitiesMap.put(DataGenera.subStrToEnd(PROPERTY_APPIUMCAP_APPPACKAGE, indexStr), _cap_appPackage);
            _capabilitiesMap.put(DataGenera.subStrToEnd(PROPERTY_APPIUMCAP_APPACTIVITY, indexStr), _cap_appActivity);
        }
    }

    public void load() throws FileNotFoundException, IOException {
        InputStream stream = getClass().getResourceAsStream(FILE);

        Properties properties = new Properties();
        properties.load(stream);

        _platform = properties.getProperty(PROPERTY_PLATFORM);
        _appium_remoteHost = properties.getProperty(PROPERTY_APPIUMREMOTEHOST);
        _appium_remotePath = properties.getProperty(PROPERTY_APPIUMREMOTEPATH);
        _appium_remotePort = properties.getProperty(PROPERTY_APPIUMREMOTEPORT);
        _cap__platformName = properties.getProperty(PROPERTY_APPIUMCAP_PLATFORMNAME);
        _cap_platformVersion = properties.getProperty(PROPERTY_APPIUMCAP_PLATFORMVERSION);
        _cap_deviceName = properties.getProperty(PROPERTY_APPIUMCAP_DEVICENAME);
        _cap_appPackage = properties.getProperty(PROPERTY_APPIUMCAP_APPPACKAGE);
        _cap_appActivity = properties.getProperty(PROPERTY_APPIUMCAP_APPACTIVITY);
        _cap_udid = properties.getProperty(PROPERTY_APPIUMCAP_UDID);
        _cap_bundleId = properties.getProperty(PROPERTY_APPIUMCAP_BUNDLEID);
        _cap__automationName = properties.getProperty(PROPERTY_APPIUMCAP_AUTONAME);

        stream.close();
    }

}
