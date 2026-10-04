package com.samsung.android.support.senl.p148nt.app.main.tablet.presenter;

import android.graphics.Point;
import android.view.DragEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.FolderHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.view.FolderPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.drawer.adapter.DrawerHolder;
import com.samsung.android.support.senl.p148nt.app.main.drawer.model.TabletDrawerModel;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TabletDragAndDropHelper {
    private static final float DRAG_SCROLL_SPEED = 500.0f;
    private static final String TAG = "TabletDragAndDropHelper";
    private final PresenterContract mContract;
    private final TabletDrawerModel mDrawerModel;
    private final FolderPenRecyclerView mRecyclerView;
    private boolean mIsDimDragStatus = false;
    private final HashMap<String, Object> mBlockedFolderUuidMap = new LinkedHashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PresenterContract {
        void dragAndDropFinished(String str);

        void setExpandedStatus(String str, int i);
    }

    public TabletDragAndDropHelper(FolderPenRecyclerView folderPenRecyclerView, TabletDrawerModel tabletDrawerModel, PresenterContract presenterContract) {
        this.mRecyclerView = folderPenRecyclerView;
        this.mDrawerModel = tabletDrawerModel;
        this.mContract = presenterContract;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> getDefaultBlockedFolderUuidList() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Boolean bool = Boolean.TRUE;
        linkedHashMap.put("settings:///", bool);
        linkedHashMap.put(FolderConstants.AllNotes.UUID, bool);
        linkedHashMap.put(FolderConstants.OldNotes.UUID, bool);
        linkedHashMap.put("favorite:///", bool);
        linkedHashMap.put("lock:///", bool);
        linkedHashMap.put("recentlyImported:///", bool);
        linkedHashMap.put(FolderConstants.SharedNotes.UUID, bool);
        linkedHashMap.put(FolderConstants.Coedit.UUID, bool);
        linkedHashMap.put("divider:///", bool);
        linkedHashMap.put("folderManage:///", bool);
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDragEnabledFolder(String str) {
        return !this.mBlockedFolderUuidMap.containsKey(str);
    }

    private void setDragBlockedFolderList(HashMap<String, Object> map, String str) {
        NotesFolder folderData = this.mDrawerModel.getFolderData(str);
        if (folderData == null) {
            return;
        }
        map.put(str, Boolean.TRUE);
        Iterator<NotesFolder> it = folderData.getChildren().iterator();
        while (it.hasNext()) {
            setDragBlockedFolderList(map, it.next().getUuid());
        }
    }

    private void setDrawerHolderDim(DrawerHolder drawerHolder) {
        float f = (!this.mIsDimDragStatus || isDragEnabledFolder(drawerHolder.getDrawerHolderInfo().getUuid())) ? 1.0f : 0.4f;
        if (drawerHolder != null) {
            drawerHolder.itemView.findViewById(C8003R.id.icon_layout).setAlpha(f);
            drawerHolder.itemView.findViewById(C8003R.id.title).setAlpha(f);
            drawerHolder.itemView.findViewById(C8003R.id.count).setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void smoothScrollToPositionForDrawer(LinearLayoutManager linearLayoutManager, View view, DragEvent dragEvent, int i) {
        Point touchPositionFromDragEvent = NotesUtils.getTouchPositionFromDragEvent(view, dragEvent);
        int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        int i2 = touchPositionFromDragEvent.y;
        double d = i;
        if (i2 < 0.2d * d) {
            this.mRecyclerView.smoothScrollToPositionForDrawer(Math.max(iFindFirstVisibleItemPosition - 1, 0), DRAG_SCROLL_SPEED);
        } else if (i2 > d * 0.8d) {
            FolderPenRecyclerView folderPenRecyclerView = this.mRecyclerView;
            folderPenRecyclerView.smoothScrollToPositionForDrawer(Math.min(iFindLastVisibleItemPosition + 1, folderPenRecyclerView.getAdapter().getItemCount()), DRAG_SCROLL_SPEED);
        }
    }

    public void setDragListener(DrawerHolder drawerHolder) {
        final FolderHolderInfo drawerHolderInfo = drawerHolder.getDrawerHolderInfo();
        View folderItemContainer = drawerHolderInfo.getFolderItemContainer();
        if (folderItemContainer == null) {
            return;
        }
        final int viewType = drawerHolderInfo.getViewType();
        final int i = this.mRecyclerView.getResources().getDisplayMetrics().heightPixels;
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mRecyclerView.getLayoutManager();
        folderItemContainer.setTag(Integer.valueOf(viewType));
        folderItemContainer.setOnDragListener(new View.OnDragListener() { // from class: com.samsung.android.support.senl.nt.app.main.tablet.presenter.TabletDragAndDropHelper.1
            @Override // android.view.View.OnDragListener
            public boolean onDrag(View view, DragEvent dragEvent) {
                int action = dragEvent.getAction();
                if (action == 3) {
                    if (!TabletDragAndDropHelper.this.isDragEnabledFolder(drawerHolderInfo.getUuid())) {
                        return false;
                    }
                    TabletDragAndDropHelper.this.mContract.dragAndDropFinished(drawerHolderInfo.getUuid());
                    view.setBackgroundResource(C8003R.drawable.drawer_list_ripple);
                    MainLogger.m7254d(TabletDragAndDropHelper.TAG, "setDragListener#onDrag# drop");
                    return true;
                }
                if (action != 4) {
                    if (action == 5) {
                        String uuid = drawerHolderInfo.getUuid();
                        if (TabletDragAndDropHelper.this.isDragEnabledFolder(uuid)) {
                            view.setBackgroundColor(TabletDragAndDropHelper.this.mRecyclerView.getResources().getColor(C8003R.color.list_ripple_color, null));
                            NotesFolder folderData = TabletDragAndDropHelper.this.mDrawerModel.getFolderData(uuid);
                            if (folderData != null && !folderData.isExpanded() && viewType == 3) {
                                if (TabletDragAndDropHelper.this.getDefaultBlockedFolderUuidList().size() != TabletDragAndDropHelper.this.mBlockedFolderUuidMap.size()) {
                                    for (String str : FolderUtils.sStaticFolders) {
                                        TabletDragAndDropHelper.this.mBlockedFolderUuidMap.put(str, Boolean.TRUE);
                                    }
                                }
                                if (TabletDragAndDropHelper.this.mDrawerModel.getDrawerDisplayDataList() != null) {
                                    TabletDragAndDropHelper.this.mContract.setExpandedStatus(drawerHolderInfo.getUuid(), TabletDragAndDropHelper.this.mDrawerModel.getDrawerDisplayDataList().indexOf(folderData));
                                }
                            }
                        }
                        TabletDragAndDropHelper.this.smoothScrollToPositionForDrawer(linearLayoutManager, view, dragEvent, i);
                        return true;
                    }
                    if (action == 6) {
                        view.setBackgroundResource(C8003R.drawable.drawer_list_ripple);
                        TabletDragAndDropHelper.this.smoothScrollToPositionForDrawer(linearLayoutManager, view, dragEvent, i);
                        return true;
                    }
                } else if (TabletDragAndDropHelper.this.mIsDimDragStatus) {
                    TabletDragAndDropHelper.this.setDrawerHolderDimDragStatus(false, null);
                }
                return true;
            }
        });
        if (FolderConstants.HolderType.isDefaultFolderType(viewType)) {
            drawerHolder.getDrawerHolderInfo().getIconLayout().setVisibility(0);
        }
        setDrawerHolderDim(drawerHolder);
    }

    public void setDrawerHolderDimDragStatus(boolean z, ArrayList<String> arrayList) {
        if (this.mIsDimDragStatus == z || this.mRecyclerView == null) {
            return;
        }
        AbstractC8014b.m7210l("setDrawerHolderDimDragStatus isDimmed : ", TAG, z);
        this.mIsDimDragStatus = z;
        this.mBlockedFolderUuidMap.clear();
        if (this.mIsDimDragStatus) {
            this.mBlockedFolderUuidMap.putAll(getDefaultBlockedFolderUuidList());
            if (!arrayList.isEmpty()) {
                for (String str : FolderUtils.sStaticFolders) {
                    this.mBlockedFolderUuidMap.put(str, Boolean.TRUE);
                }
            }
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                setDragBlockedFolderList(this.mBlockedFolderUuidMap, it.next());
            }
        }
        int childCount = this.mRecyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mRecyclerView.getChildAt(i);
            if (childAt != null) {
                setDrawerHolderDim((DrawerHolder) this.mRecyclerView.getChildViewHolder(childAt));
            }
        }
    }
}
