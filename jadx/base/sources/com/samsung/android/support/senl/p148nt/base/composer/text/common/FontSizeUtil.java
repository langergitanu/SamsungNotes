package com.samsung.android.support.senl.p148nt.base.composer.text.common;

import android.content.Context;
import com.samsung.android.sdk.pen.view.SpenConfiguration;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\"\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0007¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/text/common/FontSizeUtil;", "", "<init>", "()V", "getFontSizeList", "", "context", "Landroid/content/Context;", "getNextFontSize", "", "fontSizeArray", "curSize", "isIncrease", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFontSizeUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FontSizeUtil.kt\ncom/samsung/android/support/senl/nt/base/composer/text/common/FontSizeUtil\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,40:1\n11228#2:41\n11563#2,3:42\n*S KotlinDebug\n*F\n+ 1 FontSizeUtil.kt\ncom/samsung/android/support/senl/nt/base/composer/text/common/FontSizeUtil\n*L\n14#1:41\n14#1:42,3\n*E\n"})
public final class FontSizeUtil {

    @NotNull
    public static final FontSizeUtil INSTANCE = new FontSizeUtil();

    private FontSizeUtil() {
    }

    @JvmStatic
    @NotNull
    public static final int[] getFontSizeList(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String[] stringArray = context.getResources().getStringArray(SpenConfiguration.INSTANCE.isTabletUX(context) ? C8875R.array.tablet_rich_text_hw_font_size : C8875R.array.rich_text_hw_font_size);
        Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
        ArrayList arrayList = new ArrayList(stringArray.length);
        for (String str : stringArray) {
            Intrinsics.checkNotNull(str);
            arrayList.add(Integer.valueOf(Integer.parseInt(str)));
        }
        return CollectionsKt.toIntArray(arrayList);
    }

    @JvmStatic
    public static final int getNextFontSize(@Nullable int[] fontSizeArray, int curSize, boolean isIncrease) {
        if (fontSizeArray != null) {
            int i = 0;
            if (isIncrease) {
                int length = fontSizeArray.length;
                while (i < length) {
                    int i2 = fontSizeArray[i];
                    if (i2 > curSize) {
                        return i2;
                    }
                    i++;
                }
            } else {
                List<Integer> listReversed = ArraysKt.reversed(fontSizeArray);
                int size = listReversed.size();
                while (i < size) {
                    int iIntValue = listReversed.get(i).intValue();
                    if (iIntValue < curSize) {
                        return iIntValue;
                    }
                    i++;
                }
            }
        }
        return curSize;
    }
}
