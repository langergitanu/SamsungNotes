package com.samsung.android.sdk.pen.setting.favoritepen;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import androidx.collection.AbstractC0622a;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.spen.C7932R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0001\u0018\u0000 32\u00020\u0001:\u0003345B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\tJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0014J@\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u0014H\u0016J\u0006\u0010&\u001a\u00020\u000bJ0\u0010'\u001a\u0004\u0018\u00010\u00122\u0006\u0010(\u001a\u00020\u00122\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00120*2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000eH\u0016J\b\u0010-\u001a\u00020\u000eH\u0016J(\u0010.\u001a\u00020/2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u001dH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragManager;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "mContext", "Landroid/content/Context;", "mFavoriteDragAdapter", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteDragAdapter;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteDragAdapter;)V", "mOnItemDropListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragManager$OnItemDropListener;", "setOnItemDropListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getMovementFlags", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onMove", "", "sourceView", "targetView", "onSwiped", "direction", "clearView", "isLongPressDragEnabled", "isItemViewSwipeEnabled", "getMoveThreshold", "", "setIsLongPressDragEnabled", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "dY", "actionState", "isCurrentlyActive", "close", "chooseDropTarget", "selected", "dropTargets", "", "curX", "curY", "getBoundingBoxMargin", "getAnimationDuration", "", "animationType", "animateDx", "animateDy", "Companion", "OnItemDropListener", "OnDraggingItemListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public final class SpenFavoriteItemDragManager extends ItemTouchHelper.Callback {
    private static final int DRAG_ANIMATION_DURATION = 200;
    private static final int SCALE_ANIMATION_DURATION = 200;
    private static final float SCALE_UP_RATIO = 1.1f;

    @NotNull
    private static final String TAG = "SpenFavoriteItemDragManager";
    private static int mBoundingBoxMargin;
    private static boolean mIsLongPressDragEnabled;
    private static int mOffsetHorizontal;
    private static int mOffsetVertical;

    @NotNull
    private Context mContext;

    @Nullable
    private SpenFavoriteDragAdapter mFavoriteDragAdapter;

    @Nullable
    private OnItemDropListener mOnItemDropListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragManager$OnDraggingItemListener;", "", "onDraggingItem", "", "isDragging", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnDraggingItemListener {
        void onDraggingItem(boolean isDragging);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragManager$OnItemDropListener;", "", "OnItemDrop", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnItemDropListener {
        void OnItemDrop();
    }

    public SpenFavoriteItemDragManager(@NotNull Context mContext, @Nullable SpenFavoriteDragAdapter spenFavoriteDragAdapter) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.mFavoriteDragAdapter = spenFavoriteDragAdapter;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    @Nullable
    public RecyclerView.ViewHolder chooseDropTarget(@NotNull RecyclerView.ViewHolder selected, @NotNull List<? extends RecyclerView.ViewHolder> dropTargets, int curX, int curY) {
        int top;
        int iAbs;
        int bottom;
        int iAbs2;
        int right;
        int iAbs3;
        int left;
        int iAbs4;
        Intrinsics.checkNotNullParameter(selected, "selected");
        Intrinsics.checkNotNullParameter(dropTargets, "dropTargets");
        int width = selected.itemView.getWidth() + curX;
        int height = selected.itemView.getHeight() + curY;
        int left2 = curX - selected.itemView.getLeft();
        int top2 = curY - selected.itemView.getTop();
        int size = dropTargets.size();
        RecyclerView.ViewHolder viewHolder = null;
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView.ViewHolder viewHolder2 = dropTargets.get(i2);
            if (left2 > 0 && (left = viewHolder2.itemView.getLeft() - width) < (-selected.itemView.getWidth()) / 2 && viewHolder2.itemView.getRight() > selected.itemView.getRight() && (iAbs4 = Math.abs(left)) > i) {
                viewHolder = viewHolder2;
                i = iAbs4;
            }
            if (left2 < 0 && (right = viewHolder2.itemView.getRight() - curX) > selected.itemView.getWidth() / 2 && viewHolder2.itemView.getLeft() < selected.itemView.getLeft() && (iAbs3 = Math.abs(right)) > i) {
                viewHolder = viewHolder2;
                i = iAbs3;
            }
            if (top2 < 0 && (bottom = viewHolder2.itemView.getBottom() - curY) > selected.itemView.getHeight() / 2 && viewHolder2.itemView.getTop() < selected.itemView.getTop() && (iAbs2 = Math.abs(bottom)) > i) {
                viewHolder = viewHolder2;
                i = iAbs2;
            }
            if (top2 > 0 && (top = viewHolder2.itemView.getTop() - height) < (-selected.itemView.getHeight()) / 2 && viewHolder2.itemView.getBottom() > selected.itemView.getBottom() && (iAbs = Math.abs(top)) > i) {
                viewHolder = viewHolder2;
                i = iAbs;
            }
        }
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        setIsLongPressDragEnabled(false);
        View view = viewHolder.itemView;
        SpenSettingUtilHover.setHoverText(view, view.getTag().toString());
        super.clearView(recyclerView, viewHolder);
        viewHolder.itemView.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(5)).setListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteItemDragManager.clearView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                OnItemDropListener onItemDropListener = SpenFavoriteItemDragManager.this.mOnItemDropListener;
                if (onItemDropListener != null) {
                    onItemDropListener.OnItemDrop();
                }
                super.onAnimationEnd(animation);
            }
        }).start();
    }

    public final void close() {
        Log.i(TAG, "close()");
        this.mFavoriteDragAdapter = null;
        this.mOnItemDropListener = null;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public long getAnimationDuration(@NotNull RecyclerView recyclerView, int animationType, float animateDx, float animateDy) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        return 200L;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    /* JADX INFO: renamed from: getBoundingBoxMargin */
    public int getMBoundingBoxMargin() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        if (i > mBoundingBoxMargin) {
            mBoundingBoxMargin = i;
        }
        int i2 = displayMetrics.heightPixels;
        if (i2 > mBoundingBoxMargin) {
            mBoundingBoxMargin = i2;
        }
        return mBoundingBoxMargin;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getMoveThreshold(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (mOffsetVertical != 0 && mOffsetHorizontal != 0) {
            return 0.1f;
        }
        float f = 2;
        mOffsetHorizontal = (int) Math.ceil(((viewHolder.itemView.getWidth() * SCALE_UP_RATIO) - viewHolder.itemView.getWidth()) / f);
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        context.getResources().getDimensionPixelSize(C7932R.dimen.common_setting_bg_stroke);
        mOffsetVertical = (int) Math.ceil(((viewHolder.itemView.getHeight() * SCALE_UP_RATIO) - viewHolder.itemView.getHeight()) / f);
        Context context2 = this.mContext;
        Intrinsics.checkNotNull(context2);
        context2.getResources().getDimensionPixelSize(C7932R.dimen.common_setting_bg_stroke);
        return 0.1f;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return ((recyclerView.getLayoutManager() instanceof SpenFavoriteGridLayoutManager) && (viewHolder instanceof SpenFavoriteViewHolder) && viewHolder.itemView.getTag() != null) ? ItemTouchHelper.Callback.makeMovementFlags(15, 0) : ItemTouchHelper.Callback.makeMovementFlags(0, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return mIsLongPressDragEnabled;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(@NotNull Canvas c, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        float f;
        float f4;
        SpenFavoriteItemDragManager spenFavoriteItemDragManager;
        Canvas canvas;
        RecyclerView recyclerView2;
        RecyclerView.ViewHolder viewHolder2;
        int i;
        boolean z;
        int width;
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (viewHolder instanceof SpenFavoriteViewHolder) {
            if (recyclerView.getWidth() > recyclerView.getHeight()) {
                mBoundingBoxMargin = recyclerView.getWidth();
            } else {
                mBoundingBoxMargin = recyclerView.getHeight();
            }
            Log.i(TAG, "[onChildDraw] [Before cover] View located at X = " + (viewHolder.itemView.getLeft() + dX) + ", Y = " + (viewHolder.itemView.getTop() + dY));
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            int iFindFirstVisibleItemPosition = ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();
            RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            int iFindLastVisibleItemPosition = ((GridLayoutManager) layoutManager2).findLastVisibleItemPosition();
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            int itemCount = adapter != null ? adapter.getItemCount() : 0;
            int paddingTop = recyclerView.getPaddingTop();
            RecyclerView.LayoutManager layoutManager3 = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager3, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            int topDecorationHeight = ((GridLayoutManager) layoutManager3).getTopDecorationHeight(viewHolder.itemView) + paddingTop;
            int paddingBottom = recyclerView.getPaddingBottom();
            RecyclerView.LayoutManager layoutManager4 = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager4, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            int bottom = recyclerView.getChildAt(recyclerView.getChildCount() - 1).getBottom() + ((GridLayoutManager) layoutManager4).getBottomDecorationHeight(viewHolder.itemView) + paddingBottom;
            if (bottom < recyclerView.getHeight()) {
                bottom = recyclerView.getHeight();
            }
            float bottom2 = (iFindFirstVisibleItemPosition != 0 || ((float) viewHolder.itemView.getTop()) + dY >= ((float) (recyclerView.getChildAt(0).getTop() - topDecorationHeight))) ? (iFindLastVisibleItemPosition != itemCount + (-1) || ((float) viewHolder.itemView.getBottom()) + dY <= ((float) bottom)) ? dY : bottom - viewHolder.itemView.getBottom() : (recyclerView.getChildAt(0).getTop() - topDecorationHeight) - viewHolder.itemView.getTop();
            float left = viewHolder.itemView.getLeft() + dX;
            float width2 = viewHolder.itemView.getWidth() + left;
            if (left < mOffsetHorizontal) {
                width = (-viewHolder.itemView.getLeft()) + mOffsetHorizontal;
            } else if (width2 > recyclerView.getWidth() - mOffsetHorizontal) {
                width = ((recyclerView.getWidth() - viewHolder.itemView.getWidth()) - viewHolder.itemView.getLeft()) - mOffsetHorizontal;
            } else {
                f = dX;
                Log.i(TAG, "[onChildDraw] [After cover] View located at X = " + (viewHolder.itemView.getLeft() + f) + ", Y = " + (viewHolder.itemView.getTop() + bottom2));
                int left2 = recyclerView.getLeft();
                int top = recyclerView.getTop();
                int right = recyclerView.getRight();
                int bottom3 = recyclerView.getBottom();
                StringBuilder sbM1173s = AbstractC0622a.m1173s(left2, top, "[onChildDraw] Parent's rect  left = ", ", top = ", ", right = ");
                sbM1173s.append(right);
                sbM1173s.append(", bottom = ");
                sbM1173s.append(bottom3);
                Log.i(TAG, sbM1173s.toString());
                f4 = bottom2;
                spenFavoriteItemDragManager = this;
                recyclerView2 = recyclerView;
                viewHolder2 = viewHolder;
                i = actionState;
                z = isCurrentlyActive;
                canvas = c;
            }
            f = width;
            Log.i(TAG, "[onChildDraw] [After cover] View located at X = " + (viewHolder.itemView.getLeft() + f) + ", Y = " + (viewHolder.itemView.getTop() + bottom2));
            int left22 = recyclerView.getLeft();
            int top2 = recyclerView.getTop();
            int right2 = recyclerView.getRight();
            int bottom32 = recyclerView.getBottom();
            StringBuilder sbM1173s2 = AbstractC0622a.m1173s(left22, top2, "[onChildDraw] Parent's rect  left = ", ", top = ", ", right = ");
            sbM1173s2.append(right2);
            sbM1173s2.append(", bottom = ");
            sbM1173s2.append(bottom32);
            Log.i(TAG, sbM1173s2.toString());
            f4 = bottom2;
            spenFavoriteItemDragManager = this;
            recyclerView2 = recyclerView;
            viewHolder2 = viewHolder;
            i = actionState;
            z = isCurrentlyActive;
            canvas = c;
        } else {
            f = dX;
            f4 = dY;
            spenFavoriteItemDragManager = this;
            canvas = c;
            recyclerView2 = recyclerView;
            viewHolder2 = viewHolder;
            i = actionState;
            z = isCurrentlyActive;
        }
        super.onChildDraw(canvas, recyclerView2, viewHolder2, f, f4, i, z);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder sourceView, @NotNull RecyclerView.ViewHolder targetView) {
        SpenFavoriteDragAdapter spenFavoriteDragAdapter;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(sourceView, "sourceView");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        if (sourceView.getItemViewType() != targetView.getItemViewType()) {
            return false;
        }
        SpenSettingUtilHover.setHoverText(sourceView.itemView, null);
        int adapterPosition = sourceView.getAdapterPosition();
        int adapterPosition2 = targetView.getAdapterPosition();
        if ((targetView instanceof SpenFavoriteViewHolder) && targetView.itemView.getTag() == null) {
            SpenFavoriteDragAdapter spenFavoriteDragAdapter2 = this.mFavoriteDragAdapter;
            Intrinsics.checkNotNull(spenFavoriteDragAdapter2, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenAdapter");
            adapterPosition2 = ((SpenFavoritePenAdapter) spenFavoriteDragAdapter2).getPenCount() - 1;
            SpenFavoriteDragAdapter spenFavoriteDragAdapter3 = this.mFavoriteDragAdapter;
            Intrinsics.checkNotNull(spenFavoriteDragAdapter3, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenAdapter");
            if (adapterPosition2 > ((SpenFavoritePenAdapter) spenFavoriteDragAdapter3).getItemCount()) {
                SpenFavoriteDragAdapter spenFavoriteDragAdapter4 = this.mFavoriteDragAdapter;
                Intrinsics.checkNotNull(spenFavoriteDragAdapter4, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenAdapter");
                adapterPosition2 = ((SpenFavoritePenAdapter) spenFavoriteDragAdapter4).getItemCount();
            }
        }
        if (adapterPosition != adapterPosition2 && (spenFavoriteDragAdapter = this.mFavoriteDragAdapter) != null) {
            spenFavoriteDragAdapter.onItemMove(adapterPosition, adapterPosition2);
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(@NotNull RecyclerView.ViewHolder viewHolder, int direction) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
    }

    public final void setIsLongPressDragEnabled(boolean isLongPressDragEnabled) {
        mIsLongPressDragEnabled = isLongPressDragEnabled;
    }

    public final void setOnItemDropListener(@Nullable OnItemDropListener listener) {
        this.mOnItemDropListener = listener;
    }
}
