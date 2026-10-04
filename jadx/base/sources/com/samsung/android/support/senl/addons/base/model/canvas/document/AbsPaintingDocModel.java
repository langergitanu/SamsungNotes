package com.samsung.android.support.senl.addons.base.model.canvas.document;

import android.graphics.RectF;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.document.SpenHistoryUpdateInfo;
import com.samsung.android.sdk.pen.document.SpenPaintingDoc;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0012\b&\u0018\u0000 /2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002./B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\bJ\b\u0010\u0012\u001a\u00020\nH\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\nH\u0016J\u0017\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010\u001fJ\u0017\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010\u001fJ\u0017\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010\u001fJ\u0017\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010\u001fJ\u0017\u0010#\u001a\u0004\u0018\u00010\u001a2\u0006\u0010$\u001a\u00020\u0014H\u0016¢\u0006\u0002\u0010%J\n\u0010)\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010*\u001a\u00020\nH\u0016J\b\u0010+\u001a\u00020\nH\u0016J\b\u0010,\u001a\u00020\nH\u0002J\b\u0010-\u001a\u00020\nH\u0016J\b\u0010#\u001a\u00020\u001aH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010&\u001a\u0004\u0018\u00010\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u00060"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/document/AbsPaintingDocModel;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/document/IDocModel;", "Lcom/samsung/android/sdk/pen/document/SpenHistoryUpdateInfo;", "<init>", "()V", "mPaintingDoc", "Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc;", "mListener", "Lcom/samsung/android/support/senl/addons/base/model/canvas/document/AbsPaintingDocModel$IDocModelListener;", "setDocument", "", "paintingDoc", "drawnRectOfAllObject", "Landroid/graphics/RectF;", "getDrawnRectOfAllObject", "()Landroid/graphics/RectF;", "setDocModelListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setDocListener", "isValidDoc", "", "getDocumentFilePath", "", "isUndoable", "isRedoable", "getWidth", "", "getHeight", "clearAll", "undo", "", "()[Lcom/samsung/android/sdk/pen/document/SpenHistoryUpdateInfo;", "redo", "undoAll", "redoAll", "getObjectCount", "b", "(Z)Ljava/lang/Integer;", "foregroundImagePath", "getForegroundImagePath", "()Ljava/lang/String;", "getPaintingDoc", "close", ClientCookie.DISCARD_ATTR, "releaseListeners", "release", "IDocModelListener", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsPaintingDocModel implements IDocModel<SpenHistoryUpdateInfo> {

    @NotNull
    private static final String TAG = Logger.createTag("AbsPaintingDocModel");

    @Nullable
    private IDocModelListener mListener;

    @Nullable
    private SpenPaintingDoc mPaintingDoc;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/document/AbsPaintingDocModel$IDocModelListener;", "Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc$ObjectListener;", "Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc$HistoryListener;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IDocModelListener extends SpenPaintingDoc.ObjectListener, SpenPaintingDoc.HistoryListener {
    }

    private final void releaseListeners() {
        SpenPaintingDoc spenPaintingDoc = this.mPaintingDoc;
        if (spenPaintingDoc != null) {
            spenPaintingDoc.deregisterObjectListener(this.mListener);
        }
        SpenPaintingDoc spenPaintingDoc2 = this.mPaintingDoc;
        if (spenPaintingDoc2 != null) {
            spenPaintingDoc2.deregisterHistoryListener(this.mListener);
        }
    }

    private final void setDocListener() {
        SpenPaintingDoc spenPaintingDoc = this.mPaintingDoc;
        if (spenPaintingDoc == null || this.mListener == null) {
            return;
        }
        Intrinsics.checkNotNull(spenPaintingDoc);
        spenPaintingDoc.registerObjectListener(this.mListener);
        SpenPaintingDoc spenPaintingDoc2 = this.mPaintingDoc;
        Intrinsics.checkNotNull(spenPaintingDoc2);
        spenPaintingDoc2.registerHistoryListener(this.mListener);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.document.IDocModel
    public void clearAll() {
        SpenPaintingDoc spenPaintingDoc = this.mPaintingDoc;
        if (spenPaintingDoc != null) {
            spenPaintingDoc.removeAllObject();
        }
    }

    public void close() {
        if (this.mPaintingDoc != null) {
            releaseListeners();
            try {
                try {
                    Logger.m7100d(TAG, "closePaintingDoc - close : " + this.mPaintingDoc);
                    SpenPaintingDoc spenPaintingDoc = this.mPaintingDoc;
                    Intrinsics.checkNotNull(spenPaintingDoc);
                    spenPaintingDoc.close(true);
                } catch (IOException e) {
                    Logger.m7101e(TAG, "error @ closePaintingDoc : " + e.getMessage());
                }
            } finally {
                this.mPaintingDoc = null;
            }
        }
        this.mListener = null;
    }

    public void discard() {
        SpenPaintingDoc spenPaintingDoc = this.mPaintingDoc;
        if (spenPaintingDoc != null) {
            try {
                Logger.m7100d(TAG, "discard Painting Doc " + spenPaintingDoc);
                releaseListeners();
                SpenPaintingDoc spenPaintingDoc2 = this.mPaintingDoc;
                Intrinsics.checkNotNull(spenPaintingDoc2);
                spenPaintingDoc2.discard();
            } catch (IOException e) {
                Logger.m7101e(TAG, "error @ discarding Painting Doc : " + e.getMessage());
            } finally {
                this.mPaintingDoc = null;
            }
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.document.IDocModel
    @Nullable
    /* JADX INFO: renamed from: getDocumentFilePath */
    public String getMFilePath() {
        return null;
    }

    @Nullable
    public RectF getDrawnRectOfAllObject() {
        SpenPaintingDoc spenPaintingDoc = this.mPaintingDoc;
        if (spenPaintingDoc != null) {
            return spenPaintingDoc.getDrawnRectOfAllObject();
        }
        return null;
    }

    @Nullable
    public String getForegroundImagePath() {
        SpenPaintingDoc spenPaintingDoc = this.mPaintingDoc;
        if (spenPaintingDoc != null) {
            return spenPaintingDoc.getForegroundImagePath();
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.document.IDocModel
    public int getHeight() {
        SpenPaintingDoc spenPaintingDoc = this.mPaintingDoc;
        if (spenPaintingDoc != null) {
            return spenPaintingDoc.getHeight();
        }
        return 0;
    }

    @Nullable
    public Integer getObjectCount(boolean b) {
        SpenPaintingDoc spenPaintingDoc = this.mPaintingDoc;
        if (spenPaintingDoc != null) {
            return Integer.valueOf(spenPaintingDoc.getObjectCount(b));
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: getPaintingDoc, reason: from getter */
    public SpenPaintingDoc getMPaintingDoc() {
        return this.mPaintingDoc;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.document.IDocModel
    public int getWidth() {
        SpenPaintingDoc spenPaintingDoc = this.mPaintingDoc;
        if (spenPaintingDoc != null) {
            return spenPaintingDoc.getWidth();
        }
        return 0;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.document.IDocModel
    public boolean isRedoable() {
        SpenPaintingDoc spenPaintingDoc = this.mPaintingDoc;
        Intrinsics.checkNotNull(spenPaintingDoc);
        boolean zIsRedoable = spenPaintingDoc.isRedoable();
        Logger.m7104i(TAG, "can redo? " + zIsRedoable);
        SpenPaintingDoc spenPaintingDoc2 = this.mPaintingDoc;
        Intrinsics.checkNotNull(spenPaintingDoc2);
        return spenPaintingDoc2.isRedoable();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.document.IDocModel
    public boolean isUndoable() {
        SpenPaintingDoc spenPaintingDoc = this.mPaintingDoc;
        Intrinsics.checkNotNull(spenPaintingDoc);
        boolean zIsUndoable = spenPaintingDoc.isUndoable();
        Logger.m7104i(TAG, "can undo? " + zIsUndoable);
        return zIsUndoable;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.document.IDocModel
    public boolean isValidDoc() {
        return this.mPaintingDoc != null;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.document.IDocModel
    public void release() {
        releaseListeners();
    }

    public final void setDocModelListener(@Nullable IDocModelListener listener) {
        this.mListener = listener;
        setDocListener();
    }

    public final void setDocument(@Nullable SpenPaintingDoc paintingDoc) {
        if (paintingDoc == null) {
            return;
        }
        this.mPaintingDoc = paintingDoc;
        Intrinsics.checkNotNull(paintingDoc);
        paintingDoc.clearHistory();
        SpenPaintingDoc spenPaintingDoc = this.mPaintingDoc;
        Intrinsics.checkNotNull(spenPaintingDoc);
        spenPaintingDoc.setUndoLimit(50);
        String str = TAG;
        SpenPaintingDoc spenPaintingDoc2 = this.mPaintingDoc;
        Intrinsics.checkNotNull(spenPaintingDoc2);
        int width = spenPaintingDoc2.getWidth();
        SpenPaintingDoc spenPaintingDoc3 = this.mPaintingDoc;
        Intrinsics.checkNotNull(spenPaintingDoc3);
        Logger.m7100d(str, "set document(PaintingDoc) : size " + width + " x " + spenPaintingDoc3.getHeight());
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.document.IDocModel
    public int getObjectCount() {
        SpenPaintingDoc spenPaintingDoc = this.mPaintingDoc;
        if (spenPaintingDoc == null) {
            return 0;
        }
        Intrinsics.checkNotNull(spenPaintingDoc);
        return spenPaintingDoc.getObjectCount(true);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.samsung.android.support.senl.addons.base.model.canvas.document.IDocModel
    @Nullable
    public SpenHistoryUpdateInfo[] redo() {
        SpenPaintingDoc spenPaintingDoc = this.mPaintingDoc;
        if (spenPaintingDoc != null) {
            return spenPaintingDoc.redo();
        }
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.samsung.android.support.senl.addons.base.model.canvas.document.IDocModel
    @Nullable
    public SpenHistoryUpdateInfo[] redoAll() {
        SpenPaintingDoc spenPaintingDoc = this.mPaintingDoc;
        if (spenPaintingDoc != null) {
            return spenPaintingDoc.redoAll();
        }
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.samsung.android.support.senl.addons.base.model.canvas.document.IDocModel
    @Nullable
    public SpenHistoryUpdateInfo[] undo() {
        SpenPaintingDoc spenPaintingDoc = this.mPaintingDoc;
        if (spenPaintingDoc != null) {
            return spenPaintingDoc.undo();
        }
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.samsung.android.support.senl.addons.base.model.canvas.document.IDocModel
    @Nullable
    public SpenHistoryUpdateInfo[] undoAll() {
        SpenPaintingDoc spenPaintingDoc = this.mPaintingDoc;
        if (spenPaintingDoc != null) {
            return spenPaintingDoc.undoAll();
        }
        return null;
    }
}
