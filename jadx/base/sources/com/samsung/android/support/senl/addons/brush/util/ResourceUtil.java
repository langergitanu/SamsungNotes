package com.samsung.android.support.senl.addons.brush.util;

import android.content.res.Resources;
import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/util/ResourceUtil;", "", "<init>", "()V", "mOutValue", "Landroid/util/TypedValue;", "getFloatRes", "", "res", "Landroid/content/res/Resources;", "id", "", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ResourceUtil {

    @NotNull
    public static final ResourceUtil INSTANCE = new ResourceUtil();

    @NotNull
    private static final TypedValue mOutValue = new TypedValue();

    private ResourceUtil() {
    }

    @JvmStatic
    public static final float getFloatRes(@NotNull Resources res, int id) {
        Intrinsics.checkNotNullParameter(res, "res");
        TypedValue typedValue = mOutValue;
        res.getValue(id, typedValue, true);
        return typedValue.getFloat();
    }
}
