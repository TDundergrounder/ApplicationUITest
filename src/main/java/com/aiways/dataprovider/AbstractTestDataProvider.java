package com.aiways.dataprovider;

import com.aiways.config.TestConfiguration;

import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.testng.Assert;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public abstract class AbstractTestDataProvider {

    private static final String FILE = "/test-data.xml";

    private static final String FILE_LOCATE = "/test-locatePage-data.xml";

    private static final String ELEMENT_PLATFORM = "Platform";

    private static final String ELEMENT_ATTRIBUTE_NAME = "name";

    private static final String ELEMENT_ATTRIBUTE_KEY = "Key";

    private static final String ELEMENT_ATTRIBUTE_VALUE = "Value";

    protected static final HashMap<String, HashMap<String, String>> _data = new HashMap<String, HashMap<String, String>>();

    protected static final HashMap<String,HashMap<String,String>> _locateData = new HashMap<String,HashMap<String, String>>();

    private static boolean _isLoaded = false;

    private static boolean is_isLoaded = false;

    static {
        loadData();
        load_locatePageData();
    }

    private static void loadData() {
        try {
            if (_isLoaded) {
                return;
            }
            InputStream stream = Class.class.getResourceAsStream(FILE);

            List<Element> environments = new SAXReader().read(stream).getRootElement().elements(ELEMENT_PLATFORM);
            Element environment = environments.stream()
                    .filter(x -> x.attribute(ELEMENT_ATTRIBUTE_NAME).getValue().equalsIgnoreCase(TestConfiguration.instance().get_platform()))
                    .findFirst()
                    .orElse(null);
            if (null == environment) {
                throw new Exception("Data loading failed!");
            }
            ((List<Element>) environment.elements()).forEach(module ->
                    {
                        String moduleName = module.attributeValue(ELEMENT_ATTRIBUTE_NAME);
                        if (!_data.containsKey(moduleName)) {
                            _data.put(moduleName, new HashMap<String, String>());
                        }
                        HashMap<String, String> moudleMap = _data.get(moduleName);
                        ((List<Element>) module.elements()).forEach(data ->
                        {
                            String key = data.attributeValue(ELEMENT_ATTRIBUTE_KEY);
                            String value = data.attributeValue(ELEMENT_ATTRIBUTE_VALUE);
                            if (null != key && !moudleMap.containsKey(key)) {
                                moudleMap.put(key, value);
                            }
                        });
                    }
            );

            stream.close();

            _isLoaded = true;
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    private static void load_locatePageData() {
        try {
            if (is_isLoaded) {
                return;
            }
            InputStream stream = Class.class.getResourceAsStream(FILE_LOCATE);

            List<Element> platforms = new SAXReader().read(stream).getRootElement().elements(ELEMENT_PLATFORM);
            Element platform = platforms.stream()
                    .filter(x -> x.attribute(ELEMENT_ATTRIBUTE_NAME).getValue().equalsIgnoreCase(TestConfiguration.instance().get_platform()))
                    .findFirst()
                    .orElse(null);
            if (null == platform) {
                throw new Exception("Data loading failed!");
            }
            ((List<Element>) platform.elements()).forEach(module ->
                    {
                        String moduleName = module.attributeValue(ELEMENT_ATTRIBUTE_NAME);
                        if (!_locateData.containsKey(moduleName)) {
                            _locateData.put(moduleName, new HashMap<String, String>());
                        }
                        HashMap<String, String> moudleMap = _locateData.get(moduleName);
                        ((List<Element>) module.elements()).forEach(data ->
                        {
                            String key = data.attributeValue(ELEMENT_ATTRIBUTE_KEY);
                            String value = data.attributeValue(ELEMENT_ATTRIBUTE_VALUE);
                            if (null != key && !moudleMap.containsKey(key)) {
                                moudleMap.put(key, value);
                            }
                        });
                    }
            );

            stream.close();

            is_isLoaded = true;
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }



}
