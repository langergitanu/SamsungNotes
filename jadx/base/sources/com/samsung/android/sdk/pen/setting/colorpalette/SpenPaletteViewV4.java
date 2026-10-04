package com.samsung.android.sdk.pen.setting.colorpalette;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenBasePalette;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenChildButtonInfo;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPageIndicator;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenViewFlipperAction;
import com.samsung.android.sdk.pen.setting.common.SpenVoiceAssistantAsSlider;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\b\u001e\u0018\u0000 \u0081\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0081\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u00102\u001a\u000203J\u0010\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\u001dH\u0016J\u0010\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u001dH\u0002J\u0018\u0010:\u001a\u0002032\u0006\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u001dH\u0016J(\u0010=\u001a\u0002032\u0006\u0010>\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0016J \u0010=\u001a\u0002032\u0006\u0010>\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020DH\u0016J(\u0010E\u001a\u0002032\u0006\u0010>\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u001d2\u0006\u0010F\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001dH\u0016J0\u0010E\u001a\u0002032\u0006\u0010>\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u001d2\u0006\u0010F\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u001dH\u0016J2\u0010E\u001a\u0002032\u0006\u0010>\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u001d2\u0006\u0010F\u001a\u00020\u001d2\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010H\u001a\u00020\u001dH\u0016J \u0010E\u001a\u0002032\u0006\u0010>\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u001d2\u0006\u0010K\u001a\u00020LH\u0002J,\u0010M\u001a\u0002032\u0006\u0010;\u001a\u00020\u001d2\u0006\u0010N\u001a\u00020\u001d2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u001a\u0010Q\u001a\u0004\u0018\u00010P2\u0006\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u001dH\u0016J(\u0010T\u001a\u0002032\u0006\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u001d2\u0006\u0010U\u001a\u00020.2\u0006\u0010V\u001a\u00020.H\u0016J\u0010\u0010W\u001a\u0002032\u0006\u0010X\u001a\u00020\rH\u0002J\b\u0010Y\u001a\u000203H\u0002J \u0010Z\u001a\u0002032\u0006\u0010[\u001a\u00020\u001d2\u0006\u0010\\\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020.H\u0016J\b\u0010^\u001a\u00020\u001dH\u0016J\u0018\u0010_\u001a\u0002032\u0006\u0010>\u001a\u00020\u001d2\u0006\u0010V\u001a\u00020.H\u0016J\b\u0010`\u001a\u00020\u001dH\u0016J\u0012\u0010a\u001a\u0002032\b\u0010b\u001a\u0004\u0018\u00010\u001aH\u0016J\u000e\u0010c\u001a\b\u0012\u0004\u0012\u00020\u001d0dH\u0016J\u000e\u0010e\u001a\b\u0012\u0004\u0012\u00020\u001d0dH\u0016J\b\u0010f\u001a\u00020\u001dH\u0016J\b\u0010g\u001a\u00020\u001dH\u0016J(\u0010h\u001a\u0002032\u000e\u0010i\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010d2\u000e\u0010j\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0002J\u0018\u0010k\u001a\u0002032\u0006\u0010[\u001a\u00020\u001d2\u0006\u0010l\u001a\u00020.H\u0004J\u0010\u0010m\u001a\u0002032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010n\u001a\u0002032\u0006\u00105\u001a\u00020\u001dH\u0002J\u0010\u0010e\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u001dH\u0002J\u0010\u0010c\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u001dH\u0002J\b\u0010o\u001a\u000203H\u0002J \u0010p\u001a\u0002032\u0006\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u001d2\u0006\u0010q\u001a\u00020!H\u0002J\u001a\u0010r\u001a\u0004\u0018\u00010!2\u0006\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u001dH\u0002J\u0018\u0010s\u001a\u0002032\u0006\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u001dH\u0002J\u0018\u0010t\u001a\u00020\u001d2\u0006\u0010u\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u001dH\u0002J\u001a\u0010o\u001a\u0002032\u0006\u0010<\u001a\u00020\u001d2\b\u0010v\u001a\u0004\u0018\u00010!H\u0002J \u0010w\u001a\u0002032\u0006\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u001d2\u0006\u0010v\u001a\u00020!H\u0002J\"\u0010x\u001a\u0002032\b\u0010y\u001a\u0004\u0018\u00010\u00112\u0006\u0010<\u001a\u00020\u001d2\u0006\u0010v\u001a\u00020!H\u0002J\u001a\u0010z\u001a\u0002032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010{\u001a\u00020.2\u0006\u0010|\u001a\u00020\u001dJ\u000e\u0010}\u001a\u0002032\u0006\u0010~\u001a\u00020.J\b\u0010\u007f\u001a\u000203H\u0002J\t\u0010\u0080\u0001\u001a\u000203H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082.¢\u0006\u0002\n\u0000R*\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020!0 j\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020!`\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0082\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewV4;", "Landroid/widget/RelativeLayout;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenViewFlipperAction$ViewFlipperActionListener;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewInterface;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mFlipper", "Landroid/widget/ViewFlipper;", "mIndicatorArea", "Landroid/view/ViewGroup;", "mFixedArea", "Landroid/widget/FrameLayout;", "mFixedPalette", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenBasePalette;", "mPageIndicator", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPageIndicator;", "mPaletteArea", "mViewFlipperAction", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenViewFlipperAction;", "mColorPalletAssistant", "Lcom/samsung/android/sdk/pen/setting/common/SpenVoiceAssistantAsSlider;", "mActionListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewActionListener;", "mFixedChildIndex", "", "", "mSwipeChildIndex", "mFixedChildInfo", "Ljava/util/HashMap;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenChildButtonInfo;", "Lkotlin/collections/HashMap;", "mSwipeItemCount", "mFixedItemCount", "mItemWidth", "mItemHeight", "mBetweenMargin", "mFrontMargin", "mEndMargin", "mIndicatorSize", "mIndicatorSpace", "mIndicatorBackgroundRes", "mIsSupportSelector", "", "mIndicatorOrientation", "mLayoutResources", "mPaletteOrientation", "close", "", "setPaletteInfo", "totalPage", "getPalette", "childCount", "mChildActionListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteActionListener;", "resetColor", "pageIndex", "childAt", "setColor", "pageIdx", "color", "", "colorName", "", "colorInfo", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteColorInfo;", "setResource", "resId", "hoverStringId", "selectorId", "hoverDescription", "", "resInfo", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteResInfo;", "setIndicator", "size", "background", "Landroid/graphics/drawable/Drawable;", "getSelectorDrawable", "mCurrentPageIndex", "mCurrentChildAt", "setSelected", "selected", "needAnimation", "releasePalette", "paletteParent", "updateOrder", "onFlipped", "position", "direction", "fromUser", "getCurrentPage", "setPage", "getPageCount", "setPaletteActionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getSwipeChildIndex", "", "getFixedChildIndex", "getVersion", "getPaletteOrientation", "getChildIndex", "source", "dest", "notifyButtonClick", "isSelected", "construct", "initPageIndicator", "updateFixedLayout", "putFixedChildInfo", "info", "getFixedChildInfo", "removeFixedChildInfo", "getKey", "paletteIndex", "buttonInfo", "updateSwipeLayout", "updatePaletteInfo", "palette", "setAttributes", "setSelectorDegree", "degree", "setFlipperEnabled", "enabled", "initAccessibilityForColorPallet", "updateColorPalletContentDescription", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenPaletteViewV4.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenPaletteViewV4.kt\ncom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewV4\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,768:1\n1#2:769\n*E\n"})
public final class SpenPaletteViewV4 extends RelativeLayout implements SpenViewFlipperAction.ViewFlipperActionListener, SpenPaletteViewInterface {
    private static final int DEFAULT_FIXED_ITEM_COUNT = 1;
    private static final int DEFAULT_SWIPE_ITEM_COUNT = 8;
    private static final int SHIFT_VALUE_PALETTE = 16;

    @NotNull
    private static final String TAG = "SpenPaletteViewV4";

    @Nullable
    private SpenPaletteViewActionListener mActionListener;
    private int mBetweenMargin;

    @NotNull
    private final SpenPaletteActionListener mChildActionListener;

    @Nullable
    private SpenVoiceAssistantAsSlider mColorPalletAssistant;
    private int mCurrentChildAt;
    private int mCurrentPageIndex;
    private int mEndMargin;
    private FrameLayout mFixedArea;
    private List<Integer> mFixedChildIndex;
    private HashMap<Integer, SpenChildButtonInfo> mFixedChildInfo;
    private int mFixedItemCount;

    @Nullable
    private SpenBasePalette mFixedPalette;
    private ViewFlipper mFlipper;
    private int mFrontMargin;
    private ViewGroup mIndicatorArea;
    private int mIndicatorBackgroundRes;
    private int mIndicatorOrientation;
    private int mIndicatorSize;
    private int mIndicatorSpace;
    private boolean mIsSupportSelector;
    private int mItemHeight;
    private int mItemWidth;
    private int mLayoutResources;

    @Nullable
    private SpenPageIndicator mPageIndicator;
    private ViewGroup mPaletteArea;
    private int mPaletteOrientation;
    private List<Integer> mSwipeChildIndex;
    private int mSwipeItemCount;

    @Nullable
    private SpenViewFlipperAction mViewFlipperAction;

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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public SpenPaletteViewV4(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void construct(Context context) {
        View.inflate(context, this.mLayoutResources, this);
        View viewFindViewById = findViewById(C7932R.id.pallete_flipper);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.ViewFlipper");
        this.mFlipper = (ViewFlipper) viewFindViewById;
        this.mIndicatorArea = (ViewGroup) findViewById(C7932R.id.indicator_area);
        this.mPaletteArea = (ViewGroup) findViewById(C7932R.id.palette_area);
        this.mFixedArea = (FrameLayout) findViewById(C7932R.id.fixed_area);
        this.mFixedChildIndex = new ArrayList();
        this.mSwipeChildIndex = new ArrayList();
        this.mFixedChildInfo = new HashMap<>();
        this.mSwipeItemCount = 8;
        this.mFixedItemCount = 1;
        this.mIsSupportSelector = true;
    }

    private final void getChildIndex(List<Integer> source, List<Integer> dest) {
        if (source == null || dest == null) {
            return;
        }
        dest.addAll(source);
    }

    private final SpenChildButtonInfo getFixedChildInfo(int pageIndex, int childAt) {
        int key = getKey(pageIndex, childAt);
        HashMap<Integer, SpenChildButtonInfo> map = this.mFixedChildInfo;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFixedChildInfo");
            map = null;
        }
        return map.get(Integer.valueOf(key));
    }

    private final int getKey(int paletteIndex, int childAt) {
        return ((paletteIndex << 16) & (-65536)) | (childAt & 65535);
    }

    private final SpenBasePalette getPalette(int childCount) {
        SpenBasePalette.ChildInfo childInfo = new SpenBasePalette.ChildInfo();
        childInfo.setShape(ColorChipShape.CIRCLE);
        childInfo.setCount(childCount);
        childInfo.setWidth(this.mItemWidth);
        childInfo.setHeight(this.mItemHeight);
        int i = this.mBetweenMargin;
        if (i != 0) {
            childInfo.setBetweenMargin(i);
        } else {
            childInfo.setMargin(this.mFrontMargin, this.mEndMargin);
        }
        childInfo.setRadius(0);
        childInfo.setOrientation(this.mPaletteOrientation);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        SpenBasePalette spenBasePalette = new SpenBasePalette(context);
        spenBasePalette.setInfo(childInfo);
        return spenBasePalette;
    }

    private final void initAccessibilityForColorPallet() {
        ViewGroup viewGroup = null;
        if (getPageCount() <= 1) {
            ViewGroup viewGroup2 = this.mPaletteArea;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPaletteArea");
                viewGroup2 = null;
            }
            viewGroup2.setImportantForAccessibility(2);
            this.mColorPalletAssistant = null;
            return;
        }
        if (this.mColorPalletAssistant != null) {
            return;
        }
        ViewGroup viewGroup3 = this.mPaletteArea;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPaletteArea");
            viewGroup3 = null;
        }
        viewGroup3.setImportantForAccessibility(1);
        SpenVoiceAssistantAsSlider spenVoiceAssistantAsSlider = new SpenVoiceAssistantAsSlider(getContext(), AbstractC0541b.m757C(getContext().getString(C7932R.string.pen_string_color_palette), SQLKeyword.COMMA, getContext().getString(C7932R.string.pen_string_slider)));
        this.mColorPalletAssistant = spenVoiceAssistantAsSlider;
        spenVoiceAssistantAsSlider.setListener(new SpenVoiceAssistantAsSlider.ActionScrollListener() { // from class: com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewV4.initAccessibilityForColorPallet.1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenVoiceAssistantAsSlider.ActionScrollListener
            public void onScrollBackward() {
                SpenViewFlipperAction spenViewFlipperAction = SpenPaletteViewV4.this.mViewFlipperAction;
                if (spenViewFlipperAction != null) {
                    spenViewFlipperAction.moveBackward(true);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenVoiceAssistantAsSlider.ActionScrollListener
            public void onScrollForward() {
                SpenViewFlipperAction spenViewFlipperAction = SpenPaletteViewV4.this.mViewFlipperAction;
                if (spenViewFlipperAction != null) {
                    spenViewFlipperAction.moveForward(true);
                }
            }
        });
        ViewGroup viewGroup4 = this.mPaletteArea;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPaletteArea");
        } else {
            viewGroup = viewGroup4;
        }
        ViewCompat.setAccessibilityDelegate(viewGroup, this.mColorPalletAssistant);
    }

    private final void initPageIndicator(int totalPage) {
        SpenPageIndicator spenPageClipIndicator;
        if (this.mPageIndicator == null) {
            int i = this.mLayoutResources;
            if (i == C7932R.layout.setting_palette_view_mini || i == C7932R.layout.setting_palette_view_mini_circle) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                spenPageClipIndicator = new SpenPageClipIndicator(context, this.mIndicatorBackgroundRes);
            } else {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                spenPageClipIndicator = new SpenPageIndicator(context2, this.mIndicatorBackgroundRes);
            }
            this.mPageIndicator = spenPageClipIndicator;
            spenPageClipIndicator.setActionListener(new SpenPageIndicator.ActionListener() { // from class: com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewV4.initPageIndicator.1
                @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPageIndicator.ActionListener
                public void onIndicatorClicked(int position) {
                    AbstractC2322a.m1631u(position, "onIndicatorClicked. position=", SpenPaletteViewV4.TAG);
                    SpenPaletteViewV4.this.setPage(position, true);
                }
            });
            ViewGroup viewGroup = this.mIndicatorArea;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIndicatorArea");
                viewGroup = null;
            }
            viewGroup.addView(this.mPageIndicator);
        }
        SpenPageIndicator spenPageIndicator = this.mPageIndicator;
        if (spenPageIndicator != null) {
            spenPageIndicator.setOrientation(this.mIndicatorOrientation);
        }
        if (totalPage <= 1) {
            SpenPageIndicator spenPageIndicator2 = this.mPageIndicator;
            if (spenPageIndicator2 != null) {
                spenPageIndicator2.setVisibility(8);
            }
            AbstractC11014a.m12328m(totalPage, "totalPage=", " page indicator is null.", TAG);
            return;
        }
        SpenPageIndicator spenPageIndicator3 = this.mPageIndicator;
        if (spenPageIndicator3 != null) {
            spenPageIndicator3.setVisibility(0);
        }
        AbstractC6670b.m4744e(this.mIndicatorSpace, totalPage, "make indicator. size=", " count=", TAG);
        SpenPageIndicator spenPageIndicator4 = this.mPageIndicator;
        if (spenPageIndicator4 != null) {
            spenPageIndicator4.setInfo(this.mIndicatorSize, this.mIndicatorSpace, totalPage);
        }
        ViewFlipper viewFlipper = this.mFlipper;
        if (viewFlipper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlipper");
            viewFlipper = null;
        }
        int childCount = viewFlipper.getChildCount();
        SpenPageIndicator spenPageIndicator5 = this.mPageIndicator;
        Log.i(TAG, "setPalette. child=" + childCount + " position = " + (spenPageIndicator5 != null ? Integer.valueOf(spenPageIndicator5.getMCurrent()) : null));
    }

    private final void putFixedChildInfo(int pageIndex, int childAt, SpenChildButtonInfo info) {
        int key = getKey(pageIndex, childAt);
        HashMap<Integer, SpenChildButtonInfo> map = this.mFixedChildInfo;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFixedChildInfo");
            map = null;
        }
        map.put(Integer.valueOf(key), info);
        Log.i(TAG, "put fixedChildInfo pageIndex=" + pageIndex + " childAt=" + childAt + " key=" + key);
    }

    private final void releasePalette(ViewGroup paletteParent) {
        if (paletteParent instanceof SpenBasePalette) {
            Log.i(TAG, "releasePalette() call close()");
            ((SpenBasePalette) paletteParent).close();
            return;
        }
        if (paletteParent.getChildCount() > 0) {
            Log.i(TAG, "releasePalette() child=" + paletteParent.getChildCount());
            int childCount = paletteParent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = paletteParent.getChildAt(i);
                Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
                releasePalette((ViewGroup) childAt);
            }
        }
    }

    private final void removeFixedChildInfo(int pageIndex, int childAt) {
        int key = getKey(pageIndex, childAt);
        HashMap<Integer, SpenChildButtonInfo> map = this.mFixedChildInfo;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFixedChildInfo");
            map = null;
        }
        map.remove(Integer.valueOf(key));
    }

    private final void setAttributes(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, C7932R.styleable.SpenPaletteViewV4, 0, 0);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            this.mIndicatorOrientation = typedArrayObtainStyledAttributes.getInteger(C7932R.styleable.SpenPaletteViewV4_indicatorOrientation, 0);
            this.mLayoutResources = typedArrayObtainStyledAttributes.getResourceId(C7932R.styleable.SpenPaletteViewV4_childLayout, C7932R.layout.setting_palette_view_v4);
            this.mPaletteOrientation = typedArrayObtainStyledAttributes.getInteger(C7932R.styleable.SpenPaletteViewV4_orientation, 0);
            this.mItemWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(C7932R.styleable.SpenPaletteViewV4_itemWidth, 0);
            this.mItemHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(C7932R.styleable.SpenPaletteViewV4_itemHeight, 0);
            this.mBetweenMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(C7932R.styleable.SpenPaletteViewV4_itemBetweenMargin, 0);
            this.mIndicatorSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(C7932R.styleable.SpenPaletteViewV4_indicatorSize, 0);
            this.mIndicatorSpace = typedArrayObtainStyledAttributes.getDimensionPixelSize(C7932R.styleable.SpenPaletteViewV4_indicatorSpace, 0);
            this.mIndicatorBackgroundRes = typedArrayObtainStyledAttributes.getResourceId(C7932R.styleable.SpenPaletteViewV4_indicatorBackground, 0);
            this.mFrontMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(C7932R.styleable.SpenPaletteViewV4_itemFrontMargin, 0);
            this.mEndMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(C7932R.styleable.SpenPaletteViewV4_itemEndMargin, 0);
            typedArrayObtainStyledAttributes.recycle();
        } else {
            this.mLayoutResources = C7932R.layout.setting_palette_view_v4;
            this.mIndicatorOrientation = 0;
            this.mPaletteOrientation = 0;
            this.mIndicatorBackgroundRes = 0;
        }
        Resources resources = context.getResources();
        if (this.mItemWidth == 0) {
            this.mItemWidth = resources.getDimensionPixelOffset(C7932R.dimen.setting_color_circle_chip_width);
        }
        if (this.mItemHeight == 0) {
            this.mItemHeight = resources.getDimensionPixelOffset(C7932R.dimen.setting_color_circle_chip_height);
        }
        if (this.mBetweenMargin == 0 && this.mFrontMargin == 0 && this.mEndMargin == 0) {
            this.mFrontMargin = resources.getDimensionPixelOffset(C7932R.dimen.setting_color_circle_chip_between_margin);
            this.mEndMargin = resources.getDimensionPixelOffset(C7932R.dimen.setting_color_circle_chip_between_margin);
        }
        if (this.mIndicatorSize == 0) {
            this.mIndicatorSize = resources.getDimensionPixelSize(C7932R.dimen.setting_color_palette_page_indicator_size);
        }
        if (this.mIndicatorSpace == 0) {
            this.mIndicatorSpace = resources.getDimensionPixelSize(C7932R.dimen.setting_color_palette_between_indicator_size);
        }
        if (this.mIndicatorBackgroundRes == 0) {
            this.mIndicatorBackgroundRes = C7932R.drawable.color_palette_v70_default_indicator;
        }
    }

    private final void updateColorPalletContentDescription() {
        if (this.mColorPalletAssistant == null) {
            return;
        }
        String string = getContext().getString(C7932R.string.pen_string_page_indicator, Integer.valueOf(getCurrentPage() + 1), Integer.valueOf(getPageCount()));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ViewGroup viewGroup = this.mPaletteArea;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPaletteArea");
            viewGroup = null;
        }
        viewGroup.setContentDescription(string);
    }

    private final void updateFixedLayout() {
        int currentPage = getCurrentPage();
        List<Integer> list = this.mFixedChildIndex;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFixedChildIndex");
            list = null;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int key = getKey(currentPage, i);
            HashMap<Integer, SpenChildButtonInfo> map = this.mFixedChildInfo;
            if (map == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFixedChildInfo");
                map = null;
            }
            updateFixedLayout(i, map.get(Integer.valueOf(key)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateOrder() {
        ViewGroup viewGroup = null;
        if (getCurrentPage() != this.mCurrentPageIndex) {
            FrameLayout frameLayout = this.mFixedArea;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFixedArea");
                frameLayout = null;
            }
            frameLayout.bringToFront();
        } else if (getSwipeChildIndex(this.mCurrentChildAt) > -1) {
            int i = this.mCurrentChildAt;
            List<Integer> list = this.mSwipeChildIndex;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSwipeChildIndex");
                list = null;
            }
            if (i == list.size() - 1) {
                Log.i(TAG, "SwipeArea bring to front");
                ViewFlipper viewFlipper = this.mFlipper;
                if (viewFlipper == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFlipper");
                    viewFlipper = null;
                }
                viewFlipper.bringToFront();
            } else if (this.mFixedItemCount > 0) {
                Log.i(TAG, "FixedArea bring to front");
                FrameLayout frameLayout2 = this.mFixedArea;
                if (frameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFixedArea");
                    frameLayout2 = null;
                }
                frameLayout2.bringToFront();
            }
        }
        ViewGroup viewGroup2 = this.mPaletteArea;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPaletteArea");
        } else {
            viewGroup = viewGroup2;
        }
        viewGroup.invalidate();
    }

    private final void updatePaletteInfo(SpenBasePalette palette, int childAt, SpenChildButtonInfo buttonInfo) {
        int i = WhenMappings.$EnumSwitchMapping$0[buttonInfo.getType().ordinal()];
        if (i == 1) {
            SpenPaletteColorInfo colorInfo = buttonInfo.getColorInfo();
            if (colorInfo == null || palette == null) {
                return;
            }
            palette.setColor(childAt, colorInfo);
            return;
        }
        if (i != 2) {
            if (palette != null) {
                palette.setInit(childAt);
            }
        } else {
            SpenPaletteResInfo resInfo = buttonInfo.getResInfo();
            if (resInfo == null || palette == null) {
                return;
            }
            palette.setRes(childAt, resInfo);
        }
    }

    private final void updateSwipeLayout(int pageIndex, int childAt, SpenChildButtonInfo buttonInfo) {
        ViewFlipper viewFlipper = this.mFlipper;
        if (viewFlipper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlipper");
            viewFlipper = null;
        }
        View childAt2 = viewFlipper.getChildAt(pageIndex);
        Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.colorpalette.SpenBasePalette");
        updatePaletteInfo((SpenBasePalette) childAt2, childAt, buttonInfo);
    }

    public final void close() {
        this.mActionListener = null;
        SpenViewFlipperAction spenViewFlipperAction = this.mViewFlipperAction;
        if (spenViewFlipperAction != null) {
            spenViewFlipperAction.close();
        }
        this.mViewFlipperAction = null;
        List<Integer> list = this.mFixedChildIndex;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFixedChildIndex");
            list = null;
        }
        list.clear();
        List<Integer> list2 = this.mSwipeChildIndex;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwipeChildIndex");
            list2 = null;
        }
        list2.clear();
        HashMap<Integer, SpenChildButtonInfo> map = this.mFixedChildInfo;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFixedChildInfo");
            map = null;
        }
        map.clear();
        ViewFlipper viewFlipper = this.mFlipper;
        if (viewFlipper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlipper");
            viewFlipper = null;
        }
        releasePalette(viewFlipper);
        SpenBasePalette spenBasePalette = this.mFixedPalette;
        if (spenBasePalette != null) {
            releasePalette(spenBasePalette);
        }
        this.mFixedPalette = null;
        SpenPageIndicator spenPageIndicator = this.mPageIndicator;
        if (spenPageIndicator != null) {
            spenPageIndicator.close();
        }
        this.mPageIndicator = null;
        SpenVoiceAssistantAsSlider spenVoiceAssistantAsSlider = this.mColorPalletAssistant;
        if (spenVoiceAssistantAsSlider != null) {
            spenVoiceAssistantAsSlider.close();
        }
        this.mColorPalletAssistant = null;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public int getCurrentPage() {
        SpenPageIndicator spenPageIndicator = this.mPageIndicator;
        if (spenPageIndicator != null && spenPageIndicator.getVisibility() == 0) {
            return spenPageIndicator.getMCurrent();
        }
        ViewFlipper viewFlipper = this.mFlipper;
        if (viewFlipper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlipper");
            viewFlipper = null;
        }
        return viewFlipper.getChildCount() - 1;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    @NotNull
    public List<Integer> getFixedChildIndex() {
        ArrayList arrayList = new ArrayList();
        List<Integer> list = this.mFixedChildIndex;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFixedChildIndex");
            list = null;
        }
        getChildIndex(list, arrayList);
        return arrayList;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public int getPageCount() {
        ViewFlipper viewFlipper = this.mFlipper;
        if (viewFlipper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlipper");
            viewFlipper = null;
        }
        return viewFlipper.getChildCount();
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public int getPaletteCornerRadius() {
        return SpenPaletteViewInterface.DefaultImpls.getPaletteCornerRadius(this);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    /* JADX INFO: renamed from: getPaletteOrientation, reason: from getter */
    public int getMPaletteOrientation() {
        return this.mPaletteOrientation;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    @Nullable
    public Drawable getSelectorDrawable(int pageIndex, int childAt) {
        AbstractC6670b.m4744e(pageIndex, childAt, "setColor() pageIndex=", " childAt=", TAG);
        int fixedChildIndex = getFixedChildIndex(childAt);
        if (fixedChildIndex > -1) {
            SpenBasePalette spenBasePalette = this.mFixedPalette;
            if (spenBasePalette != null) {
                return spenBasePalette.getSelectorDrawable(fixedChildIndex);
            }
            return null;
        }
        int swipeChildIndex = getSwipeChildIndex(childAt);
        if (swipeChildIndex > -1) {
            ViewFlipper viewFlipper = this.mFlipper;
            if (viewFlipper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFlipper");
                viewFlipper = null;
            }
            KeyEvent.Callback childAt2 = viewFlipper.getChildAt(pageIndex);
            SpenPaletteInterface spenPaletteInterface = childAt2 instanceof SpenPaletteInterface ? (SpenPaletteInterface) childAt2 : null;
            if (spenPaletteInterface != null) {
                return spenPaletteInterface.getSelectorDrawable(swipeChildIndex);
            }
        }
        return null;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    @NotNull
    public List<Integer> getSwipeChildIndex() {
        ArrayList arrayList = new ArrayList();
        List<Integer> list = this.mSwipeChildIndex;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwipeChildIndex");
            list = null;
        }
        getChildIndex(list, arrayList);
        return arrayList;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public int getVersion() {
        return 70;
    }

    public final void notifyButtonClick(int position, boolean isSelected) {
        AbstractC2322a.m1631u(getCurrentPage(), "getCurrentPage=", TAG);
        SpenPaletteViewActionListener spenPaletteViewActionListener = this.mActionListener;
        if (spenPaletteViewActionListener != null) {
            spenPaletteViewActionListener.onButtonClick(getCurrentPage(), position, isSelected);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenViewFlipperAction.ViewFlipperActionListener
    public void onFlipped(int position, int direction, boolean fromUser) {
        SpenPageIndicator spenPageIndicator = this.mPageIndicator;
        if (spenPageIndicator != null) {
            spenPageIndicator.setActive(position);
        }
        updateOrder();
        updateFixedLayout();
        updateColorPalletContentDescription();
        if (this.mActionListener == null || !fromUser || direction == 0) {
            return;
        }
        AbstractC6670b.m4744e(position, direction, "notify onPaletteSwipe(", "), direction=", TAG);
        SpenPaletteViewActionListener spenPaletteViewActionListener = this.mActionListener;
        if (spenPaletteViewActionListener != null) {
            spenPaletteViewActionListener.onPaletteSwipe(position, direction);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public void resetColor(int pageIndex, int childAt) {
        int fixedChildIndex = getFixedChildIndex(childAt);
        if (fixedChildIndex > -1) {
            removeFixedChildInfo(pageIndex, fixedChildIndex);
            if (getCurrentPage() == pageIndex) {
                updateFixedLayout(fixedChildIndex, null);
                return;
            }
            return;
        }
        int swipeChildIndex = getSwipeChildIndex(childAt);
        if (swipeChildIndex > -1) {
            updateSwipeLayout(pageIndex, swipeChildIndex, new SpenChildButtonInfo());
        }
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

    public final void setFlipperEnabled(boolean enabled) {
        AbstractC4539a.m3208r("setFlipperEnabled() enabled=", TAG, enabled);
        ViewFlipper viewFlipper = this.mFlipper;
        if (viewFlipper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlipper");
            viewFlipper = null;
        }
        viewFlipper.setEnabled(enabled);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public void setIndicator(int pageIndex, int size, @Nullable Drawable background, @Nullable CharSequence hoverDescription) {
        SpenPageIndicator spenPageIndicator = this.mPageIndicator;
        if (spenPageIndicator != null) {
            spenPageIndicator.updateIndicator(pageIndex, size, background, hoverDescription);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public void setPage(int pageIdx, boolean needAnimation) {
        SpenViewFlipperAction spenViewFlipperAction = this.mViewFlipperAction;
        if (spenViewFlipperAction != null) {
            spenViewFlipperAction.changeFlip(pageIdx, needAnimation);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public void setPaletteActionListener(@Nullable SpenPaletteViewActionListener listener) {
        this.mActionListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public void setPaletteCornerRadius(int i) {
        SpenPaletteViewInterface.DefaultImpls.setPaletteCornerRadius(this, i);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public void setPaletteInfo(int totalPage) {
        AbstractC11014a.m12328m(totalPage, "setPaletteInfo() totalPage = ", " mFlipper=NOT NULL", TAG);
        ViewFlipper viewFlipper = this.mFlipper;
        ViewFlipper viewFlipper2 = null;
        if (viewFlipper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlipper");
            viewFlipper = null;
        }
        viewFlipper.removeAllViews();
        FrameLayout frameLayout = this.mFixedArea;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFixedArea");
            frameLayout = null;
        }
        frameLayout.removeAllViews();
        List<Integer> list = this.mFixedChildIndex;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFixedChildIndex");
            list = null;
        }
        list.clear();
        List<Integer> list2 = this.mSwipeChildIndex;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwipeChildIndex");
            list2 = null;
        }
        list2.clear();
        HashMap<Integer, SpenChildButtonInfo> map = this.mFixedChildInfo;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFixedChildInfo");
            map = null;
        }
        map.clear();
        int i = this.mSwipeItemCount;
        for (int i2 = 0; i2 < i; i2++) {
            List<Integer> list3 = this.mSwipeChildIndex;
            if (list3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSwipeChildIndex");
                list3 = null;
            }
            list3.add(Integer.valueOf(i2));
        }
        int i4 = this.mFixedItemCount;
        for (int i5 = 0; i5 < i4; i5++) {
            List<Integer> list4 = this.mFixedChildIndex;
            if (list4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFixedChildIndex");
                list4 = null;
            }
            list4.add(Integer.valueOf(this.mSwipeItemCount + i5));
        }
        for (int i6 = 0; i6 < totalPage; i6++) {
            SpenBasePalette palette = getPalette(this.mSwipeItemCount);
            palette.setActionListener(new SpenPaletteActionListener() { // from class: com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewV4.setPaletteInfo.1
                @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteActionListener
                public void onButtonClick(ViewGroup viewgroup, View v, int position) {
                    Intrinsics.checkNotNullParameter(viewgroup, "viewgroup");
                    Intrinsics.checkNotNullParameter(v, "v");
                    SpenPaletteViewV4.this.notifyButtonClick(position, v.isSelected());
                }
            });
            boolean z = this.mIsSupportSelector;
            if (!z) {
                palette.setSelectorIcon(z);
            }
            ViewFlipper viewFlipper3 = this.mFlipper;
            if (viewFlipper3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFlipper");
                viewFlipper3 = null;
            }
            viewFlipper3.addView(palette);
        }
        int i7 = this.mFixedItemCount;
        if (i7 > 0) {
            SpenBasePalette palette2 = getPalette(i7);
            this.mFixedPalette = palette2;
            if (palette2 != null) {
                palette2.setActionListener(this.mChildActionListener);
            }
            FrameLayout frameLayout2 = this.mFixedArea;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFixedArea");
                frameLayout2 = null;
            }
            frameLayout2.addView(this.mFixedPalette);
        }
        initPageIndicator(totalPage);
        initAccessibilityForColorPallet();
        if (totalPage <= 1) {
            this.mViewFlipperAction = null;
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ViewFlipper viewFlipper4 = this.mFlipper;
        if (viewFlipper4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlipper");
        } else {
            viewFlipper2 = viewFlipper4;
        }
        SpenViewFlipperAction spenViewFlipperAction = new SpenViewFlipperAction(context, viewFlipper2, 0);
        this.mViewFlipperAction = spenViewFlipperAction;
        spenViewFlipperAction.resetPosition();
        SpenViewFlipperAction spenViewFlipperAction2 = this.mViewFlipperAction;
        if (spenViewFlipperAction2 != null) {
            spenViewFlipperAction2.setActionListener(this);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public void setResource(int pageIdx, int childAt, int resId, int hoverStringId) {
        setResource(pageIdx, childAt, resId, hoverStringId, 0);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public void setSelected(int pageIndex, int childAt, boolean selected, boolean needAnimation) {
        AbstractC0000a.m27x(AbstractC0622a.m1173s(pageIndex, childAt, "setSelected() pageIndex=", " childAt=", " selected="), selected, TAG);
        int fixedChildIndex = getFixedChildIndex(childAt);
        if (fixedChildIndex > -1) {
            SpenChildButtonInfo fixedChildInfo = getFixedChildInfo(pageIndex, fixedChildIndex);
            if (fixedChildInfo != null) {
                fixedChildInfo.setSelected(selected);
            }
        } else {
            int swipeChildIndex = getSwipeChildIndex(childAt);
            if (swipeChildIndex > -1) {
                ViewFlipper viewFlipper = this.mFlipper;
                if (viewFlipper == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFlipper");
                    viewFlipper = null;
                }
                KeyEvent.Callback childAt2 = viewFlipper.getChildAt(pageIndex);
                SpenPaletteInterface spenPaletteInterface = childAt2 instanceof SpenPaletteInterface ? (SpenPaletteInterface) childAt2 : null;
                if (spenPaletteInterface != null) {
                    spenPaletteInterface.setSelected(swipeChildIndex, selected, needAnimation);
                }
            }
        }
        if (selected) {
            this.mCurrentPageIndex = pageIndex;
            this.mCurrentChildAt = childAt;
            updateOrder();
        }
        if (getCurrentPage() == pageIndex) {
            updateFixedLayout();
        }
    }

    public final boolean setSelectorDegree(int degree) {
        AbstractC2322a.m1631u(degree, "setSelectorDegree() degree=", TAG);
        SpenBasePalette spenBasePalette = this.mFixedPalette;
        if (spenBasePalette == null || degree % 90 != 0) {
            return false;
        }
        if (spenBasePalette != null) {
            spenBasePalette.setSelectorDegree(0, degree);
        }
        ViewFlipper viewFlipper = this.mFlipper;
        if (viewFlipper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlipper");
            viewFlipper = null;
        }
        int childCount = viewFlipper.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewFlipper viewFlipper2 = this.mFlipper;
            if (viewFlipper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFlipper");
                viewFlipper2 = null;
            }
            View childAt = viewFlipper2.getChildAt(i);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.colorpalette.SpenRectPalette");
            ((SpenRectPalette) childAt).setSelectorDegree(0, degree);
        }
        return true;
    }

    public /* synthetic */ SpenPaletteViewV4(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
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
    @JvmOverloads
    public SpenPaletteViewV4(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mChildActionListener = new SpenPaletteActionListener() { // from class: com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewV4$mChildActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteActionListener
            public void onButtonClick(ViewGroup viewgroup, View v, int position) {
                int iIntValue;
                Intrinsics.checkNotNullParameter(viewgroup, "viewgroup");
                Intrinsics.checkNotNullParameter(v, "v");
                if (this.this$0.mFixedPalette == null) {
                    Log.i("SpenPaletteViewV4", "View is null.");
                    return;
                }
                List list = null;
                if (Intrinsics.areEqual(this.this$0.mFixedPalette, viewgroup)) {
                    List list2 = this.this$0.mFixedChildIndex;
                    if (list2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mFixedChildIndex");
                    } else {
                        list = list2;
                    }
                    iIntValue = ((Number) list.get(position)).intValue();
                } else {
                    ViewFlipper viewFlipper = this.this$0.mFlipper;
                    if (viewFlipper == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mFlipper");
                        viewFlipper = null;
                    }
                    if (Intrinsics.areEqual(viewFlipper.getCurrentView(), viewgroup)) {
                        List list3 = this.this$0.mSwipeChildIndex;
                        if (list3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mSwipeChildIndex");
                        } else {
                            list = list3;
                        }
                        iIntValue = ((Number) list.get(position)).intValue();
                    } else {
                        iIntValue = -1;
                    }
                }
                if (iIntValue != -1) {
                    this.this$0.notifyButtonClick(iIntValue, v.isSelected());
                }
            }
        };
        setAttributes(context, attributeSet);
        construct(context);
    }

    private final int getFixedChildIndex(int childAt) {
        List<Integer> list = this.mFixedChildIndex;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFixedChildIndex");
            list = null;
        }
        return list.indexOf(Integer.valueOf(childAt));
    }

    private final int getSwipeChildIndex(int childAt) {
        List<Integer> list = this.mSwipeChildIndex;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSwipeChildIndex");
            list = null;
        }
        return list.indexOf(Integer.valueOf(childAt));
    }

    private final void updateFixedLayout(int childAt, SpenChildButtonInfo buttonInfo) {
        SpenBasePalette spenBasePalette;
        if (buttonInfo != null && buttonInfo.getType() != SpenChildButtonInfo.ButtonType.NONE) {
            updatePaletteInfo(this.mFixedPalette, childAt, buttonInfo);
            if (!buttonInfo.getIsSelected() || (spenBasePalette = this.mFixedPalette) == null) {
                return;
            }
            spenBasePalette.setSelected(childAt, true, false);
            return;
        }
        SpenBasePalette spenBasePalette2 = this.mFixedPalette;
        if (spenBasePalette2 != null) {
            spenBasePalette2.setInit(childAt);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public void setResource(int pageIdx, int childAt, int resId, @Nullable CharSequence hoverDescription, int selectorId) {
        StringBuilder sbM1173s = AbstractC0622a.m1173s(pageIdx, childAt, "setResource() pageIndex=", " childAt=", " resId=");
        sbM1173s.append(resId);
        sbM1173s.append(" hoverDescription=");
        sbM1173s.append((Object) hoverDescription);
        sbM1173s.append(" selectorId=");
        sbM1173s.append(selectorId);
        Log.i(TAG, sbM1173s.toString());
        SpenPaletteResInfo spenPaletteResInfo = new SpenPaletteResInfo();
        spenPaletteResInfo.setRes(resId, hoverDescription, selectorId);
        setResource(pageIdx, childAt, spenPaletteResInfo);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface
    public void setColor(int pageIdx, int childAt, @NotNull SpenPaletteColorInfo colorInfo) {
        Intrinsics.checkNotNullParameter(colorInfo, "colorInfo");
        Log.i(TAG, "setColor() pageIndex=" + pageIdx + " childAt=" + childAt);
        SpenChildButtonInfo spenChildButtonInfo = new SpenChildButtonInfo(colorInfo);
        int fixedChildIndex = getFixedChildIndex(childAt);
        if (fixedChildIndex > -1) {
            putFixedChildInfo(pageIdx, fixedChildIndex, spenChildButtonInfo);
            if (getCurrentPage() == pageIdx) {
                updateFixedLayout(fixedChildIndex, spenChildButtonInfo);
                return;
            }
            return;
        }
        int swipeChildIndex = getSwipeChildIndex(childAt);
        if (swipeChildIndex > -1) {
            updateSwipeLayout(pageIdx, swipeChildIndex, spenChildButtonInfo);
        }
    }

    private final void setResource(int pageIdx, int childAt, SpenPaletteResInfo resInfo) {
        Log.i(TAG, "setResource() pageIndex=" + pageIdx + " childAt=" + childAt);
        SpenChildButtonInfo spenChildButtonInfo = new SpenChildButtonInfo(resInfo);
        int fixedChildIndex = getFixedChildIndex(childAt);
        if (fixedChildIndex > -1) {
            putFixedChildInfo(pageIdx, fixedChildIndex, spenChildButtonInfo);
            if (getCurrentPage() == pageIdx) {
                updateFixedLayout(fixedChildIndex, spenChildButtonInfo);
                return;
            }
            return;
        }
        int swipeChildIndex = getSwipeChildIndex(childAt);
        if (swipeChildIndex > -1) {
            updateSwipeLayout(pageIdx, swipeChildIndex, spenChildButtonInfo);
        }
    }
}
