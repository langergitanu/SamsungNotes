package org.apache.commons.text.lookup;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.PrintStream;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class JavaPlatformStringLookup extends AbstractStringLookup {
    static final JavaPlatformStringLookup INSTANCE = new JavaPlatformStringLookup();
    private static final String KEY_HARDWARE = "hardware";
    private static final String KEY_LOCALE = "locale";
    private static final String KEY_OS = "os";
    private static final String KEY_RUNTIME = "runtime";
    private static final String KEY_VERSION = "version";
    private static final String KEY_VM = "vm";

    private JavaPlatformStringLookup() {
    }

    private String getSystemProperty(String str) {
        return StringLookupFactory.INSTANCE_SYSTEM_PROPERTIES.lookup(str);
    }

    public static void main(String[] strArr) {
        System.out.println(JavaPlatformStringLookup.class);
        PrintStream printStream = System.out;
        JavaPlatformStringLookup javaPlatformStringLookup = INSTANCE;
        printStream.printf("%s = %s%n", "version", javaPlatformStringLookup.lookup("version"));
        System.out.printf("%s = %s%n", KEY_RUNTIME, javaPlatformStringLookup.lookup(KEY_RUNTIME));
        System.out.printf("%s = %s%n", KEY_VM, javaPlatformStringLookup.lookup(KEY_VM));
        System.out.printf("%s = %s%n", "os", javaPlatformStringLookup.lookup("os"));
        System.out.printf("%s = %s%n", KEY_HARDWARE, javaPlatformStringLookup.lookup(KEY_HARDWARE));
        System.out.printf("%s = %s%n", "locale", javaPlatformStringLookup.lookup("locale"));
    }

    public String getHardware() {
        return "processors: " + Runtime.getRuntime().availableProcessors() + ", architecture: " + getSystemProperty(SystemProperties.OS_ARCH) + getSystemProperty(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, "sun.arch.data.model") + getSystemProperty(", instruction sets: ", "sun.cpu.isalist");
    }

    public String getLocale() {
        return "default locale: " + Locale.getDefault() + ", platform encoding: " + getSystemProperty(SystemProperties.FILE_ENCODING);
    }

    public String getOperatingSystem() {
        return getSystemProperty(SystemProperties.OS_NAME) + " " + getSystemProperty(SystemProperties.OS_VERSION) + getSystemProperty(" ", "sun.os.patch.level") + ", architecture: " + getSystemProperty(SystemProperties.OS_ARCH) + getSystemProperty(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, "sun.arch.data.model");
    }

    public String getRuntime() {
        return getSystemProperty(SystemProperties.JAVA_RUNTIME_NAME) + " (build " + getSystemProperty(SystemProperties.JAVA_RUNTIME_VERSION) + ") from " + getSystemProperty(SystemProperties.JAVA_VENDOR);
    }

    public String getVirtualMachine() {
        StringBuilder sb = new StringBuilder();
        sb.append(getSystemProperty(SystemProperties.JAVA_VM_NAME));
        sb.append(" (build ");
        sb.append(getSystemProperty(SystemProperties.JAVA_VM_VERSION));
        sb.append(SQLKeyword.COMMA);
        return AbstractC0622a.m1170p(getSystemProperty(SystemProperties.JAVA_VM_INFO), ")", sb);
    }

    @Override // org.apache.commons.text.lookup.StringLookup
    public String lookup(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
            case "locale":
                return getLocale();
            case "os":
                return getOperatingSystem();
            case "vm":
                return getVirtualMachine();
            case "hardware":
                return getHardware();
            case "version":
                return "Java version " + getSystemProperty(SystemProperties.JAVA_VERSION);
            case "runtime":
                return getRuntime();
            default:
                throw new IllegalArgumentException(str);
        }
    }

    private String getSystemProperty(String str, String str2) {
        String systemProperty = getSystemProperty(str2);
        return StringUtils.isEmpty(systemProperty) ? "" : AbstractC0541b.m756B(str, systemProperty);
    }
}
