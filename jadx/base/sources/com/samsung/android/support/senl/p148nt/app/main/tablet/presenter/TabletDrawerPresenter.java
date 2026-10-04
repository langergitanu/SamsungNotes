package com.samsung.android.support.senl.p148nt.app.main.tablet.presenter;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.FolderHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.view.FolderPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.drawer.adapter.DrawerHolder;
import com.samsung.android.support.senl.p148nt.app.main.drawer.model.TabletDrawerModel;
import com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.DrawerPresenter;
import com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.ViewContract;
import com.samsung.android.support.senl.p148nt.app.main.tablet.presenter.TabletDragAndDropHelper;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TabletDrawerPresenter extends DrawerPresenter implements TabletDragAndDropHelper.PresenterContract {
    private static final String TAG = "TabletDrawerPresenter";
    private final AbsAppCompatActivity mActivityContract;
    private final TabletDragAndDropHelper mDragNDropPresenter;
    private final View.OnClickListener mDrawerBarClickListener;
    private final View.OnHoverListener mHoverListener;
    private View mSelectedIcon;

    public TabletDrawerPresenter(AbsFragment absFragment, FolderPenRecyclerView folderPenRecyclerView, ViewContract viewContract, AbsAppCompatActivity absAppCompatActivity) {
        super(absFragment, folderPenRecyclerView, viewContract);
        this.mDrawerBarClickListener = new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.tablet.presenter.TabletDrawerPresenter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long j;
                UserInputSkipper.Tag tag = UserInputSkipper.Tag.Drawer;
                if (UserInputSkipper.isValidEvent(tag)) {
                    UserInputSkipper.setHoldingEventTime(300L, tag);
                    if (TabletDrawerPresenter.this.mSelectedIcon == null) {
                        TabletDrawerPresenter tabletDrawerPresenter = TabletDrawerPresenter.this;
                        tabletDrawerPresenter.mSelectedIcon = tabletDrawerPresenter.mActivityContract.findViewById(C8003R.id.icon_all_notes);
                    }
                    if (TabletDrawerPresenter.this.mSelectedIcon == null || (view.equals(TabletDrawerPresenter.this.mSelectedIcon) && TabletDrawerPresenter.this.mSelectedIcon.isSelected())) {
                        MainLogger.m7258i(TabletDrawerPresenter.this.getTag(), "DrawerBar icon click block");
                        return;
                    }
                    MainLogger.m7258i(TabletDrawerPresenter.this.getTag(), "DrawerBar icon click");
                    int id = view.getId();
                    if (id == C8003R.id.icon_all_notes) {
                        j = -1;
                    } else if (id == C8003R.id.inflate_icon_old_notes) {
                        j = -2;
                    } else if (id == C8003R.id.inflate_icon_favorite) {
                        j = -3;
                    } else if (id == C8003R.id.inflate_icon_lock) {
                        j = -5;
                    } else if (id == C8003R.id.inflate_icon_import) {
                        j = -6;
                    } else if (id == C8003R.id.icon_shared) {
                        j = -18;
                    } else if (id == C8003R.id.icon_coedit) {
                        j = -8;
                    } else if (id == C8003R.id.icon_trash) {
                        j = -7;
                    } else {
                        if (id != C8003R.id.icon_myfolders) {
                            MainLogger.m7258i(TabletDrawerPresenter.this.getTag(), "invalid resId");
                            return;
                        }
                        j = -4;
                    }
                    DrawerHolder drawerHolder = (DrawerHolder) ((DrawerPresenter) TabletDrawerPresenter.this).mRecyclerView.findViewHolderForItemId(j);
                    if (drawerHolder != null) {
                        FolderHolderInfo drawerHolderInfo = drawerHolder.getDrawerHolderInfo();
                        ((DrawerPresenter) TabletDrawerPresenter.this).mView.onFolderSelected(drawerHolderInfo.getUuid(), drawerHolderInfo.getViewType());
                        return;
                    }
                    MainLogger.m7258i(TabletDrawerPresenter.this.getTag(), "holder icon null");
                    NotesFolder drawerDisplayDataByItemId = ((DrawerPresenter) TabletDrawerPresenter.this).mModel.getDrawerDisplayDataByItemId(j);
                    if (drawerDisplayDataByItemId == null) {
                        return;
                    }
                    ((DrawerPresenter) TabletDrawerPresenter.this).mView.onFolderSelected(drawerDisplayDataByItemId.getUuid(), drawerDisplayDataByItemId.getViewType());
                }
            }
        };
        this.mHoverListener = new View.OnHoverListener() { // from class: com.samsung.android.support.senl.nt.app.main.tablet.presenter.TabletDrawerPresenter.2
            @Override // android.view.View.OnHoverListener
            public boolean onHover(View view, MotionEvent motionEvent) {
                if (view.isSelected()) {
                    return false;
                }
                if (motionEvent.getAction() == 10) {
                    view.setBackgroundResource(C8003R.color.transparent);
                } else {
                    view.setBackgroundResource(C8003R.drawable.drawer_item_selector_bg);
                }
                return false;
            }
        };
        this.mActivityContract = absAppCompatActivity;
        View viewFindViewById = absAppCompatActivity.findViewById(C8003R.id.icon_all_notes);
        this.mSelectedIcon = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setSelected(true);
        }
        this.mDragNDropPresenter = new TabletDragAndDropHelper(this.mRecyclerView, (TabletDrawerModel) this.mModel, this);
    }

    private View getSelectedIcon(String str) {
        if (this.mFragment.getActivity() == null) {
            return null;
        }
        if (FolderConstants.AllNotes.UUID.equals(str)) {
            return this.mFragment.getActivity().findViewById(C8003R.id.icon_all_notes);
        }
        if (FolderConstants.OldNotes.UUID.equals(str)) {
            return this.mFragment.getActivity().findViewById(C8003R.id.inflate_icon_old_notes);
        }
        if ("favorite:///".equals(str)) {
            return this.mFragment.getActivity().findViewById(C8003R.id.inflate_icon_favorite);
        }
        if ("lock:///".equals(str)) {
            return this.mFragment.getActivity().findViewById(C8003R.id.inflate_icon_lock);
        }
        if ("recentlyImported:///".equals(str)) {
            return this.mFragment.getActivity().findViewById(C8003R.id.inflate_icon_import);
        }
        if (FolderConstants.RecycleBin.UUID.equals(str)) {
            return this.mFragment.getActivity().findViewById(C8003R.id.icon_trash);
        }
        if (FolderConstants.MyFolders.UUID.equals(str)) {
            return this.mFragment.getActivity().findViewById(C8003R.id.icon_myfolders);
        }
        if (FolderConstants.SharedNotes.UUID.equals(str) || FolderConstants.Coedit.UUID.equals(str)) {
            return this.mFragment.getActivity().findViewById(C8003R.id.icon_coedit);
        }
        return null;
    }

    private void setSelectedIconResource(View view, String str, boolean z, boolean z2) {
        int drawerFolderDrawable = FolderUtils.getDrawerFolderDrawable(str, z, z2, false);
        int i = z ? C8003R.drawable.drawer_item_selector_bg : C8003R.color.transparent;
        ImageView imageView = FolderConstants.AllNotes.UUID.equals(str) ? (ImageView) view.findViewById(C8003R.id.all_notes) : FolderConstants.RecycleBin.UUID.equals(str) ? (ImageView) view.findViewById(C8003R.id.trash) : FolderConstants.MyFolders.UUID.equals(str) ? (ImageView) view.findViewById(C8003R.id.myfolders) : (FolderConstants.SharedNotes.UUID.equals(str) || FolderConstants.Coedit.UUID.equals(str)) ? (ImageView) view.findViewById(C8003R.id.coedit) : (ImageView) view.findViewById(C8003R.id.drawer_bar_icon_image);
        if (imageView != null) {
            imageView.setImageResource(drawerFolderDrawable);
            imageView.setBackgroundResource(i);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.DrawerPresenter
    public void addSALog(int i) {
        if (i == 1) {
            CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_TABLET_SCREEN_OFF_MEMO);
            CommonSamsungAnalytics.insertLog("202");
            return;
        }
        if (i == 3) {
            CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_TABLET_FOLDER_EXPAND_COLLAPSE);
            CommonSamsungAnalytics.insertLog("201");
            return;
        }
        if (i == 5) {
            CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_TABLET_MANAGE_FOLDERS);
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MANAGE_FOLDERS);
            return;
        }
        switch (i) {
            case 1001:
                CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_TABLET_MAIN_SETTINGS);
                CommonSamsungAnalytics.insertLog(SettingsSAConstants.SCREEN_SETTINGS);
                break;
            case 1002:
                CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_TABLET_ALL_NOTES);
                CommonSamsungAnalytics.insertLog("101");
                break;
            case 1003:
                CommonSamsungAnalytics.insertLog("103", "1311");
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_OLD_CATEGORY);
                break;
            case 1004:
                CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_TABLET_FAVORITES);
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_FAVORITES);
                break;
            case 1005:
                CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_TABLET_LOCKED_NOTE);
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_LOCKED_NOTES);
                break;
            case 1006:
                CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_TABLET_RECENTLY_IMPORTED);
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_RECENTLY_IMPORTED);
                break;
            case 1007:
                CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_TABLET_SHARED_NOTEBOOKS);
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_GCS_GROUP_LIST);
                break;
            case 1008:
                CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_TABLET_SHARED_NOTEBOOKS);
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN);
                break;
            case 1009:
                CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_TABLET_RECYCLEBIN);
                CommonSamsungAnalytics.insertLog("531");
                break;
            default:
                CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_TABLET_SELECT_FOLDER);
                CommonSamsungAnalytics.insertLog("201");
                break;
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.tablet.presenter.TabletDragAndDropHelper.PresenterContract
    public void dragAndDropFinished(String str) {
        this.mActivityContract.dragAndDropFinished(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.DrawerPresenter
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.DrawerPresenter, com.samsung.android.support.senl.p148nt.app.main.drawer.adapter.AdapterContract
    public void setDragListener(DrawerHolder drawerHolder) {
        this.mDragNDropPresenter.setDragListener(drawerHolder);
    }

    public void setDragStatus(boolean z) {
        if (this.mSelectedIcon == null || this.mFragment.getActivity() == null) {
            return;
        }
        this.mSelectedIcon.setSelected(z);
    }

    public boolean setDrawerBarIconInputListener(View view) {
        View childAt;
        if (view == null) {
            return false;
        }
        view.setOnClickListener(this.mDrawerBarClickListener);
        if (!(view instanceof ViewGroup)) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.getChildCount() <= 0 || (childAt = viewGroup.getChildAt(0)) == null) {
            return true;
        }
        childAt.setOnHoverListener(this.mHoverListener);
        return true;
    }

    public void setDrawerBarInputListener() {
        FragmentActivity activity = this.mFragment.getActivity();
        if (activity != null && setDrawerBarIconInputListener(activity.findViewById(C8003R.id.icon_all_notes))) {
            setDrawerBarIconInputListener(activity.findViewById(C8003R.id.icon_shared));
            setDrawerBarIconInputListener(activity.findViewById(C8003R.id.icon_coedit));
            setDrawerBarIconInputListener(activity.findViewById(C8003R.id.icon_trash));
            setDrawerBarIconInputListener(activity.findViewById(C8003R.id.icon_myfolders));
        }
    }

    public void setDrawerHolderDimDragStatus(boolean z, ArrayList<String> arrayList) {
        this.mDragNDropPresenter.setDrawerHolderDimDragStatus(z, arrayList);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.DrawerPresenter, com.samsung.android.support.senl.nt.app.main.tablet.presenter.TabletDragAndDropHelper.PresenterContract
    public void setExpandedStatus(String str, int i) {
        super.setExpandedStatus(str, i);
    }

    public void setIconSelected(String str, boolean z, boolean z2) {
        if (this.mSelectedIcon == null || this.mFragment.getActivity() == null) {
            return;
        }
        View selectedIcon = getSelectedIcon(str);
        if (selectedIcon == null) {
            this.mSelectedIcon.setSelected(false);
            return;
        }
        this.mSelectedIcon = selectedIcon;
        selectedIcon.setSelected(z);
        setSelectedIconResource(this.mSelectedIcon, str, z, z2);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.DrawerPresenter
    public void setModel() {
        this.mModel = new TabletDrawerModel();
    }
}
