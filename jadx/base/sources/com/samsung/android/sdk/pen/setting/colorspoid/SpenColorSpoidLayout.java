package com.samsung.android.sdk.pen.setting.colorspoid;

import android.animation.AnimatorInflater;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.oneui.floatingdock.ViewOnTouchListenerC4799j;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.widget.glance.single.setting.view.ViewOnTouchListenerC7005f;
import com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.ViewOnHoverListenerC7469a;
import com.samsung.android.sdk.pen.setting.color.SpenColorThemeUtil;
import com.samsung.android.sdk.pen.setting.colorpalette.ViewOnClickListenerC7538b;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilColor;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p047K3.ViewOnLayoutChangeListenerC0162a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u0000 v2\u00020\u0001:\u0002vwB-\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010G\u001a\u00020HJ\u0006\u0010I\u001a\u00020HJ\b\u0010J\u001a\u00020HH\u0017J\u000e\u0010K\u001a\u00020H2\u0006\u0010L\u001a\u00020\u0007J\u0010\u0010M\u001a\u00020H2\b\u0010N\u001a\u0004\u0018\u00010\u0013J\u000e\u0010O\u001a\u00020H2\u0006\u0010P\u001a\u00020\u0007J\u001a\u0010Q\u001a\u00020H2\b\u0010R\u001a\u0004\u0018\u00010\u00012\u0006\u0010P\u001a\u00020\u0007H\u0002J\b\u0010S\u001a\u00020HH\u0016J\u000e\u0010S\u001a\u00020H2\u0006\u0010T\u001a\u00020\u0017J\u0012\u0010U\u001a\u00020H2\b\b\u0002\u0010T\u001a\u00020\u0017H\u0007J\u0016\u0010V\u001a\u00020H2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010W\u001a\u00020H2\u0006\u0010S\u001a\u00020\u00172\u0006\u0010N\u001a\u00020XH\u0002J\"\u0010Y\u001a\u00020H2\b\u0010Z\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0003J\b\u0010[\u001a\u00020\u0019H\u0003J\u0010\u0010\\\u001a\u00020H2\u0006\u0010Z\u001a\u00020\u0019H\u0002J\u0010\u0010]\u001a\u00020\u00012\u0006\u0010Z\u001a\u00020\u0019H\u0002J\u0010\u0010^\u001a\u00020\u00012\u0006\u0010Z\u001a\u00020\u0019H\u0002J\u0010\u0010_\u001a\u00020\u00012\u0006\u0010Z\u001a\u00020\u0019H\u0002J\u0018\u0010`\u001a\u00020H2\u0006\u0010R\u001a\u00020\u00012\u0006\u0010a\u001a\u00020\u0007H\u0002J\u0010\u0010b\u001a\u00020H2\u0006\u0010R\u001a\u00020cH\u0002J\u001a\u0010d\u001a\u00020H2\b\u0010R\u001a\u0004\u0018\u00010\u00012\u0006\u0010e\u001a\u00020\u0007H\u0002J\u0010\u0010f\u001a\u00020\u00012\u0006\u0010Z\u001a\u00020\u0019H\u0002J(\u0010g\u001a\u0004\u0018\u00010\u001d2\u0006\u0010h\u001a\u00020i2\b\u0010j\u001a\u0004\u0018\u00010\u001d2\n\u0010k\u001a\u00020l\"\u00020\u0007H\u0002J\u0012\u0010m\u001a\u00020n2\b\u0010o\u001a\u0004\u0018\u00010\u0001H\u0002J\u0018\u0010p\u001a\u00020\u00172\u0006\u0010q\u001a\u00020\u00072\u0006\u0010r\u001a\u00020\u0007H\u0002J\b\u0010s\u001a\u00020HH\u0002J\b\u0010t\u001a\u00020HH\u0002J\u0010\u0010u\u001a\u00020H2\u0006\u0010T\u001a\u00020\u0017H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u001e\u0010+\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0011\u0010-\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b.\u0010(R\u0011\u0010/\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b0\u00101R\u001a\u00102\u001a\u000203X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010>\u001a\u00020?8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0010\u0010D\u001a\u00020?8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006x"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorspoid/SpenColorSpoidLayout;", "Landroid/view/View;", "context", "Landroid/content/Context;", "canvasLayout", "Landroid/view/ViewGroup;", "startMargin", "", "topMargin", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;II)V", "mParentLayout", "mColorSpoidHandle", "mSpoidCurrentColor", "mCloseButton", "mRatioHeight", "", "mRatioWidth", "mActionListener", "Lcom/samsung/android/sdk/pen/setting/colorspoid/SpenColorSpoidLayout$ActionListener;", "mColorThemeUtil", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorThemeUtil;", "mIsRotated", "", "mTotalLayout", "Landroid/widget/RelativeLayout;", "mColorNameHelper", "Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilColor;", "mDefaultColorName", "", "mPostfixColorString", "mChildRoot", "mIconColor", "mSpoidLayoutWidth", "mSpoidLayoutHeight", "mIsFirstShow", "mHasFirstShowAni", "value", "colorSpoidCurrentColor", "getColorSpoidCurrentColor", "()I", "positionX", "getPositionX", "positionY", "getPositionY", "colorSpoidSettingVisible", "getColorSpoidSettingVisible", "spoidView", "getSpoidView", "()Landroid/view/View;", "mLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "getMLayoutChangeListener", "()Landroid/view/View$OnLayoutChangeListener;", "setMLayoutChangeListener", "(Landroid/view/View$OnLayoutChangeListener;)V", "mCloseButtonClickListener", "Landroid/view/View$OnClickListener;", "mDownX", "mDownY", "mDownTotalX", "mDownTotalY", "mSpoidSettingListener", "Landroid/view/View$OnTouchListener;", "getMSpoidSettingListener", "()Landroid/view/View$OnTouchListener;", "setMSpoidSettingListener", "(Landroid/view/View$OnTouchListener;)V", "mOnConsumedTouchListener", "mOnConsumedHoverListener", "Landroid/view/View$OnHoverListener;", "setRotation", "", "rotatePosition", "close", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setSpoidListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setColorSpoidColor", "color", "setColorVoiceAssistant", "view", Constants.IntentExtraValue.SHOW, "needAnimation", "hide", "movePosition", "startAnimation", "Landroid/view/animation/Animation$AnimationListener;", "initSpoidSetting", "parent", "totalLayout", "bodyLayout", "spoiddHandle", "spoidExitBtn", "spoidColorImage", "setViewTooltip", "stringId", "setIconColor", "Landroid/widget/ImageView;", "setBackground", "bgResource", "spoidCurrentColor", "getString", "resources", "Landroid/content/res/Resources;", "div", "stringIds", "", "getMovableRect", "Landroid/graphics/Rect;", VPathDataCmd.RCurveTo, "movePositionInner", "px", "py", "updateMargin", "updatePositionRatio", "updateTotalLayout", "Companion", "ActionListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
public class SpenColorSpoidLayout extends View {

    @NotNull
    private static final String TAG = "SpenColorSpoidLayout";
    private int colorSpoidCurrentColor;

    @Nullable
    private ActionListener mActionListener;

    @Nullable
    private RelativeLayout mChildRoot;

    @Nullable
    private View mCloseButton;

    @NotNull
    private final View.OnClickListener mCloseButtonClickListener;
    private SpenSettingUtilColor mColorNameHelper;

    @Nullable
    private View mColorSpoidHandle;

    @NotNull
    private SpenColorThemeUtil mColorThemeUtil;

    @Nullable
    private String mDefaultColorName;
    private float mDownTotalX;
    private float mDownTotalY;
    private float mDownX;
    private float mDownY;
    private boolean mHasFirstShowAni;
    private final int mIconColor;
    private boolean mIsFirstShow;
    private boolean mIsRotated;

    @NotNull
    private View.OnLayoutChangeListener mLayoutChangeListener;

    @NotNull
    private final View.OnHoverListener mOnConsumedHoverListener;

    @SuppressLint({"ClickableViewAccessibility"})
    @NotNull
    private final View.OnTouchListener mOnConsumedTouchListener;

    @Nullable
    private ViewGroup mParentLayout;

    @Nullable
    private String mPostfixColorString;
    private float mRatioHeight;
    private float mRatioWidth;

    @Nullable
    private View mSpoidCurrentColor;
    private int mSpoidLayoutHeight;
    private int mSpoidLayoutWidth;

    @SuppressLint({"ClickableViewAccessibility"})
    @NotNull
    private View.OnTouchListener mSpoidSettingListener;
    private RelativeLayout mTotalLayout;
    private int positionX;
    private int positionY;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorspoid/SpenColorSpoidLayout$ActionListener;", "", "onHandlerTapped", "", "onSpoidClosed", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ActionListener {
        void onHandlerTapped();

        void onSpoidClosed();
    }

    @SuppressLint({"InlinedApi"})
    public SpenColorSpoidLayout(@Nullable Context context, @Nullable ViewGroup viewGroup, int i, int i2) {
        super(context);
        this.mColorThemeUtil = new SpenColorThemeUtil(context);
        this.mIsFirstShow = true;
        int i4 = 2;
        this.mLayoutChangeListener = new ViewOnLayoutChangeListenerC0162a(this, i4);
        this.mCloseButtonClickListener = new ViewOnClickListenerC7538b(this, i4);
        this.mSpoidSettingListener = new ViewOnTouchListenerC4799j(this, 7);
        this.mOnConsumedTouchListener = new ViewOnTouchListenerC7005f(6);
        this.mOnConsumedHoverListener = new ViewOnHoverListenerC7469a(3);
        if (context != null) {
            this.mColorNameHelper = new SpenSettingUtilColor(context, 1, 2);
            Resources resources = context.getResources();
            this.mSpoidLayoutWidth = resources.getDimensionPixelSize(C7932R.dimen.color_spoid_width);
            this.mSpoidLayoutHeight = resources.getDimensionPixelSize(C7932R.dimen.color_spoid_height);
            this.mDefaultColorName = resources.getString(C7932R.string.pen_palette_color_custom);
            this.mPostfixColorString = resources.getString(C7932R.string.pen_string_color);
        }
        this.mIconColor = SpenSettingUtil.getColor(context, C7932R.color.setting_handwriting_icon_enable_color);
        this.mParentLayout = viewGroup;
        initSpoidSetting(viewGroup, i, i2);
    }

    private final void bodyLayout(RelativeLayout parent) {
        this.mColorSpoidHandle = spoiddHandle(parent);
        this.mCloseButton = spoidExitBtn(parent);
        spoidColorImage(parent);
        this.mSpoidCurrentColor = spoidCurrentColor(parent);
    }

    private final Rect getMovableRect(View v) {
        int[] iArr = new int[2];
        Rect rect = new Rect();
        if (v != null) {
            v.getLocationOnScreen(iArr);
        }
        if (v != null) {
            rect.left = v.getPaddingLeft() + iArr[0];
            rect.top = v.getPaddingTop() + iArr[1];
            rect.right = (v.getWidth() + iArr[0]) - v.getPaddingRight();
            rect.bottom = (v.getHeight() + iArr[1]) - v.getPaddingBottom();
        }
        return rect;
    }

    private final String getString(Resources resources, String div, int... stringIds) {
        if (stringIds.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(resources.getString(stringIds[0]));
        int length = stringIds.length;
        for (int i = 1; i < length; i++) {
            if (div != null) {
                stringBuffer.append(div);
            }
            stringBuffer.append(resources.getString(stringIds[i]));
        }
        return stringBuffer.toString();
    }

    public static /* synthetic */ void hide$default(SpenColorSpoidLayout spenColorSpoidLayout, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hide");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        spenColorSpoidLayout.hide(z);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initSpoidSetting(ViewGroup parent, int startMargin, int topMargin) {
        RelativeLayout relativeLayout = totalLayout();
        this.mTotalLayout = relativeLayout;
        View view = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(8);
        View view2 = this.mColorSpoidHandle;
        if (view2 != null) {
            view2.setOnTouchListener(this.mSpoidSettingListener);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mSpoidLayoutWidth, this.mSpoidLayoutHeight);
        layoutParams.setMargins(0, 0, 0, 0);
        if (parent != null) {
            try {
                View view3 = this.mTotalLayout;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
                } else {
                    view = view3;
                }
                parent.addView(view, layoutParams);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        Log.i(TAG, "call movePosition() in initSpoidSetting()");
        movePosition(startMargin, topMargin);
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mCloseButtonClickListener$lambda$1(SpenColorSpoidLayout spenColorSpoidLayout, View view) {
        Log.i(TAG, "onClick()");
        ActionListener actionListener = spenColorSpoidLayout.mActionListener;
        if (actionListener != null) {
            actionListener.onSpoidClosed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mLayoutChangeListener$lambda$0(SpenColorSpoidLayout spenColorSpoidLayout, View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (spenColorSpoidLayout.mParentLayout == null) {
            return;
        }
        if (i == i6 && i2 == i7 && i4 == i8 && i5 == i9) {
            return;
        }
        RelativeLayout relativeLayout = spenColorSpoidLayout.mTotalLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
            relativeLayout = null;
        }
        if (relativeLayout.getVisibility() == 8 || i2 == i5) {
            return;
        }
        if (!spenColorSpoidLayout.mIsRotated) {
            Log.v(TAG, "checkPosition in OnLayoutChange - need this check??? ");
        } else {
            spenColorSpoidLayout.rotatePosition();
            spenColorSpoidLayout.mIsRotated = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mOnConsumedHoverListener$lambda$4(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mOnConsumedTouchListener$lambda$3(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mSpoidSettingListener$lambda$2(SpenColorSpoidLayout spenColorSpoidLayout, View view, MotionEvent motionEvent) {
        ViewGroup viewGroup = spenColorSpoidLayout.mParentLayout;
        if (viewGroup != null) {
            viewGroup.requestDisallowInterceptTouchEvent(true);
        }
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int action = motionEvent.getAction();
        if (action == 0) {
            spenColorSpoidLayout.mDownX = rawX;
            spenColorSpoidLayout.mDownY = rawY;
            RelativeLayout relativeLayout = spenColorSpoidLayout.mTotalLayout;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
                relativeLayout = null;
            }
            spenColorSpoidLayout.mDownTotalX = relativeLayout.getX();
            RelativeLayout relativeLayout2 = spenColorSpoidLayout.mTotalLayout;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
                relativeLayout2 = null;
            }
            spenColorSpoidLayout.mDownTotalY = relativeLayout2.getY();
        } else if (action == 1) {
            ActionListener actionListener = spenColorSpoidLayout.mActionListener;
            if (actionListener != null) {
                actionListener.onHandlerTapped();
            }
            spenColorSpoidLayout.updatePositionRatio();
        } else if (action == 2) {
            spenColorSpoidLayout.movePositionInner((int) ((spenColorSpoidLayout.mDownTotalX + rawX) - spenColorSpoidLayout.mDownX), (int) ((spenColorSpoidLayout.mDownTotalY + rawY) - spenColorSpoidLayout.mDownY));
            spenColorSpoidLayout.updateMargin();
        }
        RelativeLayout relativeLayout3 = spenColorSpoidLayout.mTotalLayout;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
            relativeLayout3 = null;
        }
        RelativeLayout relativeLayout4 = relativeLayout3 != null ? relativeLayout3 : null;
        if (relativeLayout4 != null) {
            relativeLayout4.requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }

    private final boolean movePositionInner(int px, int py) {
        boolean z;
        boolean z2;
        RelativeLayout relativeLayout;
        int i = px;
        int i2 = py;
        ViewGroup viewGroup = this.mParentLayout;
        if (viewGroup == null) {
            return false;
        }
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        if (width == 0 && height == 0) {
            Log.i(TAG, "parent width and height is 0");
            return false;
        }
        RelativeLayout relativeLayout2 = this.mTotalLayout;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
            relativeLayout2 = null;
        }
        boolean z3 = (((int) relativeLayout2.getRotation()) / 90) % 2 != 0;
        int i4 = this.mSpoidLayoutWidth;
        int i5 = this.mSpoidLayoutHeight;
        int i6 = z3 ? (i4 - i5) / 2 : 0;
        boolean z4 = this.mIsRotated;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "[1] movePositionInner() x=", " y=", " isRotated=");
        AbstractC2821a.m2208C(sbM1173s, z4, " isRotatedSpoid=", z3, " delta=");
        AbstractC0000a.m26w(sbM1173s, TAG, i6);
        int i7 = -i6;
        if (i < i7) {
            i = i7;
            z = true;
        } else {
            z = false;
        }
        if (i2 < i6) {
            i2 = i6;
            z = true;
        }
        if (i + i4 > width + i6) {
            i = (width - i4) + i6;
            z = true;
        }
        int i8 = (height - i5) - i6;
        if (i2 > i8) {
            i2 = i8;
            z2 = true;
        } else {
            z2 = z;
        }
        AbstractC0000a.m27x(AbstractC0622a.m1173s(i, i2, "[2] movePositionInner() x=", " y=", " ##### isChanged="), z2, TAG);
        RelativeLayout relativeLayout3 = this.mTotalLayout;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
            relativeLayout3 = null;
        }
        relativeLayout3.setX(i);
        RelativeLayout relativeLayout4 = this.mTotalLayout;
        if (relativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
            relativeLayout = null;
        } else {
            relativeLayout = relativeLayout4;
        }
        relativeLayout.setY(i2);
        return z2;
    }

    private final void setBackground(View view, int bgResource) {
        if (view != null) {
            view.setBackgroundResource(bgResource);
        }
    }

    private final void setColorVoiceAssistant(View view, int color) {
        if (view == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        SpenSettingUtilColor spenSettingUtilColor = this.mColorNameHelper;
        SpenSettingUtilColor spenSettingUtilColor2 = null;
        if (spenSettingUtilColor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorNameHelper");
            spenSettingUtilColor = null;
        }
        if (spenSettingUtilColor.getColorName(color) != null) {
            SpenSettingUtilColor spenSettingUtilColor3 = this.mColorNameHelper;
            if (spenSettingUtilColor3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mColorNameHelper");
            } else {
                spenSettingUtilColor2 = spenSettingUtilColor3;
            }
            sb.append(spenSettingUtilColor2.getColorName(color));
            sb.append(SQLKeyword.COMMA);
            sb.append(this.mPostfixColorString);
        } else {
            sb.append(this.mDefaultColorName);
        }
        view.setContentDescription(sb);
    }

    private final void setIconColor(ImageView view) {
        view.setColorFilter(this.mIconColor);
    }

    private final void setViewTooltip(View view, int stringId) {
        String string = getResources().getString(stringId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        view.setContentDescription(string);
        SpenSettingUtilHover.setHoverText(view, string);
    }

    private final View spoidColorImage(RelativeLayout parent) {
        View viewFindViewById = parent.findViewById(C7932R.id.eyedropper_icon);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.ImageButton");
        ImageButton imageButton = (ImageButton) viewFindViewById;
        imageButton.setBackgroundColor(0);
        imageButton.setImageResource(C7932R.drawable.ic_spoid);
        setIconColor(imageButton);
        setViewTooltip(imageButton, C7932R.string.pen_string_color_spuit);
        imageButton.setFocusable(true);
        return imageButton;
    }

    private final View spoidCurrentColor(RelativeLayout parent) {
        View viewFindViewById = parent.findViewById(C7932R.id.current_color);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.view.View");
        viewFindViewById.setBackgroundResource(C7932R.drawable.spuit_color_circle_shape);
        Drawable background = viewFindViewById.getBackground();
        Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) background).setColor(this.colorSpoidCurrentColor);
        viewFindViewById.setFocusable(true);
        return viewFindViewById;
    }

    private final View spoidExitBtn(RelativeLayout parent) {
        View viewFindViewById = parent.findViewById(C7932R.id.exit_button);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.ImageButton");
        ImageButton imageButton = (ImageButton) viewFindViewById;
        imageButton.setImageResource(C7932R.drawable.close_slot);
        setIconColor(imageButton);
        imageButton.setBackgroundResource(C7932R.drawable.spen_brush_btn_ripple_effect);
        imageButton.setFocusable(true);
        setViewTooltip(imageButton, C7932R.string.pen_string_close);
        imageButton.setOnClickListener(this.mCloseButtonClickListener);
        if (SpenSettingUtil.needRecoilVI()) {
            imageButton.setStateListAnimator(AnimatorInflater.loadStateListAnimator(getContext(), C7932R.animator.spen_recoil_button_selector));
        }
        return imageButton;
    }

    private final View spoiddHandle(RelativeLayout parent) {
        View viewFindViewById = parent.findViewById(C7932R.id.handle);
        viewFindViewById.setBackgroundResource(C7932R.drawable.colorpicker_handler);
        viewFindViewById.setBackgroundTintList(ColorStateList.valueOf(this.mIconColor));
        Resources resources = viewFindViewById.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        viewFindViewById.setContentDescription(getString(resources, SQLKeyword.COMMA, C7932R.string.pen_string_move_handler, C7932R.string.pen_string_color_double_tap_and_hold_to_move));
        viewFindViewById.setFocusable(true);
        Intrinsics.checkNotNull(viewFindViewById);
        return viewFindViewById;
    }

    private final void startAnimation(boolean show, Animation.AnimationListener listener) {
        if (this.mChildRoot == null) {
            return;
        }
        AnimationSet animationSet = new AnimationSet(false);
        if (show) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.95f, 1.0f, 0.95f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(250L);
            scaleAnimation.setInterpolator(SpenSettingUtilAnimation.getInterpolator(3));
            scaleAnimation.setFillAfter(true);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setInterpolator(SpenSettingUtilAnimation.getInterpolator(1));
            alphaAnimation.setDuration(150L);
            alphaAnimation.setStartOffset(150L);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setAnimationListener(listener);
        } else {
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.95f, 1.0f, 0.95f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(250L);
            scaleAnimation2.setInterpolator(SpenSettingUtilAnimation.getInterpolator(3));
            scaleAnimation2.setFillAfter(true);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setInterpolator(SpenSettingUtilAnimation.getInterpolator(1));
            alphaAnimation2.setDuration(150L);
            animationSet.addAnimation(scaleAnimation2);
            animationSet.addAnimation(alphaAnimation2);
            animationSet.setAnimationListener(listener);
        }
        RelativeLayout relativeLayout = this.mChildRoot;
        if (relativeLayout != null) {
            relativeLayout.startAnimation(animationSet);
        }
    }

    @SuppressLint({"InlinedApi", "ClickableViewAccessibility"})
    private final RelativeLayout totalLayout() {
        View viewInflate = View.inflate(getContext(), C7932R.layout.setting_spuit_layout_v40, null);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
        RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(C7932R.id.child_root);
        this.mChildRoot = relativeLayout2;
        setBackground(relativeLayout2, C7932R.drawable.spuit_bg);
        relativeLayout.setOnHoverListener(this.mOnConsumedHoverListener);
        relativeLayout.setOnTouchListener(this.mOnConsumedTouchListener);
        bodyLayout(relativeLayout);
        return relativeLayout;
    }

    private final void updateMargin() {
        RelativeLayout relativeLayout = this.mTotalLayout;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
            relativeLayout = null;
        }
        int x = (int) relativeLayout.getX();
        RelativeLayout relativeLayout3 = this.mTotalLayout;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
        } else {
            relativeLayout2 = relativeLayout3;
        }
        int y2 = (int) relativeLayout2.getY();
        ViewGroup viewGroup = this.mParentLayout;
        if (viewGroup != null && viewGroup.getLayoutDirection() == 1) {
            x = (viewGroup.getWidth() - x) - this.mSpoidLayoutWidth;
        }
        this.positionX = x;
        this.positionY = y2;
        Log.i(TAG, AbstractC0622a.m1164j(x, y2, "updateMargin() MARGIN[", SQLKeyword.COMMA, "]"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePositionRatio() {
        Rect movableRect = getMovableRect(this.mParentLayout);
        RelativeLayout relativeLayout = this.mTotalLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
            relativeLayout = null;
        }
        Rect movableRect2 = getMovableRect(relativeLayout);
        int i = movableRect2.left;
        int i2 = movableRect.left;
        this.mRatioWidth = (i - i2) / ((movableRect.right - movableRect2.right) + (i - i2));
        ViewGroup viewGroup = this.mParentLayout;
        if (viewGroup != null && viewGroup.getLayoutDirection() == 1) {
            this.mRatioWidth = 1.0f - this.mRatioWidth;
        }
        int i4 = movableRect2.top;
        int i5 = movableRect.top;
        float f = (i4 - i5) / ((movableRect.bottom - movableRect2.bottom) + (i4 - i5));
        this.mRatioHeight = f;
        Log.i(TAG, AbstractC0541b.m770l("### decide RATIO[", this.mRatioWidth, SQLKeyword.COMMA, f, "]"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTotalLayout(boolean needAnimation) {
        RelativeLayout relativeLayout = this.mTotalLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
            relativeLayout = null;
        }
        relativeLayout.invalidate();
        if (needAnimation) {
            startAnimation(true, new Animation.AnimationListener() { // from class: com.samsung.android.sdk.pen.setting.colorspoid.SpenColorSpoidLayout.updateTotalLayout.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    RelativeLayout relativeLayout2 = SpenColorSpoidLayout.this.mTotalLayout;
                    if (relativeLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
                        relativeLayout2 = null;
                    }
                    relativeLayout2.setAlpha(1.0f);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }
            });
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void close() {
        this.mColorSpoidHandle = null;
        this.mSpoidCurrentColor = null;
        RelativeLayout relativeLayout = this.mTotalLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
            relativeLayout = null;
        }
        relativeLayout.setOnHoverListener(null);
        RelativeLayout relativeLayout2 = this.mTotalLayout;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
            relativeLayout2 = null;
        }
        relativeLayout2.setOnTouchListener(null);
        this.mChildRoot = null;
        ViewGroup viewGroup = this.mParentLayout;
        if (viewGroup != null) {
            viewGroup.removeOnLayoutChangeListener(this.mLayoutChangeListener);
        }
        ViewGroup viewGroup2 = this.mParentLayout;
        if (viewGroup2 != null) {
            RelativeLayout relativeLayout3 = this.mTotalLayout;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
                relativeLayout3 = null;
            }
            viewGroup2.removeView(relativeLayout3);
        }
        this.mParentLayout = null;
        this.mColorThemeUtil.close();
        SpenSettingUtilColor spenSettingUtilColor = this.mColorNameHelper;
        if (spenSettingUtilColor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorNameHelper");
            spenSettingUtilColor = null;
        }
        spenSettingUtilColor.close();
        this.mRatioWidth = 0.0f;
        this.mRatioHeight = 0.0f;
        this.mCloseButton = null;
    }

    public final int getColorSpoidCurrentColor() {
        return this.colorSpoidCurrentColor;
    }

    public final int getColorSpoidSettingVisible() {
        RelativeLayout relativeLayout = this.mTotalLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
            relativeLayout = null;
        }
        return relativeLayout.getVisibility();
    }

    @NotNull
    public final View.OnLayoutChangeListener getMLayoutChangeListener() {
        return this.mLayoutChangeListener;
    }

    @NotNull
    public final View.OnTouchListener getMSpoidSettingListener() {
        return this.mSpoidSettingListener;
    }

    public final int getPositionX() {
        return this.positionX;
    }

    public final int getPositionY() {
        return this.positionY;
    }

    @NotNull
    public final View getSpoidView() {
        RelativeLayout relativeLayout = this.mTotalLayout;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
        return null;
    }

    @JvmOverloads
    public final void hide() {
        hide$default(this, false, 1, null);
    }

    public final void movePosition(int startMargin, int topMargin) {
        Log.i(TAG, AbstractC0622a.m1164j(startMargin, topMargin, "movePosition() :: movePositionByMargin MARGIN[", SQLKeyword.COMMA, "]"));
        ViewGroup viewGroup = this.mParentLayout;
        if (viewGroup != null) {
            int width = viewGroup.getLayoutDirection() == 1 ? (viewGroup.getWidth() - startMargin) - this.mSpoidLayoutWidth : startMargin;
            this.positionX = startMargin;
            this.positionY = topMargin;
            if (movePositionInner(width, topMargin)) {
                updateMargin();
            }
            updatePositionRatio();
        }
    }

    public final void rotatePosition() {
        if (this.mColorSpoidHandle != null && this.mIsRotated) {
            Rect movableRect = getMovableRect(this.mParentLayout);
            float f = this.mRatioWidth;
            float f4 = this.mRatioHeight;
            Log.v(TAG, "hRatio = " + f + ", vRatio = " + f4);
            if (f > 0.99d) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = 0.0f;
            }
            if (f4 > 0.99d) {
                f4 = 1.0f;
            } else if (f4 < 0.0f) {
                f4 = 0.0f;
            }
            int iRound = Math.round((movableRect.width() - this.mSpoidLayoutWidth) * f);
            int iRound2 = Math.round((movableRect.height() - this.mSpoidLayoutHeight) * f4);
            AbstractC6670b.m4744e(iRound, iRound2, "calculate result by ratio. sMargin = ", ", tMargin = ", TAG);
            Log.i(TAG, "call movePosition() in rotatePosition()");
            movePosition(iRound, iRound2);
        }
    }

    public final void setColorSpoidColor(int color) {
        this.colorSpoidCurrentColor = color;
        if (this.mSpoidCurrentColor == null) {
            return;
        }
        int color2 = this.mColorThemeUtil.getColor(color);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Log.i(TAG, "setColorSpoidColor() color=" + AbstractC2322a.m1624n(" #%08X", new Object[]{Integer.valueOf(this.colorSpoidCurrentColor)}, 1, "format(format, *args)") + " visible=" + AbstractC2322a.m1624n(" #%08X", new Object[]{Integer.valueOf(color2)}, 1, "format(format, *args)"));
        View view = this.mSpoidCurrentColor;
        Drawable background = view != null ? view.getBackground() : null;
        Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) background).setColor(color2);
        setColorVoiceAssistant(this.mSpoidCurrentColor, color2);
        View view2 = this.mSpoidCurrentColor;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    public final void setColorTheme(int theme) {
        this.mColorThemeUtil.setColorTheme(theme);
    }

    public final void setMLayoutChangeListener(@NotNull View.OnLayoutChangeListener onLayoutChangeListener) {
        Intrinsics.checkNotNullParameter(onLayoutChangeListener, "<set-?>");
        this.mLayoutChangeListener = onLayoutChangeListener;
    }

    public final void setMSpoidSettingListener(@NotNull View.OnTouchListener onTouchListener) {
        Intrinsics.checkNotNullParameter(onTouchListener, "<set-?>");
        this.mSpoidSettingListener = onTouchListener;
    }

    public final void setRotation() {
        this.mIsRotated = true;
    }

    public final void setSpoidListener(@Nullable ActionListener listener) {
        this.mActionListener = listener;
    }

    public void show() {
        show(false);
    }

    @JvmOverloads
    public final void hide(boolean needAnimation) {
        if (needAnimation) {
            startAnimation(false, new Animation.AnimationListener() { // from class: com.samsung.android.sdk.pen.setting.colorspoid.SpenColorSpoidLayout.hide.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    RelativeLayout relativeLayout = SpenColorSpoidLayout.this.mTotalLayout;
                    RelativeLayout relativeLayout2 = null;
                    if (relativeLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
                        relativeLayout = null;
                    }
                    relativeLayout.setVisibility(8);
                    RelativeLayout relativeLayout3 = SpenColorSpoidLayout.this.mTotalLayout;
                    if (relativeLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
                    } else {
                        relativeLayout2 = relativeLayout3;
                    }
                    relativeLayout2.setAlpha(1.0f);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }
            });
            return;
        }
        RelativeLayout relativeLayout = this.mTotalLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(8);
    }

    public final void show(boolean needAnimation) {
        if (this.mCloseButton == null) {
            return;
        }
        RelativeLayout relativeLayout = this.mTotalLayout;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
            relativeLayout = null;
        }
        relativeLayout.bringToFront();
        invalidate();
        RelativeLayout relativeLayout3 = this.mTotalLayout;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
            relativeLayout3 = null;
        }
        relativeLayout3.setVisibility(0);
        View view = this.mCloseButton;
        if (view != null) {
            view.requestFocus();
        }
        AbstractC6670b.m4758s("mIsRotate=", " mIsFirstShow=", TAG, this.mIsRotated, this.mIsFirstShow);
        if (this.mIsRotated) {
            if (!this.mIsFirstShow) {
                rotatePosition();
            }
            this.mIsRotated = false;
        }
        Log.i(TAG, "call movePosition() in show()");
        movePosition(this.positionX, this.positionY);
        if (!this.mIsFirstShow) {
            updateTotalLayout(needAnimation);
            return;
        }
        this.mIsFirstShow = false;
        this.mHasFirstShowAni = needAnimation;
        RelativeLayout relativeLayout4 = this.mTotalLayout;
        if (relativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
        } else {
            relativeLayout2 = relativeLayout4;
        }
        relativeLayout2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.sdk.pen.setting.colorspoid.SpenColorSpoidLayout.show.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                RelativeLayout relativeLayout5 = SpenColorSpoidLayout.this.mTotalLayout;
                if (relativeLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTotalLayout");
                    relativeLayout5 = null;
                }
                relativeLayout5.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                Log.i(SpenColorSpoidLayout.TAG, "call movePosition() in onGlobalLayout()");
                SpenColorSpoidLayout spenColorSpoidLayout = SpenColorSpoidLayout.this;
                spenColorSpoidLayout.movePosition(spenColorSpoidLayout.getPositionX(), SpenColorSpoidLayout.this.getPositionY());
                SpenColorSpoidLayout spenColorSpoidLayout2 = SpenColorSpoidLayout.this;
                spenColorSpoidLayout2.updateTotalLayout(spenColorSpoidLayout2.mHasFirstShowAni);
                SpenColorSpoidLayout.this.mHasFirstShowAni = false;
                SpenColorSpoidLayout.this.updatePositionRatio();
                ViewGroup viewGroup = SpenColorSpoidLayout.this.mParentLayout;
                if (viewGroup != null) {
                    viewGroup.addOnLayoutChangeListener(SpenColorSpoidLayout.this.getMLayoutChangeListener());
                }
            }
        });
    }
}
