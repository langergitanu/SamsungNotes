package com.samsung.android.sdk.pen.setting.handwriting;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.microsoft.identity.common.java.marker.PerfConstants;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenLayoutInterface;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenListControl;
import com.samsung.android.spen.C7932R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0000\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001<B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00192\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012H\u0002J\u0018\u0010\u001f\u001a\u00020\u00192\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u001cH\u0016J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020\u0012H\u0016J\b\u0010%\u001a\u00020\u0019H\u0016J\u0012\u0010&\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010\u0017H\u0016J0\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0012H\u0014J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00120\u001c2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u001cH\u0002J\u0010\u00100\u001a\u00020\u00192\u0006\u0010#\u001a\u00020!H\u0002J\"\u00101\u001a\u00020\u00192\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u0006H\u0002J.\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u00122\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00120\u001cH\u0002J\u0010\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u0015H\u0002J\u0012\u0010;\u001a\u00020\u00192\b\u0010:\u001a\u0004\u0018\u00010\u0015H\u0002R\u000e\u0010\t\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenLayout;", "Landroid/widget/FrameLayout;", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenLayoutInterface;", "context", "Landroid/content/Context;", "supportPenPreview", "", "<init>", "(Landroid/content/Context;Z)V", "mContext", "mPenControl", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPreviewPenListControl;", "mPenScrollManager", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenScrollManager;", "mPenLayout", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPensView;", "mSupportPenPreview", "mDefaultWidth", "", "mDefaultHeight", "mTargetPen", "", "mActionListener", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenLayoutInterface$OnActionListener;", "close", "", "setPenList", "penNames", "", "getBetweenPenDimenId", "count", "setPenInfoList", "penInfoList", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "setPenInfo", "penInfo", "getSelectedPenPosition", "setUnselectedPen", "setActionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onLayout", "changed", "left", "top", "right", "bottom", "construct", "getMarkerPenPosList", "updateUI", "adjustLayout", "width", "needScroll", "adjustPenLayout", "startMargin", "endMargin", "betweenPen", "markerPenPosition", "updateChildPosition", "penName", "setVisiblePen", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPenLayout extends FrameLayout implements SpenPenLayoutInterface {
    private static final int MAX_PEN_COUNT_WITHOUT_SCROLL = 7;

    @NotNull
    private static final String TAG = "SpenPenLayout";

    @Nullable
    private SpenPenLayoutInterface.OnActionListener mActionListener;
    private Context mContext;
    private int mDefaultHeight;
    private int mDefaultWidth;
    private SpenPreviewPenListControl mPenControl;

    @Nullable
    private SpenPensView mPenLayout;
    private SpenPenScrollManager mPenScrollManager;
    private boolean mSupportPenPreview;

    @Nullable
    private String mTargetPen;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPenLayout(@NotNull Context context, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSupportPenPreview = z;
        construct(context);
    }

    private final void adjustLayout(Context context, int width, boolean needScroll) {
        if (context == null) {
            return;
        }
        SpenPenScrollManager spenPenScrollManager = null;
        this.mPenLayout = new SpenPensView(context, null);
        if (!needScroll) {
            addView(this.mPenLayout, new FrameLayout.LayoutParams(width, this.mDefaultHeight));
            return;
        }
        SpenPenScrollManager spenPenScrollManager2 = this.mPenScrollManager;
        if (spenPenScrollManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenScrollManager");
        } else {
            spenPenScrollManager = spenPenScrollManager2;
        }
        spenPenScrollManager.setLayout(this, this.mPenLayout, width);
    }

    private final void adjustPenLayout(int startMargin, int endMargin, int betweenPen, List<Integer> markerPenPosition) {
        SpenPensView spenPensView = this.mPenLayout;
        if (spenPensView != null) {
            Context context = this.mContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            }
            Resources resources = context.getResources();
            spenPensView.setSelectedGuideInfo(resources.getDimensionPixelSize(C7932R.dimen.setting_pen_layout_select_margin), resources.getDimensionPixelSize(C7932R.dimen.setting_pen_layout_unselect_margin));
            spenPensView.setPenMargin(startMargin, endMargin, betweenPen);
            if (this.mSupportPenPreview) {
                int dimensionPixelOffset = resources.getDimensionPixelOffset(C7932R.dimen.setting_pen_layout_marker_preview_margin);
                int dimensionPixelOffset2 = resources.getDimensionPixelOffset(C7932R.dimen.setting_pen_layout_marker_preview_margin_top);
                spenPensView.setPenPreviewInfo(C7932R.layout.setting_pen_preview, resources.getDimensionPixelOffset(C7932R.dimen.setting_pen_layout_preview_margin), resources.getDimensionPixelOffset(C7932R.dimen.setting_pen_layout_preview_margin_top));
                spenPensView.setPenPreviewExceptInfo(dimensionPixelOffset, dimensionPixelOffset2, markerPenPosition);
            }
        }
    }

    private final void construct(Context context) {
        this.mContext = context;
        SpenPreviewPenListControl spenPreviewPenListControl = new SpenPreviewPenListControl(context, C7932R.layout.setting_pen_pen);
        this.mPenControl = spenPreviewPenListControl;
        spenPreviewPenListControl.setOnPenClickListener(new SpenPenListControl.OnPenClickListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenPenLayout.construct.1
            @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenListControl.OnPenClickListener
            public void onPenClicked(String name, boolean isSelected) {
                Log.i(SpenPenLayout.TAG, "onPenClick() name=" + name + " isSelected=" + isSelected);
                SpenPenLayoutInterface.OnActionListener onActionListener = SpenPenLayout.this.mActionListener;
                if (onActionListener != null) {
                    onActionListener.onPenClicked(name, isSelected);
                }
            }
        });
        Resources resources = context.getResources();
        this.mDefaultWidth = resources.getDimensionPixelSize(C7932R.dimen.setting_common_popup_width_v60);
        this.mDefaultHeight = resources.getDimensionPixelSize(C7932R.dimen.setting_pen_layout_popup_pen_height);
        SpenPenScrollManager spenPenScrollManager = new SpenPenScrollManager(context, this.mDefaultWidth, this.mDefaultHeight);
        this.mPenScrollManager = spenPenScrollManager;
        spenPenScrollManager.setPadding(resources.getDimensionPixelSize(C7932R.dimen.setting_pen_layout_scroll_padding_start), 0, resources.getDimensionPixelSize(C7932R.dimen.setting_pen_layout_scroll_padding_start), 0);
        SpenPenScrollManager spenPenScrollManager2 = this.mPenScrollManager;
        if (spenPenScrollManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenScrollManager");
            spenPenScrollManager2 = null;
        }
        spenPenScrollManager2.setExtraValue(resources.getDimensionPixelSize(C7932R.dimen.setting_pen_layout_pen_preview_width_minus_overlap_area));
    }

    private final int getBetweenPenDimenId(int count) {
        return count > 7 ? C7932R.dimen.setting_pen_layout_pen_item_more_space : count != 2 ? count != 3 ? C7932R.dimen.setting_pen_layout_pen_space : C7932R.dimen.setting_pen_layout_pen_space_three : C7932R.dimen.setting_pen_layout_pen_space_two;
    }

    private final List<Integer> getMarkerPenPosList(List<String> penNames) {
        ArrayList arrayList = new ArrayList();
        int size = penNames.size();
        for (int i = 0; i < size; i++) {
            if (StringsKt.m14162r(penNames.get(i), PerfConstants.CodeMarkerParameters.MARKER) || StringsKt.m14162r(penNames.get(i), "Highlighter")) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }

    private final void setVisiblePen(String penName) {
        if (penName == null) {
            return;
        }
        SpenPreviewPenListControl spenPreviewPenListControl = this.mPenControl;
        SpenPenScrollManager spenPenScrollManager = null;
        if (spenPreviewPenListControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenControl");
            spenPreviewPenListControl = null;
        }
        View viewFindPenView = spenPreviewPenListControl.findPenView(penName);
        if (viewFindPenView == null) {
            AbstractC4539a.m3207q("Not Existed Pen. (", penName, ")", TAG);
            return;
        }
        SpenPenScrollManager spenPenScrollManager2 = this.mPenScrollManager;
        if (spenPenScrollManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenScrollManager");
        } else {
            spenPenScrollManager = spenPenScrollManager2;
        }
        spenPenScrollManager.setVisibleChild(viewFindPenView, getResources().getConfiguration().getLayoutDirection() == 1);
    }

    private final boolean updateChildPosition(String penName) {
        AbstractC6670b.m4756q("updateScrollPosition() penName=", penName, TAG);
        SpenPenScrollManager spenPenScrollManager = this.mPenScrollManager;
        SpenPenScrollManager spenPenScrollManager2 = null;
        if (spenPenScrollManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenScrollManager");
            spenPenScrollManager = null;
        }
        if (!spenPenScrollManager.isSupportScroll()) {
            return true;
        }
        SpenPenScrollManager spenPenScrollManager3 = this.mPenScrollManager;
        if (spenPenScrollManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenScrollManager");
        } else {
            spenPenScrollManager2 = spenPenScrollManager3;
        }
        if (spenPenScrollManager2.getScrollWidth() > 0) {
            setVisiblePen(penName);
            return true;
        }
        this.mTargetPen = penName;
        return false;
    }

    private final void updateUI(SpenSettingPenInfo penInfo) {
        String str = penInfo.name;
        int i = penInfo.color;
        int i2 = penInfo.sizeLevel;
        float f = penInfo.particleSize;
        StringBuilder sbM780v = AbstractC0541b.m780v("updateUI() penName=", i, str, " color=", " sizeLevel=");
        sbM780v.append(i2);
        sbM780v.append(" particleSize=");
        sbM780v.append(f);
        Log.i(TAG, sbM780v.toString());
        SpenPreviewPenListControl spenPreviewPenListControl = this.mPenControl;
        if (spenPreviewPenListControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenControl");
            spenPreviewPenListControl = null;
        }
        spenPreviewPenListControl.setPenInfo(penInfo);
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenLayoutInterface
    public void close() {
        SpenPensView spenPensView = this.mPenLayout;
        if (spenPensView != null) {
            spenPensView.close();
        }
        this.mPenLayout = null;
        SpenPreviewPenListControl spenPreviewPenListControl = this.mPenControl;
        if (spenPreviewPenListControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenControl");
            spenPreviewPenListControl = null;
        }
        spenPreviewPenListControl.close();
        SpenPenScrollManager spenPenScrollManager = this.mPenScrollManager;
        if (spenPenScrollManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenScrollManager");
            spenPenScrollManager = null;
        }
        spenPenScrollManager.close();
        this.mActionListener = null;
        this.mTargetPen = null;
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenLayoutInterface
    public int getSelectedPenPosition() {
        return 0;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.mTargetPen != null) {
            SpenPenScrollManager spenPenScrollManager = this.mPenScrollManager;
            if (spenPenScrollManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenScrollManager");
                spenPenScrollManager = null;
            }
            if (spenPenScrollManager.isSupportScroll()) {
                SpenPenScrollManager spenPenScrollManager2 = this.mPenScrollManager;
                if (spenPenScrollManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPenScrollManager");
                    spenPenScrollManager2 = null;
                }
                if (spenPenScrollManager2.getScrollWidth() > 0) {
                    String str = this.mTargetPen;
                    Intrinsics.checkNotNull(str);
                    if (updateChildPosition(str)) {
                        this.mTargetPen = null;
                    }
                }
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenLayoutInterface
    public void setActionListener(@Nullable SpenPenLayoutInterface.OnActionListener listener) {
        this.mActionListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenLayoutInterface
    public boolean setPenInfo(@NotNull SpenSettingPenInfo penInfo) {
        Intrinsics.checkNotNullParameter(penInfo, "penInfo");
        updateUI(penInfo);
        updateChildPosition(penInfo.name);
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenLayoutInterface
    public void setPenInfoList(@Nullable List<? extends SpenSettingPenInfo> penInfoList) {
        SpenPreviewPenListControl spenPreviewPenListControl = this.mPenControl;
        if (spenPreviewPenListControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenControl");
            spenPreviewPenListControl = null;
        }
        spenPreviewPenListControl.setPenInfoList(penInfoList);
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenLayoutInterface
    public void setPenList(@Nullable List<String> penNames) {
        int dimensionPixelOffset;
        boolean z;
        if (penNames == null) {
            return;
        }
        Context context = this.mContext;
        SpenPreviewPenListControl spenPreviewPenListControl = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        Resources resources = context.getResources();
        int i = this.mDefaultWidth;
        int size = penNames.size();
        int dimensionPixelSize = resources.getDimensionPixelSize(getBetweenPenDimenId(size));
        int i2 = 0;
        if (size < 7) {
            dimensionPixelOffset = resources.getDimensionPixelSize(C7932R.dimen.setting_pen_layout_pen_start_end_margin);
            z = false;
            i2 = dimensionPixelOffset;
        } else if (penNames.size() == 7) {
            int dimensionPixelSize2 = resources.getDimensionPixelSize(C7932R.dimen.setting_pen_layout_more_pen_start_end_margin);
            dimensionPixelOffset = resources.getDimensionPixelSize(C7932R.dimen.setting_pen_layout_pen_start_end_margin);
            z = false;
            i2 = dimensionPixelSize2;
        } else {
            int dimensionPixelSize3 = resources.getDimensionPixelSize(C7932R.dimen.setting_pen_layout_pen_item_width);
            dimensionPixelOffset = resources.getDimensionPixelOffset(C7932R.dimen.setting_pen_layout_scroll_end_margin);
            z = true;
            i = ((size - 1) * dimensionPixelSize) + (dimensionPixelSize3 * size) + dimensionPixelOffset;
        }
        Context context2 = this.mContext;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context2 = null;
        }
        adjustLayout(context2, i, z);
        adjustPenLayout(i2, dimensionPixelOffset, dimensionPixelSize, getMarkerPenPosList(penNames));
        SpenPensView spenPensView = this.mPenLayout;
        if (spenPensView != null) {
            SpenPreviewPenListControl spenPreviewPenListControl2 = this.mPenControl;
            if (spenPreviewPenListControl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenControl");
            } else {
                spenPreviewPenListControl = spenPreviewPenListControl2;
            }
            spenPreviewPenListControl.setView(spenPensView, penNames);
        }
    }

    public /* synthetic */ SpenPenLayout(Context context, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? false : z);
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenLayoutInterface
    public void setUnselectedPen() {
    }
}
