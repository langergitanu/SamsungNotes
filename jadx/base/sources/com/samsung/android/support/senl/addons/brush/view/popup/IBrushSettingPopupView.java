package com.samsung.android.support.senl.addons.brush.view.popup;

import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingPopupView;
import com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationView;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.IBrushMenuInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u00002\u00020\u00012\u00020\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH&J(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH&¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/popup/IBrushSettingPopupView;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingPopupView;", "Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationView;", "updatePosition", "", "info", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/IBrushMenuInfo;", "subAlign", "", "getHorizontalMargin", "getVerticalMargin", "setRotationDelegate", "delegate", "Lcom/samsung/android/support/senl/addons/brush/view/popup/RotationDelegate;", "setRoundedBackground", "radius", "bgColor", "strokeSize", "strokeColor", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IBrushSettingPopupView extends ISettingPopupView, IRotationView {
    int getHorizontalMargin();

    int getVerticalMargin();

    void setRotationDelegate(@NotNull RotationDelegate delegate);

    void setRoundedBackground(int radius, int bgColor, int strokeSize, int strokeColor);

    void updatePosition();

    void updatePosition(@Nullable IBrushMenuInfo info, int subAlign);
}
