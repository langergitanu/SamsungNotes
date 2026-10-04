package com.samsung.android.sdk.pen.setting.favoritepen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ \u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mDivider", "Landroid/graphics/drawable/Drawable;", "close", "", "setColor", "color", "", "onDraw", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenFavoriteItemDecoration extends RecyclerView.ItemDecoration {

    @NotNull
    private static final String TAG = "SpenFavoriteItemDecoration";

    @NotNull
    private Drawable mDivider;

    public SpenFavoriteItemDecoration(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDivider = context.getResources().getDrawable(C7932R.drawable.setting_favorite_line_divider);
    }

    public final void close() {
        Log.i(TAG, "close()");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NotNull Canvas c, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        if (!(parent.getLayoutManager() instanceof GridLayoutManager)) {
            super.onDraw(c, parent, state);
            return;
        }
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        int spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i % spanCount == 0) {
                View childAt = parent.getChildAt(i);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) layoutParams)).bottomMargin;
                this.mDivider.setBounds(0, bottom, parent.getWidth(), this.mDivider.getIntrinsicHeight() + bottom);
                this.mDivider.draw(c);
            }
        }
    }

    public final void setColor(int color) {
        AbstractC2322a.m1631u(color, "setColor() color=", TAG);
        this.mDivider.setColorFilter(color, PorterDuff.Mode.SRC_IN);
    }
}
