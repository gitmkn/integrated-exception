package cn.makn.util;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: properties配置文件工具类
 * @author: makn
 * @version: V1.0
 * @date: 2020/12/10 11:16
 */
public class PropertiesUtils {
    // 放入内存
    private static final Map<String, String> map = new ConcurrentHashMap<String, String>();
    // 默认路径
    private static final String PATH_DEFAULT = "classpath*:/**/*.properties";

    /**
     * @param path
     * @param key
     * @return
     * @Description:
     * @author makn
     * @date 2020/12/10 11:21
     */
    public static String getXmlPath(String path, String key) {
        if(path == null || path == ""){
            path = PATH_DEFAULT;
        }
        if(key == null || key == ""){
            return null;
        }
        String mapValue = map.get(key);
        if(mapValue != null){
            return mapValue;
        }
        try {
            PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = patternResolver.getResources(path);
            for (Resource resource : resources) {
                Properties properties = PropertiesLoaderUtils.loadProperties(resource);
                String value = properties.getProperty(key);
                if (value != null) {
                    map.put(key, value);
                    return value;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
