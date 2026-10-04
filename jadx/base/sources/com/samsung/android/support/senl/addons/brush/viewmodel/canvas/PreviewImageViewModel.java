package com.samsung.android.support.senl.addons.brush.viewmodel.canvas;

import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel;
import com.samsung.android.support.senl.addons.brush.model.canvas.BrushPreviewBitmap;
import com.samsung.android.support.senl.addons.brush.model.canvas.IBrushCanvasModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\u0006\u0010\u0017\u001a\u00020\u0014J\u0006\u0010\u0018\u001a\u00020\u0014J\u0006\u0010\u0019\u001a\u00020\u0014R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/canvas/PreviewImageViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel;", "mCanvasModel", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/IBrushCanvasModel;", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/model/canvas/IBrushCanvasModel;)V", PreviewImageViewModel.BINDING_ID_PREVIEW_VISIBILITY, "", PreviewImageViewModel.BINDING_ID_CANVAS_VISIBILITY, "getData", "", "id", "", "mCanvasCallBack", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Observer;", PreviewImageViewModel.BINDING_ID_PREVIEW_BITMAP, "Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushPreviewBitmap;", "getPreviewBitmap", "()Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushPreviewBitmap;", "closeSubViewModels", "", "closeCallbacks", "clearModels", "capturePreviewImage", "showPreview", "showCanvas", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPreviewImageViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreviewImageViewModel.kt\ncom/samsung/android/support/senl/addons/brush/viewmodel/canvas/PreviewImageViewModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,106:1\n1#2:107\n*E\n"})
public class PreviewImageViewModel extends AbsBaseViewModel {

    @NotNull
    private static final String BINDING_ID_CANVAS_VISIBILITY = "canvasVisibility";

    @NotNull
    private static final String BINDING_ID_PREVIEW_BITMAP = "previewBitmap";

    @NotNull
    private static final String BINDING_ID_PREVIEW_IMAGE_VIEW_MODEL = "previewViewModel";

    @NotNull
    private static final String BINDING_ID_PREVIEW_VISIBILITY = "previewVisibility";

    @NotNull
    private static final String TAG = Logger.createBrushTag("PreviewImageViewModel");
    private boolean canvasVisibility;

    @Nullable
    private IBrushCanvasModel mCanvasModel;
    private boolean previewVisibility = true;

    @Nullable
    private IBaseModel.Observer mCanvasCallBack = new IBaseModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.viewmodel.canvas.PreviewImageViewModel$mCanvasCallBack$1
        @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
        public void onUpdate(IBaseModel.Info info) {
            Integer id = info != null ? info.getId() : null;
            IBrushCanvasModel.Companion companion = IBrushCanvasModel.INSTANCE;
            int obsv_property_show_preview_images = companion.getOBSV_PROPERTY_SHOW_PREVIEW_IMAGES();
            if (id != null && id.intValue() == obsv_property_show_preview_images) {
                Logger.m7100d(PreviewImageViewModel.TAG, "show Preview Image");
                this.this$0.previewVisibility = true;
                this.this$0.canvasVisibility = false;
                this.this$0.notifyChanged("previewBitmap");
                this.this$0.notifyChanged("previewVisibility");
                this.this$0.notifyChanged("canvasVisibility");
                return;
            }
            int obsv_property_show_preview_images_for_saving = companion.getOBSV_PROPERTY_SHOW_PREVIEW_IMAGES_FOR_SAVING();
            if (id != null && id.intValue() == obsv_property_show_preview_images_for_saving) {
                Logger.m7100d(PreviewImageViewModel.TAG, "show Preview Image for saving.");
                this.this$0.previewVisibility = true;
                this.this$0.notifyChanged("previewBitmap");
                this.this$0.notifyChanged("previewVisibility");
                return;
            }
            int obsv_property_show_canvas = companion.getOBSV_PROPERTY_SHOW_CANVAS();
            if (id != null && id.intValue() == obsv_property_show_canvas) {
                Logger.m7100d(PreviewImageViewModel.TAG, "show canvas.");
                this.this$0.canvasVisibility = true;
                this.this$0.notifyChanged("canvasVisibility");
                this.this$0.previewVisibility = false;
                this.this$0.notifyChanged("previewVisibility");
                return;
            }
            int obsv_property_update_preview = companion.getOBSV_PROPERTY_UPDATE_PREVIEW();
            if (id != null && id.intValue() == obsv_property_update_preview && this.this$0.previewVisibility) {
                Logger.m7100d(PreviewImageViewModel.TAG, "update Preview Image");
                this.this$0.notifyChanged("previewBitmap");
            }
        }
    };

    public PreviewImageViewModel(@Nullable IBrushCanvasModel iBrushCanvasModel) {
        this.mCanvasModel = iBrushCanvasModel;
        IBrushCanvasModel iBrushCanvasModel2 = this.mCanvasModel;
        Intrinsics.checkNotNull(iBrushCanvasModel2);
        iBrushCanvasModel2.addObserver(this.mCanvasCallBack);
    }

    private final BrushPreviewBitmap getPreviewBitmap() {
        IBrushCanvasModel iBrushCanvasModel = this.mCanvasModel;
        if (iBrushCanvasModel == null) {
            return null;
        }
        Intrinsics.checkNotNull(iBrushCanvasModel);
        if (!iBrushCanvasModel.isDocLoaded()) {
            return null;
        }
        IBrushCanvasModel iBrushCanvasModel2 = this.mCanvasModel;
        Intrinsics.checkNotNull(iBrushCanvasModel2);
        return iBrushCanvasModel2.getPreviewBitmap();
    }

    public final void capturePreviewImage() {
        IBrushCanvasModel iBrushCanvasModel = this.mCanvasModel;
        if (iBrushCanvasModel != null) {
            iBrushCanvasModel.capturePreviewImage();
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void clearModels() {
        IBrushCanvasModel iBrushCanvasModel = this.mCanvasModel;
        if (iBrushCanvasModel != null) {
            IBaseModel.Observer observer = this.mCanvasCallBack;
            if (observer != null) {
                Intrinsics.checkNotNull(iBrushCanvasModel);
                iBrushCanvasModel.removeObserver(observer);
            }
            this.mCanvasModel = null;
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeCallbacks() {
        this.mCanvasCallBack = null;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeSubViewModels() {
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    @Nullable
    public Object getData(@Nullable String id) {
        return Intrinsics.areEqual(BINDING_ID_PREVIEW_BITMAP, id) ? getPreviewBitmap() : Intrinsics.areEqual(BINDING_ID_PREVIEW_VISIBILITY, id) ? Boolean.valueOf(this.previewVisibility) : Intrinsics.areEqual(BINDING_ID_CANVAS_VISIBILITY, id) ? Boolean.valueOf(this.canvasVisibility) : Intrinsics.areEqual(BINDING_ID_PREVIEW_IMAGE_VIEW_MODEL, id) ? this : super.getData(id);
    }

    public final void showCanvas() {
        if (this.previewVisibility) {
            Logger.m7100d(TAG, "showCanvas - surfaceCreated");
            this.canvasVisibility = true;
            notifyChanged(BINDING_ID_CANVAS_VISIBILITY);
            this.previewVisibility = false;
            notifyChanged(BINDING_ID_PREVIEW_VISIBILITY);
        }
    }

    public final void showPreview() {
        Logger.m7100d(TAG, "showPreview - surfaceDestroyed");
        notifyChanged(BINDING_ID_PREVIEW_BITMAP);
        this.previewVisibility = true;
        notifyChanged(BINDING_ID_PREVIEW_VISIBILITY);
    }
}
