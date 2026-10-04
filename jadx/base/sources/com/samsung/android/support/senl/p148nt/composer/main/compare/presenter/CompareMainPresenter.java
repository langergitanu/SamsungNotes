package com.samsung.android.support.senl.p148nt.composer.main.compare.presenter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.display.DisplayDeviceTypeCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.compare.dialog.SyncConflictKeepDialog;
import com.samsung.android.support.senl.p148nt.composer.main.compare.logic.CompareManager;
import com.samsung.android.support.senl.p148nt.composer.main.compare.presenter.CompareViewerContract;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.simple.model.NoteInfoArgument;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001AB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\u0012\u0010#\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010%\u001a\u00020\u00172\b\u0010&\u001a\u0004\u0018\u00010\n2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0014\u0010)\u001a\u0004\u0018\u00010\n2\b\u0010&\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010*\u001a\u00020\u0017H\u0016J\u001c\u0010+\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010&\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010.\u001a\u00020\u00172\b\u0010&\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010/\u001a\u00020\u00172\b\u00100\u001a\u0004\u0018\u00010\f2\b\u0010&\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u0002032\u0006\u0010&\u001a\u00020\nH\u0016J\b\u00104\u001a\u00020\u0017H\u0016J\b\u00105\u001a\u00020\u0017H\u0016J\b\u00106\u001a\u00020\u0017H\u0016J\b\u00107\u001a\u00020\u0017H\u0016J\u0010\u00108\u001a\u00020\u00172\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020\u0017H\u0016J\u0017\u0010<\u001a\u0004\u0018\u00010\u00132\u0006\u0010&\u001a\u00020\nH\u0016¢\u0006\u0002\u0010=J\u0018\u0010>\u001a\u00020\u00152\u0006\u00109\u001a\u00020:2\u0006\u0010?\u001a\u00020\u0015H\u0016J\b\u0010@\u001a\u00020\u0017H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010\u001d\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010\u001ej\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u0001` 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006B"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/CompareMainPresenter;", "Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/CompareViewerContract$IPresenter;", "Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/IObserverConflict;", "<init>", "()V", "mActivity", "Landroid/app/Activity;", "mDialog", "Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/CompareViewerContract$IDialog;", "mDeviceNameForSyncConflict", "", "mFirstFragment", "Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/CompareViewerContract$IViewerFragment;", "mSecondFragment", "mMultiScrollPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/MultiScrollPresenter;", "mViewCompare", "Lcom/samsung/android/support/senl/nt/composer/main/compare/presenter/CompareViewerContract$IViewCompare;", "isCompareDone", "", "mCountFragment", "", "init", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "iViewCompare", "onRegisterConflictManager", "onClickKeepBoth", "isMainDisplayOfFoldModel", "noteInfoArguments", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/composer/main/simple/model/NoteInfoArgument;", "Lkotlin/collections/ArrayList;", "getNoteInfoArguments", "()Ljava/util/ArrayList;", "setDeviceNameForSyncConflict", "deviceName", "setTitle", "tag", "view", "Landroid/view/View;", "getDeviceName", "requestFitToScreenPreview", "showDialog", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "onClickOK", "setViewerFragment", "iViewerFragment", "onScrollChanged", "panY", "", "setAutoScroll", "onNextClick", "onPrevClick", "onConflictCheckDone", "setMergeNoteToShow", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "onMergeDone", "onClickEditMerge", "(Ljava/lang/String;)Ljava/lang/Boolean;", "getIndexPageOfObject", "index", "destroy", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CompareMainPresenter implements CompareViewerContract.IPresenter, IObserverConflict {
    private static final float MIN_RESIZE_FOR_CONTAINER = 0.7f;

    @NotNull
    private static final String TAG;
    private boolean isCompareDone;

    @Nullable
    private Activity mActivity;
    private int mCountFragment;

    @Nullable
    private String mDeviceNameForSyncConflict;

    @Nullable
    private CompareViewerContract.IDialog mDialog;

    @Nullable
    private CompareViewerContract.IViewerFragment mFirstFragment;

    @Nullable
    private MultiScrollPresenter mMultiScrollPresenter;

    @Nullable
    private CompareViewerContract.IViewerFragment mSecondFragment;

    @Nullable
    private CompareViewerContract.IViewCompare mViewCompare;

    static {
        String strCreateTag = Logger.createTag("CompareMainPresenter");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onConflictCheckDone$lambda$1(CompareMainPresenter compareMainPresenter) {
        MultiScrollPresenter multiScrollPresenter = compareMainPresenter.mMultiScrollPresenter;
        if (multiScrollPresenter == null) {
            compareMainPresenter.isCompareDone = true;
            return;
        }
        Intrinsics.checkNotNull(multiScrollPresenter);
        multiScrollPresenter.init(compareMainPresenter.mViewCompare);
        CompareManager companion = CompareManager.INSTANCE.getInstance();
        Intrinsics.checkNotNull(companion);
        companion.registerObserverMerge(compareMainPresenter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMergeDone$lambda$2(CompareMainPresenter compareMainPresenter) {
        CompareViewerContract.IViewCompare iViewCompare = compareMainPresenter.mViewCompare;
        if (iViewCompare != null) {
            iViewCompare.showMergeButton();
        }
        CompareViewerContract.IViewerFragment iViewerFragment = compareMainPresenter.mSecondFragment;
        if (iViewerFragment != null) {
            iViewerFragment.mergeDone();
        }
        CompareViewerContract.IViewerFragment iViewerFragment2 = compareMainPresenter.mFirstFragment;
        if (iViewerFragment2 != null) {
            iViewerFragment2.mergeDone();
        }
    }

    private final void onRegisterConflictManager() {
        CompareManager companion = CompareManager.INSTANCE.getInstance();
        Intrinsics.checkNotNull(companion);
        companion.registerObserver(this);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IPresenter
    public void destroy() {
        this.mActivity = null;
        this.mDialog = null;
        this.mFirstFragment = null;
        this.mSecondFragment = null;
        this.mMultiScrollPresenter = null;
        this.mViewCompare = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IPresenter
    @Nullable
    public String getDeviceName(@Nullable String tag) {
        if (Intrinsics.areEqual(tag, "second")) {
            Activity activity = this.mActivity;
            Intrinsics.checkNotNull(activity);
            return activity.getResources().getString(DeviceUtils.isTabletModel() ? C9086R.string.composer_this_tablet : C9086R.string.composer_this_phone);
        }
        if (Intrinsics.areEqual(tag, "first") && !TextUtils.isEmpty(this.mDeviceNameForSyncConflict)) {
            return this.mDeviceNameForSyncConflict;
        }
        Activity activity2 = this.mActivity;
        Intrinsics.checkNotNull(activity2);
        return activity2.getResources().getString(C9086R.string.merge_note);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IPresenter
    public int getIndexPageOfObject(@NotNull SpenWNote note, int index) {
        Intrinsics.checkNotNullParameter(note, "note");
        SpenObjectTextBox bodyText = note.getBodyText();
        int pageCount = note.getPageCount();
        for (int i = 0; i < pageCount; i++) {
            int textSectionStart = bodyText.getTextSectionStart(i);
            int textSectionLength = (bodyText.getTextSectionLength(i) + textSectionStart) - 1;
            if (textSectionStart <= index && index <= textSectionLength) {
                return i;
            }
            if (textSectionStart > index) {
                break;
            }
        }
        return 0;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IPresenter
    @Nullable
    public ArrayList<NoteInfoArgument> getNoteInfoArguments() {
        Intent intent;
        Activity activity = this.mActivity;
        if (activity == null || (intent = activity.getIntent()) == null) {
            return null;
        }
        return intent.getParcelableArrayListExtra(NoteInfoArgument.KEY_BUNDLE);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IPresenter
    public void init(@Nullable Activity activity, @Nullable CompareViewerContract.IViewCompare iViewCompare) {
        Logger.m11003i(TAG, "init");
        this.mActivity = activity;
        this.mViewCompare = iViewCompare;
        onRegisterConflictManager();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IPresenter
    public boolean isMainDisplayOfFoldModel() {
        Resources resources;
        boolean zIsFoldableModel = ModelFeature.getFeature().isFoldableModel();
        DisplayDeviceTypeCompat companion = DisplayDeviceTypeCompat.INSTANCE.getInstance();
        Activity activity = this.mActivity;
        return zIsFoldableModel && companion.isMainDisplay((activity == null || (resources = activity.getResources()) == null) ? null : resources.getConfiguration());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IPresenter
    @Nullable
    public Boolean onClickEditMerge(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        MultiScrollPresenter multiScrollPresenter = this.mMultiScrollPresenter;
        if (multiScrollPresenter != null) {
            return multiScrollPresenter.onClickEditMerge(tag);
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IPresenter
    public void onClickKeepBoth() {
        Logger.m11003i(TAG, "onClickKeepBoth");
        Intent intent = new Intent();
        intent.putExtra(ComposerConstants.RESULT_COMPARE, 2);
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.setResult(-1, intent);
        }
        Activity activity2 = this.mActivity;
        if (activity2 != null) {
            activity2.finish();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IPresenter
    public void onClickOK(@Nullable String tag) {
        Logger.m11003i(TAG, "onClickOK# " + tag);
        Intent intent = new Intent();
        if (tag != null) {
            if (Intrinsics.areEqual(tag, "first")) {
                intent.putExtra(ComposerConstants.RESULT_COMPARE, 1);
            } else if (Intrinsics.areEqual(tag, "second")) {
                intent.putExtra(ComposerConstants.RESULT_COMPARE, 0);
            } else {
                intent.putExtra(ComposerConstants.RESULT_COMPARE, 3);
            }
            Activity activity = this.mActivity;
            if (activity != null) {
                activity.setResult(-1, intent);
            }
        }
        Activity activity2 = this.mActivity;
        if (activity2 != null) {
            activity2.finish();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.compare.presenter.IObserverConflict
    public void onConflictCheckDone() {
        Logger.m11003i(TAG, "onConflictDone");
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.runOnUiThread(new RunnableC10908a(this, 1));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.compare.presenter.IObserverConflict
    public void onMergeDone() {
        Logger.m11003i(TAG, "onMergeDone");
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.runOnUiThread(new RunnableC10908a(this, 0));
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IPresenter
    public void onNextClick() {
        MultiScrollPresenter multiScrollPresenter = this.mMultiScrollPresenter;
        if (multiScrollPresenter != null) {
            multiScrollPresenter.onNextClick();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IPresenter
    public void onPrevClick() {
        MultiScrollPresenter multiScrollPresenter = this.mMultiScrollPresenter;
        if (multiScrollPresenter != null) {
            multiScrollPresenter.onPrevClick();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IPresenter
    public void onScrollChanged(float panY, @NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        MultiScrollPresenter multiScrollPresenter = this.mMultiScrollPresenter;
        if (multiScrollPresenter == null || multiScrollPresenter == null) {
            return;
        }
        multiScrollPresenter.onScrollChanged(panY, tag);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IPresenter
    public void requestFitToScreenPreview() {
        CompareViewerContract.IViewerFragment iViewerFragment = this.mFirstFragment;
        if (iViewerFragment != null) {
            iViewerFragment.requestFitToScreenPreview();
        }
        CompareViewerContract.IViewerFragment iViewerFragment2 = this.mSecondFragment;
        if (iViewerFragment2 != null) {
            iViewerFragment2.requestFitToScreenPreview();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IPresenter
    public void setAutoScroll() {
        synchronized (this) {
            try {
                int i = this.mCountFragment + 1;
                this.mCountFragment = i;
                if (i > 1) {
                    CompareViewerContract.IViewerFragment iViewerFragment = this.mSecondFragment;
                    if (iViewerFragment != null) {
                        iViewerFragment.setAutoScroll(true);
                    }
                    CompareViewerContract.IViewerFragment iViewerFragment2 = this.mFirstFragment;
                    if (iViewerFragment2 != null) {
                        iViewerFragment2.setAutoScroll(true);
                    }
                    CompareViewerContract.IViewCompare iViewCompare = this.mViewCompare;
                    if (iViewCompare != null) {
                        iViewCompare.updateNext(true);
                        Unit unit = Unit.INSTANCE;
                    }
                } else {
                    CompareViewerContract.IViewerFragment iViewerFragment3 = this.mSecondFragment;
                    if (iViewerFragment3 != null) {
                        iViewerFragment3.setAutoScroll(false);
                    }
                    CompareViewerContract.IViewerFragment iViewerFragment4 = this.mFirstFragment;
                    if (iViewerFragment4 != null) {
                        iViewerFragment4.setAutoScroll(false);
                    }
                    CompareViewerContract.IViewCompare iViewCompare2 = this.mViewCompare;
                    if (iViewCompare2 != null) {
                        iViewCompare2.updateNext(false);
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IPresenter
    public void setDeviceNameForSyncConflict(@Nullable String deviceName) {
        this.mDeviceNameForSyncConflict = deviceName;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IPresenter
    public void setMergeNoteToShow(@NotNull SpenWNote note) {
        Intrinsics.checkNotNullParameter(note, "note");
        CompareManager companion = CompareManager.INSTANCE.getInstance();
        Intrinsics.checkNotNull(companion);
        companion.setNoteMergeToShow(note);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IPresenter
    public void setTitle(@Nullable String tag, @Nullable View view) {
        Logger.m11003i(TAG, "setTitle");
        TextView textView = (TextView) view;
        if (Intrinsics.areEqual(tag, "second")) {
            if (textView != null) {
                Activity activity = this.mActivity;
                Intrinsics.checkNotNull(activity);
                textView.setText(activity.getResources().getString(DeviceUtils.isTabletModel() ? C9086R.string.composer_this_tablet : C9086R.string.composer_this_phone));
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(tag, "first")) {
            if (TextUtils.isEmpty(this.mDeviceNameForSyncConflict) || textView == null) {
                return;
            }
            textView.setText(this.mDeviceNameForSyncConflict);
            return;
        }
        if (textView != null) {
            Activity activity2 = this.mActivity;
            Intrinsics.checkNotNull(activity2);
            textView.setText(activity2.getResources().getString(C9086R.string.merge_note));
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IPresenter
    public void setViewerFragment(@Nullable CompareViewerContract.IViewerFragment iViewerFragment, @Nullable String tag) {
        Logger.m11003i(TAG, "setViewerFragment# " + tag);
        if (Intrinsics.areEqual(tag, "first")) {
            this.mFirstFragment = iViewerFragment;
            return;
        }
        if (Intrinsics.areEqual(tag, "second")) {
            this.mSecondFragment = iViewerFragment;
            return;
        }
        MultiScrollPresenter multiScrollPresenter = this.mMultiScrollPresenter;
        if (multiScrollPresenter != null) {
            multiScrollPresenter.setMergeFragment(iViewerFragment);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IPresenter
    public void showDialog(@Nullable FragmentManager fragmentManager, @Nullable String tag) {
        AbstractC8014b.m7197C("showDialog# ", tag, TAG);
        if (this.mDialog == null) {
            SyncConflictKeepDialog syncConflictKeepDialog = new SyncConflictKeepDialog();
            this.mDialog = syncConflictKeepDialog;
            syncConflictKeepDialog.setPresenter(this);
        }
        CompareViewerContract.IDialog iDialog = this.mDialog;
        if (iDialog != null) {
            Intrinsics.checkNotNull(fragmentManager);
            Intrinsics.checkNotNull(tag);
            iDialog.showDialog(fragmentManager, tag);
        }
    }
}
