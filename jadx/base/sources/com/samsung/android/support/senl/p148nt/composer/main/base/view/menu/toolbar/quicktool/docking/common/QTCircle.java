package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.common;

import android.view.View;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format.ServerResultMeetingParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/common/QTCircle;", "", "cx", "", "cy", "radius", "<init>", "(FFF)V", ServerResultMeetingParser.PLACE, "", "view", "Landroid/view/View;", "width", "", "height", "degrees", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nQTCircle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QTCircle.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/common/QTCircle\n+ 2 FloatExtension.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/extension/FloatExtensionKt\n*L\n1#1,19:1\n19#2:20\n*S KotlinDebug\n*F\n+ 1 QTCircle.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/common/QTCircle\n*L\n14#1:20\n*E\n"})
public final class QTCircle {
    private final float cx;
    private final float cy;
    private final float radius;

    public QTCircle(float f, float f4, float f5) {
        this.cx = f;
        this.cy = f4;
        this.radius = f5;
    }

    public final void place(@NotNull View view, int width, int height, float degrees) {
        Intrinsics.checkNotNullParameter(view, "view");
        double d = (float) ((((double) degrees) * 3.141592653589793d) / ((double) 180));
        view.setX(((this.radius * ((float) Math.cos(d))) + this.cx) - (width * 0.5f));
        view.setY(((this.radius * ((float) Math.sin(d))) + this.cy) - (height * 0.5f));
    }
}
