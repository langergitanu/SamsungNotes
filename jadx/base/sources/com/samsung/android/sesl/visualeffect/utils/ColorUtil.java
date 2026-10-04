package com.samsung.android.sesl.visualeffect.utils;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(26)
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007J1\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000eJ;\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/utils/ColorUtil;", "", "<init>", "()V", "toHexString", "", "color", "", Constants.ARG_UPDATE, "originColor", "r", "", "g", "b", "(ILjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)I", "a", "(ILjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)I", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class ColorUtil {

    @NotNull
    public static final ColorUtil INSTANCE = new ColorUtil();

    private ColorUtil() {
    }

    @NotNull
    public final String toHexString(@ColorInt int color) {
        String hexString = Integer.toHexString(color);
        Intrinsics.checkNotNull(hexString);
        String upperCase = StringsKt.padStart(hexString, 8, 'F').toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return ContentUtils.HASH_SYMBOL + upperCase;
    }

    public final int update(int originColor, @Nullable Float r, @Nullable Float g, @Nullable Float b) {
        return update(originColor, r, g, b, null);
    }

    public final int update(int originColor, @Nullable Float r, @Nullable Float g, @Nullable Float b, @Nullable Float a) {
        Color colorValueOf = Color.valueOf(originColor);
        return Color.argb(a != null ? a.floatValue() : colorValueOf.alpha(), r != null ? r.floatValue() : colorValueOf.red(), g != null ? g.floatValue() : colorValueOf.green(), b != null ? b.floatValue() : colorValueOf.blue());
    }
}
