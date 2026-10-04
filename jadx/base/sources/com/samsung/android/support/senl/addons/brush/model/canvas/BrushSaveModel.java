package com.samsung.android.support.senl.addons.brush.model.canvas;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.pen.document.SpenPaintingDoc;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.base.model.canvas.ISDocSaveModel;
import com.samsung.android.support.senl.addons.base.model.common.ISavableModel;
import com.samsung.android.support.senl.addons.base.model.save.AbsSaveModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.utils.PlatformUtil;
import com.samsung.android.support.senl.addons.base.utils.ToolsToastHandler;
import com.samsung.android.support.senl.addons.brush.model.canvas.BrushSaveExecutor;
import com.samsung.android.support.senl.addons.brush.util.BrushToastHandler;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\b\u0016\u0018\u0000 =2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0003:\u0002=>B\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ:\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u001d\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fJ\b\u0010 \u001a\u0004\u0018\u00010\u000fJ\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020\u0017H\u0002J%\u0010'\u001a\u00020\u00172\u0016\u0010(\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020)\"\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010*J%\u0010+\u001a\u00020\u00172\u0016\u0010(\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020)\"\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010*J\b\u0010,\u001a\u00020\u0017H\u0016J\u0016\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/J\u0010\u00101\u001a\u00020\u00172\b\u00102\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010+\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u0002H\u0002J\u0010\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u0002H\u0002J\b\u0010'\u001a\u00020\u0017H\u0002J\b\u00106\u001a\u00020\u0017H\u0002J\b\u00107\u001a\u00020\u0002H\u0016J\b\u00108\u001a\u00020\u0017H\u0016J\u0006\u00109\u001a\u00020\u0002J\u0012\u0010:\u001a\u00020\u00172\b\u0010;\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010<\u001a\u00020\u0017H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushSaveModel;", "Lcom/samsung/android/support/senl/addons/base/model/save/AbsSaveModel;", "", "Lcom/samsung/android/support/senl/addons/base/model/common/ISavableModel;", "facade", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushFacade;", CategoryConstants.Restored.UUID_PREFIX, "<init>", "(Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushFacade;Z)V", "mBrushFacade", "mProcessListener", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushSaveModel$IOnProcessListener;", "mExecutor", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushSaveExecutor;", "mInputPaintingDocPath", "", "mInputThumbnailPath", "mOutputPaintingDocPath", "mOutputThumbnailPath", "mInternalPath", "mSaveFileCallback", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushSaveExecutor$OnSaveFileCallback;", "setPathInfo", "", "inPaintingDocPath", "inThumbnailPath", "outPaintingDocPath", "outThumbnailPath", "internalPath", "getInputPaintingDocPath", "getOutputPaintingDocPath", "getInputThumbnailPath", "getOutputThumbnailPath", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "Landroid/os/Bundle;", "onLoadFromInstanceState", "inState", "onLoadFinished", "saveAsync", ActionHandler.PARAMS, "", "([Ljava/lang/Boolean;)V", "saveSync", "quitSave", "setThumbnailMargin", "horizontal", "", "vertical", "setProcessListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "runThread", "finishSave", "isSaved", "removeContent", "isPaintingDocChanged", "close", "updateDocumentWithoutSaving", "removeLocalFiles", "path", "joinSave", "Companion", "IOnProcessListener", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class BrushSaveModel extends AbsSaveModel<Boolean> implements ISavableModel {

    @NotNull
    private static final String TAG = Logger.createBrushTag("BrushSaveModel");

    @Nullable
    private BrushFacade mBrushFacade;

    @Nullable
    private BrushSaveExecutor mExecutor;

    @Nullable
    private String mInputPaintingDocPath;

    @Nullable
    private String mInputThumbnailPath;

    @Nullable
    private String mInternalPath;

    @Nullable
    private String mOutputPaintingDocPath;

    @Nullable
    private String mOutputThumbnailPath;

    @Nullable
    private IOnProcessListener mProcessListener;

    @NotNull
    private final BrushSaveExecutor.OnSaveFileCallback mSaveFileCallback;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushSaveModel$IOnProcessListener;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/ISDocSaveModel$OnProcessListener;", "onDocumentLoaded", "", "onStartSave", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IOnProcessListener extends ISDocSaveModel.OnProcessListener {
        void onDocumentLoaded();

        void onStartSave();
    }

    public BrushSaveModel(@Nullable BrushFacade brushFacade, boolean z) {
        BrushSaveExecutor.OnSaveFileCallback onSaveFileCallback = new BrushSaveExecutor.OnSaveFileCallback() { // from class: com.samsung.android.support.senl.addons.brush.model.canvas.BrushSaveModel$mSaveFileCallback$1
            @Override // com.samsung.android.support.senl.addons.brush.model.canvas.BrushSaveExecutor.OnSaveFileCallback
            public String getNewDocPath() {
                return this.this$0.mOutputPaintingDocPath;
            }

            @Override // com.samsung.android.support.senl.addons.brush.model.canvas.BrushSaveExecutor.OnSaveFileCallback
            public String getNewThumbnailPath() {
                return this.this$0.mOutputThumbnailPath;
            }

            @Override // com.samsung.android.support.senl.addons.brush.model.canvas.BrushSaveExecutor.OnSaveFileCallback
            public void onSaveFinished(boolean isSuccess) {
                BrushFacade brushFacade2 = this.this$0.mBrushFacade;
                Intrinsics.checkNotNull(brushFacade2);
                brushFacade2.notifyChanged(Integer.valueOf(IBrushCanvasModel.INSTANCE.getOBSV_PROPERTY_SHOW_PREVIEW_IMAGES_FOR_SAVING()));
                this.this$0.onCompleteAllProcess(isSuccess);
                this.this$0.mProcessListener = null;
            }
        };
        this.mSaveFileCallback = onSaveFileCallback;
        this.mBrushFacade = brushFacade;
        BrushSaveExecutor brushSaveExecutor = new BrushSaveExecutor(brushFacade);
        this.mExecutor = brushSaveExecutor;
        brushSaveExecutor.setSaveFileCallback(onSaveFileCallback);
        if (z || TextUtils.isEmpty(this.mOutputPaintingDocPath) || TextUtils.isEmpty(this.mOutputThumbnailPath)) {
            return;
        }
        BrushSaveExecutor brushSaveExecutor2 = this.mExecutor;
        if (brushSaveExecutor2 != null) {
            brushSaveExecutor2.setFilePath(this.mOutputPaintingDocPath, this.mOutputThumbnailPath);
        }
        BrushFacade brushFacade2 = this.mBrushFacade;
        Intrinsics.checkNotNull(brushFacade2);
        brushFacade2.createDocument(this.mInputPaintingDocPath);
    }

    private final void finishSave(boolean isSaved) {
        onCompleteAllProcess(isSaved);
    }

    private final void onLoadFinished() {
        if (this.mInternalPath == null) {
            Logger.m7101e(TAG, "onLoadFinished : SDoc is null!!! or other process is loaded");
            finishSave(false);
            return;
        }
        BrushSaveExecutor brushSaveExecutor = this.mExecutor;
        if (brushSaveExecutor != null) {
            brushSaveExecutor.setFilePath(this.mOutputPaintingDocPath, this.mOutputThumbnailPath);
        }
        BrushFacade brushFacade = this.mBrushFacade;
        if (brushFacade != null) {
            brushFacade.createDocument(this.mInputPaintingDocPath);
        }
        IOnProcessListener iOnProcessListener = this.mProcessListener;
        if (iOnProcessListener != null) {
            Intrinsics.checkNotNull(iOnProcessListener);
            iOnProcessListener.onDocumentLoaded();
        }
    }

    private final void removeContent() {
        BrushSaveExecutor brushSaveExecutor = this.mExecutor;
        if (brushSaveExecutor != null) {
            brushSaveExecutor.setPaintDocForegroundImage();
        }
        removeLocalFiles(this.mOutputThumbnailPath);
        removeLocalFiles(this.mOutputPaintingDocPath);
    }

    private final void removeLocalFiles(String path) {
        if (path == null) {
            return;
        }
        File file = new File(path);
        if (file.exists()) {
            boolean zDelete = file.delete();
            Logger.m7104i(TAG, "remove local temp file : " + Logger.getEncode(path) + ", isDeleted " + zDelete);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.save.AbsSaveModel
    public void close() {
        BrushFacade brushFacade = this.mBrushFacade;
        if (brushFacade != null) {
            Intrinsics.checkNotNull(brushFacade);
            if (brushFacade.isDiscardDoc()) {
                BrushFacade brushFacade2 = this.mBrushFacade;
                Intrinsics.checkNotNull(brushFacade2);
                brushFacade2.discardDoc();
            }
        }
        super.close();
    }

    @Nullable
    /* JADX INFO: renamed from: getInputPaintingDocPath, reason: from getter */
    public final String getMInputPaintingDocPath() {
        return this.mInputPaintingDocPath;
    }

    @Nullable
    /* JADX INFO: renamed from: getInputThumbnailPath, reason: from getter */
    public final String getMInputThumbnailPath() {
        return this.mInputThumbnailPath;
    }

    @Nullable
    /* JADX INFO: renamed from: getOutputPaintingDocPath, reason: from getter */
    public final String getMOutputPaintingDocPath() {
        return this.mOutputPaintingDocPath;
    }

    @Nullable
    /* JADX INFO: renamed from: getOutputThumbnailPath, reason: from getter */
    public final String getMOutputThumbnailPath() {
        return this.mOutputThumbnailPath;
    }

    public boolean isPaintingDocChanged() {
        BrushFacade brushFacade = this.mBrushFacade;
        if (brushFacade == null) {
            return false;
        }
        Intrinsics.checkNotNull(brushFacade);
        SpenPaintingDoc paintingDoc = brushFacade.getPaintingDoc();
        Boolean boolValueOf = paintingDoc != null ? Boolean.valueOf(paintingDoc.isChanged()) : null;
        Logger.m7100d(TAG, "isPaintingDocChanged : " + boolValueOf);
        return Intrinsics.areEqual(boolValueOf, Boolean.TRUE);
    }

    public void joinSave() {
        BrushSaveExecutor brushSaveExecutor = this.mExecutor;
        if (brushSaveExecutor != null && !brushSaveExecutor.joinSave()) {
            Logger.m7100d(TAG, "join save, restart save on main thread");
            quitSave();
            saveSync(false);
        }
        Logger.m7100d(TAG, "join save, completed");
    }

    @Override // com.samsung.android.support.senl.addons.base.model.common.ISavableModel
    public void onLoadFromInstanceState(@NotNull Bundle inState) {
        Intrinsics.checkNotNullParameter(inState, "inState");
        this.mInputPaintingDocPath = inState.getString("brush_input_painting_doc_path");
        this.mInputThumbnailPath = inState.getString("brush_input_thumbnail_path");
        this.mOutputPaintingDocPath = inState.getString("brush_output_painting_doc_path");
        this.mOutputThumbnailPath = inState.getString("brush_output_thumbnail_path");
        this.mInternalPath = inState.getString("internal_path");
    }

    @Override // com.samsung.android.support.senl.addons.base.model.common.ISavableModel
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putString("brush_input_painting_doc_path", this.mInputPaintingDocPath);
        outState.putString("brush_input_thumbnail_path", this.mInputThumbnailPath);
        outState.putString("brush_output_painting_doc_path", this.mOutputPaintingDocPath);
        outState.putString("brush_output_thumbnail_path", this.mOutputThumbnailPath);
        outState.putString("internal_path", this.mInternalPath);
    }

    public void quitSave() {
        BrushSaveExecutor brushSaveExecutor = this.mExecutor;
        if (brushSaveExecutor != null) {
            brushSaveExecutor.quitSave();
        }
    }

    public void setPathInfo(@Nullable String inPaintingDocPath, @Nullable String inThumbnailPath, @Nullable String outPaintingDocPath, @Nullable String outThumbnailPath, @Nullable String internalPath) {
        this.mInputPaintingDocPath = inPaintingDocPath;
        this.mInputThumbnailPath = inThumbnailPath;
        this.mInternalPath = internalPath;
        this.mOutputPaintingDocPath = outPaintingDocPath;
        this.mOutputThumbnailPath = outThumbnailPath;
        if (TextUtils.isEmpty(outPaintingDocPath)) {
            String str = this.mInternalPath;
            String str2 = File.separator;
            String brushFileExtension = PlatformUtil.getBrushFileExtension();
            Intrinsics.checkNotNull(brushFileExtension);
            this.mOutputPaintingDocPath = AbstractC0541b.m757C(str, str2, PlatformUtil.getFileNameByTime("", brushFileExtension));
        }
        if (TextUtils.isEmpty(outThumbnailPath)) {
            this.mOutputThumbnailPath = AbstractC0541b.m757C(this.mInternalPath, File.separator, PlatformUtil.getFileNameByTime("", PlatformUtil.getThumbnailExtension()));
        }
        String str3 = TAG;
        String encode = Logger.getEncode(this.mInputPaintingDocPath);
        String encode2 = Logger.getEncode(this.mInputThumbnailPath);
        String encode3 = Logger.getEncode(this.mInternalPath);
        StringBuilder sbM16m = AbstractC0000a.m16m("setPathInfo. input doc:  + ", encode, " + , thumbnail:  + ", encode2, " + , save:  + ");
        sbM16m.append(encode3);
        Logger.m7100d(str3, sbM16m.toString());
        Logger.m7100d(str3, "setPathInfo. output doc:  + " + Logger.getEncode(this.mOutputPaintingDocPath) + " + , thumbnail:  + " + Logger.getEncode(this.mOutputThumbnailPath));
        onLoadFinished();
    }

    public final void setProcessListener(@Nullable IOnProcessListener listener) {
        super.setOnProcessListener(listener);
        this.mProcessListener = listener;
    }

    public final void setThumbnailMargin(int horizontal, int vertical) {
        BrushFacade brushFacade = this.mBrushFacade;
        Intrinsics.checkNotNull(brushFacade);
        brushFacade.setThumbnailMargin(horizontal, vertical);
    }

    public final boolean updateDocumentWithoutSaving() {
        BrushFacade brushFacade = this.mBrushFacade;
        if (brushFacade == null) {
            return false;
        }
        Intrinsics.checkNotNull(brushFacade);
        if (!brushFacade.isChanged()) {
            return false;
        }
        BrushSaveExecutor brushSaveExecutor = this.mExecutor;
        if (brushSaveExecutor == null) {
            return true;
        }
        brushSaveExecutor.setPaintDocForegroundImage();
        return true;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.ISDocSaveModel
    public void saveAsync(@NotNull Boolean... params) {
        Intrinsics.checkNotNullParameter(params, "params");
        IOnProcessListener iOnProcessListener = this.mProcessListener;
        if (iOnProcessListener != null) {
            Intrinsics.checkNotNull(iOnProcessListener);
            iOnProcessListener.onStartSave();
        }
        BrushFacade brushFacade = this.mBrushFacade;
        Intrinsics.checkNotNull(brushFacade);
        if (brushFacade.isDocLoaded()) {
            saveAsync();
        } else {
            finishSave(false);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.ISDocSaveModel
    public void saveSync(@NotNull Boolean... params) {
        Intrinsics.checkNotNullParameter(params, "params");
        BrushFacade brushFacade = this.mBrushFacade;
        Intrinsics.checkNotNull(brushFacade);
        if (brushFacade.isDocLoaded()) {
            Boolean bool = params[0];
            Intrinsics.checkNotNull(bool);
            saveSync(bool.booleanValue());
        }
    }

    private final void saveSync(boolean runThread) {
        BrushSaveExecutor brushSaveExecutor;
        String str = TAG;
        Logger.m7104i(str, "saveSync, withSaveTemp: " + runThread);
        BrushFacade brushFacade = this.mBrushFacade;
        if (brushFacade == null) {
            return;
        }
        Intrinsics.checkNotNull(brushFacade);
        brushFacade.commitStroke();
        if (!isPaintingDocChanged() || (brushSaveExecutor = this.mExecutor) == null || brushSaveExecutor.isOnSaving()) {
            return;
        }
        BrushFacade brushFacade2 = this.mBrushFacade;
        Intrinsics.checkNotNull(brushFacade2);
        if (!brushFacade2.isEmpty()) {
            BrushSaveExecutor brushSaveExecutor2 = this.mExecutor;
            Intrinsics.checkNotNull(brushSaveExecutor2);
            brushSaveExecutor2.saveTaskExecutor(false, runThread);
            Logger.m7100d(str, "saveDrawingSync, save current image: done");
            return;
        }
        removeContent();
    }

    private final void saveAsync() {
        String str = TAG;
        BrushSaveExecutor brushSaveExecutor = this.mExecutor;
        Logger.m7104i(str, "saveAsync : " + (brushSaveExecutor != null ? Boolean.valueOf(brushSaveExecutor.isOnSaving()) : null));
        BrushSaveExecutor brushSaveExecutor2 = this.mExecutor;
        if (brushSaveExecutor2 != null && brushSaveExecutor2.isOnSaving()) {
            Logger.m7100d(str, "saveDrawingAsync - finish : already saving...");
            return;
        }
        BrushFacade brushFacade = this.mBrushFacade;
        Intrinsics.checkNotNull(brushFacade);
        brushFacade.commitStroke();
        BrushFacade brushFacade2 = this.mBrushFacade;
        Intrinsics.checkNotNull(brushFacade2);
        AbstractC6670b.m4764y("saveDrawingAsync >> isChanged? = ", str, brushFacade2.isChanged());
        BrushFacade brushFacade3 = this.mBrushFacade;
        Intrinsics.checkNotNull(brushFacade3);
        Logger.m7100d(str, "saveDrawingAsync >> object count = " + brushFacade3.getObjectCount());
        if (!PlatformUtil.isAvailableMemoryForNewDocument()) {
            BrushFacade brushFacade4 = this.mBrushFacade;
            Intrinsics.checkNotNull(brushFacade4);
            AbstractC6670b.m4764y("saveDrawingAsync >> Not enough storage", str, brushFacade4.isChanged());
            BrushToastHandler.showLong(C7944R.string.base_string_not_enough_space_in_device_storage_desc);
            finishSave(false);
            return;
        }
        if (!isPaintingDocChanged()) {
            Logger.m7100d(str, "saveDrawingAsync >> not changed");
            finishSave(false);
            return;
        }
        BrushFacade brushFacade5 = this.mBrushFacade;
        Intrinsics.checkNotNull(brushFacade5);
        if (brushFacade5.isEmpty()) {
            ToolsToastHandler.showLong(C7944R.string.brush_string_no_save);
            BrushFacade brushFacade6 = this.mBrushFacade;
            Intrinsics.checkNotNull(brushFacade6);
            brushFacade6.setDiscardDoc(true);
            removeContent();
            finishSave(true);
            return;
        }
        BrushFacade brushFacade7 = this.mBrushFacade;
        Intrinsics.checkNotNull(brushFacade7);
        brushFacade7.setDiscardDoc(false);
        BrushSaveExecutor brushSaveExecutor3 = this.mExecutor;
        if (brushSaveExecutor3 != null) {
            BrushSaveExecutor.saveTaskExecutor$default(brushSaveExecutor3, true, false, 2, null);
        }
    }
}
