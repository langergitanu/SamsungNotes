package com.samsung.android.support.senl.addons.base.model.canvas.view.settings;

import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.engine.SpenColorPickerListener;
import com.samsung.android.sdk.pen.engine.SpenSelectionChangeListener;
import com.samsung.android.sdk.pen.setting.SpenSettingRemoverLayout;
import com.samsung.android.sdk.pen.setting.pencommon.PenInfoChangedListener;
import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002\u0011\u0012J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH&J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0010H&¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ICommonSettingView;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingView;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ICommonPenSettingPopup;", "saveSettingInfo", "", "close", "hideSettingView", "addRecentColor", "color", "", "hsv", "", "savePenSettingInfo", "info", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "saveRemoverSettingInfo", "Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "IChangeListener", "ISettingPopupListener", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ICommonSettingView extends ISettingView<ICommonPenSettingPopup> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ICommonSettingView$IChangeListener;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingView$IChangeListener;", "Lcom/samsung/android/sdk/pen/setting/pencommon/PenInfoChangedListener;", "Lcom/samsung/android/sdk/pen/setting/SpenSettingRemoverLayout$RemoverInfoChangedListener;", "Lcom/samsung/android/sdk/pen/engine/SpenColorPickerListener;", "Lcom/samsung/android/sdk/pen/engine/SpenSelectionChangeListener;", "onSpuitVisibilityChanged", "", "visible", "", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IChangeListener extends ISettingView.IChangeListener, PenInfoChangedListener, SpenSettingRemoverLayout.RemoverInfoChangedListener, SpenColorPickerListener, SpenSelectionChangeListener {
        void onSpuitVisibilityChanged(boolean visible);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001H&R\u0012\u0010\b\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ICommonSettingView$ISettingPopupListener;", "", "onClose", "", "type", "", "onOpen", "", "currentPopup", "getCurrentPopup", "()I", "storePopupData", "data", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ISettingPopupListener {
        int getCurrentPopup();

        boolean onClose(int type);

        void onOpen(int type);

        void storePopupData(int type, @Nullable Object data);
    }

    void addRecentColor(int color);

    void addRecentColor(@Nullable float[] hsv);

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingView
    void close();

    void hideSettingView();

    void savePenSettingInfo(@Nullable SpenSettingPenInfo info);

    void saveRemoverSettingInfo(@Nullable SpenSettingRemoverInfo info);

    void saveSettingInfo();
}
