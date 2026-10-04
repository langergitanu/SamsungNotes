package com.samsung.android.support.senl.addons.base.model.canvas.view.settings;

import android.graphics.RectF;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.SpenSettingSelectionInfo;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ICommonSettingView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/SimpleChangeListener;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ICommonSettingView$IChangeListener;", "<init>", "()V", "onSpuitVisibilityChanged", "", "visible", "", "onColorPicked", "color", "", "x", "", "y", "onChanged", "spenSettingSelectionInfo", "Lcom/samsung/android/sdk/pen/SpenSettingSelectionInfo;", "onClearAll", "onRemoverInfoChanged", "spenSettingRemoverInfo", "Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "onPenInfoChanged", "spenSettingUIPenInfo", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "onPositionUpdated", "position", "Landroid/graphics/RectF;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class SimpleChangeListener implements ICommonSettingView.IChangeListener {
    @Override // com.samsung.android.sdk.pen.engine.SpenSelectionChangeListener
    public void onChanged(@Nullable SpenSettingSelectionInfo spenSettingSelectionInfo) {
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenSettingRemoverLayout.EventListener
    public void onClearAll() {
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenColorPickerListener
    public void onColorPicked(int color, float x, float y2) {
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.PenInfoChangedListener
    public void onPenInfoChanged(@Nullable SpenSettingUIPenInfo spenSettingUIPenInfo) {
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenSelectionChangeListener
    public void onPositionUpdated(@Nullable RectF position) {
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenSettingRemoverLayout.RemoverInfoChangedListener
    public void onRemoverInfoChanged(@Nullable SpenSettingRemoverInfo spenSettingRemoverInfo) {
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ICommonSettingView.IChangeListener
    public void onSpuitVisibilityChanged(boolean visible) {
    }
}
