package com.samsung.android.support.senl.p148nt.composer.main.compare.logic;

import android.graphics.Point;
import android.graphics.RectF;
import android.os.AsyncTask;
import com.samsung.android.sdk.mobileservice.profile.Privacy;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.compare.logic.InformationConflict;
import com.samsung.android.support.senl.p148nt.composer.main.compare.logic.page.ConflictPage;
import com.samsung.android.support.senl.p148nt.composer.main.compare.logic.page.object.CompareSPenObjectTextBox;
import com.samsung.android.support.senl.p148nt.composer.main.compare.presenter.IObserverConflict;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bitbucket.cowwoc.diffmatchpatch.DiffMatchPatch;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p188i3.RunnableC12034a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 F2\u00020\u0001:\u0001FB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fJ\b\u0010\u001a\u001a\u0004\u0018\u00010\u000fJ\u0019\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001e¢\u0006\u0002\u0010\u001fJ\u001a\u0010 \u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\t2\b\u0010\"\u001a\u0004\u0018\u00010#J\u0010\u0010$\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\tJ\b\u0010%\u001a\u00020\u001cH\u0002J\u0010\u0010&\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010\tJ(\u0010(\u001a\u0012\u0012\u0004\u0012\u00020#0)j\b\u0012\u0004\u0012\u00020#`*2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\tH\u0002JD\u0010-\u001a\u00060.j\u0002`/2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u0002010)j\b\u0012\u0004\u0012\u000201`*2\u0006\u00102\u001a\u00020.2\u0016\u00103\u001a\u0012\u0012\u0004\u0012\u0002010)j\b\u0012\u0004\u0012\u000201`*H\u0002J\u0018\u00104\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\tH\u0002J\u0016\u00105\u001a\u00020\u001c2\f\u00106\u001a\b\u0012\u0004\u0012\u00020807H\u0002J\b\u00109\u001a\u00020\u001cH\u0002J\b\u0010:\u001a\u00020\u001cH\u0016J\u0012\u0010;\u001a\u00020\u001c2\b\u0010<\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010=\u001a\u00020\u001c2\b\u0010<\u001a\u0004\u0018\u00010\u0007J!\u0010>\u001a\u0004\u0018\u00010\u00112\b\u0010?\u001a\u0004\u0018\u00010#2\b\u0010@\u001a\u0004\u0018\u00010A¢\u0006\u0002\u0010BJ\u0010\u0010C\u001a\u00020\u001c2\b\u0010+\u001a\u0004\u0018\u00010\tJ\u0006\u0010D\u001a\u00020\u001cJ\u0006\u0010E\u001a\u00020\u001cR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/CompareManager;", "Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/IObserverConflict$IConflictSubject;", "<init>", "()V", "mMergeNoteManager", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/MergeNoteManager;", "mObserver", "Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/IObserverConflict;", "mNoteSyncDown", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "mNoteLocal", "mListConflictLocation", "", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/ConflictLocation;", "mCompareBodyText", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/page/object/CompareSPenObjectTextBox;", "isCompareDone", "", "isComparePageDone", "isCompareBodyTextDone", "isStartedComparePage", "isResizeLocal", "isResizeSyncDown", "mScale", "", "getListConflictLocation", "getCompareBodyText", "setNoteToCompare", "", Privacy.KEY_NOTES, "", "([Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;)V", "setNoteMerge", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "path", "", "setNoteMergeToShow", "checkConflict", "startComparePage", "noteSync", "convertIdToCharacter", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "noteLocal", "noteSyncDown", "getStringBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "pageLocals", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "localId", "pageSyncDowns", "compareHashPage", "checkLastDiff", "diffs", "Ljava/util/LinkedList;", "Lorg/bitbucket/cowwoc/diffmatchpatch/DiffMatchPatch$Diff;", "updateStatusCompare", "notifyObservers", "registerObserver", "observer", "registerObserverMerge", "editMerge", "tag", "informationConflict", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/InformationConflict;", "(Ljava/lang/String;Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/InformationConflict;)Ljava/lang/Boolean;", "keepMerge", "onBackPressed", "release", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class CompareManager implements IObserverConflict.IConflictSubject {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "CompareManager";

    @Nullable
    private static CompareManager sInstance;
    private boolean isCompareBodyTextDone;
    private boolean isCompareDone;
    private boolean isComparePageDone;
    private boolean isResizeLocal;
    private boolean isResizeSyncDown;
    private boolean isStartedComparePage;

    @Nullable
    private CompareSPenObjectTextBox mCompareBodyText;

    @Nullable
    private List<ConflictLocation> mListConflictLocation;

    @Nullable
    private MergeNoteManager mMergeNoteManager;

    @Nullable
    private SpenWNote mNoteLocal;

    @Nullable
    private SpenWNote mNoteSyncDown;

    @Nullable
    private IObserverConflict mObserver;
    private float mScale;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/CompareManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "sInstance", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/CompareManager;", "getInstance", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized CompareManager getInstance() {
            CompareManager compareManager;
            try {
                if (CompareManager.sInstance == null) {
                    CompareManager.sInstance = new CompareManager(null);
                }
                compareManager = CompareManager.sInstance;
                Intrinsics.checkNotNull(compareManager);
            } catch (Throwable th) {
                throw th;
            }
            return compareManager;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DiffMatchPatch.Operation.values().length];
            try {
                iArr[DiffMatchPatch.Operation.DELETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DiffMatchPatch.Operation.INSERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ CompareManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void checkConflict() {
        boolean z;
        Logger.m11003i(TAG, "checkConflict start");
        SpenWNote spenWNote = this.mNoteSyncDown;
        if (spenWNote == null || this.mNoteLocal == null) {
            return;
        }
        Intrinsics.checkNotNull(spenWNote);
        boolean z2 = false;
        float width = spenWNote.getPage(0).getWidth();
        Intrinsics.checkNotNull(this.mNoteLocal);
        float width2 = width / r3.getPage(0).getWidth();
        this.mScale = width2;
        MergeNoteManager mergeNoteManager = this.mMergeNoteManager;
        if (mergeNoteManager != null) {
            mergeNoteManager.setScale(width2);
        }
        SpenWNote spenWNote2 = this.mNoteLocal;
        Intrinsics.checkNotNull(spenWNote2);
        if (spenWNote2.getBodyTextFontSizeDelta() != 0) {
            SpenWNote spenWNote3 = this.mNoteLocal;
            Intrinsics.checkNotNull(spenWNote3);
            z = spenWNote3.getBodyTextFontSizeDelta() != -5;
        }
        this.isResizeLocal = z;
        SpenWNote spenWNote4 = this.mNoteSyncDown;
        Intrinsics.checkNotNull(spenWNote4);
        if (spenWNote4.getBodyTextFontSizeDelta() != 0) {
            SpenWNote spenWNote5 = this.mNoteSyncDown;
            Intrinsics.checkNotNull(spenWNote5);
            if (spenWNote5.getBodyTextFontSizeDelta() != -5) {
                z2 = true;
            }
        }
        this.isResizeSyncDown = z2;
        if (!z2) {
            startComparePage(this.mNoteSyncDown);
        } else if (this.isResizeLocal) {
            this.isComparePageDone = true;
            this.isStartedComparePage = true;
        }
        SpenWNote spenWNote6 = this.mNoteLocal;
        Intrinsics.checkNotNull(spenWNote6);
        SpenObjectTextBox bodyText = spenWNote6.getBodyText();
        SpenWNote spenWNote7 = this.mNoteSyncDown;
        Intrinsics.checkNotNull(spenWNote7);
        SpenObjectTextBox bodyText2 = spenWNote7.getBodyText();
        if (bodyText != null && bodyText2 != null && bodyText.getModifiedTime() != bodyText2.getModifiedTime()) {
            CompareSPenObjectTextBox compareSPenObjectTextBox = new CompareSPenObjectTextBox();
            this.mCompareBodyText = compareSPenObjectTextBox;
            Intrinsics.checkNotNull(compareSPenObjectTextBox);
            compareSPenObjectTextBox.compareTextBox(bodyText, bodyText2);
        }
        this.isCompareBodyTextDone = true;
        Logger.m11003i(TAG, "checkConflict body text done");
        updateStatusCompare();
    }

    private final void checkLastDiff(LinkedList<DiffMatchPatch.Diff> diffs) {
        DiffMatchPatch.Diff diff = diffs.get(diffs.size() - 1);
        Intrinsics.checkNotNullExpressionValue(diff, "get(...)");
        DiffMatchPatch.Diff diff2 = diff;
        DiffMatchPatch.Diff diff3 = diffs.get(diffs.size() - 2);
        Intrinsics.checkNotNullExpressionValue(diff3, "get(...)");
        DiffMatchPatch.Diff diff4 = diff3;
        diffs.removeLast();
        diffs.removeLast();
        if (diff2.text.length() < diff4.text.length()) {
            diff2.operation = DiffMatchPatch.Operation.EQUAL;
            diffs.add(diff2);
            String text = diff4.text;
            Intrinsics.checkNotNullExpressionValue(text, "text");
            String strSubstring = text.substring(0, diff4.text.length() - diff2.text.length());
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            diff4.text = strSubstring;
            diffs.add(diff4);
            return;
        }
        diff4.operation = DiffMatchPatch.Operation.EQUAL;
        diffs.add(diff4);
        if (diff2.text.length() > diff4.text.length()) {
            String text2 = diff2.text;
            Intrinsics.checkNotNullExpressionValue(text2, "text");
            String strSubstring2 = text2.substring(0, diff2.text.length() - diff4.text.length());
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            diff2.text = strSubstring2;
            diffs.add(diff2);
        }
    }

    private final void compareHashPage(SpenWNote noteLocal, SpenWNote noteSyncDown) {
        Point point;
        int i;
        Logger.m11003i(TAG, "compareHashPage");
        ArrayList<String> arrayListConvertIdToCharacter = convertIdToCharacter(noteLocal, noteSyncDown);
        int i2 = 0;
        String str = arrayListConvertIdToCharacter.get(0);
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        boolean z = true;
        String str2 = arrayListConvertIdToCharacter.get(1);
        Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
        LinkedList<DiffMatchPatch.Diff> linkedListDiffMain = new DiffMatchPatch().diffMain(str, str2);
        this.mListConflictLocation = new ArrayList();
        int i4 = 2;
        if (linkedListDiffMain.size() > 1) {
            DiffMatchPatch.Operation operation = linkedListDiffMain.get(linkedListDiffMain.size() - 1).operation;
            DiffMatchPatch.Operation operation2 = DiffMatchPatch.Operation.EQUAL;
            if (operation != operation2 && linkedListDiffMain.get(linkedListDiffMain.size() - 2).operation != operation2) {
                Intrinsics.checkNotNull(linkedListDiffMain);
                checkLastDiff(linkedListDiffMain);
            }
        }
        int size = linkedListDiffMain.size();
        int i5 = 0;
        SpenWPage spenWPage = null;
        SpenWPage spenWPage2 = null;
        int i6 = -1;
        int i7 = -1;
        while (i5 < size) {
            DiffMatchPatch.Diff diff = linkedListDiffMain.get(i5);
            DiffMatchPatch.Operation operation3 = diff.operation;
            int i8 = operation3 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[operation3.ordinal()];
            if (i8 != z) {
                if (i8 != i4) {
                    int i9 = i2;
                    while (i9 < diff.text.length()) {
                        int i10 = i6 + 1;
                        int i11 = i7 + 1;
                        SpenWNote spenWNote = this.mNoteSyncDown;
                        Intrinsics.checkNotNull(spenWNote);
                        SpenWPage page = spenWNote.getPage(i11);
                        SpenWNote spenWNote2 = this.mNoteLocal;
                        Intrinsics.checkNotNull(spenWNote2);
                        SpenWPage page2 = spenWNote2.getPage(i10);
                        int i12 = page.getOffset().y;
                        Intrinsics.checkNotNull(this.mNoteSyncDown);
                        float pageVerticalPadding = (i12 - (r14.getPageVerticalPadding() * i11)) / this.mScale;
                        Intrinsics.checkNotNull(this.mNoteLocal);
                        ConflictPage conflictPage = new ConflictPage(2, i10, i11, page, page2, this.mScale);
                        conflictPage.setOffSetY(pageVerticalPadding + (r14.getPageVerticalPadding() * i11));
                        conflictPage.checkConflictPage();
                        if (conflictPage.isConflict()) {
                            if (conflictPage.getIsConflictBackground()) {
                                ConflictLocation conflictLocation = new ConflictLocation(i4, z, ConflictPage.INSTANCE.scalePoint(page.getOffset(), this.mScale), page2.getOffset());
                                InformationConflict.WPageConflict wPageConflict = new InformationConflict.WPageConflict();
                                wPageConflict.setType(i4);
                                wPageConflict.setConflictPage(conflictPage);
                                conflictLocation.setMInformationConflict(wPageConflict);
                                List<ConflictLocation> list = this.mListConflictLocation;
                                if (list != null) {
                                    list.add(conflictLocation);
                                }
                            }
                            List<ConflictLocation> list2 = this.mListConflictLocation;
                            if (list2 != null) {
                                list2.addAll(conflictPage.getListLocations());
                            }
                        }
                        i9++;
                        i6 = i10;
                        i7 = i11;
                        spenWPage = page;
                        spenWPage2 = page2;
                    }
                } else {
                    Point offset = spenWPage2 != null ? spenWPage2.getOffset() : new Point(i2, i2);
                    int i13 = i2;
                    while (i13 < diff.text.length()) {
                        int i14 = i13;
                        int i15 = i7 + 1;
                        SpenWNote spenWNote3 = this.mNoteSyncDown;
                        Intrinsics.checkNotNull(spenWNote3);
                        SpenWPage page3 = spenWNote3.getPage(i15);
                        DiffMatchPatch.Diff diff2 = diff;
                        Point point2 = offset;
                        ConflictPage conflictPage2 = new ConflictPage(0, i6, i15, page3, null, this.mScale);
                        int i16 = page3.getOffset().y;
                        Intrinsics.checkNotNull(this.mNoteSyncDown);
                        float pageVerticalPadding2 = (i16 - (r7.getPageVerticalPadding() * i15)) / this.mScale;
                        Intrinsics.checkNotNull(this.mNoteLocal);
                        float pageVerticalPadding3 = pageVerticalPadding2 + (r12.getPageVerticalPadding() * i15);
                        RectF rectF = new RectF(0.0f, pageVerticalPadding3, page3.getWidth() / this.mScale, (page3.getHeight() / this.mScale) + pageVerticalPadding3);
                        ConflictLocation conflictLocation2 = new ConflictLocation(0, true, new Point((int) rectF.left, (int) rectF.top), point2);
                        InformationConflict.WPageConflict wPageConflict2 = new InformationConflict.WPageConflict();
                        wPageConflict2.setType(0);
                        wPageConflict2.setConflictPage(conflictPage2);
                        conflictLocation2.setMInformationConflict(wPageConflict2);
                        conflictLocation2.setObjectRectF(null, rectF);
                        List<ConflictLocation> list3 = this.mListConflictLocation;
                        if (list3 != null) {
                            list3.add(conflictLocation2);
                        }
                        int i17 = i14 + 1;
                        diff = diff2;
                        offset = point2;
                        i7 = i15;
                        spenWPage = page3;
                        i13 = i17;
                        i2 = 0;
                    }
                }
                i = i2;
            } else {
                if (spenWPage != null) {
                    point = spenWPage.getOffset();
                    i = 0;
                } else {
                    i = 0;
                    point = new Point(0, 0);
                }
                int i18 = i;
                while (i18 < diff.text.length()) {
                    int i19 = i6 + 1;
                    SpenWNote spenWNote4 = this.mNoteLocal;
                    Intrinsics.checkNotNull(spenWNote4);
                    SpenWPage page4 = spenWNote4.getPage(i19);
                    ConflictPage conflictPage3 = new ConflictPage(1, i19, i7, null, page4, this.mScale);
                    Point offset2 = page4.getOffset();
                    ConflictLocation conflictLocation3 = new ConflictLocation(1, true, ConflictPage.INSTANCE.scalePoint(point, this.mScale), offset2);
                    InformationConflict.WPageConflict wPageConflict3 = new InformationConflict.WPageConflict();
                    wPageConflict3.setType(1);
                    wPageConflict3.setConflictPage(conflictPage3);
                    conflictLocation3.setMInformationConflict(wPageConflict3);
                    conflictLocation3.setObjectRectF(new RectF(offset2.x, offset2.y, page4.getWidth() + r12, page4.getHeight() + offset2.y), null);
                    List<ConflictLocation> list4 = this.mListConflictLocation;
                    if (list4 != null) {
                        list4.add(conflictLocation3);
                    }
                    i18++;
                    i6 = i19;
                    spenWPage2 = page4;
                }
            }
            i5++;
            i2 = i;
            i4 = 2;
            z = true;
        }
        this.isComparePageDone = z;
        updateStatusCompare();
    }

    private final ArrayList<String> convertIdToCharacter(SpenWNote noteLocal, SpenWNote noteSyncDown) {
        ArrayList<SpenWPage> pageList = noteLocal.getPageList();
        ArrayList<SpenWPage> pageList2 = noteSyncDown.getPageList();
        StringBuilder sb = new StringBuilder();
        StringBuilder stringBuilder = getStringBuilder(pageList, sb, pageList2);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(sb.toString());
        arrayList.add(stringBuilder.toString());
        return arrayList;
    }

    private final StringBuilder getStringBuilder(ArrayList<SpenWPage> pageLocals, StringBuilder localId, ArrayList<SpenWPage> pageSyncDowns) {
        StringBuilder sb = new StringBuilder();
        HashMap map = new HashMap();
        int size = pageLocals.size() - 1;
        char c = 1;
        for (int i = 0; i < size; i++) {
            SpenWPage spenWPage = pageLocals.get(i);
            Intrinsics.checkNotNullExpressionValue(spenWPage, "get(...)");
            localId.append(c);
            map.put(spenWPage.getId(), Character.valueOf(c));
            c = (char) (c + 1);
        }
        int size2 = pageSyncDowns.size() - 1;
        for (int i2 = 0; i2 < size2; i2++) {
            SpenWPage spenWPage2 = pageSyncDowns.get(i2);
            Intrinsics.checkNotNullExpressionValue(spenWPage2, "get(...)");
            String id = spenWPage2.getId();
            if (!map.containsKey(id)) {
                map.put(id, Character.valueOf(c));
                c = (char) (c + 1);
            }
            sb.append(map.get(id));
        }
        return sb;
    }

    private final synchronized void updateStatusCompare() {
        try {
            if (this.isComparePageDone && this.isCompareBodyTextDone) {
                MergeNoteManager mergeNoteManager = this.mMergeNoteManager;
                if (mergeNoteManager != null) {
                    Intrinsics.checkNotNull(mergeNoteManager);
                    mergeNoteManager.setFlagStartMerge();
                }
                notifyObservers();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Nullable
    public final Boolean editMerge(@Nullable String tag, @Nullable InformationConflict informationConflict) {
        MergeNoteManager mergeNoteManager;
        if (tag == null || informationConflict == null || (mergeNoteManager = this.mMergeNoteManager) == null) {
            return null;
        }
        return Boolean.valueOf(mergeNoteManager.editMerge(tag, informationConflict));
    }

    @Nullable
    public final CompareSPenObjectTextBox getCompareBodyText() {
        CompareSPenObjectTextBox compareSPenObjectTextBox = this.mCompareBodyText;
        Intrinsics.checkNotNull(compareSPenObjectTextBox);
        return compareSPenObjectTextBox;
    }

    @Nullable
    public final List<ConflictLocation> getListConflictLocation() {
        List<ConflictLocation> list = this.mListConflictLocation;
        Intrinsics.checkNotNull(list);
        return list;
    }

    public final void keepMerge(@Nullable SpenWNote noteLocal) {
        if (noteLocal != null) {
            MergeNoteManager mergeNoteManager = this.mMergeNoteManager;
            Intrinsics.checkNotNull(mergeNoteManager);
            mergeNoteManager.keepMerge(noteLocal);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.IObserverConflict.IConflictSubject
    public void notifyObservers() {
        this.isCompareDone = true;
        IObserverConflict iObserverConflict = this.mObserver;
        if (iObserverConflict != null) {
            iObserverConflict.onConflictCheckDone();
        }
    }

    public final void onBackPressed() {
        MergeNoteManager mergeNoteManager = this.mMergeNoteManager;
        if (mergeNoteManager != null) {
            mergeNoteManager.release();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.IObserverConflict.IConflictSubject
    public void registerObserver(@Nullable IObserverConflict observer) {
        this.mObserver = observer;
        if (!this.isCompareDone || observer == null) {
            return;
        }
        observer.onConflictCheckDone();
    }

    public final void registerObserverMerge(@Nullable IObserverConflict observer) {
        MergeNoteManager mergeNoteManager = this.mMergeNoteManager;
        if (mergeNoteManager != null) {
            mergeNoteManager.registerObserver(observer);
        }
    }

    public final void release() {
        Logger.m10999d(TAG, "release");
        sInstance = null;
        this.mMergeNoteManager = null;
        this.mListConflictLocation = null;
        this.mCompareBodyText = null;
        this.mObserver = null;
        this.mNoteLocal = null;
        this.mNoteSyncDown = null;
    }

    public final void setNoteMerge(@Nullable SpenWNote note, @Nullable String path) {
        MergeNoteManager mergeNoteManager = this.mMergeNoteManager;
        Intrinsics.checkNotNull(mergeNoteManager);
        mergeNoteManager.setNoteMerge(note, path);
    }

    public final void setNoteMergeToShow(@Nullable SpenWNote note) {
        MergeNoteManager mergeNoteManager = this.mMergeNoteManager;
        Intrinsics.checkNotNull(mergeNoteManager);
        mergeNoteManager.setNoteShow(note);
    }

    public final void setNoteToCompare(@NotNull SpenWNote[] notes) {
        Intrinsics.checkNotNullParameter(notes, "notes");
        SpenWNote spenWNote = notes[0];
        this.mNoteSyncDown = spenWNote;
        SpenWNote spenWNote2 = notes[1];
        this.mNoteLocal = spenWNote2;
        MergeNoteManager mergeNoteManager = this.mMergeNoteManager;
        if (mergeNoteManager != null) {
            mergeNoteManager.setNote(spenWNote2, spenWNote);
        }
        AsyncTask.execute(new RunnableC12034a(this, 14));
    }

    public final void startComparePage(@Nullable SpenWNote noteSync) {
        if (this.isStartedComparePage) {
            return;
        }
        this.isStartedComparePage = true;
        SpenWNote spenWNote = this.mNoteLocal;
        if (spenWNote == null || noteSync == null) {
            return;
        }
        Intrinsics.checkNotNull(spenWNote);
        compareHashPage(spenWNote, noteSync);
    }

    private CompareManager() {
        this.mScale = 1.0f;
        this.mMergeNoteManager = new MergeNoteManager();
    }
}
