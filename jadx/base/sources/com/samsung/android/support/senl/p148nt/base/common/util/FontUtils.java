package com.samsung.android.support.senl.p148nt.base.common.util;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.TextView;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Hashtable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u0005J\u001c\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0007J \u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/FontUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mTypefaceMap", "", "Landroid/graphics/Typeface;", "MAX_FONT_SCALE", "", "getTypeface", "typefacePath", "setFont", "", "textView", "Landroid/widget/TextView;", "font", "getMaxTextSize", "context", "Landroid/content/Context;", "maxFontScale", "textSize", "Font", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FontUtils {
    public static final float MAX_FONT_SCALE = 1.3f;

    @NotNull
    private static final String TAG = "FontUtils";

    @NotNull
    public static final FontUtils INSTANCE = new FontUtils();

    @NotNull
    private static final Map<String, Typeface> mTypefaceMap = new Hashtable();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/FontUtils$Font;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Font {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @NotNull
        public static final String None = "None";

        @NotNull
        public static final String Roboto_Light = "Roboto_Light";

        @NotNull
        public static final String Roboto_Medium = "Roboto_Medium";

        @NotNull
        public static final String Roboto_Regular = "Roboto_Regular";

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/FontUtils$Font$Companion;", "", "<init>", "()V", "None", "", "Roboto_Light", "Roboto_Regular", "Roboto_Medium", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            @NotNull
            public static final String None = "None";

            @NotNull
            public static final String Roboto_Light = "Roboto_Light";

            @NotNull
            public static final String Roboto_Medium = "Roboto_Medium";

            @NotNull
            public static final String Roboto_Regular = "Roboto_Regular";

            private Companion() {
            }
        }
    }

    private FontUtils() {
    }

    @JvmStatic
    public static final float getMaxTextSize(@NotNull Context context, float maxFontScale, float textSize) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (textSize <= 0.0f) {
            return 0.0f;
        }
        float f = context.getResources().getConfiguration().fontScale;
        return f > maxFontScale ? (textSize / f) * maxFontScale : textSize;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0049  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void setFont(@NotNull TextView textView, @Font @Nullable String font) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        if (TextUtils.isEmpty(font)) {
            font = "None";
        }
        int i = C8875R.style.RobotoRegularStyle;
        if (font == null) {
            Logger.m8698e(TAG, "unexpected font use default style!");
        } else {
            int iHashCode = font.hashCode();
            if (iHashCode != 194739631) {
                if (iHashCode != 1887631522) {
                    if (iHashCode == 2083690396 && font.equals("Roboto_Light")) {
                        i = C8875R.style.RobotoLightStyle;
                    }
                } else if (font.equals("Roboto_Regular")) {
                    i = C8875R.style.RobotoRegularStyle;
                }
            } else if (font.equals("Roboto_Medium")) {
                i = C8875R.style.RobotoMediumStyle;
            }
        }
        textView.setTextAppearance(i);
    }

    @Nullable
    public final Typeface getTypeface(@NotNull String typefacePath) {
        Typeface typeface;
        Intrinsics.checkNotNullParameter(typefacePath, "typefacePath");
        Map<String, Typeface> map = mTypefaceMap;
        synchronized (map) {
            if (!map.containsKey(typefacePath)) {
                try {
                    map.put(typefacePath, Typeface.createFromFile(typefacePath));
                } catch (Exception unused) {
                    return Typeface.DEFAULT;
                }
            }
            typeface = map.get(typefacePath);
        }
        return typeface;
    }
}
