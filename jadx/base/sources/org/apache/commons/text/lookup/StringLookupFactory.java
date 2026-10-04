package org.apache.commons.text.lookup;

import androidx.appcompat.widget.AbstractC0541b;
import io.netty.handler.codec.http.HttpHeaders;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class StringLookupFactory {
    public static final String DEFAULT_STRING_LOOKUPS_PROPERTY = "org.apache.commons.text.lookup.StringLookupFactory.defaultStringLookups";
    public static final StringLookupFactory INSTANCE = new StringLookupFactory();
    static final FunctionStringLookup<String> INSTANCE_BASE64_DECODER = FunctionStringLookup.m14953on(new C13960e(3));
    static final FunctionStringLookup<String> INSTANCE_BASE64_ENCODER = FunctionStringLookup.m14953on(new C13960e(4));
    static final FunctionStringLookup<String> INSTANCE_ENVIRONMENT_VARIABLES = FunctionStringLookup.m14953on(new C13960e(5));
    static final FunctionStringLookup<String> INSTANCE_NULL = FunctionStringLookup.m14953on(new C13960e(6));
    static final FunctionStringLookup<String> INSTANCE_SYSTEM_PROPERTIES = FunctionStringLookup.m14953on(new C13960e(7));
    public static final String KEY_BASE64_DECODER = "base64Decoder";
    public static final String KEY_BASE64_ENCODER = "base64Encoder";
    public static final String KEY_CONST = "const";
    public static final String KEY_DATE = "date";
    public static final String KEY_DNS = "dns";
    public static final String KEY_ENV = "env";
    public static final String KEY_FILE = "file";
    public static final String KEY_JAVA = "java";
    public static final String KEY_LOCALHOST = "localhost";
    public static final String KEY_LOOPBACK_ADDRESS = "loobackAddress";
    public static final String KEY_PROPERTIES = "properties";
    public static final String KEY_RESOURCE_BUNDLE = "resourceBundle";
    public static final String KEY_SCRIPT = "script";
    public static final String KEY_SYS = "sys";
    public static final String KEY_URL = "url";
    public static final String KEY_URL_DECODER = "urlDecoder";
    public static final String KEY_URL_ENCODER = "urlEncoder";
    public static final String KEY_XML = "xml";
    public static final String KEY_XML_DECODER = "xmlDecoder";
    public static final String KEY_XML_ENCODER = "xmlEncoder";
    private final Path[] fences;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder implements Supplier<StringLookupFactory> {
        private Path[] fences;

        public Builder setFences(Path... pathArr) {
            this.fences = pathArr;
            return this;
        }

        @Override // java.util.function.Supplier
        public StringLookupFactory get() {
            return new StringLookupFactory(this.fences);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class DefaultStringLookupsHolder {
        static final DefaultStringLookupsHolder INSTANCE = new DefaultStringLookupsHolder(System.getProperties());
        private final Map<String, StringLookup> defaultStringLookups;

        public DefaultStringLookupsHolder(Properties properties) {
            this.defaultStringLookups = Collections.unmodifiableMap(properties.containsKey(StringLookupFactory.DEFAULT_STRING_LOOKUPS_PROPERTY) ? parseStringLookups(properties.getProperty(StringLookupFactory.DEFAULT_STRING_LOOKUPS_PROPERTY)) : createDefaultStringLookups());
        }

        private static void addLookup(DefaultStringLookup defaultStringLookup, Map<String, StringLookup> map) {
            map.put(StringLookupFactory.toKey(defaultStringLookup.getKey()), defaultStringLookup.getStringLookup());
            if (DefaultStringLookup.BASE64_DECODER.equals(defaultStringLookup)) {
                map.put(StringLookupFactory.toKey(HttpHeaders.Values.BASE64), defaultStringLookup.getStringLookup());
            }
        }

        private static Map<String, StringLookup> createDefaultStringLookups() {
            HashMap map = new HashMap();
            addLookup(DefaultStringLookup.BASE64_DECODER, map);
            addLookup(DefaultStringLookup.BASE64_ENCODER, map);
            addLookup(DefaultStringLookup.CONST, map);
            addLookup(DefaultStringLookup.DATE, map);
            addLookup(DefaultStringLookup.ENVIRONMENT, map);
            addLookup(DefaultStringLookup.FILE, map);
            addLookup(DefaultStringLookup.JAVA, map);
            addLookup(DefaultStringLookup.LOCAL_HOST, map);
            addLookup(DefaultStringLookup.LOOPBACK_ADDRESS, map);
            addLookup(DefaultStringLookup.PROPERTIES, map);
            addLookup(DefaultStringLookup.RESOURCE_BUNDLE, map);
            addLookup(DefaultStringLookup.SYSTEM_PROPERTIES, map);
            addLookup(DefaultStringLookup.URL_DECODER, map);
            addLookup(DefaultStringLookup.URL_ENCODER, map);
            addLookup(DefaultStringLookup.XML, map);
            addLookup(DefaultStringLookup.XML_DECODER, map);
            addLookup(DefaultStringLookup.XML_ENCODER, map);
            return map;
        }

        private static Map<String, StringLookup> parseStringLookups(String str) {
            HashMap map = new HashMap();
            try {
                for (String str2 : str.split("[\\s,]+")) {
                    if (!str2.isEmpty()) {
                        addLookup(DefaultStringLookup.valueOf(str2.toUpperCase()), map);
                    }
                }
                return map;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(AbstractC0541b.m772n("Invalid default string lookups definition: ", str), e);
            }
        }

        public Map<String, StringLookup> getDefaultStringLookups() {
            return this.defaultStringLookups;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static void clear() {
        ConstantStringLookup.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$static$0(String str) {
        return new String(Base64.getDecoder().decode(str), StandardCharsets.ISO_8859_1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$static$1(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes(StandardCharsets.ISO_8859_1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$static$2(String str) {
        return null;
    }

    public static String toKey(String str) {
        return str.toLowerCase(Locale.ROOT);
    }

    public static <K, V> Map<K, V> toMap(Map<K, V> map) {
        return map == null ? Collections.EMPTY_MAP : map;
    }

    public void addDefaultStringLookups(Map<String, StringLookup> map) {
        if (map != null) {
            map.putAll(DefaultStringLookupsHolder.INSTANCE.getDefaultStringLookups());
        }
    }

    public StringLookup base64DecoderStringLookup() {
        return INSTANCE_BASE64_DECODER;
    }

    public StringLookup base64EncoderStringLookup() {
        return INSTANCE_BASE64_ENCODER;
    }

    @Deprecated
    public StringLookup base64StringLookup() {
        return INSTANCE_BASE64_DECODER;
    }

    public <R, U> BiStringLookup<U> biFunctionStringLookup(BiFunction<String, U, R> biFunction) {
        return BiFunctionStringLookup.m14951on(biFunction);
    }

    public StringLookup constantStringLookup() {
        return ConstantStringLookup.INSTANCE;
    }

    public StringLookup dateStringLookup() {
        return DateStringLookup.INSTANCE;
    }

    public StringLookup dnsStringLookup() {
        return DnsStringLookup.INSTANCE;
    }

    public StringLookup environmentVariableStringLookup() {
        return INSTANCE_ENVIRONMENT_VARIABLES;
    }

    public StringLookup fileStringLookup() {
        Path[] pathArr = this.fences;
        return pathArr != null ? fileStringLookup(pathArr) : FileStringLookup.INSTANCE;
    }

    public <R> StringLookup functionStringLookup(Function<String, R> function) {
        return FunctionStringLookup.m14953on(function);
    }

    public StringLookup interpolatorStringLookup() {
        return InterpolatorStringLookup.INSTANCE;
    }

    public StringLookup javaPlatformStringLookup() {
        return JavaPlatformStringLookup.INSTANCE;
    }

    public StringLookup localHostStringLookup() {
        return InetAddressStringLookup.LOCAL_HOST;
    }

    public StringLookup loopbackAddressStringLookup() {
        return InetAddressStringLookup.LOOPACK_ADDRESS;
    }

    public <V> StringLookup mapStringLookup(Map<String, V> map) {
        return FunctionStringLookup.m14952on(map);
    }

    public StringLookup nullStringLookup() {
        return INSTANCE_NULL;
    }

    public StringLookup propertiesStringLookup() {
        Path[] pathArr = this.fences;
        return pathArr != null ? propertiesStringLookup(pathArr) : PropertiesStringLookup.INSTANCE;
    }

    public StringLookup resourceBundleStringLookup() {
        return ResourceBundleStringLookup.INSTANCE;
    }

    public StringLookup scriptStringLookup() {
        return ScriptStringLookup.INSTANCE;
    }

    public StringLookup systemPropertyStringLookup() {
        return INSTANCE_SYSTEM_PROPERTIES;
    }

    public StringLookup urlDecoderStringLookup() {
        return UrlDecoderStringLookup.INSTANCE;
    }

    public StringLookup urlEncoderStringLookup() {
        return UrlEncoderStringLookup.INSTANCE;
    }

    public StringLookup urlStringLookup() {
        return UrlStringLookup.INSTANCE;
    }

    public StringLookup xmlDecoderStringLookup() {
        return XmlDecoderStringLookup.INSTANCE;
    }

    public StringLookup xmlEncoderStringLookup() {
        return XmlEncoderStringLookup.INSTANCE;
    }

    public StringLookup xmlStringLookup() {
        Path[] pathArr = this.fences;
        return pathArr != null ? xmlStringLookup(XmlStringLookup.DEFAULT_FEATURES, pathArr) : XmlStringLookup.INSTANCE;
    }

    private StringLookupFactory() {
        this(null);
    }

    public StringLookup fileStringLookup(Path... pathArr) {
        return new FileStringLookup(pathArr);
    }

    public StringLookup interpolatorStringLookup(Map<String, StringLookup> map, StringLookup stringLookup, boolean z) {
        return new InterpolatorStringLookup(map, stringLookup, z);
    }

    public StringLookup propertiesStringLookup(Path... pathArr) {
        return new PropertiesStringLookup(pathArr);
    }

    public StringLookup resourceBundleStringLookup(String str) {
        return new ResourceBundleStringLookup(str);
    }

    public StringLookup xmlStringLookup(Map<String, Boolean> map) {
        return xmlStringLookup(map, this.fences);
    }

    private StringLookupFactory(Path[] pathArr) {
        this.fences = pathArr;
    }

    public <V> StringLookup interpolatorStringLookup(Map<String, V> map) {
        return new InterpolatorStringLookup(map);
    }

    public StringLookup xmlStringLookup(Map<String, Boolean> map, Path... pathArr) {
        return new XmlStringLookup(map, pathArr);
    }

    public StringLookup interpolatorStringLookup(StringLookup stringLookup) {
        return new InterpolatorStringLookup(stringLookup);
    }
}
