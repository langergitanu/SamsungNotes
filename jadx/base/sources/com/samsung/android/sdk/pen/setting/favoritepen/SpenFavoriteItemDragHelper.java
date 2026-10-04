package com.samsung.android.sdk.pen.setting.favoritepen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.common.SpenLayoutConfigHelper;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u000e\b\u0001\u0018\u0000 =2\u00020\u0001:\u0005=>?@AB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0015\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\tJ\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\tJ\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J \u0010 \u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0016J\u0018\u0010#\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\tH\u0016J\b\u0010%\u001a\u00020\u000bH\u0016J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J@\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u000bH\u0016J\u001a\u0010/\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010-\u001a\u00020\tH\u0016J\b\u00100\u001a\u00020\tH\u0016J0\u00101\u001a\u0004\u0018\u00010\u001f2\u0006\u00102\u001a\u00020\u001f2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001f042\u0006\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\tH\u0016J \u00107\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020\u001fH\u0016J\u001a\u0010:\u001a\u00020\u00112\b\u0010;\u001a\u0004\u0018\u00010\u001f2\u0006\u0010<\u001a\u00020\u000bH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00060\u000eR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragHelper;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragHelper$OnItemMoveListener;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragHelper$OnItemMoveListener;)V", "mBoundingBoxMargin", "", "mIsRequestedStop", "", "mContext", "mReorderHelper", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragHelper$ReorderHelper;", "mItemMoveListener", "close", "", "setOnItemDropListener", "dropListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragHelper$OnItemDropListener;", "setOnPenMiniDragListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/OnFavoritePenMiniViewDragListener;", "setToolType", "toolType", "setOrientation", "orientation", "getMovementFlags", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onMove", "sourceView", "targetView", "onSwiped", "direction", "isLongPressDragEnabled", "clearView", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "", "dY", "actionState", "isCurrentlyActive", "onSelectedChanged", "getBoundingBoxMargin", "chooseDropTarget", "selected", "dropTargets", "", "curX", "curY", "canDropOver", "current", "target", "setItemScaleAnimation", "holder", "isEntryDragItem", "Companion", "OnItemMoveListener", "OnItemDropListener", "ReorderHelper", "OutsideReorderHelper", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public final class SpenFavoriteItemDragHelper extends ItemTouchHelper.Callback {
    private static final int SCALE_ANIMATION_DURATION = 200;
    private static final float SCALE_UP_ALPHA = 0.6f;
    private static final float SCALE_UP_RATIO = 1.1f;

    @NotNull
    private static final String TAG = "SpenFavoriteItemDragHelper";
    private int mBoundingBoxMargin;

    @NotNull
    private Context mContext;
    private boolean mIsRequestedStop;

    @Nullable
    private OnItemMoveListener mItemMoveListener;

    @NotNull
    private ReorderHelper mReorderHelper;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragHelper$OnItemDropListener;", "", "onItemDrop", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnItemDropListener {
        void onItemDrop(@Nullable RecyclerView.ViewHolder viewHolder);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragHelper$OnItemMoveListener;", "", "onItemMove", "", "fromPosition", "", "toPosition", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnItemMoveListener {
        boolean onItemMove(int fromPosition, int toPosition);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\u0010\u0007\u001a\u00060\u0001R\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J(\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010(\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J(\u0010)\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000f¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragHelper$OutsideReorderHelper;", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragHelper$ReorderHelper;", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragHelper;", "context", "Landroid/content/Context;", "mPenMiniViewDragListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/OnFavoritePenMiniViewDragListener;", "prevHelper", "<init>", "(Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragHelper;Landroid/content/Context;Lcom/samsung/android/sdk/pen/setting/favoritepen/OnFavoritePenMiniViewDragListener;Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragHelper$ReorderHelper;)V", "mReorderOutsideOffsetY", "", "value", "toolType", "getToolType", "()I", "setToolType", "(I)V", "dragFlags", "getDragFlags", "clearView", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "startDrag", "itemView", "Landroid/view/View;", "endDrag", "adjustCurrentPositionForDropTarget", "Landroid/graphics/Point;", "curX", "curY", "updateChildDraw", "Landroid/graphics/PointF;", "childView", "parentView", "Landroidx/recyclerview/widget/RecyclerView;", "dX", "", "dY", "getOutsideReorderOffset", "notifyUpdatePosition", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class OutsideReorderHelper extends ReorderHelper {

        @NotNull
        private final OnFavoritePenMiniViewDragListener mPenMiniViewDragListener;
        private int mReorderOutsideOffsetY;
        final /* synthetic */ SpenFavoriteItemDragHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OutsideReorderHelper(@NotNull SpenFavoriteItemDragHelper spenFavoriteItemDragHelper, @NotNull Context context, @NotNull OnFavoritePenMiniViewDragListener mPenMiniViewDragListener, ReorderHelper prevHelper) {
            super(spenFavoriteItemDragHelper, context, prevHelper);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(mPenMiniViewDragListener, "mPenMiniViewDragListener");
            Intrinsics.checkNotNullParameter(prevHelper, "prevHelper");
            this.this$0 = spenFavoriteItemDragHelper;
            this.mPenMiniViewDragListener = mPenMiniViewDragListener;
            this.mReorderOutsideOffsetY = getItemOffsetValue();
        }

        private final int getOutsideReorderOffset(int toolType) {
            if (toolType != 1) {
                return 0;
            }
            return getItemOffsetValue();
        }

        private final void notifyUpdatePosition(View childView, View parentView, float dX, float dY) {
            int i;
            int height;
            int width;
            int height2;
            boolean z = getToolType() == 1;
            int itemOffsetValue = getItemOffsetValue();
            PointF pointF = new PointF(dX, dY);
            if (isVertical()) {
                height2 = z ? itemOffsetValue : itemOffsetValue * 2;
                i = z ? itemOffsetValue : 0;
                width = childView.getWidth() / 2;
                height = width;
            } else {
                if (isLTR()) {
                    width = z ? itemOffsetValue : itemOffsetValue * 2;
                    height = z ? itemOffsetValue : 0;
                } else {
                    i = z ? itemOffsetValue : 0;
                    height = z ? itemOffsetValue * 2 : childView.getHeight();
                    width = i;
                }
                height2 = childView.getHeight() / 2;
                i = height2;
            }
            float fAdjustMinDisplacement = adjustMinDisplacement(pointF.x, childView.getLeft(), -width);
            pointF.x = fAdjustMinDisplacement;
            pointF.x = adjustMaxDisplacement(fAdjustMinDisplacement, childView.getRight(), height, parentView.getWidth());
            float fAdjustMinDisplacement2 = adjustMinDisplacement(pointF.y, childView.getTop(), -height2);
            pointF.y = fAdjustMinDisplacement2;
            pointF.y = adjustMaxDisplacement(fAdjustMinDisplacement2, childView.getBottom(), i, parentView.getHeight());
            this.mPenMiniViewDragListener.onUpdatePosition(childView.getLeft() + ((int) pointF.x), childView.getTop() + ((int) pointF.y));
        }

        @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteItemDragHelper.ReorderHelper
        @NotNull
        public Point adjustCurrentPositionForDropTarget(int curX, int curY) {
            return new Point(curX, curY - this.mReorderOutsideOffsetY);
        }

        @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteItemDragHelper.ReorderHelper
        public void clearView(@NotNull RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            viewHolder.itemView.setAlpha(1.0f);
            this.mPenMiniViewDragListener.onDropped();
            super.clearView(viewHolder);
        }

        @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteItemDragHelper.ReorderHelper
        public void endDrag(@NotNull View itemView) {
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.mPenMiniViewDragListener.onDropToPosition(itemView.getLeft(), itemView.getTop());
        }

        @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteItemDragHelper.ReorderHelper
        public int getDragFlags() {
            return super.getDragFlags() | (isVertical() ? 12 : 3);
        }

        @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteItemDragHelper.ReorderHelper
        public int getToolType() {
            return super.getToolType();
        }

        @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteItemDragHelper.ReorderHelper
        public void setToolType(int i) {
            boolean z = getToolType() != i;
            super.setToolType(getToolType());
            if (z) {
                this.mReorderOutsideOffsetY = getOutsideReorderOffset(getToolType());
            }
        }

        @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteItemDragHelper.ReorderHelper
        public void startDrag(@NotNull View itemView) {
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            itemView.setAlpha(0.0f);
            this.mPenMiniViewDragListener.onUpdatePosition(itemView.getLeft(), itemView.getTop());
            View viewFindViewById = itemView.findViewById(C7932R.id.favorite_pen_item);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMiniView");
            SpenFavoritePenMiniView spenFavoritePenMiniView = (SpenFavoritePenMiniView) viewFindViewById;
            SpenSettingUIPenInfo spenSettingUIPenInfo = new SpenSettingUIPenInfo();
            String penName = spenFavoritePenMiniView.getPenName();
            if (penName != null) {
                spenSettingUIPenInfo.name = penName;
            }
            spenSettingUIPenInfo.color = spenFavoritePenMiniView.getMColor();
            spenSettingUIPenInfo.sizeLevel = spenFavoritePenMiniView.getMSizeLevel();
            this.mPenMiniViewDragListener.onStartDrag(spenSettingUIPenInfo, this.mReorderOutsideOffsetY, spenFavoritePenMiniView.isSelected());
        }

        @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteItemDragHelper.ReorderHelper
        @NotNull
        public PointF updateChildDraw(@NotNull View childView, @NotNull RecyclerView parentView, float dX, float dY) {
            Intrinsics.checkNotNullParameter(childView, "childView");
            Intrinsics.checkNotNullParameter(parentView, "parentView");
            if (!getIsDragStopped()) {
                notifyUpdatePosition(childView, parentView, dX, dY);
            }
            return new PointF(dX, dY);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\b\u0092\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0018\u00010\u0000R\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u0013J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\tH\u0016J(\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000202H\u0016J\u001e\u00104\u001a\u0002022\u0006\u00105\u001a\u0002022\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\tJ&\u00108\u001a\u0002022\u0006\u00105\u001a\u0002022\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u00020\tR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0016@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\r¨\u0006<"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragHelper$ReorderHelper;", "Lcom/samsung/android/sdk/pen/setting/common/SpenLayoutConfigHelper;", "context", "Landroid/content/Context;", "helper", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragHelper;", "<init>", "(Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragHelper;Landroid/content/Context;Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragHelper$ReorderHelper;)V", "mNormalOffsetY", "", "mVerticalFirstItemOffsetY", "itemOffsetValue", "getItemOffsetValue", "()I", "toolType", "getToolType", "setToolType", "(I)V", "value", "", "isDragStopped", "()Z", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragHelper$OnItemDropListener;", "itemDropperListener", "getItemDropperListener", "()Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragHelper$OnItemDropListener;", "dragFlags", "getDragFlags", "clearView", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "setItemDropListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "requestDragStop", "stopped", "startDrag", "itemView", "Landroid/view/View;", "endDrag", "adjustCurrentPositionForDropTarget", "Landroid/graphics/Point;", "curX", "curY", "updateChildDraw", "Landroid/graphics/PointF;", "childView", "parentView", "Landroidx/recyclerview/widget/RecyclerView;", "dX", "", "dY", "adjustMinDisplacement", "displacement", "itemMinPosition", "minOffset", "adjustMaxDisplacement", "itemMaxPosition", "maxOffset", "parentLength", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public class ReorderHelper extends SpenLayoutConfigHelper {
        private boolean isDragStopped;

        @Nullable
        private OnItemDropListener itemDropperListener;
        private final int itemOffsetValue;
        private final int mNormalOffsetY;
        private final int mVerticalFirstItemOffsetY;
        final /* synthetic */ SpenFavoriteItemDragHelper this$0;
        private int toolType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReorderHelper(@NotNull SpenFavoriteItemDragHelper spenFavoriteItemDragHelper, @Nullable Context context, ReorderHelper reorderHelper) {
            super(context, reorderHelper != null ? reorderHelper.getMOrientation() : 1);
            Intrinsics.checkNotNullParameter(context, "context");
            this.this$0 = spenFavoriteItemDragHelper;
            this.itemOffsetValue = context.getResources().getDimensionPixelSize(C7932R.dimen.mini_favorite_pen_view_reorder_outside_offset_y);
            this.toolType = 1;
            float dimensionPixelSize = context.getResources().getDimensionPixelSize(C7932R.dimen.mini_favorite_pen_view_height);
            int i = ((int) ((SpenFavoriteItemDragHelper.SCALE_UP_RATIO * dimensionPixelSize) - dimensionPixelSize)) / 2;
            this.mNormalOffsetY = i;
            this.mVerticalFirstItemOffsetY = context.getResources().getDimensionPixelSize(C7932R.dimen.mini_favorite_setting_first_item_margin) + i;
            if (reorderHelper != null) {
                setItemDropListener(reorderHelper.itemDropperListener);
                spenFavoriteItemDragHelper.setToolType(reorderHelper.getToolType());
            }
        }

        @NotNull
        public Point adjustCurrentPositionForDropTarget(int curX, int curY) {
            return new Point(curX, curY);
        }

        public final float adjustMaxDisplacement(float displacement, int itemMaxPosition, int maxOffset, int parentLength) {
            return ((float) itemMaxPosition) + displacement > ((float) (parentLength + maxOffset)) ? (parentLength - itemMaxPosition) + maxOffset : displacement;
        }

        public final float adjustMinDisplacement(float displacement, int itemMinPosition, int minOffset) {
            return ((float) itemMinPosition) + displacement < ((float) minOffset) ? (-itemMinPosition) + minOffset : displacement;
        }

        public void clearView(@NotNull RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            OnItemDropListener onItemDropListener = this.itemDropperListener;
            if (onItemDropListener != null) {
                onItemDropListener.onItemDrop(viewHolder);
            }
        }

        public void endDrag(@NotNull View itemView) {
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            itemView.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(5)).start();
        }

        public int getDragFlags() {
            return isVertical() ? 3 : 12;
        }

        @Nullable
        public final OnItemDropListener getItemDropperListener() {
            return this.itemDropperListener;
        }

        public int getItemOffsetValue() {
            return this.itemOffsetValue;
        }

        public int getToolType() {
            return this.toolType;
        }

        /* JADX INFO: renamed from: isDragStopped, reason: from getter */
        public final boolean getIsDragStopped() {
            return this.isDragStopped;
        }

        public final void requestDragStop(boolean stopped) {
            this.isDragStopped = stopped;
        }

        public final void setItemDropListener(@Nullable OnItemDropListener listener) {
            this.itemDropperListener = listener;
        }

        public void setToolType(int i) {
            this.toolType = i;
        }

        public void startDrag(@NotNull View itemView) {
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            itemView.animate().scaleX(SpenFavoriteItemDragHelper.SCALE_UP_RATIO).scaleY(SpenFavoriteItemDragHelper.SCALE_UP_RATIO).alpha(0.6f).setDuration(200L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(5)).start();
        }

        @NotNull
        public PointF updateChildDraw(@NotNull View childView, @NotNull RecyclerView parentView, float dX, float dY) {
            Intrinsics.checkNotNullParameter(childView, "childView");
            Intrinsics.checkNotNullParameter(parentView, "parentView");
            int childAdapterPosition = parentView.getChildAdapterPosition(childView);
            PointF pointF = new PointF(dX, dY);
            if (isVertical()) {
                float fAdjustMinDisplacement = adjustMinDisplacement(pointF.y, childView.getTop(), childAdapterPosition == 0 ? this.mVerticalFirstItemOffsetY : this.mNormalOffsetY);
                pointF.y = fAdjustMinDisplacement;
                pointF.y = adjustMaxDisplacement(fAdjustMinDisplacement, childView.getBottom(), 0, parentView.getHeight());
                return pointF;
            }
            float fAdjustMinDisplacement2 = adjustMinDisplacement(pointF.x, childView.getLeft(), this.mNormalOffsetY);
            pointF.x = fAdjustMinDisplacement2;
            pointF.x = adjustMaxDisplacement(fAdjustMinDisplacement2, childView.getRight(), 0, parentView.getWidth());
            return pointF;
        }
    }

    public SpenFavoriteItemDragHelper(@NotNull Context context, @Nullable OnItemMoveListener onItemMoveListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        this.mItemMoveListener = onItemMoveListener;
        this.mReorderHelper = new ReorderHelper(this, context, null);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        this.mBoundingBoxMargin = i <= i2 ? i2 : i;
    }

    private final void setItemScaleAnimation(RecyclerView.ViewHolder holder, boolean isEntryDragItem) {
        if (holder == null) {
            return;
        }
        this.mReorderHelper.requestDragStop(this.mIsRequestedStop);
        if (isEntryDragItem) {
            ReorderHelper reorderHelper = this.mReorderHelper;
            View itemView = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            reorderHelper.startDrag(itemView);
            return;
        }
        ReorderHelper reorderHelper2 = this.mReorderHelper;
        View itemView2 = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
        reorderHelper2.endDrag(itemView2);
        this.mIsRequestedStop = false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean canDropOver(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder current, @NotNull RecyclerView.ViewHolder target) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(current, "current");
        Intrinsics.checkNotNullParameter(target, "target");
        boolean zCanDropOver = super.canDropOver(recyclerView, current, target);
        int adapterPosition = target.getAdapterPosition();
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        if (adapterPosition < ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition()) {
            return false;
        }
        int adapterPosition2 = target.getAdapterPosition();
        RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        if (adapterPosition2 > ((LinearLayoutManager) layoutManager2).findLastCompletelyVisibleItemPosition()) {
            return false;
        }
        return zCanDropOver;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    @Nullable
    public RecyclerView.ViewHolder chooseDropTarget(@NotNull RecyclerView.ViewHolder selected, @NotNull List<? extends RecyclerView.ViewHolder> dropTargets, int curX, int curY) {
        Intrinsics.checkNotNullParameter(selected, "selected");
        Intrinsics.checkNotNullParameter(dropTargets, "dropTargets");
        Point pointAdjustCurrentPositionForDropTarget = this.mReorderHelper.adjustCurrentPositionForDropTarget(curX, curY);
        return super.chooseDropTarget(selected, dropTargets, pointAdjustCurrentPositionForDropTarget.x, pointAdjustCurrentPositionForDropTarget.y);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        super.clearView(recyclerView, viewHolder);
        Log.i(TAG, "clearView()");
        View view = viewHolder.itemView;
        SpenSettingUtilHover.setHoverText(view, view.getTag().toString());
        this.mReorderHelper.clearView(viewHolder);
    }

    public final void close() {
        this.mItemMoveListener = null;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    /* JADX INFO: renamed from: getBoundingBoxMargin, reason: from getter */
    public int getMBoundingBoxMargin() {
        return this.mBoundingBoxMargin;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return ItemTouchHelper.Callback.makeMovementFlags(this.mReorderHelper.getDragFlags(), 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(@NotNull Canvas c, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (this.mIsRequestedStop) {
            setItemScaleAnimation(viewHolder, false);
        }
        ReorderHelper reorderHelper = this.mReorderHelper;
        View itemView = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        PointF pointFUpdateChildDraw = reorderHelper.updateChildDraw(itemView, recyclerView, dX, dY);
        super.onChildDraw(c, recyclerView, viewHolder, pointFUpdateChildDraw.x, pointFUpdateChildDraw.y, actionState, isCurrentlyActive);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder sourceView, @NotNull RecyclerView.ViewHolder targetView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(sourceView, "sourceView");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        if (sourceView.getItemViewType() != targetView.getItemViewType()) {
            return false;
        }
        SpenSettingUtilHover.setHoverText(sourceView.itemView, null);
        OnItemMoveListener onItemMoveListener = this.mItemMoveListener;
        if (onItemMoveListener == null) {
            return true;
        }
        onItemMoveListener.onItemMove(sourceView.getAdapterPosition(), targetView.getAdapterPosition());
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        if (actionState != 2) {
            this.mIsRequestedStop = true;
        } else {
            this.mIsRequestedStop = false;
            setItemScaleAnimation(viewHolder, true);
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(@NotNull RecyclerView.ViewHolder viewHolder, int direction) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
    }

    public final void setOnItemDropListener(@Nullable OnItemDropListener dropListener) {
        this.mReorderHelper.setItemDropListener(dropListener);
    }

    public final void setOnPenMiniDragListener(@Nullable OnFavoritePenMiniViewDragListener listener) {
        Log.i(TAG, "setOnPenMiniDragListener()");
        this.mReorderHelper = listener != null ? new OutsideReorderHelper(this, this.mContext, listener, this.mReorderHelper) : new ReorderHelper(this, this.mContext, this.mReorderHelper);
    }

    public final void setOrientation(int orientation) {
        AbstractC11014a.m12328m(orientation, "setOrientation(", ")", TAG);
        this.mReorderHelper.setOrientation(orientation);
    }

    public final void setToolType(int toolType) {
        this.mReorderHelper.setToolType(toolType);
    }
}
