package com.nimbusds.jose.util;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.nimbusds.jose.shaded.gson.Gson;
import com.nimbusds.jose.shaded.gson.GsonBuilder;
import com.nimbusds.jose.shaded.gson.ToNumberPolicy;
import com.nimbusds.jose.shaded.gson.internal.LinkedTreeMap;
import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class JSONObjectUtils {
    private static final Gson GSON = new GsonBuilder().serializeNulls().setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE).disableHtmlEscaping().create();

    private JSONObjectUtils() {
    }

    public static Base64URL getBase64URL(Map<String, Object> map, String str) {
        String string = getString(map, str);
        if (string == null) {
            return null;
        }
        return new Base64URL(string);
    }

    public static boolean getBoolean(Map<String, Object> map, String str) throws ParseException {
        Boolean bool = (Boolean) getGeneric(map, str, Boolean.class);
        if (bool != null) {
            return bool.booleanValue();
        }
        throw new ParseException(AbstractC0541b.m773o("JSON object member with key ", str, " is missing or null"), 0);
    }

    public static double getDouble(Map<String, Object> map, String str) throws ParseException {
        Number number = (Number) getGeneric(map, str, Number.class);
        if (number != null) {
            return number.doubleValue();
        }
        throw new ParseException(AbstractC0541b.m773o("JSON object member with key ", str, " is missing or null"), 0);
    }

    public static float getFloat(Map<String, Object> map, String str) throws ParseException {
        Number number = (Number) getGeneric(map, str, Number.class);
        if (number != null) {
            return number.floatValue();
        }
        throw new ParseException(AbstractC0541b.m773o("JSON object member with key ", str, " is missing or null"), 0);
    }

    private static <T> T getGeneric(Map<String, Object> map, String str, Class<T> cls) throws ParseException {
        if (map.get(str) == null) {
            return null;
        }
        T t = (T) map.get(str);
        if (cls.isAssignableFrom(t.getClass())) {
            return t;
        }
        throw new ParseException(AbstractC0541b.m773o("Unexpected type of JSON object member with key ", str, ""), 0);
    }

    public static int getInt(Map<String, Object> map, String str) throws ParseException {
        Number number = (Number) getGeneric(map, str, Number.class);
        if (number != null) {
            return number.intValue();
        }
        throw new ParseException(AbstractC0541b.m773o("JSON object member with key ", str, " is missing or null"), 0);
    }

    public static List<Object> getJSONArray(Map<String, Object> map, String str) {
        return (List) getGeneric(map, str, List.class);
    }

    public static Map<String, Object> getJSONObject(Map<String, Object> map, String str) throws ParseException {
        Map<String, Object> map2 = (Map) getGeneric(map, str, Map.class);
        if (map2 == null) {
            return null;
        }
        Iterator<String> it = map2.keySet().iterator();
        while (it.hasNext()) {
            if (!(it.next() instanceof String)) {
                throw new ParseException(AbstractC0541b.m773o("JSON object member with key ", str, " not a JSON object"), 0);
            }
        }
        return map2;
    }

    public static Map<String, Object>[] getJSONObjectArray(Map<String, Object> map, String str) throws ParseException {
        List<Object> jSONArray = getJSONArray(map, str);
        if (jSONArray == null) {
            return null;
        }
        if (jSONArray.isEmpty()) {
            return new HashMap[0];
        }
        for (Object obj : jSONArray) {
            if (obj != null) {
                try {
                    if (obj instanceof HashMap) {
                        return (Map[]) jSONArray.toArray(new HashMap[0]);
                    }
                    if (obj instanceof LinkedTreeMap) {
                        return (Map[]) jSONArray.toArray(new LinkedTreeMap[0]);
                    }
                } catch (ArrayStoreException unused) {
                }
            }
        }
        throw new ParseException(AbstractC0541b.m773o("JSON object member with key \"", str, "\" is not an array of JSON objects"), 0);
    }

    public static long getLong(Map<String, Object> map, String str) throws ParseException {
        Number number = (Number) getGeneric(map, str, Number.class);
        if (number != null) {
            return number.longValue();
        }
        throw new ParseException(AbstractC0541b.m773o("JSON object member with key ", str, " is missing or null"), 0);
    }

    public static String getString(Map<String, Object> map, String str) {
        return (String) getGeneric(map, str, String.class);
    }

    public static String[] getStringArray(Map<String, Object> map, String str) throws ParseException {
        List<Object> jSONArray = getJSONArray(map, str);
        if (jSONArray == null) {
            return null;
        }
        try {
            return (String[]) jSONArray.toArray(new String[0]);
        } catch (ArrayStoreException unused) {
            throw new ParseException(AbstractC0541b.m773o("JSON object member with key \"", str, "\" is not an array of strings"), 0);
        }
    }

    public static List<String> getStringList(Map<String, Object> map, String str) throws ParseException {
        String[] stringArray = getStringArray(map, str);
        if (stringArray == null) {
            return null;
        }
        return Arrays.asList(stringArray);
    }

    public static URI getURI(Map<String, Object> map, String str) throws ParseException {
        String string = getString(map, str);
        if (string == null) {
            return null;
        }
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            throw new ParseException(e.getMessage(), 0);
        }
    }

    public static Map<String, Object> newJSONObject() {
        return new HashMap();
    }

    public static Map<String, Object> parse(String str) {
        return parse(str, -1);
    }

    @Deprecated
    public static Map<String, Object> parseJSONObject(String str) {
        return parse(str);
    }

    public static String toJSONString(Map<String, ?> map) {
        return GSON.toJson(map);
    }

    public static Map<String, Object> parse(String str, int i) throws ParseException {
        if (str.trim().isEmpty()) {
            throw new ParseException("Invalid JSON object", 0);
        }
        if (i >= 0 && str.length() > i) {
            throw new ParseException(AbstractC0541b.m767i(i, "The parsed string is longer than the max accepted size of ", " characters"), 0);
        }
        try {
            return (Map) GSON.fromJson(str, TypeToken.getParameterized(Map.class, String.class, Object.class).getType());
        } catch (Exception e) {
            throw new ParseException(AbstractC2322a.m1619i(e, new StringBuilder("Invalid JSON: ")), 0);
        } catch (StackOverflowError unused) {
            throw new ParseException("Excessive JSON object and / or array nesting", 0);
        }
    }
}
