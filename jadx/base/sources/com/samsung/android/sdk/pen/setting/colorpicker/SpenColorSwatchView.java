package com.samsung.android.sdk.pen.setting.colorpicker;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.color.SpenColorSwatchUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0000\u0018\u0000 U2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002UVB7\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020 H\u0016J\b\u00104\u001a\u000202H\u0016J2\u00105\u001a\u0002022\b\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:H\u0016J\u0012\u0010=\u001a\u0002022\b\u0010>\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020AH\u0014J \u0010D\u001a\u0002022\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:H\u0002J0\u0010E\u001a\u0002022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010F\u001a\u0002022\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010G\u001a\u000202H\u0002J\u0010\u0010H\u001a\u0002022\u0006\u0010I\u001a\u00020\u0007H\u0002J\u0010\u0010J\u001a\u0002022\u0006\u0010K\u001a\u00020\u0007H\u0002J\u001a\u0010L\u001a\u00020$2\b\u0010M\u001a\u0004\u0018\u00010\u00112\u0006\u0010N\u001a\u00020\u0007H\u0002J\u0012\u0010O\u001a\u0004\u0018\u00010\u00152\u0006\u0010K\u001a\u00020\u0007H\u0002J\u0010\u0010P\u001a\u0002022\u0006\u0010I\u001a\u00020\u0007H\u0002J\b\u0010Q\u001a\u000202H\u0002J \u0010R\u001a\u00020\u00072\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:H\u0002J\b\u0010S\u001a\u000202H\u0002J\b\u0010T\u001a\u000202H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorSwatchView;", "Landroid/widget/RelativeLayout;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorViewInterface;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenPickerColorEventListener;", "context", "Landroid/content/Context;", "mItemLayoutID", "", "marginStart", "marginTop", "marginEnd", "marginBottom", "<init>", "(Landroid/content/Context;IIIII)V", "mSwatchView", "Landroid/widget/GridView;", "mSelectedView", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorSwatchFloatingView;", "mSwatchAdapter", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorSwatchAdapter;", "mDrawRect", "Landroid/graphics/Rect;", "mSwatchItemList", "", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorSwatchItem;", "mColumNum", "mCurrentPosition", "mCurrentHoverPosition", "mHoverView", "mSwatchStartMargin", "mSwatchTopMargin", "mPickerColor", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenPickerColor;", "mTouchUpListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorViewTouchUpListener;", "mIsTouchInArea", "", "mColorSwatchUtil", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorSwatchUtil;", "mReqPosIndex", "mLastPosIndex", "mLastCenterX", "mSwatchViewObserver", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "mSwatchViewBackgroundObserver", "mSwatchItemClickListener", "Landroid/widget/AdapterView$OnItemClickListener;", "mAccessibilityDelegate", "Landroid/view/View$AccessibilityDelegate;", "setPickerColor", "", "pickerColor", "release", Constants.ARG_UPDATE, "who", "", "color", "hue", "", "saturation", "value", "setTouchUpListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "dispatchHoverEvent", "event", "setColor", "construct", "initSwatchList", "initHoverView", "notifyColorChanged", "position", "updatePosition", "pos", "updateFloatingView", "floatingView", "matchPos", "getChildRect", "needUpdate", "releaseDetected", "findMatchedSwatch", "initSwatchViewOutline", "releaseBackgroundObserver", "Companion", "ActionListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenColorSwatchView extends RelativeLayout implements SpenColorViewInterface, SpenPickerColorEventListener {

    @NotNull
    private static final String TAG = "SpenColorSwatchView";

    @NotNull
    private final View.AccessibilityDelegate mAccessibilityDelegate;

    @NotNull
    private SpenColorSwatchUtil mColorSwatchUtil;
    private int mColumNum;
    private int mCurrentHoverPosition;
    private int mCurrentPosition;
    private Rect mDrawRect;

    @Nullable
    private SpenColorSwatchFloatingView mHoverView;
    private boolean mIsTouchInArea;
    private final int mItemLayoutID;
    private int mLastCenterX;
    private int mLastPosIndex;

    @Nullable
    private SpenPickerColor mPickerColor;
    private int mReqPosIndex;
    private SpenColorSwatchFloatingView mSelectedView;
    private SpenColorSwatchAdapter mSwatchAdapter;

    @NotNull
    private final AdapterView.OnItemClickListener mSwatchItemClickListener;
    private List<SpenColorSwatchItem> mSwatchItemList;
    private int mSwatchStartMargin;
    private int mSwatchTopMargin;
    private GridView mSwatchView;

    @Nullable
    private ViewTreeObserver.OnGlobalLayoutListener mSwatchViewBackgroundObserver;

    @Nullable
    private ViewTreeObserver.OnGlobalLayoutListener mSwatchViewObserver;

    @Nullable
    private SpenColorViewTouchUpListener mTouchUpListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorSwatchView$ActionListener;", "", "onColorSelected", "", "saturation", "", "value", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ActionListener {
        void onColorSelected(float saturation, float value);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenColorSwatchView(@NotNull Context context, int i, int i2, int i4, int i5, int i6) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mItemLayoutID = i;
        this.mCurrentHoverPosition = -1;
        this.mColorSwatchUtil = new SpenColorSwatchUtil(context);
        this.mReqPosIndex = -1;
        this.mLastPosIndex = -1;
        this.mSwatchItemClickListener = new C7543e(this, 0);
        this.mAccessibilityDelegate = new View.AccessibilityDelegate() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenColorSwatchView$mAccessibilityDelegate$1
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(info, "info");
                super.onInitializeAccessibilityNodeInfo(host, info);
                info.setCollectionItemInfo(null);
                info.setCollectionInfo(null);
            }
        };
        construct(context, i2, i4, i5, i6);
    }

    private final void construct(Context context, int marginStart, int marginTop, int marginEnd, int marginBottom) {
        this.mCurrentPosition = -1;
        this.mColumNum = context.getResources().getInteger(C7932R.integer.setting_color_picker_column_count);
        this.mSwatchStartMargin = marginStart;
        this.mSwatchTopMargin = marginTop;
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(C7932R.layout.setting_color_swatch_layout, (ViewGroup) this, false);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.GridView");
        GridView gridView = (GridView) viewInflate;
        this.mSwatchView = gridView;
        View view = null;
        if (gridView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwatchView");
            gridView = null;
        }
        gridView.setClipToOutline(true);
        GridView gridView2 = this.mSwatchView;
        if (gridView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwatchView");
            gridView2 = null;
        }
        gridView2.setAccessibilityDelegate(this.mAccessibilityDelegate);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMarginStart(marginStart);
        layoutParams.setMarginEnd(marginEnd);
        layoutParams.topMargin = marginTop;
        layoutParams.bottomMargin = marginBottom;
        View view2 = this.mSwatchView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwatchView");
            view2 = null;
        }
        addView(view2, layoutParams);
        SpenColorSwatchFloatingView spenColorSwatchFloatingView = new SpenColorSwatchFloatingView(context, C7932R.drawable.setting_color_swatch_selected_layout_background);
        this.mSelectedView = spenColorSwatchFloatingView;
        spenColorSwatchFloatingView.setElevation(getResources().getDimensionPixelOffset(C7932R.dimen.setting_color_picker_selector_elevation));
        ViewGroup.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(1, 1);
        View view3 = this.mSelectedView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectedView");
        } else {
            view = view3;
        }
        addView(view, layoutParams2);
        initSwatchList(context);
        initSwatchViewOutline();
    }

    private final int findMatchedSwatch(float hue, float saturation, float value) {
        int iHSVToColor = SpenSettingUtil.HSVToColor(new float[]{hue, saturation, value});
        List<SpenColorSwatchItem> list = this.mSwatchItemList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwatchItemList");
            list = null;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            List<SpenColorSwatchItem> list2 = this.mSwatchItemList;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSwatchItemList");
                list2 = null;
            }
            if (list2.get(i).getMRGBColor() == iHSVToColor) {
                return i;
            }
        }
        return -1;
    }

    private final Rect getChildRect(int pos) {
        if (pos > -1) {
            GridView gridView = this.mSwatchView;
            if (gridView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSwatchView");
                gridView = null;
            }
            View childAt = gridView.getChildAt(pos);
            if (childAt != null) {
                return new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            }
        }
        return null;
    }

    private final void initHoverView() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        SpenColorSwatchFloatingView spenColorSwatchFloatingView = new SpenColorSwatchFloatingView(context, C7932R.drawable.setting_color_swatch_hover_layout_background);
        this.mHoverView = spenColorSwatchFloatingView;
        spenColorSwatchFloatingView.setElevation(getResources().getDimensionPixelOffset(C7932R.dimen.setting_color_picker_hover_elevation));
        addView(this.mHoverView, new RelativeLayout.LayoutParams(1, 1));
    }

    private final void initSwatchList(Context context) {
        List<SpenColorSwatchItem> list;
        String string = context.getResources().getString(C7932R.string.pen_string_button);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        float[] fArr = new float[3];
        this.mSwatchItemList = new ArrayList();
        int i = 0;
        while (true) {
            list = null;
            if (i >= 13) {
                break;
            }
            for (int i2 = 0; i2 < 13; i2++) {
                this.mColorSwatchUtil.getColor(i, i2, fArr);
                SpenColorSwatchItem spenColorSwatchItem = new SpenColorSwatchItem(fArr[0], fArr[1], fArr[2]);
                spenColorSwatchItem.setVoiceAssistant(SpenColorSwatchUtil.getColorName$default(this.mColorSwatchUtil, i, i2, false, 4, null), string);
                List<SpenColorSwatchItem> list2 = this.mSwatchItemList;
                if (list2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSwatchItemList");
                    list2 = null;
                }
                list2.add(spenColorSwatchItem);
            }
            i++;
        }
        List<SpenColorSwatchItem> list3 = this.mSwatchItemList;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwatchItemList");
            list3 = null;
        }
        this.mSwatchAdapter = new SpenColorSwatchAdapter(context, (ArrayList) list3, this.mItemLayoutID);
        GridView gridView = this.mSwatchView;
        if (gridView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwatchView");
            gridView = null;
        }
        SpenColorSwatchAdapter spenColorSwatchAdapter = this.mSwatchAdapter;
        if (spenColorSwatchAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwatchAdapter");
            spenColorSwatchAdapter = null;
        }
        gridView.setAdapter((ListAdapter) spenColorSwatchAdapter);
        GridView gridView2 = this.mSwatchView;
        if (gridView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwatchView");
            gridView2 = null;
        }
        gridView2.setOnItemClickListener(this.mSwatchItemClickListener);
        List<SpenColorSwatchItem> list4 = this.mSwatchItemList;
        if (list4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwatchItemList");
        } else {
            list = list4;
        }
        AbstractC2322a.m1631u(((ArrayList) list).size(), "initSwatchList() tableSize=", TAG);
    }

    private final void initSwatchViewOutline() {
        if (this.mSwatchViewBackgroundObserver == null) {
            this.mDrawRect = new Rect(0, 0, 0, 0);
            this.mSwatchViewBackgroundObserver = new ViewTreeObserverOnGlobalLayoutListenerC7542d(this, 0);
        }
        GridView gridView = this.mSwatchView;
        if (gridView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwatchView");
            gridView = null;
        }
        gridView.getViewTreeObserver().addOnGlobalLayoutListener(this.mSwatchViewBackgroundObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSwatchViewOutline$lambda$4(final SpenColorSwatchView spenColorSwatchView) {
        Rect childRect = spenColorSwatchView.getChildRect(0);
        List<SpenColorSwatchItem> list = spenColorSwatchView.mSwatchItemList;
        GridView gridView = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwatchItemList");
            list = null;
        }
        Rect childRect2 = spenColorSwatchView.getChildRect(list.size() - 1);
        if (childRect == null || childRect2 == null) {
            return;
        }
        Rect rect = new Rect(childRect);
        rect.union(childRect2);
        Log.i(TAG, AbstractC0622a.m1164j(rect.width(), rect.height(), "onGlobalLayout() initSwatchViewOutline (w,h) = (", ",", ")"));
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        Rect rect2 = spenColorSwatchView.mDrawRect;
        if (rect2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDrawRect");
            rect2 = null;
        }
        if (Intrinsics.areEqual(rect2, rect)) {
            spenColorSwatchView.releaseBackgroundObserver();
            return;
        }
        Rect rect3 = spenColorSwatchView.mDrawRect;
        if (rect3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDrawRect");
            rect3 = null;
        }
        rect3.set(rect);
        GridView gridView2 = spenColorSwatchView.mSwatchView;
        if (gridView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwatchView");
        } else {
            gridView = gridView2;
        }
        gridView.setOutlineProvider(new ViewOutlineProvider() { // from class: com.samsung.android.sdk.pen.setting.colorpicker.SpenColorSwatchView$initSwatchViewOutline$1$1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(outline, "outline");
                Rect rect4 = this.this$0.mDrawRect;
                if (rect4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDrawRect");
                    rect4 = null;
                }
                outline.setRoundRect(rect4, this.this$0.getContext().getResources().getDimensionPixelSize(C7932R.dimen.setting_color_picker_layout_color_swatch_radius));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mSwatchItemClickListener$lambda$0(SpenColorSwatchView spenColorSwatchView, AdapterView adapterView, View view, int i, long j) {
        spenColorSwatchView.releaseDetected();
        spenColorSwatchView.updatePosition(i);
    }

    private final void needUpdate(int position) {
        AbstractC2322a.m1631u(position, "needUpdate() pos=", TAG);
        this.mReqPosIndex = position;
        if (this.mSwatchViewObserver == null) {
            this.mSwatchViewObserver = new ViewTreeObserverOnGlobalLayoutListenerC7542d(this, 1);
            GridView gridView = this.mSwatchView;
            if (gridView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSwatchView");
                gridView = null;
            }
            gridView.getViewTreeObserver().addOnGlobalLayoutListener(this.mSwatchViewObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void needUpdate$lambda$3(SpenColorSwatchView spenColorSwatchView) {
        if (spenColorSwatchView.mSwatchViewObserver != null) {
            AbstractC0000a.m26w(AbstractC0622a.m1173s(spenColorSwatchView.mReqPosIndex, spenColorSwatchView.mLastPosIndex, "onGlobalLayout() Req=", " mLast=", " mLastCenterX="), TAG, spenColorSwatchView.mLastCenterX);
            Rect childRect = spenColorSwatchView.getChildRect(spenColorSwatchView.mReqPosIndex);
            if (childRect != null) {
                boolean z = spenColorSwatchView.mReqPosIndex == spenColorSwatchView.mLastPosIndex && spenColorSwatchView.mLastCenterX == childRect.centerX();
                if (!z) {
                    spenColorSwatchView.mLastPosIndex = spenColorSwatchView.mReqPosIndex;
                    spenColorSwatchView.mLastCenterX = childRect.centerX();
                }
                AbstractC2322a.m1631u(spenColorSwatchView.mLastPosIndex, "updateSelector() in onGlobalLayout.  mLast=", TAG);
                SpenColorSwatchFloatingView spenColorSwatchFloatingView = spenColorSwatchView.mSelectedView;
                if (spenColorSwatchFloatingView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSelectedView");
                    spenColorSwatchFloatingView = null;
                }
                spenColorSwatchView.updateFloatingView(spenColorSwatchFloatingView, spenColorSwatchView.mLastPosIndex);
                if (z) {
                    spenColorSwatchView.releaseDetected();
                }
            }
        }
    }

    private final void notifyColorChanged(int position) {
        AbstractC2322a.m1631u(position, "onColorSelected() position=", TAG);
        float[] fArr = new float[3];
        this.mColorSwatchUtil.getColor(position / 13, position % 13, fArr);
        SpenPickerColor spenPickerColor = this.mPickerColor;
        if (spenPickerColor != null) {
            float f = fArr[0];
            float f4 = fArr[1];
            AbstractC2821a.m2234y(AbstractC0622a.m1176v("notifyColorChanged() [", f, SQLKeyword.COMMA, f4, SQLKeyword.COMMA), fArr[2], "]", TAG);
            spenPickerColor.setColor(TAG, 255, fArr[0], fArr[1], fArr[2]);
        }
    }

    private final void releaseBackgroundObserver() {
        if (this.mSwatchViewBackgroundObserver != null) {
            GridView gridView = this.mSwatchView;
            if (gridView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSwatchView");
                gridView = null;
            }
            gridView.getViewTreeObserver().removeOnGlobalLayoutListener(this.mSwatchViewBackgroundObserver);
        }
        this.mSwatchViewBackgroundObserver = null;
    }

    private final void releaseDetected() {
        if (this.mSwatchViewObserver != null) {
            Log.i(TAG, "releaseDetected() ");
            GridView gridView = this.mSwatchView;
            if (gridView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSwatchView");
                gridView = null;
            }
            gridView.getViewTreeObserver().removeOnGlobalLayoutListener(this.mSwatchViewObserver);
            this.mSwatchViewObserver = null;
            this.mLastPosIndex = -1;
            this.mReqPosIndex = -1;
            this.mLastCenterX = -1;
        }
    }

    private final void setColor(float hue, float saturation, float value) {
        int iFindMatchedSwatch = findMatchedSwatch(hue, saturation, value);
        SpenColorSwatchAdapter spenColorSwatchAdapter = this.mSwatchAdapter;
        SpenColorSwatchFloatingView spenColorSwatchFloatingView = null;
        if (spenColorSwatchAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwatchAdapter");
            spenColorSwatchAdapter = null;
        }
        spenColorSwatchAdapter.setSelectedPosition(iFindMatchedSwatch);
        if (this.mSwatchViewObserver != null && this.mReqPosIndex != iFindMatchedSwatch) {
            this.mReqPosIndex = iFindMatchedSwatch;
        }
        if (iFindMatchedSwatch != -1 && getChildRect(iFindMatchedSwatch) == null) {
            needUpdate(iFindMatchedSwatch);
            return;
        }
        this.mCurrentPosition = iFindMatchedSwatch;
        SpenColorSwatchFloatingView spenColorSwatchFloatingView2 = this.mSelectedView;
        if (spenColorSwatchFloatingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectedView");
        } else {
            spenColorSwatchFloatingView = spenColorSwatchFloatingView2;
        }
        updateFloatingView(spenColorSwatchFloatingView, iFindMatchedSwatch);
    }

    private final boolean updateFloatingView(SpenColorSwatchFloatingView floatingView, int matchPos) {
        AbstractC2322a.m1631u(matchPos, "updateFloatingView() pos=", TAG);
        if (matchPos == -1) {
            if (floatingView != null) {
                floatingView.setVisibility(8);
            }
            return true;
        }
        Rect childRect = getChildRect(matchPos);
        SpenColorSwatchAdapter spenColorSwatchAdapter = this.mSwatchAdapter;
        SpenColorSwatchAdapter spenColorSwatchAdapter2 = null;
        if (spenColorSwatchAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwatchAdapter");
            spenColorSwatchAdapter = null;
        }
        Integer item = spenColorSwatchAdapter.getItem(matchPos);
        if (childRect == null) {
            Log.i(TAG, " child is null. so return.");
            return false;
        }
        if (floatingView != null) {
            floatingView.updateView(childRect, this.mSwatchStartMargin, this.mSwatchTopMargin);
        }
        if (floatingView != null) {
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type kotlin.Int");
            floatingView.updateColor(item.intValue());
        }
        if (floatingView != null) {
            SpenColorSwatchAdapter spenColorSwatchAdapter3 = this.mSwatchAdapter;
            if (spenColorSwatchAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSwatchAdapter");
                spenColorSwatchAdapter3 = null;
            }
            SpenColorSwatchAdapter spenColorSwatchAdapter4 = this.mSwatchAdapter;
            if (spenColorSwatchAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSwatchAdapter");
            } else {
                spenColorSwatchAdapter2 = spenColorSwatchAdapter4;
            }
            floatingView.setContentDescription(spenColorSwatchAdapter3.getContentDescription(matchPos, matchPos == spenColorSwatchAdapter2.getMSelectedPosition()));
        }
        if (floatingView != null) {
            floatingView.requestFocus();
        }
        if (floatingView != null) {
            floatingView.sendAccessibilityEvent(8);
        }
        return true;
    }

    private final void updatePosition(int pos) {
        SpenColorSwatchAdapter spenColorSwatchAdapter = this.mSwatchAdapter;
        SpenColorSwatchFloatingView spenColorSwatchFloatingView = null;
        if (spenColorSwatchAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwatchAdapter");
            spenColorSwatchAdapter = null;
        }
        spenColorSwatchAdapter.setSelectedPosition(pos);
        notifyColorChanged(pos);
        this.mCurrentPosition = pos;
        SpenColorSwatchFloatingView spenColorSwatchFloatingView2 = this.mSelectedView;
        if (spenColorSwatchFloatingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectedView");
        } else {
            spenColorSwatchFloatingView = spenColorSwatchFloatingView2;
        }
        updateFloatingView(spenColorSwatchFloatingView, pos);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(@NotNull MotionEvent event) {
        SpenColorSwatchFloatingView spenColorSwatchFloatingView;
        SpenColorSwatchFloatingView spenColorSwatchFloatingView2;
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.mHoverView == null) {
            initHoverView();
        }
        int action = event.getAction();
        if (action != 7 && action != 9) {
            if (action != 10 || (spenColorSwatchFloatingView2 = this.mHoverView) == null) {
                return true;
            }
            spenColorSwatchFloatingView2.setVisibility(8);
            return true;
        }
        GridView gridView = this.mSwatchView;
        GridView gridView2 = null;
        if (gridView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwatchView");
            gridView = null;
        }
        int iPointToPosition = gridView.pointToPosition(((int) event.getX()) - this.mSwatchStartMargin, ((int) event.getY()) - this.mSwatchTopMargin);
        if (iPointToPosition >= 0) {
            GridView gridView3 = this.mSwatchView;
            if (gridView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSwatchView");
            } else {
                gridView2 = gridView3;
            }
            if (iPointToPosition < gridView2.getChildCount()) {
                if (iPointToPosition == this.mCurrentHoverPosition && ((spenColorSwatchFloatingView = this.mHoverView) == null || spenColorSwatchFloatingView.getVisibility() != 8)) {
                    return true;
                }
                this.mCurrentHoverPosition = iPointToPosition;
                updateFloatingView(this.mHoverView, iPointToPosition);
                return true;
            }
        }
        SpenColorSwatchFloatingView spenColorSwatchFloatingView3 = this.mHoverView;
        if (spenColorSwatchFloatingView3 == null) {
            return true;
        }
        spenColorSwatchFloatingView3.setVisibility(8);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev) {
        SpenColorViewTouchUpListener spenColorViewTouchUpListener;
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getAction() == 0) {
            this.mIsTouchInArea = true;
        }
        Rect rect = new Rect();
        GridView gridView = this.mSwatchView;
        GridView gridView2 = null;
        if (gridView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwatchView");
            gridView = null;
        }
        gridView.getHitRect(rect);
        if (!rect.contains((int) ev.getX(), (int) ev.getY())) {
            if (this.mIsTouchInArea) {
                this.mIsTouchInArea = false;
                SpenColorViewTouchUpListener spenColorViewTouchUpListener2 = this.mTouchUpListener;
                if (spenColorViewTouchUpListener2 != null) {
                    spenColorViewTouchUpListener2.onTouchUp();
                }
            }
            return true;
        }
        if (!this.mIsTouchInArea) {
            this.mIsTouchInArea = true;
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        releaseDetected();
        GridView gridView3 = this.mSwatchView;
        if (gridView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwatchView");
            gridView3 = null;
        }
        int iPointToPosition = gridView3.pointToPosition(((int) ev.getX()) - this.mSwatchStartMargin, ((int) ev.getY()) - this.mSwatchTopMargin);
        if (iPointToPosition >= 0) {
            GridView gridView4 = this.mSwatchView;
            if (gridView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSwatchView");
            } else {
                gridView2 = gridView4;
            }
            if (iPointToPosition < gridView2.getChildCount() && iPointToPosition != this.mCurrentPosition) {
                updatePosition(iPointToPosition);
            }
        }
        int action = ev.getAction();
        if (action != 0) {
            if (action == 1 && (spenColorViewTouchUpListener = this.mTouchUpListener) != null) {
                spenColorViewTouchUpListener.onTouchUp();
            }
        } else if (getParent() != null) {
            Object parent = getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            ((View) parent).playSoundEffect(0);
        }
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorViewInterface
    public void release() {
        releaseDetected();
        SpenPickerColor spenPickerColor = this.mPickerColor;
        if (spenPickerColor != null) {
            spenPickerColor.removeEventListener(this);
        }
        this.mPickerColor = null;
        releaseBackgroundObserver();
        this.mHoverView = null;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorViewInterface
    public void setPickerColor(@NotNull SpenPickerColor pickerColor) {
        Intrinsics.checkNotNullParameter(pickerColor, "pickerColor");
        this.mPickerColor = pickerColor;
        float[] fArr = {0.0f, 0.0f, 0.0f};
        if (pickerColor != null) {
            pickerColor.getColor(fArr);
        }
        setColor(fArr[0], fArr[1], fArr[2]);
        SpenPickerColor spenPickerColor = this.mPickerColor;
        if (spenPickerColor != null) {
            spenPickerColor.addEventListener(this);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorViewInterface
    public void setTouchUpListener(@Nullable SpenColorViewTouchUpListener listener) {
        this.mTouchUpListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenPickerColorEventListener
    public void update(@Nullable String who, int color, float hue, float saturation, float value) {
        if (Intrinsics.areEqual(who, TAG)) {
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        StringBuilder sbM16m = AbstractC0000a.m16m("update() who=", who, ", color=", AbstractC2322a.m1624n("%X", new Object[]{Integer.valueOf(color)}, 1, "format(format, *args)"), ", [");
        AbstractC11014a.m12337v(sbM16m, hue, SQLKeyword.COMMA, saturation, SQLKeyword.COMMA);
        AbstractC2821a.m2234y(sbM16m, value, "]", TAG);
        setColor(hue, saturation, value);
    }
}
