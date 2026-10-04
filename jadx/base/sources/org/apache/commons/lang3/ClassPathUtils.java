package org.apache.commons.lang3;

import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ClassPathUtils {
    @Deprecated
    public ClassPathUtils() {
    }

    public static String packageToPath(String str) {
        Objects.requireNonNull(str, "path");
        return str.replace('.', '/');
    }

    public static String pathToPackage(String str) {
        Objects.requireNonNull(str, "path");
        return str.replace('/', '.');
    }

    public static String toFullyQualifiedName(Class<?> cls, String str) {
        Objects.requireNonNull(cls, "context");
        Objects.requireNonNull(str, "resourceName");
        return toFullyQualifiedName(cls.getPackage(), str);
    }

    public static String toFullyQualifiedPath(Class<?> cls, String str) {
        Objects.requireNonNull(cls, "context");
        Objects.requireNonNull(str, "resourceName");
        return toFullyQualifiedPath(cls.getPackage(), str);
    }

    public static String toFullyQualifiedName(Package r12, String str) {
        Objects.requireNonNull(r12, "context");
        Objects.requireNonNull(str, "resourceName");
        return r12.getName() + Extension.DOT + str;
    }

    public static String toFullyQualifiedPath(Package r12, String str) {
        Objects.requireNonNull(r12, "context");
        Objects.requireNonNull(str, "resourceName");
        return packageToPath(r12.getName()) + "/" + str;
    }
}
