package opennlp.tools.formats.brat;

import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import opennlp.tools.tokenize.WhitespaceTokenizer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class AnnotationConfiguration {
    public static final String ATTRIBUTE_TYPE = "Attribute";
    public static final String ENTITY_TYPE = "Entity";
    public static final String EVENT_TYPE = "Event";
    public static final String RELATION_TYPE = "Relation";
    public static final String SPAN_TYPE = "Span";
    private final Map<String, String> typeToClassMap;

    public AnnotationConfiguration(Map<String, String> map) {
        HashMap map2 = new HashMap(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            Objects.requireNonNull(key);
            String value = entry.getValue();
            Objects.requireNonNull(value);
            map2.put(key, value);
        }
        this.typeToClassMap = Collections.unmodifiableMap(map2);
    }

    public static AnnotationConfiguration parse(InputStream inputStream) throws IOException {
        String str;
        HashMap map = new HashMap();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        String strSubstring = null;
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return new AnnotationConfiguration(map);
            }
            String strTrim = line.trim();
            if (!strTrim.isEmpty() && !strTrim.startsWith(ContentUtils.HASH_SYMBOL)) {
                if (!strTrim.startsWith("[") || !strTrim.endsWith("]")) {
                    str = WhitespaceTokenizer.INSTANCE.tokenize(strTrim)[0];
                    strSubstring.getClass();
                    switch (strSubstring) {
                        case "entities":
                            map.put(str, ENTITY_TYPE);
                            break;
                        case "events":
                            map.put(str, "Event");
                            break;
                        case "relations":
                            map.put(str, RELATION_TYPE);
                            break;
                        case "attributes":
                            map.put(str, ATTRIBUTE_TYPE);
                            break;
                    }
                } else {
                    strSubstring = strTrim.substring(strTrim.indexOf(91) + 1, strTrim.indexOf(93));
                }
            }
        }
    }

    public String getTypeClass(String str) {
        return this.typeToClassMap.get(str);
    }

    public static AnnotationConfiguration parse(File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            AnnotationConfiguration annotationConfiguration = parse(bufferedInputStream);
            bufferedInputStream.close();
            return annotationConfiguration;
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
