package com.samsung.android.support.senl.p148nt.composer.main.simple.presenter.listener;

import android.os.AsyncTask;
import com.samsung.android.sdk.composer.input.ISpenNotePageLayouter;
import com.samsung.android.sdk.composer.listener.SpenPageActionListener;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.compare.logic.CompareManager;
import com.samsung.android.support.senl.p148nt.composer.main.simple.presenter.listener.ISimpleListenerContract;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p004A2.RunnableC0015b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012J\u0016\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012J&\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0014J\u0006\u0010\u001d\u001a\u00020\u0010R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/simple/presenter/listener/SimpleComposerPageActionListenerImpl;", "Lcom/samsung/android/sdk/composer/listener/SpenPageActionListener;", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/simple/presenter/listener/ISimpleListenerContract$IPresenter;", "spenNotePageLayouter", "Lcom/samsung/android/sdk/composer/input/ISpenNotePageLayouter;", "tag", "", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/simple/presenter/listener/ISimpleListenerContract$IPresenter;Lcom/samsung/android/sdk/composer/input/ISpenNotePageLayouter;Ljava/lang/String;)V", "mPresenter", "mNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "mSpenNotePageLayouter", "mTag", "onLastPageChanged", "", "totalHeight", "", "syncPageInfo", "", "getDefaultPageHeight", "src", "isDummyPage", "targetIndex", "pageCount", "addPages", "newPageCount", "pageHeight", "commitHistory", "combineHistory", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SimpleComposerPageActionListenerImpl extends SpenPageActionListener {

    @NotNull
    private static final String TAG;

    @Nullable
    private SpenWNote mNote;

    @Nullable
    private ISimpleListenerContract.IPresenter mPresenter;

    @Nullable
    private ISpenNotePageLayouter mSpenNotePageLayouter;

    @Nullable
    private String mTag;

    static {
        String strCreateTag = Logger.createTag("SimpleComposerPageActionListenerImpl");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public SimpleComposerPageActionListenerImpl(@Nullable ISimpleListenerContract.IPresenter iPresenter, @Nullable ISpenNotePageLayouter iSpenNotePageLayouter, @Nullable String str) {
        this.mPresenter = iPresenter;
        this.mSpenNotePageLayouter = iSpenNotePageLayouter;
        this.mTag = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLastPageChanged$lambda$1$lambda$0(SimpleComposerPageActionListenerImpl simpleComposerPageActionListenerImpl) {
        CompareManager companion = CompareManager.INSTANCE.getInstance();
        Intrinsics.checkNotNull(companion);
        companion.startComparePage(simpleComposerPageActionListenerImpl.mNote);
    }

    public final void addPages(int newPageCount, int pageHeight, boolean commitHistory, boolean combineHistory) {
        SpenWNote spenWNote;
        String str = TAG;
        AbstractC0000a.m3D(newPageCount, "addPages# ", str);
        int[] iArr = new int[newPageCount];
        Arrays.fill(iArr, pageHeight);
        SpenWNote spenWNote2 = this.mNote;
        if (spenWNote2 != null) {
            spenWNote2.appendPageList(iArr);
        }
        ISpenNotePageLayouter iSpenNotePageLayouter = this.mSpenNotePageLayouter;
        Intrinsics.checkNotNull(iSpenNotePageLayouter);
        iSpenNotePageLayouter.requestPageLayout();
        if (commitHistory) {
            commitHistory();
            if (combineHistory && (spenWNote = this.mNote) != null) {
                spenWNote.combineLastUndo(1);
            }
        }
        Logger.m10999d(str, "addPages# end");
    }

    public final void commitHistory() {
        SpenWNote spenWNote = this.mNote;
        if (spenWNote != null) {
            spenWNote.commitHistory();
        }
    }

    public final int getDefaultPageHeight(int src) {
        SpenWNote spenWNote = this.mNote;
        Intrinsics.checkNotNull(spenWNote);
        SpenWPage page = spenWNote.getPage(src);
        if (page.getTemplateType() == 16) {
            return page.getHeight();
        }
        SpenWNote spenWNote2 = this.mNote;
        Intrinsics.checkNotNull(spenWNote2);
        if (isDummyPage(src, spenWNote2.getPageCount())) {
            return page.getHeight();
        }
        SpenWNote spenWNote3 = this.mNote;
        Intrinsics.checkNotNull(spenWNote3);
        return spenWNote3.getPageDefaultHeight();
    }

    public final boolean isDummyPage(int targetIndex, int pageCount) {
        return targetIndex == pageCount - 1;
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenPageActionListener
    public void onLastPageChanged(int totalHeight) {
        onLastPageChanged(totalHeight, true);
    }

    public final void onLastPageChanged(int totalHeight, boolean syncPageInfo) {
        AbstractC8014b.m7217s(totalHeight, "onLastPageChanged# ", TAG);
        ISimpleListenerContract.IPresenter iPresenter = this.mPresenter;
        SpenWNote doc = iPresenter != null ? iPresenter.getDoc() : null;
        this.mNote = doc;
        if (doc != null) {
            int defaultPageHeight = getDefaultPageHeight(doc.getPageCount() - 1);
            int height = totalHeight - (doc.getHeight() - defaultPageHeight);
            int i = (height / defaultPageHeight) + (height % defaultPageHeight > 0 ? 1 : 0);
            if (i <= 0) {
                return;
            }
            addPages(i, defaultPageHeight, true, true);
            if (Intrinsics.areEqual(this.mTag, "first")) {
                AsyncTask.execute(new RunnableC0015b(this, 16));
            }
        }
    }
}
