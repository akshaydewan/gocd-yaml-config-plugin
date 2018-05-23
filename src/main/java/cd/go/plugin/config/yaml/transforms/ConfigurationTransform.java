package cd.go.plugin.config.yaml.transforms;

import com.google.gson.JsonArray;

import java.util.Map;

public class ConfigurationTransform {

    static final String YAML_PLUGIN_STD_CONFIG_FIELD = "options";
    static final String YAML_PLUGIN_SEC_CONFIG_FIELD = "secure_options";
    private static final String JSON_PLUGIN_CONFIG_KEY_FIELD = "key";
    private static final String JSON_PLUGIN_CONFIG_VALUE_FIELD = "value";
    private static final String JSON_PLUGIN_CONFIG_ENCRYPTED_VALUE_FIELD = "encrypted_value";

    public JsonArray transform(Map<String, Object> map) {
        Object options = map.get(YAML_PLUGIN_STD_CONFIG_FIELD);
        Object optionsSecure = map.get(YAML_PLUGIN_SEC_CONFIG_FIELD);
        JsonArray configuration = KeyValueTransformHelper.transform(options, JSON_PLUGIN_CONFIG_KEY_FIELD, JSON_PLUGIN_CONFIG_VALUE_FIELD);
        configuration.addAll(KeyValueTransformHelper.transform(optionsSecure, JSON_PLUGIN_CONFIG_KEY_FIELD, JSON_PLUGIN_CONFIG_ENCRYPTED_VALUE_FIELD));
        return configuration;
    }
}
