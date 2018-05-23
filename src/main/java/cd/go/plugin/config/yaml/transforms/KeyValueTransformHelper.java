package cd.go.plugin.config.yaml.transforms;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Map;

public class KeyValueTransformHelper {

    public static JsonArray transform(Object map, String jsonKeyField, String jsonValueField) {
        JsonArray array = new JsonArray();
        if (map != null && map != "") {
            for (Map.Entry<String, String> env : ((Map<String, String>) map).entrySet()) {
                JsonObject evarJson = new JsonObject();
                evarJson.addProperty(jsonKeyField, env.getKey());
                evarJson.addProperty(jsonValueField, env.getValue());
                array.add(evarJson);
            }
        }
        return array;
    }

}
