package com.samsung.android.sdk.pen.setting.selection;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingSelectionInfo;
import com.samsung.android.sdk.pen.setting.common.C7558c;
import com.samsung.android.sdk.pen.setting.common.SpenRadioListLayout;
import com.samsung.android.sdk.pen.setting.common.SpenSwitchView;
import com.samsung.android.sdk.pen.setting.selection.SpenSelectionLayout;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0002$%B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010 \u001a\u00020\u0014H\u0002J\b\u0010!\u001a\u00020\u0014H\u0002J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u001eH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/selection/SpenSelectionLayout;", "Lcom/samsung/android/sdk/pen/setting/common/SpenRadioListLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mActionListener", "Lcom/samsung/android/sdk/pen/setting/selection/SpenSelectionLayout$OnActionListener;", "mSettingInfo", "Lcom/samsung/android/sdk/pen/SpenSettingSelectionInfo;", "mContext", "mOptionSwitch", "Lcom/samsung/android/sdk/pen/setting/common/SpenSwitchView;", "mRadioBtnListener", "Landroid/widget/RadioGroup$OnCheckedChangeListener;", "mOptionSwitchChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "close", "", "setActionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "settingSelectionInfo", "info", "getInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingSelectionInfo;", "setInfo", "(Lcom/samsung/android/sdk/pen/SpenSettingSelectionInfo;)V", "isSameSelectionInfo", "", "construct", "initSwitchView", "initRadioButton", "setSwitchValue", "isChecked", "Companion", "OnActionListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSelectionLayout extends SpenRadioListLayout {

    @NotNull
    private static final String TAG = "SpenSelectionLayout";

    @Nullable
    private OnActionListener mActionListener;
    private Context mContext;
    private SpenSwitchView mOptionSwitch;

    @NotNull
    private final CompoundButton.OnCheckedChangeListener mOptionSwitchChangeListener;

    @NotNull
    private final RadioGroup.OnCheckedChangeListener mRadioBtnListener;
    private SpenSettingSelectionInfo mSettingInfo;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/selection/SpenSelectionLayout$OnActionListener;", "", "onSelectionChanged", "", "type", "", "onSelectionOptionChanged", "includePartiallySelected", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnActionListener {
        void onSelectionChanged(int type);

        void onSelectionOptionChanged(boolean includePartiallySelected);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public SpenSelectionLayout(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void construct(Context context) {
        Log.i(TAG, "construct");
        this.mContext = context;
        this.mSettingInfo = new SpenSettingSelectionInfo();
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ((LayoutInflater) systemService).inflate(C7932R.layout.setting_selection_layout_v53, (ViewGroup) this, true);
        setClipChildren(false);
        initRadioButton();
        initSwitchView();
    }

    private final void initRadioButton() {
        Context context = this.mContext;
        SpenSettingSelectionInfo spenSettingSelectionInfo = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C7932R.dimen.selection_radio_button_compound_drawable_padding);
        Context context2 = this.mContext;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context2 = null;
        }
        int color = SpenSettingUtil.getColor(context2, C7932R.color.setting_selection_icon_tint_color);
        Context context3 = this.mContext;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context3 = null;
        }
        Drawable drawable = ContextCompat.getDrawable(context3, C7932R.drawable.selection_lasso);
        Context context4 = this.mContext;
        if (context4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context4 = null;
        }
        Drawable drawable2 = ContextCompat.getDrawable(context4, C7932R.drawable.selection_rectangle);
        initLayout(C7932R.id.selection_radio_group, this.mRadioBtnListener);
        setItem(C7932R.id.selection_radio_button_lasso, C7932R.id.selection_radio_ripple_button_view_1, C7932R.string.pen_string_lasso, drawable, dimensionPixelSize, color);
        setItem(C7932R.id.selection_radio_button_rect, C7932R.id.selection_radio_ripple_button_view_2, C7932R.string.pen_string_rectangle, drawable2, dimensionPixelSize, color);
        SpenSettingSelectionInfo spenSettingSelectionInfo2 = this.mSettingInfo;
        if (spenSettingSelectionInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingInfo");
        } else {
            spenSettingSelectionInfo = spenSettingSelectionInfo2;
        }
        setInfo(spenSettingSelectionInfo.type == 0 ? C7932R.id.selection_radio_button_lasso : C7932R.id.selection_radio_button_rect);
    }

    private final void initSwitchView() {
        SpenSwitchView spenSwitchView = (SpenSwitchView) findViewById(C7932R.id.partially_selected_switch);
        this.mOptionSwitch = spenSwitchView;
        SpenSwitchView spenSwitchView2 = null;
        if (spenSwitchView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOptionSwitch");
            spenSwitchView = null;
        }
        spenSwitchView.setText(C7932R.string.pen_string_include_partially_selected_objects);
        SpenSwitchView spenSwitchView3 = this.mOptionSwitch;
        if (spenSwitchView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOptionSwitch");
        } else {
            spenSwitchView2 = spenSwitchView3;
        }
        spenSwitchView2.setOnCheckedChangeListener(this.mOptionSwitchChangeListener);
    }

    private final boolean isSameSelectionInfo(SpenSettingSelectionInfo info) {
        SpenSettingSelectionInfo spenSettingSelectionInfo = this.mSettingInfo;
        SpenSettingSelectionInfo spenSettingSelectionInfo2 = null;
        if (spenSettingSelectionInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingInfo");
            spenSettingSelectionInfo = null;
        }
        if (spenSettingSelectionInfo.type != info.type) {
            return false;
        }
        SpenSettingSelectionInfo spenSettingSelectionInfo3 = this.mSettingInfo;
        if (spenSettingSelectionInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingInfo");
        } else {
            spenSettingSelectionInfo2 = spenSettingSelectionInfo3;
        }
        return spenSettingSelectionInfo2.includePartiallySelected == info.includePartiallySelected;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mRadioBtnListener$lambda$0(SpenSelectionLayout spenSelectionLayout, RadioGroup arg, int i) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        SpenSettingSelectionInfo spenSettingSelectionInfo = null;
        if (i == C7932R.id.selection_radio_button_lasso) {
            Log.i(TAG, "mRadioBtnListener - 1");
            SpenSettingSelectionInfo spenSettingSelectionInfo2 = spenSelectionLayout.mSettingInfo;
            if (spenSettingSelectionInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSettingInfo");
                spenSettingSelectionInfo2 = null;
            }
            spenSettingSelectionInfo2.type = 0;
        } else {
            if (i != C7932R.id.selection_radio_button_rect) {
                return;
            }
            Log.i(TAG, "mRadioBtnListener - 2");
            SpenSettingSelectionInfo spenSettingSelectionInfo3 = spenSelectionLayout.mSettingInfo;
            if (spenSettingSelectionInfo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSettingInfo");
                spenSettingSelectionInfo3 = null;
            }
            spenSettingSelectionInfo3.type = 1;
        }
        OnActionListener onActionListener = spenSelectionLayout.mActionListener;
        if (onActionListener == null || onActionListener == null) {
            return;
        }
        SpenSettingSelectionInfo spenSettingSelectionInfo4 = spenSelectionLayout.mSettingInfo;
        if (spenSettingSelectionInfo4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingInfo");
        } else {
            spenSettingSelectionInfo = spenSettingSelectionInfo4;
        }
        onActionListener.onSelectionChanged(spenSettingSelectionInfo.type);
    }

    private final void setSwitchValue(boolean isChecked) {
        SpenSwitchView spenSwitchView = this.mOptionSwitch;
        SpenSwitchView spenSwitchView2 = null;
        if (spenSwitchView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOptionSwitch");
            spenSwitchView = null;
        }
        if (spenSwitchView.isChecked() == isChecked) {
            return;
        }
        SpenSwitchView spenSwitchView3 = this.mOptionSwitch;
        if (spenSwitchView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOptionSwitch");
        } else {
            spenSwitchView2 = spenSwitchView3;
        }
        spenSwitchView2.setChecked(isChecked);
    }

    @Override // com.samsung.android.sdk.pen.setting.common.SpenRadioListLayout
    public void close() {
        Log.i(TAG, "close");
        SpenSwitchView spenSwitchView = this.mOptionSwitch;
        if (spenSwitchView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOptionSwitch");
            spenSwitchView = null;
        }
        spenSwitchView.close();
        super.close();
    }

    @NotNull
    public final SpenSettingSelectionInfo getInfo() {
        SpenSettingSelectionInfo spenSettingSelectionInfo = this.mSettingInfo;
        if (spenSettingSelectionInfo != null) {
            return spenSettingSelectionInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSettingInfo");
        return null;
    }

    public final void setActionListener(@Nullable OnActionListener listener) {
        this.mActionListener = listener;
    }

    public final void setInfo(@NotNull SpenSettingSelectionInfo settingSelectionInfo) {
        Intrinsics.checkNotNullParameter(settingSelectionInfo, "settingSelectionInfo");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        SpenSettingSelectionInfo spenSettingSelectionInfo = this.mSettingInfo;
        SpenSettingSelectionInfo spenSettingSelectionInfo2 = null;
        if (spenSettingSelectionInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingInfo");
            spenSettingSelectionInfo = null;
        }
        Integer numValueOf = Integer.valueOf(spenSettingSelectionInfo.type);
        SpenSettingSelectionInfo spenSettingSelectionInfo3 = this.mSettingInfo;
        if (spenSettingSelectionInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingInfo");
            spenSettingSelectionInfo3 = null;
        }
        AbstractC6670b.m4765z(new Object[]{numValueOf, Boolean.valueOf(spenSettingSelectionInfo3.includePartiallySelected), Integer.valueOf(settingSelectionInfo.type), Boolean.valueOf(settingSelectionInfo.includePartiallySelected)}, 4, "setInfo() From[%d, %s]->To[%d, %s]", "format(format, *args)", TAG);
        if (isSameSelectionInfo(settingSelectionInfo)) {
            return;
        }
        SpenSettingSelectionInfo spenSettingSelectionInfo4 = this.mSettingInfo;
        if (spenSettingSelectionInfo4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingInfo");
            spenSettingSelectionInfo4 = null;
        }
        spenSettingSelectionInfo4.type = settingSelectionInfo.type;
        SpenSettingSelectionInfo spenSettingSelectionInfo5 = this.mSettingInfo;
        if (spenSettingSelectionInfo5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingInfo");
        } else {
            spenSettingSelectionInfo2 = spenSettingSelectionInfo5;
        }
        spenSettingSelectionInfo2.includePartiallySelected = settingSelectionInfo.includePartiallySelected;
        setInfo(settingSelectionInfo.type == 0 ? C7932R.id.selection_radio_button_lasso : C7932R.id.selection_radio_button_rect);
        setSwitchValue(settingSelectionInfo.includePartiallySelected);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpenSelectionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRadioBtnListener = new C7558c(this, 3);
        this.mOptionSwitchChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.samsung.android.sdk.pen.setting.selection.SpenSelectionLayout$mOptionSwitchChangeListener$1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Intrinsics.checkNotNullParameter(buttonView, "buttonView");
                SpenSettingSelectionInfo spenSettingSelectionInfo = this.this$0.mSettingInfo;
                SpenSettingSelectionInfo spenSettingSelectionInfo2 = null;
                if (spenSettingSelectionInfo == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSettingInfo");
                    spenSettingSelectionInfo = null;
                }
                if (spenSettingSelectionInfo.includePartiallySelected == isChecked) {
                    return;
                }
                SpenSettingSelectionInfo spenSettingSelectionInfo3 = this.this$0.mSettingInfo;
                if (spenSettingSelectionInfo3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSettingInfo");
                } else {
                    spenSettingSelectionInfo2 = spenSettingSelectionInfo3;
                }
                spenSettingSelectionInfo2.includePartiallySelected = isChecked;
                SpenSelectionLayout.OnActionListener onActionListener = this.this$0.mActionListener;
                if (onActionListener != null) {
                    onActionListener.onSelectionOptionChanged(isChecked);
                }
            }
        };
        construct(context);
    }

    public /* synthetic */ SpenSelectionLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }
}
