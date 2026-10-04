package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.colorpicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import com.samsung.android.sdk.pen.setting.patternpalette.ViewOnClickListenerC7602a;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.common.QTSlider3;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.extension.ViewGroupExtensionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p241t3.C14467a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/colorpicker/QTColorDetailLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "hsv", "", Constants.ARG_UPDATE, "Lkotlin/Function1;", "", "<init>", "(Landroid/content/Context;[FLkotlin/jvm/functions/Function1;)V", "cx", "", "cy", "radius", "setupValueSlider", "setupColorPreview", "setupSaturationSlider", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
public final class QTColorDetailLayout extends FrameLayout {
    private final float cx;
    private final float cy;

    @NotNull
    private final float[] hsv;
    private final float radius;

    @NotNull
    private final Function1<float[], Unit> update;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QTColorDetailLayout(@NotNull Context context, @NotNull float[] hsv, @NotNull Function1<? super float[], Unit> update) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hsv, "hsv");
        Intrinsics.checkNotNullParameter(update, "update");
        this.hsv = hsv;
        this.update = update;
        this.cx = getResources().getDimension(C9086R.dimen.qt_container_width) * 0.5f;
        this.cy = getResources().getDimension(C9086R.dimen.qt_container_height) * 0.5f;
        this.radius = getResources().getDimension(C9086R.dimen.qt_outer_radius);
        setupValueSlider();
        setupColorPreview();
        setupSaturationSlider();
    }

    private final void setupColorPreview() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(C9086R.dimen.qt_color_preview_size);
        View view = new View(getContext());
        view.setOnClickListener(new ViewOnClickListenerC7602a(8));
        ViewGroupExtensionKt.addView(this, view, dimensionPixelSize, dimensionPixelSize, this.cx, this.cy, this.radius, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupColorPreview$lambda$1(View view) {
    }

    private final void setupSaturationSlider() {
        float[] fArr = {this.hsv[0], 1.0f, 1.0f};
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        addView(new QTSlider3(context, new int[]{-1, Color.HSVToColor(fArr)}, new float[]{0.041666668f, 0.20833333f}, 15.0f, 75.0f, this.hsv[1], new C14467a(this, 0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupSaturationSlider$lambda$2(QTColorDetailLayout qTColorDetailLayout, float f) {
        float[] fArr = qTColorDetailLayout.hsv;
        fArr[1] = f;
        qTColorDetailLayout.update.invoke(fArr);
        return Unit.INSTANCE;
    }

    private final void setupValueSlider() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        addView(new QTSlider3(context, new int[]{-1, -16777216}, new float[]{0.7916667f, 0.9583333f}, 285.0f, 345.0f, this.hsv[2], new C14467a(this, 1)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupValueSlider$lambda$0(QTColorDetailLayout qTColorDetailLayout, float f) {
        float[] fArr = qTColorDetailLayout.hsv;
        fArr[2] = 1.0f - f;
        qTColorDetailLayout.update.invoke(fArr);
        return Unit.INSTANCE;
    }
}
