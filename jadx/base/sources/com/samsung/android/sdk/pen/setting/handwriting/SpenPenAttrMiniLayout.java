package com.samsung.android.sdk.pen.setting.handwriting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.common.SpenSlider;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniLayout;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenOpacityLayoutInterface;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenPopupControl;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenSizeLayoutInterface;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthLayoutInterface;
import com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilOpacity;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 O2\u00020\u0001:\u0004OPQRB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010 \u001a\u00020!J\u0010\u0010(\u001a\u00020!2\b\u0010)\u001a\u0004\u0018\u00010\u001cJ\u0016\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005J\u000e\u0010-\u001a\u00020!2\u0006\u0010,\u001a\u00020\u0005J\u0018\u0010.\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u0017J\u001e\u00102\u001a\u00020!2\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u0017J\u0010\u00106\u001a\u00020!2\b\u0010)\u001a\u0004\u0018\u00010\u001eJ\u001a\u00106\u001a\u00020!2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u0010)\u001a\u000209H\u0002J\u0010\u0010:\u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0018\u0010;\u001a\u00020!2\u0006\u0010<\u001a\u00020\u00172\u0006\u0010=\u001a\u00020\u0017H\u0002J\u0018\u0010&\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u0017H\u0002J\u0010\u0010>\u001a\u00020!2\u0006\u0010?\u001a\u00020\u0015H\u0002J \u0010B\u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u0005H\u0002J\b\u0010L\u001a\u00020MH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010#\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010@\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bF\u0010AR\u0014\u0010G\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0014\u0010J\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010IR\u000e\u0010N\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006S"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenAttrMiniLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "orientation", "", "<init>", "(Landroid/content/Context;I)V", "mPenPopupControl", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenPopupControl;", "mSizeSlider", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenSizeLayout;", "mOpacitySlider", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenOpacityLayout;", "mSizeItem", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenAttrMiniView;", "mOpacityItem", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenOpacityMiniView;", "mWidthItem", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenWidthMiniLayout;", "mCurrentMode", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenAttrMiniLayout$Mode;", "mInitComplete", "", "mSupportSelected", "mSizeProgress", "mAlphaProgress", "mDataChangedListener", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenAttrMiniLayout$OnDataChangedListener;", "mSliderListener", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenAttrMiniLayout$OnSliderListener;", "mLayoutOrientation", "close", "", "value", "mode", "getMode", "()Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenAttrMiniLayout$Mode;", "setMode", "(Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenAttrMiniLayout$Mode;)V", "setDataChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSizeLevel", "sizeLevel", "color", "setOpacity", "setPenWidth", "penName", "", "isFixedWidth", "setAttributeVisibility", "opacityVisibility", "fixedWidthVisibility", "needAnimation", "setSliderListener", "slider", "Lcom/samsung/android/sdk/pen/setting/common/SpenSlider;", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenUserLabelSlider$OnLabelListener;", "initView", "setItemLabelVisibility", "isSizeItemVisible", "isOpacityItemVisible", "changeSliderAnimation", "toMode", "isRunningSliderAnimation", "()Z", "setSeekBarTransition", "parent", "Landroid/view/ViewGroup;", "id", "isHorizontalLayout", "layoutId", "getLayoutId", "()I", "sliderResourceId", "getSliderResourceId", "decideRadiusDir", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenPopupControl$RadiusDir;", "mOnSliderLabelListener", "Companion", "Mode", "OnDataChangedListener", "OnSliderListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
public final class SpenPenAttrMiniLayout extends FrameLayout {
    public static final int HORIZONTAL = 0;

    @NotNull
    private static final String TAG = "SpenPenAttrMiniLayout";
    public static final int VERTICAL = 1;
    private int mAlphaProgress;

    @NotNull
    private Mode mCurrentMode;

    @Nullable
    private OnDataChangedListener mDataChangedListener;
    private boolean mInitComplete;
    private final int mLayoutOrientation;

    @NotNull
    private final SpenUserLabelSlider.OnLabelListener mOnSliderLabelListener;
    private SpenPenOpacityMiniView mOpacityItem;
    private SpenPenOpacityLayout mOpacitySlider;
    private SpenPenPopupControl mPenPopupControl;
    private SpenPenAttrMiniView mSizeItem;
    private int mSizeProgress;
    private SpenPenSizeLayout mSizeSlider;

    @Nullable
    private OnSliderListener mSliderListener;
    private boolean mSupportSelected;
    private SpenPenWidthMiniLayout mWidthItem;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenAttrMiniLayout$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "SIZE", "OPACITY", CoverStickerConstants.Category.NONE.NAME, "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Mode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final Mode SIZE = new Mode("SIZE", 0);
        public static final Mode OPACITY = new Mode("OPACITY", 1);
        public static final Mode NONE = new Mode(CoverStickerConstants.Category.NONE.NAME, 2);

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{SIZE, OPACITY, NONE};
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
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenAttrMiniLayout$OnDataChangedListener;", "", "onSizeChanged", "", "sizeLevel", "", "onAlphaChanged", "alpha", "onFixedWidthChanged", "isFixedWidth", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnDataChangedListener {
        void onAlphaChanged(int alpha);

        void onFixedWidthChanged(boolean isFixedWidth);

        void onSizeChanged(int sizeLevel);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenAttrMiniLayout$OnSliderListener;", "", "onLabelStateChanged", "", "slider", "Landroid/view/View;", "state", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenAttrMiniLayout$OnSliderListener$LabelState;", "text", "", "onLabelChanged", "LabelState", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnSliderListener {

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenAttrMiniLayout$OnSliderListener$LabelState;", "", "<init>", "(Ljava/lang/String;I)V", "HIDE", "SHOW", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class LabelState {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ LabelState[] $VALUES;
            public static final LabelState HIDE = new LabelState("HIDE", 0);
            public static final LabelState SHOW = new LabelState("SHOW", 1);

            private static final /* synthetic */ LabelState[] $values() {
                return new LabelState[]{HIDE, SHOW};
            }

            static {
                LabelState[] labelStateArr$values = $values();
                $VALUES = labelStateArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(labelStateArr$values);
            }

            private LabelState(String str, int i) {
            }

            @NotNull
            public static EnumEntries<LabelState> getEntries() {
                return $ENTRIES;
            }

            public static LabelState valueOf(String str) {
                return (LabelState) Enum.valueOf(LabelState.class, str);
            }

            public static LabelState[] values() {
                return (LabelState[]) $VALUES.clone();
            }
        }

        void onLabelChanged(@NotNull String text);

        void onLabelStateChanged(@Nullable View slider, @Nullable LabelState state, @NotNull String text);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPenAttrMiniLayout(@NotNull Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCurrentMode = Mode.NONE;
        AbstractC2322a.m1631u(i, "layoutOrientation=", TAG);
        this.mLayoutOrientation = i;
        initView(context);
        this.mSupportSelected = false;
        setMode(Mode.SIZE, false);
        this.mOnSliderLabelListener = new SpenUserLabelSlider.OnLabelListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniLayout$mOnSliderLabelListener$1

            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[SpenUserLabelSlider.OnLabelListener.LabelState.values().length];
                    try {
                        iArr[SpenUserLabelSlider.OnLabelListener.LabelState.HIDE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[SpenUserLabelSlider.OnLabelListener.LabelState.SHOW.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider.OnLabelListener
            public void onLabelChanged(String text) {
                Intrinsics.checkNotNullParameter(text, "text");
                SpenPenAttrMiniLayout.OnSliderListener onSliderListener = this.this$0.mSliderListener;
                if (onSliderListener != null) {
                    onSliderListener.onLabelChanged(text);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenUserLabelSlider.OnLabelListener
            public void onLabelStateChanged(SpenUserLabelSlider.OnLabelListener.LabelState state, String text) {
                SpenPenAttrMiniLayout.OnSliderListener.LabelState labelState;
                View view;
                String str;
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(text, "text");
                if (this.this$0.mSliderListener == null) {
                    return;
                }
                int i2 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i2 == 1) {
                    this.this$0.setItemLabelVisibility(true, true);
                    labelState = SpenPenAttrMiniLayout.OnSliderListener.LabelState.HIDE;
                } else {
                    if (i2 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    this.this$0.setItemLabelVisibility(!(this.this$0.mCurrentMode == SpenPenAttrMiniLayout.Mode.SIZE), true ^ (this.this$0.mCurrentMode == SpenPenAttrMiniLayout.Mode.OPACITY));
                    labelState = SpenPenAttrMiniLayout.OnSliderListener.LabelState.SHOW;
                }
                SpenPenAttrMiniLayout.OnSliderListener onSliderListener = this.this$0.mSliderListener;
                Intrinsics.checkNotNull(onSliderListener);
                View view2 = null;
                if (this.this$0.getMCurrentMode() == SpenPenAttrMiniLayout.Mode.SIZE) {
                    view = this.this$0.mSizeSlider;
                    if (view == null) {
                        str = "mSizeSlider";
                        Intrinsics.throwUninitializedPropertyAccessException(str);
                    }
                    view2 = view;
                } else {
                    view = this.this$0.mOpacitySlider;
                    if (view == null) {
                        str = "mOpacitySlider";
                        Intrinsics.throwUninitializedPropertyAccessException(str);
                    }
                    view2 = view;
                }
                onSliderListener.onLabelStateChanged(view2, labelState, text);
            }
        };
    }

    private final void changeSliderAnimation(Mode toMode) {
        View view = null;
        if (toMode == Mode.SIZE) {
            SpenPenSizeLayout spenPenSizeLayout = this.mSizeSlider;
            if (spenPenSizeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSizeSlider");
                spenPenSizeLayout = null;
            }
            spenPenSizeLayout.setVisibility(0);
            SpenPenSizeLayout spenPenSizeLayout2 = this.mSizeSlider;
            if (spenPenSizeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSizeSlider");
                spenPenSizeLayout2 = null;
            }
            spenPenSizeLayout2.showSizeAnimation$SDK_fullRelease(this.mAlphaProgress, this.mSizeProgress);
            SpenPenOpacityLayout spenPenOpacityLayout = this.mOpacitySlider;
            if (spenPenOpacityLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOpacitySlider");
            } else {
                view = spenPenOpacityLayout;
            }
            view.setVisibility(8);
            return;
        }
        if (toMode == Mode.OPACITY) {
            SpenPenOpacityLayout spenPenOpacityLayout2 = this.mOpacitySlider;
            if (spenPenOpacityLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOpacitySlider");
                spenPenOpacityLayout2 = null;
            }
            spenPenOpacityLayout2.setVisibility(0);
            SpenPenOpacityLayout spenPenOpacityLayout3 = this.mOpacitySlider;
            if (spenPenOpacityLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOpacitySlider");
                spenPenOpacityLayout3 = null;
            }
            spenPenOpacityLayout3.showOpacityAnimation$SDK_fullRelease(this.mSizeProgress, this.mAlphaProgress);
            SpenPenSizeLayout spenPenSizeLayout3 = this.mSizeSlider;
            if (spenPenSizeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSizeSlider");
            } else {
                view = spenPenSizeLayout3;
            }
            view.setVisibility(8);
        }
    }

    private final SpenPenPopupControl.RadiusDir decideRadiusDir() {
        return isHorizontalLayout() ? SpenPenPopupControl.RadiusDir.RADIUS_DIR_START : SpenPenPopupControl.RadiusDir.RADIUS_DIR_TOP;
    }

    private final int getLayoutId() {
        return isHorizontalLayout() ? C7932R.layout.setting_mini_attr_land_layout : C7932R.layout.setting_mini_attr_layout;
    }

    private final int getSliderResourceId() {
        return isHorizontalLayout() ? C7932R.layout.setting_mini_slider_land_layout : C7932R.layout.setting_mini_slider_layout;
    }

    private final void initView(Context context) {
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ((LayoutInflater) systemService).inflate(getLayoutId(), (ViewGroup) this, true);
        SpenPenPopupControl spenPenPopupControl = new SpenPenPopupControl(context);
        this.mPenPopupControl = spenPenPopupControl;
        spenPenPopupControl.initView(this, getChildAt(0), decideRadiusDir());
        FrameLayout frameLayout = (FrameLayout) findViewById(C7932R.id.slider_container);
        SpenPenSizeLayout spenPenSizeLayout = new SpenPenSizeLayout(context, getSliderResourceId(), true);
        this.mSizeSlider = spenPenSizeLayout;
        spenPenSizeLayout.setActionListener(new SpenPenSizeLayoutInterface.ActionListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniLayout.initView.1
            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenSizeLayoutInterface.ActionListener
            public void onSizeChanged(int sizeLevel, float dpSize) {
                if (SpenPenAttrMiniLayout.this.mInitComplete) {
                    SpenPenAttrMiniView spenPenAttrMiniView = SpenPenAttrMiniLayout.this.mSizeItem;
                    SpenPenAttrMiniView spenPenAttrMiniView2 = null;
                    if (spenPenAttrMiniView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSizeItem");
                        spenPenAttrMiniView = null;
                    }
                    spenPenAttrMiniView.setSizeLevel(sizeLevel);
                    SpenPenAttrMiniView spenPenAttrMiniView3 = SpenPenAttrMiniLayout.this.mSizeItem;
                    if (spenPenAttrMiniView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSizeItem");
                    } else {
                        spenPenAttrMiniView2 = spenPenAttrMiniView3;
                    }
                    spenPenAttrMiniView2.setValue(sizeLevel);
                    OnDataChangedListener onDataChangedListener = SpenPenAttrMiniLayout.this.mDataChangedListener;
                    if (onDataChangedListener != null) {
                        onDataChangedListener.onSizeChanged(sizeLevel);
                    }
                    SpenPenAttrMiniLayout.this.mSizeProgress = sizeLevel;
                }
            }
        });
        SpenPenSizeLayout spenPenSizeLayout2 = this.mSizeSlider;
        SpenPenWidthMiniLayout spenPenWidthMiniLayout = null;
        if (spenPenSizeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSizeSlider");
            spenPenSizeLayout2 = null;
        }
        frameLayout.addView(spenPenSizeLayout2);
        SpenPenSizeLayout spenPenSizeLayout3 = this.mSizeSlider;
        if (spenPenSizeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSizeSlider");
            spenPenSizeLayout3 = null;
        }
        setSeekBarTransition(context, spenPenSizeLayout3, C7932R.id.seek_bar);
        SpenPenOpacityLayout spenPenOpacityLayout = new SpenPenOpacityLayout(context, getSliderResourceId(), true);
        this.mOpacitySlider = spenPenOpacityLayout;
        spenPenOpacityLayout.setDataChangedListener(new SpenPenOpacityLayoutInterface.OnDataChangedListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniLayout.initView.2
            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenOpacityLayoutInterface.OnDataChangedListener
            public void onAlphaChanged(int alpha, boolean notify) {
                if (SpenPenAttrMiniLayout.this.mInitComplete) {
                    SpenPenOpacityMiniView spenPenOpacityMiniView = SpenPenAttrMiniLayout.this.mOpacityItem;
                    if (spenPenOpacityMiniView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mOpacityItem");
                        spenPenOpacityMiniView = null;
                    }
                    spenPenOpacityMiniView.setAlpha(alpha);
                    OnDataChangedListener onDataChangedListener = SpenPenAttrMiniLayout.this.mDataChangedListener;
                    if (onDataChangedListener != null) {
                        onDataChangedListener.onAlphaChanged(alpha);
                    }
                    SpenPenAttrMiniLayout.this.mAlphaProgress = SpenSettingUtilOpacity.getAlphaToPercent(alpha);
                }
            }
        });
        SpenPenOpacityLayout spenPenOpacityLayout2 = this.mOpacitySlider;
        if (spenPenOpacityLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpacitySlider");
            spenPenOpacityLayout2 = null;
        }
        frameLayout.addView(spenPenOpacityLayout2);
        SpenPenOpacityLayout spenPenOpacityLayout3 = this.mOpacitySlider;
        if (spenPenOpacityLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpacitySlider");
            spenPenOpacityLayout3 = null;
        }
        setSeekBarTransition(context, spenPenOpacityLayout3, C7932R.id.seek_bar);
        Resources resources = getContext().getResources();
        this.mSizeItem = (SpenPenAttrMiniView) findViewById(C7932R.id.attr_size_item);
        String string = resources.getString(C7932R.string.pen_string_thickness);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        SpenPenAttrMiniView spenPenAttrMiniView = this.mSizeItem;
        if (spenPenAttrMiniView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSizeItem");
            spenPenAttrMiniView = null;
        }
        SpenSettingUtilHover.setHoverText(spenPenAttrMiniView, string);
        SpenPenAttrMiniView spenPenAttrMiniView2 = this.mSizeItem;
        if (spenPenAttrMiniView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSizeItem");
            spenPenAttrMiniView2 = null;
        }
        spenPenAttrMiniView2.setContentDescription(string);
        SpenPenAttrMiniView spenPenAttrMiniView3 = this.mSizeItem;
        if (spenPenAttrMiniView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSizeItem");
            spenPenAttrMiniView3 = null;
        }
        final int i = 0;
        spenPenAttrMiniView3.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.setting.handwriting.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenPenAttrMiniLayout f5060b;

            {
                this.f5060b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case 0:
                        SpenPenAttrMiniLayout.initView$lambda$0(this.f5060b, view);
                        break;
                    default:
                        SpenPenAttrMiniLayout.initView$lambda$1(this.f5060b, view);
                        break;
                }
            }
        });
        this.mOpacityItem = (SpenPenOpacityMiniView) findViewById(C7932R.id.attr_opacity_item);
        String string2 = resources.getString(C7932R.string.pen_string_opacity);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        SpenPenOpacityMiniView spenPenOpacityMiniView = this.mOpacityItem;
        if (spenPenOpacityMiniView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpacityItem");
            spenPenOpacityMiniView = null;
        }
        SpenSettingUtilHover.setHoverText(spenPenOpacityMiniView, string2);
        SpenPenOpacityMiniView spenPenOpacityMiniView2 = this.mOpacityItem;
        if (spenPenOpacityMiniView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpacityItem");
            spenPenOpacityMiniView2 = null;
        }
        spenPenOpacityMiniView2.setContentDescription(string2);
        SpenPenOpacityMiniView spenPenOpacityMiniView3 = this.mOpacityItem;
        if (spenPenOpacityMiniView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpacityItem");
            spenPenOpacityMiniView3 = null;
        }
        final int i2 = 1;
        spenPenOpacityMiniView3.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.setting.handwriting.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenPenAttrMiniLayout f5060b;

            {
                this.f5060b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        SpenPenAttrMiniLayout.initView$lambda$0(this.f5060b, view);
                        break;
                    default:
                        SpenPenAttrMiniLayout.initView$lambda$1(this.f5060b, view);
                        break;
                }
            }
        });
        SpenPenWidthMiniLayout spenPenWidthMiniLayout2 = (SpenPenWidthMiniLayout) findViewById(C7932R.id.attr_fixed_width_item);
        this.mWidthItem = spenPenWidthMiniLayout2;
        if (spenPenWidthMiniLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWidthItem");
        } else {
            spenPenWidthMiniLayout = spenPenWidthMiniLayout2;
        }
        spenPenWidthMiniLayout.setDataChangedListener(new SpenPenWidthLayoutInterface.OnDataChangedListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniLayout.initView.5
            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthLayoutInterface.OnDataChangedListener
            public void onPenWidthChanged(boolean isFixed) {
                OnDataChangedListener onDataChangedListener = SpenPenAttrMiniLayout.this.mDataChangedListener;
                if (onDataChangedListener != null) {
                    onDataChangedListener.onFixedWidthChanged(isFixed);
                }
            }
        });
        this.mInitComplete = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(SpenPenAttrMiniLayout spenPenAttrMiniLayout, View view) {
        if (spenPenAttrMiniLayout.getMCurrentMode() != Mode.OPACITY || spenPenAttrMiniLayout.isRunningSliderAnimation()) {
            return;
        }
        spenPenAttrMiniLayout.setMode(Mode.SIZE, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(SpenPenAttrMiniLayout spenPenAttrMiniLayout, View view) {
        if (spenPenAttrMiniLayout.getMCurrentMode() != Mode.SIZE || spenPenAttrMiniLayout.isRunningSliderAnimation()) {
            return;
        }
        spenPenAttrMiniLayout.setMode(Mode.OPACITY, true);
    }

    private final boolean isHorizontalLayout() {
        return this.mLayoutOrientation == 0;
    }

    private final boolean isRunningSliderAnimation() {
        SpenPenSizeLayout spenPenSizeLayout = this.mSizeSlider;
        SpenPenOpacityLayout spenPenOpacityLayout = null;
        if (spenPenSizeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSizeSlider");
            spenPenSizeLayout = null;
        }
        if (spenPenSizeLayout.isRunningShowHideAnimation$SDK_fullRelease()) {
            return true;
        }
        SpenPenOpacityLayout spenPenOpacityLayout2 = this.mOpacitySlider;
        if (spenPenOpacityLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpacitySlider");
        } else {
            spenPenOpacityLayout = spenPenOpacityLayout2;
        }
        return spenPenOpacityLayout.isRunningShowHideAnimation$SDK_fullRelease();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setItemLabelVisibility(boolean isSizeItemVisible, boolean isOpacityItemVisible) {
        int i = isSizeItemVisible ? 0 : 4;
        int i2 = isOpacityItemVisible ? 0 : 4;
        SpenPenAttrMiniView spenPenAttrMiniView = this.mSizeItem;
        SpenPenOpacityMiniView spenPenOpacityMiniView = null;
        if (spenPenAttrMiniView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSizeItem");
            spenPenAttrMiniView = null;
        }
        spenPenAttrMiniView.setLabelVisibility(i);
        SpenPenOpacityMiniView spenPenOpacityMiniView2 = this.mOpacityItem;
        if (spenPenOpacityMiniView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpacityItem");
        } else {
            spenPenOpacityMiniView = spenPenOpacityMiniView2;
        }
        spenPenOpacityMiniView.setLabelVisibility(i2);
    }

    private final void setSeekBarTransition(Context context, ViewGroup parent, int id) {
        SeekBar seekBar;
        if (isHorizontalLayout() || AbstractC0541b.m759a(context) != 1 || (seekBar = (SeekBar) parent.findViewById(id)) == null) {
            return;
        }
        seekBar.setTranslationX(seekBar.getTranslationX() * (-1));
        seekBar.setRotation(90.0f);
    }

    public final void close() {
        if (this.mInitComplete) {
            SpenPenWidthMiniLayout spenPenWidthMiniLayout = null;
            this.mSliderListener = null;
            SpenPenPopupControl spenPenPopupControl = this.mPenPopupControl;
            if (spenPenPopupControl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenPopupControl");
                spenPenPopupControl = null;
            }
            spenPenPopupControl.close();
            SpenPenSizeLayout spenPenSizeLayout = this.mSizeSlider;
            if (spenPenSizeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSizeSlider");
                spenPenSizeLayout = null;
            }
            spenPenSizeLayout.close();
            SpenPenOpacityLayout spenPenOpacityLayout = this.mOpacitySlider;
            if (spenPenOpacityLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOpacitySlider");
                spenPenOpacityLayout = null;
            }
            spenPenOpacityLayout.close();
            SpenPenAttrMiniView spenPenAttrMiniView = this.mSizeItem;
            if (spenPenAttrMiniView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSizeItem");
                spenPenAttrMiniView = null;
            }
            spenPenAttrMiniView.close();
            SpenPenOpacityMiniView spenPenOpacityMiniView = this.mOpacityItem;
            if (spenPenOpacityMiniView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOpacityItem");
                spenPenOpacityMiniView = null;
            }
            spenPenOpacityMiniView.close();
            SpenPenWidthMiniLayout spenPenWidthMiniLayout2 = this.mWidthItem;
            if (spenPenWidthMiniLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWidthItem");
            } else {
                spenPenWidthMiniLayout = spenPenWidthMiniLayout2;
            }
            spenPenWidthMiniLayout.close();
            this.mInitComplete = false;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: getMode, reason: from getter */
    public final Mode getMCurrentMode() {
        return this.mCurrentMode;
    }

    public final void setAttributeVisibility(int opacityVisibility, int fixedWidthVisibility, boolean needAnimation) {
        if (this.mInitComplete) {
            AbstractC6670b.m4744e(opacityVisibility, fixedWidthVisibility, "setAttributeVisibility() opacity=", " fixedWidth=", TAG);
            SpenPenOpacityMiniView spenPenOpacityMiniView = this.mOpacityItem;
            SpenPenAttrMiniView spenPenAttrMiniView = null;
            if (spenPenOpacityMiniView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOpacityItem");
                spenPenOpacityMiniView = null;
            }
            boolean z = spenPenOpacityMiniView.getVisibility() != opacityVisibility;
            SpenPenOpacityMiniView spenPenOpacityMiniView2 = this.mOpacityItem;
            if (spenPenOpacityMiniView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOpacityItem");
                spenPenOpacityMiniView2 = null;
            }
            spenPenOpacityMiniView2.setVisibility(opacityVisibility);
            SpenPenWidthMiniLayout spenPenWidthMiniLayout = this.mWidthItem;
            if (spenPenWidthMiniLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWidthItem");
                spenPenWidthMiniLayout = null;
            }
            spenPenWidthMiniLayout.setVisibility(fixedWidthVisibility);
            this.mSupportSelected = opacityVisibility == 0;
            SpenPenAttrMiniView spenPenAttrMiniView2 = this.mSizeItem;
            if (spenPenAttrMiniView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSizeItem");
            } else {
                spenPenAttrMiniView = spenPenAttrMiniView2;
            }
            spenPenAttrMiniView.setClickable(this.mSupportSelected);
            setMode(z ? Mode.SIZE : getMCurrentMode(), needAnimation);
        }
    }

    public final void setDataChangedListener(@Nullable OnDataChangedListener listener) {
        this.mDataChangedListener = listener;
    }

    public final void setMode(@NotNull Mode value) {
        Intrinsics.checkNotNullParameter(value, "value");
        setMode(value, false);
    }

    public final void setOpacity(int color) {
        if (this.mInitComplete) {
            SpenPenOpacityMiniView spenPenOpacityMiniView = this.mOpacityItem;
            SpenPenOpacityLayout spenPenOpacityLayout = null;
            if (spenPenOpacityMiniView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOpacityItem");
                spenPenOpacityMiniView = null;
            }
            spenPenOpacityMiniView.setColor(color);
            SpenPenOpacityLayout spenPenOpacityLayout2 = this.mOpacitySlider;
            if (spenPenOpacityLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOpacitySlider");
            } else {
                spenPenOpacityLayout = spenPenOpacityLayout2;
            }
            spenPenOpacityLayout.setColor(color);
            this.mAlphaProgress = SpenSettingUtilOpacity.getAlphaToPercent(Color.alpha(color));
        }
    }

    public final void setPenWidth(@Nullable String penName, boolean isFixedWidth) {
        if (this.mInitComplete) {
            SpenPenWidthMiniLayout spenPenWidthMiniLayout = this.mWidthItem;
            SpenPenWidthMiniLayout spenPenWidthMiniLayout2 = null;
            if (spenPenWidthMiniLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWidthItem");
                spenPenWidthMiniLayout = null;
            }
            spenPenWidthMiniLayout.setPenInfo(penName, 0, 0);
            SpenPenWidthMiniLayout spenPenWidthMiniLayout3 = this.mWidthItem;
            if (spenPenWidthMiniLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWidthItem");
            } else {
                spenPenWidthMiniLayout2 = spenPenWidthMiniLayout3;
            }
            spenPenWidthMiniLayout2.setPenWidth(isFixedWidth, false);
        }
    }

    public final void setSizeLevel(int sizeLevel, int color) {
        if (this.mInitComplete) {
            SpenPenAttrMiniView spenPenAttrMiniView = this.mSizeItem;
            if (spenPenAttrMiniView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSizeItem");
                spenPenAttrMiniView = null;
            }
            spenPenAttrMiniView.setSizeLevel(sizeLevel);
            SpenPenAttrMiniView spenPenAttrMiniView2 = this.mSizeItem;
            if (spenPenAttrMiniView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSizeItem");
                spenPenAttrMiniView2 = null;
            }
            spenPenAttrMiniView2.setValue(sizeLevel);
            SpenPenAttrMiniView spenPenAttrMiniView3 = this.mSizeItem;
            if (spenPenAttrMiniView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSizeItem");
                spenPenAttrMiniView3 = null;
            }
            spenPenAttrMiniView3.setColor(color);
            SpenPenSizeLayout spenPenSizeLayout = this.mSizeSlider;
            if (spenPenSizeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSizeSlider");
                spenPenSizeLayout = null;
            }
            spenPenSizeLayout.setPenInfo(null, sizeLevel, color);
            this.mSizeProgress = sizeLevel;
        }
    }

    public final void setSliderListener(@Nullable OnSliderListener listener) {
        if (this.mInitComplete) {
            this.mSliderListener = listener;
            SpenPenSizeLayout spenPenSizeLayout = this.mSizeSlider;
            SpenPenOpacityLayout spenPenOpacityLayout = null;
            if (spenPenSizeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSizeSlider");
                spenPenSizeLayout = null;
            }
            setSliderListener(spenPenSizeLayout.getMSizeView(), this.mOnSliderLabelListener);
            SpenPenOpacityLayout spenPenOpacityLayout2 = this.mOpacitySlider;
            if (spenPenOpacityLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOpacitySlider");
            } else {
                spenPenOpacityLayout = spenPenOpacityLayout2;
            }
            setSliderListener(spenPenOpacityLayout.getMSlider(), this.mOnSliderLabelListener);
        }
    }

    private final void setMode(Mode mode, boolean needAnimation) {
        boolean z;
        int i;
        Log.i(TAG, "setMode() mode=".concat(mode == Mode.SIZE ? "SIZE" : "OPACITY"));
        if (this.mInitComplete) {
            boolean z2 = mode != getMCurrentMode();
            boolean z3 = this.mSupportSelected;
            this.mCurrentMode = mode;
            int i2 = 8;
            if (mode == Mode.OPACITY) {
                i = 0;
                z = z3;
                z3 = false;
            } else {
                z = false;
                i = 8;
                i2 = 0;
            }
            SpenPenWidthMiniLayout spenPenWidthMiniLayout = null;
            if (z2 && needAnimation) {
                changeSliderAnimation(mode);
            } else {
                SpenPenSizeLayout spenPenSizeLayout = this.mSizeSlider;
                if (spenPenSizeLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSizeSlider");
                    spenPenSizeLayout = null;
                }
                spenPenSizeLayout.setVisibility(i2);
                SpenPenOpacityLayout spenPenOpacityLayout = this.mOpacitySlider;
                if (spenPenOpacityLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mOpacitySlider");
                    spenPenOpacityLayout = null;
                }
                spenPenOpacityLayout.setVisibility(i);
            }
            SpenPenAttrMiniView spenPenAttrMiniView = this.mSizeItem;
            if (spenPenAttrMiniView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSizeItem");
                spenPenAttrMiniView = null;
            }
            spenPenAttrMiniView.setSelected(z3);
            SpenPenOpacityMiniView spenPenOpacityMiniView = this.mOpacityItem;
            if (spenPenOpacityMiniView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOpacityItem");
                spenPenOpacityMiniView = null;
            }
            spenPenOpacityMiniView.setSelected(z);
            SpenPenWidthMiniLayout spenPenWidthMiniLayout2 = this.mWidthItem;
            if (spenPenWidthMiniLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWidthItem");
            } else {
                spenPenWidthMiniLayout = spenPenWidthMiniLayout2;
            }
            spenPenWidthMiniLayout.setSelected(false);
        }
    }

    private final void setSliderListener(SpenSlider slider, SpenUserLabelSlider.OnLabelListener listener) {
        if (slider == null || !(slider instanceof SpenUserLabelSlider)) {
            return;
        }
        ((SpenUserLabelSlider) slider).setOnLabelListener(listener);
    }

    public /* synthetic */ SpenPenAttrMiniLayout(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? 1 : i);
    }
}
