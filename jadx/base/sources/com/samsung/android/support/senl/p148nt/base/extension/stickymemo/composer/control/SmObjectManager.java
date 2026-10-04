package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.samsung.android.sdk.composer.document.SpenWNoteHelper;
import com.samsung.android.sdk.composer.input.SpenNoteObjectInserter;
import com.samsung.android.sdk.pen.control.ISpenControlObjectManager;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.text.SmTextManager;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ;2\u00020\u0001:\u0001;B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u001e\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u001bj\b\u0012\u0004\u0012\u00020\u0019`\u001cJ\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u001bj\b\u0012\u0004\u0012\u00020\u0019`\u001cJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001fJ\u0016\u0010 \u001a\u00020\u001f2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\"J\u0006\u0010#\u001a\u00020\u0017J\u0006\u0010$\u001a\u00020\u0017J\u0006\u0010%\u001a\u00020\u001fJ\u000e\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u001fJ\u001e\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001fJ\u0006\u0010.\u001a\u00020/J\u0016\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000203J\b\u00105\u001a\u0004\u0018\u000106J\b\u00107\u001a\u0004\u0018\u00010,J&\u00108\u001a\u00020\u00172\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u001bj\b\u0012\u0004\u0012\u00020\u0019`\u001c2\u0006\u00109\u001a\u00020\u001fJ\u0006\u0010:\u001a\u00020\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;", "", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "textManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;", "spenNoteObjectInserter", "Lcom/samsung/android/sdk/composer/input/SpenNoteObjectInserter;", "spenControlObjectManager", "Lcom/samsung/android/sdk/pen/control/ISpenControlObjectManager;", "<init>", "(Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;Lcom/samsung/android/sdk/composer/input/SpenNoteObjectInserter;Lcom/samsung/android/sdk/pen/control/ISpenControlObjectManager;)V", "getNote", "()Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "getTextManager", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;", "getSpenNoteObjectInserter", "()Lcom/samsung/android/sdk/composer/input/SpenNoteObjectInserter;", "getSpenControlObjectManager", "()Lcom/samsung/android/sdk/pen/control/ISpenControlObjectManager;", "spenWNoteHelper", "Lcom/samsung/android/sdk/composer/document/SpenWNoteHelper;", "selectObject", "", "obj", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "objList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSelectedObjectList", "isSelectedObject", "", "isSelectedTextBox", "objectList", "", "clearSelectObject", "clearSelection", "isFocusedTextBox", "setFocus", "focus", "insertText", "objectTextBox", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "position", "Landroid/graphics/PointF;", "toNext", "makeNewTextBox", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "getPageIndexByXY", "", "x", "", "y", "getSelectedObjectBitmap", "Landroid/graphics/Bitmap;", "getPastePosition", "deleteObjectList", "commitHistory", "removeAllStroke", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmObjectManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = SmLogger.createTag("ContentObjectManager");

    @NotNull
    private final SpenWNote note;

    @NotNull
    private final ISpenControlObjectManager spenControlObjectManager;

    @NotNull
    private final SpenNoteObjectInserter spenNoteObjectInserter;

    @NotNull
    private final SpenWNoteHelper spenWNoteHelper;

    @NotNull
    private final SmTextManager textManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return SmObjectManager.TAG;
        }

        private Companion() {
        }
    }

    public SmObjectManager(@NotNull SpenWNote note, @NotNull SmTextManager textManager, @NotNull SpenNoteObjectInserter spenNoteObjectInserter, @NotNull ISpenControlObjectManager spenControlObjectManager) {
        Intrinsics.checkNotNullParameter(note, "note");
        Intrinsics.checkNotNullParameter(textManager, "textManager");
        Intrinsics.checkNotNullParameter(spenNoteObjectInserter, "spenNoteObjectInserter");
        Intrinsics.checkNotNullParameter(spenControlObjectManager, "spenControlObjectManager");
        this.note = note;
        this.textManager = textManager;
        this.spenNoteObjectInserter = spenNoteObjectInserter;
        this.spenControlObjectManager = spenControlObjectManager;
        SpenWNoteHelper spenWNoteHelper = new SpenWNoteHelper(true);
        this.spenWNoteHelper = spenWNoteHelper;
        spenWNoteHelper.setDocument(note);
    }

    public final void clearSelectObject() {
        if (this.note.isClosed()) {
            return;
        }
        this.note.selectObject((SpenObjectBase) null);
    }

    public final void clearSelection() {
        if (isFocusedTextBox()) {
            this.textManager.clearSelection();
        } else {
            clearSelectObject();
        }
    }

    public final void deleteObjectList(@NotNull ArrayList<SpenObjectBase> objList, boolean commitHistory) {
        Intrinsics.checkNotNullParameter(objList, "objList");
        this.note.getPage(0).removeObjectList(objList);
        if (commitHistory) {
            this.note.commitHistory();
        }
    }

    @NotNull
    public final SpenWNote getNote() {
        return this.note;
    }

    public final int getPageIndexByXY(float x, float y2) {
        return this.spenWNoteHelper.getPageIndexByXY(x, y2);
    }

    @Nullable
    public final PointF getPastePosition() {
        PointF pastePosition = this.spenControlObjectManager.getPastePosition();
        if (pastePosition == null || pastePosition.x <= 0.0f || pastePosition.y <= 0.0f) {
            return null;
        }
        return pastePosition;
    }

    @Nullable
    public final Bitmap getSelectedObjectBitmap() {
        return ImageUtils.createBitmap(this.spenControlObjectManager.getSelectedData(), -1);
    }

    @NotNull
    public final ArrayList<SpenObjectBase> getSelectedObjectList() {
        return this.note.getSelectedObject();
    }

    @NotNull
    public final ISpenControlObjectManager getSpenControlObjectManager() {
        return this.spenControlObjectManager;
    }

    @NotNull
    public final SpenNoteObjectInserter getSpenNoteObjectInserter() {
        return this.spenNoteObjectInserter;
    }

    @NotNull
    public final SmTextManager getTextManager() {
        return this.textManager;
    }

    public final boolean insertText(@NotNull SpenObjectShape objectTextBox, @NotNull PointF position, boolean toNext) {
        Intrinsics.checkNotNullParameter(objectTextBox, "objectTextBox");
        Intrinsics.checkNotNullParameter(position, "position");
        SmLogger.m8666i(TAG, "insertBodyText# position:" + position);
        return this.spenNoteObjectInserter.insertBodyText(objectTextBox, this.note.getPage(0), position.y, toNext, toNext);
    }

    public final boolean isFocusedTextBox() {
        return isSelectedTextBox();
    }

    public final boolean isSelectedObject() {
        return !getSelectedObjectList().isEmpty();
    }

    public final boolean isSelectedTextBox() {
        return isSelectedTextBox(getSelectedObjectList());
    }

    @NotNull
    public final SpenObjectTextBox makeNewTextBox() {
        SpenObjectTextBox spenObjectTextBox = new SpenObjectTextBox("");
        this.textManager.setDefaultState(spenObjectTextBox);
        return spenObjectTextBox;
    }

    public final void removeAllStroke() {
        this.note.getPage(0).removeObjects(1);
    }

    public final void selectObject(@Nullable SpenObjectBase obj) {
        this.note.selectObject(obj);
    }

    public final void setFocus(boolean focus) {
        this.spenControlObjectManager.setFocus(focus);
    }

    public final boolean isSelectedTextBox(@Nullable List<? extends SpenObjectBase> objectList) {
        return objectList != null && objectList.size() == 1 && 2 == objectList.get(0).getType();
    }

    public final void selectObject(@NotNull ArrayList<SpenObjectBase> objList) {
        Intrinsics.checkNotNullParameter(objList, "objList");
        this.note.selectObject(objList);
    }
}
