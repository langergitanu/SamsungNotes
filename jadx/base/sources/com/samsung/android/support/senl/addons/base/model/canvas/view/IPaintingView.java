package com.samsung.android.support.senl.addons.base.model.canvas.view;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.document.SpenHistoryUpdateInfo;
import com.samsung.android.sdk.pen.document.SpenPaintingDoc;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u001d2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002\u001c\u001dJ\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J*\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH&J\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0010H&J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H&J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IPaintingView;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IView;", "Lcom/samsung/android/sdk/pen/document/SpenHistoryUpdateInfo;", "capturePage", "Landroid/graphics/Bitmap;", "ratio", "", "option", "", "getValidRect", "Landroid/graphics/RectF;", "lMargin", "tMargin", "rMargin", "bMargin", "setPaintingDoc", "", "paintingDoc", "Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc;", "isUpdate", "captureRect", "rect", "setMouseWheelZoomEnabled", "", "wheelZoomEnabled", "setOnLoadedDocumentListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IPaintingView$OnDocumentLoadedListener;", "OnDocumentLoadedListener", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IPaintingView extends IView<SpenHistoryUpdateInfo> {
    public static final int CAPTURE_ALL = 286261521;
    public static final int CAPTURE_FOREGROUND_ALL = 273;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IPaintingView$Companion;", "", "<init>", "()V", "CAPTURE_ALL", "", "CAPTURE_FOREGROUND_ALL", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int CAPTURE_ALL = 286261521;
        public static final int CAPTURE_FOREGROUND_ALL = 273;

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IPaintingView$OnDocumentLoadedListener;", "", "onLoaded", "", "view", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IPaintingView;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnDocumentLoadedListener {
        void onLoaded(@Nullable IPaintingView view);
    }

    @Nullable
    Bitmap capturePage(float ratio, int option);

    @Nullable
    Bitmap captureRect(@Nullable RectF rect);

    @Nullable
    RectF getValidRect(int lMargin, int tMargin, int rMargin, int bMargin);

    void setMouseWheelZoomEnabled(boolean wheelZoomEnabled);

    void setOnLoadedDocumentListener(@Nullable OnDocumentLoadedListener listener);

    boolean setPaintingDoc(@Nullable SpenPaintingDoc paintingDoc, boolean isUpdate);
}
