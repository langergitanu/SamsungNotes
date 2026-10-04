package com.samsung.android.support.senl.addons.base.model.canvas.view.settings;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.SpenSettingRemoverLayout;
import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.IPenSettingPopup;
import com.samsung.android.support.senl.addons.base.model.setting.ISettingShow;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u0003:\u0001\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u0012\u001a\u00020\fH&J\u0012\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&R\u0012\u0010\u0004\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingView;", "T", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/IPenSettingPopup;", "Lcom/samsung/android/support/senl/addons/base/model/setting/ISettingShow;", "penSettingPopup", "getPenSettingPopup", "()Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/IPenSettingPopup;", "removerSettingPopup", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/IRemoverSettingPopup;", "getRemoverSettingPopup", "()Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/IRemoverSettingPopup;", "showPopup", "", "mode", "", "data", "", "hidePopup", "close", "setChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingView$IChangeListener;", "IChangeListener", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ISettingView<T extends IPenSettingPopup> extends ISettingShow {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingView$IChangeListener;", "Lcom/samsung/android/sdk/pen/setting/SpenSettingRemoverLayout$EventListener;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IChangeListener extends SpenSettingRemoverLayout.EventListener {
    }

    void close();

    T getPenSettingPopup();

    @Nullable
    IRemoverSettingPopup getRemoverSettingPopup();

    void hidePopup(int mode);

    void setChangeListener(@Nullable IChangeListener listener);

    void showPopup(int mode, @Nullable Object data);
}
