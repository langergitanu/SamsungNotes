package com.samsung.android.support.senl.p148nt.composer.main.compare;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbarFragment;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.IMenuInflater;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.SyncConflictConfirmDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.compare.presenter.CompareMainPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.compare.presenter.CompareViewerContract;
import com.samsung.android.support.senl.p148nt.composer.main.compare.viewer.CompareViewerFragment;
import com.samsung.android.support.senl.p148nt.composer.main.simple.common.SimpleComposerConstant;
import com.samsung.android.support.senl.p148nt.composer.main.simple.model.NoteInfoArgument;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CompareMainFragment extends CustomToolbarFragment implements CompareViewerContract.IViewCompare {
    public static final String FIRST_TAG = "first";
    public static final String MERGE_TAG = "merge";
    public static final String SECOND_TAG = "second";
    private static final String TAG = Logger.createTag("CompareMainFragment", SimpleComposerConstant.TAG_PREFIX);
    private Boolean isShowMergeLayout = null;
    private AbsCompareLayoutManager mCompareLayoutManager;
    private View mCompareViewerContainer;
    private View mMenuBar;
    private View mMergeViewerContainer;
    private OnBackPressedCallback mOnBackPressedCallback;
    private ImageButton mOpenMergeBtn;
    private CompareViewerContract.IPresenter mPresenter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class AbsCompareLayoutManager {
        protected final Fragment mContainerFragment;
        protected final ArrayList<NoteInfoArgument> mNoteInfoArguments;
        protected CompareViewerContract.IPresenter mPresenter;

        public AbsCompareLayoutManager(Fragment fragment, CompareViewerContract.IPresenter iPresenter) {
            this.mContainerFragment = fragment;
            this.mPresenter = iPresenter;
            this.mNoteInfoArguments = iPresenter.getNoteInfoArguments();
        }

        public void addFragment(NoteInfoArgument noteInfoArgument, @IdRes int i, String str) {
            Fragment fragmentFindFragmentByTag = this.mContainerFragment.getChildFragmentManager().findFragmentByTag(str);
            if (fragmentFindFragmentByTag != null) {
                ((CompareViewerFragment) fragmentFindFragmentByTag).setCompareMainPresenter(this.mPresenter);
                return;
            }
            FragmentTransaction fragmentTransactionBeginTransaction = this.mContainerFragment.getChildFragmentManager().beginTransaction();
            Bundle bundle = new Bundle();
            bundle.putParcelable(NoteInfoArgument.KEY_BUNDLE, noteInfoArgument);
            CompareViewerFragment compareViewerFragment = new CompareViewerFragment();
            compareViewerFragment.setArguments(bundle);
            compareViewerFragment.setCompareMainPresenter(this.mPresenter);
            fragmentTransactionBeginTransaction.add(i, compareViewerFragment, str).commitAllowingStateLoss();
        }

        public boolean canShowChangeOption() {
            return false;
        }

        public abstract boolean onBackPressed();

        public abstract void onViewCreated();

        public void setFirstFragment() {
            ArrayList<NoteInfoArgument> arrayList = this.mNoteInfoArguments;
            if (arrayList == null) {
                Logger.m11000e(CompareMainFragment.TAG, "setFirstFragment# mNoteInfoArguments is null");
            } else {
                addFragment(arrayList.get(0), C9086R.id.first_pan, "first");
            }
        }

        public void setMergeFragment() {
            if (this.mNoteInfoArguments == null) {
                Logger.m11000e(CompareMainFragment.TAG, "setMergeFragment# mNoteInfoArguments is null");
                return;
            }
            Fragment fragmentFindFragmentByTag = this.mContainerFragment.getChildFragmentManager().findFragmentByTag("merge");
            if (fragmentFindFragmentByTag == null) {
                addFragment(this.mNoteInfoArguments.get(2), C9086R.id.merge_pan, "merge");
            } else if (fragmentFindFragmentByTag.isHidden()) {
                this.mContainerFragment.getChildFragmentManager().popBackStack();
            }
        }

        public abstract void setSecondFragment();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PhoneLayoutManager extends AbsCompareLayoutManager {
        public PhoneLayoutManager(Fragment fragment, CompareViewerContract.IPresenter iPresenter) {
            super(fragment, iPresenter);
        }

        private boolean isShowingSecond() {
            if (this.mContainerFragment.getChildFragmentManager().getFragments().size() <= 1) {
                return false;
            }
            return !r0.get(1).isHidden();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.compare.CompareMainFragment.AbsCompareLayoutManager
        public boolean canShowChangeOption() {
            return !isShowingSecond();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.compare.CompareMainFragment.AbsCompareLayoutManager
        public boolean onBackPressed() {
            List<Fragment> fragments = this.mContainerFragment.getChildFragmentManager().getFragments();
            if (fragments.size() <= 1) {
                return false;
            }
            Fragment fragment = fragments.get(1);
            if (fragment.isHidden()) {
                return false;
            }
            FragmentActivity fragmentActivityRequireActivity = fragment.requireActivity();
            this.mContainerFragment.getChildFragmentManager().beginTransaction().hide(fragment).addToBackStack("hide").commitAllowingStateLoss();
            fragmentActivityRequireActivity.invalidateOptionsMenu();
            return true;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.compare.CompareMainFragment.AbsCompareLayoutManager
        public void onViewCreated() {
            setFirstFragment();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.compare.CompareMainFragment.AbsCompareLayoutManager
        public void setSecondFragment() {
            if (this.mNoteInfoArguments == null) {
                Logger.m11000e(CompareMainFragment.TAG, "setSecondFragment# mNoteInfoArguments is null");
                return;
            }
            Fragment fragmentFindFragmentByTag = this.mContainerFragment.getChildFragmentManager().findFragmentByTag("second");
            if (fragmentFindFragmentByTag == null) {
                addFragment(this.mNoteInfoArguments.get(1), C9086R.id.second_pan, "second");
            } else if (fragmentFindFragmentByTag.isHidden()) {
                this.mContainerFragment.getChildFragmentManager().popBackStack();
            } else {
                Logger.m10999d(CompareMainFragment.TAG, "setSecondFragment# unexpected case");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TabletLayoutManager extends AbsCompareLayoutManager {
        public TabletLayoutManager(Fragment fragment, CompareViewerContract.IPresenter iPresenter) {
            super(fragment, iPresenter);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.compare.CompareMainFragment.AbsCompareLayoutManager
        public boolean onBackPressed() {
            return false;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.compare.CompareMainFragment.AbsCompareLayoutManager
        public void onViewCreated() {
            setFirstFragment();
            setSecondFragment();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.compare.CompareMainFragment.AbsCompareLayoutManager
        public void setSecondFragment() {
            if (this.mNoteInfoArguments == null) {
                Logger.m11000e(CompareMainFragment.TAG, "setSecondFragment# mNoteInfoArguments is null");
                return;
            }
            Fragment fragmentFindFragmentByTag = this.mContainerFragment.getChildFragmentManager().findFragmentByTag("second");
            if (fragmentFindFragmentByTag == null) {
                addFragment(this.mNoteInfoArguments.get(1), C9086R.id.second_pan, "second");
            } else if (fragmentFindFragmentByTag.isHidden()) {
                this.mContainerFragment.getChildFragmentManager().popBackStack();
            } else {
                ((CompareViewerFragment) fragmentFindFragmentByTag).setCompareMainPresenter(this.mPresenter);
            }
        }
    }

    private void createLayoutManager() {
        this.mCompareLayoutManager = new TabletLayoutManager(this, this.mPresenter);
    }

    /* JADX INFO: renamed from: g */
    public static /* bridge */ /* synthetic */ void m12072g(CompareMainFragment compareMainFragment) {
        compareMainFragment.isShowMergeLayout = Boolean.TRUE;
    }

    private void initActionBar(AppCompatActivity appCompatActivity) {
        enableToolbar();
        enableAdjustableMenu();
        appCompatActivity.setSupportActionBar((Toolbar) getSupportedToolbar());
        if (appCompatActivity.getSupportActionBar() != null) {
            appCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        getSupportedToolbar().setDisplayHomeAsUpEnabled(true);
        setHasOptionsMenu(true);
    }

    private void initKeepBothButton(View view) {
        view.findViewById(C9086R.id.compare_button_keep_both).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.compare.CompareMainFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CompareMainFragment.this.mPresenter.onClickKeepBoth();
            }
        });
    }

    private void initMenuBar(View view) {
        this.mMenuBar = view.findViewById(C9086R.id.conflict_menu_tool_bar_layout);
        this.mMergeViewerContainer = view.findViewById(C9086R.id.merge_viewer_container);
        View view2 = this.mMenuBar;
        if (view2 != null) {
            View viewFindViewById = view2.findViewById(C9086R.id.previous_button_conflict_menu_tool_bar);
            viewFindViewById.setEnabled(false);
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.compare.CompareMainFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    CompareMainFragment.this.mPresenter.onPrevClick();
                }
            });
            this.mMenuBar.findViewById(C9086R.id.next_button_conflict_menu_tool_bar).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.compare.CompareMainFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    CompareMainFragment.this.mPresenter.onNextClick();
                }
            });
            this.mMenuBar.findViewById(C9086R.id.merge_button_container).setVisibility(8);
        }
    }

    private void setLayout(int i) {
        Logger.m11003i(TAG, "setLayout#");
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(requireContext()).inflate(i, (ViewGroup) null);
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(C9086R.id.viewer_container);
        ViewGroup viewGroup3 = (ViewGroup) getView();
        if (viewGroup3 != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= viewGroup3.getChildCount()) {
                    break;
                }
                ViewGroup viewGroup4 = (ViewGroup) viewGroup3.getChildAt(i2);
                if (viewGroup4.getId() == C9086R.id.viewer_container) {
                    View viewFindViewById = viewGroup4.findViewById(C9086R.id.first_pan);
                    View viewFindViewById2 = viewGroup4.findViewById(C9086R.id.second_pan);
                    viewGroup3.removeView(viewGroup4);
                    viewGroup.removeView(viewGroup2);
                    viewGroup4.removeView(viewFindViewById2);
                    View viewFindViewById3 = viewGroup2.findViewById(C9086R.id.second_pan);
                    viewGroup2.removeView(viewFindViewById3);
                    viewGroup2.addView(viewFindViewById2, viewFindViewById3.getLayoutParams());
                    viewGroup4.removeView(viewFindViewById);
                    View viewFindViewById4 = viewGroup2.findViewById(C9086R.id.first_pan);
                    viewGroup2.removeView(viewFindViewById4);
                    viewGroup2.addView(viewFindViewById, viewFindViewById4.getLayoutParams());
                    viewGroup3.addView(viewGroup2);
                    break;
                }
                i2++;
            }
        }
        Boolean bool = this.isShowMergeLayout;
        if (bool != null) {
            showMergeViewer(bool.booleanValue());
        }
        this.mPresenter.requestFitToScreenPreview();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMergeViewer(boolean z) {
        this.mOpenMergeBtn.setImageDrawable(getResources().getDrawable(!z ? C9086R.drawable.comp_compare_merge_selected : C9086R.drawable.comp_compare_merge_unselected, null));
        this.mMergeViewerContainer.setVisibility(z ? 8 : 0);
        this.mCompareViewerContainer.setVisibility(z ? 0 : 8);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbarFragment
    public void initAppbarContents(@NonNull View view) {
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbarFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mPresenter.isMainDisplayOfFoldModel()) {
            setLayout(C9086R.layout.compare_comp_main_fragment_layout_fold);
        } else {
            setLayout(C9086R.layout.compare_comp_main_fragment_layout);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        CompareMainPresenter compareMainPresenter = new CompareMainPresenter();
        this.mPresenter = compareMainPresenter;
        compareMainPresenter.init(requireActivity(), this);
        this.mPresenter.setDeviceNameForSyncConflict(requireActivity().getIntent().getStringExtra(SyncConflictConfirmDialogPresenter.DEVICE_NAME_SYNC_CONFLICT));
        this.mOnBackPressedCallback = new OnBackPressedCallback(true) { // from class: com.samsung.android.support.senl.nt.composer.main.compare.CompareMainFragment.1
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                Logger.m10999d(CompareMainFragment.TAG, "handleOnBackPressed#");
                if (CompareMainFragment.this.isShowMergeLayout != null && !CompareMainFragment.this.isShowMergeLayout.booleanValue()) {
                    CompareMainFragment.m12072g(CompareMainFragment.this);
                    CompareMainFragment.this.showMergeViewer(true);
                } else if (CompareMainFragment.this.mCompareLayoutManager == null || !CompareMainFragment.this.mCompareLayoutManager.onBackPressed()) {
                    CompareMainFragment.this.requireActivity().finish();
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this.mOnBackPressedCallback);
        String str = TAG;
        StringBuilder sb = new StringBuilder("onCreate# ");
        sb.append(bundle == null);
        sb.append(" ");
        sb.append(getResources().getConfiguration());
        Logger.m10999d(str, sb.toString());
        if (this.mPresenter.getNoteInfoArguments() == null) {
            Logger.m11000e(str, "arguments is empty");
            requireActivity().finish();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbarFragment
    public void onCreateFragmentOptionMenu(@NonNull Menu menu, @NonNull IMenuInflater iMenuInflater) {
        iMenuInflater.inflateMenu(C9086R.menu.compare_viewer_menu, menu);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = this.mPresenter.isMainDisplayOfFoldModel() ? layoutInflater.inflate(C9086R.layout.compare_comp_main_fragment_layout_fold, viewGroup, false) : layoutInflater.inflate(C9086R.layout.compare_comp_main_fragment_layout, viewGroup, false);
        this.mCompareViewerContainer = viewInflate.findViewById(C9086R.id.viewer_container);
        createLayoutManager();
        initToolbar(viewInflate);
        initMenuBar(viewInflate);
        initKeepBothButton(viewInflate);
        WindowManagerCompat.getInstance().disableSystemBarInsets(viewInflate);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Logger.m10999d(TAG, "CompareMainFragment onDestroy");
        this.mPresenter.destroy();
        this.mPresenter = null;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.mOnBackPressedCallback.handleOnBackPressed();
        fragmentActivityRequireActivity.setResult(0);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbarFragment
    public void onPrepareFragmentOptionMenu(@NonNull Menu menu) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        AppCompatActivity appCompatActivity = (AppCompatActivity) requireActivity();
        this.mCompareLayoutManager.onViewCreated();
        initActionBar(appCompatActivity);
        appCompatActivity.setTitle(C9086R.string.compare_notes);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewCompare
    public void setFirstFragment() {
        this.mCompareLayoutManager.setFirstFragment();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewCompare
    public void setMergeFragment() {
        this.mCompareLayoutManager.setMergeFragment();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewCompare
    @SuppressLint({"SetTextI18n"})
    public void showMenuBar(Integer[] numArr) {
        this.mMenuBar.setVisibility(0);
        TextView textView = (TextView) this.mMenuBar.findViewById(C9086R.id.information_conflict_insert);
        TextView textView2 = (TextView) this.mMenuBar.findViewById(C9086R.id.information_conflict_delete);
        TextView textView3 = (TextView) this.mMenuBar.findViewById(C9086R.id.information_conflict_formatting);
        textView.setText(numArr[0].toString());
        textView2.setText(numArr[1].toString());
        textView3.setText(numArr[2].toString());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewCompare
    public void showMergeButton() {
        View view = this.mMenuBar;
        if (view != null) {
            view.findViewById(C9086R.id.comp_compare_merge_button).setVisibility(0);
            this.mMenuBar.findViewById(C9086R.id.merge_progress_bar).setVisibility(8);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewCompare
    public void updateNext(boolean z) {
        View view = this.mMenuBar;
        if (view != null) {
            View viewFindViewById = view.findViewById(C9086R.id.next_button_conflict_menu_tool_bar);
            viewFindViewById.setEnabled(z);
            viewFindViewById.setAlpha(z ? 1.0f : 0.1f);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.compare.presenter.CompareViewerContract.IViewCompare
    public void updatePrevious(boolean z) {
        View view = this.mMenuBar;
        if (view != null) {
            View viewFindViewById = view.findViewById(C9086R.id.previous_button_conflict_menu_tool_bar);
            viewFindViewById.setEnabled(z);
            viewFindViewById.setAlpha(z ? 1.0f : 0.1f);
        }
    }
}
