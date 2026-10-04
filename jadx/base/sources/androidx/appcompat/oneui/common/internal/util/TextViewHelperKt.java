package androidx.appcompat.oneui.common.internal.util;

import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m13886d2 = {"checkMaxFontScale", "", "Landroid/widget/TextView;", "baseSizeDp", "", "maxFontScale", "Landroidx/appcompat/oneui/common/internal/util/MaxFontScaleRatio;", "appcompat_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TextViewHelperKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final void checkMaxFontScale(@NotNull TextView textView, @DimenRes int i, @NotNull MaxFontScaleRatio maxFontScale) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(maxFontScale, "maxFontScale");
        textView.setTextSize(0, textView.getResources().getDimensionPixelSize(i) * RangesKt.coerceAtMost(textView.getResources().getConfiguration().fontScale, maxFontScale.getRatio()));
    }
}
