package com.samsung.android.support.senl.addons.brush.model.canvas;

import android.graphics.Rect;
import android.util.Size;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.addons.base.model.canvas.document.AbsPaintingDocModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushDocModel;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/document/AbsPaintingDocModel;", "screenModel", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/IBrushCanvasScreenModel;", "path", "", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/model/canvas/IBrushCanvasScreenModel;Ljava/lang/String;)V", "mFilePath", "mIsTobeDiscardDoc", "", "mCanvasWidth", "", "mCanvasHeight", "getWidth", "getHeight", "getDocumentFilePath", "measurePaintingDoc", "", "setDiscardDoc", "isDiscard", "isDiscardDoc", "close", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class BrushDocModel extends AbsPaintingDocModel {

    @NotNull
    private static final String TAG = Logger.createBrushTag("BrushDocModel");
    private int mCanvasHeight;
    private int mCanvasWidth;

    @Nullable
    private String mFilePath;
    private boolean mIsTobeDiscardDoc;

    public BrushDocModel(@NotNull IBrushCanvasScreenModel screenModel, @Nullable String str) {
        Intrinsics.checkNotNullParameter(screenModel, "screenModel");
        this.mFilePath = "";
        measurePaintingDoc(screenModel);
        this.mFilePath = str;
    }

    private final void measurePaintingDoc(IBrushCanvasScreenModel screenModel) {
        if (screenModel == null) {
            return;
        }
        Rect rect = new Rect();
        Size mContentScreenSize = screenModel.getMContentScreenSize();
        int statusBarHeight = screenModel.getMStatusHeight();
        rect.set(0, 0, mContentScreenSize.getWidth(), mContentScreenSize.getHeight());
        String str = TAG;
        Logger.m7100d(str, "canvasSizeWH = (" + statusBarHeight + ")");
        Logger.m7100d(str, AbstractC0622a.m1164j(rect.right, rect.bottom, "canvasSizeWH = ( ", " , ", " )"));
        if (rect.height() < rect.width()) {
            rect.set(0, 0, rect.height(), rect.width());
        }
        int iHeight = rect.height() - statusBarHeight;
        this.mCanvasHeight = iHeight;
        int i = (iHeight / 3) * 2;
        this.mCanvasWidth = i;
        if (i > mContentScreenSize.getWidth()) {
            int width = mContentScreenSize.getWidth();
            this.mCanvasWidth = width;
            this.mCanvasHeight = (width / 2) * 3;
        } else if (this.mCanvasWidth > mContentScreenSize.getHeight()) {
            int height = mContentScreenSize.getHeight();
            this.mCanvasWidth = height;
            this.mCanvasHeight = (height / 2) * 3;
        }
        Logger.m7100d(str, AbstractC0622a.m1164j(this.mCanvasWidth, this.mCanvasHeight, "final canvasSizeWH = (", SQLKeyword.COMMA, ")"));
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.document.AbsPaintingDocModel
    public void close() {
        if (this.mIsTobeDiscardDoc) {
            discard();
        } else {
            super.close();
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.document.AbsPaintingDocModel, com.samsung.android.support.senl.addons.base.model.canvas.document.IDocModel
    @Nullable
    /* JADX INFO: renamed from: getDocumentFilePath, reason: from getter */
    public String getMFilePath() {
        return this.mFilePath;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.document.AbsPaintingDocModel, com.samsung.android.support.senl.addons.base.model.canvas.document.IDocModel
    public int getHeight() {
        int height = super.getHeight();
        return height == 0 ? this.mCanvasHeight : height;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.document.AbsPaintingDocModel, com.samsung.android.support.senl.addons.base.model.canvas.document.IDocModel
    public int getWidth() {
        int width = super.getWidth();
        return width == 0 ? this.mCanvasWidth : width;
    }

    /* JADX INFO: renamed from: isDiscardDoc, reason: from getter */
    public boolean getMIsTobeDiscardDoc() {
        return this.mIsTobeDiscardDoc;
    }

    public void setDiscardDoc(boolean isDiscard) {
        this.mIsTobeDiscardDoc = isDiscard;
    }
}
