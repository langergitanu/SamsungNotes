package androidx.appcompat.util;

import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.reflect.SeslBaseReflector;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 23)
public class SeslShapeDrawable extends GradientDrawable {
    static final String TAG = "SeslShapeDrawable";

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void inflate(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        Method declaredMethod = SeslBaseReflector.getDeclaredMethod(GradientDrawable.class, "setSmoothCorner", (Class<?>[]) new Class[]{Boolean.TYPE});
        if (declaredMethod == null) {
            Log.w(TAG, "This API is not supported by the platform.");
        } else {
            SeslBaseReflector.invoke(this, declaredMethod, Boolean.TRUE);
        }
    }
}
