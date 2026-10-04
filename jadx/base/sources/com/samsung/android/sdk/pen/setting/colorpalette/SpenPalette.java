package com.samsung.android.sdk.pen.setting.colorpalette;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.GridLayout;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.material.carousel.RunnableC4617a;
import com.google.android.material.oneui.floatingdock.ViewOnTouchListenerC4799j;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenChildButtonInfo;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 G2\u00020\u0001:\u0002GHB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0014J\u0006\u0010%\u001a\u00020 J\u0016\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0005J\u0016\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020,J\u0016\u0010-\u001a\u00020 2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020 2\u0006\u0010*\u001a\u00020\u0005J\u001e\u00101\u001a\u00020 2\u0006\u0010*\u001a\u00020\u00052\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000203J\u0010\u00105\u001a\u00020 2\b\u00106\u001a\u0004\u0018\u00010\u0016J\u0016\u00107\u001a\u0002032\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u0005J\u0016\u0010:\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010;\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0018\u0010<\u001a\u00020 2\u0006\u0010=\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0005H\u0002J\"\u0010?\u001a\u00020 2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010C\u001a\u00020 H\u0002J\u0010\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020FH\u0002R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPalette;", "Landroid/widget/GridLayout;", "context", "Landroid/content/Context;", "childSize", "", "childPadding", "<init>", "(Landroid/content/Context;II)V", "mChildSize", "mChildPadding", "mHorizontalSpacing", "mVerticalSpacing", "mSelectorDegree", "mSelectorFlip", "mRow", "mCol", "mDownX", "", "mDownY", "mTouchSlope", "mOnActionListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPalette$OnActionListener;", "mChildInfo", "Ljava/util/HashMap;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenChildButtonInfo;", "Lkotlin/collections/HashMap;", "mTouchListener", "Landroid/view/View$OnTouchListener;", "mChildClickListener", "Landroid/view/View$OnClickListener;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "close", "setInfo", "row", "col", "setColor", "childAt", "colorInfo", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteColorInfo;", "setRes", "resInfo", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteResInfo;", "setInit", "setSelected", "selected", "", "needAnimation", "setActionListener", "onActionListener", "setSelectorDegree", "flipDir", "degree", "setChildSize", "construct", "decideChild", "width", "height", "setChildButton", "colorView", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorView;", "info", "updateChildMargin", "getChildIndex", VPathDataCmd.RCurveTo, "Landroid/view/View;", "Companion", "OnActionListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenPalette.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenPalette.kt\ncom/samsung/android/sdk/pen/setting/colorpalette/SpenPalette\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,328:1\n1#2:329\n*E\n"})
public final class SpenPalette extends GridLayout {

    @NotNull
    private static final String TAG = "SpenPalette";

    @NotNull
    private final View.OnClickListener mChildClickListener;

    @Nullable
    private HashMap<Integer, SpenChildButtonInfo> mChildInfo;
    private int mChildPadding;
    private int mChildSize;
    private int mCol;
    private float mDownX;
    private float mDownY;
    private int mHorizontalSpacing;

    @Nullable
    private OnActionListener mOnActionListener;
    private int mRow;
    private int mSelectorDegree;
    private int mSelectorFlip;

    @NotNull
    private final View.OnTouchListener mTouchListener;
    private float mTouchSlope;
    private int mVerticalSpacing;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPalette$OnActionListener;", "", "onButtonClick", "", "viewgroup", "Landroid/view/ViewGroup;", VPathDataCmd.RCurveTo, "Landroid/view/View;", "position", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnActionListener {
        void onButtonClick(@Nullable ViewGroup viewgroup, @Nullable View v, int position);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SpenChildButtonInfo.ButtonType.values().length];
            try {
                iArr[SpenChildButtonInfo.ButtonType.COLOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SpenChildButtonInfo.ButtonType.RES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPalette(@NotNull Context context, int i, int i2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTouchListener = new ViewOnTouchListenerC4799j(this, 5);
        this.mChildClickListener = new ViewOnClickListenerC7538b(this, 0);
        setChildSize(i, i2);
        construct(context);
    }

    private final void construct(Context context) {
        this.mHorizontalSpacing = 0;
        this.mVerticalSpacing = 0;
        this.mSelectorDegree = 0;
        this.mSelectorFlip = 0;
        this.mTouchSlope = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mChildInfo = null;
    }

    private final void decideChild(int width, int height) {
        int columnCount = width - (getColumnCount() * this.mChildSize);
        int rowCount = height - (getRowCount() * this.mChildSize);
        this.mHorizontalSpacing = getColumnCount() > 1 ? columnCount / (getColumnCount() - 1) : 0;
        int rowCount2 = getRowCount() > 1 ? rowCount / (getRowCount() - 1) : 0;
        this.mVerticalSpacing = rowCount2;
        AbstractC0000a.m26w(AbstractC0622a.m1173s(this.mChildSize, this.mHorizontalSpacing, "childSize=", " horizontalSpacing=", " verticalSpacing="), TAG, rowCount2);
        int i = this.mRow;
        if (i == 0) {
            updateChildMargin();
        } else {
            int i2 = this.mHorizontalSpacing;
            if (i2 < 0) {
                i2 = 0;
            }
            int i4 = this.mVerticalSpacing;
            if (i4 < 0) {
                i4 = 0;
            }
            int i5 = i * this.mCol;
            for (int i6 = 0; i6 < i5; i6++) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                SpenColorView spenColorView = new SpenColorView(context);
                spenColorView.setId(View.generateViewId());
                int i7 = this.mChildPadding;
                spenColorView.setPadding(i7, i7, i7, i7);
                int i8 = this.mChildSize;
                GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(new ViewGroup.LayoutParams(i8, i8));
                layoutParams.setMarginStart(i6 % getColumnCount() != 0 ? i2 : 0);
                layoutParams.topMargin = i6 / getColumnCount() != 0 ? i4 : 0;
                spenColorView.setTag(String.valueOf(i6));
                addView(spenColorView, layoutParams);
                HashMap<Integer, SpenChildButtonInfo> map = this.mChildInfo;
                if (map != null) {
                    Intrinsics.checkNotNull(map);
                    setChildButton(i6, spenColorView, map.get(Integer.valueOf(i6)));
                }
            }
            this.mRow = 0;
            this.mCol = 0;
            HashMap<Integer, SpenChildButtonInfo> map2 = this.mChildInfo;
            if (map2 != null) {
                map2.clear();
                this.mChildInfo = null;
            }
            int i9 = this.mSelectorDegree;
            if (i9 != 0) {
                setSelectorDegree(this.mSelectorFlip, i9);
            }
        }
        new Handler().post(new RunnableC4617a(this, 22));
    }

    private final int getChildIndex(View v) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (Intrinsics.areEqual(getChildAt(i), v)) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mChildClickListener$lambda$1(SpenPalette spenPalette, View view) {
        int childIndex;
        OnActionListener onActionListener;
        if (view.getTag() != null) {
            Object tag = view.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.String");
            childIndex = Integer.parseInt((String) tag);
        } else {
            Intrinsics.checkNotNull(view);
            childIndex = spenPalette.getChildIndex(view);
        }
        if (childIndex == -1 || (onActionListener = spenPalette.mOnActionListener) == null) {
            return;
        }
        onActionListener.onButtonClick(spenPalette, view, childIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mTouchListener$lambda$0(SpenPalette spenPalette, View view, MotionEvent motionEvent) {
        if (spenPalette.getParent() instanceof SpenViewFlipper) {
            if (motionEvent.getAction() == 2) {
                if (motionEvent.getX() > 0.0f && motionEvent.getX() < view.getWidth() && motionEvent.getY() > 0.0f && motionEvent.getY() < view.getHeight()) {
                    double x = spenPalette.mDownX - motionEvent.getX();
                    double y2 = spenPalette.mDownY - motionEvent.getY();
                    if (Math.abs(x) < Math.abs(y2) && Math.abs(y2) > spenPalette.mTouchSlope) {
                        spenPalette.getParent().getParent().requestDisallowInterceptTouchEvent(false);
                    } else if (Math.abs(x) > Math.abs(y2) && Math.abs(x) > spenPalette.mTouchSlope) {
                        spenPalette.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
            } else if (motionEvent.getAction() == 0) {
                spenPalette.mDownX = motionEvent.getX();
                spenPalette.mDownY = motionEvent.getY();
            }
        }
        return false;
    }

    private final void setChildButton(int childAt, SpenColorView colorView, SpenChildButtonInfo info) {
        if (info == null) {
            setInit(childAt);
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[info.getType().ordinal()];
        if (i == 1) {
            SpenPaletteColorInfo colorInfo = info.getColorInfo();
            if (colorInfo != null) {
                setColor(childAt, colorInfo);
            }
            colorView.setSelected(info.getIsSelected(), false);
            return;
        }
        if (i != 2) {
            return;
        }
        SpenPaletteResInfo resInfo = info.getResInfo();
        if (resInfo != null) {
            setRes(childAt, resInfo);
        }
        colorView.setSelected(info.getIsSelected(), false);
    }

    private final void updateChildMargin() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.GridLayout.LayoutParams");
            GridLayout.LayoutParams layoutParams2 = (GridLayout.LayoutParams) layoutParams;
            layoutParams2.setMarginStart(i % getColumnCount() != 0 ? this.mHorizontalSpacing : 0);
            layoutParams2.topMargin = i / getColumnCount() != 0 ? this.mVerticalSpacing : 0;
            childAt.setLayoutParams(layoutParams2);
        }
    }

    public final void close() {
        Log.i(TAG, "close()");
        this.mOnActionListener = null;
        HashMap<Integer, SpenChildButtonInfo> map = this.mChildInfo;
        if (map != null) {
            map.clear();
        }
        this.mChildInfo = null;
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.i(TAG, AbstractC2322a.m1625o(AbstractC0622a.m1173s(oldw, oldh, "onSizeChanged() old[", SQLKeyword.COMMA, "] new["), w, h, SQLKeyword.COMMA, "]"));
        decideChild(w, h);
    }

    public final void setActionListener(@Nullable OnActionListener onActionListener) {
        this.mOnActionListener = onActionListener;
    }

    public final void setChildSize(int childSize, int childPadding) {
        boolean z = (this.mChildSize == childSize && this.mChildPadding == childPadding) ? false : true;
        this.mChildSize = childSize;
        this.mChildPadding = childPadding;
        if (!z || getChildCount() <= 0) {
            return;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.colorpalette.SpenColorView");
            SpenColorView spenColorView = (SpenColorView) childAt;
            int i2 = this.mChildPadding;
            spenColorView.setPadding(i2, i2, i2, i2);
            ViewGroup.LayoutParams layoutParams = spenColorView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.GridLayout.LayoutParams");
            GridLayout.LayoutParams layoutParams2 = (GridLayout.LayoutParams) layoutParams;
            int i4 = this.mChildSize;
            layoutParams2.width = i4;
            layoutParams2.height = i4;
            spenColorView.setLayoutParams(layoutParams2);
        }
    }

    public final void setColor(int childAt, @NotNull SpenPaletteColorInfo colorInfo) {
        Intrinsics.checkNotNullParameter(colorInfo, "colorInfo");
        if (getChildCount() > childAt) {
            View childAt2 = getChildAt(childAt);
            Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.colorpalette.SpenColorView");
            SpenColorView spenColorView = (SpenColorView) childAt2;
            spenColorView.setColor(colorInfo.getColor(), colorInfo.getOpacity(), colorInfo.getColorName());
            spenColorView.setOnClickListener(this.mChildClickListener);
            spenColorView.setClickable(true);
            spenColorView.setFocusable(true);
            spenColorView.setSelected(false);
            spenColorView.setOnTouchListener(this.mTouchListener);
            return;
        }
        HashMap<Integer, SpenChildButtonInfo> map = this.mChildInfo;
        if (map != null) {
            SpenChildButtonInfo spenChildButtonInfo = map.get(Integer.valueOf(childAt));
            if (spenChildButtonInfo != null && spenChildButtonInfo.getType() == SpenChildButtonInfo.ButtonType.COLOR) {
                spenChildButtonInfo.setColorInfo(colorInfo);
                return;
            }
            if (spenChildButtonInfo != null) {
                Log.i(TAG, "+++++++++++++ Is possible? ");
            }
            map.put(Integer.valueOf(childAt), new SpenChildButtonInfo(colorInfo));
        }
    }

    public final void setInfo(int row, int col) {
        setColumnCount(col);
        setRowCount(row);
        AbstractC0000a.m26w(AbstractC0622a.m1173s(row, col, "setInfo() row=", " col=", " childSize="), TAG, this.mChildSize);
        if (this.mChildSize <= 0) {
            this.mRow = row;
            this.mCol = col;
            this.mChildInfo = new HashMap<>();
            return;
        }
        int i = row * col;
        for (int i2 = 0; i2 < i; i2++) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            SpenColorView spenColorView = new SpenColorView(context);
            spenColorView.setId(View.generateViewId());
            int i4 = this.mChildPadding;
            spenColorView.setPadding(i4, i4, i4, i4);
            int i5 = this.mChildSize;
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(new ViewGroup.LayoutParams(i5, i5));
            spenColorView.setTag(String.valueOf(i2));
            addView(spenColorView, layoutParams);
        }
    }

    public final void setInit(int childAt) {
        if (getChildCount() <= childAt) {
            HashMap<Integer, SpenChildButtonInfo> map = this.mChildInfo;
            if (map == null || !map.containsKey(Integer.valueOf(childAt))) {
                return;
            }
            map.remove(Integer.valueOf(childAt));
            return;
        }
        View childAt2 = getChildAt(childAt);
        Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.colorpalette.SpenColorView");
        SpenColorView spenColorView = (SpenColorView) childAt2;
        spenColorView.setInit();
        spenColorView.setOnClickListener(null);
        spenColorView.setClickable(false);
        spenColorView.setFocusable(false);
        spenColorView.setSelected(false);
    }

    public final void setRes(int childAt, @NotNull SpenPaletteResInfo resInfo) {
        Intrinsics.checkNotNullParameter(resInfo, "resInfo");
        if (getChildCount() > childAt) {
            View childAt2 = getChildAt(childAt);
            Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.colorpalette.SpenColorView");
            SpenColorView spenColorView = (SpenColorView) childAt2;
            spenColorView.setColorRes(resInfo.getResourceId());
            spenColorView.setHoverDescription(resInfo.getHoverDescription());
            spenColorView.setOnClickListener(this.mChildClickListener);
            spenColorView.setClickable(true);
            spenColorView.setFocusable(true);
            spenColorView.setSelected(false);
            return;
        }
        HashMap<Integer, SpenChildButtonInfo> map = this.mChildInfo;
        if (map != null) {
            SpenChildButtonInfo spenChildButtonInfo = map.get(Integer.valueOf(childAt));
            if (spenChildButtonInfo != null && spenChildButtonInfo.getType() == SpenChildButtonInfo.ButtonType.RES) {
                spenChildButtonInfo.setResInfo(resInfo);
                return;
            }
            if (spenChildButtonInfo != null) {
                Log.i(TAG, "setRes() childInfo is not null.");
            }
            map.put(Integer.valueOf(childAt), new SpenChildButtonInfo(resInfo));
        }
    }

    public final void setSelected(int childAt, boolean selected, boolean needAnimation) {
        SpenChildButtonInfo spenChildButtonInfo;
        if (getChildCount() > childAt) {
            View childAt2 = getChildAt(childAt);
            Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.colorpalette.SpenColorView");
            ((SpenColorView) childAt2).setSelected(selected, needAnimation);
        } else {
            HashMap<Integer, SpenChildButtonInfo> map = this.mChildInfo;
            if (map == null || (spenChildButtonInfo = map.get(Integer.valueOf(childAt))) == null) {
                return;
            }
            spenChildButtonInfo.setSelected(selected);
        }
    }

    public final boolean setSelectorDegree(int flipDir, int degree) {
        if (degree % 90 != 0) {
            AbstractC2322a.m1631u(degree, "Not support degree=", TAG);
            return false;
        }
        this.mSelectorDegree = degree;
        this.mSelectorFlip = flipDir;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.colorpalette.SpenColorView");
            SpenColorView spenColorView = (SpenColorView) childAt;
            spenColorView.resetDegree();
            spenColorView.setSelectorDegree(flipDir, degree);
            spenColorView.setResourceDegree(flipDir, degree);
        }
        return true;
    }
}
