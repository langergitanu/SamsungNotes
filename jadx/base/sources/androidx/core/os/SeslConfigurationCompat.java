package androidx.core.os;

import android.content.res.Configuration;
import androidx.annotation.NonNull;
import androidx.reflect.content.res.SeslConfigurationReflector;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class SeslConfigurationCompat {
    private SeslConfigurationCompat() {
    }

    public static boolean isMainDisplay(@NonNull Configuration configuration) {
        Integer field_semDisplayDeviceType = SeslConfigurationReflector.getField_semDisplayDeviceType(configuration);
        return field_semDisplayDeviceType != null && field_semDisplayDeviceType.equals(SeslConfigurationReflector.getField_SEM_DISPLAY_DEVICE_TYPE_MAIN());
    }

    public static boolean isNightModeActive(Configuration configuration) {
        return (configuration.uiMode & 48) == 32;
    }

    public static boolean isSubDisplay(@NonNull Configuration configuration) {
        Integer field_semDisplayDeviceType = SeslConfigurationReflector.getField_semDisplayDeviceType(configuration);
        return field_semDisplayDeviceType != null && field_semDisplayDeviceType.equals(SeslConfigurationReflector.getField_SEM_DISPLAY_DEVICE_TYPE_SUB());
    }

    public static boolean semIsPopOver(@NonNull Configuration configuration) {
        Object field_semIsPopOver = SeslConfigurationReflector.getField_semIsPopOver(configuration);
        if (field_semIsPopOver instanceof Boolean) {
            return ((Boolean) field_semIsPopOver).booleanValue();
        }
        return false;
    }
}
