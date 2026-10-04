package com.samsung.android.sdk.pen.setting;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.pen.setting.common.SpenCommonTitleLayout;
import com.samsung.android.sdk.pen.setting.common.SpenConsumedListener;
import com.samsung.android.sdk.pen.setting.common.SpenPopupInOutAnimation;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.widget.SpenNestedScrollView;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0019\b\u0016\u0018\u0000 }2\u00020\u0001:\u0003}~\u007fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0004J\b\u0010&\u001a\u00020\u000fH\u0004J\u0010\u0010,\u001a\u00020\"2\b\u0010-\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020\u0007H\u0004J\u0018\u00100\u001a\u00020\"2\u0006\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u0017H\u0004J\u0010\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020\u0007H\u0004J\u0018\u00105\u001a\u00020\"2\u0006\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u0017H\u0004J\u001a\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%2\b\u00108\u001a\u0004\u0018\u000109H\u0004J\u001a\u0010:\u001a\u00020\"2\b\u0010;\u001a\u0004\u0018\u00010%2\b\u00108\u001a\u0004\u0018\u00010<J\u0010\u0010=\u001a\u00020\"2\u0006\u0010>\u001a\u00020\u0017H\u0004J\u0006\u0010?\u001a\u00020\"J\u0006\u0010@\u001a\u00020\u0007J\u000e\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0017J\u0012\u0010C\u001a\u00020\u00072\b\u0010D\u001a\u0004\u0018\u00010EH\u0004J\"\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020\u00172\u0006\u0010H\u001a\u00020\u00172\b\u0010I\u001a\u0004\u0018\u00010EH\u0004J(\u0010J\u001a\u00020%2\u0006\u0010G\u001a\u00020\u00172\u0006\u0010H\u001a\u00020\u00172\b\u0010I\u001a\u0004\u0018\u00010E2\u0006\u0010K\u001a\u00020\u0007J\u0012\u0010L\u001a\u00020\"2\b\u0010M\u001a\u0004\u0018\u00010NH\u0014J\u0018\u0010O\u001a\u00020\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010P\u001a\u00020\u0007H\u0004J?\u0010Q\u001a\u00020%2\u0006\u0010G\u001a\u00020\u00172\b\u0010I\u001a\u0004\u0018\u00010E2\u0006\u0010H\u001a\u00020\u00172\u0016\u0010R\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010T0S\"\u0004\u0018\u00010TH\u0004¢\u0006\u0002\u0010UJ\u0012\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010YH\u0004J\u0010\u0010V\u001a\u00020W2\u0006\u0010Z\u001a\u00020\u0017H\u0004J\b\u0010[\u001a\u00020\u0007H\u0004J\u0010\u0010\\\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010\u001cJ\b\u0010]\u001a\u00020\"H\u0004J\u0012\u0010^\u001a\u00020\"2\b\u0010-\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010_\u001a\u00020\"2\u0006\u0010B\u001a\u00020\u0017H\u0016J\u0010\u0010`\u001a\u00020\u00072\u0006\u0010a\u001a\u00020bH\u0016J\u0018\u0010c\u001a\u00020\"2\u0006\u0010d\u001a\u00020%2\u0006\u0010B\u001a\u00020\u0017H\u0014J\u0016\u0010_\u001a\u00020\"2\u0006\u0010B\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u0007J(\u0010e\u001a\u00020\"2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020\u00172\u0006\u0010i\u001a\u00020\u00172\u0006\u0010j\u001a\u00020\u0017H\u0014J\u0010\u0010k\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u001a\u0010l\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010m\u001a\u00020\u00072\u0006\u0010n\u001a\u00020%2\u0006\u0010o\u001a\u00020\u0007H\u0002J\u0010\u0010p\u001a\u00020\"2\u0006\u0010\u0006\u001a\u00020\u0007H\u0004J\u0010\u0010q\u001a\u00020\"2\u0006\u0010B\u001a\u00020\u0017H\u0004J\u0010\u0010y\u001a\u00020\"2\u0006\u0010z\u001a\u00020\u0017H\u0002J\u0018\u0010{\u001a\u00020\"2\u0006\u0010n\u001a\u00020%2\u0006\u0010|\u001a\u00020\u0017H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010'\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0014\u0010r\u001a\u00020\u00178DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bs\u0010)R\u0014\u0010t\u001a\u00020\u00178DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bu\u0010)R\u0014\u0010v\u001a\u00020%8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bw\u0010x¨\u0006\u0080\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenPopupLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "hasAnimation", "", "getHasAnimation", "()Z", "setHasAnimation", "(Z)V", "mTitle", "Lcom/samsung/android/sdk/pen/setting/common/SpenCommonTitleLayout;", "mChild", "Landroid/view/ViewGroup;", "mContentBody", "Landroidx/core/widget/NestedScrollView;", "mConsumedListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenConsumedListener;", "mPopupAnimation", "Lcom/samsung/android/sdk/pen/setting/common/SpenPopupInOutAnimation;", "mRadius", "", "mOrientation", "mViewListener", "Lcom/samsung/android/sdk/pen/setting/SpenPopupLayout$ViewListener;", "mHideAnimationListener", "Landroid/view/animation/Animation$AnimationListener;", "mOrientationChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenPopupLayout$OrientationChangedListener;", "mScrollBarThumbOffset", "", "close", "", "setContentView", "view", "Landroid/view/View;", "getChangeBoundsSceneRoot", "orientation", "getOrientation", "()I", "setOrientation", "(I)V", "setOrientationChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setContentVerticalScrollBarEnable", "enableScrollBar", "scrollContentToPosition", "x", "y", "changeContentRule", "isBelowTitle", "setScrollBarThumbOffset", "offsetToTitle", "offsetToNoTitle", ActionHandler.PARAMS, "Landroid/widget/FrameLayout$LayoutParams;", "addViewInTop", "child", "Landroid/view/ViewGroup$LayoutParams;", "setContentTopMargin", "topMargin", "hideCloseButton", "requestCloseButtonAccessibilityFocus", "setCloseButtonVisibility", "visibility", "setCloseButtonInfo", "closeClickListener", "Landroid/view/View$OnClickListener;", "addButtonNextToCloseInTitle", "resId", "descriptionId", "buttonClickListener", "addButtonInTitle", "changedColorByState", "setCloseButtonDescription", "contentDescription", "", "setButtonStateChanged", "isClickable", "addHeaderButtonInTitle", "formatArgs", "", "", "(ILandroid/view/View$OnClickListener;I[Ljava/lang/Object;)Landroid/view/View;", "setTitleText", "Landroid/widget/TextView;", "text", "", "stringResId", "showAnimation", "hideAnimation", "cancelAnimation", "setVisibilityChangedListener", "setVisibility", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onVisibilityChanged", "changedView", "setRoundedBackground", "radius", "", "bgColor", "strokeSize", "strokeColor", "initView", "initBackground", "setRadiusInScrollView", "scrollView", "bottomOnly", "setAnimation", "setTitleVisibility", "childHeight", "getChildHeight", "childWidth", "getChildWidth", "titleView", "getTitleView", "()Landroid/view/View;", "setContentWidth", "width", "updateScrollBarThumb", "offsetTop", "Companion", "ViewListener", "OrientationChangedListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenPopupLayout extends RelativeLayout {
    private static final int NORMAL_SCROLL_BAR_THUMB_INDEX = 0;
    private static final int NO_TITLE_SCROLL_BAR_THUMB_INDEX = 1;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;

    @NotNull
    private static final String TAG = "SpenSettingPopupType";
    private boolean hasAnimation;
    private ViewGroup mChild;
    private SpenConsumedListener mConsumedListener;
    private NestedScrollView mContentBody;

    @Nullable
    private Animation.AnimationListener mHideAnimationListener;
    private int mOrientation;

    @Nullable
    private OrientationChangedListener mOrientationChangedListener;

    @NotNull
    private SpenPopupInOutAnimation mPopupAnimation;
    private int mRadius;

    @Nullable
    private int[] mScrollBarThumbOffset;
    private SpenCommonTitleLayout mTitle;

    @Nullable
    private ViewListener mViewListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenPopupLayout$OrientationChangedListener;", "", "onOrientationChanged", "", "orientation", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OrientationChangedListener {
        void onOrientationChanged(int orientation);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenPopupLayout$ViewListener;", "", "onVisibilityChanged", "", "visibility", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ViewListener {
        void onVisibilityChanged(int visibility);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPopupLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mOrientation = 1;
        initView(context);
        this.mPopupAnimation = new SpenPopupInOutAnimation(getChildAt(0));
    }

    private final void initBackground(Context context, ViewGroup view) {
        if (view == null) {
            return;
        }
        view.setElevation(context.getResources().getDimensionPixelSize(C7932R.dimen.setting_popup_bg_elevation));
        view.setBackgroundResource(C7932R.drawable.dialog_bg);
        SpenSettingUtil.setShadowAlpha(view, 0.5f);
    }

    private final void initView(Context context) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C7932R.dimen.setting_favorite_scrollbar_offset_top_normal);
        setScrollBarThumbOffset(dimensionPixelSize, dimensionPixelSize);
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ((LayoutInflater) systemService).inflate(C7932R.layout.setting_popup_layout, (ViewGroup) this, true);
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.setFocusable(false);
        }
        this.mTitle = (SpenCommonTitleLayout) findViewById(C7932R.id.popup_title);
        this.mChild = (ViewGroup) findViewById(C7932R.id.total_layout);
        SpenConsumedListener spenConsumedListener = new SpenConsumedListener();
        this.mConsumedListener = spenConsumedListener;
        ViewGroup viewGroup = this.mChild;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChild");
            viewGroup = null;
        }
        spenConsumedListener.setConsumedListener(this, viewGroup);
        this.mContentBody = (NestedScrollView) findViewById(C7932R.id.popup_body);
        this.mRadius = context.getResources().getDimensionPixelSize(C7932R.dimen.common_setting_layout_radius);
        NestedScrollView nestedScrollView = this.mContentBody;
        if (nestedScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentBody");
            nestedScrollView = null;
        }
        setRadiusInScrollView(nestedScrollView, true);
        ViewGroup viewGroup3 = this.mChild;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChild");
        } else {
            viewGroup2 = viewGroup3;
        }
        initBackground(context, viewGroup2);
    }

    private final void setContentWidth(int width) {
        SpenCommonTitleLayout spenCommonTitleLayout = this.mTitle;
        NestedScrollView nestedScrollView = null;
        if (spenCommonTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            spenCommonTitleLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = spenCommonTitleLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.width = width;
        SpenCommonTitleLayout spenCommonTitleLayout2 = this.mTitle;
        if (spenCommonTitleLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            spenCommonTitleLayout2 = null;
        }
        spenCommonTitleLayout2.setLayoutParams(layoutParams2);
        NestedScrollView nestedScrollView2 = this.mContentBody;
        if (nestedScrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentBody");
            nestedScrollView2 = null;
        }
        ViewGroup.LayoutParams layoutParams3 = nestedScrollView2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        layoutParams4.width = width;
        NestedScrollView nestedScrollView3 = this.mContentBody;
        if (nestedScrollView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentBody");
        } else {
            nestedScrollView = nestedScrollView3;
        }
        nestedScrollView.setLayoutParams(layoutParams4);
    }

    private final boolean setRadiusInScrollView(View scrollView, boolean bottomOnly) {
        if (!(scrollView instanceof SpenNestedScrollView)) {
            return false;
        }
        if (!bottomOnly) {
            ((SpenNestedScrollView) scrollView).setRadius(this.mRadius);
            return true;
        }
        int i = this.mRadius;
        ((SpenNestedScrollView) scrollView).setRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, i, i, i, i});
        return true;
    }

    private final void updateScrollBarThumb(View scrollView, int offsetTop) {
        Drawable drawable = scrollView.getContext().getResources().getDrawable(C7932R.drawable.setting_scrollbar_thumb);
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        layerDrawable.mutate();
        int i = Build.VERSION.SDK_INT;
        layerDrawable.setLayerInsetTop(0, offsetTop);
        if (i >= 29) {
            scrollView.setVerticalScrollbarThumbDrawable(layerDrawable);
            return;
        }
        try {
            Field declaredField = View.class.getDeclaredField("mScrollCache");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(scrollView);
            Field declaredField2 = obj.getClass().getDeclaredField("scrollBar");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Method declaredMethod = obj2.getClass().getDeclaredMethod("setVerticalThumbDrawable", Drawable.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj2, layerDrawable);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    @NotNull
    public final View addButtonInTitle(int resId, int descriptionId, @Nullable View.OnClickListener buttonClickListener, boolean changedColorByState) {
        SpenCommonTitleLayout spenCommonTitleLayout = this.mTitle;
        if (spenCommonTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            spenCommonTitleLayout = null;
        }
        return SpenCommonTitleLayout.addButton$default(spenCommonTitleLayout, resId, descriptionId, buttonClickListener, changedColorByState, false, 16, null);
    }

    @NotNull
    public final View addButtonNextToCloseInTitle(int resId, int descriptionId, @Nullable View.OnClickListener buttonClickListener) {
        SpenCommonTitleLayout spenCommonTitleLayout = this.mTitle;
        if (spenCommonTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            spenCommonTitleLayout = null;
        }
        return spenCommonTitleLayout.addButtonNextToClose(resId, descriptionId, buttonClickListener);
    }

    @NotNull
    public final View addHeaderButtonInTitle(int resId, @Nullable View.OnClickListener buttonClickListener, int descriptionId, @NotNull Object... formatArgs) {
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        SpenCommonTitleLayout spenCommonTitleLayout = this.mTitle;
        if (spenCommonTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            spenCommonTitleLayout = null;
        }
        return spenCommonTitleLayout.addHeaderButton(resId, buttonClickListener, descriptionId, Arrays.copyOf(formatArgs, formatArgs.length));
    }

    public final void addViewInTop(@Nullable View child, @Nullable ViewGroup.LayoutParams params) {
        ViewGroup viewGroup = this.mChild;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChild");
            viewGroup = null;
        }
        viewGroup.addView(child, params);
    }

    public final void cancelAnimation() {
        this.mPopupAnimation.cancelAnimation();
    }

    public final void changeContentRule(boolean isBelowTitle) {
        NestedScrollView nestedScrollView = null;
        if (isBelowTitle) {
            NestedScrollView nestedScrollView2 = this.mContentBody;
            if (nestedScrollView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentBody");
                nestedScrollView2 = null;
            }
            ViewGroup.LayoutParams layoutParams = nestedScrollView2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            SpenCommonTitleLayout spenCommonTitleLayout = this.mTitle;
            if (spenCommonTitleLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitle");
                spenCommonTitleLayout = null;
            }
            layoutParams2.addRule(3, spenCommonTitleLayout.getId());
            layoutParams2.topMargin = 0;
            NestedScrollView nestedScrollView3 = this.mContentBody;
            if (nestedScrollView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentBody");
                nestedScrollView3 = null;
            }
            nestedScrollView3.setLayoutParams(layoutParams2);
        } else {
            NestedScrollView nestedScrollView4 = this.mContentBody;
            if (nestedScrollView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentBody");
                nestedScrollView4 = null;
            }
            ViewGroup.LayoutParams layoutParams3 = nestedScrollView4.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
            layoutParams4.addRule(3, 0);
            layoutParams4.topMargin = 0;
            NestedScrollView nestedScrollView5 = this.mContentBody;
            if (nestedScrollView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentBody");
                nestedScrollView5 = null;
            }
            nestedScrollView5.setLayoutParams(layoutParams4);
            ViewGroup viewGroup = this.mChild;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mChild");
                viewGroup = null;
            }
            SpenCommonTitleLayout spenCommonTitleLayout2 = this.mTitle;
            if (spenCommonTitleLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitle");
                spenCommonTitleLayout2 = null;
            }
            viewGroup.bringChildToFront(spenCommonTitleLayout2);
        }
        int[] iArr = this.mScrollBarThumbOffset;
        if (iArr != null) {
            NestedScrollView nestedScrollView6 = this.mContentBody;
            if (nestedScrollView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentBody");
            } else {
                nestedScrollView = nestedScrollView6;
            }
            updateScrollBarThumb(nestedScrollView, iArr[!isBelowTitle ? 1 : 0]);
        }
    }

    public void close() {
        SpenConsumedListener spenConsumedListener = this.mConsumedListener;
        NestedScrollView nestedScrollView = null;
        if (spenConsumedListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConsumedListener");
            spenConsumedListener = null;
        }
        spenConsumedListener.close();
        this.mPopupAnimation.close();
        this.mHideAnimationListener = null;
        this.mOrientationChangedListener = null;
        this.mViewListener = null;
        SpenCommonTitleLayout spenCommonTitleLayout = this.mTitle;
        if (spenCommonTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            spenCommonTitleLayout = null;
        }
        spenCommonTitleLayout.setOnCloseButtonClickListener(null);
        SpenCommonTitleLayout spenCommonTitleLayout2 = this.mTitle;
        if (spenCommonTitleLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            spenCommonTitleLayout2 = null;
        }
        spenCommonTitleLayout2.close();
        ViewGroup viewGroup = this.mChild;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChild");
            viewGroup = null;
        }
        viewGroup.removeAllViews();
        NestedScrollView nestedScrollView2 = this.mContentBody;
        if (nestedScrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentBody");
        } else {
            nestedScrollView = nestedScrollView2;
        }
        nestedScrollView.removeAllViews();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getActionMasked() == 5) {
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }

    @NotNull
    public final ViewGroup getChangeBoundsSceneRoot() {
        View childAt = getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) childAt;
    }

    public final int getChildHeight() {
        ViewGroup viewGroup = this.mChild;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChild");
            viewGroup = null;
        }
        return viewGroup.getHeight();
    }

    public final int getChildWidth() {
        ViewGroup viewGroup = this.mChild;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChild");
            viewGroup = null;
        }
        return viewGroup.getWidth();
    }

    public final boolean getHasAnimation() {
        return this.hasAnimation;
    }

    /* JADX INFO: renamed from: getOrientation, reason: from getter */
    public final int getMOrientation() {
        return this.mOrientation;
    }

    @NotNull
    public final View getTitleView() {
        SpenCommonTitleLayout spenCommonTitleLayout = this.mTitle;
        if (spenCommonTitleLayout != null) {
            return spenCommonTitleLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTitle");
        return null;
    }

    public final boolean hideAnimation(@Nullable Animation.AnimationListener listener) {
        this.mHideAnimationListener = listener;
        return this.mPopupAnimation.hideAnimation(new Animation.AnimationListener() { // from class: com.samsung.android.sdk.pen.setting.SpenPopupLayout.hideAnimation.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                boolean hasAnimation = SpenPopupLayout.this.getHasAnimation();
                SpenPopupLayout.this.setAnimation(false);
                SpenPopupLayout.this.setVisibility(8, false);
                SpenPopupLayout.this.setAnimation(hasAnimation);
                Animation.AnimationListener animationListener = SpenPopupLayout.this.mHideAnimationListener;
                if (animationListener != null) {
                    animationListener.onAnimationEnd(animation);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Animation.AnimationListener animationListener = SpenPopupLayout.this.mHideAnimationListener;
                if (animationListener != null) {
                    animationListener.onAnimationRepeat(animation);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Animation.AnimationListener animationListener = SpenPopupLayout.this.mHideAnimationListener;
                if (animationListener != null) {
                    animationListener.onAnimationStart(animation);
                }
            }
        });
    }

    public final void hideCloseButton() {
        setCloseButtonVisibility(8);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NotNull View changedView, int visibility) {
        ViewListener viewListener;
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        if (Intrinsics.areEqual(changedView, this) && (viewListener = this.mViewListener) != null) {
            viewListener.onVisibilityChanged(visibility);
        }
        super.onVisibilityChanged(changedView, visibility);
    }

    public final boolean requestCloseButtonAccessibilityFocus() {
        SpenCommonTitleLayout spenCommonTitleLayout = this.mTitle;
        if (spenCommonTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            spenCommonTitleLayout = null;
        }
        return spenCommonTitleLayout.requestCloseButtonAccessibilityEvent(8);
    }

    public final void scrollContentToPosition(int x, int y2) {
        NestedScrollView nestedScrollView = this.mContentBody;
        if (nestedScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentBody");
            nestedScrollView = null;
        }
        nestedScrollView.scrollTo(x, y2);
    }

    public final void setAnimation(boolean hasAnimation) {
        this.hasAnimation = hasAnimation;
    }

    public final void setButtonStateChanged(@NotNull View view, boolean isClickable) {
        Intrinsics.checkNotNullParameter(view, "view");
        SpenCommonTitleLayout spenCommonTitleLayout = this.mTitle;
        if (spenCommonTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            spenCommonTitleLayout = null;
        }
        spenCommonTitleLayout.setButtonStateChanged(view, isClickable);
    }

    public void setCloseButtonDescription(@Nullable String contentDescription) {
        SpenCommonTitleLayout spenCommonTitleLayout = this.mTitle;
        if (spenCommonTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            spenCommonTitleLayout = null;
        }
        spenCommonTitleLayout.setCloseButtonDescription(contentDescription);
    }

    public final boolean setCloseButtonInfo(@Nullable View.OnClickListener closeClickListener) {
        SpenCommonTitleLayout spenCommonTitleLayout = this.mTitle;
        if (spenCommonTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            spenCommonTitleLayout = null;
        }
        spenCommonTitleLayout.setOnCloseButtonClickListener(closeClickListener);
        return true;
    }

    public final boolean setCloseButtonVisibility(int visibility) {
        SpenCommonTitleLayout spenCommonTitleLayout = this.mTitle;
        if (spenCommonTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            spenCommonTitleLayout = null;
        }
        spenCommonTitleLayout.setCloseButtonVisibility(visibility);
        return true;
    }

    public final void setContentTopMargin(int topMargin) {
        NestedScrollView nestedScrollView = this.mContentBody;
        NestedScrollView nestedScrollView2 = null;
        if (nestedScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentBody");
            nestedScrollView = null;
        }
        ViewGroup.LayoutParams layoutParams = nestedScrollView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = topMargin;
        NestedScrollView nestedScrollView3 = this.mContentBody;
        if (nestedScrollView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentBody");
        } else {
            nestedScrollView2 = nestedScrollView3;
        }
        nestedScrollView2.setLayoutParams(layoutParams2);
    }

    public final void setContentVerticalScrollBarEnable(boolean enableScrollBar) {
        NestedScrollView nestedScrollView = this.mContentBody;
        NestedScrollView nestedScrollView2 = null;
        if (nestedScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentBody");
            nestedScrollView = null;
        }
        if (nestedScrollView.isVerticalScrollBarEnabled() != enableScrollBar) {
            NestedScrollView nestedScrollView3 = this.mContentBody;
            if (nestedScrollView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentBody");
            } else {
                nestedScrollView2 = nestedScrollView3;
            }
            nestedScrollView2.setVerticalScrollBarEnabled(enableScrollBar);
        }
    }

    public final void setContentView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        setContentView(view, null);
    }

    public final void setHasAnimation(boolean z) {
        this.hasAnimation = z;
    }

    public final void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            setContentWidth(getContext().getResources().getDimensionPixelSize(this.mOrientation == 1 ? C7932R.dimen.setting_common_popup_width_v60 : C7932R.dimen.setting_common_popup_landscape_width));
            OrientationChangedListener orientationChangedListener = this.mOrientationChangedListener;
            if (orientationChangedListener != null) {
                orientationChangedListener.onOrientationChanged(i);
            }
        }
    }

    public final void setOrientationChangedListener(@Nullable OrientationChangedListener listener) {
        this.mOrientationChangedListener = listener;
    }

    public void setRoundedBackground(float radius, int bgColor, int strokeSize, int strokeColor) {
        ViewGroup viewGroup = this.mChild;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChild");
            viewGroup = null;
        }
        Drawable background = viewGroup.getBackground();
        GradientDrawable gradientDrawable = background instanceof GradientDrawable ? (GradientDrawable) background : null;
        if (gradientDrawable == null) {
            return;
        }
        gradientDrawable.mutate();
        gradientDrawable.setCornerRadius(radius);
        gradientDrawable.setColor(bgColor);
        gradientDrawable.setStroke(strokeSize, strokeColor);
        ViewGroup viewGroup3 = this.mChild;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChild");
        } else {
            viewGroup2 = viewGroup3;
        }
        viewGroup2.setBackground(gradientDrawable);
    }

    public final void setScrollBarThumbOffset(int offsetToTitle, int offsetToNoTitle) {
        if (this.mScrollBarThumbOffset == null) {
            this.mScrollBarThumbOffset = new int[2];
        }
        int[] iArr = this.mScrollBarThumbOffset;
        if (iArr != null) {
            iArr[0] = offsetToTitle;
            iArr[1] = offsetToNoTitle;
        }
    }

    @NotNull
    public final TextView setTitleText(@Nullable CharSequence text) {
        SpenCommonTitleLayout spenCommonTitleLayout = this.mTitle;
        if (spenCommonTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            spenCommonTitleLayout = null;
        }
        TextView text2 = spenCommonTitleLayout.setText(0);
        text2.setText(text);
        return text2;
    }

    public final void setTitleVisibility(int visibility) {
        SpenCommonTitleLayout spenCommonTitleLayout = this.mTitle;
        NestedScrollView nestedScrollView = null;
        if (spenCommonTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            spenCommonTitleLayout = null;
        }
        spenCommonTitleLayout.setVisibility(visibility);
        NestedScrollView nestedScrollView2 = this.mContentBody;
        if (nestedScrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentBody");
        } else {
            nestedScrollView = nestedScrollView2;
        }
        setRadiusInScrollView(nestedScrollView, visibility != 8);
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        boolean z = this.hasAnimation;
        AbstractC0000a.m26w(AbstractC2821a.m2226q("setVisibility(", visibility, ") hasAnimation=", z, " current="), TAG, getVisibility());
        setVisibility(visibility, this.hasAnimation);
    }

    public void setVisibilityChangedListener(@Nullable ViewListener listener) {
        this.mViewListener = listener;
    }

    public final boolean showAnimation() {
        Log.i(TAG, "showAnimation()");
        return this.mPopupAnimation.showAnimation(null);
    }

    public final void setContentView(@NotNull View view, @Nullable FrameLayout.LayoutParams params) {
        Intrinsics.checkNotNullParameter(view, "view");
        NestedScrollView nestedScrollView = null;
        if (params == null) {
            NestedScrollView nestedScrollView2 = this.mContentBody;
            if (nestedScrollView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentBody");
            } else {
                nestedScrollView = nestedScrollView2;
            }
            nestedScrollView.addView(view);
            return;
        }
        NestedScrollView nestedScrollView3 = this.mContentBody;
        if (nestedScrollView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentBody");
        } else {
            nestedScrollView = nestedScrollView3;
        }
        nestedScrollView.addView(view, params);
    }

    @NotNull
    public final TextView setTitleText(int stringResId) {
        SpenCommonTitleLayout spenCommonTitleLayout = this.mTitle;
        if (spenCommonTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            spenCommonTitleLayout = null;
        }
        return spenCommonTitleLayout.setText(stringResId);
    }

    public final void setVisibility(int visibility, boolean hasAnimation) {
        boolean z = hasAnimation && visibility != getVisibility();
        boolean zIsShown = isShown();
        StringBuilder sbM2226q = AbstractC2821a.m2226q("setVisibility(", visibility, SQLKeyword.COMMA, hasAnimation, ") isShown()=");
        sbM2226q.append(zIsShown);
        sbM2226q.append(" isAnimation=");
        sbM2226q.append(z);
        Log.i(TAG, sbM2226q.toString());
        cancelAnimation();
        if (!z) {
            super.setVisibility(visibility);
            return;
        }
        if (visibility == 0) {
            super.setVisibility(visibility);
            showAnimation();
        } else if (visibility != 8) {
            super.setVisibility(visibility);
        } else {
            hideAnimation(null);
        }
    }
}
