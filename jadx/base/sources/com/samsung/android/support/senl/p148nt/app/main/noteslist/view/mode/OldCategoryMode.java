package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.oldnotes.view.OldCategoryFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/view/mode/OldCategoryMode;", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/view/mode/BaseMode;", "modeParams", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/params/ModeParams;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/params/ModeParams;)V", "mIsModeEnded", "", "getMIsModeEnded", "()Z", "setMIsModeEnded", "(Z)V", "onLayout", "", "addOldCategoryFragment", "removeOldCategoryFragment", "onResume", "onModeEnd", "onDestroy", "onBackKeyDown", "getModeIndex", "", "setNoHolderLayout", "getTag", "", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class OldCategoryMode extends BaseMode {

    @NotNull
    private static final String TAG = "OldCategoryMode";
    private boolean mIsModeEnded;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OldCategoryMode(@NotNull ModeParams modeParams) {
        super(modeParams);
        Intrinsics.checkNotNullParameter(modeParams, "modeParams");
    }

    private final void addOldCategoryFragment() {
        MainLogger.m7254d(TAG, "addOldCategoryFragment");
        FragmentActivity activity = this.mFragment.getActivity();
        Intrinsics.checkNotNull(activity);
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        OldCategoryFragment oldCategoryFragment = (OldCategoryFragment) supportFragmentManager.findFragmentByTag(OldCategoryFragment.TAG);
        if (oldCategoryFragment == null) {
            oldCategoryFragment = new OldCategoryFragment();
            supportFragmentManager.beginTransaction().add(C8003R.id.notes_fragment_container, oldCategoryFragment, OldCategoryFragment.TAG).commitAllowingStateLoss();
        } else {
            supportFragmentManager.beginTransaction().detach(oldCategoryFragment).commitAllowingStateLoss();
            supportFragmentManager.beginTransaction().attach(oldCategoryFragment).commitAllowingStateLoss();
        }
        oldCategoryFragment.setContract(new OldCategoryFragment.Contract() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.OldCategoryMode.addOldCategoryFragment.1
            @Override // com.samsung.android.support.senl.nt.app.main.oldnotes.view.OldCategoryFragment.Contract
            public void onCategorySelected(String categoryUuid) {
                OldCategoryMode.this.removeOldCategoryFragment();
                OldCategoryMode.this.mPresenter.getStateInfo().setCategoryUuid(categoryUuid);
                OldCategoryMode.this.mNotesView.setIsScrollToTop(true, 0);
                OldCategoryMode.this.mNotesView.setMode(21);
            }

            @Override // com.samsung.android.support.senl.nt.app.main.oldnotes.view.OldCategoryFragment.Contract
            public void startConvertAllNotes() {
                OldCategoryMode.this.removeOldCategoryFragment();
                OldCategoryMode.this.mNotesView.onFolderSelected(FolderConstants.AllNotes.UUID);
                OldCategoryMode.this.mPresenter.showConvertConfirmDialog(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeOldCategoryFragment() {
        MainLogger.m7254d(TAG, "removeOldCategoryFragment");
        FragmentActivity activity = this.mFragment.getActivity();
        FragmentManager supportFragmentManager = activity != null ? activity.getSupportFragmentManager() : null;
        OldCategoryFragment oldCategoryFragment = (OldCategoryFragment) (supportFragmentManager != null ? supportFragmentManager.findFragmentByTag(OldCategoryFragment.TAG) : null);
        if (oldCategoryFragment != null) {
            supportFragmentManager.beginTransaction().remove(oldCategoryFragment).commitAllowingStateLoss();
        } else if (!this.mIsModeEnded) {
            RunnableC7599e runnableC7599e = new RunnableC7599e(this, 28);
            MainLogger.m7254d(TAG, "removeOldCategoryFragment after drawing fragment");
            View view = this.mFragment.getView();
            if (view != null) {
                view.post(new RunnableC7599e(runnableC7599e, 29));
            }
        }
        this.mIsModeEnded = true;
    }

    public final boolean getMIsModeEnded() {
        return this.mIsModeEnded;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.Contract
    public int getModeIndex() {
        return 23;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onBackKeyDown() {
        removeOldCategoryFragment();
        if (NotesUtils.isTabletLayout(this.mContext) || !super.onBackKeyDown()) {
            return backStackHistory();
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onDestroy() {
        super.onDestroy();
        removeOldCategoryFragment();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onLayout() {
        this.mIsModeEnded = false;
        setNoHolderLayout();
        this.mActionMenuController.setToolbarTitle(C8003R.string.upgradable_notes);
        this.mActionMenuController.setToolbarSubTitle((String) null);
        this.mActionMenuController.setDisplayHomeAsUpEnabled(true);
        this.mActionMenuController.releaseCoeditBetaView();
        addOldCategoryFragment();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onModeEnd() {
        MainLogger.m7254d(TAG, "onModeEnd");
        removeOldCategoryFragment();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onResume() {
        super.onResume();
        this.mNotesView.applyWindowInsets();
    }

    public final void setMIsModeEnded(boolean z) {
        this.mIsModeEnded = z;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public void setNoHolderLayout() {
        if (this.mNoHolderLayout == null) {
            this.mNoHolderLayout = (ViewGroup) ViewModeUtils.getInflatedView(this.mFragment.getView(), C8003R.id.no_note_layout, C8003R.id.inflate_no_note_layout);
        }
        this.mNoHolderLayout.setVisibility(8);
    }
}
