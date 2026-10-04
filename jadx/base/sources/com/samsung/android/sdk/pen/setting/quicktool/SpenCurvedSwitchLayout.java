package com.samsung.android.sdk.pen.setting.quicktool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.bottomappbar.RunnableC4587a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.common.RunnableC7563h;
import com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSwitchLayout;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilDrawable;
import com.samsung.android.spen.C7932R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\b\u000b*\u0001h\b\u0000\u0018\u0000 l2\u00020\u00012\u00020\u0002:\u0006lmnopqB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010)\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0006\u0010+\u001a\u00020*J9\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\b\u00101\u001a\u0004\u0018\u0001022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u00104J\u000e\u00105\u001a\u00020*2\u0006\u0010.\u001a\u00020\u000eJ\u0010\u00106\u001a\u00020*2\b\u00107\u001a\u0004\u0018\u00010\u0010J\u000e\u00108\u001a\u00020*2\u0006\u00107\u001a\u00020\u0012J\u001a\u00109\u001a\u00020*2\b\u0010.\u001a\u0004\u0018\u00010\u000e2\b\u00107\u001a\u0004\u0018\u00010\u0015J\u0016\u0010:\u001a\u00020*2\u0006\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020-J\u0018\u0010=\u001a\u00020*2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020-H\u0002J\u0010\u0010>\u001a\u00020*2\u0006\u0010;\u001a\u00020\"H\u0002J\u0018\u0010?\u001a\u00020*2\u0006\u0010;\u001a\u00020\u00062\u0006\u0010@\u001a\u00020-H\u0002J\u0018\u0010A\u001a\u00020*2\u0006\u0010;\u001a\u00020\u00062\u0006\u0010@\u001a\u00020-H\u0002J\u0018\u0010B\u001a\u00020*2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020-H\u0002J*\u0010C\u001a\u00020-2\u0006\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\u00062\b\u0010F\u001a\u0004\u0018\u0001022\u0006\u0010G\u001a\u00020\u0006H\u0002J2\u0010H\u001a\u00020-2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\b\u00101\u001a\u0004\u0018\u0001022\u0006\u0010G\u001a\u00020\u0006H\u0002J\u0018\u0010I\u001a\u00020*2\u0006\u0010J\u001a\u00020\u00192\u0006\u0010K\u001a\u00020\fH\u0002J\u0010\u0010L\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u000eH\u0002J\u0010\u0010M\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u000eH\u0002J\u0010\u0010N\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u000eH\u0002J\u0012\u0010O\u001a\u0004\u0018\u00010\u000e2\u0006\u0010P\u001a\u00020\u0006H\u0002J\u0010\u0010Q\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020\"H\u0002J\u0010\u0010S\u001a\u00020-2\u0006\u0010.\u001a\u00020\u000eH\u0002J \u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u00062\u0006\u0010W\u001a\u00020\u00062\u0006\u0010R\u001a\u00020\u0006H\u0002J\u0010\u0010X\u001a\u00020*2\u0006\u0010R\u001a\u00020\u0006H\u0002J \u0010Y\u001a\u00020*2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010Z\u001a\u00020\u00062\u0006\u0010[\u001a\u00020\u0006H\u0002J(\u0010\\\u001a\u00020*2\u0006\u0010]\u001a\u00020\u00192\u0006\u0010^\u001a\u00020\u00062\u0006\u0010_\u001a\u00020\u00062\u0006\u0010`\u001a\u00020\"H\u0002J\u0010\u0010a\u001a\u00020*2\u0006\u0010J\u001a\u00020\u0019H\u0016J\u0016\u0010b\u001a\u00020-2\u0006\u0010c\u001a\u00020\"2\u0006\u0010d\u001a\u00020\"J \u00105\u001a\u00020*2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010e\u001a\u00020-2\u0006\u0010<\u001a\u00020-H\u0002J\u0012\u0010f\u001a\u0004\u0018\u00010\f2\u0006\u0010.\u001a\u00020\u000eH\u0002J\u0010\u0010j\u001a\u00020*2\u0006\u0010.\u001a\u00020\u000eH\u0002J\u0010\u0010\\\u001a\u00020*2\u0006\u0010k\u001a\u00020\u0006H\u0002R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010g\u001a\u00020h8\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010i¨\u0006r"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "modeCount", "", "<init>", "(Landroid/content/Context;I)V", "mMaxModeCount", "mModeItems", "", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout$ModeInfo;", "mCurrentMode", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout$Mode;", "mOnModeChangedListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout$OnModeChangedListener;", "mOnSwitchDragListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout$OnSwitchDragListener;", "mBlockedMode", "mOnBlockedEventListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout$OnModeBlockedEventListener;", "mAnglePosition", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTAnglePosition;", "mBackgroundView", "Landroid/view/View;", "mThumbView", "Landroid/widget/FrameLayout;", "mImageThumbContainer", "mThumbViewSize", "mSwitchIconSize", "mMaxAngle", "mMinAngle", "mTouchOffsetX", "", "mTouchOffsetY", "mThumbViewDefaultRotationOffset", "mIconTintColor", "mBackgroundDrawable", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSliderBackgroundDrawable;", "mDefaultBackgroundColor", "construct", "", "close", "setModeInfo", "", "mode", "unselectedResourceId", "selectedResourceId", "description", "", "backgroundColor", "(Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout$Mode;IILjava/lang/CharSequence;Ljava/lang/Integer;)Z", "changeMode", "setOnModeChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnSwitchDragListener", "blockModeAccessOnClick", "setRotation", Key.ROTATION, "animation", "updateThumbView", "setBgImageViewsRotation", "setThumbViewRotation", "needAnimation", "setImageThumbContainerRotation", "updateImageThumbContainer", "updateModeInfo", "modeInfo", "changeResourceId", "changeDescription", "switchColor", "addModeInfo", "bindItem", "view", "item", "getModeAngle", "getViewId", "getThumbChildId", "getMode", "viewId", "getModeByAngle", "angle", "isValidMode", "addButton", "Landroid/widget/ImageView;", "id", "size", "addThumbView", "addImageToThumbContainer", "resourceId", "visibility", "setSwitchBackground", "modeBg", "width", "height", "radius", "onClick", "isScrollAt", "rawX", "rawY", "notify", "getModeInfo", "mOnTouchListener", "com/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout$mOnTouchListener$1", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout$mOnTouchListener$1;", "updateSwitchBackground", "color", "Companion", "Mode", "ModeInfo", "OnModeChangedListener", "OnSwitchDragListener", "OnModeBlockedEventListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenCurvedSwitchLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenCurvedSwitchLayout.kt\ncom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout\n+ 2 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,558:1\n53#2,4:559\n1855#3,2:563\n*S KotlinDebug\n*F\n+ 1 SpenCurvedSwitchLayout.kt\ncom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout\n*L\n117#1:559,4\n194#1:563,2\n*E\n"})
public final class SpenCurvedSwitchLayout extends ConstraintLayout implements View.OnClickListener {
    private static final int ADVANCED_ANGLE = 60;
    private static final int BASIC_DEFAULT_ANGLE = 70;
    private static final int BASIC_EXTEND_ANGLE = 90;
    private static final int DEFAULT_MODE_COUNT = 2;
    private static final long HIDE_ANIMATION_DURATION = 350;
    private static final float HIDE_BASE_SCALE = 0.0f;
    private static final long SHOW_ANIMATION_DURATION = 400;
    private static final float SHOW_BASE_SCALE = 1.0f;
    private static final int STANDARD_DEFAULT_ANGLE = 110;
    private static final int STANDARD_EXTEND_ANGLE = 120;

    @NotNull
    private static final String TAG = "SpenCurvedSwitchLayout";

    @NotNull
    private final SpenQTAnglePosition mAnglePosition;

    @Nullable
    private SpenSliderBackgroundDrawable mBackgroundDrawable;
    private View mBackgroundView;

    @Nullable
    private Mode mBlockedMode;

    @NotNull
    private Mode mCurrentMode;
    private final int mDefaultBackgroundColor;
    private final int mIconTintColor;

    @Nullable
    private FrameLayout mImageThumbContainer;
    private int mMaxAngle;
    private int mMaxModeCount;
    private int mMinAngle;

    @Nullable
    private List<ModeInfo> mModeItems;

    @Nullable
    private OnModeBlockedEventListener mOnBlockedEventListener;

    @Nullable
    private OnModeChangedListener mOnModeChangedListener;

    @Nullable
    private OnSwitchDragListener mOnSwitchDragListener;

    @SuppressLint({"ClickableViewAccessibility"})
    @NotNull
    private final SpenCurvedSwitchLayout$mOnTouchListener$1 mOnTouchListener;
    private int mSwitchIconSize;

    @Nullable
    private FrameLayout mThumbView;
    private int mThumbViewDefaultRotationOffset;
    private int mThumbViewSize;
    private float mTouchOffsetX;
    private float mTouchOffsetY;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "BASIC", "STANDARD", "ADVANCED", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Mode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final Mode BASIC = new Mode("BASIC", 0);
        public static final Mode STANDARD = new Mode("STANDARD", 1);
        public static final Mode ADVANCED = new Mode("ADVANCED", 2);

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{BASIC, STANDARD, ADVANCED};
        }

        static {
            Mode[] modeArr$values = $values();
            $VALUES = modeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(modeArr$values);
        }

        private Mode(String str, int i) {
        }

        @NotNull
        public static EnumEntries<Mode> getEntries() {
            return $ENTRIES;
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout$OnModeBlockedEventListener;", "", "onModeBlocked", "", "mode", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout$Mode;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnModeBlockedEventListener {
        void onModeBlocked(@NotNull Mode mode);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout$OnModeChangedListener;", "", "onModeChanged", "", "mode", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout$Mode;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnModeChangedListener {
        void onModeChanged(@NotNull Mode mode);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout$OnSwitchDragListener;", "", "onDragStart", "", "onDragEnd", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnSwitchDragListener {
        void onDragEnd();

        void onDragStart();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Mode.values().length];
            try {
                iArr[Mode.BASIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Mode.STANDARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Mode.ADVANCED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSwitchLayout$mOnTouchListener$1] */
    public SpenCurvedSwitchLayout(@NotNull Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCurrentMode = Mode.BASIC;
        this.mAnglePosition = new SpenQTAnglePosition();
        this.mIconTintColor = SpenSettingUtil.getColor(context, C7932R.color.setting_qt_icon_switch_layout_tint_color);
        this.mDefaultBackgroundColor = SpenSettingUtil.getColor(context, C7932R.color.setting_qt_switch_bg_color);
        this.mMaxModeCount = i;
        this.mMaxAngle = i == 2 ? 110 : 120;
        this.mMinAngle = i == 2 ? 70 : 60;
        construct(context);
        this.mOnTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSwitchLayout$mOnTouchListener$1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                Intrinsics.checkNotNullParameter(v, "v");
                Intrinsics.checkNotNullParameter(event, "event");
                int action = event.getAction();
                if (action == 0) {
                    this.this$0.mTouchOffsetX = (v.getWidth() / 2.0f) - event.getX();
                    this.this$0.mTouchOffsetY = (v.getHeight() / 2.0f) - event.getY();
                    SpenCurvedSwitchLayout.OnSwitchDragListener onSwitchDragListener = this.this$0.mOnSwitchDragListener;
                    if (onSwitchDragListener != null) {
                        onSwitchDragListener.onDragStart();
                    }
                } else if (action == 1) {
                    SpenCurvedSwitchLayout spenCurvedSwitchLayout = this.this$0;
                    spenCurvedSwitchLayout.updateThumbView(spenCurvedSwitchLayout.mCurrentMode, true);
                    SpenCurvedSwitchLayout.OnSwitchDragListener onSwitchDragListener2 = this.this$0.mOnSwitchDragListener;
                    if (onSwitchDragListener2 != null) {
                        onSwitchDragListener2.onDragEnd();
                    }
                } else if (action == 2) {
                    this.this$0.getLocationOnScreen(new int[2]);
                    float rawX = this.this$0.mTouchOffsetX + (event.getRawX() - r13[0]);
                    float rawY = this.this$0.mTouchOffsetY + (event.getRawY() - r13[1]);
                    double radians = Math.toRadians(-this.this$0.getRotation());
                    double d = rawX;
                    double d2 = rawY;
                    int angleToCenter = this.this$0.mAnglePosition.getAngleToCenter((float) ((Math.cos(radians) * d) - (Math.sin(radians) * d2)), (float) AbstractC2821a.m2210a(radians, d2, Math.sin(radians) * d));
                    int i2 = this.this$0.mMinAngle;
                    if (angleToCenter <= this.this$0.mMaxAngle && i2 <= angleToCenter) {
                        this.this$0.setThumbViewRotation(angleToCenter, false);
                        this.this$0.setImageThumbContainerRotation(angleToCenter, false);
                        SpenCurvedSwitchLayout.Mode modeByAngle = this.this$0.getModeByAngle(angleToCenter);
                        if (modeByAngle != this.this$0.mCurrentMode) {
                            this.this$0.updateImageThumbContainer(modeByAngle, true);
                            this.this$0.mCurrentMode = modeByAngle;
                            SpenCurvedSwitchLayout.OnModeChangedListener onModeChangedListener = this.this$0.mOnModeChangedListener;
                            if (onModeChangedListener != null) {
                                onModeChangedListener.onModeChanged(modeByAngle);
                            }
                        }
                    }
                }
                return true;
            }
        };
    }

    private final ImageView addButton(int id, int size, int angle) {
        PointF viewPosition = this.mAnglePosition.getViewPosition(size, size, angle);
        ImageView imageView = new ImageView(getContext());
        imageView.setId(id);
        addView(imageView, new ConstraintLayout.LayoutParams(size, size));
        imageView.setX(viewPosition.x);
        imageView.setY(viewPosition.y);
        return imageView;
    }

    private final void addImageToThumbContainer(Mode mode, int resourceId, int visibility) {
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

    private final boolean addModeInfo(Mode mode, int unselectedResourceId, int selectedResourceId, CharSequence description, int switchColor) {
        if (this.mModeItems == null) {
            return false;
        }
        ModeInfo modeInfo = new ModeInfo(mode, unselectedResourceId, description, getModeAngle(mode), getViewId(mode), switchColor);
        List<ModeInfo> list = this.mModeItems;
        Intrinsics.checkNotNull(list);
        list.add(modeInfo);
        bindItem(addButton(modeInfo.getViewId(), this.mSwitchIconSize, modeInfo.getAngle()), modeInfo);
        if (mode != Mode.BASIC || this.mThumbView != null) {
            addImageToThumbContainer(mode, selectedResourceId, 8);
            return true;
        }
        addThumbView(modeInfo.getAngle());
        addImageToThumbContainer(mode, selectedResourceId, 0);
        return true;
    }

    private final void addThumbView(int angle) {
        if (this.mThumbView != null) {
            Log.i(TAG, "addThumbView() already exist thumbView.");
            return;
        }
        AbstractC2322a.m1631u(angle, "addThumbView() angle=", TAG);
        this.mThumbViewDefaultRotationOffset = angle;
        SpenQTAnglePosition spenQTAnglePosition = this.mAnglePosition;
        int i = this.mThumbViewSize;
        PointF viewPosition = spenQTAnglePosition.getViewPosition(i, i, angle);
        PointF centerOffset = this.mAnglePosition.getCenterOffset(viewPosition);
        int i2 = this.mThumbViewSize;
        ViewGroup.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(i2, i2);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setId(C7932R.id.qt_mode_thumb);
        frameLayout.setBackgroundResource(C7932R.drawable.setting_qt_switch_thumb_bg);
        frameLayout.setElevation(frameLayout.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_switch_thumb_elevation));
        frameLayout.setX(viewPosition.x);
        frameLayout.setY(viewPosition.y);
        frameLayout.setPivotX(centerOffset.x);
        frameLayout.setPivotY(centerOffset.y);
        frameLayout.setOnTouchListener(this.mOnTouchListener);
        this.mThumbView = frameLayout;
        addView(frameLayout, layoutParams);
    }

    private final void bindItem(View view, ModeInfo item) {
        view.setTag(item.getMode());
        Drawable drawable = SpenSettingUtilDrawable.getDrawable(getContext(), item.getResourceId());
        if (drawable != null) {
            drawable.setTint(this.mIconTintColor);
        }
        view.setBackground(drawable);
        view.setContentDescription(item.getDescription());
        view.setTooltipText(item.getDescription());
        view.setOnClickListener(this);
    }

    private final void construct(Context context) {
        View view = new View(context);
        this.mBackgroundView = view;
        view.setId(C7932R.id.qt_mode);
        int dimensionPixelSize = getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_default_size);
        View view2 = this.mBackgroundView;
        View view3 = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBackgroundView");
            view2 = null;
        }
        addView(view2, new ConstraintLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        float dimensionPixelSize2 = getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_radius);
        this.mAnglePosition.setRadius(dimensionPixelSize2);
        int i = dimensionPixelSize / 2;
        this.mAnglePosition.setCenterPosition(i, i);
        this.mModeItems = new ArrayList();
        this.mSwitchIconSize = getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_switch_icon_size);
        this.mThumbViewSize = getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_switch_thumb_size);
        View view4 = this.mBackgroundView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBackgroundView");
        } else {
            view3 = view4;
        }
        setSwitchBackground(view3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
    }

    private final Mode getMode(int viewId) {
        if (viewId == C7932R.id.qt_mode_basic) {
            return Mode.BASIC;
        }
        if (viewId == C7932R.id.qt_mode_standard) {
            return Mode.STANDARD;
        }
        if (viewId == C7932R.id.qt_mode_advanced) {
            return Mode.ADVANCED;
        }
        return null;
    }

    private final int getModeAngle(Mode mode) {
        int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
        if (i == 1) {
            return this.mMaxModeCount == 2 ? 70 : 90;
        }
        if (i == 2) {
            return this.mMaxModeCount == 2 ? 110 : 120;
        }
        if (i == 3) {
            return 60;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Mode getModeByAngle(float angle) {
        if (this.mMaxModeCount != 2) {
            return angle >= ((float) AbstractC0000a.m7d(this.mMaxAngle, 90, 2, 90)) ? Mode.STANDARD : angle < ((float) (90 - ((90 - this.mMinAngle) / 2))) ? Mode.ADVANCED : Mode.BASIC;
        }
        int i = this.mMinAngle;
        return angle >= ((float) AbstractC0000a.m7d(this.mMaxAngle, i, 2, i)) ? Mode.STANDARD : Mode.BASIC;
    }

    private final ModeInfo getModeInfo(Mode mode) {
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

    private final int getThumbChildId(Mode mode) {
        int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
        if (i == 1) {
            return C7932R.id.qt_mode_thumb_child_basic;
        }
        if (i == 2) {
            return C7932R.id.qt_mode_thumb_child_standard;
        }
        if (i == 3) {
            return C7932R.id.qt_mode_thumb_child_advanced;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final int getViewId(Mode mode) {
        int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
        if (i == 1) {
            return C7932R.id.qt_mode_basic;
        }
        if (i == 2) {
            return C7932R.id.qt_mode_standard;
        }
        if (i == 3) {
            return C7932R.id.qt_mode_advanced;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final boolean isValidMode(Mode mode) {
        int i = this.mMaxModeCount;
        if (i == Mode.values().length) {
            return true;
        }
        return i == 2 ? mode == Mode.BASIC || mode == Mode.STANDARD : mode == Mode.BASIC;
    }

    private final void setBgImageViewsRotation(float rotation) {
        AbstractC4539a.m3205o("setBgImageViewsRotation() rotation=", TAG, rotation);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void setImageThumbContainerRotation(int rotation, boolean needAnimation) {
        FrameLayout frameLayout = this.mImageThumbContainer;
        if (frameLayout == null) {
            return;
        }
        float rotation2 = this.mThumbViewDefaultRotationOffset - (getRotation() + rotation);
        frameLayout.animate().cancel();
        if (needAnimation) {
            frameLayout.animate().rotation(rotation2).setDuration(400L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).start();
        } else {
            frameLayout.setRotation(rotation2);
        }
    }

    public static /* synthetic */ boolean setModeInfo$default(SpenCurvedSwitchLayout spenCurvedSwitchLayout, Mode mode, int i, int i2, CharSequence charSequence, Integer num, int i4, Object obj) {
        if ((i4 & 16) != 0) {
            num = null;
        }
        return spenCurvedSwitchLayout.setModeInfo(mode, i, i2, charSequence, num);
    }

    private final void setSwitchBackground(View modeBg, int width, int height, float radius) {
        float dimensionPixelSize = getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_switch_stroke_size);
        int i = this.mDefaultBackgroundColor;
        int[] iArr = {i, i};
        ArrayList arrayList = new ArrayList();
        for (Mode mode : Mode.values()) {
            if (isValidMode(mode)) {
                arrayList.add(Integer.valueOf(getModeAngle(mode)));
            }
        }
        int iIntValue = ((Number) CollectionsKt___CollectionsKt.m22661minOrThrow((Iterable) arrayList)).intValue();
        int iIntValue2 = ((Number) CollectionsKt___CollectionsKt.m22653maxOrThrow((Iterable) arrayList)).intValue();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        SpenSliderBackgroundDrawable spenSliderBackgroundDrawable = new SpenSliderBackgroundDrawable(context, width, height, radius, dimensionPixelSize, iIntValue, iIntValue2 - iIntValue, iArr);
        this.mBackgroundDrawable = spenSliderBackgroundDrawable;
        modeBg.setBackground(spenSliderBackgroundDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setThumbViewRotation(int rotation, boolean needAnimation) {
        FrameLayout frameLayout = this.mThumbView;
        if (frameLayout == null) {
            return;
        }
        float f = rotation - this.mThumbViewDefaultRotationOffset;
        frameLayout.animate().cancel();
        if (needAnimation) {
            frameLayout.animate().rotation(f).setDuration(400L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).start();
        } else {
            frameLayout.setRotation(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateImageThumbContainer(Mode mode, boolean animation) {
        Mode mode2 = this.mCurrentMode;
        if (mode2 == mode) {
            return;
        }
        FrameLayout frameLayout = this.mImageThumbContainer;
        View viewFindViewById = frameLayout != null ? frameLayout.findViewById(getThumbChildId(mode2)) : null;
        FrameLayout frameLayout2 = this.mImageThumbContainer;
        View viewFindViewById2 = frameLayout2 != null ? frameLayout2.findViewById(getThumbChildId(mode)) : null;
        AbstractC6670b.m4744e(getThumbChildId(this.mCurrentMode), getThumbChildId(mode), "updateImageThumbContainer fromID=", " toID=", TAG);
        if (viewFindViewById == null || viewFindViewById2 == null) {
            return;
        }
        viewFindViewById.animate().cancel();
        viewFindViewById2.animate().cancel();
        if (animation) {
            viewFindViewById.animate().scaleX(0.0f).scaleY(0.0f).setDuration(350L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).withEndAction(new RunnableC7563h(viewFindViewById, viewFindViewById2, 1)).start();
            viewFindViewById2.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).withStartAction(new RunnableC4587a(viewFindViewById2, 3)).start();
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

    private final boolean updateModeInfo(ModeInfo modeInfo, int changeResourceId, CharSequence changeDescription, int switchColor) {
        modeInfo.setResourceId(changeResourceId);
        modeInfo.setDescription(changeDescription);
        modeInfo.setSwitchColor(switchColor);
        View viewFindViewById = findViewById(modeInfo.getViewId());
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        bindItem(viewFindViewById, modeInfo);
        return true;
    }

    private final void updateSwitchBackground(Mode mode) {
        ModeInfo modeInfo = getModeInfo(this.mCurrentMode);
        ModeInfo modeInfo2 = getModeInfo(mode);
        if (modeInfo == null || modeInfo2 == null || modeInfo.getSwitchColor() == modeInfo2.getSwitchColor()) {
            return;
        }
        Log.i(TAG, "updateSwitchBackground() Mode[" + this.mCurrentMode + " -> " + mode + "]");
        setSwitchBackground(modeInfo2.getSwitchColor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateThumbView(Mode mode, boolean animation) {
        if (this.mThumbView == null) {
            return;
        }
        setThumbViewRotation(getModeAngle(mode), animation);
        setImageThumbContainerRotation(getModeAngle(mode), animation);
        updateImageThumbContainer(mode, animation);
    }

    public final void blockModeAccessOnClick(@Nullable Mode mode, @Nullable OnModeBlockedEventListener listener) {
        this.mBlockedMode = mode;
        this.mOnBlockedEventListener = listener;
    }

    public final void changeMode(@NotNull Mode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Log.i(TAG, "changeMode() mode=" + mode);
        changeMode(mode, false, false);
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
        View view = this.mBackgroundView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBackgroundView");
            view = null;
        }
        view.setBackground(null);
        this.mBackgroundDrawable = null;
    }

    public final boolean isScrollAt(float rawX, float rawY) {
        View view = this.mBackgroundView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBackgroundView");
            view = null;
        }
        Drawable background = view.getBackground();
        SpenSliderBackgroundDrawable spenSliderBackgroundDrawable = background instanceof SpenSliderBackgroundDrawable ? (SpenSliderBackgroundDrawable) background : null;
        if (spenSliderBackgroundDrawable == null) {
            return false;
        }
        getLocationOnScreen(new int[2]);
        float f = rawY - r2[1];
        double radians = Math.toRadians(-getRotation());
        double d = rawX - r2[0];
        double d2 = f;
        return spenSliderBackgroundDrawable.isPointInPath((float) ((Math.cos(radians) * d) - (Math.sin(radians) * d2)), (float) AbstractC2821a.m2210a(radians, d2, Math.sin(radians) * d));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Mode mode = getMode(view.getId());
        if (mode == null) {
            return;
        }
        Mode mode2 = this.mBlockedMode;
        if (mode2 == null || mode2 != mode) {
            changeMode(mode, true, true);
            return;
        }
        Log.i(TAG, "blocked change mode. mode=" + mode2);
        OnModeBlockedEventListener onModeBlockedEventListener = this.mOnBlockedEventListener;
        if (onModeBlockedEventListener != null) {
            onModeBlockedEventListener.onModeBlocked(mode);
        }
    }

    public final boolean setModeInfo(@NotNull Mode mode, int unselectedResourceId, int selectedResourceId, @Nullable CharSequence description, @Nullable Integer backgroundColor) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (this.mModeItems != null && isValidMode(mode)) {
            int iIntValue = backgroundColor != null ? backgroundColor.intValue() : this.mDefaultBackgroundColor;
            ModeInfo modeInfo = getModeInfo(mode);
            return modeInfo == null ? addModeInfo(mode, unselectedResourceId, selectedResourceId, description, iIntValue) : updateModeInfo(modeInfo, unselectedResourceId, description, iIntValue);
        }
        Log.i(TAG, "setModeInfo() Not Support Mode. (mode=" + mode + ", maxMode=" + this.mMaxModeCount + ")");
        return false;
    }

    public final void setOnModeChangedListener(@Nullable OnModeChangedListener listener) {
        this.mOnModeChangedListener = listener;
    }

    public final void setOnSwitchDragListener(@NotNull OnSwitchDragListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mOnSwitchDragListener = listener;
    }

    public final void setRotation(float rotation, boolean animation) {
        AbstractC0000a.m27x(AbstractC0622a.m1176v("setRotation() currentRotation=", getRotation(), " rotation=", rotation, " animation="), animation, TAG);
        setBgImageViewsRotation(-rotation);
        setImageThumbContainerRotation((int) ((rotation - getRotation()) + getModeAngle(this.mCurrentMode)), false);
        if (!animation) {
            setRotation(rotation);
        } else {
            animate().cancel();
            animate().rotation(rotation).setDuration(400L).setStartDelay(0L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).start();
        }
    }

    private final void changeMode(Mode mode, boolean notify, boolean animation) {
        OnModeChangedListener onModeChangedListener;
        Mode mode2 = this.mCurrentMode;
        if (mode2 == mode) {
            return;
        }
        StringBuilder sb = new StringBuilder("changeMode() mCurrentMode=");
        sb.append(mode2);
        sb.append(" mode=");
        sb.append(mode);
        sb.append(" animation=");
        AbstractC0000a.m27x(sb, animation, TAG);
        updateThumbView(mode, animation);
        updateSwitchBackground(mode);
        this.mCurrentMode = mode;
        if (!notify || (onModeChangedListener = this.mOnModeChangedListener) == null) {
            return;
        }
        onModeChangedListener.onModeChanged(mode);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003JG\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u0006("}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout$ModeInfo;", "", "mode", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout$Mode;", "resourceId", "", "description", "", "angle", "viewId", "switchColor", "<init>", "(Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout$Mode;ILjava/lang/CharSequence;III)V", "getMode", "()Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout$Mode;", "getResourceId", "()I", "setResourceId", "(I)V", "getDescription", "()Ljava/lang/CharSequence;", "setDescription", "(Ljava/lang/CharSequence;)V", "getAngle", "getViewId", "getSwitchColor", "setSwitchColor", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final /* data */ class ModeInfo {
        private final int angle;

        @Nullable
        private CharSequence description;

        @NotNull
        private final Mode mode;
        private int resourceId;
        private int switchColor;
        private final int viewId;

        public ModeInfo(@NotNull Mode mode, int i, @Nullable CharSequence charSequence, int i2, int i4, int i5) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            this.mode = mode;
            this.resourceId = i;
            this.description = charSequence;
            this.angle = i2;
            this.viewId = i4;
            this.switchColor = i5;
        }

        public static /* synthetic */ ModeInfo copy$default(ModeInfo modeInfo, Mode mode, int i, CharSequence charSequence, int i2, int i4, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                mode = modeInfo.mode;
            }
            if ((i6 & 2) != 0) {
                i = modeInfo.resourceId;
            }
            if ((i6 & 4) != 0) {
                charSequence = modeInfo.description;
            }
            if ((i6 & 8) != 0) {
                i2 = modeInfo.angle;
            }
            if ((i6 & 16) != 0) {
                i4 = modeInfo.viewId;
            }
            if ((i6 & 32) != 0) {
                i5 = modeInfo.switchColor;
            }
            int i7 = i4;
            int i8 = i5;
            return modeInfo.copy(mode, i, charSequence, i2, i7, i8);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Mode getMode() {
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
        public final int getAngle() {
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
        public final ModeInfo copy(@NotNull Mode mode, int resourceId, @Nullable CharSequence description, int angle, int viewId, int switchColor) {
            Intrinsics.checkNotNullParameter(mode, "mode");
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
            return this.mode == modeInfo.mode && this.resourceId == modeInfo.resourceId && Intrinsics.areEqual(this.description, modeInfo.description) && this.angle == modeInfo.angle && this.viewId == modeInfo.viewId && this.switchColor == modeInfo.switchColor;
        }

        public final int getAngle() {
            return this.angle;
        }

        @Nullable
        public final CharSequence getDescription() {
            return this.description;
        }

        @NotNull
        public final Mode getMode() {
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
            int iM1157c = AbstractC0622a.m1157c(this.resourceId, this.mode.hashCode() * 31, 31);
            CharSequence charSequence = this.description;
            return Integer.hashCode(this.switchColor) + AbstractC0622a.m1157c(this.viewId, AbstractC0622a.m1157c(this.angle, (iM1157c + (charSequence == null ? 0 : charSequence.hashCode())) * 31, 31), 31);
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
            Mode mode = this.mode;
            int i = this.resourceId;
            CharSequence charSequence = this.description;
            int i2 = this.angle;
            int i4 = this.viewId;
            int i5 = this.switchColor;
            StringBuilder sb = new StringBuilder("ModeInfo(mode=");
            sb.append(mode);
            sb.append(", resourceId=");
            sb.append(i);
            sb.append(", description=");
            sb.append((Object) charSequence);
            sb.append(", angle=");
            sb.append(i2);
            sb.append(", viewId=");
            return AbstractC2322a.m1625o(sb, i4, i5, ", switchColor=", ")");
        }

        public /* synthetic */ ModeInfo(Mode mode, int i, CharSequence charSequence, int i2, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this(mode, i, (i6 & 4) != 0 ? null : charSequence, (i6 & 8) != 0 ? 0 : i2, i4, i5);
        }
    }

    private final void setSwitchBackground(int color) {
        AbstractC6670b.m4756q("setSwitchBackground() color=", Integer.toHexString(color), TAG);
        int[] iArr = {color, color};
        SpenSliderBackgroundDrawable spenSliderBackgroundDrawable = this.mBackgroundDrawable;
        if (spenSliderBackgroundDrawable != null) {
            spenSliderBackgroundDrawable.setGradientColor(iArr);
        }
    }

    public /* synthetic */ SpenCurvedSwitchLayout(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? Mode.values().length : i);
    }
}
