package com.samsung.android.support.senl.addons.brush.model.canvas;

import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/canvas/IBrushCanvasModel;", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel;", "getPageDocWidth", "", "getPageDocHeight", "getPreviewBitmap", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushPreviewBitmap;", "isDocLoaded", "", "capturePreviewImage", "", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IBrushCanvasModel extends IBaseModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/canvas/IBrushCanvasModel$Companion;", "", "<init>", "()V", "OBSV_PROPERTY_SHOW_PREVIEW_IMAGES", "", "getOBSV_PROPERTY_SHOW_PREVIEW_IMAGES", "()I", "setOBSV_PROPERTY_SHOW_PREVIEW_IMAGES", "(I)V", "OBSV_PROPERTY_UPDATE_PREVIEW", "getOBSV_PROPERTY_UPDATE_PREVIEW", "setOBSV_PROPERTY_UPDATE_PREVIEW", "OBSV_PROPERTY_SHOW_PREVIEW_IMAGES_FOR_SAVING", "getOBSV_PROPERTY_SHOW_PREVIEW_IMAGES_FOR_SAVING", "setOBSV_PROPERTY_SHOW_PREVIEW_IMAGES_FOR_SAVING", "OBSV_PROPERTY_SHOW_CANVAS", "getOBSV_PROPERTY_SHOW_CANVAS", "setOBSV_PROPERTY_SHOW_CANVAS", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static int OBSV_PROPERTY_SHOW_PREVIEW_IMAGES = 600;
        private static int OBSV_PROPERTY_UPDATE_PREVIEW = 601;
        private static int OBSV_PROPERTY_SHOW_PREVIEW_IMAGES_FOR_SAVING = 602;
        private static int OBSV_PROPERTY_SHOW_CANVAS = 603;

        private Companion() {
        }

        public final int getOBSV_PROPERTY_SHOW_CANVAS() {
            return OBSV_PROPERTY_SHOW_CANVAS;
        }

        public final int getOBSV_PROPERTY_SHOW_PREVIEW_IMAGES() {
            return OBSV_PROPERTY_SHOW_PREVIEW_IMAGES;
        }

        public final int getOBSV_PROPERTY_SHOW_PREVIEW_IMAGES_FOR_SAVING() {
            return OBSV_PROPERTY_SHOW_PREVIEW_IMAGES_FOR_SAVING;
        }

        public final int getOBSV_PROPERTY_UPDATE_PREVIEW() {
            return OBSV_PROPERTY_UPDATE_PREVIEW;
        }

        public final void setOBSV_PROPERTY_SHOW_CANVAS(int i) {
            OBSV_PROPERTY_SHOW_CANVAS = i;
        }

        public final void setOBSV_PROPERTY_SHOW_PREVIEW_IMAGES(int i) {
            OBSV_PROPERTY_SHOW_PREVIEW_IMAGES = i;
        }

        public final void setOBSV_PROPERTY_SHOW_PREVIEW_IMAGES_FOR_SAVING(int i) {
            OBSV_PROPERTY_SHOW_PREVIEW_IMAGES_FOR_SAVING = i;
        }

        public final void setOBSV_PROPERTY_UPDATE_PREVIEW(int i) {
            OBSV_PROPERTY_UPDATE_PREVIEW = i;
        }
    }

    void capturePreviewImage();

    int getPageDocHeight();

    int getPageDocWidth();

    @Nullable
    BrushPreviewBitmap getPreviewBitmap();

    boolean isDocLoaded();
}
