package com.samsung.android.support.senl.p148nt.app.main.common.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005H\u0016J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0000H\u0016J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0000H\u0016J\u001c\u0010#\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H&R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0010\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006("}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/adapter/CommonHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewMode", "", "<init>", "(Landroid/view/View;I)V", "getViewMode", "()I", "mHolderType", "mAdapterContract", "Lcom/samsung/android/support/senl/nt/app/main/common/adapter/AdapterContract;", "mIsBottomOfSameViewType", "", "value", "adapterContract", "getAdapterContract", "()Lcom/samsung/android/support/senl/nt/app/main/common/adapter/AdapterContract;", "setAdapterContract", "(Lcom/samsung/android/support/senl/nt/app/main/common/adapter/AdapterContract;)V", "holderType", "getHolderType", "setHolderType", "(I)V", "isBottomOfSameViewType", "()Z", "setBottomOfSameViewType", "(Z)V", "onBindViewHolder", "", "position", "onViewAttachedToWindow", "commonHolder", "onViewDetachedFromWindow", "decorate", "holderData", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/model/Common;", "stateInfo", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/model/StateInfo;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class CommonHolder extends RecyclerView.ViewHolder {

    @Nullable
    private AdapterContract mAdapterContract;
    private int mHolderType;
    private boolean mIsBottomOfSameViewType;
    private final int viewMode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonHolder(@NotNull View itemView, int i) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.viewMode = i;
    }

    public abstract void decorate(@Nullable Common holderData, @Nullable StateInfo stateInfo);

    @Nullable
    /* JADX INFO: renamed from: getAdapterContract, reason: from getter */
    public AdapterContract getMAdapterContract() {
        return this.mAdapterContract;
    }

    /* JADX INFO: renamed from: getHolderType, reason: from getter */
    public final int getMHolderType() {
        return this.mHolderType;
    }

    public int getViewMode() {
        return this.viewMode;
    }

    /* JADX INFO: renamed from: isBottomOfSameViewType, reason: from getter */
    public final boolean getMIsBottomOfSameViewType() {
        return this.mIsBottomOfSameViewType;
    }

    public void onBindViewHolder(int position) {
    }

    public void onViewAttachedToWindow(@NotNull CommonHolder commonHolder) {
        Intrinsics.checkNotNullParameter(commonHolder, "commonHolder");
    }

    public void onViewDetachedFromWindow(@NotNull CommonHolder commonHolder) {
        Intrinsics.checkNotNullParameter(commonHolder, "commonHolder");
    }

    public void setAdapterContract(@Nullable AdapterContract adapterContract) {
        this.mAdapterContract = adapterContract;
    }

    public final void setBottomOfSameViewType(boolean z) {
        this.mIsBottomOfSameViewType = z;
    }

    public final void setHolderType(int i) {
        this.mHolderType = i;
    }
}
