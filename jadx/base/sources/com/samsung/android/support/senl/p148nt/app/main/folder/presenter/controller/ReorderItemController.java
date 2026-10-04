package com.samsung.android.support.senl.p148nt.app.main.folder.presenter.controller;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.FolderHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.folder.adapter.FolderAdapter;
import com.samsung.android.support.senl.p148nt.app.main.folder.adapter.FolderHolder;
import com.samsung.android.support.senl.p148nt.app.main.folder.model.FolderModel;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.InvalidParentFolderException;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ReorderItemController {
    public static final String TAG = "ReorderItemController";
    private final FolderAdapter mAdapter;
    private final Context mContext;
    private final Contract mContract;
    private final FolderModel mFolderModel;
    private final ItemTouchHelper mItemTouchHelper;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void attachAddFolderItem();

        int getDataUpdateType();

        boolean isCheckedItem(String str);

        boolean isSkippedDataSetChanged();

        void setDataUpdateType(int i);

        void setExpandedStatus(boolean z, String str, int i);

        void setSelectedUuid(String str);

        void setToScrollUuid(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class FolderOrder implements Comparable<FolderOrder> {
        final NotesFolder mFolder;
        final Integer mIndex;

        public FolderOrder(NotesFolder notesFolder, Integer num) {
            this.mFolder = notesFolder;
            this.mIndex = num;
        }

        public boolean equals(@Nullable Object obj) {
            return super.equals(obj);
        }

        public NotesFolder getFolder() {
            return this.mFolder;
        }

        public Integer getIndex() {
            return this.mIndex;
        }

        @Override // java.lang.Comparable
        public int compareTo(FolderOrder folderOrder) {
            return Integer.compare(this.mIndex.intValue(), folderOrder.getIndex().intValue());
        }
    }

    public ReorderItemController(RecyclerView recyclerView, FolderModel folderModel, Context context, Contract contract, FolderAdapter folderAdapter) {
        this.mFolderModel = folderModel;
        this.mContext = context;
        this.mContract = contract;
        this.mAdapter = folderAdapter;
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.controller.ReorderItemController.1
            private int mActionState;
            private boolean mInsertColored;
            private int mInsertedColor;
            private RecyclerView.ViewHolder mInsertedHolder;
            private FolderHolderInfo mPreHolderInfo;
            private String mPrvSelectedFolderUuid;
            private Runnable mSetPostExpand;
            private RecyclerView.ViewHolder mStartViewHolder;
            private final int NORMAL = 0;
            private final int SELECTED = 1;
            private final int EFFECT = 2;
            private final Handler mHandler = new Handler(Looper.myLooper());

            /* JADX INFO: Access modifiers changed from: private */
            public List<NotesFolder> getChildOrderList(NotesFolder notesFolder, List<NotesFolder> list, String str) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new FolderOrder(notesFolder, Integer.valueOf(ReorderItemController.this.mFolderModel.getFolderDisplayDataList().indexOf(notesFolder))));
                for (NotesFolder notesFolder2 : list) {
                    if (notesFolder == null || !notesFolder.equals(notesFolder2)) {
                        arrayList.add(new FolderOrder(notesFolder2, Integer.valueOf(ReorderItemController.this.mFolderModel.getFolderDisplayDataList().indexOf(notesFolder2))));
                    }
                }
                Collections.sort(arrayList);
                list.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    list.add(((FolderOrder) it.next()).getFolder());
                }
                int i = 0;
                for (NotesFolder notesFolder3 : list) {
                    if (notesFolder3 != null) {
                        notesFolder3.setParentUuid(str);
                        notesFolder3.setReorder(Integer.valueOf(i));
                        i++;
                    }
                }
                return list;
            }

            private boolean hasFolder(String str) {
                return ReorderItemController.this.mFolderModel.getFolderData(str) != null;
            }

            private void moveAndReorder(final String str, final String str2) {
                final NotesFolder folderData = ReorderItemController.this.mFolderModel.getFolderData(str);
                final NotesFolder folderData2 = ReorderItemController.this.mFolderModel.getFolderData(str2);
                if (folderData == null || folderData2 == null) {
                    moveFail(str, str2, "moveAndReorder : folder is null");
                    return;
                }
                if (DataManager.getInstance().isExistFolderName(ReorderItemController.this.mContext, folderData.getDisplayName(), str2, DataManager.getInstance().getFoldersDisplayName(str2, ReorderItemController.this.mFolderModel.getFolderDataMap()), false)) {
                    ToastHandler.show(ReorderItemController.this.mContext, C8003R.string.folder_already_in_use, 0);
                    ReorderItemController.this.mFolderModel.initFolderDisplayDataList();
                    ReorderItemController.this.mContract.attachAddFolderItem();
                    moveFail(str, str2, "moveAndReorder : folder name already in use");
                    return;
                }
                if ((folderData2.getDepth() + DataManager.getMaximumFolderDepth(folderData)) - folderData.getDepth() < 50) {
                    FolderManager.getInstance().runInTransaction(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.controller.ReorderItemController.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                FolderManager.getInstance().move(str, str2);
                                List childOrderList = getChildOrderList(folderData, folderData2.getChildren(), str2);
                                if (childOrderList.isEmpty()) {
                                    moveFail(str, str2, "moveAndReorder#run : children folder empty");
                                    return;
                                }
                                try {
                                    FolderManager.getInstance().reorder(folderData2.getUuid(), childOrderList);
                                } catch (InvalidParentFolderException e) {
                                    moveFail(str, str2, "moveAndReorder#reorder : " + e.getMessage());
                                }
                            } catch (InvalidParentFolderException e2) {
                                moveFail(str, str2, "moveAndReorder#move : " + e2.getMessage());
                            }
                        }
                    });
                } else {
                    ToastHandler.show(ReorderItemController.this.mContext, C8003R.string.add_subfolder_max_toast, 0);
                    moveFail(str, str2, "moveAndReorder : max depth");
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void moveFail(String str, String str2, String str3) {
                StringBuilder sbM16m = AbstractC0000a.m16m("move fail# ", str, " to ", str2, SQLKeyword.COMMA);
                sbM16m.append(str3);
                MainLogger.m7258i(ReorderItemController.TAG, sbM16m.toString());
                ReorderItemController.this.mContract.setSelectedUuid(null);
                ReorderItemController.this.mContract.setToScrollUuid(null);
                ReorderItemController.this.mContract.setDataUpdateType(-1);
                this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.controller.ReorderItemController.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ReorderItemController.this.mContract.isSkippedDataSetChanged()) {
                            return;
                        }
                        try {
                            ReorderItemController.this.mAdapter.notifyDataSetChanged();
                        } catch (IllegalStateException e) {
                            MainLogger.m7258i(ReorderItemController.TAG, "move fail IllegalStateException# " + e.getMessage());
                        }
                    }
                });
            }

            private void onItemMove(int i, int i2) {
                Runnable runnable = this.mSetPostExpand;
                if (runnable != null) {
                    this.mHandler.removeCallbacks(runnable);
                    this.mPrvSelectedFolderUuid = null;
                }
                ReorderItemController.this.mAdapter.onItemMove(i, i2);
            }

            private void onItemMoveFinished(final boolean z, final String str, final String str2) {
                MainLogger.m7258i(ReorderItemController.TAG, "onItemMoveFinished# " + z + " " + str + " to " + str2);
                Runnable runnable = this.mSetPostExpand;
                if (runnable != null) {
                    this.mHandler.removeCallbacks(runnable);
                    this.mPrvSelectedFolderUuid = null;
                }
                ReorderItemController.this.mContract.setToScrollUuid(str);
                if ("addFolder:///".equals(str2) || TextUtils.isEmpty(str2)) {
                    str2 = FolderConstants.MyFolders.UUID;
                }
                FolderManager.getInstance().executeOperation(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.controller.ReorderItemController.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        reorder(str, str2, z);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void reorder(String str, String str2, boolean z) {
                if (!hasFolder(str) || !hasFolder(str2) || str2.equals(str)) {
                    moveFail(str, str2, "reorder : don't need");
                    return;
                }
                ReorderItemController.this.mContract.setDataUpdateType(10);
                NotesFolder folderData = ReorderItemController.this.mFolderModel.getFolderData(str);
                NotesFolder folderData2 = ReorderItemController.this.mFolderModel.getFolderData(str2);
                if (folderData == null || folderData2 == null) {
                    moveFail(str, str2, "reorder : folder is null");
                    return;
                }
                String parentUuid = folderData.getParentUuid();
                String parentUuid2 = folderData2.getParentUuid();
                if (parentUuid == null) {
                    parentUuid = FolderConstants.MyFolders.UUID;
                }
                if (parentUuid2 == null) {
                    parentUuid2 = FolderConstants.MyFolders.UUID;
                }
                if (!hasFolder(parentUuid)) {
                    moveFail(str, str2, "reorder : parent folder empty");
                    return;
                }
                NotesFolder parent = folderData.getParent();
                if (z && !str2.equals(parentUuid)) {
                    ReorderItemController.this.mContract.setSelectedUuid(str2);
                    moveAndReorder(str, str2);
                    return;
                }
                if (!z) {
                    if (!parentUuid.equals(parentUuid2)) {
                        ReorderItemController.this.mContract.setSelectedUuid(parentUuid2);
                        moveAndReorder(str, parentUuid2);
                        return;
                    }
                    List<NotesFolder> folderDisplayDataList = ReorderItemController.this.mFolderModel.getFolderDisplayDataList();
                    int iIndexOf = folderDisplayDataList.indexOf(folderData2);
                    int iIndexOf2 = folderDisplayDataList.indexOf(folderData) + 1;
                    int size = folderDisplayDataList.size();
                    if (size > iIndexOf2 && size > iIndexOf) {
                        NotesFolder parent2 = folderDisplayDataList.get(iIndexOf2).getParent();
                        if (iIndexOf2 - iIndexOf == 2 && parent2 != null && parent2.equals(folderDisplayDataList.get(iIndexOf)) && !parent2.equals(parent)) {
                            ReorderItemController.this.mContract.setSelectedUuid(str2);
                            moveAndReorder(str, str2);
                            return;
                        }
                    }
                }
                ReorderItemController.this.mContract.setSelectedUuid(parentUuid);
                List<NotesFolder> childOrderList = getChildOrderList(folderData, parent.getChildren(), parentUuid);
                if (childOrderList.isEmpty()) {
                    moveFail(str, str2, "reorder : children folder empty");
                } else {
                    try {
                        FolderManager.getInstance().reorder(parentUuid, childOrderList);
                    } catch (InvalidParentFolderException e) {
                        moveFail(str, str2, "reorder : " + e.getMessage());
                        return;
                    }
                }
                MainLogger.m7258i(ReorderItemController.TAG, "move success# " + str + " to " + str2);
            }

            private void setExpandedStatus(final String str) {
                if (str.equals(this.mPrvSelectedFolderUuid)) {
                    return;
                }
                MainLogger.m7254d(ReorderItemController.TAG, "setExpandedStatus# ".concat(str));
                Runnable runnable = this.mSetPostExpand;
                if (runnable != null) {
                    this.mHandler.removeCallbacks(runnable);
                }
                this.mPrvSelectedFolderUuid = str;
                Runnable runnable2 = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.folder.presenter.controller.ReorderItemController.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NotesFolder folderData;
                        if (ReorderItemController.this.mContract.getDataUpdateType() == 10 || (folderData = ReorderItemController.this.mFolderModel.getFolderData(str)) == null || folderData.isExpanded()) {
                            return;
                        }
                        ReorderItemController.this.mContract.setExpandedStatus(false, str, ReorderItemController.this.mFolderModel.getFolderDisplayDataList().indexOf(folderData));
                    }
                };
                this.mSetPostExpand = runnable2;
                this.mHandler.postDelayed(runnable2, 500L);
            }

            private void updateHolder(int i, @NonNull RecyclerView.ViewHolder viewHolder) {
                List<NotesFolder> folderDisplayDataList = ReorderItemController.this.mFolderModel.getFolderDisplayDataList();
                FolderHolder folderHolder = (FolderHolder) viewHolder;
                FolderHolderInfo folderHolderInfo = folderHolder.getFolderHolderInfo();
                String uuid = folderHolderInfo.getUuid();
                int iIndexOf = folderDisplayDataList.indexOf(ReorderItemController.this.mFolderModel.getFolderData(uuid));
                int size = folderDisplayDataList.size();
                if (i == 0) {
                    if (((FolderHolder) this.mStartViewHolder).getFolderHolderInfo().getUuid().equals(uuid)) {
                        return;
                    }
                    folderHolderInfo.setBackground(iIndexOf, size);
                    folderHolderInfo.setSelectedFolder(ReorderItemController.this.mContract.isCheckedItem(uuid));
                    if (viewHolder.equals(this.mInsertedHolder)) {
                        this.mInsertColored = false;
                        return;
                    }
                    return;
                }
                if (i == 1) {
                    folderHolderInfo.setReorderSelected(true);
                    folderHolderInfo.setBackground(iIndexOf, size, true);
                    this.mPreHolderInfo = folderHolderInfo;
                } else {
                    if (i != 2) {
                        return;
                    }
                    this.mInsertColored = true;
                    if ("addFolder:///".equals(folderHolder.getFolderHolderInfo().getUuid())) {
                        return;
                    }
                    folderHolderInfo.setBackground(iIndexOf, size);
                    folderHolderInfo.setSelectedFolder(true);
                    NotesFolder folderData = ReorderItemController.this.mFolderModel.getFolderData(uuid);
                    if (folderData == null || folderData.equals(ReorderItemController.this.mFolderModel.getFolderData(((FolderHolder) this.mStartViewHolder).getFolderHolderInfo().getUuid())) || !folderData.hasChild() || folderData.isExpanded()) {
                        return;
                    }
                    setExpandedStatus(folderData.getUuid());
                }
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public RecyclerView.ViewHolder chooseDropTarget(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<RecyclerView.ViewHolder> list, int i, int i2) {
                int left;
                int iAbs;
                int bottom;
                int iAbs2;
                int iAbs3;
                int right;
                RecyclerView.ViewHolder viewHolder2 = list.get(0);
                if (this.mInsertedHolder.equals(viewHolder2) || "addFolder:///".equals(((FolderHolder) viewHolder2).getFolderHolderInfo().getUuid())) {
                    this.mInsertedColor = 2;
                } else {
                    this.mInsertedColor = 0;
                }
                int i4 = this.mInsertedColor;
                this.mInsertedHolder = viewHolder2;
                updateHolder(i4, viewHolder2);
                int width = viewHolder.itemView.getWidth() + i;
                int height = viewHolder.itemView.getHeight() + i2;
                int left2 = i - viewHolder.itemView.getLeft();
                int top = i2 - viewHolder.itemView.getTop();
                int size = list.size();
                RecyclerView.ViewHolder viewHolder3 = null;
                int i5 = -1;
                for (int i6 = 0; i6 < size; i6++) {
                    RecyclerView.ViewHolder viewHolder4 = list.get(i6);
                    if (left2 <= 0 ? !(left2 >= 0 || (left = viewHolder4.itemView.getLeft() - i) <= 0 || viewHolder4.itemView.getLeft() >= viewHolder.itemView.getLeft() || (iAbs = Math.abs(left)) <= i5) : !((right = viewHolder4.itemView.getRight() - width) >= 0 || viewHolder4.itemView.getRight() <= viewHolder.itemView.getRight() || (iAbs = Math.abs(right)) <= i5)) {
                        viewHolder3 = viewHolder4;
                        i5 = iAbs;
                    }
                    if (top < 0) {
                        int top2 = viewHolder4.itemView.getTop() - i2;
                        if (top2 <= 0 || viewHolder4.itemView.getTop() >= viewHolder.itemView.getTop() || (iAbs3 = Math.abs(top2)) <= i5) {
                            viewHolder4 = viewHolder3;
                        } else {
                            i5 = iAbs3;
                        }
                        viewHolder3 = viewHolder4;
                    } else if (top > 0 && (bottom = viewHolder4.itemView.getBottom() - height) < 0 && viewHolder4.itemView.getBottom() > viewHolder.itemView.getBottom() && (iAbs2 = Math.abs(bottom)) > i5) {
                        viewHolder3 = viewHolder4;
                        i5 = iAbs2;
                    }
                }
                return viewHolder3;
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void clearView(@NonNull RecyclerView recyclerView2, @NonNull RecyclerView.ViewHolder viewHolder) {
                FolderHolder folderHolder;
                super.clearView(recyclerView2, viewHolder);
                RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
                if (layoutManager == null) {
                    return;
                }
                boolean z = this.mInsertColored;
                for (int i = 0; i < layoutManager.getChildCount(); i++) {
                    View childAt = layoutManager.getChildAt(i);
                    if (childAt != null && (folderHolder = (FolderHolder) recyclerView2.findContainingViewHolder(childAt)) != null) {
                        FolderHolderInfo folderHolderInfo = folderHolder.getFolderHolderInfo();
                        if (folderHolderInfo.getViewType() != 4) {
                            folderHolderInfo.setReorderSelected(false);
                            folderHolderInfo.setSelectedFolder(false);
                            FolderHolderInfo folderHolderInfo2 = this.mPreHolderInfo;
                            if (folderHolderInfo2 != null && folderHolderInfo == folderHolderInfo2) {
                                this.mPreHolderInfo = null;
                            }
                        }
                    }
                }
                FolderHolderInfo folderHolderInfo3 = this.mPreHolderInfo;
                if (folderHolderInfo3 != null) {
                    folderHolderInfo3.setReorderSelected(false);
                    this.mPreHolderInfo.setSelectedFolder(false);
                    this.mPreHolderInfo = null;
                }
                onItemMoveFinished(z, ((FolderHolder) this.mStartViewHolder).getFolderHolderInfo().getUuid(), ((FolderHolder) this.mInsertedHolder).getFolderHolderInfo().getUuid());
                VoiceAssistantTTS.getInstance().sendTalkBackMessage(ReorderItemController.this.mContext.getResources().getString(C8003R.string.base_drag_drop_at, Integer.valueOf(viewHolder.getAbsoluteAdapterPosition() + 1)));
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public float getMoveThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
                if (this.mInsertedColor != 0) {
                    updateHolder(0, this.mInsertedHolder);
                }
                return super.getMoveThreshold(viewHolder);
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public int getMovementFlags(@NotNull RecyclerView recyclerView2, @NotNull RecyclerView.ViewHolder viewHolder) {
                if (this.mActionState == 2) {
                    this.mActionState = 0;
                    updateHolder(1, this.mStartViewHolder);
                }
                return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public boolean isLongPressDragEnabled() {
                return false;
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void onChildDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView2, @NonNull RecyclerView.ViewHolder viewHolder, float f, float f4, int i, boolean z) {
                int height;
                float top = viewHolder.itemView.getTop() + f4;
                if (top > 0.0f) {
                    float height2 = top + viewHolder.itemView.getHeight();
                    if (((FolderHolder) recyclerView2.findViewHolderForAdapterPosition(recyclerView2.getAdapter().getItemCount() - 1)) != null) {
                        if (height2 >= r1.itemView.getHeight() + r1.itemView.getTop()) {
                            height = viewHolder.itemView.getHeight();
                        }
                    }
                    super.onChildDraw(canvas, recyclerView2, viewHolder, f, f4, i, z);
                }
                height = recyclerView2.getTop() - viewHolder.itemView.getHeight();
                f4 = height;
                super.onChildDraw(canvas, recyclerView2, viewHolder, f, f4, i, z);
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public boolean onMove(@NotNull RecyclerView recyclerView2, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
                int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
                int absoluteAdapterPosition2 = viewHolder2.getAbsoluteAdapterPosition();
                if (absoluteAdapterPosition == -1 || absoluteAdapterPosition2 == -1) {
                    return false;
                }
                if (absoluteAdapterPosition > absoluteAdapterPosition2) {
                    while (absoluteAdapterPosition > absoluteAdapterPosition2) {
                        int i = absoluteAdapterPosition - 1;
                        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView2.findViewHolderForAdapterPosition(i);
                        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition2 = recyclerView2.findViewHolderForAdapterPosition(absoluteAdapterPosition);
                        if (viewHolderFindViewHolderForAdapterPosition != null && viewHolderFindViewHolderForAdapterPosition2 != null && viewHolderFindViewHolderForAdapterPosition2.getItemViewType() == viewHolderFindViewHolderForAdapterPosition.getItemViewType()) {
                            this.mInsertedColor = 0;
                            this.mInsertedHolder = viewHolderFindViewHolderForAdapterPosition;
                            updateHolder(0, viewHolderFindViewHolderForAdapterPosition);
                            onItemMove(absoluteAdapterPosition, i);
                        }
                        absoluteAdapterPosition--;
                    }
                    return true;
                }
                while (absoluteAdapterPosition < absoluteAdapterPosition2) {
                    int i2 = absoluteAdapterPosition + 1;
                    RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition3 = recyclerView2.findViewHolderForAdapterPosition(i2);
                    RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition4 = recyclerView2.findViewHolderForAdapterPosition(absoluteAdapterPosition);
                    if (viewHolderFindViewHolderForAdapterPosition3 != null && viewHolderFindViewHolderForAdapterPosition4 != null && viewHolderFindViewHolderForAdapterPosition4.getItemViewType() == viewHolderFindViewHolderForAdapterPosition3.getItemViewType()) {
                        this.mInsertedColor = 0;
                        this.mInsertedHolder = viewHolderFindViewHolderForAdapterPosition3;
                        updateHolder(0, viewHolderFindViewHolderForAdapterPosition3);
                        onItemMove(absoluteAdapterPosition, i2);
                    }
                    absoluteAdapterPosition = i2;
                }
                return true;
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
                AbstractC6670b.m4736A(i, "onSelectedChanged# actionState : ", ReorderItemController.TAG);
                super.onSelectedChanged(viewHolder, i);
                if (i == 0) {
                    updateHolder(0, this.mStartViewHolder);
                } else if (i == 2) {
                    this.mStartViewHolder = viewHolder;
                    this.mInsertedHolder = viewHolder;
                    updateHolder(1, viewHolder);
                    VoiceAssistantTTS.getInstance().sendTalkBackMessage(ReorderItemController.this.mContext.getResources().getString(C8003R.string.base_drag_start_at, Integer.valueOf(viewHolder.getAbsoluteAdapterPosition() + 1)));
                }
                this.mActionState = i;
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void onSwiped(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
            }
        });
        this.mItemTouchHelper = itemTouchHelper;
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    public void reorderStart(@NotNull FolderHolder folderHolder) {
        folderHolder.itemView.setHapticFeedbackEnabled(false);
        this.mItemTouchHelper.startDrag(folderHolder);
        folderHolder.itemView.setHapticFeedbackEnabled(true);
    }
}
