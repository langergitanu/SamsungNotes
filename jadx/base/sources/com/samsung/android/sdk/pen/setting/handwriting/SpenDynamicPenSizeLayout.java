package com.samsung.android.sdk.pen.setting.handwriting;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.common.SpenSwitchView;
import com.samsung.android.sdk.pen.setting.common.SpenTabGroup;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p091W2.C0331a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 =2\u00020\u0001:\u0003=>?B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\tJ\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020#2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u0019J\u000e\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u001bJ\u000e\u0010)\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J \u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u0010H\u0002J\u0010\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u0010H\u0002J\u0010\u00102\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u00020\tH\u0002J\u001a\u00105\u001a\u00020\u001d2\b\u00106\u001a\u0004\u0018\u00010\u00172\u0006\u00107\u001a\u00020\tH\u0002J\u0010\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\tH\u0002J\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\tH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenDynamicPenSizeLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "fitLevels", "", "isAutoThickness", "", Bixby2Constants.BIXBY_PARAM_RANGE, "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenDynamicPenSizeLayout$CoverRange;", "rangeValues", "", "[Lcom/samsung/android/sdk/pen/setting/handwriting/SpenDynamicPenSizeLayout$CoverRange;", "rangeIds", "", "[Ljava/lang/Integer;", "tabGroup", "Lcom/samsung/android/sdk/pen/setting/common/SpenTabGroup;", "adjustThicknessSwitch", "Lcom/samsung/android/sdk/pen/setting/common/SpenSwitchView;", "optionGroup", "Landroid/view/View;", "dataChangedListener", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenDynamicPenSizeLayout$OnDataChangedListener;", "transitionTargetView", "Landroid/view/ViewGroup;", "close", "", "setAutoThicknessEnabled", "enable", "setRange", "setRangeByRatio", "ratio", "", "getRatioByRange", "setOnDataChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setTransitionTargetView", "targetView", "setAutoSizeFitLevels", "construct", "setIconBgColor", "layerDrawable", "Landroid/graphics/drawable/LayerDrawable;", "layerId", "color", "getRange", "id", "getId", "updateLayout", "animation", "scaleViewAnimation", "view", Constants.IntentExtraValue.SHOW, "startTransition", "isExpended", "getTransition", "Landroid/transition/TransitionSet;", "isNeedExpend", "Companion", "CoverRange", "OnDataChangedListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenDynamicPenSizeLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenDynamicPenSizeLayout.kt\ncom/samsung/android/sdk/pen/setting/handwriting/SpenDynamicPenSizeLayout\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,219:1\n16867#2,14:220\n13644#2,3:234\n*S KotlinDebug\n*F\n+ 1 SpenDynamicPenSizeLayout.kt\ncom/samsung/android/sdk/pen/setting/handwriting/SpenDynamicPenSizeLayout\n*L\n78#1:220,14\n131#1:234,3\n*E\n"})
public final class SpenDynamicPenSizeLayout extends LinearLayout {
    public static final int FIT_LEVEL_MAX = 3;
    public static final float FIT_RATIO_MEDIUM = 0.7f;
    public static final float FIT_RATIO_THICK = 1.0f;
    public static final float FIT_RATIO_THIN = 0.5f;

    @NotNull
    private static final String TAG = "SpenPenAdjustThicknessLayout";
    private SpenSwitchView adjustThicknessSwitch;

    @Nullable
    private OnDataChangedListener dataChangedListener;

    @NotNull
    private float[] fitLevels;
    private boolean isAutoThickness;
    private View optionGroup;

    @NotNull
    private CoverRange range;

    @NotNull
    private final Integer[] rangeIds;

    @NotNull
    private final CoverRange[] rangeValues;
    private SpenTabGroup tabGroup;

    @Nullable
    private ViewGroup transitionTargetView;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenDynamicPenSizeLayout$CoverRange;", "", "<init>", "(Ljava/lang/String;I)V", "THIN", "MEDIUM", "THICK", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class CoverRange {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CoverRange[] $VALUES;
        public static final CoverRange THIN = new CoverRange("THIN", 0);
        public static final CoverRange MEDIUM = new CoverRange("MEDIUM", 1);
        public static final CoverRange THICK = new CoverRange("THICK", 2);

        private static final /* synthetic */ CoverRange[] $values() {
            return new CoverRange[]{THIN, MEDIUM, THICK};
        }

        static {
            CoverRange[] coverRangeArr$values = $values();
            $VALUES = coverRangeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(coverRangeArr$values);
        }

        private CoverRange(String str, int i) {
        }

        @NotNull
        public static EnumEntries<CoverRange> getEntries() {
            return $ENTRIES;
        }

        public static CoverRange valueOf(String str) {
            return (CoverRange) Enum.valueOf(CoverRange.class, str);
        }

        public static CoverRange[] values() {
            return (CoverRange[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenDynamicPenSizeLayout$OnDataChangedListener;", "", "onAutoThicknessChanged", "", "enable", "", "onRangeChanged", Bixby2Constants.BIXBY_PARAM_RANGE, "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenDynamicPenSizeLayout$CoverRange;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnDataChangedListener {
        void onAutoThicknessChanged(boolean enable);

        void onRangeChanged(@NotNull CoverRange range);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CoverRange.values().length];
            try {
                iArr[CoverRange.THIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CoverRange.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CoverRange.THICK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenDynamicPenSizeLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.fitLevels = new float[3];
        CoverRange coverRange = CoverRange.THICK;
        this.range = coverRange;
        this.rangeValues = new CoverRange[]{CoverRange.THIN, CoverRange.MEDIUM, coverRange};
        this.rangeIds = new Integer[]{Integer.valueOf(C7932R.id.text_thickness_50_view), Integer.valueOf(C7932R.id.text_thickness_70_view), Integer.valueOf(C7932R.id.text_thickness_full_view)};
        construct(context);
    }

    private final void construct(Context context) {
        this.fitLevels = new float[]{0.5f, 0.7f, 1.0f};
        setOrientation(1);
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ((LayoutInflater) systemService).inflate(C7932R.layout.setting_pen_dynamic_pen_size_layout, (ViewGroup) this, true);
        SpenSwitchView spenSwitchView = (SpenSwitchView) findViewById(C7932R.id.dynamic_pen_size_switch);
        this.adjustThicknessSwitch = spenSwitchView;
        View view = null;
        if (spenSwitchView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adjustThicknessSwitch");
            spenSwitchView = null;
        }
        spenSwitchView.setText(C7932R.string.pen_string_adjust_thickness_to_text);
        SpenSwitchView spenSwitchView2 = this.adjustThicknessSwitch;
        if (spenSwitchView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adjustThicknessSwitch");
            spenSwitchView2 = null;
        }
        spenSwitchView2.setChecked(this.isAutoThickness);
        SpenSwitchView spenSwitchView3 = this.adjustThicknessSwitch;
        if (spenSwitchView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adjustThicknessSwitch");
            spenSwitchView3 = null;
        }
        spenSwitchView3.setOnCheckedChangeListener(new C0331a(this, 2));
        this.tabGroup = new SpenTabGroup();
        int primaryColor = SpenSettingUtil.getPrimaryColor(context);
        Integer[] numArr = this.rangeIds;
        int length = numArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i4 = i2 + 1;
            ImageView imageView = (ImageView) findViewById(numArr[i].intValue());
            Drawable drawable = imageView.getDrawable();
            Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
            setIconBgColor((LayerDrawable) drawable, C7932R.id.range_bg, primaryColor);
            SpenSettingUtilHover.setHoverText(imageView, context.getResources().getString(C7932R.string.pen_string_percent_text_height, Integer.valueOf((int) (this.fitLevels[i2] * 100))));
            SpenTabGroup spenTabGroup = this.tabGroup;
            if (spenTabGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabGroup");
                spenTabGroup = null;
            }
            spenTabGroup.addTab(imageView);
            i++;
            i2 = i4;
        }
        SpenTabGroup spenTabGroup2 = this.tabGroup;
        if (spenTabGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabGroup");
            spenTabGroup2 = null;
        }
        spenTabGroup2.select(getId(this.range));
        SpenTabGroup spenTabGroup3 = this.tabGroup;
        if (spenTabGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabGroup");
            spenTabGroup3 = null;
        }
        spenTabGroup3.setOnTabSelectedListener(new SpenTabGroup.OnTabSelectedListener() { // from class: com.samsung.android.sdk.pen.setting.handwriting.SpenDynamicPenSizeLayout.construct.3
            @Override // com.samsung.android.sdk.pen.setting.common.SpenTabGroup.OnTabSelectedListener
            public void onTabSelected(View tab) {
                Log.i(SpenDynamicPenSizeLayout.TAG, "onTabSelected()");
                if (tab != null) {
                    SpenDynamicPenSizeLayout spenDynamicPenSizeLayout = SpenDynamicPenSizeLayout.this;
                    spenDynamicPenSizeLayout.range = spenDynamicPenSizeLayout.getRange(tab.getId());
                    OnDataChangedListener onDataChangedListener = spenDynamicPenSizeLayout.dataChangedListener;
                    if (onDataChangedListener != null) {
                        onDataChangedListener.onRangeChanged(spenDynamicPenSizeLayout.range);
                    }
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenTabGroup.OnTabSelectedListener
            public void onTabReselected(View tab) {
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenTabGroup.OnTabSelectedListener
            public void onTabUnselected(View tab) {
            }
        });
        View viewFindViewById = findViewById(C7932R.id.text_thickness_option_layout);
        this.optionGroup = viewFindViewById;
        if (viewFindViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("optionGroup");
        } else {
            view = viewFindViewById;
        }
        view.setVisibility(this.isAutoThickness ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void construct$lambda$1(SpenDynamicPenSizeLayout spenDynamicPenSizeLayout, CompoundButton buttonView, boolean z) {
        Intrinsics.checkNotNullParameter(buttonView, "buttonView");
        AbstractC6670b.m4758s("onCheckedChanged() isChecked=", " isAutoThickness=", TAG, z, spenDynamicPenSizeLayout.isAutoThickness);
        if (z != spenDynamicPenSizeLayout.isAutoThickness) {
            spenDynamicPenSizeLayout.isAutoThickness = z;
            spenDynamicPenSizeLayout.updateLayout(true);
            OnDataChangedListener onDataChangedListener = spenDynamicPenSizeLayout.dataChangedListener;
            if (onDataChangedListener != null) {
                onDataChangedListener.onAutoThicknessChanged(z);
            }
        }
    }

    private final int getId(CoverRange range) {
        return this.rangeIds[ArraysKt.indexOf(this.rangeValues, range)].intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoverRange getRange(int id) {
        return this.rangeValues[ArraysKt.indexOf(this.rangeIds, Integer.valueOf(id))];
    }

    private final TransitionSet getTransition(boolean isNeedExpend) {
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.setOrdering(0);
        if (isNeedExpend) {
            transitionSet.addTransition(new ChangeBounds().setDuration(333L).setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.3f, 1.0f)));
            return transitionSet;
        }
        transitionSet.addTransition(new ChangeBounds().setDuration(333L).setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.3f, 1.0f)).setStartDelay(150L));
        return transitionSet;
    }

    private final void scaleViewAnimation(View view, boolean show) {
        Animation animationLoadAnimation;
        if (view == null) {
            return;
        }
        if (show) {
            view.setVisibility(0);
            animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), C7932R.anim.spen_seekbar_scale_up);
            animationLoadAnimation.setStartOffset(150L);
        } else {
            view.setVisibility(8);
            animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), C7932R.anim.spen_seekbar_scale_down);
        }
        view.startAnimation(animationLoadAnimation);
    }

    private final void setIconBgColor(LayerDrawable layerDrawable, int layerId, int color) {
        Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(layerId);
        if (drawableFindDrawableByLayerId != null) {
            drawableFindDrawableByLayerId.setTint(color);
        }
    }

    private final void startTransition(boolean isExpended) {
        ViewGroup viewGroup = this.transitionTargetView;
        if (viewGroup != null) {
            TransitionManager.beginDelayedTransition(viewGroup, getTransition(isExpended));
        }
    }

    private final void updateLayout(boolean animation) {
        View view = null;
        if (!animation) {
            View view2 = this.optionGroup;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("optionGroup");
            } else {
                view = view2;
            }
            view.setVisibility(this.isAutoThickness ? 0 : 8);
            return;
        }
        startTransition(this.isAutoThickness);
        View view3 = this.optionGroup;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("optionGroup");
        } else {
            view = view3;
        }
        scaleViewAnimation(view, this.isAutoThickness);
    }

    public final void close() {
        SpenTabGroup spenTabGroup = null;
        this.transitionTargetView = null;
        SpenTabGroup spenTabGroup2 = this.tabGroup;
        if (spenTabGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabGroup");
        } else {
            spenTabGroup = spenTabGroup2;
        }
        spenTabGroup.close();
    }

    public final float getRatioByRange(@NotNull CoverRange range) {
        Intrinsics.checkNotNullParameter(range, "range");
        int i = WhenMappings.$EnumSwitchMapping$0[range.ordinal()];
        if (i == 1) {
            return this.fitLevels[0];
        }
        if (i == 2) {
            return this.fitLevels[1];
        }
        if (i == 3) {
            return this.fitLevels[2];
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean setAutoSizeFitLevels(@NotNull float[] fitLevels) {
        Intrinsics.checkNotNullParameter(fitLevels, "fitLevels");
        if (fitLevels.length < 3) {
            return false;
        }
        float[] fArr = this.fitLevels;
        fArr[0] = fitLevels[0];
        fArr[1] = fitLevels[1];
        fArr[2] = fitLevels[2];
        return true;
    }

    public final void setAutoThicknessEnabled(boolean enable) {
        if (this.isAutoThickness == enable) {
            return;
        }
        SpenSwitchView spenSwitchView = this.adjustThicknessSwitch;
        if (spenSwitchView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adjustThicknessSwitch");
            spenSwitchView = null;
        }
        spenSwitchView.setChecked(enable);
    }

    public final void setOnDataChangedListener(@NotNull OnDataChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.dataChangedListener = listener;
    }

    public final void setRange(@NotNull CoverRange range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (this.range == range) {
            return;
        }
        this.range = range;
        SpenTabGroup spenTabGroup = this.tabGroup;
        if (spenTabGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabGroup");
            spenTabGroup = null;
        }
        spenTabGroup.select(getId(range));
        updateLayout(false);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    public final void setRangeByRatio(float ratio) {
        Float fValueOf;
        CoverRange coverRange;
        float[] fArr = this.fitLevels;
        if (fArr.length == 0) {
            fValueOf = null;
        } else {
            float f = fArr[0];
            int lastIndex = ArraysKt.getLastIndex(fArr);
            if (lastIndex == 0) {
                fValueOf = Float.valueOf(f);
            } else {
                float fAbs = Math.abs(f - ratio);
                ?? Iterator2 = new IntRange(1, lastIndex).iterator();
                while (Iterator2.hasNext()) {
                    float f4 = fArr[Iterator2.nextInt()];
                    float fAbs2 = Math.abs(f4 - ratio);
                    if (Float.compare(fAbs, fAbs2) > 0) {
                        f = f4;
                        fAbs = fAbs2;
                    }
                }
                fValueOf = Float.valueOf(f);
            }
        }
        if (Intrinsics.areEqual(fValueOf, this.fitLevels[0])) {
            coverRange = CoverRange.THIN;
        } else if (Intrinsics.areEqual(fValueOf, this.fitLevels[1])) {
            coverRange = CoverRange.MEDIUM;
        } else if (!Intrinsics.areEqual(fValueOf, this.fitLevels[2])) {
            return;
        } else {
            coverRange = CoverRange.THICK;
        }
        setRange(coverRange);
    }

    public final void setTransitionTargetView(@NotNull ViewGroup targetView) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        this.transitionTargetView = targetView;
    }
}
