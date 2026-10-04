package com.samsung.android.support.senl.addons.brush.view.popup;

import android.annotation.SuppressLint;
import android.content.Context;
import com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerLayout;
import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingPopupView;
import com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationEvent;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.IBrushMenuInfo;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u001a\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0012\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\b\u0010 \u001a\u00020\u000eH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/popup/ColorGradationPopupView;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerLayout;", "Lcom/samsung/android/support/senl/addons/brush/view/popup/IBrushSettingPopupView;", "context", "Landroid/content/Context;", "mode", "", "hsvColor", "", "<init>", "(Landroid/content/Context;I[F)V", "mDelegate", "Lcom/samsung/android/support/senl/addons/brush/view/popup/ColorPopupViewDelegate;", "hide", "", "result", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingPopupView$IPopupResult;", Constants.IntentExtraValue.SHOW, "updatePosition", "info", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/IBrushMenuInfo;", "subAlign", "rotate", "event", "Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationEvent;", "setRotationDelegate", "delegate", "Lcom/samsung/android/support/senl/addons/brush/view/popup/RotationDelegate;", "isVisible", "", "getVerticalMargin", "getHorizontalMargin", "close", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
public final class ColorGradationPopupView extends SpenColorPickerLayout implements IBrushSettingPopupView {

    @NotNull
    private final ColorPopupViewDelegate mDelegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColorGradationPopupView(@NotNull Context context, int i, @Nullable float[] fArr) {
        super(context, i, fArr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDelegate = new ColorPopupViewDelegate(context, this);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerLayout, com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingPopupView
    public void close() {
        this.mDelegate.close();
        super.close();
    }

    @Override // com.samsung.android.support.senl.addons.brush.view.popup.IBrushSettingPopupView
    public int getHorizontalMargin() {
        return this.mDelegate.getHorizontalMargin();
    }

    @Override // com.samsung.android.support.senl.addons.brush.view.popup.IBrushSettingPopupView
    public int getVerticalMargin() {
        return this.mDelegate.getVerticalMargin();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingPopupView
    public void hide(@Nullable ISettingPopupView.IPopupResult result) {
        if (result != null) {
            float[] fArr = new float[3];
            getCurrentColor(fArr);
            result.setResult(fArr);
        }
        setVisibility(8);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationView
    public boolean isVisible() {
        return getVisibility() == 0;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationView
    public void rotate(@Nullable IRotationEvent event) {
        this.mDelegate.rotate(event);
    }

    @Override // com.samsung.android.support.senl.addons.brush.view.popup.IBrushSettingPopupView
    public void setRotationDelegate(@NotNull RotationDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.mDelegate.setRotationDelegate(delegate);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingPopupView
    public void show() {
        this.mDelegate.show();
    }

    @Override // com.samsung.android.support.senl.addons.brush.view.popup.IBrushSettingPopupView
    public void updatePosition(@Nullable IBrushMenuInfo info, int subAlign) {
        this.mDelegate.updatePosition(info);
    }

    @Override // com.samsung.android.support.senl.addons.brush.view.popup.IBrushSettingPopupView
    public void updatePosition() {
        this.mDelegate.updatePosition();
    }
}
