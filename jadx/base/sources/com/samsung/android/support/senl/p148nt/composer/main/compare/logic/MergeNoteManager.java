package com.samsung.android.support.senl.p148nt.composer.main.compare.logic;

import android.graphics.RectF;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.compare.clone_object.CloneSpenObject;
import com.samsung.android.support.senl.p148nt.composer.main.compare.logic.InformationConflict;
import com.samsung.android.support.senl.p148nt.composer.main.compare.logic.page.ConflictPage;
import com.samsung.android.support.senl.p148nt.composer.main.compare.logic.page.object.CompareSPenObjectTextBox;
import com.samsung.android.support.senl.p148nt.composer.main.compare.presenter.IObserverConflict;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 G2\u00020\u0001:\u0001GB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\b\u0010 \u001a\u0004\u0018\u00010\u000bJ\u0010\u0010!\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0014J\u001a\u0010$\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0007J\u0006\u0010'\u001a\u00020\u001eJ\b\u0010(\u001a\u00020\u001eH\u0002J\b\u0010)\u001a\u00020\u001eH\u0002J\u0006\u0010*\u001a\u00020\u001eJ\b\u0010+\u001a\u00020\u001eH\u0002J\b\u0010,\u001a\u00020\u001eH\u0002J\u0018\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0019H\u0002J\b\u00101\u001a\u00020\u001eH\u0002J\u0016\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u000205J \u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u00192\u0006\u00109\u001a\u00020\u0016H\u0002J\u0018\u0010:\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020\u00102\u0006\u00109\u001a\u00020\u0016H\u0002J\u000e\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\u0007J\b\u0010>\u001a\u00020\u001eH\u0016J\u0012\u0010?\u001a\u00020\u001e2\b\u0010@\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020BH\u0002J\u0018\u0010D\u001a\u00020B2\u0006\u0010E\u001a\u00020B2\u0006\u0010F\u001a\u00020BH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/MergeNoteManager;", "Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/IObserverConflict$IMergeConflictSubject;", "<init>", "()V", "mObserver", "Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/IObserverConflict;", "mNoteMerge", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "mNoteLocal", "mNoteSync", "mPathMerge", "", "listConflictBodyText", "", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/InformationConflict$BodyTextConflict;", "listConflictWPage", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/InformationConflict$WPageConflict;", "listConflictSPenObject", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/InformationConflict$SPenObjectConflict;", "mScale", "", "mFlagStartMerge", "", "isDone", "mCurrentId", "", "isMergePageDone", "isMergeBodyTextDone", "isChangeNote", "setNoteMerge", "", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "path", "setNoteShow", "setScale", WiggleAnimationConfig.KEY_SCALE, "setNote", "local", "sync", "setFlagStartMerge", "merge", "updateMergeStatus", "release", "mergeBodyText", "mergerPages", "insertPage", "conflictPage", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/page/ConflictPage;", "totalPagesAdded", "updateInfoConflict", "editMerge", "tag", "informationConflict", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/InformationConflict;", "updateListConflictBodyText", "bodyTextConflict", "length", "isInsert", "updateListConflictPage", "wPageConflict", "keepMerge", "noteLocal", "notifyObservers", "registerObserver", "observer", "scaleRect", "Landroid/graphics/RectF;", "rect", "moveRectF", "localRect", "serverRect", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMergeNoteManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MergeNoteManager.kt\ncom/samsung/android/support/senl/nt/composer/main/compare/logic/MergeNoteManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,415:1\n1#2:416\n*E\n"})
public final class MergeNoteManager implements IObserverConflict.IMergeConflictSubject {

    @NotNull
    public static final String TAG = "MergeNoteManager";
    private boolean isChangeNote;
    private boolean isDone;
    private boolean isMergeBodyTextDone;
    private boolean isMergePageDone;
    private int mCurrentId;
    private boolean mFlagStartMerge;

    @Nullable
    private SpenWNote mNoteLocal;

    @Nullable
    private SpenWNote mNoteMerge;

    @Nullable
    private SpenWNote mNoteSync;

    @Nullable
    private IObserverConflict mObserver;

    @Nullable
    private String mPathMerge;
    private float mScale;

    @Nullable
    private List<InformationConflict.SPenObjectConflict> listConflictSPenObject = new ArrayList();

    @Nullable
    private List<InformationConflict.BodyTextConflict> listConflictBodyText = new ArrayList();

    @Nullable
    private List<InformationConflict.WPageConflict> listConflictWPage = new ArrayList();

    private final void insertPage(ConflictPage conflictPage, int totalPagesAdded) {
        SpenWNote spenWNote = this.mNoteLocal;
        Intrinsics.checkNotNull(spenWNote);
        SpenWPage page = spenWNote.getPage(conflictPage.getMPageIndexLocal());
        int width = (int) (page.getWidth() * this.mScale);
        int height = (int) (page.getHeight() * this.mScale);
        SpenWNote spenWNote2 = this.mNoteMerge;
        SpenWPage spenWPageInsertPage = spenWNote2 != null ? spenWNote2.insertPage(conflictPage.getMPageIndexSyncDown() + 1 + totalPagesAdded, width, height) : null;
        if (spenWPageInsertPage != null) {
            spenWPageInsertPage.copy(page);
        }
    }

    private final void merge() {
    }

    private static final void merge$lambda$0(MergeNoteManager mergeNoteManager) {
        try {
            mergeNoteManager.mergerPages();
        } catch (IOException e) {
            Logger.m11001e(TAG, "merge error: ", e);
        }
    }

    private final void mergeBodyText() {
        int endIndexLocal;
        CompareManager companion = CompareManager.INSTANCE.getInstance();
        Intrinsics.checkNotNull(companion);
        CompareSPenObjectTextBox compareBodyText = companion.getCompareBodyText();
        if (compareBodyText != null && compareBodyText.getIsConflictBody()) {
            List<ConflictLocation> listConflictLocation = compareBodyText.getListConflictLocation();
            CollectionsKt.sortWith(listConflictLocation, new Comparator<ConflictLocation>() { // from class: com.samsung.android.support.senl.nt.composer.main.compare.logic.MergeNoteManager.mergeBodyText.1
                @Override // java.util.Comparator
                public int compare(ConflictLocation o12, ConflictLocation o22) {
                    int endIndexSync;
                    int endIndexSync2;
                    Intrinsics.checkNotNullParameter(o12, "o1");
                    Intrinsics.checkNotNullParameter(o22, "o2");
                    InformationConflict mInformationConflict = o12.getMInformationConflict();
                    Intrinsics.checkNotNull(mInformationConflict, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.composer.main.compare.logic.InformationConflict.BodyTextConflict");
                    InformationConflict.BodyTextConflict bodyTextConflict = (InformationConflict.BodyTextConflict) mInformationConflict;
                    InformationConflict mInformationConflict2 = o22.getMInformationConflict();
                    Intrinsics.checkNotNull(mInformationConflict2, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.composer.main.compare.logic.InformationConflict.BodyTextConflict");
                    InformationConflict.BodyTextConflict bodyTextConflict2 = (InformationConflict.BodyTextConflict) mInformationConflict2;
                    if (bodyTextConflict.getStartIndexSync() != bodyTextConflict2.getStartIndexSync()) {
                        endIndexSync = bodyTextConflict.getStartIndexSync();
                        endIndexSync2 = bodyTextConflict2.getStartIndexSync();
                    } else {
                        endIndexSync = bodyTextConflict.getEndIndexSync();
                        endIndexSync2 = bodyTextConflict2.getEndIndexSync();
                    }
                    return endIndexSync - endIndexSync2;
                }
            });
            TreeSet treeSet = new TreeSet(new Comparator<InformationConflict.BodyTextConflict>() { // from class: com.samsung.android.support.senl.nt.composer.main.compare.logic.MergeNoteManager$mergeBodyText$setConflictBodyText$1
                @Override // java.util.Comparator
                public int compare(InformationConflict.BodyTextConflict o12, InformationConflict.BodyTextConflict o22) {
                    int id;
                    int id2;
                    Intrinsics.checkNotNullParameter(o12, "o1");
                    Intrinsics.checkNotNullParameter(o22, "o2");
                    if (o12.getStartMerge() != o22.getStartMerge()) {
                        id = o12.getStartMerge();
                        id2 = o22.getStartMerge();
                    } else {
                        id = o12.getId();
                        id2 = o22.getId();
                    }
                    return id - id2;
                }
            });
            SpenWNote spenWNote = this.mNoteLocal;
            Intrinsics.checkNotNull(spenWNote);
            SpenObjectTextBox bodyText = spenWNote.getBodyText();
            SpenWNote spenWNote2 = this.mNoteMerge;
            Intrinsics.checkNotNull(spenWNote2);
            SpenObjectTextBox bodyText2 = spenWNote2.getBodyText();
            Iterator<ConflictLocation> it = listConflictLocation.iterator();
            int i = 0;
            while (it.hasNext()) {
                InformationConflict mInformationConflict = it.next().getMInformationConflict();
                Intrinsics.checkNotNull(mInformationConflict, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.composer.main.compare.logic.InformationConflict.BodyTextConflict");
                InformationConflict.BodyTextConflict bodyTextConflict = (InformationConflict.BodyTextConflict) mInformationConflict;
                bodyTextConflict.setStartMerge(bodyTextConflict.getStartIndexSync() + i);
                int i2 = this.mCurrentId;
                this.mCurrentId = i2 + 1;
                bodyTextConflict.setId(i2);
                if (bodyTextConflict.getType() == 2) {
                    endIndexLocal = bodyTextConflict.getEndIndexLocal() - bodyTextConflict.getStartIndexLocal();
                    bodyText2.insertText(bodyTextConflict.getEndIndexSync() + i, bodyText, bodyTextConflict.getStartIndexLocal(), endIndexLocal);
                } else if (bodyTextConflict.getType() == 1) {
                    endIndexLocal = bodyTextConflict.getEndIndexLocal() - bodyTextConflict.getStartIndexLocal();
                    bodyText2.insertText(bodyTextConflict.getStartMerge(), bodyText, bodyTextConflict.getStartIndexLocal(), endIndexLocal);
                } else {
                    treeSet.add(bodyTextConflict);
                }
                i += endIndexLocal;
                treeSet.add(bodyTextConflict);
            }
            Iterator it2 = treeSet.iterator();
            Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
            while (it2.hasNext()) {
                InformationConflict.BodyTextConflict bodyTextConflict2 = (InformationConflict.BodyTextConflict) it2.next();
                List<InformationConflict.BodyTextConflict> list = this.listConflictBodyText;
                if (list != null) {
                    Intrinsics.checkNotNull(bodyTextConflict2);
                    list.add(bodyTextConflict2);
                }
                List<InformationConflict.BodyTextConflict> list2 = this.listConflictBodyText;
                bodyTextConflict2.setIndexOfListConflict(list2 != null ? list2.size() - 1 : -1);
            }
        }
        this.isMergeBodyTextDone = true;
        updateMergeStatus();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x01bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void mergerPages() {
        boolean z;
        int i;
        List<InformationConflict.SPenObjectConflict> list;
        TreeSet treeSet = new TreeSet(new Comparator<InformationConflict.WPageConflict>() { // from class: com.samsung.android.support.senl.nt.composer.main.compare.logic.MergeNoteManager$mergerPages$setConflictWPage$1
            @Override // java.util.Comparator
            public int compare(InformationConflict.WPageConflict o12, InformationConflict.WPageConflict o22) {
                int id;
                int id2;
                Intrinsics.checkNotNullParameter(o12, "o1");
                Intrinsics.checkNotNullParameter(o22, "o2");
                if (o12.getIndexMerge() != o22.getIndexMerge()) {
                    id = o12.getIndexMerge();
                    id2 = o22.getIndexMerge();
                } else {
                    id = o12.getId();
                    id2 = o22.getId();
                }
                return id - id2;
            }
        });
        CompareManager companion = CompareManager.INSTANCE.getInstance();
        Intrinsics.checkNotNull(companion);
        List<ConflictLocation> listConflictLocation = companion.getListConflictLocation();
        List<ConflictLocation> list2 = listConflictLocation;
        int i2 = 1;
        if (list2 == null || list2.isEmpty()) {
            z = true;
            i = 0;
        } else {
            Iterator<ConflictLocation> it = listConflictLocation.iterator();
            i = 0;
            while (it.hasNext()) {
                InformationConflict mInformationConflict = it.next().getMInformationConflict();
                if (mInformationConflict instanceof InformationConflict.WPageConflict) {
                    InformationConflict.WPageConflict wPageConflict = (InformationConflict.WPageConflict) mInformationConflict;
                    ConflictPage conflictPage = wPageConflict.getConflictPage();
                    Intrinsics.checkNotNull(conflictPage);
                    wPageConflict.setIndexMerge(conflictPage.getMPageIndexSyncDown() + i);
                    int i4 = this.mCurrentId;
                    this.mCurrentId = i4 + 1;
                    wPageConflict.setId(i4);
                    if (wPageConflict.getType() == i2) {
                        ConflictPage conflictPage2 = wPageConflict.getConflictPage();
                        Intrinsics.checkNotNull(conflictPage2);
                        insertPage(conflictPage2, i);
                        i++;
                    }
                    treeSet.add(mInformationConflict);
                } else {
                    if (mInformationConflict instanceof InformationConflict.SPenObjectConflict) {
                        SpenWNote spenWNote = this.mNoteLocal;
                        Intrinsics.checkNotNull(spenWNote);
                        InformationConflict.SPenObjectConflict sPenObjectConflict = (InformationConflict.SPenObjectConflict) mInformationConflict;
                        ConflictPage conflictPage3 = sPenObjectConflict.getConflictPage();
                        Intrinsics.checkNotNull(conflictPage3);
                        SpenWPage page = spenWNote.getPage(conflictPage3.getMPageIndexLocal());
                        SpenWNote spenWNote2 = this.mNoteMerge;
                        Intrinsics.checkNotNull(spenWNote2);
                        ConflictPage conflictPage4 = sPenObjectConflict.getConflictPage();
                        Intrinsics.checkNotNull(conflictPage4);
                        SpenWPage page2 = spenWNote2.getPage(conflictPage4.getMPageIndexSyncDown() + i);
                        ArrayList<SpenObjectBase> objectList = page.getObjectList();
                        ArrayList<SpenObjectBase> objectList2 = page2.getObjectList();
                        int i5 = this.mCurrentId;
                        this.mCurrentId = i5 + 1;
                        sPenObjectConflict.setId(i5);
                        ConflictPage conflictPage5 = sPenObjectConflict.getConflictPage();
                        Intrinsics.checkNotNull(conflictPage5);
                        sPenObjectConflict.setIndexPage(conflictPage5.getMPageIndexSyncDown() + i);
                        if (sPenObjectConflict.getType() == 2) {
                            ArrayList<Integer> arrayList = new ArrayList<>();
                            int size = sPenObjectConflict.getIndexLocals().size();
                            int i6 = 0;
                            while (i6 < size) {
                                Integer num = sPenObjectConflict.getIndexLocals().get(i6);
                                Intrinsics.checkNotNullExpressionValue(num, "get(...)");
                                SpenObjectBase spenObjectBase = objectList.get(num.intValue());
                                Intrinsics.checkNotNullExpressionValue(spenObjectBase, "get(...)");
                                SpenObjectBase spenObjectBase2 = spenObjectBase;
                                int i7 = i2;
                                SpenObjectBase spenObjectBaseCloneSpenObject = CloneSpenObject.INSTANCE.cloneSpenObject(spenObjectBase2);
                                Integer num2 = sPenObjectConflict.getIndexSyncs().get(i6);
                                Intrinsics.checkNotNullExpressionValue(num2, "get(...)");
                                SpenObjectBase spenObjectBase3 = objectList2.get(num2.intValue());
                                Intrinsics.checkNotNullExpressionValue(spenObjectBase3, "get(...)");
                                SpenObjectBase spenObjectBase4 = spenObjectBase3;
                                RectF rectFScaleRect = scaleRect(spenObjectBase2.getRect());
                                RectF rectFMoveRectF = rectFScaleRect != null ? moveRectF(rectFScaleRect, spenObjectBase4.getRect()) : null;
                                if (spenObjectBaseCloneSpenObject != null) {
                                    spenObjectBaseCloneSpenObject.setRect(rectFMoveRectF, false);
                                }
                                page2.appendObject(spenObjectBaseCloneSpenObject);
                                arrayList.add(Integer.valueOf(page2.getObjectList().size() - 1));
                                i6++;
                                i2 = i7;
                            }
                            sPenObjectConflict.setIndexLocals(arrayList);
                        } else {
                            if (sPenObjectConflict.getType() == i2) {
                                ArrayList<Integer> arrayList2 = new ArrayList<>();
                                int size2 = sPenObjectConflict.getIndexLocals().size();
                                for (int i8 = 0; i8 < size2; i8++) {
                                    Integer num3 = sPenObjectConflict.getIndexLocals().get(i8);
                                    Intrinsics.checkNotNullExpressionValue(num3, "get(...)");
                                    SpenObjectBase spenObjectBase5 = objectList.get(num3.intValue());
                                    Intrinsics.checkNotNullExpressionValue(spenObjectBase5, "get(...)");
                                    SpenObjectBase spenObjectBase6 = spenObjectBase5;
                                    SpenObjectBase spenObjectBaseCloneSpenObject2 = CloneSpenObject.INSTANCE.cloneSpenObject(spenObjectBase6);
                                    RectF rect = spenObjectBase6.getRect();
                                    if (spenObjectBaseCloneSpenObject2 != null) {
                                        spenObjectBaseCloneSpenObject2.setRect(scaleRect(rect), false);
                                    }
                                    page2.appendObject(spenObjectBaseCloneSpenObject2);
                                    arrayList2.add(Integer.valueOf(page2.getObjectList().size() - 1));
                                }
                                sPenObjectConflict.setIndexLocals(arrayList2);
                            }
                            list = this.listConflictSPenObject;
                            if (list != null) {
                                list.add((InformationConflict.SPenObjectConflict) mInformationConflict);
                            }
                        }
                        list = this.listConflictSPenObject;
                        if (list != null) {
                        }
                    }
                    i2 = 1;
                }
            }
            Iterator it2 = treeSet.iterator();
            Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
            while (it2.hasNext()) {
                InformationConflict.WPageConflict wPageConflict2 = (InformationConflict.WPageConflict) it2.next();
                List<InformationConflict.WPageConflict> list3 = this.listConflictWPage;
                if (list3 != null) {
                    Intrinsics.checkNotNull(wPageConflict2);
                    list3.add(wPageConflict2);
                }
                List<InformationConflict.WPageConflict> list4 = this.listConflictWPage;
                wPageConflict2.setIndexOfListConflict(list4 != null ? list4.size() - 1 : -1);
            }
            z = true;
        }
        this.isMergePageDone = z;
        updateMergeStatus();
        AbstractC8014b.m7217s(i, "mergerPages totalPagesAdded: ", TAG);
    }

    private final RectF moveRectF(RectF localRect, RectF serverRect) {
        float f = localRect.left;
        if (f - r1 > ((double) serverRect.left) * 0.01d) {
            return localRect;
        }
        float f4 = localRect.top;
        if (f4 - r2 > ((double) serverRect.top) * 0.01d) {
            return localRect;
        }
        float f5 = localRect.right;
        if (f5 - r3 > ((double) serverRect.right) * 0.01d) {
            return localRect;
        }
        float f6 = localRect.bottom;
        if (f6 - r12 > ((double) serverRect.bottom) * 0.01d) {
            return localRect;
        }
        float f7 = f * 1.02f;
        localRect.left = f7;
        float f8 = f4 * 1.02f;
        localRect.top = f8;
        float f9 = f5 * 1.02f;
        localRect.right = f9;
        float f10 = f6 * 1.02f;
        localRect.bottom = f10;
        return new RectF(f7, f8, f9, f10);
    }

    private final RectF scaleRect(RectF rect) {
        float f = rect.left;
        float f4 = this.mScale;
        return new RectF(f * f4, rect.top * f4, rect.right * f4, rect.bottom * f4);
    }

    private final void updateInfoConflict() {
        SpenWPage pageMerge;
        SpenWPage pageMerge2;
        SpenWPage page;
        List<InformationConflict.WPageConflict> list = this.listConflictWPage;
        Intrinsics.checkNotNull(list);
        Iterator<InformationConflict.WPageConflict> it = list.iterator();
        while (true) {
            SpenWPage page2 = null;
            if (!it.hasNext()) {
                break;
            }
            InformationConflict.WPageConflict next = it.next();
            if (next.getType() == 0) {
                SpenWNote spenWNote = this.mNoteMerge;
                Intrinsics.checkNotNull(spenWNote);
                page = spenWNote.getPage(next.getIndexMerge());
            } else {
                page = null;
            }
            next.setPageSync(page);
            if (next.getType() == 1) {
                SpenWNote spenWNote2 = this.mNoteLocal;
                Intrinsics.checkNotNull(spenWNote2);
                page2 = spenWNote2.getPage(next.getIndexMerge());
            }
            next.setPageLocal(page2);
        }
        List<InformationConflict.SPenObjectConflict> list2 = this.listConflictSPenObject;
        Intrinsics.checkNotNull(list2);
        for (InformationConflict.SPenObjectConflict sPenObjectConflict : list2) {
            SpenWNote spenWNote3 = this.mNoteMerge;
            sPenObjectConflict.setPageMerge(spenWNote3 != null ? spenWNote3.getPage(sPenObjectConflict.getIndexPage()) : null);
            int iMax = (int) Math.max(sPenObjectConflict.getIndexLocals().size(), sPenObjectConflict.getIndexSyncs().size());
            for (int i = 0; i < iMax; i++) {
                if (sPenObjectConflict.getType() != 0 && (pageMerge2 = sPenObjectConflict.getPageMerge()) != null) {
                    Integer num = sPenObjectConflict.getIndexLocals().get(i);
                    Intrinsics.checkNotNullExpressionValue(num, "get(...)");
                    SpenObjectBase object = pageMerge2.getObject(num.intValue());
                    if (object != null) {
                        sPenObjectConflict.getObjectLocals().add(object);
                    }
                }
                if (sPenObjectConflict.getType() != 1 && (pageMerge = sPenObjectConflict.getPageMerge()) != null) {
                    ArrayList<SpenObjectBase> objectSyncs = sPenObjectConflict.getObjectSyncs();
                    Integer num2 = sPenObjectConflict.getIndexSyncs().get(i);
                    Intrinsics.checkNotNullExpressionValue(num2, "get(...)");
                    SpenObjectBase object2 = pageMerge.getObject(num2.intValue());
                    Intrinsics.checkNotNull(object2);
                    objectSyncs.add(object2);
                }
            }
        }
    }

    private final void updateListConflictBodyText(InformationConflict.BodyTextConflict bodyTextConflict, int length, boolean isInsert) {
        List<InformationConflict.BodyTextConflict> list = this.listConflictBodyText;
        Intrinsics.checkNotNull(list);
        int size = list.size();
        for (int indexOfListConflict = bodyTextConflict.getIndexOfListConflict() + 1; indexOfListConflict < size; indexOfListConflict++) {
            List<InformationConflict.BodyTextConflict> list2 = this.listConflictBodyText;
            Intrinsics.checkNotNull(list2);
            InformationConflict.BodyTextConflict bodyTextConflict2 = list2.get(indexOfListConflict);
            bodyTextConflict2.setStartMerge(bodyTextConflict2.getStartMerge() + (isInsert ? length : -length));
        }
    }

    private final void updateListConflictPage(InformationConflict.WPageConflict wPageConflict, boolean isInsert) {
        List<InformationConflict.WPageConflict> list = this.listConflictWPage;
        Intrinsics.checkNotNull(list);
        int size = list.size();
        for (int indexOfListConflict = wPageConflict.getIndexOfListConflict() + 1; indexOfListConflict < size; indexOfListConflict++) {
            List<InformationConflict.WPageConflict> list2 = this.listConflictWPage;
            Intrinsics.checkNotNull(list2);
            InformationConflict.WPageConflict wPageConflict2 = list2.get(indexOfListConflict);
            wPageConflict2.setIndexMerge(wPageConflict2.getIndexMerge() + (isInsert ? 1 : -1));
        }
        Logger.m11003i(TAG, "updateListConflictPage");
    }

    private final synchronized void updateMergeStatus() {
        try {
            if (this.isMergeBodyTextDone && this.isMergePageDone) {
                SpenWNote spenWNote = this.mNoteMerge;
                if (spenWNote != null) {
                    spenWNote.saveAsDirectory(this.mPathMerge);
                }
                notifyObservers();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final boolean editMerge(@NotNull String tag, @NotNull InformationConflict informationConflict) {
        SpenObjectTextBox bodyText;
        SpenObjectTextBox bodyText2;
        SpenObjectTextBox bodyText3;
        SpenObjectTextBox bodyText4;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(informationConflict, "informationConflict");
        this.isChangeNote = true;
        SpenWPage spenWPageInsertPage = null;
        SpenWPage spenWPageInsertPage2 = null;
        if (Intrinsics.areEqual(tag, "first")) {
            if (informationConflict.getIsActiveSync()) {
                if (informationConflict instanceof InformationConflict.WPageConflict) {
                    InformationConflict.WPageConflict wPageConflict = (InformationConflict.WPageConflict) informationConflict;
                    SpenWNote spenWNote = this.mNoteMerge;
                    wPageConflict.setPageSync(spenWNote != null ? spenWNote.getPage(wPageConflict.getIndexMerge()) : null);
                    SpenWNote spenWNote2 = this.mNoteMerge;
                    if (spenWNote2 != null) {
                        spenWNote2.removePage(wPageConflict.getIndexMerge());
                    }
                    updateListConflictPage(wPageConflict, false);
                } else if (informationConflict instanceof InformationConflict.SPenObjectConflict) {
                    InformationConflict.SPenObjectConflict sPenObjectConflict = (InformationConflict.SPenObjectConflict) informationConflict;
                    SpenWPage pageMerge = sPenObjectConflict.getPageMerge();
                    if (pageMerge != null) {
                        pageMerge.removeObjectList(sPenObjectConflict.getObjectSyncs());
                    }
                } else if (informationConflict instanceof InformationConflict.BodyTextConflict) {
                    InformationConflict.BodyTextConflict bodyTextConflict = (InformationConflict.BodyTextConflict) informationConflict;
                    int endIndexSync = bodyTextConflict.getEndIndexSync() - bodyTextConflict.getStartIndexSync();
                    SpenWNote spenWNote3 = this.mNoteMerge;
                    if (spenWNote3 != null && (bodyText4 = spenWNote3.getBodyText()) != null) {
                        bodyText4.removeText(bodyTextConflict.getStartMerge(), endIndexSync);
                    }
                    updateListConflictBodyText(bodyTextConflict, endIndexSync, false);
                }
            } else if (informationConflict instanceof InformationConflict.WPageConflict) {
                SpenWNote spenWNote4 = this.mNoteMerge;
                if (spenWNote4 != null) {
                    InformationConflict.WPageConflict wPageConflict2 = (InformationConflict.WPageConflict) informationConflict;
                    int indexMerge = wPageConflict2.getIndexMerge();
                    SpenWPage pageSync = wPageConflict2.getPageSync();
                    Integer numValueOf = pageSync != null ? Integer.valueOf(pageSync.getWidth()) : null;
                    Intrinsics.checkNotNull(numValueOf);
                    int iIntValue = numValueOf.intValue();
                    SpenWPage pageSync2 = wPageConflict2.getPageSync();
                    Integer numValueOf2 = pageSync2 != null ? Integer.valueOf(pageSync2.getHeight()) : null;
                    Intrinsics.checkNotNull(numValueOf2);
                    spenWPageInsertPage = spenWNote4.insertPage(indexMerge, iIntValue, numValueOf2.intValue());
                }
                if (spenWPageInsertPage != null) {
                    SpenWPage pageSync3 = ((InformationConflict.WPageConflict) informationConflict).getPageSync();
                    Intrinsics.checkNotNull(pageSync3);
                    spenWPageInsertPage.copy(pageSync3);
                }
                updateListConflictPage((InformationConflict.WPageConflict) informationConflict, true);
            } else if (informationConflict instanceof InformationConflict.SPenObjectConflict) {
                InformationConflict.SPenObjectConflict sPenObjectConflict2 = (InformationConflict.SPenObjectConflict) informationConflict;
                SpenWPage pageMerge2 = sPenObjectConflict2.getPageMerge();
                if (pageMerge2 != null) {
                    pageMerge2.appendObjectList(sPenObjectConflict2.getObjectSyncs());
                }
            } else if (informationConflict instanceof InformationConflict.BodyTextConflict) {
                InformationConflict.BodyTextConflict bodyTextConflict2 = (InformationConflict.BodyTextConflict) informationConflict;
                int endIndexSync2 = bodyTextConflict2.getEndIndexSync() - bodyTextConflict2.getStartIndexSync();
                SpenWNote spenWNote5 = this.mNoteMerge;
                if (spenWNote5 != null && (bodyText3 = spenWNote5.getBodyText()) != null) {
                    int startMerge = bodyTextConflict2.getStartMerge();
                    SpenWNote spenWNote6 = this.mNoteSync;
                    bodyText3.insertText(startMerge, spenWNote6 != null ? spenWNote6.getBodyText() : null, bodyTextConflict2.getStartIndexSync(), endIndexSync2);
                }
                updateListConflictBodyText(bodyTextConflict2, endIndexSync2, true);
            }
            informationConflict.setActiveSync(!informationConflict.getIsActiveSync());
            return informationConflict.getIsActiveSync();
        }
        if (informationConflict.getIsActiveLocal()) {
            if (informationConflict instanceof InformationConflict.WPageConflict) {
                InformationConflict.WPageConflict wPageConflict3 = (InformationConflict.WPageConflict) informationConflict;
                int indexMerge2 = wPageConflict3.getIndexMerge() + 1;
                SpenWNote spenWNote7 = this.mNoteMerge;
                wPageConflict3.setPageLocal(spenWNote7 != null ? spenWNote7.getPage(indexMerge2) : null);
                SpenWNote spenWNote8 = this.mNoteMerge;
                if (spenWNote8 != null) {
                    spenWNote8.removePage(indexMerge2);
                }
                updateListConflictPage(wPageConflict3, false);
            } else if (informationConflict instanceof InformationConflict.SPenObjectConflict) {
                InformationConflict.SPenObjectConflict sPenObjectConflict3 = (InformationConflict.SPenObjectConflict) informationConflict;
                SpenWPage pageMerge3 = sPenObjectConflict3.getPageMerge();
                if (pageMerge3 != null) {
                    pageMerge3.removeObjectList(sPenObjectConflict3.getObjectLocals());
                }
            } else if (informationConflict instanceof InformationConflict.BodyTextConflict) {
                InformationConflict.BodyTextConflict bodyTextConflict3 = (InformationConflict.BodyTextConflict) informationConflict;
                int endIndexLocal = bodyTextConflict3.getEndIndexLocal() - bodyTextConflict3.getStartIndexLocal();
                int startMerge2 = bodyTextConflict3.getStartMerge();
                if (informationConflict.getType() == 2 && informationConflict.getIsActiveSync()) {
                    startMerge2 += bodyTextConflict3.getEndIndexSync() - bodyTextConflict3.getStartIndexSync();
                }
                SpenWNote spenWNote9 = this.mNoteMerge;
                if (spenWNote9 != null && (bodyText2 = spenWNote9.getBodyText()) != null) {
                    bodyText2.removeText(startMerge2, endIndexLocal);
                }
                updateListConflictBodyText(bodyTextConflict3, endIndexLocal, false);
            }
        } else if (informationConflict instanceof InformationConflict.WPageConflict) {
            InformationConflict.WPageConflict wPageConflict4 = (InformationConflict.WPageConflict) informationConflict;
            int indexMerge3 = wPageConflict4.getIndexMerge() + 1;
            SpenWNote spenWNote10 = this.mNoteMerge;
            if (spenWNote10 != null) {
                SpenWPage pageLocal = wPageConflict4.getPageLocal();
                Intrinsics.checkNotNull(pageLocal);
                int width = pageLocal.getWidth();
                SpenWPage pageLocal2 = wPageConflict4.getPageLocal();
                Intrinsics.checkNotNull(pageLocal2);
                spenWPageInsertPage2 = spenWNote10.insertPage(indexMerge3, width, pageLocal2.getHeight());
            }
            if (spenWPageInsertPage2 != null) {
                SpenWPage pageLocal3 = wPageConflict4.getPageLocal();
                Intrinsics.checkNotNull(pageLocal3);
                spenWPageInsertPage2.copy(pageLocal3);
            }
            updateListConflictPage(wPageConflict4, true);
        } else if (informationConflict instanceof InformationConflict.SPenObjectConflict) {
            InformationConflict.SPenObjectConflict sPenObjectConflict4 = (InformationConflict.SPenObjectConflict) informationConflict;
            SpenWPage pageMerge4 = sPenObjectConflict4.getPageMerge();
            Intrinsics.checkNotNull(pageMerge4);
            pageMerge4.appendObjectList(sPenObjectConflict4.getObjectLocals());
        } else if (informationConflict instanceof InformationConflict.BodyTextConflict) {
            InformationConflict.BodyTextConflict bodyTextConflict4 = (InformationConflict.BodyTextConflict) informationConflict;
            int endIndexLocal2 = bodyTextConflict4.getEndIndexLocal() - bodyTextConflict4.getStartIndexLocal();
            int startMerge3 = bodyTextConflict4.getStartMerge();
            if (informationConflict.getType() == 2 && informationConflict.getIsActiveSync()) {
                startMerge3 += bodyTextConflict4.getEndIndexSync() - bodyTextConflict4.getStartIndexSync();
            }
            SpenWNote spenWNote11 = this.mNoteMerge;
            if (spenWNote11 != null && (bodyText = spenWNote11.getBodyText()) != null) {
                SpenWNote spenWNote12 = this.mNoteLocal;
                bodyText.insertText(startMerge3, spenWNote12 != null ? spenWNote12.getBodyText() : null, bodyTextConflict4.getStartIndexLocal(), endIndexLocal2);
            }
            updateListConflictBodyText(bodyTextConflict4, endIndexLocal2, true);
        }
        informationConflict.setActiveLocal(!informationConflict.getIsActiveLocal());
        return informationConflict.getIsActiveLocal();
    }

    public final void keepMerge(@NotNull SpenWNote noteLocal) {
        Intrinsics.checkNotNullParameter(noteLocal, "noteLocal");
        int i = 0;
        this.isChangeNote = false;
        SpenObjectTextBox bodyText = noteLocal.getBodyText();
        bodyText.removeAllText();
        SpenWNote spenWNote = this.mNoteMerge;
        SpenObjectTextBox bodyText2 = spenWNote != null ? spenWNote.getBodyText() : null;
        Intrinsics.checkNotNull(bodyText2);
        bodyText.copy(bodyText2);
        int pageCount = noteLocal.getPageCount();
        SpenWNote spenWNote2 = this.mNoteMerge;
        Integer numValueOf = spenWNote2 != null ? Integer.valueOf(spenWNote2.getPageCount()) : null;
        Intrinsics.checkNotNull(numValueOf);
        if (pageCount <= numValueOf.intValue()) {
            while (i < noteLocal.getPageCount()) {
                SpenWPage page = noteLocal.getPage(i);
                SpenWNote spenWNote3 = this.mNoteMerge;
                SpenWPage page2 = spenWNote3 != null ? spenWNote3.getPage(i) : null;
                Intrinsics.checkNotNull(page2);
                page.copy(page2);
                i++;
            }
            SpenWNote spenWNote4 = this.mNoteMerge;
            Integer numValueOf2 = spenWNote4 != null ? Integer.valueOf(spenWNote4.getPageCount()) : null;
            Intrinsics.checkNotNull(numValueOf2);
            if (i < numValueOf2.intValue()) {
                SpenWNote spenWNote5 = this.mNoteMerge;
                Integer numValueOf3 = spenWNote5 != null ? Integer.valueOf(spenWNote5.getPageCount()) : null;
                Intrinsics.checkNotNull(numValueOf3);
                int iIntValue = numValueOf3.intValue();
                while (i < iIntValue) {
                    SpenWNote spenWNote6 = this.mNoteMerge;
                    SpenWPage page3 = spenWNote6 != null ? spenWNote6.getPage(i) : null;
                    Integer numValueOf4 = page3 != null ? Integer.valueOf(page3.getWidth()) : null;
                    Intrinsics.checkNotNull(numValueOf4);
                    noteLocal.appendPage(numValueOf4.intValue(), page3.getHeight()).copy(page3);
                    i++;
                }
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.IObserverConflict.IMergeConflictSubject
    public void notifyObservers() {
        this.isDone = true;
        IObserverConflict iObserverConflict = this.mObserver;
        if (iObserverConflict != null) {
            iObserverConflict.onMergeDone();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.IObserverConflict.IMergeConflictSubject
    public void registerObserver(@Nullable IObserverConflict observer) {
        this.mObserver = observer;
        if (this.isDone) {
            Intrinsics.checkNotNull(observer);
            observer.onMergeDone();
        }
    }

    public final void release() {
        if (this.isChangeNote) {
            try {
                SpenWNote spenWNote = this.mNoteMerge;
                if (spenWNote != null) {
                    spenWNote.saveAsDirectory(this.mPathMerge);
                }
                this.isChangeNote = false;
            } catch (Exception e) {
                Logger.m11001e(TAG, "release error: ", e);
            }
        }
    }

    public final void setFlagStartMerge() {
        this.mFlagStartMerge = true;
        merge();
    }

    public final void setNote(@Nullable SpenWNote local, @Nullable SpenWNote sync) {
        this.mNoteLocal = local;
        this.mNoteSync = sync;
    }

    public final void setNoteMerge(@Nullable SpenWNote note, @Nullable String path) {
        this.mNoteMerge = note;
        this.mPathMerge = path;
        merge();
    }

    public final void setNoteShow(@Nullable SpenWNote note) {
        boolean z = this.mNoteMerge != null;
        this.mNoteMerge = note;
        if (z) {
            updateInfoConflict();
        }
    }

    public final void setScale(float scale) {
        this.mScale = scale;
    }
}
