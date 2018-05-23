package cd.go.plugin.config.yaml.transforms;

import com.google.gson.JsonArray;

import java.util.Map;

public class EnvironmentVariablesTransform {
    public static final String JSON_ENV_VAR_FIELD = "environment_variables";

    public static final String JSON_ENV_NAME_FIELD = "name";
    public static final String JSON_ENV_VALUE_FIELD = "value";
    public static final String JSON_ENV_ENCRYPTED_FIELD = "encrypted_value";

    public static final String YAML_ENV_VAR_FIELD = "environment_variables";
    public static final String YAML_SEC_VAR_FIELD = "secure_variables";

    public JsonArray transform(Object all) {
        Map<String, Object> map = (Map<String, Object>) all;
        Object variables = map.get(YAML_ENV_VAR_FIELD);
        JsonArray array = KeyValueTransformHelper.transform(variables, JSON_ENV_NAME_FIELD, JSON_ENV_VALUE_FIELD);
        Object secureVariables = map.get(YAML_SEC_VAR_FIELD);
        array.addAll(KeyValueTransformHelper.transform(secureVariables, JSON_ENV_NAME_FIELD, JSON_ENV_ENCRYPTED_FIELD));
        return array;
    }
}
