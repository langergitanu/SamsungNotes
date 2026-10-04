package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.ViewOnHoverListenerC7469a;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTPenListAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 <2\u00020\u0001:\u0004<=>?B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010!\u001a\u00020\"J\u0014\u0010#\u001a\u00020\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u001e\u0010%\u001a\u00020\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010&\u001a\u00020\bJ\u0010\u0010'\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010\u0014J\u0016\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\bJ\u000e\u0010,\u001a\u00020\"2\u0006\u0010,\u001a\u00020\bJ\u0016\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\bJ\u001e\u0010/\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\b\u00100\u001a\u00020\"H\u0002J\u0018\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u0016H\u0002J(\u00104\u001a\u00020\"2\u0006\u00105\u001a\u00020\u00162\u0006\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u0016H\u0014J\u0010\u00109\u001a\u00020\"2\u0006\u0010:\u001a\u00020;H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPenListDockingLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "penInfoList", "", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTPenViewInfo;", "isFavorite", "", WiggleAnimationConfig.KEY_SCALE, "", "<init>", "(Landroid/content/Context;Ljava/util/List;ZF)V", "mPenList", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTRecyclerView;", "mPenListAdapter", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTPenListAdapter;", "mPenListLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mItemClickListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPenListDockingLayout$OnItemClickListener;", "mItemOffset", "", "mBottomFadeHeight", "mSideFadeHeight", "mBottomShader", "Landroid/graphics/LinearGradient;", "mLeftShader", "mRightShader", "mPaint", "Landroid/graphics/Paint;", "mSmoothScroller", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "close", "", "setPenInfoList", "penList", "notifyItemChange", "updatePenList", "setOnItemClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "selectPen", "index", "animation", "enableScroll", "setVisibility", "visibility", "initView", "updatePenPosition", "smoothScrollToPositionWithOffset", "position", TypedValues.Cycle.S_WAVE_OFFSET, "onSizeChanged", "w", "h", "oldw", "oldh", "draw", "canvas", "Landroid/graphics/Canvas;", "Companion", "OnItemClickListener", "OffsetSnapHelper", "OffsetSmoothScroller", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
@SourceDebugExtension({"SMAP\nSettingQTPenListDockingLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingQTPenListDockingLayout.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPenListDockingLayout\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,272:1\n255#2:273\n*S KotlinDebug\n*F\n+ 1 SettingQTPenListDockingLayout.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPenListDockingLayout\n*L\n113#1:273\n*E\n"})
public final class SettingQTPenListDockingLayout extends ConstraintLayout {
    private static final int PEN_ITEM_SELECT_ANIMATION_DURATION = 350;

    @NotNull
    private static final String TAG = "SpenSettingQTPenListLayout";
    private final boolean isFavorite;
    private float mBottomFadeHeight;

    @Nullable
    private LinearGradient mBottomShader;

    @Nullable
    private OnItemClickListener mItemClickListener;
    private int mItemOffset;

    @Nullable
    private LinearGradient mLeftShader;

    @NotNull
    private Paint mPaint;
    private QTRecyclerView mPenList;
    private QTPenListAdapter mPenListAdapter;
    private LinearLayoutManager mPenListLayoutManager;

    @Nullable
    private LinearGradient mRightShader;
    private float mSideFadeHeight;

    @Nullable
    private LinearSmoothScroller mSmoothScroller;
    private final float scale;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPenListDockingLayout$OffsetSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", TypedValues.Cycle.S_WAVE_OFFSET, "", "<init>", "(Landroid/content/Context;I)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "calculateDxToMakeVisible", "view", "Landroid/view/View;", "snapPreference", "onTargetFound", "", "targetView", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "action", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller$Action;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class OffsetSmoothScroller extends LinearSmoothScroller {

        @NotNull
        private Context context;
        private int offset;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OffsetSmoothScroller(@NotNull Context context, int i) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.offset = i;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDxToMakeVisible(@NotNull View view, int snapPreference) {
            Intrinsics.checkNotNullParameter(view, "view");
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager == null) {
                return 0;
            }
            return (((view.getRight() + view.getLeft()) / 2) - (layoutManager.getWidth() / 2)) - this.offset;
        }

        @NotNull
        public final Context getContext() {
            return this.context;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onTargetFound(@NotNull View targetView, @NotNull RecyclerView.State state, @NotNull RecyclerView.SmoothScroller.Action action) {
            Intrinsics.checkNotNullParameter(targetView, "targetView");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(action, "action");
            int iCalculateDxToMakeVisible = calculateDxToMakeVisible(targetView, -1);
            if (iCalculateDxToMakeVisible != 0) {
                action.update(iCalculateDxToMakeVisible, 0, SettingQTPenListDockingLayout.PEN_ITEM_SELECT_ANIMATION_DURATION, SpenSettingUtilAnimation.getInterpolator(20));
            }
        }

        public final void setContext(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            this.context = context;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPenListDockingLayout$OffsetSnapHelper;", "Landroidx/recyclerview/widget/LinearSnapHelper;", TypedValues.Cycle.S_WAVE_OFFSET, "", "<init>", "(I)V", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class OffsetSnapHelper extends LinearSnapHelper {
        private final int offset;

        public OffsetSnapHelper(int i) {
            this.offset = i;
        }

        @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
        @Nullable
        public int[] calculateDistanceToFinalSnap(@NotNull RecyclerView.LayoutManager layoutManager, @NotNull View targetView) {
            Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
            Intrinsics.checkNotNullParameter(targetView, "targetView");
            int[] iArrCalculateDistanceToFinalSnap = super.calculateDistanceToFinalSnap(layoutManager, targetView);
            if (iArrCalculateDistanceToFinalSnap == null) {
                return null;
            }
            if (layoutManager.canScrollVertically()) {
                iArrCalculateDistanceToFinalSnap[1] = iArrCalculateDistanceToFinalSnap[1] - this.offset;
            }
            if (layoutManager.canScrollHorizontally()) {
                iArrCalculateDistanceToFinalSnap[0] = iArrCalculateDistanceToFinalSnap[0] - this.offset;
            }
            return iArrCalculateDistanceToFinalSnap;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPenListDockingLayout$OnItemClickListener;", "", "onItemClicked", "", "position", "", "selected", "", "onAddFavoriteClicked", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnItemClickListener {
        void onAddFavoriteClicked();

        void onItemClicked(int position, boolean selected);
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenListDockingLayout$initView$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, m13886d2 = {"com/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPenListDockingLayout$initView$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class C107762 extends RecyclerView.OnScrollListener {
        public C107762() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            QTRecyclerView qTRecyclerView = SettingQTPenListDockingLayout.this.mPenList;
            if (qTRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenList");
                qTRecyclerView = null;
            }
            qTRecyclerView.post(new RunnableC10783e(SettingQTPenListDockingLayout.this, 1));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingQTPenListDockingLayout(@NotNull Context context, @NotNull List<QTPenViewInfo> penInfoList, boolean z, float f) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(penInfoList, "penInfoList");
        this.isFavorite = z;
        this.scale = f;
        this.mItemOffset = (int) (ResourceUtils.convertDpToPixel(context, 34.0f) / 2);
        this.mPaint = new Paint();
        initView(context, penInfoList);
    }

    public static final /* synthetic */ void access$updatePenPosition(SettingQTPenListDockingLayout settingQTPenListDockingLayout) {
        settingQTPenListDockingLayout.updatePenPosition();
    }

    private final void initView(Context context, List<QTPenViewInfo> penInfoList) {
        LayoutInflater.from(context).inflate(C9086R.layout.qt_pen_list_docking, (ViewGroup) this, true);
        View viewFindViewById = findViewById(C9086R.id.pen_list_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        RelativeLayout relativeLayout = (RelativeLayout) viewFindViewById;
        View viewFindViewById2 = findViewById(C9086R.id.pen_list_recycler_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        QTRecyclerView qTRecyclerView = (QTRecyclerView) viewFindViewById2;
        if (this.isFavorite) {
            relativeLayout.getLayoutParams().width = getResources().getDimensionPixelSize(C9086R.dimen.qt_docking_pen_list_favorite);
            qTRecyclerView.setPaddingRelative(getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_pen_list_padding_favorite), 0, getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_pen_list_padding_favorite), 0);
        } else {
            relativeLayout.getLayoutParams().width = getResources().getDimensionPixelSize(C9086R.dimen.qt_circle_pen_list_width);
            qTRecyclerView.setPaddingRelative(getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_pen_list_padding), 0, getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_pen_list_padding), 0);
        }
        QTRecyclerView qTRecyclerView2 = (QTRecyclerView) findViewById(C9086R.id.pen_list_recycler_view);
        this.mPenList = qTRecyclerView2;
        if (qTRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            qTRecyclerView2 = null;
        }
        qTRecyclerView2.setOnHoverListener(new ViewOnHoverListenerC7469a(8));
        this.mPenListLayoutManager = new LinearLayoutManager(context, 0, false);
        QTRecyclerView qTRecyclerView3 = this.mPenList;
        if (qTRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            qTRecyclerView3 = null;
        }
        LinearLayoutManager linearLayoutManager = this.mPenListLayoutManager;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenListLayoutManager");
            linearLayoutManager = null;
        }
        qTRecyclerView3.setLayoutManager(linearLayoutManager);
        QTRecyclerView qTRecyclerView4 = this.mPenList;
        if (qTRecyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            qTRecyclerView4 = null;
        }
        qTRecyclerView4.addOnScrollListener(new C107762());
        QTPenListAdapter qTPenListAdapter = new QTPenListAdapter(context, penInfoList, this.scale, this.isFavorite);
        this.mPenListAdapter = qTPenListAdapter;
        qTPenListAdapter.setOnItemClickListener(new QTPenListAdapter.OnItemClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenListDockingLayout.initView.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTPenListAdapter.OnItemClickListener
            public void onAddFavoriteClicked() {
                Logger.m11003i(SettingQTPenListDockingLayout.TAG, "onAddFavoriteClicked()");
                OnItemClickListener onItemClickListener = SettingQTPenListDockingLayout.this.mItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onAddFavoriteClicked();
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTPenListAdapter.OnItemClickListener
            public void onItemClick(int position, boolean selected) {
                Logger.m11003i(SettingQTPenListDockingLayout.TAG, "onItemClick() position=" + position + " selected=" + selected);
                OnItemClickListener onItemClickListener = SettingQTPenListDockingLayout.this.mItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClicked(position, selected);
                }
            }
        });
        QTPenListAdapter qTPenListAdapter2 = this.mPenListAdapter;
        if (qTPenListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenListAdapter");
            qTPenListAdapter2 = null;
        }
        qTPenListAdapter2.setOnAnimationListener(new QTPenListAdapter.OnAnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenListDockingLayout.initView.4
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTPenListAdapter.OnAnimationListener
            public void onAnimationEnd(boolean isShowAnimation) {
                if (isShowAnimation) {
                    return;
                }
                SettingQTPenListDockingLayout.this.setVisibility(8);
            }
        });
        QTRecyclerView qTRecyclerView5 = this.mPenList;
        if (qTRecyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            qTRecyclerView5 = null;
        }
        QTPenListAdapter qTPenListAdapter3 = this.mPenListAdapter;
        if (qTPenListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenListAdapter");
            qTPenListAdapter3 = null;
        }
        qTRecyclerView5.setAdapter(qTPenListAdapter3);
        QTRecyclerView qTRecyclerView6 = this.mPenList;
        if (qTRecyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            qTRecyclerView6 = null;
        }
        qTRecyclerView6.seslSetPointerIconRotation(90.0f);
        OffsetSnapHelper offsetSnapHelper = new OffsetSnapHelper(this.mItemOffset);
        QTRecyclerView qTRecyclerView7 = this.mPenList;
        if (qTRecyclerView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            qTRecyclerView7 = null;
        }
        offsetSnapHelper.attachToRecyclerView(qTRecyclerView7);
        float dimensionPixelSize = getResources().getDimensionPixelSize(C9086R.dimen.qt_circle_layout_elevation) * 3;
        this.mBottomFadeHeight = dimensionPixelSize;
        this.mSideFadeHeight = dimensionPixelSize;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$2(View view, MotionEvent motionEvent) {
        return true;
    }

    public static /* synthetic */ void notifyItemChange$default(SettingQTPenListDockingLayout settingQTPenListDockingLayout, List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        settingQTPenListDockingLayout.notifyItemChange(list, z);
    }

    private final void smoothScrollToPositionWithOffset(int position, int offset) {
        QTRecyclerView qTRecyclerView = this.mPenList;
        if (qTRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            qTRecyclerView = null;
        }
        RecyclerView.LayoutManager layoutManager = qTRecyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return;
        }
        if (this.mSmoothScroller == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.mSmoothScroller = new OffsetSmoothScroller(context, offset);
        }
        LinearSmoothScroller linearSmoothScroller = this.mSmoothScroller;
        if (linearSmoothScroller != null) {
            linearSmoothScroller.setTargetPosition(position);
        }
        linearLayoutManager.startSmoothScroll(this.mSmoothScroller);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePenPosition() {
        float width;
        QTPenListAdapter qTPenListAdapter = this.mPenListAdapter;
        if (qTPenListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenListAdapter");
            qTPenListAdapter = null;
        }
        int selectedPenPosition = qTPenListAdapter.getMSelectedPosition();
        QTPenListAdapter qTPenListAdapter2 = this.mPenListAdapter;
        if (qTPenListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenListAdapter");
            qTPenListAdapter2 = null;
        }
        int addFavoritePosition = qTPenListAdapter2.getMAddFavoritePosition();
        if (this.isFavorite) {
            QTRecyclerView qTRecyclerView = this.mPenList;
            if (qTRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenList");
                qTRecyclerView = null;
            }
            width = (qTRecyclerView.getWidth() / 2.0f) + getResources().getDimensionPixelSize(C9086R.dimen.qt_docking_pen_list_favorite_margin);
        } else {
            QTRecyclerView qTRecyclerView2 = this.mPenList;
            if (qTRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenList");
                qTRecyclerView2 = null;
            }
            width = qTRecyclerView2.getWidth() / 2.0f;
        }
        float dimensionPixelSize = getContext().getResources().getDimensionPixelSize(C9086R.dimen.qt_pen_list_item_offset_translateY);
        float dimensionPixelSize2 = getResources().getDimensionPixelSize(C9086R.dimen.qt_pen_list_item_margin_right) / 2.0f;
        float dimensionPixelSize3 = getContext().getResources().getDimensionPixelSize(C9086R.dimen.qt_circle_arch_background_radius_docking);
        QTRecyclerView qTRecyclerView3 = this.mPenList;
        if (qTRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            qTRecyclerView3 = null;
        }
        int childCount = qTRecyclerView3.getChildCount();
        for (int i = 0; i < childCount; i++) {
            QTRecyclerView qTRecyclerView4 = this.mPenList;
            if (qTRecyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenList");
                qTRecyclerView4 = null;
            }
            View childAt = qTRecyclerView4.getChildAt(i);
            float fCoerceAtMost = RangesKt.coerceAtMost(Math.abs((((childAt.getRight() + childAt.getLeft()) / 2.0f) - dimensionPixelSize2) - width), dimensionPixelSize3);
            float fSqrt = dimensionPixelSize3 - ((float) Math.sqrt((dimensionPixelSize3 * dimensionPixelSize3) - (fCoerceAtMost * fCoerceAtMost)));
            QTRecyclerView qTRecyclerView5 = this.mPenList;
            if (qTRecyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenList");
                qTRecyclerView5 = null;
            }
            int childAdapterPosition = qTRecyclerView5.getChildAdapterPosition(childAt);
            if (childAdapterPosition != addFavoritePosition && childAdapterPosition != selectedPenPosition) {
                fSqrt += dimensionPixelSize;
            }
            childAt.setTranslationY(fSqrt);
        }
    }

    public final void close() {
        this.mItemClickListener = null;
        QTPenListAdapter qTPenListAdapter = this.mPenListAdapter;
        if (qTPenListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenListAdapter");
            qTPenListAdapter = null;
        }
        qTPenListAdapter.close();
        this.mSmoothScroller = null;
    }

    @Override // android.view.View
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.draw(canvas);
        this.mPaint.setShader(this.mLeftShader);
        canvas.drawRect(0.0f, 0.0f, this.mSideFadeHeight, getHeight(), this.mPaint);
        this.mPaint.setShader(this.mRightShader);
        canvas.drawRect(getWidth() - this.mSideFadeHeight, 0.0f, getWidth(), getHeight(), this.mPaint);
        this.mPaint.setShader(this.mBottomShader);
        canvas.drawRect(0.0f, getHeight() - this.mBottomFadeHeight, getWidth(), getHeight(), this.mPaint);
    }

    public final void enableScroll(boolean enableScroll) {
        QTRecyclerView qTRecyclerView = this.mPenList;
        if (qTRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            qTRecyclerView = null;
        }
        qTRecyclerView.setEnableScroll(enableScroll);
    }

    public final void notifyItemChange(@NotNull List<QTPenViewInfo> penList, boolean updatePenList) {
        Intrinsics.checkNotNullParameter(penList, "penList");
        QTPenListAdapter qTPenListAdapter = null;
        if (updatePenList) {
            QTPenListAdapter qTPenListAdapter2 = this.mPenListAdapter;
            if (qTPenListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenListAdapter");
                qTPenListAdapter2 = null;
            }
            qTPenListAdapter2.updatePenList(penList);
        }
        QTPenListAdapter qTPenListAdapter3 = this.mPenListAdapter;
        if (qTPenListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenListAdapter");
        } else {
            qTPenListAdapter = qTPenListAdapter3;
        }
        smoothScrollToPositionWithOffset(qTPenListAdapter.getMSelectedPosition(), this.mItemOffset);
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.mBottomShader = new LinearGradient(0.0f, getHeight(), 0.0f, getHeight() - this.mBottomFadeHeight, new int[]{0, -16777216}, (float[]) null, tileMode);
        this.mLeftShader = new LinearGradient(0.0f, getHeight(), this.mSideFadeHeight, getHeight(), new int[]{0, -16777216}, (float[]) null, tileMode);
        this.mRightShader = new LinearGradient(getWidth() - this.mSideFadeHeight, getHeight(), getWidth(), getHeight(), new int[]{-16777216, 0}, (float[]) null, tileMode);
    }

    public final void selectPen(int index, boolean animation) {
        QTPenListAdapter qTPenListAdapter = this.mPenListAdapter;
        LinearLayoutManager linearLayoutManager = null;
        if (qTPenListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenListAdapter");
            qTPenListAdapter = null;
        }
        qTPenListAdapter.setSelectedPenPosition(index);
        boolean z = false;
        int iConvertDpToPixel = this.isFavorite ? (int) ResourceUtils.convertDpToPixel(getContext(), 50.0f) : 0;
        int i = iConvertDpToPixel;
        QTRecyclerView qTRecyclerView = this.mPenList;
        if (qTRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            qTRecyclerView = null;
        }
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = qTRecyclerView.findViewHolderForAdapterPosition(index);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            int right = ((viewHolderFindViewHolderForAdapterPosition.itemView.getRight() + viewHolderFindViewHolderForAdapterPosition.itemView.getLeft()) + iConvertDpToPixel) / 2;
            LinearLayoutManager linearLayoutManager2 = this.mPenListLayoutManager;
            if (linearLayoutManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenListLayoutManager");
                linearLayoutManager2 = null;
            }
            if (Math.abs(right - ((linearLayoutManager2.getWidth() + iConvertDpToPixel) / 2)) > viewHolderFindViewHolderForAdapterPosition.itemView.getWidth() / 2) {
                z = true;
            }
        } else {
            z = animation;
        }
        if (animation && z) {
            smoothScrollToPositionWithOffset(index, i + ((int) ResourceUtils.convertDpToPixel(getContext(), 12.0f)));
            return;
        }
        LinearLayoutManager linearLayoutManager3 = this.mPenListLayoutManager;
        if (linearLayoutManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenListLayoutManager");
        } else {
            linearLayoutManager = linearLayoutManager3;
        }
        linearLayoutManager.scrollToPositionWithOffset(index, i);
    }

    public final void setOnItemClickListener(@Nullable OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    public final void setPenInfoList(@NotNull List<QTPenViewInfo> penList) {
        Intrinsics.checkNotNullParameter(penList, "penList");
        AbstractC8014b.m7217s(penList.size(), "setPenInfoList() size=", TAG);
        QTPenListAdapter qTPenListAdapter = this.mPenListAdapter;
        if (qTPenListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenListAdapter");
            qTPenListAdapter = null;
        }
        qTPenListAdapter.setPenList(penList);
    }

    public final void setVisibility(int visibility, boolean animation) {
        if ((visibility != 0 && getVisibility() != 0) || !animation) {
            setVisibility(visibility);
            return;
        }
        setVisibility(0);
        boolean z = visibility == 0;
        QTPenListAdapter qTPenListAdapter = null;
        if (this.isFavorite && !z) {
            QTPenListAdapter qTPenListAdapter2 = this.mPenListAdapter;
            if (qTPenListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenListAdapter");
                qTPenListAdapter2 = null;
            }
            selectPen(qTPenListAdapter2.getMSelectedPosition(), true);
        }
        QTPenListAdapter qTPenListAdapter3 = this.mPenListAdapter;
        if (qTPenListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenListAdapter");
        } else {
            qTPenListAdapter = qTPenListAdapter3;
        }
        qTPenListAdapter.startAnimation(z);
        post(new RunnableC10783e(this, 0));
    }
}
