package configuration;

import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author : VaibhavS
 * @desc : Read the Property file
 */
public class ReadConfiguration {
    protected Properties configVo =null;

    /**
     * Constructor to load the properties from the file
     * @throws Exception
     */
    public ReadConfiguration() throws Exception{
        configVo = new Properties();
        configVo = loadConfiguration("config.properties");
    }

    /**
     * Read the Configuration file and values to the object
     * @param resourcepath
     * @return
     * @throws Exception
     */
    public Properties loadConfiguration(String resourcepath) throws Exception{

        Properties propVo = new Properties();

        try {
            if(StringUtils.isNotEmpty(resourcepath)) {
                propVo.load(ReadConfiguration.class.getClassLoader().getResourceAsStream(resourcepath));
            } else {
                throw new Exception("Resource path is empty!!");
            }
        }catch (FileNotFoundException e ){
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }catch (IOException ioe){
            ioe.printStackTrace();
            throw new Exception(ioe.getMessage());
        }

        return propVo;
    }

    /**
     * Return the Property value for any key
     * @param key
     * @return
     */
    public String getKey(String key){
        if(StringUtils.isNotEmpty(key)&&!(configVo.isEmpty())&&configVo.containsKey(key))
            return configVo.getProperty(key);
        else
            return null;
    }

}
