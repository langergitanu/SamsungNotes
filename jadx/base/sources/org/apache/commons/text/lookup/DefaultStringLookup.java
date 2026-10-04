package org.apache.commons.text.lookup;

import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'BASE64_DECODER' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class DefaultStringLookup {
    private static final /* synthetic */ DefaultStringLookup[] $VALUES;
    public static final DefaultStringLookup BASE64_DECODER;
    public static final DefaultStringLookup BASE64_ENCODER;
    public static final DefaultStringLookup CONST;
    public static final DefaultStringLookup DATE;
    public static final DefaultStringLookup DNS;
    public static final DefaultStringLookup ENVIRONMENT;
    public static final DefaultStringLookup FILE;
    public static final DefaultStringLookup JAVA;
    public static final DefaultStringLookup LOCAL_HOST;
    public static final DefaultStringLookup LOOPBACK_ADDRESS;
    public static final DefaultStringLookup PROPERTIES;
    public static final DefaultStringLookup RESOURCE_BUNDLE;
    public static final DefaultStringLookup SCRIPT;
    public static final DefaultStringLookup SYSTEM_PROPERTIES;
    public static final DefaultStringLookup URL;
    public static final DefaultStringLookup URL_DECODER;
    public static final DefaultStringLookup URL_ENCODER;
    public static final DefaultStringLookup XML;
    public static final DefaultStringLookup XML_DECODER;
    public static final DefaultStringLookup XML_ENCODER;
    private final String key;
    private final StringLookup lookup;

    private static /* synthetic */ DefaultStringLookup[] $values() {
        return new DefaultStringLookup[]{BASE64_DECODER, BASE64_ENCODER, CONST, DATE, DNS, ENVIRONMENT, FILE, JAVA, LOCAL_HOST, LOOPBACK_ADDRESS, PROPERTIES, RESOURCE_BUNDLE, SCRIPT, SYSTEM_PROPERTIES, URL, URL_DECODER, URL_ENCODER, XML, XML_DECODER, XML_ENCODER};
    }

    static {
        StringLookupFactory stringLookupFactory = StringLookupFactory.INSTANCE;
        BASE64_DECODER = new DefaultStringLookup("BASE64_DECODER", 0, StringLookupFactory.KEY_BASE64_DECODER, stringLookupFactory.base64DecoderStringLookup());
        BASE64_ENCODER = new DefaultStringLookup("BASE64_ENCODER", 1, StringLookupFactory.KEY_BASE64_ENCODER, stringLookupFactory.base64EncoderStringLookup());
        CONST = new DefaultStringLookup("CONST", 2, StringLookupFactory.KEY_CONST, stringLookupFactory.constantStringLookup());
        DATE = new DefaultStringLookup(TextConst.DATE_TIME_UNIT_DATE, 3, "date", stringLookupFactory.dateStringLookup());
        DNS = new DefaultStringLookup("DNS", 4, StringLookupFactory.KEY_DNS, stringLookupFactory.dnsStringLookup());
        ENVIRONMENT = new DefaultStringLookup("ENVIRONMENT", 5, StringLookupFactory.KEY_ENV, stringLookupFactory.environmentVariableStringLookup());
        FILE = new DefaultStringLookup("FILE", 6, "file", stringLookupFactory.fileStringLookup());
        JAVA = new DefaultStringLookup("JAVA", 7, StringLookupFactory.KEY_JAVA, stringLookupFactory.javaPlatformStringLookup());
        LOCAL_HOST = new DefaultStringLookup("LOCAL_HOST", 8, StringLookupFactory.KEY_LOCALHOST, stringLookupFactory.localHostStringLookup());
        LOOPBACK_ADDRESS = new DefaultStringLookup("LOOPBACK_ADDRESS", 9, StringLookupFactory.KEY_LOOPBACK_ADDRESS, stringLookupFactory.loopbackAddressStringLookup());
        PROPERTIES = new DefaultStringLookup("PROPERTIES", 10, StringLookupFactory.KEY_PROPERTIES, stringLookupFactory.propertiesStringLookup());
        RESOURCE_BUNDLE = new DefaultStringLookup("RESOURCE_BUNDLE", 11, StringLookupFactory.KEY_RESOURCE_BUNDLE, stringLookupFactory.resourceBundleStringLookup());
        SCRIPT = new DefaultStringLookup("SCRIPT", 12, StringLookupFactory.KEY_SCRIPT, stringLookupFactory.scriptStringLookup());
        SYSTEM_PROPERTIES = new DefaultStringLookup("SYSTEM_PROPERTIES", 13, "sys", stringLookupFactory.systemPropertyStringLookup());
        URL = new DefaultStringLookup(TextConst.ENTITY_TYPE_URL, 14, "url", stringLookupFactory.urlStringLookup());
        URL_DECODER = new DefaultStringLookup("URL_DECODER", 15, StringLookupFactory.KEY_URL_DECODER, stringLookupFactory.urlDecoderStringLookup());
        URL_ENCODER = new DefaultStringLookup("URL_ENCODER", 16, StringLookupFactory.KEY_URL_ENCODER, stringLookupFactory.urlEncoderStringLookup());
        XML = new DefaultStringLookup("XML", 17, "xml", stringLookupFactory.xmlStringLookup());
        XML_DECODER = new DefaultStringLookup("XML_DECODER", 18, StringLookupFactory.KEY_XML_DECODER, stringLookupFactory.xmlDecoderStringLookup());
        XML_ENCODER = new DefaultStringLookup("XML_ENCODER", 19, StringLookupFactory.KEY_XML_ENCODER, stringLookupFactory.xmlEncoderStringLookup());
        $VALUES = $values();
    }

    private DefaultStringLookup(String str, int i, String str2, StringLookup stringLookup) {
        this.key = str2;
        this.lookup = stringLookup;
    }

    public static DefaultStringLookup valueOf(String str) {
        return (DefaultStringLookup) Enum.valueOf(DefaultStringLookup.class, str);
    }

    public static DefaultStringLookup[] values() {
        return (DefaultStringLookup[]) $VALUES.clone();
    }

    public String getKey() {
        return this.key;
    }

    public StringLookup getStringLookup() {
        return this.lookup;
    }
}
