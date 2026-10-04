package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSimpleChipView;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.common.QTCircle;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.common.QTVoiceAssistantAsButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorPickerPreviewContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "colorPreview", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSimpleChipView;", "getColorPreview", "()Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSimpleChipView;", "innerCirclePath", "Landroid/graphics/Path;", "setItemAccessibility", "", "item", "Landroid/view/View;", "stringId", "", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nQTColorPickerPreviewContainer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QTColorPickerPreviewContainer.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorPickerPreviewContainer\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 Canvas.kt\nandroidx/core/graphics/CanvasKt\n*L\n1#1,63:1\n176#2,2:64\n27#3,7:66\n*S KotlinDebug\n*F\n+ 1 QTColorPickerPreviewContainer.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorPickerPreviewContainer\n*L\n29#1:64,2\n57#1:66,7\n*E\n"})
public final class QTColorPickerPreviewContainer extends FrameLayout {

    @NotNull
    private final SpenSimpleChipView colorPreview;

    @NotNull
    private final Path innerCirclePath;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QTColorPickerPreviewContainer(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setWillNotDraw(false);
        float dimension = getResources().getDimension(C9086R.dimen.composer_qt_color_picker_layout_width);
        float dimension2 = getResources().getDimension(C9086R.dimen.composer_qt_color_picker_layout_height);
        SpenSimpleChipView spenSimpleChipView = new SpenSimpleChipView(context);
        spenSimpleChipView.setBackgroundResource(C9086R.drawable.spen_round_ripple);
        int dimensionPixelSize = spenSimpleChipView.getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_attr_color_item_padding);
        spenSimpleChipView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        setItemAccessibility(spenSimpleChipView, C9086R.string.pen_string_pen_color);
        int dimensionPixelSize2 = spenSimpleChipView.getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_circle_color_item_size);
        spenSimpleChipView.setLayoutParams(new ViewGroup.LayoutParams(dimensionPixelSize2, dimensionPixelSize2));
        float f = dimension * 0.5f;
        float f4 = 0.5f * dimension2;
        new QTCircle(f, f4, spenSimpleChipView.getResources().getDimension(C9086R.dimen.composer_qt_color_picker_color_tone_seekbar_max_radius)).place(spenSimpleChipView, dimensionPixelSize2, dimensionPixelSize2, 0.0f);
        this.colorPreview = spenSimpleChipView;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams((int) dimension, (int) dimension2));
        frameLayout.addView(spenSimpleChipView);
        addView(frameLayout);
        Path path = new Path();
        path.addCircle(f, f4, getResources().getDimension(C9086R.dimen.qt_ai_menu_radius), Path.Direction.CW);
        this.innerCirclePath = path;
    }

    private final void setItemAccessibility(View item, int stringId) {
        String string = getContext().getString(stringId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        item.setContentDescription(string);
        SpenSettingUtilHover.setHoverText(item, string);
        item.setAccessibilityDelegate(new QTVoiceAssistantAsButton());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int iSave = canvas.save();
        try {
            canvas.clipOutPath(this.innerCirclePath);
            super.dispatchDraw(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    @NotNull
    public final SpenSimpleChipView getColorPreview() {
        return this.colorPreview;
    }
}
