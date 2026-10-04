package com.samsung.android.sdk.pen.setting.quicktool;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.ViewOnHoverListenerC7469a;
import com.samsung.android.sdk.pen.setting.quicktool.SpenQTPenListAdapter;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sdk.pen.setting.widget.SpenRecyclerView;
import com.samsung.android.spen.C7932R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 :2\u00020\u0001:\u0004:;<=B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"J\u0014\u0010#\u001a\u00020\u001f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0010\u0010%\u001a\u00020\u001f2\b\u0010&\u001a\u0004\u0018\u00010\u0010J\u0010\u0010'\u001a\u00020\u001f2\b\u0010&\u001a\u0004\u0018\u00010\u0012J\u0016\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\"J\u0016\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020*2\u0006\u0010+\u001a\u00020\"J\u001e\u0010.\u001a\u00020\u001f2\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\b\u0010/\u001a\u00020\u001fH\u0002J\u0010\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020*H\u0002J(\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020*2\u0006\u00105\u001a\u00020*2\u0006\u00106\u001a\u00020*H\u0014J\u0010\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u000209H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenListLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "penInfoList", "", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenPenViewInfo;", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "mPenList", "Lcom/samsung/android/sdk/pen/setting/widget/SpenRecyclerView;", "mPenListAdapter", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTPenListAdapter;", "mPenListLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mItemClickListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenListLayout$OnItemClickListener;", "mAddButtonClickListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenListLayout$OnAddButtonClickListener;", "mBottomFadeHeight", "", "mSideFadeHeight", "mBottomShader", "Landroid/graphics/LinearGradient;", "mLeftShader", "mRightShader", "mPaint", "Landroid/graphics/Paint;", "mSmoothScroller", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "close", "", "setAddButtonEnabled", "enabled", "", "setPenInfoList", "penList", "setOnItemClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnAddButtonClickListener", "selectPen", "index", "", "animation", "setVisibility", "visibility", "initView", "updatePenPosition", "customSmoothScrollToPosition", "position", "onSizeChanged", "w", "h", "oldw", "oldh", "draw", "canvas", "Landroid/graphics/Canvas;", "Companion", "OnItemClickListener", "OnAddButtonClickListener", "CustomSmoothScroller", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenSettingQTPenListLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenSettingQTPenListLayout.kt\ncom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenListLayout\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,225:1\n254#2:226\n*S KotlinDebug\n*F\n+ 1 SpenSettingQTPenListLayout.kt\ncom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenListLayout\n*L\n96#1:226\n*E\n"})
public final class SpenSettingQTPenListLayout extends ConstraintLayout {
    private static final int PEN_ITEM_SELECT_ANIMATION_DURATION = 350;

    @NotNull
    private static final String TAG = "SpenSettingQTPenListLayout";

    @Nullable
    private OnAddButtonClickListener mAddButtonClickListener;
    private float mBottomFadeHeight;

    @Nullable
    private LinearGradient mBottomShader;

    @Nullable
    private OnItemClickListener mItemClickListener;

    @Nullable
    private LinearGradient mLeftShader;

    @NotNull
    private Paint mPaint;
    private SpenRecyclerView mPenList;
    private SpenQTPenListAdapter mPenListAdapter;
    private LinearLayoutManager mPenListLayoutManager;

    @Nullable
    private LinearGradient mRightShader;
    private float mSideFadeHeight;

    @Nullable
    private LinearSmoothScroller mSmoothScroller;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenListLayout$CustomSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "calculateDxToMakeVisible", "", "view", "Landroid/view/View;", "snapPreference", "onTargetFound", "", "targetView", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "action", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller$Action;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class CustomSmoothScroller extends LinearSmoothScroller {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomSmoothScroller(@NotNull Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDxToMakeVisible(@NotNull View view, int snapPreference) {
            Intrinsics.checkNotNullParameter(view, "view");
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager == null) {
                return 0;
            }
            return ((view.getRight() + view.getLeft()) / 2) - (layoutManager.getWidth() / 2);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onTargetFound(@NotNull View targetView, @NotNull RecyclerView.State state, @NotNull RecyclerView.SmoothScroller.Action action) {
            Intrinsics.checkNotNullParameter(targetView, "targetView");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(action, "action");
            int iCalculateDxToMakeVisible = calculateDxToMakeVisible(targetView, -1);
            if (iCalculateDxToMakeVisible != 0) {
                action.update(iCalculateDxToMakeVisible, 0, SpenSettingQTPenListLayout.PEN_ITEM_SELECT_ANIMATION_DURATION, SpenSettingUtilAnimation.getInterpolator(20));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenListLayout$OnAddButtonClickListener;", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTPenListAdapter$OnAddButtonClickListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnAddButtonClickListener extends SpenQTPenListAdapter.OnAddButtonClickListener {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenListLayout$OnItemClickListener;", "", "onItemClicked", "", "position", "", "selected", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnItemClickListener {
        void onItemClicked(int position, boolean selected);
    }

    /* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenListLayout$initView$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, m13886d2 = {"com/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenListLayout$initView$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "onScrollStateChanged", "newState", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class C76452 extends RecyclerView.OnScrollListener {
        final /* synthetic */ LinearSnapHelper $snapHelper;

        public C76452(LinearSnapHelper linearSnapHelper) {
            this.$snapHelper = linearSnapHelper;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            RecyclerView.LayoutManager layoutManager;
            View viewFindSnapView;
            int i;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState != 0 || (layoutManager = recyclerView.getLayoutManager()) == null || (viewFindSnapView = this.$snapHelper.findSnapView(layoutManager)) == null) {
                return;
            }
            int position = layoutManager.getPosition(viewFindSnapView);
            int[] iArrCalculateDistanceToFinalSnap = this.$snapHelper.calculateDistanceToFinalSnap(layoutManager, viewFindSnapView);
            if (position != 0 || iArrCalculateDistanceToFinalSnap == null || (i = iArrCalculateDistanceToFinalSnap[0]) <= 0) {
                return;
            }
            recyclerView.scrollBy(i, iArrCalculateDistanceToFinalSnap[1]);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            SpenRecyclerView spenRecyclerView = SpenSettingQTPenListLayout.this.mPenList;
            if (spenRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenList");
                spenRecyclerView = null;
            }
            spenRecyclerView.post(new RunnableC7663o(SpenSettingQTPenListLayout.this, 1));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSettingQTPenListLayout(@NotNull Context context, @NotNull List<SpenPenViewInfo> penInfoList) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(penInfoList, "penInfoList");
        this.mPaint = new Paint();
        initView(context, penInfoList);
    }

    public static final /* synthetic */ void access$updatePenPosition(SpenSettingQTPenListLayout spenSettingQTPenListLayout) {
        spenSettingQTPenListLayout.updatePenPosition();
    }

    private final void customSmoothScrollToPosition(int position) {
        SpenRecyclerView spenRecyclerView = this.mPenList;
        if (spenRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            spenRecyclerView = null;
        }
        RecyclerView.LayoutManager layoutManager = spenRecyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return;
        }
        if (this.mSmoothScroller == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.mSmoothScroller = new CustomSmoothScroller(context);
        }
        LinearSmoothScroller linearSmoothScroller = this.mSmoothScroller;
        if (linearSmoothScroller != null) {
            linearSmoothScroller.setTargetPosition(position);
        }
        linearLayoutManager.startSmoothScroll(this.mSmoothScroller);
    }

    private final void initView(Context context, List<SpenPenViewInfo> penInfoList) {
        LayoutInflater.from(context).inflate(C7932R.layout.setting_qt_pen_list_layout, (ViewGroup) this, true);
        SpenRecyclerView spenRecyclerView = (SpenRecyclerView) findViewById(C7932R.id.pen_list_recycler_view);
        this.mPenList = spenRecyclerView;
        if (spenRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            spenRecyclerView = null;
        }
        spenRecyclerView.setRecoilEnabled(false);
        SpenRecyclerView spenRecyclerView2 = this.mPenList;
        if (spenRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            spenRecyclerView2 = null;
        }
        spenRecyclerView2.setOnHoverListener(new ViewOnHoverListenerC7469a(5));
        this.mPenListLayoutManager = new LinearLayoutManager(context, 0, false);
        SpenRecyclerView spenRecyclerView3 = this.mPenList;
        if (spenRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            spenRecyclerView3 = null;
        }
        LinearLayoutManager linearLayoutManager = this.mPenListLayoutManager;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenListLayoutManager");
            linearLayoutManager = null;
        }
        spenRecyclerView3.setLayoutManager(linearLayoutManager);
        LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
        SpenRecyclerView spenRecyclerView4 = this.mPenList;
        if (spenRecyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            spenRecyclerView4 = null;
        }
        linearSnapHelper.attachToRecyclerView(spenRecyclerView4);
        SpenRecyclerView spenRecyclerView5 = this.mPenList;
        if (spenRecyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            spenRecyclerView5 = null;
        }
        spenRecyclerView5.addOnScrollListener(new C76452(linearSnapHelper));
        SpenQTPenListAdapter spenQTPenListAdapter = new SpenQTPenListAdapter(context, penInfoList);
        this.mPenListAdapter = spenQTPenListAdapter;
        spenQTPenListAdapter.setOnItemClickListener(new SpenQTPenListAdapter.OnItemClickListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenListLayout.initView.3
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenQTPenListAdapter.OnItemClickListener
            public void onItemClick(int position, boolean selected) {
                AbstractC6670b.m4754o("onItemClick() position=", position, " selected=", selected, SpenSettingQTPenListLayout.TAG);
                OnItemClickListener onItemClickListener = SpenSettingQTPenListLayout.this.mItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClicked(position, selected);
                }
            }
        });
        SpenQTPenListAdapter spenQTPenListAdapter2 = this.mPenListAdapter;
        if (spenQTPenListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenListAdapter");
            spenQTPenListAdapter2 = null;
        }
        spenQTPenListAdapter2.setOnAnimationListener(new SpenQTPenListAdapter.OnAnimationListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenListLayout.initView.4
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenQTPenListAdapter.OnAnimationListener
            public void onAnimationEnd(boolean isShowAnimation) {
                if (isShowAnimation) {
                    return;
                }
                SpenSettingQTPenListLayout.this.setVisibility(8);
            }
        });
        SpenQTPenListAdapter spenQTPenListAdapter3 = this.mPenListAdapter;
        if (spenQTPenListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenListAdapter");
            spenQTPenListAdapter3 = null;
        }
        spenQTPenListAdapter3.setOnAddButtonClickListener(new SpenQTPenListAdapter.OnAddButtonClickListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenListLayout.initView.5
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenQTPenListAdapter.OnAddButtonClickListener
            public void onAddButtonClicked() {
                Log.i(SpenSettingQTPenListLayout.TAG, "onAddButtonClicked()");
                OnAddButtonClickListener onAddButtonClickListener = SpenSettingQTPenListLayout.this.mAddButtonClickListener;
                if (onAddButtonClickListener != null) {
                    onAddButtonClickListener.onAddButtonClicked();
                }
            }
        });
        SpenRecyclerView spenRecyclerView6 = this.mPenList;
        if (spenRecyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            spenRecyclerView6 = null;
        }
        SpenQTPenListAdapter spenQTPenListAdapter4 = this.mPenListAdapter;
        if (spenQTPenListAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenListAdapter");
            spenQTPenListAdapter4 = null;
        }
        spenRecyclerView6.setAdapter(spenQTPenListAdapter4);
        float dimensionPixelSize = getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_layout_elevation) * 3;
        this.mBottomFadeHeight = dimensionPixelSize;
        this.mSideFadeHeight = dimensionPixelSize;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$1(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePenPosition() {
        SpenQTPenListAdapter spenQTPenListAdapter = this.mPenListAdapter;
        if (spenQTPenListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenListAdapter");
            spenQTPenListAdapter = null;
        }
        int selectedPenPosition = spenQTPenListAdapter.getMSelectedPosition();
        SpenRecyclerView spenRecyclerView = this.mPenList;
        if (spenRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            spenRecyclerView = null;
        }
        float width = spenRecyclerView.getWidth() / 2.0f;
        float dimensionPixelSize = getContext().getResources().getDimensionPixelSize(C7932R.dimen.qt_pen_list_item_offset_translateY);
        float dimensionPixelSize2 = getResources().getDimensionPixelSize(C7932R.dimen.qt_pen_list_item_margin_right) / 2.0f;
        float dimensionPixelSize3 = getContext().getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_arch_background_radius);
        SpenRecyclerView spenRecyclerView2 = this.mPenList;
        if (spenRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            spenRecyclerView2 = null;
        }
        int childCount = spenRecyclerView2.getChildCount();
        for (int i = 0; i < childCount; i++) {
            SpenRecyclerView spenRecyclerView3 = this.mPenList;
            if (spenRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenList");
                spenRecyclerView3 = null;
            }
            View childAt = spenRecyclerView3.getChildAt(i);
            float fCoerceAtMost = RangesKt.coerceAtMost(Math.abs((((childAt.getRight() + childAt.getLeft()) / 2.0f) - dimensionPixelSize2) - width), dimensionPixelSize3);
            float fSqrt = dimensionPixelSize3 - ((float) Math.sqrt((dimensionPixelSize3 * dimensionPixelSize3) - (fCoerceAtMost * fCoerceAtMost)));
            SpenRecyclerView spenRecyclerView4 = this.mPenList;
            if (spenRecyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenList");
                spenRecyclerView4 = null;
            }
            int childAdapterPosition = spenRecyclerView4.getChildAdapterPosition(childAt);
            if (childAdapterPosition != selectedPenPosition) {
                fSqrt += dimensionPixelSize;
            }
            childAt.setTranslationY(fSqrt);
            SpenQTPenListAdapter spenQTPenListAdapter2 = this.mPenListAdapter;
            if (spenQTPenListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenListAdapter");
                spenQTPenListAdapter2 = null;
            }
            spenQTPenListAdapter2.setItemTranslationY(childAdapterPosition, childAt.getTranslationY());
        }
    }

    public final void close() {
        this.mItemClickListener = null;
        SpenQTPenListAdapter spenQTPenListAdapter = this.mPenListAdapter;
        if (spenQTPenListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenListAdapter");
            spenQTPenListAdapter = null;
        }
        spenQTPenListAdapter.close();
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

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.mBottomShader = new LinearGradient(0.0f, getHeight(), 0.0f, getHeight() - this.mBottomFadeHeight, new int[]{0, -16777216}, (float[]) null, tileMode);
        this.mLeftShader = new LinearGradient(0.0f, getHeight(), this.mSideFadeHeight, getHeight(), new int[]{0, -16777216}, (float[]) null, tileMode);
        this.mRightShader = new LinearGradient(getWidth() - this.mSideFadeHeight, getHeight(), getWidth(), getHeight(), new int[]{-16777216, 0}, (float[]) null, tileMode);
    }

    public final void selectPen(int index, boolean animation) {
        SpenQTPenListAdapter spenQTPenListAdapter = this.mPenListAdapter;
        SpenRecyclerView spenRecyclerView = null;
        if (spenQTPenListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenListAdapter");
            spenQTPenListAdapter = null;
        }
        spenQTPenListAdapter.setSelectedPenPosition(index);
        if (animation) {
            customSmoothScrollToPosition(index);
            return;
        }
        SpenRecyclerView spenRecyclerView2 = this.mPenList;
        if (spenRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
        } else {
            spenRecyclerView = spenRecyclerView2;
        }
        spenRecyclerView.scrollToPosition(index);
    }

    public final void setAddButtonEnabled(boolean enabled) {
        AbstractC4539a.m3208r("setAddButtonEnabled() enabled=", TAG, enabled);
        SpenQTPenListAdapter spenQTPenListAdapter = this.mPenListAdapter;
        if (spenQTPenListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenListAdapter");
            spenQTPenListAdapter = null;
        }
        spenQTPenListAdapter.setAddButtonEnabled(enabled);
    }

    public final void setOnAddButtonClickListener(@Nullable OnAddButtonClickListener listener) {
        this.mAddButtonClickListener = listener;
    }

    public final void setOnItemClickListener(@Nullable OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    public final void setPenInfoList(@NotNull List<SpenPenViewInfo> penList) {
        Intrinsics.checkNotNullParameter(penList, "penList");
        AbstractC2322a.m1631u(penList.size(), "setPenInfoList() size=", TAG);
        SpenQTPenListAdapter spenQTPenListAdapter = this.mPenListAdapter;
        if (spenQTPenListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenListAdapter");
            spenQTPenListAdapter = null;
        }
        spenQTPenListAdapter.setPenList(penList);
    }

    public final void setVisibility(int visibility, boolean animation) {
        if ((visibility != 0 && getVisibility() != 0) || !animation) {
            setVisibility(visibility);
            return;
        }
        setVisibility(0);
        SpenQTPenListAdapter spenQTPenListAdapter = this.mPenListAdapter;
        if (spenQTPenListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenListAdapter");
            spenQTPenListAdapter = null;
        }
        spenQTPenListAdapter.startAnimation(visibility == 0);
        post(new RunnableC7663o(this, 0));
    }
}
