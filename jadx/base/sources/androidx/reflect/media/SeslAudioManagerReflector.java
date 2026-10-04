package androidx.reflect.media;

import android.media.AudioManager;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslAudioManagerReflector {
    private static final Class<?> mClass = AudioManager.class;

    private SeslAudioManagerReflector() {
    }

    public static int getField_SOUND_TIME_PICKER_SCROLL() {
        Field field = SeslBaseReflector.getField(mClass, "SOUND_TIME_PICKER_SCROLL");
        if (field == null) {
            return 0;
        }
        Object obj = SeslBaseReflector.get(null, field);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public static int getField_SOUND_TIME_PICKER_SCROLL_FAST() {
        Field field = SeslBaseReflector.getField(mClass, "SOUND_TIME_PICKER_FAST");
        if (field == null) {
            return 0;
        }
        Object obj = SeslBaseReflector.get(null, field);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public static int getField_SOUND_TIME_PICKER_SCROLL_SLOW() {
        Field field = SeslBaseReflector.getField(mClass, "SOUND_TIME_PICKER_SLOW");
        if (field == null) {
            return 0;
        }
        Object obj = SeslBaseReflector.get(null, field);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }
}
