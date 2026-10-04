package com.samsung.android.sdk.pen.setting.favoritepen;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenBaseView;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\f\b\u0000\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00046789B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u000fJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0006H\u0016J&\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00062\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\bH\u0016J\u0018\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006H\u0016J\u0018\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020+2\u0006\u0010 \u001a\u00020\u0006H\u0002J\u0010\u0010,\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001aH\u0002J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0006H\u0016J\u000e\u00104\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u000fR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R4\u0010/\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010.2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010.8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006:"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenAdapter;", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenBaseAdapter;", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteDragAdapter;", "context", "Landroid/content/Context;", "maxCount", "", XmlErrorCodes.LIST, "", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "mDragStartListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteDragListener;", "<init>", "(Landroid/content/Context;ILjava/util/List;Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteDragListener;)V", "mIsNeedAnimation", "", "mIsAddButtonEnabled", "mOnItemEventListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenAdapter$OnItemEventListener;", "close", "", "setOnItemEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAddButtonEnabled", "enabled", "onCreateViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "payloads", "", "onItemMove", "fromPosition", "toPosition", "itemOffset", "getItemOffset", "()I", "onItemEvent", "view", "Landroid/view/View;", "onItemStartDrag", "deletePen", "", "favoriteList", "getFavoriteList", "()Ljava/util/List;", "setFavoriteList", "(Ljava/util/List;)V", "setItemAnimation", "isNeedAnimation", "Companion", "OnItemEventListener", "FavoritePenViewHolder", "AddViewHolder", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenFavoritePenAdapter extends SpenFavoritePenBaseAdapter implements SpenFavoriteDragAdapter {

    @NotNull
    private static final String TAG = "SpenFavoritePenAdapter";

    @Nullable
    private SpenFavoriteDragListener mDragStartListener;
    private boolean mIsAddButtonEnabled;
    private boolean mIsNeedAnimation;

    @Nullable
    private OnItemEventListener mOnItemEventListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenAdapter$AddViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenAdapter;Landroid/view/View;)V", "mAddButton", "getMAddButton", "()Landroid/view/View;", "setMAddButton", "(Landroid/view/View;)V", "onClick", "", VPathDataCmd.RCurveTo, "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class AddViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Nullable
        private View mAddButton;
        final /* synthetic */ SpenFavoritePenAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddViewHolder(@NotNull SpenFavoritePenAdapter spenFavoritePenAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = spenFavoritePenAdapter;
            View viewFindViewById = itemView.findViewById(C7932R.id.add_icon);
            this.mAddButton = viewFindViewById;
            if (viewFindViewById != null) {
                SpenSettingUtilHover.setHoverEffect(viewFindViewById, itemView.getContext().getResources().getDimensionPixelSize(C7932R.dimen.setting_favorite_pen_view_round_bg_elevation_hover), viewFindViewById.getElevation());
                viewFindViewById.setOnClickListener(this);
                String string = itemView.getResources().getString(C7932R.string.pen_string_add_favorite_pen);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                viewFindViewById.setContentDescription(string);
                SpenSettingUtilHover.setHoverText(viewFindViewById, string);
            }
        }

        @Nullable
        public final View getMAddButton() {
            return this.mAddButton;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            OnItemEventListener onItemEventListener = this.this$0.mOnItemEventListener;
            if (onItemEventListener != null) {
                onItemEventListener.onAddItemClick();
            }
        }

        public final void setMAddButton(@Nullable View view) {
            this.mAddButton = view;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B)\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0014J\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0005H\u0016¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenAdapter$FavoritePenViewHolder;", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteViewHolder;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "itemView", "Landroid/view/View;", "favoriteId", "", "deleteId", "roundBgId", "<init>", "(Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenAdapter;Landroid/view/View;III)V", "finalize", "", "setMode", "mode", "supportLongClick", "", "onClick", VPathDataCmd.RCurveTo, "onLongClick", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class FavoritePenViewHolder extends SpenFavoriteViewHolder implements View.OnClickListener, View.OnLongClickListener {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FavoritePenViewHolder(@Nullable View view, int i, int i2, int i4) {
            super(view, i, i2, i4);
            Intrinsics.checkNotNull(view);
            ImageButton imageButton = this.mDeleteButton;
            if (imageButton != null) {
                imageButton.setOnClickListener(this);
            }
        }

        @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteViewHolder
        public void finalize() {
            this.mContainer.setOnLongClickListener(null);
            super.finalize();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            int adapterPosition = getAdapterPosition();
            if (adapterPosition == -1) {
                return;
            }
            int selectedPosition = SpenFavoritePenAdapter.this.getMSelectedPosition();
            if (SpenFavoritePenAdapter.this.getMode() == 1 && selectedPosition != adapterPosition) {
                SpenFavoritePenAdapter.this.setSelectedPosition(adapterPosition);
                SpenFavoritePenAdapter.this.notifyItemChanged(adapterPosition, 1);
                if (selectedPosition != -1) {
                    SpenFavoritePenAdapter.this.notifyItemChanged(selectedPosition, 1);
                }
            }
            SpenFavoritePenAdapter.this.onItemEvent(v, adapterPosition);
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            SpenFavoritePenAdapter spenFavoritePenAdapter = SpenFavoritePenAdapter.this;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.ViewHolder");
            spenFavoritePenAdapter.onItemStartDrag(this);
            return false;
        }

        public final void setMode(int mode, boolean supportLongClick) {
            SpenPenBaseView penView;
            SpenPenBaseView penView2;
            SpenPenBaseView penView3;
            SpenPenBaseView penView4;
            SpenPenBaseView penView5;
            if (mode == 1) {
                setDeleteButtonVisibility(8, SpenFavoritePenAdapter.this.mIsNeedAnimation);
                setRoundBackgroundVisibility(8, SpenFavoritePenAdapter.this.mIsNeedAnimation);
                this.mContainer.setOnClickListener(this);
                SpenFavoritePenBaseView spenFavoritePenBaseView = this.mFavoritePenView;
                if (spenFavoritePenBaseView != null && (penView5 = spenFavoritePenBaseView.getPenView()) != null) {
                    penView5.setOnClickListener(this);
                }
                SpenFavoritePenBaseView spenFavoritePenBaseView2 = this.mFavoritePenView;
                if (spenFavoritePenBaseView2 != null && (penView4 = spenFavoritePenBaseView2.getPenView()) != null) {
                    penView4.setImportantForAccessibility(1);
                }
                this.mContainer.setImportantForAccessibility(1);
            } else {
                setDeleteButtonVisibility(0, SpenFavoritePenAdapter.this.mIsNeedAnimation);
                setRoundBackgroundVisibility(0, SpenFavoritePenAdapter.this.mIsNeedAnimation);
                this.mContainer.setOnClickListener(null);
                SpenFavoritePenBaseView spenFavoritePenBaseView3 = this.mFavoritePenView;
                if (spenFavoritePenBaseView3 != null && (penView2 = spenFavoritePenBaseView3.getPenView()) != null) {
                    penView2.setOnClickListener(null);
                }
                SpenFavoritePenBaseView spenFavoritePenBaseView4 = this.mFavoritePenView;
                if (spenFavoritePenBaseView4 != null && (penView = spenFavoritePenBaseView4.getPenView()) != null) {
                    penView.setImportantForAccessibility(2);
                }
                this.mContainer.setImportantForAccessibility(2);
                this.mContainer.setClickable(false);
            }
            this.itemView.setOnLongClickListener(supportLongClick ? this : null);
            SpenFavoritePenBaseView spenFavoritePenBaseView5 = this.mFavoritePenView;
            if (spenFavoritePenBaseView5 == null || (penView3 = spenFavoritePenBaseView5.getPenView()) == null) {
                return;
            }
            penView3.setOnLongClickListener(supportLongClick ? this : null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenAdapter$OnItemEventListener;", "", "onItemClick", "", "mode", "", "position", "onAddItemClick", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnItemEventListener {
        void onAddItemClick();

        void onItemClick(int mode, int position);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenFavoritePenAdapter(@NotNull Context context, int i, @Nullable List<? extends SpenSettingUIPenInfo> list, @Nullable SpenFavoriteDragListener spenFavoriteDragListener) {
        super(context, i, list);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDragStartListener = spenFavoriteDragListener;
        this.mIsAddButtonEnabled = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean onItemEvent(View view, int position) {
        OnItemEventListener onItemEventListener = this.mOnItemEventListener;
        if (onItemEventListener == null) {
            return false;
        }
        onItemEventListener.onItemClick(getMode(), position);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onItemStartDrag(RecyclerView.ViewHolder holder) {
        SpenFavoriteDragListener spenFavoriteDragListener = this.mDragStartListener;
        if (spenFavoriteDragListener != null) {
            spenFavoriteDragListener.onStartDrag(holder);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenBaseAdapter
    public void close() {
        Log.i(TAG, "close()");
        this.mDragStartListener = null;
        super.close();
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenBaseAdapter
    public void deletePen(int position) {
        super.deletePen(position);
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenBaseAdapter
    @Nullable
    public List<SpenSettingUIPenInfo> getFavoriteList() {
        return super.getFavoriteList();
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenBaseAdapter
    public int getItemOffset() {
        if (this.mIsAddButtonEnabled) {
            return super.getItemOffset();
        }
        Log.i(TAG, "AddButton has been disabled");
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Log.i(TAG, "onBindViewHolder() position=" + position);
        if (holder.getItemViewType() != 1) {
            return;
        }
        SpenSettingUIPenInfo penInfo = getPenInfo(position);
        FavoritePenViewHolder favoritePenViewHolder = (FavoritePenViewHolder) holder;
        if (penInfo != null) {
            favoritePenViewHolder.setInfo(penInfo, getVisiblePenColor(penInfo.color), getColorName(penInfo.hsv));
        }
        int mode = getMode();
        boolean z = getMSelectedPosition() == position;
        favoritePenViewHolder.setMode(mode, mode == 1 && getPenCount() > 0);
        favoritePenViewHolder.setSelected(mode == 1 && z, z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Log.i(TAG, "onCreateViewHolder() viewType=" + viewType);
        if (viewType != 2) {
            return new FavoritePenViewHolder(LayoutInflater.from(parent.getContext()).inflate(C7932R.layout.setting_favorite_adapter_view, parent, false), C7932R.id.favorite_adapter_view, C7932R.id.delete_btn, C7932R.id.pen_rounded_bg);
        }
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C7932R.layout.setting_favorite_adapter_add_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return new AddViewHolder(this, viewInflate);
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteDragAdapter
    public boolean onItemMove(int fromPosition, int toPosition) {
        return changePen(fromPosition, toPosition);
    }

    public final void setAddButtonEnabled(boolean enabled) {
        this.mIsAddButtonEnabled = enabled;
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenBaseAdapter
    public void setFavoriteList(@Nullable List<SpenSettingUIPenInfo> list) {
        super.setFavoriteList(list);
        setItemAnimation(false);
    }

    public final void setItemAnimation(boolean isNeedAnimation) {
        this.mIsNeedAnimation = isNeedAnimation;
    }

    public final void setOnItemEventListener(@Nullable OnItemEventListener listener) {
        this.mOnItemEventListener = listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads);
            return;
        }
        boolean z = false;
        if ((payloads.get(0) instanceof Integer) || (holder instanceof FavoritePenViewHolder) || holder.getItemViewType() == 1) {
            Object obj = payloads.get(0);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            if (((Integer) obj).intValue() == 1) {
                FavoritePenViewHolder favoritePenViewHolder = (FavoritePenViewHolder) holder;
                if (getMode() == 1 && getMSelectedPosition() == position) {
                    z = true;
                }
                favoritePenViewHolder.setSelected(z, true);
            }
        }
    }
}
