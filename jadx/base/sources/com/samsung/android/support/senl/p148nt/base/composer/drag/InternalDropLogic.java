package com.samsung.android.support.senl.p148nt.base.composer.drag;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.base.composer.content.ObjectTypeHelper;
import com.samsung.android.support.senl.p148nt.base.composer.drag.DropContent;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.TextUtil;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001EB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0017\u001a\u00020)2\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u00140+j\b\u0012\u0004\u0012\u00020\u0014`,J\u0006\u0010-\u001a\u00020#J \u0010.\u001a\u00020)2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0014H\u0002J\u0018\u00102\u001a\u00020#2\u0006\u00103\u001a\u00020\u001f2\u0006\u0010/\u001a\u000200H\u0002J\u0018\u00104\u001a\u00020#2\u0006\u00103\u001a\u00020\u001f2\u0006\u0010/\u001a\u000200H\u0002J\u0018\u00105\u001a\u00020#2\u0006\u00101\u001a\u00020\u00142\u0006\u0010/\u001a\u000200H\u0002J\u0018\u00106\u001a\u00020#2\u0006\u00101\u001a\u00020\u00142\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00107\u001a\u00020#2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00108\u001a\u00020#2\u0006\u00101\u001a\u00020\u0014H\u0002J\b\u00109\u001a\u00020#H\u0002J\u0018\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020\u0014H\u0002J\u0010\u0010=\u001a\u00020)2\u0006\u0010/\u001a\u000200H\u0002J\u000e\u0010>\u001a\u00020\u00142\u0006\u0010?\u001a\u00020@J\u0006\u0010A\u001a\u00020#J\u0012\u0010B\u001a\u0004\u0018\u00010\u00142\u0006\u0010?\u001a\u00020@H\u0002J\u0012\u0010C\u001a\u0004\u0018\u00010\u00142\u0006\u0010?\u001a\u00020@H\u0002J\u0006\u0010D\u001a\u00020)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R.\u0010\u001d\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f0\u001e\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/drag/InternalDropLogic;", "", "tag", "", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "dragInfo", "Lcom/samsung/android/support/senl/nt/base/composer/drag/DragInfo;", "injectedFunction", "Lcom/samsung/android/support/senl/nt/base/composer/drag/InternalDropLogic$InjectedFunction;", "pageRatio", "", "<init>", "(Ljava/lang/String;Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;Lcom/samsung/android/support/senl/nt/base/composer/drag/DragInfo;Lcom/samsung/android/support/senl/nt/base/composer/drag/InternalDropLogic$InjectedFunction;F)V", "getTag", "()Ljava/lang/String;", "getNote", "()Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "backupObjList", "", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "getBackupObjList", "()Ljava/util/List;", "setBackupObjList", "(Ljava/util/List;)V", "backupPageList", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "getBackupPageList", "setBackupPageList", "selectedCellPositionsOfTable", "Lkotlin/Pair;", "", "getSelectedCellPositionsOfTable", "setSelectedCellPositionsOfTable", "beginHistory", "", "getBeginHistory", "()Z", "setBeginHistory", "(Z)V", "dropAreaGapVertical", "", "backupObjectList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "internalDnD", "removeInternalContent", "startCursor", "", "startObject", "isTextSelected", "type", "isTableSelected", "isInSelection", "isInSelectionTextType", "isInSelectionObjectSpanType", "isInSelectionObjectType", "isSamePositionRegion", "removeObjectFromBackupPageList", "listIndex", "targetObj", "getCursorAfterRemove", "getPositionObject", "position", "Landroid/graphics/PointF;", "isDropContentObjectSpan", "findObjectPosition", "findObjectSpanPosition", "clear", "InjectedFunction", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nInternalDropLogic.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InternalDropLogic.kt\ncom/samsung/android/support/senl/nt/base/composer/drag/InternalDropLogic\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,303:1\n1869#2,2:304\n*S KotlinDebug\n*F\n+ 1 InternalDropLogic.kt\ncom/samsung/android/support/senl/nt/base/composer/drag/InternalDropLogic\n*L\n32#1:304,2\n*E\n"})
public final class InternalDropLogic {

    @Nullable
    private List<SpenObjectBase> backupObjList;

    @Nullable
    private List<SpenWPage> backupPageList;
    private boolean beginHistory;

    @NotNull
    private final DragInfo dragInfo;
    private final float dropAreaGapVertical;

    @NotNull
    private final InjectedFunction injectedFunction;

    @NotNull
    private final SpenWNote note;

    @Nullable
    private List<Pair<Integer, Integer>> selectedCellPositionsOfTable;

    @NotNull
    private final String tag;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0007H&J\b\u0010\u0010\u001a\u00020\u0005H\u0016¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/drag/InternalDropLogic$InjectedFunction;", "", "<init>", "()V", "isCursorDragMode", "", "getCursorIndex", "", "objectShape", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "position", "Landroid/graphics/PointF;", "setTargetTextBoxFocus", "", "targetObject", "targetObjectCursor", "isObjectSpanOptionEnabled", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static abstract class InjectedFunction {
        public abstract int getCursorIndex(@NotNull SpenObjectShape objectShape, @NotNull PointF position);

        public abstract boolean isCursorDragMode();

        public boolean isObjectSpanOptionEnabled() {
            return false;
        }

        public abstract void setTargetTextBoxFocus(@NotNull SpenObjectShape targetObject, int targetObjectCursor);
    }

    public InternalDropLogic(@NotNull String tag, @NotNull SpenWNote note, @NotNull DragInfo dragInfo, @NotNull InjectedFunction injectedFunction, float f) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(note, "note");
        Intrinsics.checkNotNullParameter(dragInfo, "dragInfo");
        Intrinsics.checkNotNullParameter(injectedFunction, "injectedFunction");
        this.tag = tag;
        this.note = note;
        this.dragInfo = dragInfo;
        this.injectedFunction = injectedFunction;
        this.dropAreaGapVertical = 50 * f;
    }

    private final SpenObjectBase findObjectPosition(PointF position) {
        for (SpenWPage spenWPage : this.note.getPageList()) {
            ArrayList<SpenObjectBase> objectList = spenWPage.getObjectList();
            if (objectList != null && !objectList.isEmpty()) {
                Point offset = spenWPage.getOffset();
                for (int size = objectList.size() - 1; size >= 0; size--) {
                    SpenObjectBase spenObjectBase = objectList.get(size);
                    Intrinsics.checkNotNullExpressionValue(spenObjectBase, "get(...)");
                    SpenObjectBase spenObjectBase2 = spenObjectBase;
                    RectF rect = spenObjectBase2.getRect();
                    rect.offset(offset.x, offset.y);
                    if (rect.contains(position.x, position.y)) {
                        Logger.m8697d(this.tag, "getPositionObject# findObject:" + spenObjectBase2);
                        return spenObjectBase2;
                    }
                }
            }
        }
        return null;
    }

    private final SpenObjectBase findObjectSpanPosition(PointF position) {
        int cursorIndex = this.injectedFunction.getCursorIndex(this.note.getBodyText(), position);
        ArrayList<SpenObjectSpan> arrayListFindObjectSpan = this.note.getBodyText().findObjectSpan(cursorIndex, cursorIndex);
        if (arrayListFindObjectSpan == null || arrayListFindObjectSpan.isEmpty()) {
            return null;
        }
        Logger.m8697d(this.tag, "getPositionObject# findObjectSpan:" + arrayListFindObjectSpan.get(0).getObject());
        return arrayListFindObjectSpan.get(0).getObject();
    }

    private final void getCursorAfterRemove(int[] startCursor) {
        int targetObjectCursor;
        Logger.m8697d(DragNDropConstant.TAG, "getCursorAfterRemove before :" + this.dragInfo + ".targetObjectCursor");
        if (this.dragInfo.getTargetObjectCursor() > startCursor[0]) {
            DragInfo dragInfo = this.dragInfo;
            if (dragInfo.getTargetObjectCursor() <= startCursor[1]) {
                targetObjectCursor = startCursor[0];
            } else {
                targetObjectCursor = (this.dragInfo.getTargetObjectCursor() + startCursor[0]) - startCursor[1];
            }
            dragInfo.setTargetObjectCursor(targetObjectCursor);
        }
        Logger.m8697d(DragNDropConstant.TAG, "getCursorAfterRemove after : " + this.dragInfo + ".targetObjectCursor");
    }

    private final boolean isInSelection(SpenObjectBase startObject, int[] startCursor) {
        String str = this.tag;
        DragInfo dragInfo = this.dragInfo;
        Logger.m8702i(str, "isInSelection# mDropContentType:" + dragInfo + ".dropContentType, object:" + startObject + SQLKeyword.COMMA + dragInfo + ".targetObject");
        int dropContentType = this.dragInfo.getDropContentType();
        return dropContentType != 2 ? dropContentType != 3 ? isInSelectionObjectType(startObject) : isInSelectionObjectSpanType(startCursor) : isInSelectionTextType(startObject, startCursor);
    }

    private final boolean isInSelectionObjectSpanType(int[] startCursor) {
        int i;
        int[] cursor = TextUtil.getCursor(this.note.getBodyText());
        Intrinsics.checkNotNullExpressionValue(cursor, "getCursor(...)");
        String str = this.tag;
        int i2 = startCursor[0];
        int i4 = startCursor[1];
        int i5 = cursor[0];
        int i6 = cursor[1];
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i2, i4, "isInSelectionObjectSpanType# startCursor:", ",", "currentCursor:");
        sbM1173s.append(i5);
        sbM1173s.append(SQLKeyword.COMMA);
        sbM1173s.append(i6);
        Logger.m8702i(str, sbM1173s.toString());
        if (!this.injectedFunction.isCursorDragMode()) {
            return isSamePositionRegion();
        }
        int i7 = cursor[0];
        int i8 = startCursor[0];
        return (i7 >= i8 && i7 <= startCursor[1]) || ((i = cursor[1]) >= i8 && i <= startCursor[1]);
    }

    private final boolean isInSelectionObjectType(SpenObjectBase startObject) {
        if (Intrinsics.areEqual(startObject, this.dragInfo.getTargetObject())) {
            return true;
        }
        return isSamePositionRegion();
    }

    private final boolean isInSelectionTextType(SpenObjectBase startObject, int[] startCursor) {
        int i;
        int i2;
        if (!Intrinsics.areEqual(startObject, this.dragInfo.getTargetObject()) || !(this.dragInfo.getTargetObject() instanceof SpenObjectShape)) {
            return false;
        }
        int[] cursor = TextUtil.getCursor((SpenObjectShape) this.dragInfo.getTargetObject());
        Intrinsics.checkNotNullExpressionValue(cursor, "getCursor(...)");
        int i4 = startCursor[0];
        int i5 = startCursor[1];
        return i4 < i5 && (((i = cursor[0]) >= i4 && i < i5) || ((i2 = cursor[1]) >= i4 && i2 < i5));
    }

    private final boolean isSamePositionRegion() {
        PointF startPosition = this.dragInfo.getStartPosition();
        return startPosition != null && Math.abs((double) (startPosition.x - this.dragInfo.getDragPosition().x)) < 50.0d && Math.abs((double) (startPosition.y - this.dragInfo.getDragPosition().y)) < ((double) this.dropAreaGapVertical);
    }

    private final boolean isTableSelected(int type, int[] startCursor) {
        return ObjectTypeHelper.INSTANCE.isTableType(type) && startCursor[0] != startCursor[1];
    }

    private final boolean isTextSelected(int type, int[] startCursor) {
        return ObjectTypeHelper.INSTANCE.isTextType(type) && startCursor[0] != startCursor[1];
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002a A[Catch: Exception -> 0x001f, TryCatch #0 {Exception -> 0x001f, blocks: (B:3:0x0007, B:5:0x0014, B:12:0x002a, B:13:0x002d, B:15:0x0034, B:16:0x0039, B:18:0x003d, B:20:0x0048, B:23:0x005b, B:25:0x0060, B:27:0x0068, B:29:0x006c, B:32:0x0073, B:33:0x008b, B:35:0x00a3, B:37:0x00a9, B:38:0x00ad, B:40:0x00b7, B:42:0x00d5, B:44:0x00db, B:45:0x00df, B:47:0x00e7, B:48:0x00f4, B:10:0x0022), top: B:53:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void removeInternalContent(SpenWNote note, int[] startCursor, SpenObjectBase startObject) {
        Pair pair;
        Logger.m8702i(this.tag, "removeInternalContent");
        try {
            if (!Intrinsics.areEqual(startObject, this.dragInfo.getTargetObject()) || !isTextSelected(startObject.getType(), startCursor)) {
                if (this.dragInfo.getDropContentType() == 3) {
                    getCursorAfterRemove(startCursor);
                }
            }
            if (!note.isGroupingHistory()) {
                this.beginHistory = true;
                note.beginHistoryGroup();
            }
            List<SpenObjectBase> list = this.backupObjList;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    SpenObjectBase spenObjectBase = list.get(i);
                    if (isTableSelected(spenObjectBase.getType(), startCursor)) {
                        List<Pair<Integer, Integer>> list2 = this.selectedCellPositionsOfTable;
                        SpenObjectTextBox contentObject = null;
                        if (list2 != null && (pair = (Pair) CollectionsKt.firstOrNull((List) list2)) != null) {
                            SpenObjectTable spenObjectTable = spenObjectBase instanceof SpenObjectTable ? (SpenObjectTable) spenObjectBase : null;
                            if (spenObjectTable != null) {
                                contentObject = spenObjectTable.getContentObject(((Number) pair.getFirst()).intValue(), ((Number) pair.getSecond()).intValue());
                            }
                        }
                        Intrinsics.checkNotNull(contentObject, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectShape");
                        int i2 = startCursor[0];
                        contentObject.removeText(i2, startCursor[1] - i2);
                        String text = contentObject.getText();
                        Intrinsics.checkNotNull(text);
                        if (text.length() == 0 && spenObjectBase.getType() == 2) {
                            removeObjectFromBackupPageList(i, spenObjectBase);
                        }
                    } else if (isTextSelected(spenObjectBase.getType(), startCursor)) {
                        Intrinsics.checkNotNull(spenObjectBase, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectShape");
                        int i4 = startCursor[0];
                        ((SpenObjectShape) spenObjectBase).removeText(i4, startCursor[1] - i4);
                        String text2 = ((SpenObjectShape) spenObjectBase).getText();
                        Intrinsics.checkNotNull(text2);
                        if (text2.length() == 0 && spenObjectBase.getType() == 2) {
                            removeObjectFromBackupPageList(i, spenObjectBase);
                        }
                    } else if (this.dragInfo.getDropContentType() == 3) {
                        SpenObjectTextBox bodyText = note.getBodyText();
                        int i5 = startCursor[0];
                        bodyText.removeText(i5, startCursor[1] - i5);
                    } else {
                        removeObjectFromBackupPageList(i, spenObjectBase);
                    }
                }
            }
        } catch (Exception e) {
            Logger.m8699e(this.tag, "removeInternalContent# removeContents " + e.getMessage(), e);
        }
    }

    private final void removeObjectFromBackupPageList(int listIndex, SpenObjectBase targetObj) {
        List<SpenWPage> list = this.backupPageList;
        if (list != null) {
            list.get(listIndex).removeObject(targetObj);
        }
    }

    public final void clear() {
        List<SpenObjectBase> list = this.backupObjList;
        if (list != null) {
            list.clear();
        }
        this.backupObjList = null;
        List<SpenWPage> list2 = this.backupPageList;
        if (list2 != null) {
            list2.clear();
        }
        this.backupPageList = null;
    }

    @Nullable
    public final List<SpenObjectBase> getBackupObjList() {
        return this.backupObjList;
    }

    @Nullable
    public final List<SpenWPage> getBackupPageList() {
        return this.backupPageList;
    }

    public final boolean getBeginHistory() {
        return this.beginHistory;
    }

    @NotNull
    public final SpenWNote getNote() {
        return this.note;
    }

    @NotNull
    public final SpenObjectBase getPositionObject(@NotNull PointF position) {
        SpenObjectBase spenObjectBaseFindObjectPosition;
        Intrinsics.checkNotNullParameter(position, "position");
        SpenObjectBase spenObjectBaseFindObjectSpanPosition = (isDropContentObjectSpan() || (spenObjectBaseFindObjectPosition = findObjectPosition(position)) == null) ? findObjectSpanPosition(position) : spenObjectBaseFindObjectPosition;
        if (spenObjectBaseFindObjectSpanPosition != null) {
            return spenObjectBaseFindObjectSpanPosition;
        }
        Logger.m8697d(this.tag, "getPositionObject# return Default Object");
        return this.note.getBodyText();
    }

    @Nullable
    public final List<Pair<Integer, Integer>> getSelectedCellPositionsOfTable() {
        return this.selectedCellPositionsOfTable;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    public final boolean internalDnD() {
        if (this.dragInfo.getLabelInfo() == null) {
            Logger.m8702i(this.tag, "internalDnD# mLabelInfo is null");
            return false;
        }
        if (this.dragInfo.getTargetObject() == null) {
            Logger.m8702i(this.tag, "internalDnD# mTargetObject is null");
            return false;
        }
        String[] labelInfo = this.dragInfo.getLabelInfo();
        Intrinsics.checkNotNull(labelInfo);
        DropContent.StartPosition startPosition = new DropContent.StartPosition(labelInfo[3]);
        PointF pointF = new PointF(startPosition.getStartX(), startPosition.getStartY());
        int[] iArr = {startPosition.getSelectionStart(), startPosition.getSelectionEnd()};
        Logger.m8702i(this.tag, "internalDnD# startPosF : " + pointF + ", cursor:" + iArr[0] + SQLKeyword.COMMA + iArr[1]);
        SpenObjectBase positionObject = getPositionObject(pointF);
        if (isInSelection(positionObject, iArr)) {
            Logger.m8702i(this.tag, "internalDnD# item is dropped in same position");
            return false;
        }
        List<SpenObjectBase> list = this.backupObjList;
        if (list != null && !list.isEmpty()) {
            removeInternalContent(this.note, iArr, positionObject);
            if (this.injectedFunction.isCursorDragMode()) {
                ObjectTypeHelper objectTypeHelper = ObjectTypeHelper.INSTANCE;
                SpenObjectBase targetObject = this.dragInfo.getTargetObject();
                Intrinsics.checkNotNull(targetObject);
                if (objectTypeHelper.isTextType(targetObject.getType())) {
                    Logger.m8702i(this.tag, "internalDnD# setFocusedTextBox cursor:" + this.dragInfo + ".targetObjectCursor");
                    InjectedFunction injectedFunction = this.injectedFunction;
                    SpenObjectBase targetObject2 = this.dragInfo.getTargetObject();
                    Intrinsics.checkNotNull(targetObject2, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectShape");
                    injectedFunction.setTargetTextBoxFocus((SpenObjectShape) targetObject2, this.dragInfo.getTargetObjectCursor());
                }
            }
        }
        return true;
    }

    public final boolean isDropContentObjectSpan() {
        if (this.dragInfo.isDropContentObjectSpan()) {
            return true;
        }
        return !this.dragInfo.getIsInternalLabel() && this.injectedFunction.isObjectSpanOptionEnabled();
    }

    public final void setBackupObjList(@Nullable List<SpenObjectBase> list) {
        this.backupObjList = list;
    }

    public final void setBackupPageList(@Nullable List<SpenWPage> list) {
        this.backupPageList = list;
    }

    public final void setBeginHistory(boolean z) {
        this.beginHistory = z;
    }

    public final void setSelectedCellPositionsOfTable(@Nullable List<Pair<Integer, Integer>> list) {
        this.selectedCellPositionsOfTable = list;
    }

    public final void setBackupObjList(@NotNull ArrayList<SpenObjectBase> backupObjectList) {
        Intrinsics.checkNotNullParameter(backupObjectList, "backupObjectList");
        this.backupObjList = backupObjectList;
        if (backupObjectList != null) {
            for (SpenObjectBase spenObjectBase : backupObjectList) {
                if (ObjectTypeHelper.INSTANCE.isTableType(spenObjectBase.getType())) {
                    Intrinsics.checkNotNull(spenObjectBase, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectTable");
                    this.selectedCellPositionsOfTable = ((SpenObjectTable) spenObjectBase).getSelectedCellPositions();
                }
            }
        }
    }
}
