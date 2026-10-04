package com.samsung.android.support.senl.p148nt.app.main.drawer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.drawer.model.DrawerModel;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class DrawerAdapter extends RecyclerView.Adapter<DrawerHolder> {
    private static final String TAG = "DrawerAdapter";
    private final AdapterContract mAdapterContract;
    private final int mBaseHolderType;
    private final int mDirectoryDepthWidth;
    private final DrawerModel mModel;

    public DrawerAdapter(Context context, AdapterContract adapterContract, DrawerModel drawerModel) {
        this.mAdapterContract = adapterContract;
        this.mModel = drawerModel;
        setHasStableIds(true);
        if (NotesUtils.isTabletLayout(context)) {
            this.mBaseHolderType = 1024;
            this.mDirectoryDepthWidth = context.getResources().getDimensionPixelSize(C8003R.dimen.tablet_drawer_bar_icon_margin_start);
        } else if (adapterContract.isFreeFormWindow()) {
            this.mBaseHolderType = 4096;
            this.mDirectoryDepthWidth = context.getResources().getDimensionPixelSize(C8003R.dimen.drawer_list_item_depth_margin_start) / 2;
        } else {
            this.mBaseHolderType = 2048;
            this.mDirectoryDepthWidth = context.getResources().getDimensionPixelSize(C8003R.dimen.drawer_list_item_depth_margin_start);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<NotesFolder> drawerDisplayDataList = this.mModel.getDrawerDisplayDataList();
        if (drawerDisplayDataList == null) {
            return 0;
        }
        return drawerDisplayDataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        NotesFolder drawerDisplayData = this.mModel.getDrawerDisplayData(i);
        if (drawerDisplayData == null) {
            return 0L;
        }
        return drawerDisplayData.getId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        NotesFolder drawerDisplayData = this.mModel.getDrawerDisplayData(i);
        if (drawerDisplayData == null) {
            return 0;
        }
        return drawerDisplayData.getViewType() | this.mBaseHolderType;
    }

    public void notifyDataSetChanged(String str) {
        MainLogger.m7254d(TAG, "notifyDataSetChanged# caller : " + str);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public DrawerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new DrawerHolder((i & 1024) != 0 ? LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.drawer_list_item_tablet, viewGroup, false) : (i & 4096) != 0 ? LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.drawer_list_item_free_form_window, viewGroup, false) : LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.drawer_list_item, viewGroup, false), this.mAdapterContract, this.mDirectoryDepthWidth);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull DrawerHolder drawerHolder) {
        this.mAdapterContract.setDragListener(drawerHolder);
        drawerHolder.onViewAttachedToWindow();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull DrawerHolder drawerHolder, int i, @NonNull List list) {
        NotesFolder drawerDisplayData = this.mModel.getDrawerDisplayData(i);
        if (drawerDisplayData == null) {
            MainLogger.m7259w(TAG, "onBindViewHolder# folder data is null, position : " + i);
            return;
        }
        if (list.isEmpty()) {
            MainLogger.m7254d(TAG, "onBindViewHolder# payloads is empty, position : " + i);
            drawerHolder.decorate(drawerDisplayData);
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() == 0) {
                drawerHolder.decorateIcon(drawerDisplayData);
            } else if (num.intValue() == 2) {
                drawerHolder.decorateCount(drawerDisplayData);
                drawerHolder.setContentDescription(drawerDisplayData.getUuid(), drawerDisplayData.getViewType());
            } else if (num.intValue() == 3) {
                drawerHolder.updateNewBadge(drawerDisplayData.getViewType(), drawerDisplayData.isExpanded());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull DrawerHolder drawerHolder, int i) {
        AbstractC6670b.m4736A(i, "onBindViewHolder# position : ", TAG);
        drawerHolder.decorate(this.mModel.getDrawerDisplayData(i));
    }
}
