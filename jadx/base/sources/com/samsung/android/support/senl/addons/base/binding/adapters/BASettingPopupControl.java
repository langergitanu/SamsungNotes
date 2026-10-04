package com.samsung.android.support.senl.addons.base.binding.adapters;

import android.view.View;
import com.samsung.android.sdk.smp.SmpConstants;
import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingPopup;
import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingView;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ*\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/adapters/BASettingPopupControl;", "", "<init>", "()V", "setSettingPopup", "", "view", "Landroid/view/View;", SmpConstants.MARKETING_TYPE_POPUP, "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingPopup;", "setPopup", Constants.IntentExtraValue.SHOW, "", "mode", "", "data", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BASettingPopupControl {

    @NotNull
    public static final BASettingPopupControl INSTANCE = new BASettingPopupControl();

    private BASettingPopupControl() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setPopup(View view, boolean show, int mode, Object data) {
        if (!(view instanceof ISettingView)) {
            throw new ClassCastException("View is not ISpenSettingView");
        }
        ISettingView iSettingView = (ISettingView) view;
        if (show) {
            iSettingView.showPopup(mode, data);
        } else {
            iSettingView.hidePopup(mode);
        }
    }

    public final void setSettingPopup(@NotNull View view, @Nullable ISettingPopup popup) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (popup == null) {
            return;
        }
        setPopup(view, popup.getMIsShow(), popup.getMType(), popup.getMData());
    }
}
