package androidx.reflect.media;

import android.media.RingtoneManager;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslRingtoneManagerReflector {
    private static final Class<?> mClass = RingtoneManager.class;

    private SeslRingtoneManagerReflector() {
    }

    public static String getField_EXTRA_RINGTONE_AUDIO_ATTRIBUTES_FLAGS() {
        Object objInvoke = null;
        if (Build.VERSION.SDK_INT >= 29) {
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "hidden_EXTRA_RINGTONE_AUDIO_ATTRIBUTES_FLAGS", (Class<?>[]) new Class[0]);
            if (declaredMethod != null) {
                objInvoke = SeslBaseReflector.invoke(null, declaredMethod, new Object[0]);
            }
        } else {
            Field field = SeslBaseReflector.getField(mClass, "EXTRA_RINGTONE_AUDIO_ATTRIBUTES_FLAGS");
            if (field != null) {
                objInvoke = SeslBaseReflector.get(null, field);
            }
        }
        return objInvoke instanceof String ? (String) objInvoke : "android.intent.extra.ringtone.SHOW_DEFAULT";
    }
}
