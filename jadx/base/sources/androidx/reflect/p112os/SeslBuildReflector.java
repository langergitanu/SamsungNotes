package androidx.reflect.p112os;

import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslBuildReflector {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SeslVersionReflector {
        private static final Class<?> mClass = Build.VERSION.class;

        private SeslVersionReflector() {
        }

        public static int getField_SEM_PLATFORM_INT() {
            Field declaredField;
            if (Build.VERSION.SDK_INT < 28 || (declaredField = SeslBaseReflector.getDeclaredField(mClass, "SEM_PLATFORM_INT")) == null || !(SeslBaseReflector.get(null, declaredField) instanceof Integer)) {
                return -1;
            }
            return ((Integer) SeslBaseReflector.get(null, declaredField)).intValue();
        }
    }

    private SeslBuildReflector() {
    }
}
