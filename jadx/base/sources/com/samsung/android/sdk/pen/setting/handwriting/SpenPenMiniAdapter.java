package com.samsung.android.sdk.pen.setting.handwriting;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenBaseView;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\b\u0000\u0018\u0000 *2\u000e\u0012\n\u0012\b\u0018\u00010\u0002R\u00020\u00000\u0001:\u0003*+,B\u001f\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u001c\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u0007J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J\u0014\u0010\u001f\u001a\u0004\u0018\u00010\r2\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\rJ\u0018\u0010#\u001a\u00020\u00172\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0004H\u0007J\u0010\u0010%\u001a\u00020\u00172\b\u0010&\u001a\u0004\u0018\u00010\u0011J\u0012\u0010'\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010(\u001a\u00020\u00172\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006-"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenMiniAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenMiniAdapter$ViewHolder;", XmlErrorCodes.LIST, "", "", "itemLayoutId", "", "<init>", "(Ljava/util/List;I)V", "mList", "", "mPenInfoList", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "mSelectIdx", "mItemLayoutId", "mItemClickListener", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenMiniAdapter$OnItemClickListener;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemCount", "selectedPosition", "getSelectedPosition", "()I", "getPenName", "getPenInfo", "penName", "setPenInfo", "penInfo", "setListPenInfo", "penInfoList", "setOnItemClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "findPenIndex", "initList", "penNames", "Companion", "OnItemClickListener", "ViewHolder", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPenMiniAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final int CHANGE_SELECT = 1;

    @NotNull
    private static final String TAG = "SpenPenMiniAdapter";

    @Nullable
    private OnItemClickListener mItemClickListener;
    private final int mItemLayoutId;

    @Nullable
    private List<String> mList;

    @Nullable
    private List<SpenSettingPenInfo> mPenInfoList;
    private int mSelectIdx;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenMiniAdapter$OnItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "position", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnItemClickListener {
        void onItemClick(@Nullable View view, int position);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenMiniAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenMiniAdapter;Landroid/view/View;)V", "penView", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenMiniView;", "getPenView", "()Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenMiniView;", "setPenView", "(Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenMiniView;)V", "onClick", "", VPathDataCmd.RCurveTo, "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Nullable
        private SpenPenMiniView penView;
        final /* synthetic */ SpenPenMiniAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull SpenPenMiniAdapter spenPenMiniAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = spenPenMiniAdapter;
            if (itemView instanceof SpenPenMiniView) {
                SpenPenMiniView spenPenMiniView = (SpenPenMiniView) itemView;
                this.penView = spenPenMiniView;
                Intrinsics.checkNotNull(spenPenMiniView);
                SpenPenBaseView penView = spenPenMiniView.getMPenView();
                Intrinsics.checkNotNull(penView);
                penView.setOnClickListener(this);
            }
            itemView.setOnClickListener(this);
        }

        @Nullable
        public final SpenPenMiniView getPenView() {
            return this.penView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            int adapterPosition = getAdapterPosition();
            if (adapterPosition == -1 || this.this$0.mItemClickListener == null) {
                return;
            }
            OnItemClickListener onItemClickListener = this.this$0.mItemClickListener;
            Intrinsics.checkNotNull(onItemClickListener);
            onItemClickListener.onItemClick(v, adapterPosition);
        }

        public final void setPenView(@Nullable SpenPenMiniView spenPenMiniView) {
            this.penView = spenPenMiniView;
        }
    }

    public SpenPenMiniAdapter(@Nullable List<String> list, int i) {
        initList(list);
        this.mItemLayoutId = i;
        this.mSelectIdx = -1;
    }

    private final int findPenIndex(String penName) {
        List<String> list = this.mList;
        if (list != null) {
            return CollectionsKt.indexOf((List<? extends String>) list, penName);
        }
        return -1;
    }

    private final SpenSettingPenInfo getPenInfo(int position) {
        return getPenInfo(getPenName(position));
    }

    private final void initList(List<String> penNames) {
        if (this.mList == null) {
            this.mList = new ArrayList();
        }
        List<String> list = this.mList;
        Intrinsics.checkNotNull(list);
        list.clear();
        List<String> list2 = penNames;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        List<String> list3 = this.mList;
        Intrinsics.checkNotNull(list3);
        list3.addAll(list2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.mList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Nullable
    public final String getPenName(int position) {
        List<String> list = this.mList;
        if (list == null) {
            return null;
        }
        Intrinsics.checkNotNull(list);
        if (position >= list.size()) {
            return null;
        }
        List<String> list2 = this.mList;
        Intrinsics.checkNotNull(list2);
        return list2.get(position);
    }

    /* JADX INFO: renamed from: getSelectedPosition, reason: from getter */
    public final int getMSelectIdx() {
        return this.mSelectIdx;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void setListPenInfo(@Nullable List<? extends SpenSettingPenInfo> penInfoList) {
        if (this.mPenInfoList == null) {
            this.mPenInfoList = new ArrayList();
        }
        List<SpenSettingPenInfo> list = this.mPenInfoList;
        Intrinsics.checkNotNull(list);
        list.clear();
        List<? extends SpenSettingPenInfo> list2 = penInfoList;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        List<SpenSettingPenInfo> list3 = this.mPenInfoList;
        Intrinsics.checkNotNull(list3);
        list3.addAll(list2);
        notifyDataSetChanged();
    }

    public final void setOnItemClickListener(@Nullable OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    public final void setPenInfo(@NotNull SpenSettingPenInfo penInfo) {
        Intrinsics.checkNotNullParameter(penInfo, "penInfo");
        int iFindPenIndex = findPenIndex(penInfo.name);
        int i = this.mSelectIdx;
        if (iFindPenIndex > -1) {
            SpenSettingPenInfo penInfo2 = getPenInfo(penInfo.name);
            if (penInfo2 == null) {
                return;
            }
            penInfo2.color = penInfo.color;
            penInfo2.sizeLevel = penInfo.sizeLevel;
            penInfo2.particleSize = penInfo.particleSize;
            penInfo2.isFixedWidth = penInfo.isFixedWidth;
            penInfo2.isFixedOpacity = penInfo.isFixedOpacity;
            this.mSelectIdx = iFindPenIndex;
        }
        if (i != -1) {
            notifyItemChanged(i, 1);
        }
        notifyItemChanged(this.mSelectIdx, 1);
    }

    private final SpenSettingPenInfo getPenInfo(String penName) {
        List<SpenSettingPenInfo> list;
        if (penName != null && (list = this.mPenInfoList) != null) {
            Intrinsics.checkNotNull(list);
            for (SpenSettingPenInfo spenSettingPenInfo : list) {
                if (Intrinsics.areEqual(spenSettingPenInfo.name, penName)) {
                    return spenSettingPenInfo;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Log.i(TAG, "onBindViewHolder() position=" + position);
        SpenSettingPenInfo penInfo = getPenInfo(position);
        if (penInfo != null) {
            String penName = getPenName(position);
            Intrinsics.checkNotNull(penName);
            penInfo.name = penName;
            SpenPenMiniView penView = holder.getPenView();
            Intrinsics.checkNotNull(penView);
            penView.setPenInfo(penInfo);
            SpenPenMiniView penView2 = holder.getPenView();
            Intrinsics.checkNotNull(penView2);
            penView2.setSelected(this.mSelectIdx == position);
            int penDescriptionID = SpenPenResource.getPenDescriptionID(penInfo.name);
            SpenPenMiniView penView3 = holder.getPenView();
            Intrinsics.checkNotNull(penView3);
            String string = penView3.getResources().getString(penDescriptionID);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            SpenSettingUtilHover.setHoverText(holder.getPenView(), string);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(this.mItemLayoutId, parent, false);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.handwriting.SpenPenMiniView");
        return new ViewHolder(this, (SpenPenMiniView) viewInflate);
    }
}
