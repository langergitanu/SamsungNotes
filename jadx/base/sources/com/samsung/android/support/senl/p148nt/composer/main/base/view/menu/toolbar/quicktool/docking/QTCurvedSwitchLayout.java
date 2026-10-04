package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.bottomappbar.RunnableC4587a;
import com.google.android.material.oneui.floatingdock.ViewOnTouchListenerC4799j;
import com.samsung.android.sdk.pen.setting.common.RunnableC7563h;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTContainer;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilDrawable;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 a2\u00020\u00012\u00020\u0002:\u0002`aB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ(\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0018H\u0002J\u000e\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\u0006J\u0006\u0010-\u001a\u00020&J\u0010\u0010.\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010$J;\u00100\u001a\u00020&2\u0006\u0010,\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00062\b\u00103\u001a\u0004\u0018\u0001042\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u00106J \u00107\u001a\u00020&2\u0006\u0010,\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u0006H\u0002J\u0018\u0010:\u001a\u00020&2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\fH\u0002J \u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u001bH\u0002J\u0010\u0010B\u001a\u00020&2\u0006\u0010A\u001a\u00020\u001bH\u0003J\u0018\u0010C\u001a\u00020&2\u0006\u0010D\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020FH\u0002J\u0018\u0010G\u001a\u00020&2\u0006\u0010D\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010H\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u0018H\u0002J\u0018\u0010I\u001a\u00020&2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010J\u001a\u00020FH\u0002J\u0010\u0010K\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006H\u0002J\u0010\u0010L\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006H\u0002J\u000e\u0010M\u001a\u00020&2\u0006\u0010D\u001a\u00020\u0018J\u0010\u0010N\u001a\u00020&2\u0006\u0010D\u001a\u00020\u0018H\u0002J\u0018\u0010O\u001a\u00020&2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010J\u001a\u00020FH\u0002J\u0010\u0010P\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u0006H\u0002J\u0012\u0010Q\u001a\u0004\u0018\u00010\f2\u0006\u0010,\u001a\u00020\u0006H\u0002J\u0010\u0010R\u001a\u00020&2\u0006\u0010,\u001a\u00020\u0006H\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010S\u001a\u00020\u0006H\u0002J \u0010T\u001a\u00020&2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010U\u001a\u00020F2\u0006\u0010J\u001a\u00020FH\u0002J\u0010\u0010V\u001a\u00020&2\u0006\u0010W\u001a\u00020\u000eH\u0016J\u0017\u0010X\u001a\u0004\u0018\u00010\u00062\u0006\u0010Y\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010ZJ\u0016\u0010[\u001a\u00020F2\u0006\u0010W\u001a\u00020\u000e2\u0006\u0010\\\u001a\u00020]J\u0006\u0010^\u001a\u00020&J\u0006\u0010_\u001a\u00020&R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTCurvedSwitchLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "modeCount", "", "<init>", "(Landroid/content/Context;I)V", "mMaxModeCount", "mModeItems", "", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTCurvedSwitchLayout$ModeInfo;", "mBackgroundView", "Landroid/view/View;", "mBackgroundDrawable", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTSliderBackgroundDrawable;", "mIconTintColor", "mDefaultBackgroundColor", "mAnglePosition", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTAnglePosition;", "mThumbViewSize", "mSwitchIconSize", "mTouchOffsetX", "", "mTouchOffsetY", "mMaxAngle", "", "mMinAngle", "mThumbView", "Landroid/widget/FrameLayout;", "mImageThumbContainer", "mThumbViewDefaultRotationOffset", "mCurrentMode", "mRestrictMode", "mOnModeChangedListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTContainer$OnModeChangedListener;", "setSwitchBackground", "", "modeBg", "width", "height", "radius", "restrictModeAccessDocking", "mode", "clearModeAccessDocking", "setOnModeChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addModeInfo", "unselectedResourceId", "selectedResourceId", "description", "", "switchColor", "(IIILjava/lang/CharSequence;Ljava/lang/Integer;)V", "addImageToThumbContainer", "resourceId", "visibility", "bindItem", "view", "item", "addButton", "Landroid/widget/ImageView;", "id", "size", "angle", "addThumbView", "setThumbViewRotation", Key.ROTATION, "needAnimation", "", "setImageThumbContainerRotation", "getModeByAngle", "updateImageThumbContainer", "animation", "getThumbChildId", "getViewId", "setRotationIcon", "setBgImageViewsRotation", "updateThumbView", "getModeAngle", "getModeInfo", "updateSwitchBackground", "color", "changeMode", "notify", "onClick", VPathDataCmd.RCurveTo, "getMode", "viewId", "(I)Ljava/lang/Integer;", "onTouch", "event", "Landroid/view/MotionEvent;", "showNoticeToast", "close", "ModeInfo", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
@SourceDebugExtension({"SMAP\nQTCurvedSwitchLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QTCurvedSwitchLayout.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTCurvedSwitchLayout\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n*L\n1#1,504:1\n1869#2,2:505\n55#3,4:507\n*S KotlinDebug\n*F\n+ 1 QTCurvedSwitchLayout.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTCurvedSwitchLayout\n*L\n327#1:505,2\n480#1:507,4\n*E\n"})
public final class QTCurvedSwitchLayout extends ConstraintLayout implements View.OnClickListener {
    private static final int ADVANCED_ANGLE = 176;
    private static final int BASIC_DEFAULT_ANGLE = 178;
    private static final int BASIC_EXTEND_ANGLE = 180;
    private static final int DEFAULT_MODE_COUNT = 2;
    private static final long HIDE_ANIMATION_DURATION = 350;
    private static final float HIDE_BASE_SCALE = 0.0f;
    private static final long SHOW_ANIMATION_DURATION = 400;
    private static final float SHOW_BASE_SCALE = 1.0f;
    private static final int STANDARD_DEFAULT_ANGLE = 182;
    private static final int STANDARD_EXTEND_ANGLE = 184;

    @NotNull
    private static final String TAG = "QTCurvedSwitchLayout";

    @NotNull
    private final QTAnglePosition mAnglePosition;

    @Nullable
    private QTSliderBackgroundDrawable mBackgroundDrawable;

    @NotNull
    private View mBackgroundView;
    private int mCurrentMode;
    private final int mDefaultBackgroundColor;
    private final int mIconTintColor;

    @Nullable
    private FrameLayout mImageThumbContainer;
    private double mMaxAngle;
    private int mMaxModeCount;
    private double mMinAngle;

    @Nullable
    private List<ModeInfo> mModeItems;

    @Nullable
    private SpenSettingQTContainer.OnModeChangedListener mOnModeChangedListener;
    private int mRestrictMode;
    private int mSwitchIconSize;

    @Nullable
    private FrameLayout mThumbView;
    private double mThumbViewDefaultRotationOffset;
    private int mThumbViewSize;
    private float mTouchOffsetX;
    private float mTouchOffsetY;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QTCurvedSwitchLayout(@NotNull Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mMaxModeCount = i;
        this.mBackgroundView = new View(context);
        this.mIconTintColor = SpenSettingUtil.getColor(context, C7932R.color.setting_qt_icon_switch_layout_tint_color);
        this.mDefaultBackgroundColor = SpenSettingUtil.getColor(context, C7932R.color.setting_qt_switch_bg_color);
        QTAnglePosition qTAnglePosition = new QTAnglePosition();
        this.mAnglePosition = qTAnglePosition;
        this.mRestrictMode = -1;
        int i2 = this.mMaxModeCount;
        this.mMaxAngle = i2 == 2 ? 182.0d : 184.0d;
        this.mMinAngle = i2 == 2 ? 178.0d : 176.0d;
        this.mBackgroundView.setId(C9086R.id.qt_mode);
        int dimensionPixelSize = getResources().getDimensionPixelSize(C9086R.dimen.qt_circle_pen_list_width);
        addView(this.mBackgroundView, new ConstraintLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        float dimensionPixelSize2 = getResources().getDimensionPixelSize(C9086R.dimen.qt_circle_radius_docking);
        qTAnglePosition.setRadius(dimensionPixelSize2);
        qTAnglePosition.setCenterPosition(dimensionPixelSize, dimensionPixelSize / 2);
        this.mModeItems = new ArrayList();
        this.mSwitchIconSize = getResources().getDimensionPixelSize(C9086R.dimen.qt_circle_switch_icon_size);
        this.mThumbViewSize = getResources().getDimensionPixelSize(C9086R.dimen.qt_circle_switch_thumb_size);
        setSwitchBackground(this.mBackgroundView, dimensionPixelSize * 2, dimensionPixelSize, dimensionPixelSize2);
        addModeInfo(0, C9086R.drawable.qt_ic_pen, C9086R.drawable.qt_ic_pen_selected, context.getResources().getString(C9086R.string.pen_string_qtool_pen_settings), null);
        addModeInfo(1, C9086R.drawable.qt_ic_favorite_pen, C9086R.drawable.qt_ic_favorite_pen_selected, context.getResources().getString(C9086R.string.pen_string_favorite_pens), null);
        if (this.mMaxModeCount > 2) {
            addModeInfo(2, C9086R.drawable.qt_ic_ai_menu_toolbar_btn_unselected, C9086R.drawable.ic_ai_menu_toolbar_btn, context.getText(C9086R.string.ai_notes_assist), null);
        }
        changeMode(1, true, true);
    }

    private final ImageView addButton(int id, int size, double angle) {
        PointF viewPosition = this.mAnglePosition.getViewPosition(size, size, angle);
        ImageView imageView = new ImageView(getContext());
        imageView.setId(id);
        addView(imageView, new ConstraintLayout.LayoutParams(size, size));
        imageView.setX(viewPosition.x);
        imageView.setY(viewPosition.y);
        return imageView;
    }

    private final void addImageToThumbContainer(int mode, int resourceId, int visibility) {
        if (this.mImageThumbContainer == null) {
            this.mImageThumbContainer = new FrameLayout(getContext());
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, -1);
            FrameLayout frameLayout = this.mThumbView;
            if (frameLayout != null) {
                frameLayout.addView(this.mImageThumbContainer, layoutParams);
            }
        }
        int thumbChildId = getThumbChildId(mode);
        ImageView imageView = new ImageView(getContext());
        int dimensionPixelSize = getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_switch_thumb_padding);
        imageView.setId(thumbChildId);
        imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        imageView.setImageResource(resourceId);
        imageView.setColorFilter(this.mIconTintColor);
        imageView.setVisibility(visibility);
        FrameLayout frameLayout2 = this.mImageThumbContainer;
        Intrinsics.checkNotNull(frameLayout2);
        frameLayout2.addView(imageView);
    }

    private final void addModeInfo(int mode, int unselectedResourceId, int selectedResourceId, CharSequence description, Integer switchColor) {
        ModeInfo modeInfo = new ModeInfo(mode, unselectedResourceId, description, getModeAngle(mode), getViewId(mode), switchColor != null ? switchColor.intValue() : this.mDefaultBackgroundColor);
        List<ModeInfo> list = this.mModeItems;
        if (list != null) {
            list.add(modeInfo);
        }
        bindItem(addButton(modeInfo.getViewId(), this.mSwitchIconSize, modeInfo.getAngle()), modeInfo);
        if (mode != 0 || this.mThumbView != null) {
            addImageToThumbContainer(mode, selectedResourceId, 8);
        } else {
            addThumbView(modeInfo.getAngle());
            addImageToThumbContainer(mode, selectedResourceId, 0);
        }
    }

    public static /* synthetic */ void addModeInfo$default(QTCurvedSwitchLayout qTCurvedSwitchLayout, int i, int i2, int i4, CharSequence charSequence, Integer num, int i5, Object obj) {
        if ((i5 & 16) != 0) {
            num = null;
        }
        qTCurvedSwitchLayout.addModeInfo(i, i2, i4, charSequence, num);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void addThumbView(double angle) {
        if (this.mThumbView != null) {
            Logger.m11003i(TAG, "addThumbView() already exist thumbView.");
            return;
        }
        Logger.m11003i(TAG, "addThumbView() angle=" + angle);
        this.mThumbViewDefaultRotationOffset = angle;
        QTAnglePosition qTAnglePosition = this.mAnglePosition;
        int i = this.mThumbViewSize;
        PointF viewPosition = qTAnglePosition.getViewPosition(i, i, angle);
        PointF centerOffset = this.mAnglePosition.getCenterOffset(viewPosition);
        int i2 = this.mThumbViewSize;
        ViewGroup.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(i2, i2);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setId(C9086R.id.qt_mode_thumb);
        frameLayout.setBackgroundResource(C9086R.drawable.setting_qt_switch_thumb_bg);
        frameLayout.setElevation(frameLayout.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_switch_thumb_elevation));
        frameLayout.setX(viewPosition.x);
        frameLayout.setY(viewPosition.y);
        frameLayout.setPivotX(centerOffset.x);
        frameLayout.setPivotY(centerOffset.y);
        frameLayout.setOnTouchListener(new ViewOnTouchListenerC4799j(this, 22));
        this.mThumbView = frameLayout;
        addView(frameLayout, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean addThumbView$lambda$1$lambda$0(QTCurvedSwitchLayout qTCurvedSwitchLayout, View v, MotionEvent event) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        return qTCurvedSwitchLayout.onTouch(v, event);
    }

    private final void bindItem(View view, ModeInfo item) {
        view.setTag(Integer.valueOf(item.getMode()));
        Drawable drawable = SpenSettingUtilDrawable.getDrawable(getContext(), item.getResourceId());
        if (drawable != null) {
            drawable.setTint(this.mIconTintColor);
        }
        view.setBackground(drawable);
        view.setContentDescription(item.getDescription());
        view.setTooltipText(item.getDescription());
        view.setOnClickListener(this);
    }

    private final void changeMode(int mode, boolean notify, boolean animation) {
        SpenSettingQTContainer.OnModeChangedListener onModeChangedListener;
        int i = this.mCurrentMode;
        if (i == mode) {
            return;
        }
        AbstractC8014b.m7222x(AbstractC0622a.m1173s(i, mode, "changeMode() mCurrentMode=", " mode=", " animation="), animation, TAG);
        updateThumbView(mode, animation);
        updateSwitchBackground(mode);
        this.mCurrentMode = mode;
        if (!notify || (onModeChangedListener = this.mOnModeChangedListener) == null) {
            return;
        }
        onModeChangedListener.onModeChanged(mode);
    }

    private final Integer getMode(int viewId) {
        if (viewId == C9086R.id.qt_mode_basic) {
            return 0;
        }
        if (viewId == C9086R.id.qt_mode_standard) {
            return 1;
        }
        return viewId == C9086R.id.qt_mode_advanced ? 2 : null;
    }

    private final double getModeAngle(int mode) {
        return mode != 0 ? mode != 1 ? mode != 2 ? 0.0d : 176.0d : this.mMaxModeCount == 2 ? 182.0d : 184.0d : this.mMaxModeCount == 2 ? 178.0d : 180.0d;
    }

    private final int getModeByAngle(float angle) {
        if (this.mMaxModeCount == 2) {
            double d = this.mMinAngle;
            return ((double) angle) >= ((this.mMaxAngle - d) / ((double) 2)) + d ? 1 : 0;
        }
        double d2 = 180;
        double d3 = 2;
        double d4 = ((this.mMaxAngle - d2) / d3) + d2;
        double d5 = d2 - ((d2 - this.mMinAngle) / d3);
        double d6 = angle;
        if (d6 >= d4) {
            return 1;
        }
        return d6 < d5 ? 2 : 0;
    }

    private final ModeInfo getModeInfo(int mode) {
        List<ModeInfo> list = this.mModeItems;
        if (list == null) {
            return null;
        }
        Intrinsics.checkNotNull(list);
        for (ModeInfo modeInfo : list) {
            if (modeInfo.getMode() == mode) {
                return modeInfo;
            }
        }
        return null;
    }

    private final int getThumbChildId(int mode) {
        if (mode == 0) {
            return C9086R.id.qt_mode_thumb_child_basic;
        }
        if (mode == 1) {
            return C9086R.id.qt_mode_thumb_child_standard;
        }
        if (mode != 2) {
            return 0;
        }
        return C9086R.id.qt_mode_thumb_child_advanced;
    }

    private final int getViewId(int mode) {
        return mode != 0 ? mode != 1 ? mode != 2 ? C9086R.id.qt_mode_basic : C9086R.id.qt_mode_advanced : C9086R.id.qt_mode_standard : C9086R.id.qt_mode_basic;
    }

    private final void setBgImageViewsRotation(float rotation) {
        Logger.m11003i(TAG, "setBgImageViewsRotation() rotation=" + rotation);
        List<ModeInfo> list = this.mModeItems;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                View viewFindViewById = findViewById(((ModeInfo) it.next()).getViewId());
                if (viewFindViewById != null) {
                    viewFindViewById.setRotation(rotation);
                }
            }
        }
    }

    private final void setImageThumbContainerRotation(double rotation, boolean needAnimation) {
        FrameLayout frameLayout = this.mImageThumbContainer;
        if (frameLayout == null) {
            return;
        }
        double rotation2 = this.mThumbViewDefaultRotationOffset - (((double) getRotation()) + rotation);
        frameLayout.animate().cancel();
        if (needAnimation) {
            frameLayout.animate().rotation((float) rotation2).setDuration(400L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).start();
        } else {
            frameLayout.setRotation((float) rotation2);
        }
    }

    private final void setSwitchBackground(View modeBg, int width, int height, float radius) {
        float dimensionPixelSize = getResources().getDimensionPixelSize(C9086R.dimen.qt_circle_switch_stroke_size);
        int i = this.mDefaultBackgroundColor;
        int[] iArr = {i, i};
        int i2 = this.mMaxModeCount;
        QTSliderBackgroundDrawable qTSliderBackgroundDrawable = new QTSliderBackgroundDrawable(width, height, radius, dimensionPixelSize, i2 == 2 ? 178 : 176, (i2 == 2 ? 182 : 184) - r2, iArr);
        this.mBackgroundDrawable = qTSliderBackgroundDrawable;
        modeBg.setBackground(qTSliderBackgroundDrawable);
    }

    private final void setThumbViewRotation(double rotation, boolean needAnimation) {
        FrameLayout frameLayout = this.mThumbView;
        if (frameLayout == null) {
            return;
        }
        float f = (float) (rotation - this.mThumbViewDefaultRotationOffset);
        frameLayout.animate().cancel();
        if (needAnimation) {
            frameLayout.animate().rotation(f).setDuration(400L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).start();
        } else {
            frameLayout.setRotation(f);
        }
    }

    private final void updateImageThumbContainer(int mode, boolean animation) {
        int i = this.mCurrentMode;
        if (i == mode) {
            return;
        }
        FrameLayout frameLayout = this.mImageThumbContainer;
        View viewFindViewById = frameLayout != null ? frameLayout.findViewById(getThumbChildId(i)) : null;
        FrameLayout frameLayout2 = this.mImageThumbContainer;
        View viewFindViewById2 = frameLayout2 != null ? frameLayout2.findViewById(getThumbChildId(mode)) : null;
        AbstractC14516b.m15114b(getThumbChildId(this.mCurrentMode), getThumbChildId(mode), "updateImageThumbContainer fromID=", " toID=", TAG);
        if (viewFindViewById == null || viewFindViewById2 == null) {
            return;
        }
        viewFindViewById.animate().cancel();
        viewFindViewById2.animate().cancel();
        if (animation) {
            viewFindViewById.animate().scaleX(0.0f).scaleY(0.0f).setDuration(350L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).withEndAction(new RunnableC7563h(viewFindViewById, viewFindViewById2, 2)).start();
            viewFindViewById2.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).withStartAction(new RunnableC4587a(viewFindViewById2, 12)).start();
        } else {
            viewFindViewById.setVisibility(8);
            viewFindViewById2.setScaleX(1.0f);
            viewFindViewById2.setScaleY(1.0f);
            viewFindViewById2.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateImageThumbContainer$lambda$2(View view, View view2) {
        view.setVisibility(8);
        view2.setScaleX(1.0f);
        view2.setScaleY(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateImageThumbContainer$lambda$3(View view) {
        view.setScaleX(0.0f);
        view.setScaleY(0.0f);
        view.setVisibility(0);
    }

    private final void updateSwitchBackground(int mode) {
        ModeInfo modeInfo = getModeInfo(this.mCurrentMode);
        ModeInfo modeInfo2 = getModeInfo(mode);
        if (modeInfo == null || modeInfo2 == null || modeInfo.getSwitchColor() == modeInfo2.getSwitchColor()) {
            return;
        }
        Logger.m11003i(TAG, AbstractC0622a.m1164j(this.mCurrentMode, mode, "updateSwitchBackground() Mode[", " -> ", "]"));
        setSwitchBackground(modeInfo2.getSwitchColor());
    }

    private final void updateThumbView(int mode, boolean animation) {
        if (this.mThumbView == null) {
            return;
        }
        setThumbViewRotation(getModeAngle(mode), animation);
        updateImageThumbContainer(mode, animation);
    }

    public final void clearModeAccessDocking() {
        this.mRestrictMode = -1;
    }

    public final void close() {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        List<ModeInfo> list = this.mModeItems;
        if (list != null) {
            list.clear();
        }
        this.mModeItems = null;
        this.mOnModeChangedListener = null;
        FrameLayout frameLayout = this.mThumbView;
        if (frameLayout != null && (viewPropertyAnimatorAnimate = frameLayout.animate()) != null) {
            viewPropertyAnimatorAnimate.cancel();
        }
        FrameLayout frameLayout2 = this.mImageThumbContainer;
        if (frameLayout2 != null) {
            int childCount = frameLayout2.getChildCount();
            for (int i = 0; i < childCount; i++) {
                frameLayout2.getChildAt(i).animate().cancel();
            }
        }
        removeAllViews();
        this.mImageThumbContainer = null;
        this.mThumbView = null;
        this.mBackgroundView.setBackground(null);
        this.mBackgroundDrawable = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        Integer mode = getMode(v.getId());
        if (mode != null) {
            int iIntValue = mode.intValue();
            int i = this.mRestrictMode;
            if (i != iIntValue) {
                changeMode(iIntValue, true, true);
                return;
            }
            Logger.m11003i(TAG, "blocked change mode. mode=" + i);
            showNoticeToast();
        }
    }

    public final boolean onTouch(@NotNull View v, @NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action == 0) {
            this.mTouchOffsetX = (v.getWidth() / 2.0f) - event.getX();
            this.mTouchOffsetY = (v.getHeight() / 2.0f) - event.getY();
        } else if (action == 1) {
            updateThumbView(this.mCurrentMode, true);
            int i = this.mCurrentMode;
            if (i == 1) {
                return false;
            }
            if (i == this.mRestrictMode) {
                showNoticeToast();
                changeMode(1, false, true);
                return false;
            }
            SpenSettingQTContainer.OnModeChangedListener onModeChangedListener = this.mOnModeChangedListener;
            if (onModeChangedListener != null) {
                onModeChangedListener.onModeChanged(i);
            }
        } else if (action == 2) {
            getLocationOnScreen(new int[2]);
            float rawX = (event.getRawX() - r1[0]) + this.mTouchOffsetX;
            float rawY = (event.getRawY() - r1[1]) + this.mTouchOffsetY;
            double radians = Math.toRadians(-getRotation());
            double d = rawX;
            double d2 = rawY;
            double angleToCenter = this.mAnglePosition.getAngleToCenter((float) ((Math.cos(radians) * d) - (Math.sin(radians) * d2)), (float) AbstractC2821a.m2210a(radians, d2, Math.sin(radians) * d));
            double d3 = this.mMinAngle;
            if (angleToCenter <= this.mMaxAngle && d3 <= angleToCenter) {
                setThumbViewRotation(angleToCenter, false);
                int modeByAngle = getModeByAngle((float) angleToCenter);
                if (modeByAngle != this.mCurrentMode) {
                    updateImageThumbContainer(modeByAngle, true);
                    this.mCurrentMode = modeByAngle;
                }
            }
        }
        return true;
    }

    public final void restrictModeAccessDocking(int mode) {
        AbstractC8014b.m7217s(mode, "restrictModeAccess() mode=", TAG);
        this.mRestrictMode = mode;
    }

    public final void setOnModeChangedListener(@Nullable SpenSettingQTContainer.OnModeChangedListener listener) {
        this.mOnModeChangedListener = listener;
    }

    public final void setRotationIcon(float rotation) {
        float rotation2 = getRotation();
        Animation animation = getAnimation();
        StringBuilder sbM1176v = AbstractC0622a.m1176v("setRotation() currentRotation=", rotation2, " rotation=", rotation, " animation=");
        sbM1176v.append(animation);
        Logger.m11003i(TAG, sbM1176v.toString());
        setBgImageViewsRotation(-rotation);
        setImageThumbContainerRotation(((double) (rotation - getRotation())) + getModeAngle(this.mCurrentMode), false);
    }

    public final void showNoticeToast() {
        ToastHandler.show(getContext(), C9086R.string.block_assist_quick_tool_notice, 0);
    }

    private final void setSwitchBackground(int color) {
        AbstractC8014b.m7197C("setSwitchBackground() color=", Integer.toHexString(color), TAG);
        int[] iArr = {color, color};
        QTSliderBackgroundDrawable qTSliderBackgroundDrawable = this.mBackgroundDrawable;
        if (qTSliderBackgroundDrawable != null) {
            qTSliderBackgroundDrawable.setGradientColor(iArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003JG\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000e\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0011¨\u0006("}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTCurvedSwitchLayout$ModeInfo;", "", "mode", "", "resourceId", "description", "", "angle", "", "viewId", "switchColor", "<init>", "(IILjava/lang/CharSequence;DII)V", "getMode", "()I", "getResourceId", "setResourceId", "(I)V", "getDescription", "()Ljava/lang/CharSequence;", "setDescription", "(Ljava/lang/CharSequence;)V", "getAngle", "()D", "getViewId", "getSwitchColor", "setSwitchColor", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class ModeInfo {
        private final double angle;

        @Nullable
        private CharSequence description;
        private final int mode;
        private int resourceId;
        private int switchColor;
        private final int viewId;

        public ModeInfo(int i, int i2, @Nullable CharSequence charSequence, double d, int i4, int i5) {
            this.mode = i;
            this.resourceId = i2;
            this.description = charSequence;
            this.angle = d;
            this.viewId = i4;
            this.switchColor = i5;
        }

        public static /* synthetic */ ModeInfo copy$default(ModeInfo modeInfo, int i, int i2, CharSequence charSequence, double d, int i4, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i = modeInfo.mode;
            }
            if ((i6 & 2) != 0) {
                i2 = modeInfo.resourceId;
            }
            if ((i6 & 4) != 0) {
                charSequence = modeInfo.description;
            }
            if ((i6 & 8) != 0) {
                d = modeInfo.angle;
            }
            if ((i6 & 16) != 0) {
                i4 = modeInfo.viewId;
            }
            if ((i6 & 32) != 0) {
                i5 = modeInfo.switchColor;
            }
            double d2 = d;
            CharSequence charSequence2 = charSequence;
            return modeInfo.copy(i, i2, charSequence2, d2, i4, i5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getMode() {
            return this.mode;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getResourceId() {
            return this.resourceId;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CharSequence getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final double getAngle() {
            return this.angle;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getViewId() {
            return this.viewId;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getSwitchColor() {
            return this.switchColor;
        }

        @NotNull
        public final ModeInfo copy(int mode, int resourceId, @Nullable CharSequence description, double angle, int viewId, int switchColor) {
            return new ModeInfo(mode, resourceId, description, angle, viewId, switchColor);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ModeInfo)) {
                return false;
            }
            ModeInfo modeInfo = (ModeInfo) other;
            return this.mode == modeInfo.mode && this.resourceId == modeInfo.resourceId && Intrinsics.areEqual(this.description, modeInfo.description) && Double.compare(this.angle, modeInfo.angle) == 0 && this.viewId == modeInfo.viewId && this.switchColor == modeInfo.switchColor;
        }

        public final double getAngle() {
            return this.angle;
        }

        @Nullable
        public final CharSequence getDescription() {
            return this.description;
        }

        public final int getMode() {
            return this.mode;
        }

        public final int getResourceId() {
            return this.resourceId;
        }

        public final int getSwitchColor() {
            return this.switchColor;
        }

        public final int getViewId() {
            return this.viewId;
        }

        public int hashCode() {
            int iM1157c = AbstractC0622a.m1157c(this.resourceId, Integer.hashCode(this.mode) * 31, 31);
            CharSequence charSequence = this.description;
            return Integer.hashCode(this.switchColor) + AbstractC0622a.m1157c(this.viewId, (Double.hashCode(this.angle) + ((iM1157c + (charSequence == null ? 0 : charSequence.hashCode())) * 31)) * 31, 31);
        }

        public final void setDescription(@Nullable CharSequence charSequence) {
            this.description = charSequence;
        }

        public final void setResourceId(int i) {
            this.resourceId = i;
        }

        public final void setSwitchColor(int i) {
            this.switchColor = i;
        }

        @NotNull
        public String toString() {
            int i = this.mode;
            int i2 = this.resourceId;
            CharSequence charSequence = this.description;
            double d = this.angle;
            int i4 = this.viewId;
            int i5 = this.switchColor;
            StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "ModeInfo(mode=", ", resourceId=", ", description=");
            sbM1173s.append((Object) charSequence);
            sbM1173s.append(", angle=");
            sbM1173s.append(d);
            AbstractC0622a.m1180z(sbM1173s, i4, i5, ", viewId=", ", switchColor=");
            sbM1173s.append(")");
            return sbM1173s.toString();
        }

        public /* synthetic */ ModeInfo(int i, int i2, CharSequence charSequence, double d, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, (i6 & 4) != 0 ? null : charSequence, (i6 & 8) != 0 ? 0.0d : d, i4, i5);
        }
    }
}
