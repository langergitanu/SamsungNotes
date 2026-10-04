package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.extension;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u001aB\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t¨\u0006\r"}, m13886d2 = {"addView", "", "Landroid/view/ViewGroup;", "child", "Landroid/view/View;", "width", "", "height", "cx", "", "cy", "radius", "degrees", "ntComposer_release"}, m13887k = 2, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nViewGroupExtension.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewGroupExtension.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/extension/ViewGroupExtensionKt\n+ 2 FloatExtension.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/extension/FloatExtensionKt\n*L\n1#1,24:1\n19#2:25\n*S KotlinDebug\n*F\n+ 1 ViewGroupExtension.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/extension/ViewGroupExtensionKt\n*L\n18#1:25\n*E\n"})
public final class ViewGroupExtensionKt {
    public static final void addView(@NotNull ViewGroup viewGroup, @NotNull View child, int i, int i2, float f, float f4, float f5, float f6) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        double d = (float) ((((double) f6) * 3.141592653589793d) / ((double) 180));
        child.setX(((((float) Math.cos(d)) * f5) + f) - (i * 0.5f));
        child.setY(((f5 * ((float) Math.sin(d))) + f4) - (i2 * 0.5f));
        child.setLayoutParams(new ViewGroup.LayoutParams(i, i2));
        viewGroup.addView(child);
    }
}
