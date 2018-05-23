package cd.go.plugin.config.yaml.transforms;

import com.google.gson.JsonArray;

import java.util.Map;

public class ParameterTransform {

    public static final String YAML_PIPELINE_PARAMETERS_FIELD = "parameters";
    public static final String JSON_PARAM_NAME_FIELD = "name";
    public static final String JSON_PARAM_VALUE_FIELD = "value";

    public JsonArray transform(Object all) {
        Map<String, Object> map = (Map<String, Object>) all;
        Object parameters = map.get(YAML_PIPELINE_PARAMETERS_FIELD);
        return KeyValueTransformHelper.transform(parameters, JSON_PARAM_NAME_FIELD, JSON_PARAM_VALUE_FIELD);
    }
}
