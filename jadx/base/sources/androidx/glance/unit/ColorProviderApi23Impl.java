package androidx.glance.unit;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\b"}, m13886d2 = {"Landroidx/glance/unit/ColorProviderApi23Impl;", "", "()V", "getColor", "", "context", "Landroid/content/Context;", "resId", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
final class ColorProviderApi23Impl {

    @NotNull
    public static final ColorProviderApi23Impl INSTANCE = new ColorProviderApi23Impl();

    private ColorProviderApi23Impl() {
    }

    @ColorInt
    @DoNotInline
    public final int getColor(@NotNull Context context, @ColorRes int resId) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getColor(resId);
    }
}
