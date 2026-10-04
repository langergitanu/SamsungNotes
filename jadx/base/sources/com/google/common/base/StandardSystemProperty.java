package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import javax.annotation.CheckForNull;
import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@J2ktIncompatible
@GwtIncompatible
@ElementTypesAreNonnullByDefault
public enum StandardSystemProperty {
    JAVA_VERSION(SystemProperties.JAVA_VERSION),
    JAVA_VENDOR(SystemProperties.JAVA_VENDOR),
    JAVA_VENDOR_URL(SystemProperties.JAVA_VENDOR_URL),
    JAVA_HOME("java.home"),
    JAVA_VM_SPECIFICATION_VERSION(SystemProperties.JAVA_VM_SPECIFICATION_VERSION),
    JAVA_VM_SPECIFICATION_VENDOR(SystemProperties.JAVA_VM_SPECIFICATION_VENDOR),
    JAVA_VM_SPECIFICATION_NAME(SystemProperties.JAVA_VM_SPECIFICATION_NAME),
    JAVA_VM_VERSION(SystemProperties.JAVA_VM_VERSION),
    JAVA_VM_VENDOR(SystemProperties.JAVA_VM_VENDOR),
    JAVA_VM_NAME(SystemProperties.JAVA_VM_NAME),
    JAVA_SPECIFICATION_VERSION(SystemProperties.JAVA_SPECIFICATION_VERSION),
    JAVA_SPECIFICATION_VENDOR(SystemProperties.JAVA_SPECIFICATION_VENDOR),
    JAVA_SPECIFICATION_NAME(SystemProperties.JAVA_SPECIFICATION_NAME),
    JAVA_CLASS_VERSION(SystemProperties.JAVA_CLASS_VERSION),
    JAVA_CLASS_PATH(SystemProperties.JAVA_CLASS_PATH),
    JAVA_LIBRARY_PATH(SystemProperties.JAVA_LIBRARY_PATH),
    JAVA_IO_TMPDIR("java.io.tmpdir"),
    JAVA_COMPILER(SystemProperties.JAVA_COMPILER),
    JAVA_EXT_DIRS(SystemProperties.JAVA_EXT_DIRS),
    OS_NAME(SystemProperties.OS_NAME),
    OS_ARCH(SystemProperties.OS_ARCH),
    OS_VERSION(SystemProperties.OS_VERSION),
    FILE_SEPARATOR(SystemProperties.FILE_SEPARATOR),
    PATH_SEPARATOR(SystemProperties.PATH_SEPARATOR),
    LINE_SEPARATOR(SystemProperties.LINE_SEPARATOR),
    USER_NAME("user.name"),
    USER_HOME("user.home"),
    USER_DIR("user.dir");

    private final String key;

    StandardSystemProperty(String str) {
        this.key = str;
    }

    public String key() {
        return this.key;
    }

    @Override // java.lang.Enum
    public String toString() {
        return key() + MarketingConstants.REFERRER_DELIMITER_U003D + value();
    }

    @CheckForNull
    public String value() {
        return System.getProperty(this.key);
    }
}
