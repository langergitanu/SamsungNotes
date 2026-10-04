package com.samsung.android.support.senl.addons.base.model.canvas.view;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.engine.SpenColorPickerListener;
import com.samsung.android.sdk.pen.engine.deltaZoom.SpenZoomListener;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageConst;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/view/ICanvasControl;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/ICanvasFlags;", "setCanvas", "", "view", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IView;", "enableListener", ImageConst.PARAM_MODE_WALLPAPER_MASK, "", "setCanvasActionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/ICanvasControl$ICanvasActionListener;", "setCanvasListeners", "close", "ICanvasActionListener", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ICanvasControl extends ICanvasFlags {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH&¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/view/ICanvasControl$ICanvasActionListener;", "Lcom/samsung/android/sdk/pen/engine/deltaZoom/SpenZoomListener;", "Lcom/samsung/android/sdk/pen/engine/SpenColorPickerListener;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/ITouchListener;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IPreTouchListener;", "onCanvasSizeChanged", "", "left", "", "top", "right", "bottom", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ICanvasActionListener extends SpenZoomListener, SpenColorPickerListener, ITouchListener, IPreTouchListener {
        void onCanvasSizeChanged(int left, int top, int right, int bottom);
    }

    void close();

    void enableListener(int mask);

    void setCanvas(@Nullable IView<?> view);

    void setCanvasActionListener(@Nullable ICanvasActionListener listener);

    void setCanvasListeners();
}
