package com.samsung.android.support.senl.p148nt.app.main.folder.view;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingBottomLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingToolbarLayout;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.listener.OnCustomKeyListener;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.WidgetInsetUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.view.ActionMenuController;
import com.samsung.android.support.senl.p148nt.app.main.common.view.BottomMenuController;
import com.samsung.android.support.senl.p148nt.app.main.common.view.FolderPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.common.view.layoutmanager.FolderLayoutManager;
import com.samsung.android.support.senl.p148nt.app.main.folder.presenter.FolderPresenter;
import com.samsung.android.support.senl.p148nt.app.main.folder.presenter.ViewContract;
import com.samsung.android.support.senl.p148nt.app.main.folder.view.dialog.DialogCreator;
import com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.BaseMode;
import com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.ManageEditMode;
import com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.ManageMode;
import com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.ManageSyncMode;
import com.samsung.android.support.senl.p148nt.base.common.WindowInsetsManager;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FolderListFragment extends AbsFragment implements OnCustomKeyListener, ViewContract.IFragment {
    public static final String TAG = "FolderListFragment";
    private AccessibilityManager mAccessibilityManager;
    private ActionMenuController mActionMenuController;
    private AbsAppCompatActivity mActivityContract;
    private BottomMenuController mBottomMenuController;
    private View mContainer;
    private BaseMode mMode;
    private ModeFactory mModeFactory;
    private OnBackPressedCallback mOnBackPressedCallback;
    private FolderPresenter mPresenter;
    private FolderPenRecyclerView mRecyclerView;
    private WindowInsetsManager.AnimationCallback mAnimationCallback = new WindowInsetsManager.AnimationCallback() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.FolderListFragment.1
        @Override // com.samsung.android.support.senl.nt.base.common.WindowInsetsManager.AnimationCallback
        public void onEnd(@NotNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) throws Exception {
            FolderListFragment.this.updateWindowInsets();
        }

        @Override // com.samsung.android.support.senl.nt.base.common.WindowInsetsManager.AnimationCallback
        public void onProgress(@NotNull WindowInsetsCompat windowInsetsCompat, @NotNull List<WindowInsetsAnimationCompat> list) {
        }
    };
    private WindowInsetsManager.ApplyInsetListener mApplyInsetListener = new WindowInsetsManager.ApplyInsetListener() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.FolderListFragment.2
        @Override // com.samsung.android.support.senl.nt.base.common.WindowInsetsManager.ApplyInsetListener
        public void onApplyInsets(@NotNull View view, @NotNull WindowInsetsCompat windowInsetsCompat) throws Exception {
            FolderListFragment.this.updateWindowInsets();
        }
    };
    private final AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener = new AccessibilityManager.AccessibilityStateChangeListener() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.FolderListFragment.3
        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean z) {
            AbstractC8014b.m7210l("onAccessibilityStateChanged : ", "FolderListFragment", z);
            FolderListFragment.this.mPresenter.setObserveDataChanged();
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ModeFactory {
        ManageMode mManage;
        ManageEditMode mManageEdit;
        ManageSyncMode mManageSync;

        public /* synthetic */ ModeFactory(FolderListFragment folderListFragment, int i) {
            this();
        }

        public BaseMode getMode(int i) {
            if (i == 2) {
                ManageMode manageMode = this.mManage;
                if (manageMode != null) {
                    return manageMode;
                }
                FolderListFragment folderListFragment = FolderListFragment.this;
                ManageMode manageMode2 = new ManageMode(folderListFragment, folderListFragment.mRecyclerView, FolderListFragment.this.mActionMenuController, FolderListFragment.this.mBottomMenuController, FolderListFragment.this.mPresenter);
                this.mManage = manageMode2;
                return manageMode2;
            }
            if (i == 3) {
                ManageEditMode manageEditMode = this.mManageEdit;
                if (manageEditMode != null) {
                    return manageEditMode;
                }
                FolderListFragment folderListFragment2 = FolderListFragment.this;
                ManageEditMode manageEditMode2 = new ManageEditMode(folderListFragment2, folderListFragment2.mRecyclerView, FolderListFragment.this.mActionMenuController, FolderListFragment.this.mBottomMenuController, FolderListFragment.this.mPresenter);
                this.mManageEdit = manageEditMode2;
                return manageEditMode2;
            }
            if (i != 4) {
                return null;
            }
            ManageSyncMode manageSyncMode = this.mManageSync;
            if (manageSyncMode != null) {
                return manageSyncMode;
            }
            FolderListFragment folderListFragment3 = FolderListFragment.this;
            ManageSyncMode manageSyncMode2 = new ManageSyncMode(folderListFragment3, folderListFragment3.mRecyclerView, FolderListFragment.this.mActionMenuController, FolderListFragment.this.mBottomMenuController, FolderListFragment.this.mPresenter);
            this.mManageSync = manageSyncMode2;
            return manageSyncMode2;
        }

        private ModeFactory() {
        }
    }

    public FolderListFragment() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBackKeyDown() {
        if (this.mMode.onBackKeyDown()) {
            return;
        }
        OnBackPressedCallback onBackPressedCallback = this.mOnBackPressedCallback;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.setEnabled(false);
        }
        requireActivity().onBackPressed();
    }

    private void registerWindowInsetManager() {
        MainLogger.m7254d("FolderListFragment", "registerWindowInsetManager()");
        if (this.mContainer == null) {
            MainLogger.m7254d("FolderListFragment", "registerWindowInsetManager(), failed");
        } else {
            WindowInsetsManager.getInstance().registerAnimationCallback(this.mContainer, this.mAnimationCallback);
            WindowInsetsManager.getInstance().registerApplyListener(this.mContainer, this.mApplyInsetListener);
        }
    }

    private void setBackPressedListener() {
        this.mOnBackPressedCallback = new OnBackPressedCallback(true) { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.FolderListFragment.5
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                FolderListFragment.this.onBackKeyDown();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, this.mOnBackPressedCallback);
    }

    private void unregisterWindowInsetManager() {
        MainLogger.m7254d("FolderListFragment", "unregisterWindowInsetManager()");
        if (this.mContainer == null) {
            MainLogger.m7254d("FolderListFragment", "unregisterWindowInsetManager(), failed");
            return;
        }
        WindowInsetsManager.getInstance().unregisterAnimationCallback(this.mContainer);
        WindowInsetsManager.getInstance().unregisterApplyListener(this.mContainer);
        this.mAnimationCallback = null;
        this.mApplyInsetListener = null;
        this.mContainer = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWindowInsets() throws Exception {
        FragmentActivity activity = getActivity();
        this.mRecyclerView.seslSetFadingEdgeEnabled(true, this.mPresenter.getSelectedItemCount() >= 1);
        if (activity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT > 34) {
            WidgetInsetUtils.applyWindowInsetsForFolderList(activity.getWindow(), this.mContainer, this.mRecyclerView, (AppBarLayout) activity.findViewById(C8003R.id.appbar_layout), (FloatingToolbarLayout) activity.findViewById(C8003R.id.sesl_floating_toolbar_layout), (FloatingBottomLayout) activity.findViewById(C8003R.id.floating_bottom_layout));
        } else {
            WindowManagerCompat.getInstance().disableSystemBarInsets(this.mContainer);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IFragment
    public ViewContract.IMode getMode() {
        return this.mMode;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IFragment
    public int getModeIndex() {
        return this.mMode.getModeIndex();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        this.mPresenter.onActivityResult(i, i2, intent);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) throws Exception {
        super.onConfigurationChanged(configuration);
        updateWindowInsets();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.mAccessibilityManager = accessibilityManager;
        if (accessibilityManager != null) {
            accessibilityManager.addAccessibilityStateChangeListener(this.accessibilityStateChangeListener);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(@NotNull Menu menu, @NotNull MenuInflater menuInflater) {
        this.mMode.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(C8003R.layout.folderlist_fragment, (ViewGroup) null);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.common.listener.OnCustomKeyListener
    public boolean onCustomKeyEvent(int i, KeyEvent keyEvent) {
        return this.mMode.onCustomKeyEvent(i, keyEvent);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IFragment
    public void onDataChanged(int i) {
        this.mMode.onDataChanged(i);
        FolderPresenter folderPresenter = this.mPresenter;
        folderPresenter.setFastScrollerEnabled(folderPresenter.getFolderCount());
        AbsAppCompatActivity absAppCompatActivity = this.mActivityContract;
        if (absAppCompatActivity != null) {
            absAppCompatActivity.invalidateOptionsMenu();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.mPresenter.onDestroy();
        ActionMenuController actionMenuController = this.mActionMenuController;
        if (actionMenuController != null) {
            actionMenuController.onDestroy();
            this.mActionMenuController = null;
        }
        this.mModeFactory = null;
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        if (accessibilityManager != null) {
            accessibilityManager.removeAccessibilityStateChangeListener(this.accessibilityStateChangeListener);
        }
        OnBackPressedCallback onBackPressedCallback = this.mOnBackPressedCallback;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.remove();
            this.mOnBackPressedCallback = null;
        }
        unregisterWindowInsetManager();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        return this.mMode.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(@NotNull Menu menu) {
        this.mMode.onPrepareOptionsMenu();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() throws Exception {
        super.onResume();
        updateWindowInsets();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putInt(FolderConstants.KEY_FOLDER_MODE_INDEX, getModeIndex());
        this.mPresenter.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        OnBackPressedCallback onBackPressedCallback = this.mOnBackPressedCallback;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.setEnabled(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        OnBackPressedCallback onBackPressedCallback = this.mOnBackPressedCallback;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.setEnabled(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        FolderPenRecyclerView folderPenRecyclerView = (FolderPenRecyclerView) view.findViewById(C8003R.id.folderlist_recyclerview);
        this.mRecyclerView = folderPenRecyclerView;
        folderPenRecyclerView.setLayoutManager(new FolderLayoutManager(getContext()), 17);
        this.mRecyclerView.setBackgroundColor(getResources().getColor(C8003R.color.round_corner_color, null));
        this.mRecyclerView.seslSetGoToTopEnabled(true);
        if (!CommonUtil.isNotAvailableActivity(getActivity())) {
            this.mContainer = getActivity().findViewById(C8003R.id.activity_container);
        }
        this.mActionMenuController = new ActionMenuController(this, this.mRecyclerView, new ActionMenuController.OnClickNavigateListener() { // from class: com.samsung.android.support.senl.nt.app.main.folder.view.FolderListFragment.4
            @Override // com.samsung.android.support.senl.nt.app.main.common.view.ActionMenuController.OnClickNavigateListener
            public void onClick(boolean z) {
                FolderListFragment.this.onBackKeyDown();
            }
        }, null);
        this.mBottomMenuController = new BottomMenuController(this, this.mRecyclerView);
        int i = getArguments() != null ? getArguments().getInt(FolderConstants.KEY_FOLDER_MODE_INDEX) : 2;
        if (bundle != null) {
            i = bundle.getInt(FolderConstants.KEY_FOLDER_MODE_INDEX);
        }
        int i2 = i;
        this.mPresenter = new FolderPresenter(this, this.mRecyclerView, this, new DialogCreator(), i2);
        this.mModeFactory = new ModeFactory(this, 0);
        this.mPresenter.restoreInstanceState(bundle);
        setMode(i2);
        this.mPresenter.setObserveDataChanged();
        this.mPresenter.registerListener();
        setBackPressedListener();
        registerWindowInsetManager();
    }

    public void setActivityContract(AbsAppCompatActivity absAppCompatActivity) {
        this.mActivityContract = absAppCompatActivity;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IFragment
    public boolean setMode(int i) {
        BaseMode baseMode = this.mMode;
        if (baseMode != null) {
            if (baseMode.getModeIndex() == i) {
                return false;
            }
            this.mMode.onModeEnd();
        }
        AbstractC8014b.m7201c(i, "setMode ", "FolderListFragment");
        BaseMode mode = this.mModeFactory.getMode(i);
        this.mMode = mode;
        mode.onLayout();
        return true;
    }

    public FolderListFragment(Bundle bundle) {
        setArguments(bundle);
    }
}
