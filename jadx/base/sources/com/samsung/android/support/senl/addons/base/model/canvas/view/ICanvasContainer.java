package com.samsung.android.support.senl.addons.base.model.canvas.view;

import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u000e\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/view/ICanvasContainer;", "", "getView", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IView;", "getSettingView", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingView;", "getCanvasControl", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/ICanvasControl;", "OnInflateCallback", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ICanvasContainer {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/view/ICanvasContainer$OnInflateCallback;", "", "onInflated", "", "container", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/ICanvasContainer;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnInflateCallback {
        void onInflated(@Nullable ICanvasContainer container);
    }

    @Nullable
    ICanvasControl getCanvasControl();

    @Nullable
    ISettingView<?> getSettingView();

    @Nullable
    IView<?> getView();
}
