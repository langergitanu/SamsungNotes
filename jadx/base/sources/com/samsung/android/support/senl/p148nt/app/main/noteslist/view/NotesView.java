package com.samsung.android.support.senl.p148nt.app.main.noteslist.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.google.android.material.appbar.AppBarLayout;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesActivityResultCallback;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.DemoUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.WidgetInsetUtils;
import com.samsung.android.support.senl.p148nt.app.common.widget.IFolderPathLayoutListener;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.common.handoff.MainHandoffManager;
import com.samsung.android.support.senl.p148nt.app.main.common.handoff.RunnableC8212b;
import com.samsung.android.support.senl.p148nt.app.main.common.task.EntryImprovementTask;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.view.ActionMenuController;
import com.samsung.android.support.senl.p148nt.app.main.common.view.BottomMenuController;
import com.samsung.android.support.senl.p148nt.app.main.common.view.BottomProgressCircleManager;
import com.samsung.android.support.senl.p148nt.app.main.common.view.NotesPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.common.view.TabletActionMenuController;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.checkdata.CheckedNoteInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.postprocessing.NotesListPostLaunch;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.postprocessing.NotesListPostResume;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.postprocessing.NotesListPostStart;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.NotesPresenter;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.handoff.NotesHandoffContentObserver;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.listener.ViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ViewParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.CustomSwipeRefreshLayout;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.DialogCreator;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.ModeContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.CoeditSpaceImpl;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.DummyImpl;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.GcsImpl;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.widget.FabMenuView;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.FTUConstants;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.HandoffUtils;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.model.collector.CollectController;
import com.samsung.android.support.senl.p148nt.model.converter.ConvertTaskManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;
import p044K.C0158a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NotesView implements ModeContract.IView, ViewContract.IView, EntryImprovementTask.TaskListener {
    private static final int ACTIVITY_STATE_PAUSED = 1;
    private static final int ACTIVITY_STATE_RESUMED = 2;
    private static final int ACTIVITY_STATE_STOPPED = 0;
    private static final String TAG = "NotesView";
    private final ActionMenuController mActionMenuController;
    private int mActivityState;
    private final BottomMenuController mBottomMenuController;
    private final Runnable mClearScrollToPositionRunnable;
    private final FabMenuView.Contract mFabMenuListener;
    private final FabMenuView mFabMenuView;
    private final AbsFragment mFragment;
    private final ModeContract.IFragment mFragmentContract;
    private final Handler mHandler;
    private NotesHandoffContentObserver mHandoffContentObserver;
    private boolean mIsScrollToTop;
    private BaseMode mMode;
    private final ModeFactory mModeFactory;
    private final NotesListPostLaunch mNotesListPostLaunch;
    private final NotesListPostResume mNotesListPostResume;
    private final NotesListPostStart mNotesListPostStart;
    private final NotesPenRecyclerView mNotesRecyclerView;
    private final NotesPresenter mPresenter;
    private int mScrollDelay;
    private Runnable mScrollToPositionRunnable;
    private final CustomSwipeRefreshLayout.Contract mSwipeRefreshListener;
    private final CustomSwipeRefreshLayout mSwipeRefreshView;
    private Runnable mUpdateListStateRunnable;

    /* JADX WARN: Multi-variable type inference failed */
    public NotesView(CustomSwipeRefreshLayout customSwipeRefreshLayout, AbsFragment absFragment, NotesPresenter notesPresenter, Bundle bundle) {
        Looper looperMyLooper = Looper.myLooper();
        Objects.requireNonNull(looperMyLooper);
        this.mHandler = new Handler(looperMyLooper);
        this.mIsScrollToTop = false;
        this.mScrollDelay = 0;
        this.mActivityState = 0;
        this.mUpdateListStateRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.NotesView.1
            @Override // java.lang.Runnable
            public void run() {
                StaggeredGridLayoutManager staggeredGridLayoutManager;
                if (!NotesUtils.isStaggeredGridLayout(NotesView.this.mNotesRecyclerView.getLayoutMode()) || (staggeredGridLayoutManager = (StaggeredGridLayoutManager) NotesView.this.mNotesRecyclerView.getLayoutManager()) == null) {
                    return;
                }
                staggeredGridLayoutManager.invalidateSpanAssignments();
            }
        };
        this.mClearScrollToPositionRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.NotesView.2
            @Override // java.lang.Runnable
            public void run() {
                NotesView.this.mPresenter.setLastOpenedSDocXUuid(null);
                NotesView.this.mPresenter.releaseNoteAnimation();
            }
        };
        this.mScrollToPositionRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.NotesView.3
            @Override // java.lang.Runnable
            public void run() {
                String lastOpenedSDocXUuid = NotesView.this.mPresenter.getLastOpenedSDocXUuid();
                int iFindScrollIndexOfDisplayData = NotesView.this.mIsScrollToTop ? 0 : TextUtils.isEmpty(lastOpenedSDocXUuid) ? -1 : NotesView.this.mPresenter.getDocumentMap().findScrollIndexOfDisplayData(lastOpenedSDocXUuid);
                StringBuilder sbM778t = AbstractC0541b.m778t(iFindScrollIndexOfDisplayData, "scrollToPosition# position : ", ", IsScrollToTop : ");
                sbM778t.append(NotesView.this.mIsScrollToTop);
                MainLogger.m7258i(NotesView.TAG, sbM778t.toString());
                if (iFindScrollIndexOfDisplayData >= 0) {
                    if (iFindScrollIndexOfDisplayData == 0) {
                        NotesView.this.mNotesRecyclerView.scrollToTop();
                    } else {
                        NotesView.this.mNotesRecyclerView.scrollToPosition(iFindScrollIndexOfDisplayData, false);
                    }
                    NotesView.this.setCollapseToolbarByScroll(iFindScrollIndexOfDisplayData);
                }
                NotesView.this.mHandler.removeCallbacks(NotesView.this.mClearScrollToPositionRunnable);
                NotesView.this.mHandler.postDelayed(NotesView.this.mClearScrollToPositionRunnable, NotesView.this.mIsScrollToTop ? 0L : 1000L);
                NotesView.this.setIsScrollToTop(false, 0);
            }
        };
        FabMenuView.Contract contract = new FabMenuView.Contract() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.NotesView.4
            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.Contract
            public int getModeIndex() {
                return NotesView.this.getModeIndex();
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.Contract
            public boolean getVerticalOffset() {
                return NotesView.this.mActionMenuController.getVerticalOffset();
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.Contract
            public void onNewNote(String str, int i) {
                NotesView.this.mFragmentContract.onNewNote(str, i);
            }
        };
        this.mFabMenuListener = contract;
        this.mSwipeRefreshListener = new CustomSwipeRefreshLayout.Contract() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.NotesView.5
            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.CustomSwipeRefreshLayout.Contract
            public boolean canChildScrollUp() {
                return NotesView.this.mNotesRecyclerView.canScrollVertically(-1);
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.CustomSwipeRefreshLayout.Contract
            public boolean isPenMultiSelectionMode(MotionEvent motionEvent) {
                return NotesView.this.mNotesRecyclerView.isPenMultiSelectionMode(motionEvent);
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.CustomSwipeRefreshLayout.Contract
            public boolean onSwipeRefresh() {
                return NotesView.this.getMode().onSwipeRefresh();
            }
        };
        this.mSwipeRefreshView = customSwipeRefreshLayout;
        NotesPenRecyclerView notesPenRecyclerView = (NotesPenRecyclerView) customSwipeRefreshLayout.findViewById(C8003R.id.noteslist_recyclerview);
        this.mNotesRecyclerView = notesPenRecyclerView;
        this.mFragment = absFragment;
        ModeContract.IFragment iFragment = (ModeContract.IFragment) absFragment;
        this.mFragmentContract = iFragment;
        this.mNotesListPostLaunch = new NotesListPostLaunch(absFragment.getPostLaunchToken(), absFragment.getPostStartToken());
        this.mNotesListPostResume = new NotesListPostResume(absFragment.getPostResumeToken());
        this.mNotesListPostStart = new NotesListPostStart(absFragment.getPostStartToken());
        ActionMenuController actionMenuControllerCreateActionMenuController = createActionMenuController();
        this.mActionMenuController = actionMenuControllerCreateActionMenuController;
        BottomMenuController bottomMenuController = new BottomMenuController(absFragment, notesPenRecyclerView);
        this.mBottomMenuController = bottomMenuController;
        this.mPresenter = notesPresenter;
        notesPresenter.initPresenter(new ViewParams.ViewParamsBuilder().setAbsFragment(absFragment).setNotesView(this).setNotesRecyclerView(notesPenRecyclerView).setNotesListContainer(customSwipeRefreshLayout).setDialogCreator(new DialogCreator()).build());
        this.mModeFactory = new ModeFactory(new ModeParams().setActionMenuController(actionMenuControllerCreateActionMenuController).setBottomMenuController(bottomMenuController).setPresenter(notesPresenter).setNotesRecyclerView(notesPenRecyclerView).setNotesView(this).setFragmentContract(iFragment));
        addPostLaunchLogic();
        if (bundle == null) {
            onNewInstanceState();
        } else {
            onRestoreInstanceState(bundle);
        }
        this.mFabMenuView = new FabMenuView(absFragment, notesPresenter, contract);
        int viewMode = FeatureUtils.getViewMode(notesPresenter.getStateInfo().getModeIndex());
        notesPresenter.setLayoutManager(viewMode);
        applyWindowInsets();
        setImproveEntryLogic(viewMode);
    }

    private void addPaddingForFolderPathLayout(boolean z) {
        if (z == this.mActionMenuController.getHasPaddingForFolderpathLayout()) {
            return;
        }
        this.mActionMenuController.setHasPaddingForFolderpathLayout(z);
        ViewModeUtils.updateRecyclerViewFadingEdge(this.mNotesRecyclerView, this.mActionMenuController.getHasPaddingForFolderpathLayout(), this.mBottomMenuController.getFloatingBottomVisibility() == 0);
        int dimension = (int) this.mFragment.getResources().getDimension(C8003R.dimen.noteslist_recycler_padding_top);
        if (z) {
            dimension += (int) this.mFragment.getResources().getDimension(C8003R.dimen.folderpath_layout_height_for_notesview_padding);
        }
        NotesPenRecyclerView notesPenRecyclerView = this.mNotesRecyclerView;
        notesPenRecyclerView.setPadding(notesPenRecyclerView.getPaddingStart(), dimension, this.mNotesRecyclerView.getPaddingEnd(), this.mNotesRecyclerView.getPaddingBottom());
        if (z) {
            scrollToTopOnFolderSelected();
        }
    }

    private void addPostLaunchLogic() {
        PostLaunchManager.getInstance().addLogic(this.mFragment.getPostLaunchToken(), 105, new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.NotesView.6
            @Override // java.lang.Runnable
            public void run() {
                NotesView.this.mPresenter.onPostLaunch();
                NotesView.this.mFabMenuView.inflateFab();
                NotesView.this.mSwipeRefreshView.initView(NotesView.this.mSwipeRefreshListener);
                new EntryImprovementTask(NotesView.this.mFragment.getActivity()).run(new EntryImprovementTask.TaskParams(false, NotesView.this.mNotesRecyclerView, -1, FeatureUtils.isSubFolderExist(NotesView.this.mPresenter.getStateInfo().getModeIndex(), NotesView.this.mPresenter.getStateInfo().getFolderUuid()), NotesView.this));
                PermissionHelper.noticeAppPermissionIfNeededs(NotesView.this.mFragment.getActivity());
                NotesView.this.importDemoSamples();
                TaskState companion = TaskState.INSTANCE.getInstance();
                TaskState.Type.Companion companion2 = TaskState.Type.INSTANCE;
                if (!companion.isRunning("CONVERT")) {
                    CollectController.getInstance().collectReadyState(false);
                }
                CollectController.getInstance().collectSavingByWhichPid();
                if (FeatureUtils.isNoteListHandoffSupported(NotesView.this.getModeIndex())) {
                    NotesView.this.mHandoffContentObserver = new NotesHandoffContentObserver();
                    NotesView.this.mHandoffContentObserver.initialize(NotesView.this.mFragment, NotesView.this.mPresenter, new NotesHandoffContentObserver.Contract() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.NotesView.6.1
                        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.handoff.NotesHandoffContentObserver.Contract
                        public void requestUnregisterNoteHandoffObserver() {
                            NotesView.this.unregisterNoteHandoffObserver();
                        }
                    });
                    HandoffUtils.getInstance().registerContentObserver(NotesView.this.mHandoffContentObserver);
                    NotesView.this.mHandoffContentObserver.updateHandoffInfo();
                }
            }
        });
    }

    private void clearOldModeData(String str) {
        this.mFragmentContract.setDrawerTitleBold(str);
        this.mPresenter.clearCheckedData();
        this.mPresenter.deleteCheckedNoteDataFile(this.mFragment.getContext());
    }

    @NonNull
    @SuppressLint({WarningType.NewApi})
    private Runnable getUpdateRunnable(String str, int i, int i2) {
        return new RunnableC8212b(this, i, i2, str, 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean hasActivityAction(@NonNull Bundle bundle) {
        boolean z = false;
        if (this.mFragment.getActivity() == null) {
            return false;
        }
        Intent intent = this.mFragment.getActivity().getIntent();
        String action = intent.getAction();
        if (NotesConstants.ACTION_VIEW_ALL_NOTES.equals(action)) {
            bundle.putString(NotesConstants.KEY_FOLDER_UUID, FolderConstants.AllNotes.UUID);
            bundle.putInt("mode", 1);
            intent.setAction("android.intent.action.VIEW");
        } else if (NotesConstants.ACTION_VIEW_TRASH.equals(action)) {
            NotesUtils.openTrashByOtherApps();
            bundle.putString(NotesConstants.KEY_FOLDER_UUID, FolderConstants.RecycleBin.UUID);
            bundle.putInt("mode", 5);
            intent.setAction("android.intent.action.VIEW");
        } else if (NotesConstants.ACTION_VIEW_CO_EDIT.equals(action) && C0158a.m409d(this.mFragment.getContext())) {
            FTUConstants.setCoeditOpenedByNotification();
            bundle.putString(NotesConstants.KEY_FOLDER_UUID, FolderConstants.Coedit.UUID);
            if (intent.hasExtra("spaceId")) {
                bundle.putInt("mode", 14);
                bundle.putString(Constants.KEY_GROUP_ID, intent.getStringExtra("groupId"));
                bundle.putString(Constants.KEY_SPACE_ID, intent.getStringExtra("spaceId"));
            } else {
                bundle.putInt("mode", 12);
            }
            intent.setAction("android.intent.action.VIEW");
        } else {
            if (!Constants.ACTION_START_SHARED_NOTES.equals(action)) {
                if (MainHandoffManager.INSTANCE.getInstance().isHandoffAction(intent)) {
                }
                if (z) {
                    MainLogger.m7254d(TAG, "hasActivityAction# modeIndex : " + bundle.getInt("mode") + ", folderUuid : " + bundle.getString(NotesConstants.KEY_FOLDER_UUID));
                }
                return z;
            }
            goToGcsMode(bundle, intent);
        }
        z = true;
        if (z) {
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createActionMenuController$0(boolean z) {
        if (CommonUtil.isNotAvailableActivity(this.mFragment.getActivity())) {
            return;
        }
        getMode().onBackKeyDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$createActionMenuController$1() {
        return this.mPresenter.getStateInfo().getModeIndex();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createActionMenuController$2(boolean z) {
        if (z) {
            getMode().onBackKeyDown();
        } else {
            this.mFragmentContract.openDrawer(8388611);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$createActionMenuController$3() {
        return this.mPresenter.getStateInfo().getModeIndex();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getUpdateRunnable$4(int i, int i2, String str) throws Exception {
        if (i != -1) {
            setMode(i);
        }
        this.mPresenter.onFolderSelected(str, FeatureUtils.getUpdateDataIndex(i2) == FeatureUtils.getUpdateDataIndex(i));
        setFolderPathLayoutVisibility(str);
        this.mFragmentContract.setDrawerTitleBold(str);
        setNoteFabVisibleWithAnimation();
        this.mPresenter.getBackPressedHelper().updateOnBackInvokedCallback();
    }

    private void onCoeditSpaceSelected(String str, String str2, String str3) throws Exception {
        AbstractC0000a.m25v("onCoeditSpaceSelected# folderUuid : ", str, TAG);
        this.mPresenter.getCoeditHelper().onSpaceSelected(str2, str3);
        this.mPresenter.onFolderSelected(str, true);
        setFolderPathLayoutVisibility(str);
        this.mFragmentContract.setDrawerTitleBold(str);
        setNoteFabVisibleWithAnimation();
    }

    private void onNewInstanceState() {
        setSyncModeAndFilter(this.mFragment.getArguments());
        this.mPresenter.saveArguments(this.mFragment.getArguments());
        setMode(this.mPresenter.getStateInfo().getModeIndex());
    }

    private void onRestoreDataChanged(int i) {
        AbstractC8014b.m7201c(i, "onRestoreDataChanged# count : ", TAG);
        this.mMode.onRestoreDataChanged(i);
        updateViewByDataChanged(i);
    }

    private void releaseDeletedFolder() throws Exception {
        MainLogger.m7258i(TAG, "releaseDeletedFolder");
        NotesPresenter notesPresenter = this.mPresenter;
        String str = FolderConstants.MyFolders.UUID;
        notesPresenter.onFolderSelected(str, true);
        this.mFragmentContract.setDrawerTitleBold(str);
        setFolderPathLayoutVisibility(str);
        setNoteFabVisibleWithAnimation();
    }

    private boolean releaseEmptyFolderByDrawer(String str) {
        MainLogger.m7254d(TAG, "releaseEmptyFolderByDrawer");
        String str2 = FolderConstants.AllNotes.UUID;
        if (str2.equals(str) || !this.mPresenter.getDocumentMap().nonNullDocumentCountMap()) {
            return false;
        }
        if ("old_converted_notes".equals(str) || FolderConstants.OldNotes.UUID.equals(str)) {
            if (this.mPresenter.getDocumentMap().getDocumentCount(FolderConstants.OldNotes.UUID) + this.mPresenter.getDocumentMap().getDocumentCount("old_converted_notes") <= 0) {
                onFolderSelected(str2);
                return true;
            }
        } else if (this.mPresenter.getDocumentMap().getDocumentCount(str) <= 0) {
            onFolderSelected(str2);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCollapseToolbarByScroll(int i) {
        boolean zIsLastItemNotDisplaying;
        AppBarLayout appBarLayout;
        if (NotesUtils.isLinearLayout(this.mNotesRecyclerView.getLayoutMode())) {
            int iFindLastCompletelyVisibleItemPosition = ((LinearLayoutManager) this.mNotesRecyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
            zIsLastItemNotDisplaying = i > iFindLastCompletelyVisibleItemPosition && iFindLastCompletelyVisibleItemPosition != -1;
        } else {
            zIsLastItemNotDisplaying = this.mNotesRecyclerView.isLastItemNotDisplaying(i);
        }
        AbstractC6670b.m4739D("setCollapseToolbarByScroll# setExpanded : ", TAG, zIsLastItemNotDisplaying);
        if (!zIsLastItemNotDisplaying || (appBarLayout = this.mActionMenuController.getAppBarLayout()) == null) {
            return;
        }
        appBarLayout.setExpanded(false);
    }

    private void setImproveEntryLogic(int i) {
        new EntryImprovementTask(this.mFragment.getActivity()).run(new EntryImprovementTask.TaskParams(true, this.mNotesRecyclerView, i, FeatureUtils.isSubFolderExist(this.mPresenter.getStateInfo().getModeIndex(), this.mPresenter.getStateInfo().getFolderUuid()), this));
    }

    private void setSyncModeAndFilter(@Nullable Bundle bundle) {
        int i;
        if (bundle == null || hasActivityAction(bundle)) {
            return;
        }
        int i2 = bundle.getInt(NotesConstants.KEY_CALLER, 0);
        int i4 = 1;
        int i5 = bundle.getInt("mode", 1);
        String string = bundle.getString(NotesConstants.KEY_FOLDER_UUID, NotesUtils.getLastSelectedFolder());
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i2, i5, "setSyncModeAndFilter# caller : ", ", modeIndex : ", ", folderUuid : ");
        sbM1173s.append(string);
        MainLogger.m7254d(TAG, sbM1173s.toString());
        if (FeatureUtils.isExecuteType(i5) || FeatureUtils.isSearchMode(i5)) {
            return;
        }
        if (i2 != 12) {
            if (!FolderConstants.RecycleBin.UUID.equals(string)) {
                if (FolderConstants.Coedit.UUID.equals(string)) {
                    if (FeatureUtils.isCoeditSpaceMode(i5)) {
                        i = FeatureUtils.isEditMode(i5) ? 15 : 14;
                    } else if (FeatureUtils.isEditMode(i5)) {
                        i = 13;
                    } else {
                        i4 = 12;
                    }
                } else if (FolderConstants.OldNotes.UUID.equals(string)) {
                    string = FolderConstants.AllNotes.UUID;
                    clearOldModeData(string);
                } else if (FolderConstants.SharedNotes.UUID.equals(string)) {
                    if (i5 == 1) {
                        string = FolderConstants.AllNotes.UUID;
                    }
                } else if (!FeatureUtils.isHashTagMode(i5)) {
                    if (FeatureUtils.isEditMode(i5)) {
                        i4 = 2;
                    }
                }
                bundle.putInt("mode", i4);
                bundle.putString(NotesConstants.KEY_FOLDER_UUID, string);
                MainLogger.m7254d(TAG, "setSyncModeAndFilter# updated modeIndex : " + i4 + ", folderUuid : " + string);
            }
            i = FeatureUtils.isEditMode(i5) ? 6 : 5;
            i4 = i;
            bundle.putInt("mode", i4);
            bundle.putString(NotesConstants.KEY_FOLDER_UUID, string);
            MainLogger.m7254d(TAG, "setSyncModeAndFilter# updated modeIndex : " + i4 + ", folderUuid : " + string);
        }
        string = FolderConstants.MathNotes.UUID;
        i4 = i5;
        bundle.putInt("mode", i4);
        bundle.putString(NotesConstants.KEY_FOLDER_UUID, string);
        MainLogger.m7254d(TAG, "setSyncModeAndFilter# updated modeIndex : " + i4 + ", folderUuid : " + string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterNoteHandoffObserver() {
        if (this.mHandoffContentObserver != null) {
            HandoffUtils.getInstance().unregisterContentObserver(this.mHandoffContentObserver);
            this.mHandoffContentObserver = null;
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.common.task.EntryImprovementTask.TaskListener
    public void addInflatedView(@org.jetbrains.annotations.Nullable View view) {
        this.mPresenter.addInflatedView(view);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.common.task.EntryImprovementTask.TaskListener
    public void addSubFolderBitmap(int i, int i2, @NotNull Drawable drawable) {
        this.mPresenter.addSubFolderBitmap(i, i2, drawable);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.common.task.EntryImprovementTask.TaskListener
    public void addSubHeaderInflatedView(@org.jetbrains.annotations.Nullable View view) {
        this.mPresenter.addSubHeaderInflatedView(view);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IView, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void applyWindowInsets() {
        FragmentActivity activity = this.mFragment.getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        if (!WidgetInsetUtils.getCanUseWindowInsets()) {
            WindowManagerCompat.getInstance().disableSystemBarInsetsWithIme(this.mFragmentContract.getNoteParentView());
            return;
        }
        RecyclerView recyclerView = getModeIndex() == 24 ? (RecyclerView) activity.findViewById(C8003R.id.shared_notebook_recyclerview) : getModeIndex() == 23 ? (RecyclerView) activity.findViewById(C8003R.id.old_note_list) : this.mNotesRecyclerView;
        if (recyclerView == null) {
            MainLogger.m7254d(TAG, "applyWindowInsets# recyclerView is null");
        } else {
            WidgetInsetUtils.applyWindowInsetsForList(activity.getWindow(), this.mFragmentContract.getNoteParentView(), recyclerView, this.mFragmentContract.getDrawerView(), this.mActionMenuController.getAppBarLayout(), this.mFabMenuView.getNoteFabLayout(), this.mFabMenuView.getNoteFakeFabLayout(), this.mPresenter.getFloatingToolbarLayout(), this.mPresenter.getFloatingBottomLayout());
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void changedGcsDisable() {
        this.mFragmentContract.changedGcsDisable();
    }

    public ActionMenuController createActionMenuController() {
        return NotesUtils.isTabletLayout(this.mFragment.getActivity()) ? new TabletActionMenuController(this.mFragment, this.mNotesRecyclerView, new C8587a(this, 0), new C8587a(this, 1)) : new ActionMenuController(this.mFragment, this.mNotesRecyclerView, new C8587a(this, 2), new C8587a(this, 3));
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void dragAndDropFinished(String str) {
        this.mFragmentContract.dragAndDropFinished(str);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IView
    public void filteredInvalidateOptionsMenu() {
        if (this.mNotesRecyclerView.isLongPressed() || this.mFragment.getActivity() == null) {
            return;
        }
        if ((FeatureUtils.isEditMode(getModeIndex()) && ConvertTaskManager.getInstance().findConvertTaskGroup(2, 4, null)) || BottomProgressCircleManager.getInstance().isProgressOn()) {
            return;
        }
        long currentOptionsMenuStatus = getMode().getCurrentOptionsMenuStatus();
        long lastOptionsMenuStatus = getMode().getLastOptionsMenuStatus();
        StringBuilder sbM1323p = AbstractC1974b.m1323p(currentOptionsMenuStatus, "filteredInvalidateOptionsMenu current# ", " last# ");
        sbM1323p.append(lastOptionsMenuStatus);
        MainLogger.m7258i(TAG, sbM1323p.toString());
        if (currentOptionsMenuStatus == lastOptionsMenuStatus) {
            return;
        }
        this.mFragment.getActivity().invalidateOptionsMenu();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public View getContainer() {
        return this.mFragmentContract.getNoteParentView();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IView
    public GcsImpl getGcsImpl() {
        int modeIndex = this.mMode.getModeIndex();
        return (24 == modeIndex || FeatureUtils.isGcsSpaceMode(modeIndex)) ? (GcsImpl) this.mMode : new DummyImpl();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IView, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public ViewContract.IMode getMode() {
        return this.mMode;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public int getModeIndex() {
        BaseMode baseMode = this.mMode;
        if (baseMode != null) {
            return baseMode.getModeIndex();
        }
        MainLogger.m7255e(TAG, "getModeIndex# Mode is not define");
        return -1;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IView, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public SearchImpl getSearchImpl() {
        return FeatureUtils.isSearchMode(this.mMode.getModeIndex()) ? (SearchImpl) this.mMode : new DummyImpl();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public CoeditSpaceImpl getSpaceImpl() {
        return FeatureUtils.isCoeditMode(this.mMode.getModeIndex()) ? (CoeditSpaceImpl) this.mMode : new DummyImpl();
    }

    public void goToGcsMode(Bundle bundle, Intent intent) {
        MainLogger.m7254d(TAG, "goToGcsMode#");
        if (bundle == null) {
            return;
        }
        if (!NotesUtils.isMDEFeatureEnabled()) {
            MainLogger.m7254d(TAG, "goToGcsMode# isMDEFeatureEnabled false");
        }
        bundle.putString(NotesConstants.KEY_FOLDER_UUID, FolderConstants.SharedNotes.UUID);
        if (intent.hasExtra("spaceId")) {
            bundle.putInt("mode", 10);
            bundle.putString(Constants.KEY_GROUP_ID, intent.getStringExtra("groupId"));
            bundle.putString(Constants.KEY_SPACE_ID, intent.getStringExtra("spaceId"));
        } else {
            bundle.putInt("mode", 24);
        }
        intent.setAction("android.intent.action.VIEW");
    }

    public void importDemoSamples() {
        final String[] storagePermissions = PermissionCompat.getStoragePermissions(4);
        Runnable runnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.NotesView.7
            @Override // java.lang.Runnable
            public void run() {
                PermissionHelper.requestPermissions(NotesView.this.mFragment, 101, storagePermissions);
            }
        };
        if (DeviceUtils.isUnpackDevice()) {
            if (PermissionHelper.isPermissionGranted(this.mFragment.getActivity(), runnable, storagePermissions)) {
                DemoUtils.loadUnpackFile(this.mFragment.getContext());
            }
        } else if (DeviceUtils.isShopDemoDevice(this.mFragment.getContext()) && PermissionHelper.isPermissionGranted(this.mFragment.getActivity(), runnable, storagePermissions)) {
            DemoUtils.loadLDUFile(this.mFragment.getContext());
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void initFolderForBixby() {
        if (getModeIndex() != 1) {
            setMode(1);
        }
        Bundle arguments = this.mFragment.getArguments();
        if (arguments != null) {
            arguments.putString(NotesConstants.KEY_FOLDER_UUID, FolderConstants.AllNotes.UUID);
        }
        NotesPresenter notesPresenter = this.mPresenter;
        String str = FolderConstants.AllNotes.UUID;
        notesPresenter.onFolderSelected(str, true);
        setFolderPathLayoutVisibility(str);
        this.mFragmentContract.setDrawerTitleBold(str);
        setNoteFabVisibleWithAnimation();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void launchActivity(Intent intent, NotesActivityResultCallback notesActivityResultCallback) {
        this.mFragmentContract.launchActivity(intent, notesActivityResultCallback);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void launchPopOverActivity(Intent intent, int i, NotesActivityResultCallback notesActivityResultCallback) {
        this.mFragmentContract.launchPopOverActivity(intent, i, notesActivityResultCallback);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.common.task.EntryImprovementTask.TaskListener
    public boolean needInflatedView() {
        return this.mPresenter.needInflatedView();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void onActivityResultAfterVerify(int i, int i2, @Nullable Intent intent) {
        this.mFragmentContract.onActivityResultAfterVerify(i, i2, intent);
    }

    public void onActivityResultForSaveExport(Intent intent) {
        String pathFromResult = ContentPickerUtils.getPathFromResult(this.mFragment.getContext(), intent);
        MainLogger.m7258i(TAG, "onActivityResultForSaveExport# dir : " + MainLogger.getEncode(pathFromResult));
        ArrayList<CheckedNoteInfo> saveExportNoteList = this.mPresenter.getSaveExportNoteList();
        if (saveExportNoteList == null || saveExportNoteList.size() != 1 || this.mPresenter.getCheckedNotesCount() > 1) {
            this.mPresenter.executeSaveAsTask(pathFromResult, null);
        } else {
            this.mPresenter.showSaveExportRenameDialog(intent, saveExportNoteList.get(0));
        }
    }

    public void onActivityResultFromComposer(Intent intent, boolean z) {
        String stringExtra = intent.getStringExtra("category_id");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        if (z && FeatureUtils.isRecyclebinMode(getModeIndex())) {
            return;
        }
        if (z) {
            onFolderSelected(stringExtra);
            return;
        }
        String folderUuid = this.mPresenter.getStateInfo().getFolderUuid();
        if (FeatureUtils.isPreDefinedFolderUuid(folderUuid) || stringExtra.equals(folderUuid) || getModeIndex() == 3) {
            return;
        }
        if (!FeatureUtils.isCoeditFilterType(stringExtra)) {
            onFolderSelected(stringExtra);
        } else if (intent.getBooleanExtra(ComposerConstants.ARG_MDE_COEDIT_STAND_ALONE, true)) {
            onFolderSelected(stringExtra);
        } else {
            onCoeditSpaceSelected(stringExtra, intent.getStringExtra(ComposerConstants.ARG_MDE_GROUP_ID), intent.getStringExtra(ComposerConstants.ARG_MDE_SPACE_ID));
        }
    }

    public boolean onActivityResultFromHandoff(int i, int i2, Intent intent) {
        NotesHandoffContentObserver notesHandoffContentObserver = this.mHandoffContentObserver;
        if (notesHandoffContentObserver == null) {
            return false;
        }
        return notesHandoffContentObserver.handleActivityResult(i, i2, intent);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void onBackInvoked() {
        this.mFragmentContract.onBackInvoked();
    }

    public boolean onBackKeyDown() {
        FabMenuView fabMenuView = this.mFabMenuView;
        if (fabMenuView == null || !fabMenuView.onBackKeyDown(false)) {
            return this.mMode.onBackKeyDown();
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IView
    public void onConfigurationChanged() {
        this.mPresenter.onConfigurationChanged();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public boolean onContextClick(CommonHolderInfo commonHolderInfo) {
        return this.mMode.onContextClick(commonHolderInfo);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void onDataChanged(int i, String str) {
        AbstractC8014b.m7212n(AbstractC2322a.m1629s("onDataChanged# count : ", i, ", caller : ", str, ", ScrollDelay : "), TAG, this.mScrollDelay);
        this.mMode.onDataChangedViewUpdate(i);
        updateViewByDataChanged(i);
        this.mHandler.removeCallbacks(this.mScrollToPositionRunnable);
        this.mHandler.postDelayed(this.mScrollToPositionRunnable, this.mScrollDelay);
    }

    public void onDestroy() {
        this.mMode.onDestroy();
        this.mPresenter.onDestroy(this.mFragment.getActivity().hashCode());
        this.mActionMenuController.onDestroy();
        this.mFabMenuView.onDestroy();
        this.mHandler.removeCallbacks(this.mScrollToPositionRunnable);
        this.mHandler.removeCallbacks(this.mUpdateListStateRunnable);
        this.mScrollToPositionRunnable = null;
        this.mUpdateListStateRunnable = null;
        unregisterNoteHandoffObserver();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IView, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    @SuppressLint({WarningType.NewApi})
    public void onFolderSelected(String str) {
        if (this.mNotesRecyclerView == null) {
            return;
        }
        String folderUuid = this.mPresenter.getStateInfo().getFolderUuid();
        int modeIndex = getModeIndex();
        int searchCallerMode = this.mPresenter.getStateInfo().getSearchCallerMode();
        StringBuilder sbM16m = AbstractC0000a.m16m("onFolderSelected# folderUuid : ", str, ", currentFolderUuid : ", folderUuid, ", modeIndex : ");
        sbM16m.append(modeIndex);
        sbM16m.append(", searchCallerModeIndex : ");
        sbM16m.append(searchCallerMode);
        MainLogger.m7258i(TAG, sbM16m.toString());
        if (str == null || this.mPresenter.getDocumentMap().getFolderData(str) == null) {
            return;
        }
        if (str.equals(FolderConstants.RecycleBin.UUID)) {
            searchCallerMode = 5;
        } else if (str.equals(FolderConstants.Coedit.UUID)) {
            if (C0158a.f491k || !getSpaceImpl().isEnabledStatus()) {
                MainLogger.m7255e(TAG, "onFolderSelected#isSocialErrorRaised true, folderUuid : ".concat(str));
                return;
            }
            searchCallerMode = 12;
        } else if (str.equals(FolderConstants.SharedNotes.UUID)) {
            if (C0158a.f491k) {
                MainLogger.m7255e(TAG, "onFolderSelected#isSocialErrorRaised true, folderUuid : ".concat(str));
                return;
            }
            searchCallerMode = 24;
        } else if (str.equals(FolderConstants.OldNotes.UUID)) {
            searchCallerMode = 23;
        } else if (!FeatureUtils.isPickMode(searchCallerMode)) {
            searchCallerMode = !FeatureUtils.isPickMode(modeIndex) ? 1 : -1;
        }
        Runnable updateRunnable = getUpdateRunnable(str, searchCallerMode, modeIndex);
        if (modeIndex != 1 || !FeatureUtils.isSubFolderExist(modeIndex, str) || FeatureUtils.canDeleteFolderPathLayout(modeIndex, str) || getMode().hasCreatePostLogic()) {
            updateRunnable.run();
        } else {
            this.mPresenter.updateRecyclerViewLayoutMode(updateRunnable);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void onImportPdf(String str, int i, List<Uri> list) {
        this.mFragmentContract.onImportPdf(str, i, list);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IView, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void onNewNote(String str, int i) {
        this.mFragmentContract.onNewNote(str, i);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IView
    public void onNewNoteStyleNote(Intent intent) {
        this.mFragmentContract.onNewNoteStyleNote(intent);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void onNoteSelectedWidget(MainEntryParam mainEntryParam) {
        this.mFragmentContract.onNoteSelectedWidget(mainEntryParam);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void onOldCategorySelected(String str) throws Exception {
        AbstractC8014b.m7209k("onOldCategorySelected# categoryUuid : ", str, TAG);
        this.mPresenter.getStateInfo().setCategoryUuid(str);
        setMode(21);
        NotesPresenter notesPresenter = this.mPresenter;
        String str2 = FolderConstants.OldNotes.UUID;
        notesPresenter.onFolderSelected(str2, false);
        setFolderPathLayoutVisibility(str2);
        this.mFragmentContract.setDrawerTitleBold(str2);
        setNoteFabVisibleWithAnimation();
    }

    public void onPause() {
        this.mActivityState = 1;
        this.mNotesListPostResume.inactivate();
        this.mMode.onPaused();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void onRestoreCorruptedNoteSelect(MainEntryParam mainEntryParam) {
        this.mFragmentContract.onRestoreCorruptedNoteSelect(mainEntryParam);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        MainLogger.m7254d(TAG, "onRestoreInstanceState");
        setSyncModeAndFilter(bundle);
        this.mPresenter.onRestoreInstanceState(bundle);
        setMode(this.mPresenter.getStateInfo().getModeIndex());
        onRestoreDataChanged(this.mPresenter.getDocumentMap().getCommonDisplayListSize(new String[0]));
        this.mMode.onRestoreInstanceState(bundle);
        filteredInvalidateOptionsMenu();
        this.mPresenter.onRestoreProgressCircle();
        stopSwipeRefreshLayout();
    }

    public void onResume() {
        this.mActivityState = 2;
        Trace.beginSection("NotesView Resume(MainList)");
        this.mMode.onResume();
        this.mPresenter.onResume();
        this.mNotesListPostResume.activate(this.mNotesRecyclerView);
        Trace.endSection();
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.mMode.onSaveInstanceState(bundle);
        this.mPresenter.onSaveInstanceState(bundle);
        if (NotesUtils.isExceedBundleSize(bundle)) {
            bundle.clear();
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void onScrollStateChanged(int i) {
        if (i == 0) {
            ViewModeUtils.updateFloatingLayoutShadow(this.mNotesRecyclerView, this.mBottomMenuController.getMFloatingBottomLayout(), this.mActionMenuController.getMultiFloatingView(), this.mActionMenuController.getFloatingToolbarLayout());
        } else if (!this.mPresenter.isScrolling()) {
            ViewModeUtils.updateScrollingFloatingLayoutShadow(this.mNotesRecyclerView, this.mBottomMenuController.getMFloatingBottomLayout(), this.mActionMenuController.getMultiFloatingView(), this.mActionMenuController.getFloatingToolbarLayout());
        }
        FabMenuView fabMenuView = this.mFabMenuView;
        if (fabMenuView != null) {
            fabMenuView.onListScrollStateChanged();
        }
        this.mPresenter.onScrollStateChanged(i);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void onScrolled(int i) {
        FabMenuView fabMenuView = this.mFabMenuView;
        if (fabMenuView != null) {
            fabMenuView.onListScrolled(i);
        }
        this.mPresenter.onScrolled(i);
    }

    public void onStart() {
        this.mActivityState = 1;
        Trace.beginSection("NotesView onStart(MainList)");
        this.mNotesListPostLaunch.activate();
        this.mNotesListPostStart.activate(this.mNotesRecyclerView);
        Trace.endSection();
        this.mPresenter.updateRecyclerView();
    }

    public void onStop() {
        this.mActivityState = 0;
        this.mNotesListPostLaunch.inactivate();
        this.mNotesListPostStart.inactivate();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IView, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void onTagSelected() {
        if (this.mNotesRecyclerView == null) {
            return;
        }
        MainLogger.m7258i(TAG, "onTagSelected# currentFolderUuid : " + this.mPresenter.getStateInfo().getFolderUuid() + ", modeIndex : " + getModeIndex());
        setMode(18);
        setIsScrollToTop(true, 0);
        setNoteFabVisibleWithAnimation();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void onTagSelectedFromTagActivity(@NotNull Set<String> set) {
        this.mFragmentContract.onTagSelectedFromTagActivity(set);
    }

    public void onViewChangeRestoreInstanceState(Bundle bundle) {
        onRestoreInstanceState(bundle);
        this.mMode.onViewChangeRestoreInstanceState();
        this.mPresenter.onViewChangeRestoreInstanceState(bundle);
    }

    public void onViewChangeSaveInstanceState(Bundle bundle) {
        this.mMode.onSaveInstanceState(bundle);
        this.mMode.onViewChangeSaveInstanceState();
        this.mPresenter.onViewChangeSaveInstanceState(bundle);
    }

    public void onWindowFocusChanged(boolean z) {
        if (getModeIndex() == 2) {
            this.mMode.onWindowFocusChanged(z);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IView
    public void releaseEmptyFolder() {
        MainLogger.m7254d(TAG, "releaseEmptyFolder");
        NotesPresenter notesPresenter = this.mPresenter;
        String str = FolderConstants.AllNotes.UUID;
        notesPresenter.onFolderSelected(str, false);
        this.mFragmentContract.setDrawerTitleBold(str);
        setNoteFabVisibleWithAnimation();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void scrollToTopOnFolderSelected() {
        MainLogger.m7254d(TAG, "scrollToTopOnFolderSelected#");
        if (!this.mActionMenuController.isExpandedState()) {
            this.mActionMenuController.setFloatingToolbarExpanded(false);
        }
        this.mNotesRecyclerView.scrollToPosition(0, true);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void setCheckedDimNotes() {
        this.mPresenter.setCheckedDimmedNotes(this.mFragment.getArguments());
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void setDrawerIconDimDragStatus(boolean z, ArrayList<String> arrayList) {
        this.mFragmentContract.setDrawerIconDimDragStatus(z, arrayList);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IView
    public void setFolderPathLayoutVisibility(String str) throws Exception {
        boolean zCanDeleteFolderPathLayout = FeatureUtils.canDeleteFolderPathLayout(getModeIndex(), str);
        if (zCanDeleteFolderPathLayout || FolderConstants.MyFolders.UUID.equals(str)) {
            if (this.mActionMenuController.isFolderpathLayoutEmpty()) {
                return;
            }
            this.mActionMenuController.setFolderPathLayoutVisibility(8, !zCanDeleteFolderPathLayout);
            addPaddingForFolderPathLayout(false);
            return;
        }
        MainLogger.m7258i(TAG, "setFolderPathLayoutVisibility# Visible");
        if (!this.mActionMenuController.isFolderpathLayoutVisible()) {
            MainLogger.m7258i(TAG, "FolderPathLayoutVisibility# Gone to Visible");
            CommonSamsungAnalytics.insertLog("201", NotesSAConstants.EVENT_ENTER_A_SECOND_DEPTH_FOLDER);
        }
        if (this.mActionMenuController.isFolderpathLayoutEmpty()) {
            this.mActionMenuController.initFolderpathLayout(DataManager.getInstance().getFolderData(str), new IFolderPathLayoutListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.NotesView.8
                @Override // com.samsung.android.support.senl.p148nt.app.common.widget.IFolderPathLayoutListener
                public String getFolderUuid() {
                    return NotesView.this.mPresenter.getStateInfo().getFolderUuid();
                }

                @Override // com.samsung.android.support.senl.p148nt.app.common.widget.IFolderPathLayoutListener
                public void onFolderLayoutSelected(String str2) {
                    NotesView.this.mActionMenuController.updateCurrentFolderPath(DataManager.getInstance().getFolderData(str2), true);
                    int modeIndex = NotesView.this.getModeIndex();
                    if (!FeatureUtils.isPickEditMode(modeIndex) && FeatureUtils.isEditMode(modeIndex)) {
                        NotesView.this.setMode(1);
                    }
                    NotesView.this.onFolderSelected(str2);
                    CommonSamsungAnalytics.insertLog("101", NotesSAConstants.EVENT_NOTESLIST_FOLDER_NAVIGATION);
                }
            });
        } else {
            this.mActionMenuController.updateCurrentFolderPath(DataManager.getInstance().getFolderData(str), false);
            this.mActionMenuController.setFolderPathLayoutVisibility(0, true);
        }
        addPaddingForFolderPathLayout(true);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IView, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void setIsScrollToTop(boolean z, int i) {
        if (z && !this.mActionMenuController.isExpandedState()) {
            this.mActionMenuController.setFloatingToolbarExpanded(false);
        }
        this.mIsScrollToTop = z;
        this.mScrollDelay = i;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IView, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    @SuppressLint({WarningType.NewApi})
    public boolean setMode(int i) {
        int modeIndex = getModeIndex();
        if (this.mNotesRecyclerView == null || modeIndex == i) {
            return false;
        }
        AbstractC8014b.m7200b(i, modeIndex, "setMode# modeIndex : ", ", prevMode : ", TAG);
        this.mPresenter.getStateInfo().setModeIndex(i);
        if (this.mMode != null) {
            this.mPresenter.getStateInfo().setPrevModeIndex(modeIndex);
            this.mMode.onModeEnd();
            this.mMode = this.mModeFactory.getMode(i);
            this.mPresenter.updateDataObserverToCurrentMode(modeIndex, i);
        } else {
            this.mMode = this.mModeFactory.getMode(i);
            this.mPresenter.initDataObserver();
        }
        this.mMode.onLayout();
        this.mMode.updateFocusView(modeIndex);
        this.mFragmentContract.onModeChanged(i);
        this.mPresenter.getBackPressedHelper().updateOnBackInvokedCallback();
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IView
    public void setNoteFabVisibleWithAnimation() {
        FabMenuView fabMenuView = this.mFabMenuView;
        if (fabMenuView == null) {
            return;
        }
        fabMenuView.setNoteFabVisibility(this.mFragment.getActivity().findViewById(C8003R.id.inflate_note_fab), true);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IView
    public void setSwipeRefreshLayoutDuration(int i) {
        this.mSwipeRefreshView.setRefreshLayoutDuration(i);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.ModeContract.IView
    public void setSwipeRefreshLayoutEnabled(boolean z) {
        this.mSwipeRefreshView.setSwipeRefreshLayoutEnabled(z);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void showDragAndDropImage(int i, View view, int i2) {
        this.mBottomMenuController.showDragAndDropImage(i, view, i2);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void showProgressCircle(int i) {
        this.mBottomMenuController.setProgressCircleId(i);
        this.mBottomMenuController.checkProgressCircle();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void stopSwipeRefreshLayout() {
        this.mSwipeRefreshView.stopSwipeRefreshLayout();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void updateDrawerIconWithBadge() {
        ActionMenuController actionMenuController = this.mActionMenuController;
        if (actionMenuController == null) {
            return;
        }
        actionMenuController.updateDrawerIconWithBadge();
    }

    public void updateNoteViewByDrawerObserver(boolean z) {
        String folderUuid = this.mPresenter.getStateInfo().getFolderUuid();
        MainLogger.m7258i(TAG, "updateNoteViewByDrawerObserver# folderUuid : " + folderUuid);
        int modeIndex = getModeIndex();
        if (FeatureUtils.isSearchMode(modeIndex)) {
            this.mPresenter.onDataChangedByFolder(z, z);
            return;
        }
        if (FeatureUtils.isSubFolderExist(modeIndex, folderUuid)) {
            if (this.mPresenter.getDocumentMap().isDeletedFolder(folderUuid) || this.mPresenter.getDocumentMap().isIgnoreFolder(folderUuid)) {
                releaseDeletedFolder();
                return;
            }
            if (this.mPresenter.isScrolling()) {
                MainLogger.m7258i(TAG, "updateNoteViewByDrawerObserver# isScrolling : setPostNotifyDataSetChanged");
                this.mPresenter.setPostNotifyDataSetChanged();
            } else {
                this.mPresenter.onDataChangedByFolder(z, z);
            }
            setFolderPathLayoutVisibility(folderUuid);
            return;
        }
        if (!FeatureUtils.isSOMFolder(modeIndex, folderUuid)) {
            if (FeatureUtils.isCreateNewNoteEnabledFolder(folderUuid) || releaseEmptyFolderByDrawer(folderUuid)) {
                return;
            }
            this.mMode.updateTitle();
            return;
        }
        if (this.mPresenter.isScrolling()) {
            MainLogger.m7258i(TAG, "updateNoteViewByDrawerObserver# for SOM, isScrolling : setPostNotifyDataSetChanged");
            this.mPresenter.setPostNotifyDataSetChanged();
        } else {
            this.mPresenter.onDataChangedByFolder(z, z);
        }
        setFolderPathLayoutVisibility(folderUuid);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void updateSelectedNoteCount() {
        this.mActionMenuController.updateSelectedNoteCount(this.mPresenter.getCheckedDataCount() == this.mPresenter.getDocumentMap().getSelectableDataCount(), this.mPresenter.getCheckedDataCount());
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IView
    public void updateViewByDataChanged(int i) {
        this.mPresenter.setFastScroller(i);
        int i2 = this.mActivityState;
        if (i2 == 2 || i2 == 1) {
            this.mNotesListPostLaunch.executeOnPreDraw(this.mNotesRecyclerView, 300L);
        } else {
            this.mNotesListPostLaunch.reserveExecution();
        }
        filteredInvalidateOptionsMenu();
        this.mHandler.removeCallbacks(this.mUpdateListStateRunnable);
        this.mHandler.postDelayed(this.mUpdateListStateRunnable, 300L);
        FabMenuView fabMenuView = this.mFabMenuView;
        if (fabMenuView != null) {
            fabMenuView.invalidate();
        }
    }
}
