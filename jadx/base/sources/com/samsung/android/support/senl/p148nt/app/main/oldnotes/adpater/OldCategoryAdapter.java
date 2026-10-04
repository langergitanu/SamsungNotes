package com.samsung.android.support.senl.p148nt.app.main.oldnotes.adpater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.oldnotes.adpater.holder.OldCategoryHolder;
import com.samsung.android.support.senl.p148nt.app.main.oldnotes.adpater.holder.OldCommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.oldnotes.adpater.holder.OldNotifyHolder;
import com.samsung.android.support.senl.p148nt.app.main.oldnotes.model.OldCategoryData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0002./B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u000eH\u0016J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\u000eH\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u000eH\u0016J\u0012\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002J\u0012\u0010%\u001a\u00020\u00162\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u000eH\u0016J\u000e\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\bJ\u000e\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u000eR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/oldnotes/adpater/OldCategoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/samsung/android/support/senl/nt/app/main/oldnotes/adpater/holder/OldCommonHolder;", "Lcom/samsung/android/support/senl/nt/app/main/oldnotes/adpater/holder/OldCategoryHolder$Contract;", "Lcom/samsung/android/support/senl/nt/app/main/oldnotes/adpater/holder/OldNotifyHolder$Contract;", "<init>", "()V", "mIsNotifyVisible", "", "getMIsNotifyVisible", "()Z", "setMIsNotifyVisible", "(Z)V", "mNotifyBtnMargin", "", "getMNotifyBtnMargin", "()I", "setMNotifyBtnMargin", "(I)V", "mContract", "Lcom/samsung/android/support/senl/nt/app/main/oldnotes/adpater/OldCategoryAdapter$Contract;", "setContract", "", "contract", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemViewType", "getItemCount", "getItemId", "", "getOldCategoryDataByPosition", "Lcom/samsung/android/support/senl/nt/app/main/oldnotes/model/OldCategoryData;", "onItemSelected", "categoryUuid", "", "onNotifyBtnClicked", "type", "updateNotifyVisibility", "isVisible", "setNotifyButtonMargin", "margin", "Contract", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class OldCategoryAdapter extends RecyclerView.Adapter<OldCommonHolder> implements OldCategoryHolder.Contract, OldNotifyHolder.Contract {

    @NotNull
    public static final String TAG = "OldCategoryAdapter";

    @Nullable
    private Contract mContract;
    private boolean mIsNotifyVisible;
    private int mNotifyBtnMargin;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0007H&R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/oldnotes/adpater/OldCategoryAdapter$Contract;", "", "onItemSelected", "", "categoryUuid", "", "oldCategoryDataCount", "", "getOldCategoryDataCount", "()I", "getOldCategoryData", "Lcom/samsung/android/support/senl/nt/app/main/oldnotes/model/OldCategoryData;", "position", "onNotifyBtnClicked", "type", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        @Nullable
        OldCategoryData getOldCategoryData(int position);

        int getOldCategoryDataCount();

        void onItemSelected(@Nullable String categoryUuid);

        void onNotifyBtnClicked(int type);
    }

    public OldCategoryAdapter() {
        setHasStableIds(true);
    }

    private final OldCategoryData getOldCategoryDataByPosition(int position) {
        Contract contract = this.mContract;
        if (contract != null) {
            return contract.getOldCategoryData(position);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        Contract contract = this.mContract;
        if (contract != null) {
            return contract.getOldCategoryDataCount();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return getOldCategoryDataByPosition(position) != null ? r3.getId() : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        OldCategoryData oldCategoryDataByPosition = getOldCategoryDataByPosition(position);
        if (oldCategoryDataByPosition != null) {
            return oldCategoryDataByPosition.getMHolderType();
        }
        return 0;
    }

    public final boolean getMIsNotifyVisible() {
        return this.mIsNotifyVisible;
    }

    public final int getMNotifyBtnMargin() {
        return this.mNotifyBtnMargin;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.oldnotes.adpater.holder.OldCategoryHolder.Contract
    public void onItemSelected(@Nullable String categoryUuid) {
        Contract contract = this.mContract;
        if (contract != null) {
            contract.onItemSelected(categoryUuid);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.oldnotes.adpater.holder.OldNotifyHolder.Contract
    public void onNotifyBtnClicked(int type) {
        Contract contract = this.mContract;
        if (contract != null) {
            contract.onNotifyBtnClicked(type);
        }
    }

    public final void setContract(@Nullable Contract contract) {
        this.mContract = contract;
    }

    public final void setMIsNotifyVisible(boolean z) {
        this.mIsNotifyVisible = z;
    }

    public final void setMNotifyBtnMargin(int i) {
        this.mNotifyBtnMargin = i;
    }

    public final void setNotifyButtonMargin(int margin) {
        this.mNotifyBtnMargin = margin;
    }

    public final void updateNotifyVisibility(boolean isVisible) {
        this.mIsNotifyVisible = isVisible;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull OldCommonHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MainLogger.m7254d(TAG, "onBindViewHolder# " + position);
        OldCategoryData oldCategoryDataByPosition = getOldCategoryDataByPosition(position);
        if (oldCategoryDataByPosition == null) {
            return;
        }
        int mHolderType = oldCategoryDataByPosition.getMHolderType();
        if (mHolderType == 0) {
            ((OldCategoryHolder) holder).decorateItemView(oldCategoryDataByPosition, getItemCount() == position + 1);
        } else {
            if (mHolderType != 1) {
                return;
            }
            ((OldNotifyHolder) holder).decorateItemView(oldCategoryDataByPosition.getMNotifyType(), this.mIsNotifyVisible, this.mNotifyBtnMargin);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public OldCommonHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int viewType) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        MainLogger.m7254d(TAG, "onCreateViewHolder# ");
        if (viewType == 1) {
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.old_category_notify_item_holder, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
            return new OldNotifyHolder(viewInflate, this);
        }
        View viewInflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.old_category_list_item_holder, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate2, "inflate(...)");
        return new OldCategoryHolder(viewInflate2, this);
    }
}
