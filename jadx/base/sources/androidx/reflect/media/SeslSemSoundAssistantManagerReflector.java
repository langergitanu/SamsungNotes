package androidx.reflect.media;

import android.content.Context;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
public class SeslSemSoundAssistantManagerReflector {
    private static String mClassName = "com.samsung.android.media.SemSoundAssistantManager";

    private SeslSemSoundAssistantManagerReflector() {
    }

    private static Object getInstance(Context context) {
        Constructor<?> constructor = SeslBaseReflector.getConstructor(mClassName, Context.class);
        if (constructor == null) {
            return null;
        }
        try {
            return constructor.newInstance(context);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            Log.e("SeslSemSoundAssistantManagerReflector", "Failed to instantiate class");
            return null;
        }
    }

    public static void setFastAudioOpenMode(Context context, boolean z) {
        Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClassName, "setFastAudioOpenMode", (Class<?>[]) new Class[]{Boolean.TYPE});
        Object seslSemSoundAssistantManagerReflector = getInstance(context);
        if (declaredMethod == null || seslSemSoundAssistantManagerReflector == null) {
            return;
        }
        SeslBaseReflector.invoke(seslSemSoundAssistantManagerReflector, declaredMethod, Boolean.valueOf(z));
    }
}
