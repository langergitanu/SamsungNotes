package com.samsung.android.support.senl.p148nt.composer.main.compare.presenter;

import android.graphics.Point;
import android.graphics.RectF;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.compare.logic.CompareManager;
import com.samsung.android.support.senl.p148nt.composer.main.compare.logic.ConflictLocation;
import com.samsung.android.support.senl.p148nt.composer.main.compare.logic.InformationConflict;
import com.samsung.android.support.senl.p148nt.composer.main.compare.logic.page.object.CompareSPenObjectTextBox;
import com.samsung.android.support.senl.p148nt.composer.main.compare.presenter.CompareViewerContract;
import com.samsung.scsp.common.Header;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 22\u00020\u0001:\u00012B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003J\u0013\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u0018H\u0002¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u001bH\u0002J\u0018\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0002J\u0016\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020\u001bJ\u0006\u0010+\u001a\u00020\u001bJ\b\u0010,\u001a\u00020\u001bH\u0002J\b\u0010-\u001a\u00020\u001bH\u0002J\u0012\u0010.\u001a\u0004\u0018\u00010$2\u0006\u0010/\u001a\u00020\u0010H\u0002J\u0015\u00100\u001a\u0004\u0018\u00010\u00162\u0006\u0010(\u001a\u00020)¢\u0006\u0002\u00101R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0018X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019¨\u00063"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/MultiScrollPresenter;", "", "firstFragment", "Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/CompareViewerContract$IViewerFragment;", "secondFragment", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/CompareViewerContract$IViewerFragment;Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/CompareViewerContract$IViewerFragment;)V", "DEFAULT_ZOOM", "", "mPrePanLeft", "mPrePanRight", "mFirstFragment", "mSecondFragment", "mMergeFragment", "mListLocationConflict", "", "Lcom/samsung/android/support/senl/nt/composer/main/compare/logic/ConflictLocation;", "mViewCompare", "Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/CompareViewerContract$IViewCompare;", "mCurrentLocationConflict", "", "isStartedConflictList", "", "mCounterConflict", "", "[Ljava/lang/Integer;", "init", "", "iViewCompare", "setMergeFragment", "fragment", "updateNumberOfConflict", "()[Ljava/lang/Integer;", "updateConflictLocation", "comparePoint", "o1", "Landroid/graphics/Point;", "o2", "onScrollChanged", "panY", "tag", "", "onNextClick", "onPrevClick", "updateMenuButton", "scrollToLocation", "getMergeLocation", Header.LOCATION, "onClickEditMerge", "(Ljava/lang/String;)Ljava/lang/Boolean;", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMultiScrollPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultiScrollPresenter.kt\ncom/samsung/android/support/senl/nt/composer/main/compare/presenter/MultiScrollPresenter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,323:1\n1#2:324\n*E\n"})
public final class MultiScrollPresenter {

    @NotNull
    private static final String TAG;
    private final float DEFAULT_ZOOM;
    private boolean isStartedConflictList;

    @NotNull
    private Integer[] mCounterConflict;
    private int mCurrentLocationConflict;

    @Nullable
    private CompareViewerContract.IViewerFragment mFirstFragment;

    @Nullable
    private List<ConflictLocation> mListLocationConflict;

    @Nullable
    private CompareViewerContract.IViewerFragment mMergeFragment;
    private float mPrePanLeft;
    private float mPrePanRight;

    @Nullable
    private CompareViewerContract.IViewerFragment mSecondFragment;

    @Nullable
    private CompareViewerContract.IViewCompare mViewCompare;

    static {
        String strCreateTag = Logger.createTag("MultiScrollPresenter");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public MultiScrollPresenter(@Nullable CompareViewerContract.IViewerFragment iViewerFragment, @NotNull CompareViewerContract.IViewerFragment secondFragment) {
        Intrinsics.checkNotNullParameter(secondFragment, "secondFragment");
        this.DEFAULT_ZOOM = 1.0f;
        this.mFirstFragment = iViewerFragment;
        this.mSecondFragment = secondFragment;
        this.mCurrentLocationConflict = -1;
        Integer[] numArr = new Integer[3];
        for (int i = 0; i < 3; i++) {
            numArr[i] = 0;
        }
        this.mCounterConflict = numArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int comparePoint(Point o12, Point o22) {
        int i = o12.y;
        int i2 = o22.y;
        return i != i2 ? i - i2 : o12.x - o22.x;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Point getMergeLocation(ConflictLocation location) {
        RectF rectF;
        RectF rectF2;
        RectF rectF3;
        RectF rectF4;
        InformationConflict mInformationConflict = location.getMInformationConflict();
        RectF rectF5 = null;
        rectF = null;
        RectF rectF6 = null;
        rectF5 = null;
        if (this.mMergeFragment != null) {
            if ((mInformationConflict == null || !mInformationConflict.getIsActiveSync()) && (mInformationConflict == null || !mInformationConflict.getIsActiveLocal())) {
                location.setMRectMerges(new ArrayList<>());
            } else {
                if (mInformationConflict instanceof InformationConflict.BodyTextConflict) {
                    InformationConflict.BodyTextConflict bodyTextConflict = (InformationConflict.BodyTextConflict) mInformationConflict;
                    int startMerge = bodyTextConflict.getStartMerge() + (bodyTextConflict.getIsActiveLocal() ? bodyTextConflict.getEndIndexLocal() - bodyTextConflict.getStartIndexLocal() : 0) + (bodyTextConflict.getIsActiveSync() ? bodyTextConflict.getEndIndexSync() - bodyTextConflict.getStartIndexSync() : 0);
                    CompareViewerContract.IViewerFragment iViewerFragment = this.mMergeFragment;
                    Intrinsics.checkNotNull(iViewerFragment);
                    ArrayList<RectF> textRectFromIndex = iViewerFragment.getTextRectFromIndex(bodyTextConflict.getStartMerge(), startMerge);
                    location.setMRectMerges(textRectFromIndex);
                    RectF rectF7 = textRectFromIndex.get(0);
                    if (rectF7 != null) {
                        return new Point((int) rectF7.left, (int) rectF7.top);
                    }
                    return null;
                }
                if (mInformationConflict instanceof InformationConflict.WPageConflict) {
                    ArrayList<RectF> arrayList = new ArrayList<>();
                    location.setMRectMerges(arrayList);
                    InformationConflict.WPageConflict wPageConflict = (InformationConflict.WPageConflict) mInformationConflict;
                    if (wPageConflict.getIsActiveLocal()) {
                        SpenWPage pageLocal = wPageConflict.getPageLocal();
                        Point offset = pageLocal != null ? pageLocal.getOffset() : null;
                        if (offset != null) {
                            float f = offset.y;
                            SpenWPage pageLocal2 = wPageConflict.getPageLocal();
                            Integer numValueOf = pageLocal2 != null ? Integer.valueOf(pageLocal2.getWidth()) : null;
                            Intrinsics.checkNotNull(numValueOf);
                            float fIntValue = numValueOf.intValue();
                            int i = offset.y;
                            SpenWPage pageLocal3 = wPageConflict.getPageLocal();
                            Intrinsics.checkNotNull(pageLocal3 != null ? Integer.valueOf(pageLocal3.getHeight()) : null);
                            rectF3 = new RectF(0.0f, f, fIntValue, r8.intValue() + i);
                            arrayList.add(rectF3);
                        }
                    } else {
                        rectF3 = null;
                    }
                    if (wPageConflict.getIsActiveSync()) {
                        SpenWPage pageSync = wPageConflict.getPageSync();
                        Point offset2 = pageSync != null ? pageSync.getOffset() : null;
                        if (offset2 != null) {
                            float f4 = offset2.y;
                            SpenWPage pageSync2 = wPageConflict.getPageSync();
                            Integer numValueOf2 = pageSync2 != null ? Integer.valueOf(pageSync2.getWidth()) : null;
                            Intrinsics.checkNotNull(numValueOf2);
                            float fIntValue2 = numValueOf2.intValue();
                            int i2 = offset2.y;
                            SpenWPage pageSync3 = wPageConflict.getPageSync();
                            Intrinsics.checkNotNull(pageSync3 != null ? Integer.valueOf(pageSync3.getHeight()) : null);
                            RectF rectF8 = new RectF(0.0f, f4, fIntValue2, r2.intValue() + i2);
                            arrayList.add(rectF8);
                            rectF6 = rectF8;
                        }
                    }
                    if (rectF3 == null || rectF6 == null) {
                        rectF4 = rectF3 != null ? new RectF(rectF3) : new RectF(rectF6);
                    } else {
                        rectF4 = new RectF(0.0f, rectF6.top, rectF6.right, rectF3.bottom);
                    }
                    arrayList.add(0, rectF4);
                    return new Point((int) rectF4.left, (int) rectF4.top);
                }
                if (mInformationConflict instanceof InformationConflict.SPenObjectConflict) {
                    ArrayList<RectF> arrayList2 = new ArrayList<>();
                    location.setMRectMerges(arrayList2);
                    InformationConflict.SPenObjectConflict sPenObjectConflict = (InformationConflict.SPenObjectConflict) mInformationConflict;
                    SpenWPage pageMerge = sPenObjectConflict.getPageMerge();
                    Point offset3 = pageMerge != null ? pageMerge.getOffset() : null;
                    if (sPenObjectConflict.getIsActiveLocal()) {
                        Iterator<SpenObjectBase> it = sPenObjectConflict.getObjectLocals().iterator();
                        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                        rectF = null;
                        while (it.hasNext()) {
                            SpenObjectBase next = it.next();
                            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                            RectF rect = next.getRect();
                            if (rectF == null) {
                                rectF = new RectF(rect);
                            } else {
                                rectF.top = Math.min(rectF.top, rect.top);
                                rectF.bottom = Math.max(rectF.bottom, rect.bottom);
                                rectF.left = Math.min(rectF.left, rect.left);
                                rectF.right = Math.max(rectF.right, rect.right);
                            }
                        }
                        if (offset3 != null && rectF != null) {
                            float f5 = rectF.top;
                            int i4 = offset3.y;
                            rectF.top = f5 + i4;
                            rectF.bottom += i4;
                        }
                        arrayList2.add(rectF);
                    } else {
                        rectF = null;
                    }
                    if (sPenObjectConflict.getIsActiveSync()) {
                        Iterator<SpenObjectBase> it2 = sPenObjectConflict.getObjectSyncs().iterator();
                        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                        while (it2.hasNext()) {
                            SpenObjectBase next2 = it2.next();
                            Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                            RectF rect2 = next2.getRect();
                            if (rectF5 == null) {
                                rectF5 = new RectF(rect2);
                            } else {
                                rectF5.top = Math.min(rectF5.top, rect2.top);
                                rectF5.bottom = Math.max(rectF5.bottom, rect2.bottom);
                                rectF5.left = Math.min(rectF5.left, rect2.left);
                                rectF5.right = Math.max(rectF5.right, rect2.right);
                            }
                        }
                        if (offset3 != null && rectF5 != null) {
                            float f6 = rectF5.top;
                            int i5 = offset3.y;
                            rectF5.top = f6 + i5;
                            rectF5.bottom += i5;
                        }
                        arrayList2.add(rectF5);
                    }
                    if (rectF == null || rectF5 == null) {
                        rectF2 = rectF != null ? new RectF(rectF) : new RectF(rectF5);
                    } else {
                        rectF2 = new RectF(Math.min(rectF.left, rectF5.left), Math.min(rectF.top, rectF5.top), Math.max(rectF.right, rectF5.right), Math.max(rectF.bottom, rectF5.bottom));
                    }
                    arrayList2.add(0, rectF2);
                    return new Point((int) rectF2.left, (int) rectF2.top);
                }
            }
        }
        return null;
    }

    private final void scrollToLocation() {
        CompareViewerContract.IViewerFragment iViewerFragment;
        CompareViewerContract.IViewerFragment iViewerFragment2;
        CompareViewerContract.IViewerFragment iViewerFragment3;
        CompareViewerContract.IViewerFragment iViewerFragment4;
        CompareViewerContract.IViewerFragment iViewerFragment5;
        CompareViewerContract.IViewerFragment iViewerFragment6;
        if (!this.isStartedConflictList) {
            updateConflictLocation();
            this.isStartedConflictList = true;
        }
        updateMenuButton();
        List<ConflictLocation> list = this.mListLocationConflict;
        ConflictLocation conflictLocation = list != null ? list.get(this.mCurrentLocationConflict) : null;
        if (conflictLocation != null) {
            CompareViewerContract.IViewerFragment iViewerFragment7 = this.mFirstFragment;
            if (iViewerFragment7 != null) {
                iViewerFragment7.setZoomScale(this.DEFAULT_ZOOM);
            }
            CompareViewerContract.IViewerFragment iViewerFragment8 = this.mSecondFragment;
            if (iViewerFragment8 != null) {
                iViewerFragment8.setZoomScale(this.DEFAULT_ZOOM);
            }
            CompareViewerContract.IViewerFragment iViewerFragment9 = this.mMergeFragment;
            if (iViewerFragment9 != null) {
                iViewerFragment9.setZoomScale(this.DEFAULT_ZOOM);
            }
            Point mPointLocal = conflictLocation.getMPointLocal();
            Integer numValueOf = mPointLocal != null ? Integer.valueOf(mPointLocal.y) : null;
            Intrinsics.checkNotNull(numValueOf);
            float fIntValue = numValueOf.intValue();
            CompareViewerContract.IViewerFragment iViewerFragment10 = this.mSecondFragment;
            Intrinsics.checkNotNull(iViewerFragment10 != null ? iViewerFragment10.getEditBtnHeight() : null);
            float fIntValue2 = fIntValue - (r3.intValue() * 1.2f);
            this.mPrePanLeft = fIntValue2;
            if (fIntValue2 < 0.0f) {
                this.mPrePanLeft = 0.0f;
            }
            Point mPointSync = conflictLocation.getMPointSync();
            Integer numValueOf2 = mPointSync != null ? Integer.valueOf(mPointSync.y) : null;
            Intrinsics.checkNotNull(numValueOf2);
            float fIntValue3 = numValueOf2.intValue();
            CompareViewerContract.IViewerFragment iViewerFragment11 = this.mFirstFragment;
            Intrinsics.checkNotNull(iViewerFragment11 != null ? iViewerFragment11.getEditBtnHeight() : null);
            float fIntValue4 = fIntValue3 - (r5.intValue() * 1.2f);
            this.mPrePanRight = fIntValue4;
            if (fIntValue4 < 0.0f) {
                this.mPrePanRight = 0.0f;
            }
            CompareViewerContract.IViewerFragment iViewerFragment12 = this.mFirstFragment;
            if (iViewerFragment12 != null) {
                Point mPointSync2 = conflictLocation.getMPointSync();
                Intrinsics.checkNotNull(mPointSync2 != null ? Integer.valueOf(mPointSync2.x) : null);
                iViewerFragment12.setScrollView(r3.intValue(), this.mPrePanRight);
            }
            CompareViewerContract.IViewerFragment iViewerFragment13 = this.mSecondFragment;
            if (iViewerFragment13 != null) {
                Point mPointLocal2 = conflictLocation.getMPointLocal();
                Intrinsics.checkNotNull(mPointLocal2 != null ? Integer.valueOf(mPointLocal2.x) : null);
                iViewerFragment13.setScrollView(r1.intValue(), this.mPrePanLeft);
            }
            if (getMergeLocation(conflictLocation) != null && (iViewerFragment6 = this.mMergeFragment) != null) {
                iViewerFragment6.setScrollView(r1.x, r1.y);
            }
            ArrayList<RectF> mRectMerges = conflictLocation.getMRectMerges();
            if (mRectMerges != null && (iViewerFragment5 = this.mMergeFragment) != null) {
                iViewerFragment5.drawHighlight(mRectMerges, conflictLocation.getMType());
            }
            ArrayList<RectF> mRectSyncs = conflictLocation.getMRectSyncs();
            if (mRectSyncs != null && (iViewerFragment4 = this.mFirstFragment) != null) {
                iViewerFragment4.drawHighlight(mRectSyncs, conflictLocation.getMType());
            }
            InformationConflict mInformationConflict = conflictLocation.getMInformationConflict();
            if (mInformationConflict != null && (iViewerFragment3 = this.mFirstFragment) != null) {
                iViewerFragment3.setViewEditMergeButton(mInformationConflict.getIsActiveSync());
            }
            ArrayList<RectF> mRectLocals = conflictLocation.getMRectLocals();
            if (mRectLocals != null && (iViewerFragment2 = this.mSecondFragment) != null) {
                iViewerFragment2.drawHighlight(mRectLocals, conflictLocation.getMType());
            }
            InformationConflict mInformationConflict2 = conflictLocation.getMInformationConflict();
            if (mInformationConflict2 == null || (iViewerFragment = this.mSecondFragment) == null) {
                return;
            }
            iViewerFragment.setViewEditMergeButton(mInformationConflict2.getIsActiveLocal());
        }
    }

    private final void updateConflictLocation() {
        List<ConflictLocation> list;
        SpenWNote note;
        SpenWNote note2;
        CompareManager companion = CompareManager.INSTANCE.getInstance();
        Intrinsics.checkNotNull(companion);
        CompareSPenObjectTextBox compareBodyText = companion.getCompareBodyText();
        if (this.mSecondFragment != null) {
            CompareViewerContract.IViewerFragment iViewerFragment = this.mFirstFragment;
            Integer numValueOf = (iViewerFragment == null || (note2 = iViewerFragment.getNote()) == null) ? null : Integer.valueOf(note2.getPageVerticalPadding());
            CompareViewerContract.IViewerFragment iViewerFragment2 = this.mSecondFragment;
            Intrinsics.checkNotNull(iViewerFragment2);
            SpenWNote note3 = iViewerFragment2.getNote();
            if (!Intrinsics.areEqual(numValueOf, note3 != null ? Integer.valueOf(note3.getPageVerticalPadding()) : null)) {
                CompareViewerContract.IViewerFragment iViewerFragment3 = this.mFirstFragment;
                if (iViewerFragment3 != null && (note = iViewerFragment3.getNote()) != null) {
                    CompareViewerContract.IViewerFragment iViewerFragment4 = this.mSecondFragment;
                    Intrinsics.checkNotNull(iViewerFragment4);
                    SpenWNote note4 = iViewerFragment4.getNote();
                    Intrinsics.checkNotNull(note4);
                    note.setPageVerticalPadding(note4.getPageVerticalPadding());
                }
                CompareViewerContract.IViewerFragment iViewerFragment5 = this.mFirstFragment;
                if (iViewerFragment5 != null) {
                    iViewerFragment5.requestPageLayout();
                }
            }
        }
        this.mListLocationConflict = new ArrayList();
        List<ConflictLocation> listConflictLocation = compareBodyText != null ? compareBodyText.getListConflictLocation() : null;
        if (listConflictLocation != null) {
            for (ConflictLocation conflictLocation : listConflictLocation) {
                InformationConflict mInformationConflict = conflictLocation.getMInformationConflict();
                Intrinsics.checkNotNull(mInformationConflict, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.composer.main.compare.logic.InformationConflict.BodyTextConflict");
                InformationConflict.BodyTextConflict bodyTextConflict = (InformationConflict.BodyTextConflict) mInformationConflict;
                CompareViewerContract.IViewerFragment iViewerFragment6 = this.mSecondFragment;
                ArrayList<RectF> textRectFromIndex = iViewerFragment6 != null ? iViewerFragment6.getTextRectFromIndex(bodyTextConflict.getStartIndexLocal(), bodyTextConflict.getEndIndexLocal()) : null;
                CompareViewerContract.IViewerFragment iViewerFragment7 = this.mFirstFragment;
                ArrayList<RectF> textRectFromIndex2 = iViewerFragment7 != null ? iViewerFragment7.getTextRectFromIndex(bodyTextConflict.getStartIndexSync(), bodyTextConflict.getEndIndexSync()) : null;
                if (bodyTextConflict.getIsSPenObject()) {
                    CompareViewerContract.IViewerFragment iViewerFragment8 = this.mSecondFragment;
                    textRectFromIndex = iViewerFragment8 != null ? iViewerFragment8.getRectObjectSpan(bodyTextConflict.getStartIndexLocal()) : null;
                    CompareViewerContract.IViewerFragment iViewerFragment9 = this.mFirstFragment;
                    textRectFromIndex2 = iViewerFragment9 != null ? iViewerFragment9.getRectObjectSpan(bodyTextConflict.getStartIndexSync()) : null;
                }
                if (textRectFromIndex2 != null && !textRectFromIndex2.isEmpty() && textRectFromIndex != null && !textRectFromIndex.isEmpty()) {
                    RectF rectF = textRectFromIndex.get(0);
                    RectF rectF2 = textRectFromIndex2.get(0);
                    Intrinsics.checkNotNull(rectF);
                    Point point = new Point((int) rectF.left, (int) rectF.top);
                    Intrinsics.checkNotNull(rectF2);
                    conflictLocation.setPoint(point, new Point((int) rectF2.left, (int) rectF2.top));
                    conflictLocation.setRectF(textRectFromIndex, textRectFromIndex2);
                    List<ConflictLocation> list2 = this.mListLocationConflict;
                    if (list2 != null) {
                        list2.add(conflictLocation);
                    }
                }
            }
        }
        CompareManager.Companion companion2 = CompareManager.INSTANCE;
        CompareManager companion3 = companion2.getInstance();
        Intrinsics.checkNotNull(companion3);
        if (companion3.getListConflictLocation() != null) {
            CompareManager companion4 = companion2.getInstance();
            Intrinsics.checkNotNull(companion4);
            List<ConflictLocation> listConflictLocation2 = companion4.getListConflictLocation();
            if (listConflictLocation2 != null && (list = this.mListLocationConflict) != null) {
                list.addAll(listConflictLocation2);
            }
        }
        List<ConflictLocation> list3 = this.mListLocationConflict;
        if (list3 != null) {
            CollectionsKt.sortWith(list3, new Comparator<ConflictLocation>() { // from class: com.samsung.android.support.senl.nt.composer.main.compare.presenter.MultiScrollPresenter.updateConflictLocation.2
                @Override // java.util.Comparator
                public int compare(ConflictLocation o12, ConflictLocation o22) {
                    RectF rectF3;
                    RectF rectF4;
                    RectF rectF5;
                    RectF rectF6;
                    RectF rectF7;
                    RectF rectF8;
                    RectF rectF9;
                    RectF rectF10;
                    Intrinsics.checkNotNullParameter(o12, "o1");
                    Intrinsics.checkNotNullParameter(o22, "o2");
                    if (o12.getIsPageOrObject() || o22.getIsPageOrObject()) {
                        if (o12.getMPointLocal() != null && o22.getMPointLocal() != null) {
                            MultiScrollPresenter multiScrollPresenter = MultiScrollPresenter.this;
                            Point mPointLocal = o12.getMPointLocal();
                            Intrinsics.checkNotNull(mPointLocal);
                            Point mPointLocal2 = o22.getMPointLocal();
                            Intrinsics.checkNotNull(mPointLocal2);
                            int iComparePoint = multiScrollPresenter.comparePoint(mPointLocal, mPointLocal2);
                            if (iComparePoint != 0) {
                                return iComparePoint;
                            }
                        }
                        if (o12.getMPointSync() == null || o22.getMPointSync() == null) {
                            return 0;
                        }
                        MultiScrollPresenter multiScrollPresenter2 = MultiScrollPresenter.this;
                        Point mPointSync = o12.getMPointSync();
                        Intrinsics.checkNotNull(mPointSync);
                        Point mPointSync2 = o22.getMPointSync();
                        Intrinsics.checkNotNull(mPointSync2);
                        return multiScrollPresenter2.comparePoint(mPointSync, mPointSync2);
                    }
                    ArrayList<RectF> mRectLocals = o12.getMRectLocals();
                    Float fValueOf = null;
                    Float fValueOf2 = (mRectLocals == null || (rectF10 = mRectLocals.get(1)) == null) ? null : Float.valueOf(rectF10.left);
                    Intrinsics.checkNotNull(fValueOf2);
                    int iFloatValue = (int) fValueOf2.floatValue();
                    ArrayList<RectF> mRectLocals2 = o12.getMRectLocals();
                    Float fValueOf3 = (mRectLocals2 == null || (rectF9 = mRectLocals2.get(1)) == null) ? null : Float.valueOf(rectF9.top);
                    Intrinsics.checkNotNull(fValueOf3);
                    Point point2 = new Point(iFloatValue, (int) fValueOf3.floatValue());
                    ArrayList<RectF> mRectLocals3 = o22.getMRectLocals();
                    Float fValueOf4 = (mRectLocals3 == null || (rectF8 = mRectLocals3.get(1)) == null) ? null : Float.valueOf(rectF8.left);
                    Intrinsics.checkNotNull(fValueOf4);
                    int iFloatValue2 = (int) fValueOf4.floatValue();
                    ArrayList<RectF> mRectLocals4 = o22.getMRectLocals();
                    Float fValueOf5 = (mRectLocals4 == null || (rectF7 = mRectLocals4.get(1)) == null) ? null : Float.valueOf(rectF7.top);
                    Intrinsics.checkNotNull(fValueOf5);
                    int iComparePoint2 = MultiScrollPresenter.this.comparePoint(point2, new Point(iFloatValue2, (int) fValueOf5.floatValue()));
                    if (iComparePoint2 != 0) {
                        return iComparePoint2;
                    }
                    ArrayList<RectF> mRectSyncs = o12.getMRectSyncs();
                    Float fValueOf6 = (mRectSyncs == null || (rectF6 = mRectSyncs.get(1)) == null) ? null : Float.valueOf(rectF6.left);
                    Intrinsics.checkNotNull(fValueOf6);
                    int iFloatValue3 = (int) fValueOf6.floatValue();
                    ArrayList<RectF> mRectSyncs2 = o12.getMRectSyncs();
                    Float fValueOf7 = (mRectSyncs2 == null || (rectF5 = mRectSyncs2.get(1)) == null) ? null : Float.valueOf(rectF5.top);
                    Intrinsics.checkNotNull(fValueOf7);
                    Point point3 = new Point(iFloatValue3, (int) fValueOf7.floatValue());
                    ArrayList<RectF> mRectSyncs3 = o22.getMRectSyncs();
                    Float fValueOf8 = (mRectSyncs3 == null || (rectF4 = mRectSyncs3.get(1)) == null) ? null : Float.valueOf(rectF4.left);
                    Intrinsics.checkNotNull(fValueOf8);
                    int iFloatValue4 = (int) fValueOf8.floatValue();
                    ArrayList<RectF> mRectSyncs4 = o22.getMRectSyncs();
                    if (mRectSyncs4 != null && (rectF3 = mRectSyncs4.get(1)) != null) {
                        fValueOf = Float.valueOf(rectF3.top);
                    }
                    Intrinsics.checkNotNull(fValueOf);
                    return MultiScrollPresenter.this.comparePoint(point3, new Point(iFloatValue4, (int) fValueOf.floatValue()));
                }
            });
        }
    }

    private final void updateMenuButton() {
        CompareViewerContract.IViewCompare iViewCompare = this.mViewCompare;
        if (iViewCompare != null) {
            iViewCompare.updatePrevious(this.mCurrentLocationConflict >= 1);
        }
        CompareViewerContract.IViewCompare iViewCompare2 = this.mViewCompare;
        if (iViewCompare2 != null) {
            int i = this.mCurrentLocationConflict;
            List<ConflictLocation> list = this.mListLocationConflict;
            Intrinsics.checkNotNull(list);
            iViewCompare2.updateNext(i < list.size() - 1);
        }
    }

    private final Integer[] updateNumberOfConflict() {
        CompareManager companion = CompareManager.INSTANCE.getInstance();
        Intrinsics.checkNotNull(companion);
        CompareSPenObjectTextBox compareBodyText = companion.getCompareBodyText();
        if (compareBodyText != null) {
            for (ConflictLocation conflictLocation : compareBodyText.getListConflictLocation()) {
                Integer[] numArr = this.mCounterConflict;
                int mType = conflictLocation.getMType();
                numArr[mType] = Integer.valueOf(numArr[mType].intValue() + 1);
            }
        }
        CompareManager.Companion companion2 = CompareManager.INSTANCE;
        CompareManager companion3 = companion2.getInstance();
        Intrinsics.checkNotNull(companion3);
        if (companion3.getListConflictLocation() != null) {
            CompareManager companion4 = companion2.getInstance();
            Intrinsics.checkNotNull(companion4);
            List<ConflictLocation> listConflictLocation = companion4.getListConflictLocation();
            Intrinsics.checkNotNull(listConflictLocation);
            for (ConflictLocation conflictLocation2 : listConflictLocation) {
                Integer[] numArr2 = this.mCounterConflict;
                int mType2 = conflictLocation2.getMType();
                numArr2[mType2] = Integer.valueOf(numArr2[mType2].intValue() + 1);
            }
        }
        return this.mCounterConflict;
    }

    public final void init(@Nullable CompareViewerContract.IViewCompare iViewCompare) {
        this.mViewCompare = iViewCompare;
        if (iViewCompare != null) {
            iViewCompare.showMenuBar(updateNumberOfConflict());
        }
    }

    @Nullable
    public final Boolean onClickEditMerge(@NotNull String tag) {
        CompareViewerContract.IViewerFragment iViewerFragment;
        CompareViewerContract.IViewerFragment iViewerFragment2;
        CompareViewerContract.IViewerFragment iViewerFragment3;
        Intrinsics.checkNotNullParameter(tag, "tag");
        AbstractC8014b.m7197C("onClickEditMerge: ", tag, TAG);
        List<ConflictLocation> list = this.mListLocationConflict;
        ConflictLocation conflictLocation = list != null ? list.get(this.mCurrentLocationConflict) : null;
        InformationConflict mInformationConflict = conflictLocation != null ? conflictLocation.getMInformationConflict() : null;
        if (mInformationConflict == null) {
            return null;
        }
        CompareManager companion = CompareManager.INSTANCE.getInstance();
        Intrinsics.checkNotNull(companion);
        Boolean boolEditMerge = companion.editMerge(tag, mInformationConflict);
        if ((mInformationConflict instanceof InformationConflict.WPageConflict) && (iViewerFragment3 = this.mMergeFragment) != null) {
            iViewerFragment3.requestPageLayout();
        }
        if (getMergeLocation(conflictLocation) != null && (iViewerFragment2 = this.mMergeFragment) != null) {
            iViewerFragment2.setScrollView(r1.x, r1.y);
        }
        ArrayList<RectF> mRectMerges = conflictLocation.getMRectMerges();
        if (mRectMerges != null && (iViewerFragment = this.mMergeFragment) != null) {
            iViewerFragment.drawHighlight(mRectMerges, conflictLocation.getMType());
        }
        return boolEditMerge;
    }

    public final void onNextClick() {
        this.mCurrentLocationConflict++;
        scrollToLocation();
    }

    public final void onPrevClick() {
        this.mCurrentLocationConflict--;
        scrollToLocation();
    }

    public final void onScrollChanged(float panY, @NotNull String tag) {
        float panY2;
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (Intrinsics.areEqual(tag, "second")) {
            if (((float) Math.rint(this.mPrePanLeft)) != ((float) Math.rint(panY))) {
                float f = panY - this.mPrePanLeft;
                if (f != 0.0f) {
                    this.mPrePanLeft = panY;
                    CompareViewerContract.IViewerFragment iViewerFragment = this.mFirstFragment;
                    panY2 = iViewerFragment != null ? iViewerFragment.getPanY() + f : 0.0f;
                    this.mPrePanRight = panY2;
                    CompareViewerContract.IViewerFragment iViewerFragment2 = this.mFirstFragment;
                    if (iViewerFragment2 != null) {
                        iViewerFragment2.setScrollView(panY2);
                    }
                }
            }
        } else if (Intrinsics.areEqual(tag, "first") && ((float) Math.rint(this.mPrePanRight)) != ((float) Math.rint(panY))) {
            float f4 = panY - this.mPrePanRight;
            if (f4 != 0.0f) {
                this.mPrePanRight = panY;
                CompareViewerContract.IViewerFragment iViewerFragment3 = this.mSecondFragment;
                panY2 = iViewerFragment3 != null ? iViewerFragment3.getPanY() + f4 : 0.0f;
                this.mPrePanLeft = panY2;
                CompareViewerContract.IViewerFragment iViewerFragment4 = this.mSecondFragment;
                if (iViewerFragment4 != null) {
                    iViewerFragment4.setScrollView(panY2);
                }
            }
        }
        CompareViewerContract.IViewerFragment iViewerFragment5 = this.mFirstFragment;
        if (iViewerFragment5 != null) {
            iViewerFragment5.redraw();
        }
        CompareViewerContract.IViewerFragment iViewerFragment6 = this.mSecondFragment;
        if (iViewerFragment6 != null) {
            iViewerFragment6.redraw();
        }
        CompareViewerContract.IViewerFragment iViewerFragment7 = this.mMergeFragment;
        if (iViewerFragment7 != null) {
            iViewerFragment7.redraw();
        }
    }

    public final void setMergeFragment(@Nullable CompareViewerContract.IViewerFragment fragment) {
        this.mMergeFragment = fragment;
    }
}
