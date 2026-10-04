package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import com.samsung.android.sdk.composer.SpenTextWritingView;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.util.ConvertSpenTextToSpannable;
import com.samsung.android.support.senl.p148nt.base.composer.drag.DragNDropConstant;
import com.samsung.android.support.senl.p148nt.base.composer.drag.DragViewMaker;
import com.samsung.android.support.senl.p148nt.base.composer.drag.DropContent;
import com.samsung.android.support.senl.p148nt.base.composer.drag.DropContentMaker;
import com.samsung.android.support.senl.p148nt.base.composer.share.BaseHandleImage;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/DragNDropControl;", "", "spenView", "Lcom/samsung/android/sdk/composer/SpenTextWritingView;", "objectManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;", "<init>", "(Lcom/samsung/android/sdk/composer/SpenTextWritingView;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;)V", "getObjectManager", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;", "handleImage", "Lcom/samsung/android/support/senl/nt/base/composer/share/BaseHandleImage;", "dropContentMaker", "Lcom/samsung/android/support/senl/nt/base/composer/drag/DropContentMaker;", "dragViewMaker", "Lcom/samsung/android/support/senl/nt/base/composer/drag/DragViewMaker;", "startDrag", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DragNDropControl {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = SmLogger.createTag("DragNDropControl");

    @NotNull
    private final DragViewMaker dragViewMaker;

    @NotNull
    private final DropContentMaker dropContentMaker;

    @NotNull
    private final BaseHandleImage handleImage;

    @NotNull
    private final SmObjectManager objectManager;

    @NotNull
    private final SpenTextWritingView spenView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/DragNDropControl$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return DragNDropControl.TAG;
        }

        private Companion() {
        }
    }

    public DragNDropControl(@NotNull SpenTextWritingView spenView, @NotNull SmObjectManager objectManager) {
        Intrinsics.checkNotNullParameter(spenView, "spenView");
        Intrinsics.checkNotNullParameter(objectManager, "objectManager");
        this.spenView = spenView;
        this.objectManager = objectManager;
        String str = TAG;
        this.handleImage = new BaseHandleImage(str, new BaseHandleImage.Contract() { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.DragNDropControl$handleImage$1
            @Override // com.samsung.android.support.senl.nt.base.composer.share.BaseHandleImage.Contract
            public void markGenerativeEditImage(SpenObjectBase spenObjectBase, String str2, String str3, String str4, Rect rect) {
                BaseHandleImage.Contract.DefaultImpls.markGenerativeEditImage(this, spenObjectBase, str2, str3, str4, rect);
            }
        });
        this.dropContentMaker = new DropContentMaker(str, new DropContentMaker.Contract() { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.DragNDropControl$dropContentMaker$1
            @Override // com.samsung.android.support.senl.nt.base.composer.drag.DropContentMaker.Contract
            public void copyObjectSpanText(SpenWNote spenWNote, SpenObjectBase spenObjectBase, DropContent dropContent) {
                DropContentMaker.Contract.DefaultImpls.copyObjectSpanText(this, spenWNote, spenObjectBase, dropContent);
            }

            @Override // com.samsung.android.support.senl.nt.base.composer.drag.DropContentMaker.Contract
            public ConvertSpenTextToSpannable.IObjectSpanConverter createObjectSpanConverter(Context context, String baseName, DropContent dropContent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(baseName, "baseName");
                Intrinsics.checkNotNullParameter(dropContent, "dropContent");
                return null;
            }

            @Override // com.samsung.android.support.senl.nt.base.composer.drag.DropContentMaker.Contract
            public Bitmap getSelectedObjectBitmap() {
                return this.this$0.getObjectManager().getSelectedObjectBitmap();
            }

            @Override // com.samsung.android.support.senl.nt.base.composer.drag.DropContentMaker.Contract
            public boolean isFocusedTextBox() {
                return this.this$0.getObjectManager().isFocusedTextBox();
            }

            @Override // com.samsung.android.support.senl.nt.base.composer.drag.DropContentMaker.Contract
            public String saveAsImage(SpenObjectBase imageObject, String pathDir, String fileName) {
                return this.this$0.handleImage.saveAsImage(imageObject, pathDir, fileName);
            }
        });
        this.dragViewMaker = new DragViewMaker(str, spenView, new DragViewMaker.Contract() { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.DragNDropControl$dragViewMaker$1
            @Override // com.samsung.android.support.senl.nt.base.composer.drag.DragViewMaker.Contract
            public float getScale() {
                return DragViewMaker.Contract.DefaultImpls.getScale(this);
            }

            @Override // com.samsung.android.support.senl.nt.base.composer.drag.DragViewMaker.Contract
            public Bitmap getSelectedObjectBitmap() {
                return this.this$0.getObjectManager().getSelectedObjectBitmap();
            }

            @Override // com.samsung.android.support.senl.nt.base.composer.drag.DragViewMaker.Contract
            public void setShadowSize(int width, int height) {
            }
        });
    }

    @NotNull
    public final SmObjectManager getObjectManager() {
        return this.objectManager;
    }

    public final boolean startDrag() {
        String str = TAG;
        SmLogger.m8661d(str, "startDrag#");
        if (!DeviceInfo.isSemDevice()) {
            return false;
        }
        Context context = this.spenView.getContext();
        PointF pastePosition = this.objectManager.getPastePosition();
        if (pastePosition == null) {
            SmLogger.m8662e(str, "startDrag# paste position is error");
            return false;
        }
        this.dropContentMaker.clear();
        DropContent dropContentCreateDropContentWithContentList = this.dropContentMaker.createDropContentWithContentList(this.objectManager.getNote(), this.objectManager.getSelectedObjectList());
        if (dropContentCreateDropContentWithContentList.contentList.isEmpty()) {
            DragNDropConstant dragNDropConstant = DragNDropConstant.INSTANCE;
            Intrinsics.checkNotNull(context);
            dragNDropConstant.showCopyFailMessage(context);
            SmLogger.m8662e(str, "startDrag# fail to create drop content");
            return false;
        }
        DropContentMaker dropContentMaker = this.dropContentMaker;
        Intrinsics.checkNotNull(context);
        SpenWNote note = this.objectManager.getNote();
        ArrayList<SpenObjectBase> contentList = dropContentCreateDropContentWithContentList.contentList;
        Intrinsics.checkNotNullExpressionValue(contentList, "contentList");
        dropContentMaker.makeBackupNote(context, note, contentList);
        DropContentMaker dropContentMaker2 = this.dropContentMaker;
        dropContentMaker2.fillDropContent(context, dropContentCreateDropContentWithContentList, dropContentMaker2.getBackupFileName(), this.dropContentMaker.getBackupPath());
        try {
            SpenWNoteFile.removeClosedCache(context, this.dropContentMaker.getBackupPath());
        } catch (IOException unused) {
            SmLogger.m8661d(TAG, "clear# - fail to remove cache");
        }
        if (dropContentCreateDropContentWithContentList.contentList.isEmpty()) {
            SmLogger.m8662e(TAG, "startDrag# fail to fill drop content");
            return false;
        }
        try {
            this.dragViewMaker.startDragAndDrop(this.spenView, this.dragViewMaker.createClipData(dropContentCreateDropContentWithContentList, this.spenView.hashCode(), 0, pastePosition), dropContentCreateDropContentWithContentList);
            return true;
        } catch (Exception e) {
            SmLogger.m8663e(TAG, "startDrag# ", e);
            return true;
        }
    }
}
