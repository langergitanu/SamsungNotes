package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.colorpalette;

import android.animation.AnimatorInflater;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 P2\u00020\u0001:\u0002PQB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\u0019J\u000e\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u0017J\u0018\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0017H\u0016J\b\u0010)\u001a\u00020!H\u0016J\u001a\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010*\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010\u00152\b\u0010,\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010*\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000e\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020\nH\u0016J\b\u00100\u001a\u00020\u0017H\u0016J\u0010\u00101\u001a\u00020!2\u0006\u0010/\u001a\u00020\nH\u0016J\n\u00102\u001a\u0004\u0018\u000103H\u0016J\u0010\u00104\u001a\u00020!2\b\u00105\u001a\u0004\u0018\u00010\u001bJ\u0016\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\nJ\u0016\u00109\u001a\u00020\u00172\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\nJ\u0006\u0010:\u001a\u00020!J\u0012\u0010;\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010\u0015H\u0004J\u001a\u0010<\u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010=\u001a\u00020!2\u0006\u0010+\u001a\u00020\nH\u0002J\u0010\u0010>\u001a\u00020!2\u0006\u0010?\u001a\u00020\nH\u0002J\u0012\u0010@\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010A\u001a\u00020!2\u0006\u0010B\u001a\u00020\u0017H\u0002J\u0018\u0010C\u001a\n\u0018\u00010Dj\u0004\u0018\u0001`E2\u0006\u0010B\u001a\u00020\u0017H\u0002J\u0010\u00104\u001a\u00020!2\u0006\u0010F\u001a\u00020\u0017H\u0002J\"\u0010G\u001a\u00020\u00172\b\u0010H\u001a\u0004\u0018\u00010I2\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\nH\u0002J\u001a\u0010J\u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H$R\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010K\u001a\u00020IX¦\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0012\u0010N\u001a\u00020IX¦\u0004¢\u0006\u0006\u001a\u0004\bO\u0010M¨\u0006R"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/colorpalette/BaseColorView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "", "colorType", "getColorType", "()I", "opacity", "getOpacity", "mStringName", "", "mStringColorPrefix", "mStringComma", "mHsvColor", "", "mIsSupportSelector", "", "mCheckedChangeListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/colorpalette/BaseColorView$OnCheckedChangeListener;", "mHoverString", "", "mIsUsedCustomSelector", "mResourceId", "mAccessibilityDelegate", "Landroid/view/View$AccessibilityDelegate;", "close", "", "setOnCheckedChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSelectorIcon", "isSupported", "setSelected", "selected", "animation", "setInit", "setColor", "color", "colorName", "hsv", "setColorRes", "drawableId", "isCustomSelector", "setSelectorRes", "getSelectorDrawable", "Landroid/graphics/drawable/Drawable;", "setHoverDescription", "description", "setSelectorDegree", "flipDir", "degree", "setResourceDegree", "resetDegree", "getColor", "construct", "setColorInView", "changeType", "type", "setName", "setContentDescription", "isNeedContent", "getDescription", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "isNeedHover", "setViewDegree", "view", "Landroid/view/View;", "initView", "selectView", "getSelectView", "()Landroid/view/View;", "colorView", "getColorView", "Companion", "OnCheckedChangeListener", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBaseColorView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseColorView.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/colorpalette/BaseColorView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,339:1\n1#2:340\n*E\n"})
public abstract class BaseColorView extends FrameLayout {
    public static final int COLOR_TYPE_HSV = 2;
    public static final int COLOR_TYPE_NONE = 0;
    public static final int COLOR_TYPE_RES = 3;
    public static final int COLOR_TYPE_RGB = 1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int OPACITY_100 = 255;

    @NotNull
    private static final String TAG = "BaseColorView";
    private int colorType;

    @NotNull
    private final View.AccessibilityDelegate mAccessibilityDelegate;

    @Nullable
    private OnCheckedChangeListener mCheckedChangeListener;

    @Nullable
    private CharSequence mHoverString;

    @NotNull
    private final float[] mHsvColor;
    private boolean mIsSupportSelector;
    private boolean mIsUsedCustomSelector;
    private int mResourceId;

    @Nullable
    private String mStringColorPrefix;

    @Nullable
    private String mStringComma;

    @Nullable
    private String mStringName;
    private int opacity;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u00020\u00078\u0004X\u0085D¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/colorpalette/BaseColorView$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "COLOR_TYPE_NONE", "", "COLOR_TYPE_RGB", "COLOR_TYPE_HSV", "COLOR_TYPE_RES", "OPACITY_100", "getOPACITY_100$annotations", "getOPACITY_100", "()I", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getOPACITY_100$annotations() {
        }

        public final int getOPACITY_100() {
            return BaseColorView.OPACITY_100;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/colorpalette/BaseColorView$OnCheckedChangeListener;", "", "onCheckedChanged", "", "view", "Landroid/view/View;", "isChecked", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnCheckedChangeListener {
        void onCheckedChanged(@Nullable View view, boolean isChecked);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseColorView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mHsvColor = new float[3];
        this.mResourceId = -1;
        this.mAccessibilityDelegate = new View.AccessibilityDelegate() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.colorpalette.BaseColorView$mAccessibilityDelegate$1
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(info, "info");
                super.onInitializeAccessibilityNodeInfo(host, info);
                if (this.this$0.getColorType() == 3) {
                    info.setClassName("android.widget.Button");
                }
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View host, int eventType) {
                Intrinsics.checkNotNullParameter(host, "host");
                if (eventType == 1 || eventType == 4) {
                    this.this$0.setContentDescription(false);
                } else {
                    this.this$0.setContentDescription(true);
                }
                super.sendAccessibilityEvent(host, eventType);
            }
        };
        construct(context, null);
    }

    private final void changeType(int type) {
        if (this.colorType == type) {
            return;
        }
        this.mStringName = null;
        setHoverDescription((CharSequence) null);
        setContentDescription((CharSequence) null);
        this.colorType = type;
    }

    private final void construct(Context context, AttributeSet attrs) {
        this.mStringColorPrefix = context.getResources().getString(C9086R.string.pen_string_color);
        this.mStringComma = context.getResources().getString(C9086R.string.pen_string_comma);
        this.mCheckedChangeListener = null;
        this.mIsSupportSelector = true;
        this.colorType = 0;
        initView(context, attrs);
        setInit();
        setAccessibilityDelegate(this.mAccessibilityDelegate);
        if (SpenSettingUtil.needRecoilVI()) {
            setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, C9086R.animator.spen_recoil_button_selector));
        }
    }

    private final StringBuilder getDescription(boolean isNeedContent) {
        if (!isNeedContent) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (this.colorType == 3) {
            sb.append(this.mHoverString);
            return sb;
        }
        sb.append(this.mStringName);
        sb.append(this.mStringComma + " ");
        sb.append(this.mStringColorPrefix);
        return sb;
    }

    public static final int getOPACITY_100() {
        return INSTANCE.getOPACITY_100();
    }

    private final void setColorInView(int color) {
        Drawable background = getColorView().getBackground();
        GradientDrawable gradientDrawable = background instanceof GradientDrawable ? (GradientDrawable) background : null;
        if (gradientDrawable != null) {
            gradientDrawable.setColor(color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setContentDescription(boolean isNeedContent) {
        setContentDescription(getDescription(isNeedContent));
    }

    private final void setName(String colorName) {
        if (colorName == null) {
            setContentDescription((CharSequence) null);
        } else {
            this.mStringName = colorName;
        }
    }

    private final boolean setViewDegree(View view, int flipDir, int degree) {
        if (view == null) {
            return false;
        }
        if (flipDir == -1) {
            view.setRotationY(degree);
        } else if (flipDir != 1) {
            view.setRotation(degree);
        } else {
            view.setRotationX(degree);
        }
        return true;
    }

    public void close() {
        this.mHoverString = null;
        this.mStringColorPrefix = null;
        this.mStringComma = null;
    }

    public final boolean getColor(@Nullable float[] hsv) {
        if (hsv == null || hsv.length != 3) {
            return false;
        }
        float[] fArr = this.mHsvColor;
        System.arraycopy(fArr, 0, hsv, 0, fArr.length);
        return true;
    }

    public final int getColorType() {
        return this.colorType;
    }

    @NotNull
    public abstract View getColorView();

    public final int getOpacity() {
        return this.opacity;
    }

    @NotNull
    public abstract View getSelectView();

    @Nullable
    public Drawable getSelectorDrawable() {
        Drawable background;
        if (this.mIsUsedCustomSelector && (background = getSelectView().getBackground()) != null) {
            return background;
        }
        return null;
    }

    public abstract void initView(@NotNull Context context, @Nullable AttributeSet attrs);

    /* JADX INFO: renamed from: isCustomSelector, reason: from getter */
    public boolean getMIsUsedCustomSelector() {
        return this.mIsUsedCustomSelector;
    }

    public final void resetDegree() {
        setViewDegree(getSelectView(), -1, 0);
        setViewDegree(getSelectView(), 0, 0);
        setViewDegree(getSelectView(), 1, 0);
        setViewDegree(getColorView(), -1, 0);
        setViewDegree(getColorView(), 0, 0);
        setViewDegree(getColorView(), 1, 0);
    }

    public void setColor(int color, @Nullable String colorName) {
        changeType(1);
        this.mResourceId = -1;
        Color.colorToHSV(color, this.mHsvColor);
        this.opacity = Color.alpha(color);
        setColorInView(color);
        setName(colorName);
        setHoverDescription(colorName != null);
    }

    public void setColorRes(int drawableId) {
        changeType(3);
        float[] fArr = this.mHsvColor;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        this.opacity = OPACITY_100;
        if (drawableId != this.mResourceId) {
            getColorView().setBackgroundResource(drawableId);
            return;
        }
        Logger.m11003i(TAG, "setColorRes() drawableId is same. (" + drawableId + ")");
    }

    public final void setHoverDescription(@Nullable CharSequence description) {
        SpenSettingUtilHover.setHoverText(this, description);
        this.mHoverString = description;
    }

    public void setInit() {
        changeType(0);
        float[] fArr = this.mHsvColor;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        this.opacity = OPACITY_100;
        this.mIsUsedCustomSelector = false;
        this.mResourceId = -1;
    }

    public final void setOnCheckedChangeListener(@Nullable OnCheckedChangeListener listener) {
        this.mCheckedChangeListener = listener;
    }

    public final boolean setResourceDegree(int flipDir, int degree) {
        return setViewDegree(getColorView(), flipDir, degree);
    }

    public boolean setSelected(boolean selected, boolean animation) {
        OnCheckedChangeListener onCheckedChangeListener;
        boolean z = isSelected() != selected;
        super.setSelected(selected);
        if (this.mIsSupportSelector) {
            if (selected) {
                getSelectView().setVisibility(0);
            } else {
                getSelectView().setVisibility(8);
            }
            if (selected && animation) {
                SpenSettingUtilAnimation.colorSelectAnimation(getSelectView());
            }
        }
        if (z && (onCheckedChangeListener = this.mCheckedChangeListener) != null) {
            onCheckedChangeListener.onCheckedChanged(this, selected);
        }
        return true;
    }

    public final boolean setSelectorDegree(int flipDir, int degree) {
        return setViewDegree(getSelectView(), flipDir, degree);
    }

    public final void setSelectorIcon(boolean isSupported) {
        this.mIsSupportSelector = isSupported;
        if (isSupported) {
            setSelected(isSelected(), false);
        } else {
            getSelectView().setVisibility(8);
        }
    }

    public void setSelectorRes(int drawableId) {
        if (this.colorType != 3) {
            return;
        }
        Drawable background = getSelectView().getBackground();
        if (background != null && (background instanceof BitmapDrawable)) {
            getSelectView().setBackground(null);
            ((BitmapDrawable) background).getBitmap().recycle();
        }
        getSelectView().setBackgroundResource(drawableId);
        this.mIsUsedCustomSelector = true;
    }

    private final void setHoverDescription(boolean isNeedHover) {
        SpenSettingUtilHover.setHoverText(this, getDescription(isNeedHover));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseColorView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mHsvColor = new float[3];
        this.mResourceId = -1;
        this.mAccessibilityDelegate = new View.AccessibilityDelegate() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.colorpalette.BaseColorView$mAccessibilityDelegate$1
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(info, "info");
                super.onInitializeAccessibilityNodeInfo(host, info);
                if (this.this$0.getColorType() == 3) {
                    info.setClassName("android.widget.Button");
                }
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View host, int eventType) {
                Intrinsics.checkNotNullParameter(host, "host");
                if (eventType == 1 || eventType == 4) {
                    this.this$0.setContentDescription(false);
                } else {
                    this.this$0.setContentDescription(true);
                }
                super.sendAccessibilityEvent(host, eventType);
            }
        };
        construct(context, attributeSet);
    }

    public boolean setColor(@Nullable float[] hsv, @Nullable String colorName) {
        return setColor(hsv, OPACITY_100, colorName);
    }

    public boolean setColor(@Nullable float[] hsv, int opacity, @Nullable String colorName) {
        if (hsv == null || hsv.length < this.mHsvColor.length) {
            return false;
        }
        float f = hsv[0];
        float f4 = hsv[1];
        float f5 = hsv[2];
        StringBuilder sbM1176v = AbstractC0622a.m1176v("setColor() hue=", f, " saturation=", f4, " value=");
        sbM1176v.append(f5);
        Logger.m11003i(TAG, sbM1176v.toString());
        changeType(2);
        this.mResourceId = -1;
        float[] fArr = this.mHsvColor;
        System.arraycopy(hsv, 0, fArr, 0, fArr.length);
        this.opacity = opacity;
        setColorInView(SpenSettingUtil.HSVToColor(opacity, this.mHsvColor));
        setName(colorName);
        setHoverDescription(colorName != null);
        return true;
    }
}
