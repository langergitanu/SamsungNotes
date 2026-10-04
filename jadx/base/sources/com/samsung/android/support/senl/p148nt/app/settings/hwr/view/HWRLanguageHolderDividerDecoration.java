package com.samsung.android.support.senl.p148nt.app.settings.hwr.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.util.SeslRoundedCorner;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/hwr/view/HWRLanguageHolderDividerDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mDivider", "Landroid/graphics/drawable/Drawable;", "mRoundedCorner", "Landroidx/appcompat/util/SeslRoundedCorner;", "seslOnDispatchDraw", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class HWRLanguageHolderDividerDecoration extends RecyclerView.ItemDecoration {

    @Nullable
    private final Drawable mDivider;

    @NotNull
    private final SeslRoundedCorner mRoundedCorner;

    public HWRLanguageHolderDividerDecoration(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDivider = ResourcesCompat.getDrawable(context.getResources(), C8003R.drawable.settings_recyclerview_divider_bg, null);
        this.mRoundedCorner = new SeslRoundedCorner(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c6  */
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void seslOnDispatchDraw(@NotNull Canvas c, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        RecyclerView.ViewHolder viewHolderFindContainingViewHolder;
        int itemViewType;
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.seslOnDispatchDraw(c, parent, state);
        int childCount = parent.getChildCount();
        int dimension = (int) parent.getResources().getDimension(C8003R.dimen.hwr_language_recyclerview_divider_padding_start_end);
        int dimension2 = (int) parent.getResources().getDimension(C8003R.dimen.hwr_language_recyclerview_divider_padding_start_end);
        int width = parent.getWidth() - dimension;
        for (int i = -1; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            if (childAt != null && (viewHolderFindContainingViewHolder = parent.findContainingViewHolder(childAt)) != null) {
                View childAt2 = parent.getChildAt(i - 1);
                View childAt3 = parent.getChildAt(i + 1);
                int itemViewType2 = viewHolderFindContainingViewHolder.getItemViewType();
                if (itemViewType2 != -1) {
                    if (itemViewType2 == 0 || itemViewType2 == 1 || itemViewType2 == 2) {
                        if (childAt2 != null) {
                            this.mRoundedCorner.setRoundedCorners(12);
                            this.mRoundedCorner.drawRoundedCorner(childAt2, c);
                        }
                        if (childAt3 != null) {
                            this.mRoundedCorner.setRoundedCorners(3);
                            this.mRoundedCorner.drawRoundedCorner(childAt3, c);
                        }
                    } else if (itemViewType2 == 4) {
                        this.mRoundedCorner.setRoundedCorners(0);
                        this.mRoundedCorner.drawRoundedCorner(childAt, c);
                        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                        layoutParams.height = (int) childAt.getResources().getDimension(C8003R.dimen.noteslist_recycler_padding_bottom);
                        childAt.setLayoutParams(layoutParams);
                    } else if (itemViewType2 != 5) {
                        if (itemViewType2 != 7) {
                            if (childAt3 != null) {
                                RecyclerView.ViewHolder viewHolderFindContainingViewHolder2 = parent.findContainingViewHolder(childAt3);
                                itemViewType = viewHolderFindContainingViewHolder2 != null ? viewHolderFindContainingViewHolder2.getItemViewType() : 7;
                            } else {
                                itemViewType = 4;
                            }
                            if (itemViewType == 4 || itemViewType == 5 || itemViewType == 7) {
                                this.mRoundedCorner.setRoundedCorners(12);
                                this.mRoundedCorner.drawRoundedCorner(childAt, c);
                            } else if (this.mDivider != null) {
                                int bottom = childAt.getBottom();
                                this.mDivider.setBounds(dimension2, bottom, width, this.mDivider.getIntrinsicHeight() + bottom);
                                this.mDivider.draw(c);
                            }
                        }
                    }
                }
            }
        }
    }
}
