package cd.go.plugin.config.yaml.transforms;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Map;

public class ConfigurationTransform {

    public static final String YAML_PLUGIN_STD_CONFIG_FIELD = "options";
    public static final String YAML_PLUGIN_SEC_CONFIG_FIELD = "secure_options";
    private static final String JSON_PLUGIN_CONFIG_KEY_FIELD = "key";
    private static final String JSON_PLUGIN_CONFIG_VALUE_FIELD = "value";
    private static final String JSON_PLUGIN_CONFIG_ENCRYPTED_VALUE_FIELD = "encrypted_value";

    public JsonArray transform(Map<String, Object> map) {
        JsonArray configuration = new JsonArray();
        Object options = map.get(YAML_PLUGIN_STD_CONFIG_FIELD);
        Object optionsSecure = map.get(YAML_PLUGIN_SEC_CONFIG_FIELD);
        if (options != null && options != "") {
            for (Map.Entry<String, String> env : ((Map<String, String>) options).entrySet()) {
                JsonObject kv = new JsonObject();
                kv.addProperty(JSON_PLUGIN_CONFIG_KEY_FIELD, env.getKey());
                kv.addProperty(JSON_PLUGIN_CONFIG_VALUE_FIELD, env.getValue());
                configuration.add(kv);
            }
        }
        if (optionsSecure != null && optionsSecure != "") {
            for (Map.Entry<String, String> env : ((Map<String, String>) optionsSecure).entrySet()) {
                JsonObject kv = new JsonObject();
                kv.addProperty(JSON_PLUGIN_CONFIG_KEY_FIELD, env.getKey());
                kv.addProperty(JSON_PLUGIN_CONFIG_ENCRYPTED_VALUE_FIELD, env.getValue());
                configuration.add(kv);
            }
        }
        return configuration;
    }

}
