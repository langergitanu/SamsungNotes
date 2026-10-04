package com.samsung.android.support.senl.addons.brush.model.canvas;

import com.samsung.android.sdk.pen.document.SpenHistoryUpdateInfo;
import com.samsung.android.support.senl.addons.base.model.canvas.view.IPaintingView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&J(\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH&J\u001f\u0010\u000f\u001a\u00020\u00032\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011H&¢\u0006\u0002\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u00032\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011H&¢\u0006\u0002\u0010\u0013¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/canvas/IBrushCanvas;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IPaintingView;", "setMargin", "", "left", "", "top", "right", "bottom", "setTouchMargin", "marginLeft", "", "marginTop", "marginRight", "marginBottom", "updateUndo", "userDataList", "", "Lcom/samsung/android/sdk/pen/document/SpenHistoryUpdateInfo;", "([Lcom/samsung/android/sdk/pen/document/SpenHistoryUpdateInfo;)V", "updateRedo", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IBrushCanvas extends IPaintingView {
    public static final float BRUSH_CANVAS_MIN_ZOOM = 0.9f;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/canvas/IBrushCanvas$Companion;", "", "<init>", "()V", "BRUSH_CANVAS_MIN_ZOOM", "", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final float BRUSH_CANVAS_MIN_ZOOM = 0.9f;

        private Companion() {
        }
    }

    void setMargin(float left, float top, float right, float bottom);

    void setTouchMargin(int marginLeft, int marginTop, int marginRight, int marginBottom);

    void updateRedo(@Nullable SpenHistoryUpdateInfo[] userDataList);

    void updateUndo(@Nullable SpenHistoryUpdateInfo[] userDataList);
}
