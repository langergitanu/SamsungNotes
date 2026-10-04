package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.worddoc.SpenCustomObject;
import com.samsung.android.sdk.pen.worddoc.SpenStickyNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.common.SpenDocumentInitializer;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.StickyMemoView;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.StickyMemoSAConstants;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.document.SmDocumentManager;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.StickyNoteEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.samsung.android.support.senl.p148nt.model.repository.data.sticky.StickyDataSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 O2\u00020\u0001:\u0001OB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010\u0015J*\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010J&\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0010J \u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&H\u0002J\u0018\u0010'\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020&2\u0006\u0010%\u001a\u00020&H\u0002J\u0016\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001e\u001a\u00020\u0017J\u000e\u0010.\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u0017J\u0016\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u0002012\u0006\u0010\u001e\u001a\u00020\u0017J\u000e\u00102\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0017J\u001e\u00103\u001a\u00020\u001d2\u0006\u00100\u001a\u0002012\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0017J\u0018\u00103\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u0017H\u0002J\u0016\u00103\u001a\u00020\u001d2\u0006\u00100\u001a\u0002012\u0006\u0010\u001e\u001a\u00020\u0017J\u001a\u0010\u0012\u001a\u0004\u0018\u00010$2\u0006\u00100\u001a\u0002012\u0006\u0010\u001e\u001a\u00020\u0017H\u0002J\u001d\u00104\u001a\u0004\u0018\u00010\u000e2\u0006\u00100\u001a\u0002012\u0006\u0010\u001e\u001a\u00020\u0017¢\u0006\u0002\u00105J\u001d\u00106\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u00172\b\u00107\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u00108J\u000e\u00109\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\fJ\u0006\u0010:\u001a\u00020;J\u0016\u0010<\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000eJ\u0018\u0010<\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010=\u001a\u00020>H\u0002J\u0016\u0010?\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020-2\u0006\u0010@\u001a\u00020>J\u0014\u0010A\u001a\u00020\u001d2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020>0CJ\u000e\u0010D\u001a\u00020>2\u0006\u0010E\u001a\u00020\u0017J0\u0010F\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\u0016\u0010G\u001a\u0012\u0012\u0004\u0012\u00020\f0Hj\b\u0012\u0004\u0012\u00020\f`I2\u0006\u0010J\u001a\u00020\u000eH\u0016J \u0010K\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\u0006\u0010L\u001a\u00020M2\u0006\u0010J\u001a\u00020\u000eH\u0016J0\u0010N\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\u0016\u0010G\u001a\u0012\u0012\u0004\u0012\u00020\f0Hj\b\u0012\u0004\u0012\u00020\f`I2\u0006\u0010J\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoObjectManager;", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote$CustomObjectEventListener;", "composerViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;)V", "getComposerViewPresenter", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "iconSize", "", "overlapRange", "lastRemovedObject", "Lcom/samsung/android/sdk/pen/worddoc/SpenCustomObject;", "getAddTargetPageIndex", "", "pos", "Landroid/graphics/PointF;", "(Landroid/graphics/PointF;)Ljava/lang/Integer;", "findPageBy", Bixby2Constants.BIXBY_PARAM_RANGE, "Lkotlin/ranges/IntRange;", "(Lkotlin/ranges/IntRange;Landroid/graphics/PointF;)Ljava/lang/Integer;", "addNewMemoObject", "Lcom/samsung/android/sdk/pen/worddoc/SpenStickyNote;", "context", "Landroid/content/Context;", "pageIndex", "defWidth", "updateNewMemoObject", "", "obj", "beginPageIndex", "curPageIndex", "lTPoint", "adjustOverlapPos", "page", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "dest", "Landroid/graphics/RectF;", "checkBoundary", "isOverlapped", "", "below", "updateFile", "memoView", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/StickyMemoView;", "hasDirty", "clearDirty", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "setDirty", "removeMemoObject", "findPageIndexBy", "(Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;Lcom/samsung/android/sdk/pen/worddoc/SpenStickyNote;)Ljava/lang/Integer;", "updateBackgroundColor", "bgColor", "(Lcom/samsung/android/sdk/pen/worddoc/SpenStickyNote;Ljava/lang/Integer;)Z", "logMinimizedColor", "getRepository", "Lcom/samsung/android/support/senl/nt/model/repository/data/sticky/StickyDataSource;", "insertEntity", "pageId", "", "updateLastHeight", "memoId", "deleteEntity", "pageIdList", "", "toString", "memoObj", "onCustomObjectAdded", "objectList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "historyEventType", "onCustomObjectChanged", "changedInfo", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote$CustomObjectEventListener$CustomObjectChangedInfo;", "onCustomObjectRemoved", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class StickyMemoObjectManager implements SpenWNote.CustomObjectEventListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG;

    @NotNull
    private final ComposerViewPresenter composerViewPresenter;
    private final float iconSize;

    @Nullable
    private SpenCustomObject lastRemovedObject;
    private final float overlapRange;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoObjectManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return StickyMemoObjectManager.TAG;
        }

        private Companion() {
        }
    }

    static {
        String strCreateTag = Logger.createTag("StickyMemoObjectManager");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public StickyMemoObjectManager(@NotNull ComposerViewPresenter composerViewPresenter) {
        Intrinsics.checkNotNullParameter(composerViewPresenter, "composerViewPresenter");
        this.composerViewPresenter = composerViewPresenter;
        SpenDocumentInitializer.Companion companion = SpenDocumentInitializer.INSTANCE;
        SpenWNote doc = composerViewPresenter.getDoc();
        Intrinsics.checkNotNullExpressionValue(doc, "getDoc(...)");
        this.iconSize = companion.convertDpToNoteValue(doc, 18.0f);
        SpenWNote doc2 = composerViewPresenter.getDoc();
        Intrinsics.checkNotNullExpressionValue(doc2, "getDoc(...)");
        this.overlapRange = companion.convertDpToNoteValue(doc2, 9.0f);
    }

    public static /* synthetic */ SpenStickyNote addNewMemoObject$default(StickyMemoObjectManager stickyMemoObjectManager, Context context, int i, int i2, PointF pointF, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            pointF = null;
        }
        return stickyMemoObjectManager.addNewMemoObject(context, i, i2, pointF);
    }

    private final void adjustOverlapPos(SpenWPage page, SpenStickyNote obj, RectF dest) {
        int i;
        SpenCustomObject customObject;
        int customObjectCount = page.getCustomObjectCount();
        while (true) {
            while (i < customObjectCount) {
                customObject = page.getCustomObject(i);
                i = (customObject == null || Intrinsics.areEqual(customObject, obj) || !isOverlapped(customObject.getCollapseRect(), dest)) ? i + 1 : 0;
            }
            checkBoundary(dest, page);
            return;
            RectF collapseRect = customObject.getCollapseRect();
            float f = collapseRect.left;
            float f4 = this.overlapRange;
            float f5 = f + f4;
            float f6 = collapseRect.top + f4;
            float f7 = this.iconSize;
            dest.set(f5, f6, f5 + f7, f7 + f6);
        }
    }

    private final void checkBoundary(RectF dest, SpenWPage page) {
        float f = dest.left;
        float width = f < 0.0f ? (-1) * f : 0.0f;
        float f4 = dest.top;
        float height = f4 < 0.0f ? (-1) * f4 : 0.0f;
        if (dest.right > page.getWidth()) {
            width = page.getWidth() - dest.right;
        }
        if (dest.bottom > page.getHeight()) {
            height = page.getHeight() - dest.bottom;
        }
        dest.offset(width, height);
    }

    private final Integer findPageBy(IntRange range, PointF pos) {
        int first = range.getFirst();
        int last = range.getLast();
        if (first > last) {
            return null;
        }
        while (true) {
            SpenWPage page = this.composerViewPresenter.getDoc().getPage(first);
            if (new Rect(page.getOffset().x, page.getOffset().y, page.getWidth() + page.getOffset().x, page.getHeight() + page.getOffset().y).contains((int) pos.x, (int) pos.y)) {
                return Integer.valueOf(first);
            }
            if (first == last) {
                return null;
            }
            first++;
        }
    }

    private final boolean isOverlapped(RectF below, RectF dest) {
        float f = below.left;
        float f4 = dest.left;
        if (f > f4) {
            return false;
        }
        float f5 = this.overlapRange;
        if (f + f5 <= f4) {
            return false;
        }
        float f6 = below.top;
        float f7 = dest.top;
        return f6 <= f7 && f6 + f5 > f7;
    }

    @NotNull
    public final SpenStickyNote addNewMemoObject(@NotNull Context context, int pageIndex, int defWidth, @Nullable PointF pos) {
        Intrinsics.checkNotNullParameter(context, "context");
        SpenWPage page = this.composerViewPresenter.getDoc().getPage(pageIndex);
        Logger.m10999d(TAG, AbstractC0622a.m1164j(pageIndex, page.getCustomObjectCount(), "addMemoObject# ", "(", ")"));
        String cachePath = this.composerViewPresenter.getObjectManager().getCachePath();
        SmDocumentManager.Companion companion = SmDocumentManager.INSTANCE;
        String strM756B = AbstractC0541b.m756B(cachePath, companion.makeFileName());
        SmDocumentManager smDocumentManager = new SmDocumentManager();
        int value = this.composerViewPresenter.getTextManager().getLastTextState().getBodyTextFontSize().getValue();
        Activity activity = this.composerViewPresenter.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        smDocumentManager.loadDoc(activity, strM756B, strM756B, defWidth, Float.valueOf(value));
        smDocumentManager.save();
        smDocumentManager.release(true);
        PointF pointF = new PointF(0.0f, 0.0f);
        if (pos != null) {
            pointF.x = pos.x - page.getOffset().x;
            pointF.y = pos.y - page.getOffset().y;
        }
        SpenStickyNote spenStickyNote = new SpenStickyNote();
        spenStickyNote.setAttachedFile(strM756B);
        float f = pointF.x;
        float f4 = pointF.y;
        float f5 = this.iconSize;
        RectF rectF = new RectF(f, f4, f + f5, f5 + f4);
        spenStickyNote.setRect(rectF);
        spenStickyNote.setCollapseRect(new RectF(rectF));
        spenStickyNote.setBackgroundColor(companion.getDefaultBackgroundColor(context));
        if (pos != null) {
            updateNewMemoObject(spenStickyNote, pageIndex, pageIndex, new PointF(pointF.x, pointF.y));
        }
        page.appendCustomObject(spenStickyNote);
        return spenStickyNote;
    }

    public final void clearDirty(@NotNull SpenWNote note, @NotNull SpenStickyNote obj) {
        Intrinsics.checkNotNullParameter(note, "note");
        Intrinsics.checkNotNullParameter(obj, "obj");
        boolean zIsChanged = note.isChanged();
        obj.setCustomData("");
        if (zIsChanged) {
            return;
        }
        note.clearChangedFlag();
    }

    public final void deleteEntity(@NotNull List<String> pageIdList) {
        Intrinsics.checkNotNullParameter(pageIdList, "pageIdList");
        Iterator<String> it = pageIdList.iterator();
        while (it.hasNext()) {
            getRepository().deleteByPageId(it.next());
        }
    }

    @Nullable
    public final Integer findPageIndexBy(@NotNull SpenWNote note, @NotNull SpenStickyNote obj) {
        Intrinsics.checkNotNullParameter(note, "note");
        Intrinsics.checkNotNullParameter(obj, "obj");
        ArrayList<SpenWPage> pageList = note.getPageList();
        int size = pageList.size();
        for (int i = 0; i < size; i++) {
            SpenWPage spenWPage = pageList.get(i);
            Intrinsics.checkNotNullExpressionValue(spenWPage, "get(...)");
            SpenWPage spenWPage2 = spenWPage;
            int customObjectCount = spenWPage2.getCustomObjectCount();
            for (int i2 = 0; i2 < customObjectCount; i2++) {
                SpenCustomObject customObject = spenWPage2.getCustomObject(i2);
                if (customObject != null && customObject.getMHandle() == obj.getMHandle()) {
                    return Integer.valueOf(i);
                }
            }
        }
        return null;
    }

    @Nullable
    public final Integer getAddTargetPageIndex(@Nullable PointF pos) {
        int currentPageIndex = this.composerViewPresenter.getCurrentPageIndex();
        if (pos != null) {
            Integer numFindPageBy = findPageBy(new IntRange(currentPageIndex, RangesKt.coerceAtMost(currentPageIndex + 3, this.composerViewPresenter.getDoc().getPageCount() - 1)), pos);
            if (numFindPageBy == null) {
                numFindPageBy = findPageBy(new IntRange(RangesKt.coerceAtLeast(currentPageIndex - 1, 0), RangesKt.coerceAtLeast(currentPageIndex - 3, 0)), pos);
            }
            if (numFindPageBy == null) {
                return null;
            }
            currentPageIndex = numFindPageBy.intValue();
        }
        return Integer.valueOf(currentPageIndex);
    }

    @NotNull
    public final ComposerViewPresenter getComposerViewPresenter() {
        return this.composerViewPresenter;
    }

    @NotNull
    public final StickyDataSource getRepository() {
        StickyDataSource stickyNoteRepository = this.composerViewPresenter.getComposerModel().getNotesDocEntityManager().getStickyNoteRepository();
        Intrinsics.checkNotNullExpressionValue(stickyNoteRepository, "getStickyNoteRepository(...)");
        return stickyNoteRepository;
    }

    public final boolean hasDirty(@NotNull SpenStickyNote obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        return !TextUtils.isEmpty(obj.getCustomData());
    }

    public final void insertEntity(@NotNull SpenStickyNote obj, int pageIndex) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        insertEntity(obj, this.composerViewPresenter.getDoc().getPageIdByIndex(pageIndex));
    }

    public final void logMinimizedColor(@NotNull SpenCustomObject obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        int backgroundColor = obj.getBackgroundColor();
        int[] intArray = this.composerViewPresenter.getActivity().getResources().getIntArray(C9086R.array.sticky_memo_background_color);
        Intrinsics.checkNotNullExpressionValue(intArray, "getIntArray(...)");
        int iIndexOf = ArraysKt.indexOf(intArray, backgroundColor);
        if (iIndexOf >= 0) {
            ComposerSA.insert(StickyMemoSAConstants.SCREEN_STICKY_NOTE_MINIMIZED, "411", StickyMemoSAConstants.INSTANCE.getDETAIL_BG_COLOR_ARRAY()[iIndexOf]);
        }
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.CustomObjectEventListener
    public void onCustomObjectAdded(@NotNull SpenWPage page, @NotNull ArrayList<SpenCustomObject> objectList, int historyEventType) {
        StickyNoteEntity stickyNoteEntity;
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(objectList, "objectList");
        String str = TAG;
        Logger.m10999d(str, "onCustomObjectAdded#");
        if (!objectList.isEmpty() && Intrinsics.areEqual(objectList.get(0), this.lastRemovedObject) && (stickyNoteEntity = getRepository().get(objectList.get(0).getId())) != null) {
            Logger.m10999d(str, "onCustomObjectAdded# on page changed");
            stickyNoteEntity.setPageUuid(page.getId());
            getRepository().update(stickyNoteEntity);
        }
        this.lastRemovedObject = null;
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.CustomObjectEventListener
    public void onCustomObjectChanged(@NotNull SpenWPage page, @NotNull SpenWNote.CustomObjectEventListener.CustomObjectChangedInfo changedInfo, int historyEventType) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(changedInfo, "changedInfo");
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.CustomObjectEventListener
    public void onCustomObjectRemoved(@NotNull SpenWPage page, @NotNull ArrayList<SpenCustomObject> objectList, int historyEventType) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(objectList, "objectList");
        Logger.m10999d(TAG, "onCustomObjectRemoved# ");
        this.lastRemovedObject = objectList.get(0);
    }

    public final void removeMemoObject(@NotNull SpenWNote note, int pageIndex, @NotNull SpenStickyNote obj) {
        Intrinsics.checkNotNullParameter(note, "note");
        Intrinsics.checkNotNullParameter(obj, "obj");
        removeMemoObject(note.getPage(pageIndex), obj);
    }

    public final void setDirty(@NotNull SpenStickyNote obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        obj.setCustomData(String.valueOf(System.currentTimeMillis()));
        this.composerViewPresenter.getComposerModel().getDocState().setDirty(true);
    }

    @NotNull
    public final String toString(@NotNull SpenStickyNote memoObj) {
        Intrinsics.checkNotNullParameter(memoObj, "memoObj");
        String encode = Logger.getEncode(memoObj.getAttachedFile());
        String id = memoObj.getId();
        boolean zM1607A = AbstractC2322a.m1607A(encode);
        RectF rect = memoObj.getRect();
        StringBuilder sbM16m = AbstractC0000a.m16m("MemoObject{", id, " file: ", encode, "(");
        sbM16m.append(zM1607A);
        sbM16m.append(") rect: ");
        sbM16m.append(rect);
        sbM16m.append("}");
        return sbM16m.toString();
    }

    public final boolean updateBackgroundColor(@NotNull SpenStickyNote obj, @Nullable Integer bgColor) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        if (bgColor == null || obj.getBackgroundColor() == bgColor.intValue()) {
            return false;
        }
        obj.setBackgroundColor(bgColor.intValue());
        return true;
    }

    public final void updateFile(@NotNull StickyMemoView memoView, @NotNull SpenStickyNote obj) {
        Intrinsics.checkNotNullParameter(memoView, "memoView");
        Intrinsics.checkNotNullParameter(obj, "obj");
        String strValueOf = String.valueOf(hashCode());
        String str = TAG;
        Logger.startTime(strValueOf, str, "updateFile start");
        memoView.saveDoc();
        obj.setAttachedFile(memoView.getDocManager().getSavePath());
        obj.setMinFormatVersion(memoView.getDocManager().getLastMinFormatVer());
        obj.setFormatVersion(memoView.getDocManager().getLastFormatVer());
        Logger.endTime(String.valueOf(hashCode()), str, "updateFile end");
    }

    public final void updateLastHeight(@NotNull StickyMemoView memoView, @NotNull String memoId) {
        Intrinsics.checkNotNullParameter(memoView, "memoView");
        Intrinsics.checkNotNullParameter(memoId, "memoId");
        StickyNoteEntity stickyNoteEntity = getRepository().get(memoId);
        if (stickyNoteEntity == null) {
            AbstractC8014b.m7196B("updateLastHeight# not found ", memoId, TAG);
        } else if (stickyNoteEntity.getHeight() != memoView.getHeight()) {
            stickyNoteEntity.setHeight(memoView.getHeight());
            getRepository().update(stickyNoteEntity);
            AbstractC0000a.m3D(memoView.getHeight(), "updateLastHeight: ", TAG);
        }
    }

    public final void updateNewMemoObject(@NotNull SpenStickyNote obj, int beginPageIndex, int curPageIndex, @NotNull PointF lTPoint) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(lTPoint, "lTPoint");
        AbstractC8014b.m7216r(beginPageIndex, curPageIndex, "updateNewMemoObject# ", " / ", TAG);
        SpenWPage page = this.composerViewPresenter.getDoc().getPage(curPageIndex);
        if (curPageIndex != beginPageIndex) {
            removeMemoObject(this.composerViewPresenter.getDoc().getPage(beginPageIndex), obj);
            page.appendCustomObject(obj);
        }
        lTPoint.x -= page.getOffset().x;
        lTPoint.y -= page.getOffset().y;
        float f = lTPoint.x;
        float f4 = lTPoint.y;
        float f5 = this.iconSize;
        RectF rectF = new RectF(f, f4, f + f5, f5 + f4);
        adjustOverlapPos(page, obj, rectF);
        obj.setRect(rectF);
        obj.setCollapseRect(new RectF(rectF));
    }

    private final void insertEntity(SpenStickyNote obj, String pageId) {
        StickyNoteEntity stickyNoteEntity = new StickyNoteEntity();
        stickyNoteEntity.setObjectId(obj.getId());
        stickyNoteEntity.setDocumentUuid(this.composerViewPresenter.getComposerModel().getDocState().getUuid());
        stickyNoteEntity.setPageUuid(pageId);
        getRepository().insert(CollectionsKt.listOf(stickyNoteEntity), false);
    }

    private final void removeMemoObject(SpenWPage page, SpenStickyNote obj) {
        int customObjectCount = page.getCustomObjectCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i < customObjectCount) {
                SpenCustomObject customObject = page.getCustomObject(i);
                if (customObject != null && customObject.getMHandle() == obj.getMHandle()) {
                    page.removeCustomObject(i);
                    z = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        Logger.m10999d(TAG, "removeMemoObject# " + z + " " + obj.getAttachedFile());
    }

    public final void removeMemoObject(@NotNull SpenWNote note, @NotNull SpenStickyNote obj) {
        Intrinsics.checkNotNullParameter(note, "note");
        Intrinsics.checkNotNullParameter(obj, "obj");
        SpenWPage spenWPageFindPageBy = findPageBy(note, obj);
        if (spenWPageFindPageBy != null) {
            removeMemoObject(spenWPageFindPageBy, obj);
        }
    }

    private final SpenWPage findPageBy(SpenWNote note, SpenStickyNote obj) {
        Integer numFindPageIndexBy = findPageIndexBy(note, obj);
        if (numFindPageIndexBy != null) {
            return note.getPage(numFindPageIndexBy.intValue());
        }
        return null;
    }
}
