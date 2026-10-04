package androidx.reflect.media;

import android.media.AudioAttributes;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslAudioAttributesReflector {

    @RequiresApi(21)
    private static final Class<?> mClass = AudioAttributes.class;

    private SeslAudioAttributesReflector() {
    }

    public static int getField_FLAG_BYPASS_INTERRUPTION_POLICY() {
        Object objInvoke = null;
        if (Build.VERSION.SDK_INT >= 29) {
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "hidden_FLAG_BYPASS_INTERRUPTION_POLICY", (Class<?>[]) new Class[0]);
            if (declaredMethod != null) {
                objInvoke = SeslBaseReflector.invoke(null, declaredMethod, new Object[0]);
            }
        } else {
            Field field = SeslBaseReflector.getField(mClass, "FLAG_BYPASS_INTERRUPTION_POLICY");
            if (field != null) {
                objInvoke = SeslBaseReflector.get(null, field);
            }
        }
        if (objInvoke instanceof Integer) {
            return ((Integer) objInvoke).intValue();
        }
        return 1;
    }
}
