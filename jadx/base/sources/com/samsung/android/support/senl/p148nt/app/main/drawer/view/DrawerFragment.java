package com.samsung.android.support.senl.p148nt.app.main.drawer.view;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;
import androidx.core.math.MathUtils;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.notes.bixby.BixbyManager;
import com.samsung.android.support.notes.bixby.BixbyManagerContract;
import com.samsung.android.support.notes.bixby.bixby2.contract.IDrawerFragmentBixby2;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.DisplayCutoutCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.badge.BadgeHelper;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.WidgetInsetUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.view.FolderPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.common.view.layoutmanager.FolderLayoutManager;
import com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.DrawerPresenter;
import com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.ViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.Bixby2;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.SystemUi;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesDocumentCountEntry;
import java.util.ArrayList;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import p079T.RunnableC0284b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class DrawerFragment extends AbsFragment implements ViewContract {
    private static final String TAG = "DrawerFragment";
    private AbsAppCompatActivity mActivityContract;
    private View mDrawerContainerView;
    private DrawerLayout mDrawerLayout;
    private View mMainView;
    private DrawerPresenter mPresenter;
    private FolderPenRecyclerView mRecyclerView;
    private boolean mIsDragging = false;
    private boolean mIsScrolling = false;
    private boolean mIsFreeFormWindow = false;
    private final Runnable mShowNoteFabScrollFinished = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.drawer.view.DrawerFragment.1
        @Override // java.lang.Runnable
        public void run() {
            DrawerFragment.this.mIsScrolling = false;
        }
    };

    public DrawerFragment() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateDrawerLayout$0() {
    }

    private void updateDrawerLayout(boolean z) {
        if (CommonUtil.isNotAvailableActivity(getActivity())) {
            MainLogger.m7258i(TAG, "updateDrawerLayout# activity is destroyed");
            return;
        }
        if (this.mDrawerLayout == null || this.mDrawerContainerView == null) {
            MainLogger.m7255e(TAG, "updateDrawerLayout# not found drawerLayout");
            return;
        }
        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        float f = displayMetrics.widthPixels;
        float f4 = f / displayMetrics.density;
        float dimension = resources.getDimension(C8003R.dimen.sesl_drawer_view_floating_start_inset);
        int iApplyDimension = (int) ((f - dimension) * 0.86f);
        if (f4 > 479.0f) {
            iApplyDimension = (int) TypedValue.applyDimension(1, resources.getDimension(C8003R.dimen.drawer_fragment_max_width) / displayMetrics.density, displayMetrics);
        }
        int i = iApplyDimension + ((int) (dimension * 2.0f));
        this.mDrawerContainerView.setTranslationX(0.0f);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mDrawerContainerView.getLayoutParams();
        marginLayoutParams.width = i;
        if (z) {
            WidgetInsetUtils.applyWindowInsetsToDrawer(getActivity(), marginLayoutParams, new RunnableC0284b(10));
        }
        if (!z || !isDrawerOpen()) {
            this.mDrawerContainerView.setTranslationX(0.0f);
        } else if (LocaleUtils.isRTLMode()) {
            this.mDrawerContainerView.setTranslationX(-i);
        } else {
            this.mDrawerContainerView.setTranslationX(i);
        }
        this.mDrawerLayout.seslSetDrawerViewFloatingBlur(getContext(), this.mDrawerContainerView);
    }

    public void changedGcsEnableStatus() {
        DrawerPresenter drawerPresenter = this.mPresenter;
        if (drawerPresenter == null) {
            return;
        }
        drawerPresenter.getModel().updateGcsDoucumentMap();
        this.mPresenter.updateDrawerDisplayData();
    }

    public boolean closeDrawer(final boolean z, long j) {
        if (!isDrawerOpen()) {
            return false;
        }
        this.mDrawerLayout.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.drawer.view.DrawerFragment.5
            @Override // java.lang.Runnable
            public void run() {
                MainLogger.m7258i(DrawerFragment.TAG, "closeDrawer");
                DrawerFragment.this.mDrawerLayout.closeDrawer(DrawerFragment.this.mDrawerContainerView, z);
            }
        }, j);
        return true;
    }

    public View getDrawerContainerView() {
        return this.mDrawerContainerView;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.ViewContract
    public void initFolderDataMap() {
        AbsAppCompatActivity absAppCompatActivity = this.mActivityContract;
        if (absAppCompatActivity == null) {
            return;
        }
        absAppCompatActivity.initFolderDataMap();
    }

    public boolean isDrawerOpen() {
        DrawerLayout drawerLayout = this.mDrawerLayout;
        return drawerLayout != null && drawerLayout.isDrawerOpen(this.mDrawerContainerView);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.ViewContract
    public boolean isFreeFormWindow() {
        return this.mIsFreeFormWindow;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.ViewContract
    public boolean isNoteListScrolling() {
        return this.mActivityContract.isScrolling();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment, com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.ViewContract
    public boolean isRunningAnimator() {
        return this.mIsScrolling;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mIsFreeFormWindow != WindowManagerCompat.getInstance().isFreeFormWindow(getActivity()) && !DeviceUtils.isTabletModel()) {
            this.mIsFreeFormWindow = !this.mIsFreeFormWindow;
            MainLogger.m7258i(TAG, "onConfigurationChanged mIsFreeFormWindow# " + this.mIsFreeFormWindow);
            FolderPenRecyclerView folderPenRecyclerView = this.mRecyclerView;
            if (folderPenRecyclerView != null) {
                folderPenRecyclerView.getAdapter().notifyDataSetChanged();
            }
        }
        updateDrawerLayout(false);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(C8003R.layout.drawer_fragment, (ViewGroup) null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        MainLogger.m7254d(TAG, "onDestroy");
        DrawerPresenter drawerPresenter = this.mPresenter;
        if (drawerPresenter != null) {
            drawerPresenter.unregisterSharedPreferenceListener();
        }
        Bixby2.DrawerFragmentBixby2.getInstance().release();
        BixbyManager.getInstance().releaseDrawerFragment();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        DataManager.getInstance().destroySmartFilter();
        DrawerPresenter drawerPresenter = this.mPresenter;
        if (drawerPresenter != null) {
            drawerPresenter.onDestroyView();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment
    public void onFolderDeleteVerifySuccess() {
        DrawerPresenter drawerPresenter = this.mPresenter;
        if (drawerPresenter == null) {
            return;
        }
        drawerPresenter.onFolderDeleteVerifySuccess();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.ViewContract
    public void onFolderSelected(String str, int i) {
        if (FolderConstants.HolderType.isExecuteType(i)) {
            DataManager.getInstance().saveFolderExpandState(this.mPresenter.getModel().getFolderDataMap());
            this.mActivityContract.onExecuteItemSelected(i);
            return;
        }
        this.mActivityContract.onFolderSelected(str);
        closeDrawer(true, FolderConstants.HolderType.isRequireServerSyncType(i) ? 100L : 0L);
        if (i == 1008) {
            BadgeHelper.setCoeditHasBadge(false);
            BadgeHelper.setGcsHasDrawerBadge(false);
        } else if (i == 1007) {
            BadgeHelper.setGcsHasDrawerBadge(false);
        }
    }

    public void onFoldersDataMove(ArrayList<String> arrayList, String str) {
        this.mPresenter.onFoldersDataMove(arrayList, str);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        DrawerPresenter drawerPresenter = this.mPresenter;
        if (drawerPresenter != null) {
            drawerPresenter.onSaveInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        MainLogger.m7258i(TAG, "onViewCreated#");
        setHasOptionsMenu(true);
        FragmentActivity activity = getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            MainLogger.m7258i(TAG, "onViewCreated# activity is destroyed");
            return;
        }
        this.mMainView = activity.findViewById(C8003R.id.main_view_container);
        this.mDrawerContainerView = activity.findViewById(C8003R.id.drawer_fragment_container);
        DrawerLayout drawerLayout = (DrawerLayout) activity.findViewById(C8003R.id.drawer_layout);
        this.mDrawerLayout = drawerLayout;
        if (drawerLayout == null) {
            MainLogger.m7255e(TAG, "onViewCreated# not found drawerLayout");
            return;
        }
        drawerLayout.seslSetContentView(this.mMainView);
        this.mDrawerLayout.setImportantForAccessibility(2);
        this.mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() { // from class: com.samsung.android.support.senl.nt.app.main.drawer.view.DrawerFragment.2
            @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerClosed(@NotNull View view2) {
                if (DrawerFragment.this.getContext() != null) {
                    VoiceAssistantTTS.getInstance().sendTalkBackMessage(DrawerFragment.this.getContext().getString(C8003R.string.drawer_collapsed));
                }
            }

            @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerOpened(@NotNull View view2) {
                if (DrawerFragment.this.isAdded()) {
                    view2.requestFocus();
                    CommonSamsungAnalytics.insertLog("103");
                    if (DrawerFragment.this.mIsDragging) {
                        CommonSamsungAnalytics.insertLog("101", NotesSAConstants.EVENT_NOTESLIST_DRAWER_OPEN, "b");
                        DrawerFragment.this.mIsDragging = false;
                    } else {
                        CommonSamsungAnalytics.insertLog("101", NotesSAConstants.EVENT_NOTESLIST_DRAWER_OPEN, "a");
                    }
                    if (DrawerFragment.this.getContext() != null) {
                        VoiceAssistantTTS.getInstance().sendTalkBackMessage(DrawerFragment.this.getContext().getString(C8003R.string.drawer_expanded));
                    }
                }
            }

            @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerSlide(@NotNull View view2, float f) {
            }

            @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerStateChanged(int i) {
                if (DrawerFragment.this.isDrawerOpen() || i != 1) {
                    return;
                }
                DrawerFragment.this.mIsDragging = true;
            }
        });
        this.mIsFreeFormWindow = WindowManagerCompat.getInstance().isFreeFormWindow(getActivity()) && !NotesUtils.isTabletLayout(getContext());
        if (this.mDrawerContainerView == null) {
            return;
        }
        final Handler handler = new Handler(Looper.myLooper());
        this.mIsScrolling = false;
        FolderPenRecyclerView folderPenRecyclerView = (FolderPenRecyclerView) this.mDrawerContainerView.findViewById(C8003R.id.drawer_recyclerview);
        this.mRecyclerView = folderPenRecyclerView;
        folderPenRecyclerView.setLayoutManager(new FolderLayoutManager(getContext()), 9);
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.samsung.android.support.senl.nt.app.main.drawer.view.DrawerFragment.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                DrawerFragment.this.mIsScrolling = true;
                handler.removeCallbacks(DrawerFragment.this.mShowNoteFabScrollFinished);
                handler.postDelayed(DrawerFragment.this.mShowNoteFabScrollFinished, 1000L);
            }
        });
        DrawerPresenter drawerPresenter = new DrawerPresenter(this, this.mRecyclerView, this);
        this.mPresenter = drawerPresenter;
        if (bundle == null) {
            drawerPresenter.saveArguments(getArguments());
        } else {
            drawerPresenter.onRestoreInstanceState(bundle);
        }
        this.mPresenter.registerSharedPreferenceListener();
        BixbyManager.getInstance().registerDrawerFragmentBixby2(new BixbyManagerContract.IDrawerFragment() { // from class: com.samsung.android.support.senl.nt.app.main.drawer.view.DrawerFragment.4
            @Override // com.samsung.android.support.notes.bixby.BixbyManagerContract.IDrawerFragment
            public IDrawerFragmentBixby2 registerDrawerFragmentBixby2() {
                Bixby2.DrawerFragmentBixby2 drawerFragmentBixby2 = Bixby2.DrawerFragmentBixby2.getInstance();
                drawerFragmentBixby2.setDrawerLayout(DrawerFragment.this.mDrawerLayout);
                return drawerFragmentBixby2;
            }
        });
        updateDrawerLayout(true);
    }

    public void release() {
        if (this.mPresenter == null) {
            return;
        }
        DataManager.getInstance().saveFolderExpandState(this.mPresenter.getModel().getFolderDataMap());
    }

    public void setActivityContract(AbsAppCompatActivity absAppCompatActivity) {
        this.mActivityContract = absAppCompatActivity;
    }

    public void setDrawerTitleBold(String str) {
        DrawerPresenter drawerPresenter = this.mPresenter;
        if (drawerPresenter != null) {
            drawerPresenter.setDrawerTitleBold(str);
            return;
        }
        MainLogger.m7255e(TAG, "setFolderUuid# folderUuid : " + str + ", But DrawerFragment is not created yet");
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.putString(NotesConstants.KEY_FOLDER_UUID, str);
        }
    }

    public void setStatusBarAndNavigationBarColor(float f) {
        TypedValue typedValue = new TypedValue();
        getResources().getValue(C8003R.dimen.drawer_alpha_percent, typedValue, true);
        int argb = ColorUtils.compositeColors(Color.valueOf(ColorUtils.setAlphaComponent(getResources().getColor(C8003R.color.drawer_fragment_scrim_color, null), (int) MathUtils.clamp(f * 255.0f * typedValue.getFloat(), 0.0f, 255.0f))), Color.valueOf(getResources().getColor(DeviceInfo.isVSTModel() ? C8003R.color.noteslist_fragment_bg_color_for_vst : C8003R.color.noteslist_fragment_bg_color, null))).toArgb();
        getActivity().getWindow().getDecorView().setBackgroundColor(argb);
        SystemUi.setNavigationBarTheme(getActivity(), argb, !ContextUtils.isNightMode(getContext()));
        DisplayCutoutCompat.getInstance().setDisplayCutoutBGColor(getActivity(), argb);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.ViewContract
    public void updateDocumentCountMap(Map<String, NotesDocumentCountEntry> map) {
        AbsAppCompatActivity absAppCompatActivity = this.mActivityContract;
        if (absAppCompatActivity == null) {
            return;
        }
        absAppCompatActivity.updateDocumentCountMap(map);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.ViewContract
    public void updateDrawerBar() {
    }

    public void updateDrawerDisplayData() {
        DrawerPresenter drawerPresenter = this.mPresenter;
        if (drawerPresenter == null) {
            return;
        }
        drawerPresenter.updateDrawerDisplayData();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.ViewContract
    public void updateNewBadge() {
        AbsAppCompatActivity absAppCompatActivity = this.mActivityContract;
        if (absAppCompatActivity == null) {
            return;
        }
        absAppCompatActivity.updateDrawerIconWithBadge();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.ViewContract
    public void updateNoteViewByDrawerObserver(boolean z) {
        if (this.mActivityContract == null) {
            return;
        }
        MainLogger.m7254d(TAG, "updateNoteViewByDrawerObserver");
        this.mActivityContract.updateNoteViewByDrawerObserver(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.ViewContract
    public void verifyForDelete() {
        AbsAppCompatActivity absAppCompatActivity = this.mActivityContract;
        if (absAppCompatActivity == null) {
            return;
        }
        absAppCompatActivity.verifyForDelete();
    }

    public DrawerFragment(Bundle bundle) {
        setArguments(bundle);
    }
}
