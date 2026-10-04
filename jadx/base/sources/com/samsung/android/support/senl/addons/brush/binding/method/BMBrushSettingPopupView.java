package com.samsung.android.support.senl.addons.brush.binding.method;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingView;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.IBrushMenuInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/binding/method/BMBrushSettingPopupView;", "Lcom/samsung/android/support/senl/addons/brush/binding/method/BMBrushMenuView;", "updateMenuInfo", "", "info", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/IBrushMenuInfo;", "setChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingView$IChangeListener;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface BMBrushSettingPopupView extends BMBrushMenuView {
    void setChangeListener(@Nullable ISettingView.IChangeListener listener);

    void updateMenuInfo(@Nullable IBrushMenuInfo info);
}
