package androidx.reflect.content.res;

import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslCompatibilityInfoReflector {
    private static final String mClassName = "android.content.res.CompatibilityInfo";

    private SeslCompatibilityInfoReflector() {
    }

    public static float getField_applicationScale(@NonNull Resources resources) {
        Field field;
        Object compatibilityInfo = SeslResourcesReflector.getCompatibilityInfo(resources);
        if (compatibilityInfo == null || (field = SeslBaseReflector.getField(mClassName, "applicationScale")) == null) {
            return 1.0f;
        }
        if (SeslBaseReflector.get(compatibilityInfo, field) instanceof Integer) {
            return ((Integer) r2).intValue();
        }
        return 1.0f;
    }
}
