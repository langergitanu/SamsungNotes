package com.samsung.android.support.senl.p148nt.app.main.tablet.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.badge.BadgeHelper;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.main.tablet.presenter.TabletDrawerPresenter;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TabletDrawerBar {
    private static final int ENTRY = 0;
    private static final int NONE_INFLATE_ICON = -1;
    private static final int NORMAL = 2;
    private static final int RUNNING_ANIMATOR = 1;
    private static final String TAG = "TabletDrawerBar";
    private final LinearLayout mDrawerBar;
    private DrawerContract mDrawerContract;
    private TabletDrawerPresenter mPresenter;
    private final LinkedHashMap<Long, View> mDrawerBarIconList = new LinkedHashMap<>();
    private final ArrayList<Float> mDrawerBarIconDstY = new ArrayList<>();
    private float mAllNotesY = 0.0f;
    private float mIconYGap = 0.0f;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DrawerContract {
        void dragAndDropFinished(String str);

        void openDrawerWithAnimation();
    }

    public TabletDrawerBar(AbsAppCompatActivity absAppCompatActivity) {
        this.mDrawerBar = (LinearLayout) absAppCompatActivity.findViewById(C8003R.id.drawer_bar_layout);
        onInitializeDrawerBar(absAppCompatActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calculateDrawerIconGap() {
        float y2;
        Iterator<View> it = this.mDrawerBarIconList.values().iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                y2 = 0.0f;
                break;
            }
            View next = it.next();
            if (i == 0) {
                this.mAllNotesY = next.getY();
            } else if (i == 1) {
                y2 = next.getY();
                break;
            }
            i++;
        }
        float f = this.mAllNotesY;
        float f4 = y2 - f;
        this.mIconYGap = f4;
        if (f4 < 0.0f) {
            this.mIconYGap = f;
        }
    }

    private View inflateDrawerIcon(long j, int i, int i2, int i4, int i5, int i6) {
        View inflatedView = ViewModeUtils.getInflatedView(this.mDrawerBar, i, i2);
        ImageView imageView = (ImageView) inflatedView.findViewById(C8003R.id.drawer_bar_icon_image);
        if (i5 == -1 || !isSelectedDrawerFilter(j)) {
            imageView.setImageResource(i4);
        } else {
            imageView.setImageResource(i5);
        }
        imageView.setColorFilter(new PorterDuffColorFilter(imageView.getContext().getColor(C8003R.color.folder_list_item_filter_icon_color), PorterDuff.Mode.SRC_IN));
        String string = this.mDrawerBar.getContext().getString(i6);
        imageView.setContentDescription(string);
        ViewCompat.getInstance().setTooltipText(inflatedView, string);
        TabletDrawerPresenter tabletDrawerPresenter = this.mPresenter;
        if (tabletDrawerPresenter != null) {
            tabletDrawerPresenter.setDrawerBarIconInputListener(inflatedView);
        }
        return inflatedView;
    }

    private void initDrawerBar() {
        this.mDrawerBarIconList.clear();
        this.mDrawerBar.findViewById(C8003R.id.icon_all_notes).setVisibility(8);
        this.mDrawerBar.findViewById(C8003R.id.icon_shared).setVisibility(8);
        this.mDrawerBar.findViewById(C8003R.id.icon_coedit).setVisibility(8);
        this.mDrawerBar.findViewById(C8003R.id.icon_trash).setVisibility(8);
        this.mDrawerBar.findViewById(C8003R.id.item_divider).setVisibility(8);
        this.mDrawerBar.findViewById(C8003R.id.icon_myfolders).setVisibility(8);
        initInflatedDrawerBar(C8003R.id.inflate_icon_old_notes);
        initInflatedDrawerBar(C8003R.id.inflate_icon_favorite);
        initInflatedDrawerBar(C8003R.id.inflate_icon_lock);
        initInflatedDrawerBar(C8003R.id.inflate_icon_import);
    }

    private void initInflatedDrawerBar(int i) {
        View viewFindViewById = this.mDrawerBar.findViewById(i);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
    }

    private boolean isSelectedDrawerFilter(long j) {
        TabletDrawerPresenter tabletDrawerPresenter = this.mPresenter;
        if (tabletDrawerPresenter == null) {
            return false;
        }
        String folderUuid = tabletDrawerPresenter.getFolderUuid();
        if (j == -1) {
            return FolderConstants.AllNotes.UUID.equals(folderUuid);
        }
        if (j == -18) {
            return FolderConstants.SharedNotes.UUID.equals(folderUuid);
        }
        if (j == -8) {
            return FolderConstants.Coedit.UUID.equals(folderUuid);
        }
        if (j == -7) {
            return FolderConstants.RecycleBin.UUID.equals(folderUuid);
        }
        if (j == -4) {
            return FolderConstants.MyFolders.UUID.equals(folderUuid);
        }
        if (j == -2) {
            return FolderConstants.OldNotes.UUID.equals(folderUuid);
        }
        if (j == -3) {
            return "favorite:///".equals(folderUuid);
        }
        if (j == -5) {
            return "lock:///".equals(folderUuid);
        }
        if (j == -6) {
            return "recentlyImported:///".equals(folderUuid);
        }
        return false;
    }

    private void onInitializeDrawerBar(AbsAppCompatActivity absAppCompatActivity) {
        MainLogger.m7254d(TAG, "onInitializeDrawerBar");
        DataManager dataManager = DataManager.getInstance();
        boolean zHasLogic = PostLaunchManager.getInstance().hasLogic(absAppCompatActivity.getPostLaunchToken(), 102);
        setDrawerBarIcon(-1L, C8003R.id.icon_all_notes, -1, C8003R.drawable.ic_all, C8003R.drawable.ic_all_solid, -1, 0);
        if (dataManager.isOldNotesFolderNeed()) {
            setDrawerBarIcon(-2L, C8003R.id.icon_old_notes, C8003R.id.inflate_icon_old_notes, C8003R.drawable.ic_old_notes, C8003R.drawable.ic_old_notes_solid, C8003R.string.upgradable_notes, 0);
        }
        if ((zHasLogic ? SharedPreferencesCompat.getInstance(FolderConstants.PREF_FOLDER_INFO).getInt("favorite:///", 0) : dataManager.getFavoriteItemCount()) > 0) {
            setDrawerBarIcon(-3L, C8003R.id.icon_favorite, C8003R.id.inflate_icon_favorite, C8003R.drawable.ic_favorite, C8003R.drawable.ic_favorite_solid, C8003R.string.favorite_notes, 0);
        }
        if ((zHasLogic ? SharedPreferencesCompat.getInstance(FolderConstants.PREF_FOLDER_INFO).getInt("lock:///", 0) : dataManager.getAllLockedDataCount()) > 0) {
            setDrawerBarIcon(-5L, C8003R.id.icon_lock, C8003R.id.inflate_icon_lock, C8003R.drawable.ic_drawer_lock, C8003R.drawable.ic_drawer_lock_solid, C8003R.string.locked_notes, 0);
        }
        if ((zHasLogic ? SharedPreferencesCompat.getInstance(FolderConstants.PREF_FOLDER_INFO).getInt("recentlyImported:///", 0) : dataManager.getRecentlyImportedCount()) > 0) {
            setDrawerBarIcon(-6L, C8003R.id.icon_import, C8003R.id.inflate_icon_import, C8003R.drawable.ic_import, C8003R.drawable.ic_import_solid, C8003R.string.folder_recently_imported, 0);
        }
        setDrawerBarIcon(-8L, C8003R.id.icon_coedit, -1, C8003R.drawable.ic_drawer_coedit, C8003R.drawable.ic_drawer_coedit_solid, -1, 0);
        setDrawerBarIcon(-7L, C8003R.id.icon_trash, -1, C8003R.drawable.ic_delete, C8003R.drawable.ic_delete_solid, -1, 0);
        setDrawerBarIcon(-10L, C8003R.id.item_divider, -1, -1, -1, -1, 0);
        setDrawerBarIcon(-4L, C8003R.id.icon_myfolders, -1, C8003R.drawable.ic_drawer_folder, C8003R.drawable.ic_drawer_folder_solid, -1, 0);
    }

    private void setDrawerBar(boolean z) {
        List<NotesFolder> drawerDisplayDataList = this.mPresenter.getModel().getDrawerDisplayDataList();
        if (drawerDisplayDataList == null) {
            return;
        }
        for (NotesFolder notesFolder : drawerDisplayDataList) {
            if (notesFolder != null) {
                int viewType = notesFolder.getViewType();
                if (viewType != 3) {
                    switch (viewType) {
                        case 1002:
                            setDrawerBarIcon(-1L, C8003R.id.icon_all_notes, -1, -1, C8003R.drawable.ic_all_solid, -1, z ? 1 : 2);
                            break;
                        case 1003:
                            setDrawerBarIcon(-2L, C8003R.id.icon_old_notes, C8003R.id.inflate_icon_old_notes, C8003R.drawable.ic_old_notes, C8003R.drawable.ic_old_notes_solid, C8003R.string.upgradable_notes, z ? 1 : 2);
                            break;
                        case 1004:
                            setDrawerBarIcon(-3L, C8003R.id.icon_favorite, C8003R.id.inflate_icon_favorite, C8003R.drawable.ic_favorite, C8003R.drawable.ic_favorite_solid, C8003R.string.favorite_notes, z ? 1 : 2);
                            break;
                        case 1005:
                            setDrawerBarIcon(-5L, C8003R.id.icon_lock, C8003R.id.inflate_icon_lock, C8003R.drawable.ic_drawer_lock, C8003R.drawable.ic_drawer_lock_solid, C8003R.string.locked_notes, z ? 1 : 2);
                            break;
                        case 1006:
                            setDrawerBarIcon(-6L, C8003R.id.icon_import, C8003R.id.inflate_icon_import, C8003R.drawable.ic_import, C8003R.drawable.ic_import_solid, C8003R.string.folder_recently_imported, z ? 1 : 2);
                            break;
                        case 1007:
                            setDrawerBarIcon(-18L, C8003R.id.icon_shared, -1, -1, C8003R.drawable.ic_shared_notebooks_solid, -1, z ? 1 : 2);
                            break;
                        case 1008:
                            setDrawerBarIcon(-8L, C8003R.id.icon_coedit, -1, -1, C8003R.drawable.ic_drawer_coedit_solid, -1, z ? 1 : 2);
                            break;
                        case 1009:
                            setDrawerBarIcon(-7L, C8003R.id.icon_trash, -1, -1, C8003R.drawable.ic_delete_solid, -1, z ? 1 : 2);
                            break;
                        case 1010:
                            setDrawerBarIcon(-10L, C8003R.id.item_divider, -1, -1, -1, -1, z ? 1 : 2);
                            break;
                    }
                } else {
                    setDrawerBarIcon(-4L, C8003R.id.icon_myfolders, -1, -1, C8003R.drawable.ic_drawer_folder_solid, -1, z ? 1 : 2);
                }
            }
        }
    }

    private void setDrawerBarIcon(long j, int i, int i2, int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        View viewFindViewById = this.mDrawerBar.findViewById(i);
        if (viewFindViewById == null) {
            if (i2 == -1) {
                return;
            } else {
                viewFindViewById = inflateDrawerIcon(j, i, i2, i4, i5, i6);
            }
        } else if (i7 == 0 && i2 != -1) {
            viewFindViewById = inflateDrawerIcon(j, i, i2, i4, i5, i6);
        }
        long j2 = j;
        TabletDrawerBar tabletDrawerBar = this;
        if (j2 == -18 && !NotesUtils.getPreferenceMDESupported()) {
            viewFindViewById.setVisibility(8);
            return;
        }
        if (i2 == -1 || tabletDrawerBar.mDrawerBar.findViewById(i2) != null) {
            i8 = i2;
            i9 = i4;
            i10 = i5;
        } else {
            i8 = i2;
            i9 = i4;
            i10 = i5;
            viewFindViewById = inflateDrawerIcon(j2, i, i8, i9, i10, i6);
            j2 = j2;
            tabletDrawerBar = this;
        }
        tabletDrawerBar.mDrawerBarIconList.put(Long.valueOf(j2), viewFindViewById);
        if (i7 == 2 || i7 == 0) {
            viewFindViewById.setVisibility(0);
        } else {
            viewFindViewById.setVisibility(4);
        }
        if (i8 != -1 || j2 == -10) {
            return;
        }
        tabletDrawerBar.setNonInflateIconColorFilter(j2, viewFindViewById, i9, i10);
    }

    private void setNonInflateIconColorFilter(long j, View view, int i, int i2) {
        ImageView imageView;
        if (j == -1) {
            imageView = (ImageView) view.findViewById(C8003R.id.all_notes);
        } else if (j == -18) {
            imageView = (ImageView) view.findViewById(C8003R.id.shared);
        } else if (j == -8) {
            imageView = (ImageView) view.findViewById(C8003R.id.coedit);
        } else if (j == -7) {
            imageView = (ImageView) view.findViewById(C8003R.id.trash);
        } else if (j != -4) {
            return;
        } else {
            imageView = (ImageView) view.findViewById(C8003R.id.myfolders);
        }
        if (i2 != -1 && isSelectedDrawerFilter(j)) {
            imageView.setImageResource(i2);
        } else if (i != -1) {
            imageView.setImageResource(i);
        }
        imageView.setColorFilter(new PorterDuffColorFilter(imageView.getContext().getColor(C8003R.color.folder_list_item_filter_icon_color), PorterDuff.Mode.SRC_IN));
    }

    public float getAllNotesY() {
        return this.mAllNotesY;
    }

    public int getDividerHeight() {
        if (this.mDrawerBarIconList.get(-10L) == null) {
            return 0;
        }
        return this.mDrawerBarIconList.get(-10L).getMeasuredHeight();
    }

    public ArrayList<Float> getIconDstY() {
        return this.mDrawerBarIconDstY;
    }

    public int getIconHeight() {
        if (this.mDrawerBarIconList.get(-1L) == null) {
            return 0;
        }
        return this.mDrawerBarIconList.get(-1L).getMeasuredHeight();
    }

    public LinkedHashMap<Long, View> getIconList() {
        return this.mDrawerBarIconList;
    }

    public float getIconYGap() {
        return this.mIconYGap;
    }

    public View getView() {
        return this.mDrawerBar;
    }

    public int getVisibility() {
        return this.mDrawerBar.getVisibility();
    }

    public boolean onDataChanged(boolean z) {
        int size = this.mDrawerBarIconList.size();
        initDrawerBar();
        setDrawerBar(z);
        return this.mDrawerBarIconList.size() != size;
    }

    public void setDividerVisibility(int i) {
        if (this.mDrawerBarIconList.get(-10L) == null) {
            return;
        }
        this.mDrawerBarIconList.get(-10L).setVisibility(i);
    }

    public void setDrawerBarAnimator(View.OnClickListener onClickListener) {
        ImageView imageView = (ImageView) this.mDrawerBar.findViewById(C8003R.id.drawer_button);
        CommonUtils.nextLayoutChanged(this.mDrawerBar, new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.app.main.tablet.widget.TabletDrawerBar.2
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                TabletDrawerBar.this.calculateDrawerIconGap();
            }
        });
        this.mDrawerBar.setOnDragListener(new View.OnDragListener() { // from class: com.samsung.android.support.senl.nt.app.main.tablet.widget.TabletDrawerBar.3
            @Override // android.view.View.OnDragListener
            public boolean onDrag(View view, DragEvent dragEvent) {
                if (TabletDrawerBar.this.mDrawerContract != null && dragEvent.getAction() == 5) {
                    TabletDrawerBar.this.mDrawerContract.openDrawerWithAnimation();
                }
                return true;
            }
        });
        calculateDrawerIconGap();
        imageView.setOnClickListener(onClickListener);
    }

    public void setDrawerBarIconDragListener() {
        setDrawerBarIconDragListener(C8003R.id.icon_trash);
        setDrawerBarIconDragListener(C8003R.id.icon_myfolders);
    }

    public void setDrawerIconDimDragStatus(boolean z, ArrayList<String> arrayList) {
        float f = z ? 0.4f : 1.0f;
        for (View view : this.mDrawerBarIconList.values()) {
            if (view != null && !view.equals(this.mDrawerBarIconList.get(-7L)) && (!view.equals(this.mDrawerBarIconList.get(-4L)) || arrayList == null || arrayList.contains(FolderConstants.MyFolders.UUID))) {
                view.setAlpha(f);
                view.setEnabled(!z);
            }
        }
    }

    public void setDrawerPresenter(TabletDrawerPresenter tabletDrawerPresenter, DrawerContract drawerContract) {
        this.mPresenter = tabletDrawerPresenter;
        this.mDrawerContract = drawerContract;
    }

    public void setToolTipText(Context context) {
        ViewCompat viewCompat = ViewCompat.getInstance();
        viewCompat.setTooltipText(this.mDrawerBar.findViewById(C8003R.id.icon_all_notes), context.getString(C8003R.string.all_notes));
        viewCompat.setTooltipText(this.mDrawerBar.findViewById(C8003R.id.icon_shared), context.getString(C8003R.string.shared_notebooks));
        viewCompat.setTooltipText(this.mDrawerBar.findViewById(C8003R.id.icon_coedit), context.getString(C8003R.string.co_edit_title));
        viewCompat.setTooltipText(this.mDrawerBar.findViewById(C8003R.id.icon_trash), context.getString(C8003R.string.trash));
        viewCompat.setTooltipText(this.mDrawerBar.findViewById(C8003R.id.icon_myfolders), context.getString(C8003R.string.settings_my_folders));
    }

    public void setVisibility(int i) {
        this.mDrawerBar.setVisibility(i);
    }

    public void updateNewBadge(int i) {
        View viewFindViewById = this.mDrawerBar.findViewById(C8003R.id.drawer_button_new_badge);
        if (viewFindViewById != null && viewFindViewById.getVisibility() != i) {
            viewFindViewById.setVisibility(i);
        }
        View viewFindViewById2 = this.mDrawerBar.findViewById(C8003R.id.drawer_button);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setContentDescription(BadgeHelper.getDrawerButtonContentDescription(i == 0));
            ViewCompat.getInstance().setTooltipText(viewFindViewById2);
        }
    }

    private void setDrawerBarIconDragListener(int i) {
        View viewFindViewById = this.mDrawerBar.findViewById(i);
        if (viewFindViewById == null) {
            return;
        }
        viewFindViewById.setOnDragListener(new View.OnDragListener(i) { // from class: com.samsung.android.support.senl.nt.app.main.tablet.widget.TabletDrawerBar.1
            final int iconId;
            final String uuid;
            final /* synthetic */ int val$resId;

            {
                this.val$resId = i;
                int i2 = C8003R.id.icon_trash;
                this.iconId = i == i2 ? C8003R.id.trash : C8003R.id.myfolders;
                this.uuid = i == i2 ? FolderConstants.RecycleBin.UUID : FolderConstants.MyFolders.UUID;
            }

            @Override // android.view.View.OnDragListener
            public boolean onDrag(View view, DragEvent dragEvent) {
                int action = dragEvent.getAction();
                if (action == 1) {
                    TabletDrawerBar.this.mPresenter.setDragStatus(false);
                } else if (action == 3) {
                    TabletDrawerBar.this.mDrawerContract.dragAndDropFinished(this.uuid);
                    view.findViewById(this.iconId).setSelected(false);
                } else if (action == 4) {
                    TabletDrawerBar.this.setDrawerIconDimDragStatus(false, null);
                    TabletDrawerBar.this.mPresenter.setDragStatus(true);
                } else if (action == 5) {
                    TabletDrawerBar.this.mDrawerContract.openDrawerWithAnimation();
                    view.findViewById(this.iconId).setSelected(true);
                } else if (action == 6) {
                    view.findViewById(this.iconId).setSelected(false);
                }
                return true;
            }
        });
    }
}
