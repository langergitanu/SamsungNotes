package com.samsung.android.sdk.pen.setting.colorpalette;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0001QB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tJ\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 H\u0016J(\u0010!\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J \u0010!\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020(H\u0016J(\u0010)\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000bH\u0016J0\u0010)\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000bH\u0016J2\u0010)\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000b2\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010,\u001a\u00020\u000bH\u0016J(\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u00101\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 H\u0016J,\u00102\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000b2\b\u00104\u001a\u0004\u0018\u0001052\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0018\u00106\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0016J\u001a\u00107\u001a\u0004\u0018\u0001052\u0006\u00100\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0016J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020\u000b09H\u0016J\u000e\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000b09H\u0016J\b\u0010;\u001a\u00020\u000bH\u0016J\u000e\u0010<\u001a\u00020 2\u0006\u0010=\u001a\u00020\u000bJ\u0010\u0010>\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u000bH\u0016J\u0006\u0010@\u001a\u00020\u0017J\u0012\u0010A\u001a\u0004\u0018\u00010\u00142\u0006\u0010B\u001a\u00020\u000bH\u0002J\u0010\u0010C\u001a\u00020 2\u0006\u0010B\u001a\u00020\u000bH\u0002J\u0010\u0010D\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020FH\u0002J\b\u0010G\u001a\u00020\u0017H\u0002J\u0010\u0010H\u001a\u00020\u00172\u0006\u0010I\u001a\u00020 H\u0002J\u0018\u0010J\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020 2\u0006\u0010L\u001a\u00020 H\u0002J \u0010M\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u000b2\u0006\u0010O\u001a\u00020 H\u0002J\u001a\u0010P\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewV3;", "Landroid/widget/LinearLayout;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewInterface;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mPaletteChildCount", "", "mActionListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewActionListener;", "mItemWidth", "mItemHeight", "mBetweenMargin", "mPaletteCornerRadius", "mPalettePage", "", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenRectPalette;", "mCurrentPage", "setPaletteActionListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getPageCount", "setPaletteInfo", "totalPage", "getCurrentPage", "setPage", "pageIdx", "needAnimation", "", "setColor", "childAt", "color", "", "colorName", "", "colorInfo", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteColorInfo;", "setResource", "resId", "hoverStringId", "selectorId", "hoverDescription", "", "setSelected", "pageIndex", "selected", "setIndicator", "size", "background", "Landroid/graphics/drawable/Drawable;", "resetColor", "getSelectorDrawable", "getSwipeChildIndex", "", "getFixedChildIndex", "getVersion", "setSelectorDegree", "degree", "setPaletteCornerRadius", "radius", "close", "getPalette", "index", "outOfPageRange", "getPaletteIndex", "palette", "Landroid/view/View;", "construct", "clearPalette", "removed", "getCornerType", "isFirst", "isRTL", "notifyButtonClick", "position", "isSelected", "setAttributes", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenPaletteViewV3.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenPaletteViewV3.kt\ncom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewV3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,256:1\n1#2:257\n*E\n"})
public final class SpenPaletteViewV3 extends LinearLayout implements SpenPaletteViewInterface {
    private static final int DEFAULT_CHILD_COUNT = 8;

    @NotNull
    private static final String TAG = "SpenPaletteViewV3";

    @Nullable
    private SpenPaletteViewActionListener mActionListener;
    private int mBetweenMargin;
    private int mCurrentPage;
    private int mItemHeight;
    private int mItemWidth;
    private int mPaletteChildCount;
    private int mPaletteCornerRadius;

    @Nullable
    private List<SpenRectPalette> mPalettePage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPaletteViewV3(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPaletteChildCount = -1;
        setAttributes(context, null);
        construct();
    }

    private final void clearPalette(boolean removed) {
        List<SpenRectPalette> list = this.mPalettePage;
        if (list == null || list.size() == 0) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            SpenRectPalette spenRectPalette = list.get(i);
            spenRectPalette.close();
            removeView(spenRectPalette);
        }
        list.clear();
        this.mCurrentPage = -1;
        if (removed) {
            this.mPalettePage = null;
        }
    }

    private final void construct() {
        setOrientation(1);
        this.mPalettePage = new ArrayList();
        this.mCurrentPage = -1;
    }

    private final int getCornerType(boolean isFirst, boolean isRTL) {
        return isFirst != isRTL ? 9 : 6;
    }

    private final SpenRectPalette getPalette(int index) {
        List<SpenRectPalette> list;
        if (outOfPageRange(index) || (list = this.mPalettePage) == null) {
            return null;
        }
        return list.get(index);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getPaletteIndex(View palette) {
        List<SpenRectPalette> list = this.mPalettePage;
        if (list != null) {
            return CollectionsKt.indexOf((List<? extends View>) list, palette);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyButtonClick(int pageIndex, int position, boolean isSelected) {
        if (this.mActionListener == null || pageIndex == -1) {
            return;
        }
        AbstractC0000a.m27x(AbstractC0622a.m1173s(pageIndex, position, "notifyButtonClick() pageIndex=", " position=", " isSelected="), isSelected, TAG);
        SpenPaletteViewActionListener spenPaletteViewActionListener = this.mActionListener;
        if (spenPaletteViewActionListener != null) {
            spenPaletteViewActionListener.onButtonClick(pageIndex, position, isSelected);
        }
    }

    private final boolean outOfPageRange(int index) {
        List<SpenRectPalette> list = this.mPalettePage;
        return list == null || index < -1 || index >= list.size();
    }

    private final void setAttributes(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, C7932R.styleable.SpenPaletteViewV3, 0, 0);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            this.mItemWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(C7932R.styleable.SpenPaletteViewV3_itemWidth, 0);
            this.mItemHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(C7932R.styleable.SpenPaletteViewV3_itemHeight, 0);
            this.mBetweenMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(C7932R.styleable.SpenPaletteViewV3_itemBetweenMargin, 0);
            this.mPaletteCornerRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(C7932R.styleable.SpenPaletteViewV3_paletteCornerRadius, 0);
            this.mPaletteChildCount = typedArrayObtainStyledAttributes.getInt(C7932R.styleable.SpenPaletteViewV3_itemCount, 8);
            typedArrayObtainStyledAttributes.recycle();
        } else {
            this.mItemWidth = 0;
            this.mItemHeight = 0;
            this.mBetweenMargin = 0;
            this.mPaletteCornerRadius = 0;
            if (this.mPaletteChildCount == -1) {
                this.mPaletteChildCount = 8;
            }
        }
        int i = this.mItemWidth;
        int i2 = this.mItemHeight;
        int i4 = this.mBetweenMargin;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "setAttributes() itemWidth=", ", itemHeight=", " betweenMargin=");
        sbM1173s.append(i4);
        Log.i(TAG, sbM1173s.toString());
        Resources resources = context.getResources();
        if (this.mItemWidth == 0) {
            this.mItemWidth = resources.getDimensionPixelOffset(C7932R.dimen.setting_color_extend_chip_width);
        }
        if (this.mItemHeight == 0) {
            this.mItemHeight = resources.getDimensionPixelOffset(C7932R.dimen.setting_color_extend_chip_height);
        }
        if (this.mBetweenMargin == 0) {
            this.mBetweenMargin = resources.getDimensionPixelSize(C7932R.dimen.setting_color_extend_chip_between_margin);
        }
    }

    public final void close() {
        this.mActionListener = null;
        clearPalette(true);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    /* JADX INFO: renamed from: getCurrentPage, reason: from getter */
    public int getMCurrentPage() {
        return this.mCurrentPage;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    @NotNull
    public List<Integer> getFixedChildIndex() {
        return new ArrayList();
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public int getPageCount() {
        List<SpenRectPalette> list = this.mPalettePage;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    /* JADX INFO: renamed from: getPaletteCornerRadius */
    public int getMPaletteCornerRadius() {
        return SpenPaletteViewInterface.DefaultImpls.getPaletteCornerRadius(this);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    /* JADX INFO: renamed from: getPaletteOrientation */
    public int getMPaletteOrientation() {
        return SpenPaletteViewInterface.DefaultImpls.getPaletteOrientation(this);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    @Nullable
    public Drawable getSelectorDrawable(int pageIndex, int childAt) {
        return null;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    @NotNull
    public List<Integer> getSwipeChildIndex() {
        ArrayList arrayList = new ArrayList();
        int i = this.mPaletteChildCount;
        for (int iM1200a = 0; iM1200a < i; iM1200a = AbstractC1038a.m1200a(iM1200a, iM1200a, 1, arrayList)) {
        }
        return arrayList;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public int getVersion() {
        return 70;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public void resetColor(int pageIndex, int childAt) {
        SpenRectPalette palette = getPalette(pageIndex);
        if (palette == null) {
            return;
        }
        palette.setInit(childAt);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public void setColor(int pageIdx, int childAt, @NotNull float[] color, @NotNull String colorName) {
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(colorName, "colorName");
        float f = color[0];
        float f4 = color[1];
        float f5 = color[2];
        StringBuilder sbM1173s = AbstractC0622a.m1173s(pageIdx, childAt, "setColor() pageIndex=", " childAt=", " color[");
        AbstractC11014a.m12337v(sbM1173s, f, ",", f4, ",");
        sbM1173s.append(f5);
        sbM1173s.append(")");
        Log.i(TAG, sbM1173s.toString());
        SpenPaletteColorInfo spenPaletteColorInfo = new SpenPaletteColorInfo();
        spenPaletteColorInfo.setColor(color, 255, colorName);
        setColor(pageIdx, childAt, spenPaletteColorInfo);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public void setPaletteActionListener(@Nullable SpenPaletteViewActionListener listener) {
        this.mActionListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public void setPaletteCornerRadius(int radius) {
        this.mPaletteCornerRadius = radius;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public void setPaletteInfo(int totalPage) {
        int cornerType;
        int cornerType2;
        AbstractC2322a.m1631u(totalPage, "setPaletteInfo() totalPage = ", TAG);
        clearPalette(false);
        Resources resources = getContext().getResources();
        int i = 1;
        if (this.mPaletteCornerRadius > 0) {
            boolean z = resources.getConfiguration().getLayoutDirection() == 1;
            cornerType2 = getCornerType(true, z);
            cornerType = getCornerType(false, z);
        } else {
            cornerType = 0;
            cornerType2 = 0;
        }
        int dimensionPixelOffset = resources.getDimensionPixelOffset(C7932R.dimen.setting_change_extend_chip_unselected_margin_start_end);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(C7932R.dimen.setting_change_extend_chip_unselected_margin_top);
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(C7932R.dimen.setting_change_extend_chip_unselected_margin_bottom);
        int i2 = 0;
        while (i2 < totalPage) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            int i4 = i;
            SpenRectPalette spenRectPalette = new SpenRectPalette(context, this.mPaletteChildCount, this.mItemWidth, this.mItemHeight, this.mBetweenMargin, this.mPaletteCornerRadius);
            spenRectPalette.setUnSelectedChildLayout(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset3);
            int i5 = this.mPaletteCornerRadius;
            if (i5 > 0) {
                spenRectPalette.setChildCornerRadius(0, cornerType2, i5);
                spenRectPalette.setChildCornerRadius(this.mPaletteChildCount - 1, cornerType, this.mPaletteCornerRadius);
            }
            spenRectPalette.setActionListener(new SpenPaletteActionListener() { // from class: com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewV3.setPaletteInfo.1
                @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteActionListener
                public void onButtonClick(ViewGroup viewgroup, View v, int position) {
                    Intrinsics.checkNotNullParameter(viewgroup, "viewgroup");
                    Intrinsics.checkNotNullParameter(v, "v");
                    SpenPaletteViewV3 spenPaletteViewV3 = SpenPaletteViewV3.this;
                    spenPaletteViewV3.notifyButtonClick(spenPaletteViewV3.getPaletteIndex(viewgroup), position, v.isSelected());
                }
            });
            LinearLayoutCompat.LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(-1, -2);
            ((LinearLayout.LayoutParams) layoutParams).gravity = i4;
            addView(spenRectPalette, layoutParams);
            List<SpenRectPalette> list = this.mPalettePage;
            if (list != null) {
                list.add(spenRectPalette);
            }
            i2++;
            i = i4;
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public void setResource(int pageIdx, int childAt, int resId, int hoverStringId) {
        setResource(pageIdx, childAt, resId, hoverStringId, 0);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public void setSelected(int pageIndex, int childAt, boolean selected, boolean needAnimation) {
        AbstractC0000a.m27x(AbstractC0622a.m1173s(pageIndex, childAt, "setSelected() pageIndex=", " childAt=", " selected="), selected, TAG);
        SpenRectPalette palette = getPalette(pageIndex);
        if (palette != null) {
            palette.setSelected(childAt, selected, needAnimation);
        }
    }

    public final boolean setSelectorDegree(int degree) {
        AbstractC2322a.m1631u(degree, "setSelectorDegree() degree=", TAG);
        List<SpenRectPalette> list = this.mPalettePage;
        if (list == null) {
            return true;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            SpenRectPalette palette = getPalette(i);
            if (palette != null) {
                palette.setSelectorDegree(0, degree);
            }
        }
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public void setResource(int pageIdx, int childAt, int resId, int hoverStringId, int selectorId) {
        StringBuilder sbM1173s = AbstractC0622a.m1173s(pageIdx, childAt, "setResource() pageIndex=", " childAt=", " resId=");
        sbM1173s.append(resId);
        sbM1173s.append(" hoverStringId=");
        sbM1173s.append(hoverStringId);
        Log.i(TAG, sbM1173s.toString());
        setResource(pageIdx, childAt, resId, hoverStringId != 0 ? getContext().getResources().getString(hoverStringId) : null, selectorId);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPaletteViewV3(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPaletteChildCount = -1;
        setAttributes(context, attributeSet);
        construct();
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public void setResource(int pageIdx, int childAt, int resId, @Nullable CharSequence hoverDescription, int selectorId) {
        StringBuilder sbM1173s = AbstractC0622a.m1173s(pageIdx, childAt, "setResource() pageIndex=", " childAt=", " resId=");
        sbM1173s.append(resId);
        sbM1173s.append(" hoverDescription=");
        sbM1173s.append((Object) hoverDescription);
        Log.i(TAG, sbM1173s.toString());
        SpenRectPalette palette = getPalette(pageIdx);
        if (palette == null) {
            return;
        }
        SpenPaletteResInfo spenPaletteResInfo = new SpenPaletteResInfo();
        spenPaletteResInfo.setRes(resId, hoverDescription, selectorId);
        palette.setRes(childAt, spenPaletteResInfo);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public void setColor(int pageIdx, int childAt, @NotNull SpenPaletteColorInfo colorInfo) {
        Intrinsics.checkNotNullParameter(colorInfo, "colorInfo");
        SpenRectPalette palette = getPalette(pageIdx);
        if (palette != null) {
            palette.setColor(childAt, colorInfo);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public void setPage(int pageIdx, boolean needAnimation) {
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public void setIndicator(int pageIndex, int size, @Nullable Drawable background, @Nullable CharSequence hoverDescription) {
    }
}
