package com.samsung.android.support.senl.p148nt.app.main.folder.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.folder.model.FolderModel;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FolderAdapter extends RecyclerView.Adapter<FolderHolder> {
    private static final String TAG = "FolderAdapter";
    private final AdapterContract mAdapterContract;
    private final int mAddFolderIconMarginStart;
    private final int mCheckBoxMarginStart;
    private final int mCheckBoxWidth;
    private final Context mContext;
    private final int mFolderListItemDepthMargin;
    private final int mFolderListItemMarginStart;
    private final FolderModel mModel;

    public FolderAdapter(Context context, AdapterContract adapterContract, FolderModel folderModel) {
        setHasStableIds(true);
        this.mContext = context;
        this.mAdapterContract = adapterContract;
        this.mModel = folderModel;
        Resources resources = context.getResources();
        this.mFolderListItemMarginStart = resources.getDimensionPixelSize(C8003R.dimen.folder_list_item_margin_start);
        this.mFolderListItemDepthMargin = resources.getDimensionPixelOffset(C8003R.dimen.folder_list_item_margin_start_depth);
        this.mCheckBoxWidth = resources.getDimensionPixelSize(C8003R.dimen.item_checkbox_width);
        this.mCheckBoxMarginStart = resources.getDimensionPixelOffset(C8003R.dimen.folder_list_item_check_box_margin_start);
        this.mAddFolderIconMarginStart = resources.getDimensionPixelSize(C8003R.dimen.folder_list_item_plus_icon_margin_start);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<NotesFolder> folderDisplayDataList = this.mModel.getFolderDisplayDataList();
        if (folderDisplayDataList != null) {
            return folderDisplayDataList.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        NotesFolder folderDisplayData = this.mModel.getFolderDisplayData(i);
        if (folderDisplayData == null) {
            return 0L;
        }
        return folderDisplayData.getId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.mModel.getFolderDisplayData(i) == null) {
            return 0;
        }
        return this.mModel.getFolderDisplayData(i).getViewType();
    }

    public void notifyDataSetChanged(String str) {
        MainLogger.m7254d(TAG, "notifyDataSetChanged# caller : " + str);
        notifyDataSetChanged();
    }

    public void onItemMove(int i, int i2) {
        if (i == i2) {
            return;
        }
        this.mModel.getFolderDisplayDataList().add(i, this.mModel.getFolderDisplayDataList().remove(i2));
        notifyItemMoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public FolderHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new FolderHolder(LayoutInflater.from(this.mContext).inflate(C8003R.layout.folder_list_item, viewGroup, false), this.mAdapterContract, this.mFolderListItemMarginStart, this.mFolderListItemDepthMargin, this.mCheckBoxWidth, this.mCheckBoxMarginStart, this.mAddFolderIconMarginStart);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull FolderHolder folderHolder) {
        folderHolder.setCheckBoxStatus(this.mAdapterContract.getModeIndex() == 3 ? 0 : 8);
        folderHolder.setFolderItemDim(this.mAdapterContract.isDimItem(folderHolder.getFolderHolderInfo().getUuid()));
        folderHolder.setFolderItemLayoutTransition();
        folderHolder.applySelectedViewHolder(this.mAdapterContract.getFolderUuid().equals(folderHolder.getFolderHolderInfo().getUuid()));
        this.mAdapterContract.setDragListener(folderHolder.getFolderHolderInfo());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull FolderHolder folderHolder, int i, @NonNull List list) {
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "onBindViewHolder position : ", " payLoads size: ");
        sbM778t.append(list.size());
        MainLogger.m7258i(TAG, sbM778t.toString());
        if (list.isEmpty()) {
            folderHolder.decorate(this.mModel.getFolderDisplayData(i));
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                if (num.intValue() == 0) {
                    folderHolder.decorateIcon(this.mModel.getFolderDisplayData(i));
                } else if (num.intValue() == 1) {
                    folderHolder.decorateTitle(this.mModel.getFolderDisplayData(i));
                } else if (num.intValue() == 2) {
                    folderHolder.decorateCount(this.mModel.getFolderDisplayData(i));
                }
                this.mAdapterContract.setDragListener(folderHolder.getFolderHolderInfo());
            }
            this.mAdapterContract.updateContentDescription(folderHolder.getFolderHolderInfo());
        }
        folderHolder.getFolderHolderInfo().setBackground(i, this.mModel.getFolderDisplayDataList().size());
        folderHolder.applySelectedViewHolder(this.mAdapterContract.getFolderUuid().equals(folderHolder.getFolderHolderInfo().getUuid()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull FolderHolder folderHolder, int i) {
        AbstractC8014b.m7201c(i, "onBindViewHolder position : ", TAG);
        folderHolder.decorate(this.mModel.getFolderDisplayData(i));
        folderHolder.getFolderHolderInfo().setBackground(i, this.mModel.getFolderDisplayDataList().size());
        this.mAdapterContract.updateContentDescription(folderHolder.getFolderHolderInfo());
    }
}
