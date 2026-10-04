package com.samsung.android.sdk.pen.setting;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.SpenPopupLayout;
import com.samsung.android.sdk.pen.setting.common.SpenSwitchView;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p043J2.ViewOnClickListenerC0157a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 \"2\u00020\u0001:\u0003\"#$B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u000bJ\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u000bJ\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u000bJ\u0010\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u001f\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingStraightenLayout;", "Lcom/samsung/android/sdk/pen/setting/SpenPopupLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mLetterCorrectionSwitch", "Lcom/samsung/android/sdk/pen/setting/common/SpenSwitchView;", "mLowSpacingSwitch", "mWordSpacingSwitch", "mLetterCorrectionEnabled", "", "mLowSpacingEnabled", "mWordSpacingEnabled", "mInfoChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenSettingStraightenLayout$StraightenInfoChangedListener;", "mVisibilityChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenSettingStraightenLayout$ViewListener;", "close", "", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "", "setLetterCorrectionEnabled", "enable", "setLowSpacingEnabled", "setWordSpacingEnabled", "setStraightenInfoChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setVisibilityChangedListener", "construct", "initView", "Companion", "StraightenInfoChangedListener", "ViewListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSettingStraightenLayout extends SpenPopupLayout {

    @NotNull
    private static final String TAG = "SpenSettingStraightenLayout";

    @Nullable
    private StraightenInfoChangedListener mInfoChangedListener;
    private boolean mLetterCorrectionEnabled;
    private SpenSwitchView mLetterCorrectionSwitch;
    private boolean mLowSpacingEnabled;
    private SpenSwitchView mLowSpacingSwitch;

    @Nullable
    private ViewListener mVisibilityChangedListener;
    private boolean mWordSpacingEnabled;
    private SpenSwitchView mWordSpacingSwitch;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingStraightenLayout$StraightenInfoChangedListener;", "", "onLetterCorrectionChanged", "", "enable", "", "onLowSpacingChanged", "onWordSpacingChanged", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface StraightenInfoChangedListener {
        void onLetterCorrectionChanged(boolean enable);

        void onLowSpacingChanged(boolean enable);

        void onWordSpacingChanged(boolean enable);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingStraightenLayout$ViewListener;", "Lcom/samsung/android/sdk/pen/setting/SpenPopupLayout$ViewListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ViewListener extends SpenPopupLayout.ViewListener {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSettingStraightenLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        construct(context);
    }

    private final void construct(Context context) {
        this.mLetterCorrectionEnabled = false;
        this.mLowSpacingEnabled = false;
        this.mWordSpacingEnabled = false;
        initView(context);
    }

    private final void initView(Context context) {
        setTitleText("Straighten");
        SpenSwitchView spenSwitchView = null;
        View viewInflate = View.inflate(context, C7932R.layout.setting_straighten_layout, null);
        LinearLayout linearLayout = viewInflate instanceof LinearLayout ? (LinearLayout) viewInflate : null;
        if (linearLayout == null) {
            return;
        }
        SpenSwitchView spenSwitchView2 = (SpenSwitchView) linearLayout.findViewById(C7932R.id.letter_correction_switch);
        this.mLetterCorrectionSwitch = spenSwitchView2;
        if (spenSwitchView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLetterCorrectionSwitch");
            spenSwitchView2 = null;
        }
        spenSwitchView2.setText("Letter correction");
        SpenSwitchView spenSwitchView3 = this.mLetterCorrectionSwitch;
        if (spenSwitchView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLetterCorrectionSwitch");
            spenSwitchView3 = null;
        }
        spenSwitchView3.setChecked(this.mLetterCorrectionEnabled);
        SpenSwitchView spenSwitchView4 = this.mLetterCorrectionSwitch;
        if (spenSwitchView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLetterCorrectionSwitch");
            spenSwitchView4 = null;
        }
        final int i = 0;
        spenSwitchView4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: com.samsung.android.sdk.pen.setting.g

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenSettingStraightenLayout f5058b;

            {
                this.f5058b = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                switch (i) {
                    case 0:
                        SpenSettingStraightenLayout.initView$lambda$0(this.f5058b, compoundButton, z);
                        break;
                    case 1:
                        SpenSettingStraightenLayout.initView$lambda$1(this.f5058b, compoundButton, z);
                        break;
                    default:
                        SpenSettingStraightenLayout.initView$lambda$2(this.f5058b, compoundButton, z);
                        break;
                }
            }
        });
        SpenSwitchView spenSwitchView5 = (SpenSwitchView) linearLayout.findViewById(C7932R.id.low_spacing_switch);
        this.mLowSpacingSwitch = spenSwitchView5;
        if (spenSwitchView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLowSpacingSwitch");
            spenSwitchView5 = null;
        }
        spenSwitchView5.setText("Low spacing");
        SpenSwitchView spenSwitchView6 = this.mLowSpacingSwitch;
        if (spenSwitchView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLowSpacingSwitch");
            spenSwitchView6 = null;
        }
        spenSwitchView6.setChecked(this.mLowSpacingEnabled);
        SpenSwitchView spenSwitchView7 = this.mLowSpacingSwitch;
        if (spenSwitchView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLowSpacingSwitch");
            spenSwitchView7 = null;
        }
        final int i2 = 1;
        spenSwitchView7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: com.samsung.android.sdk.pen.setting.g

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenSettingStraightenLayout f5058b;

            {
                this.f5058b = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                switch (i2) {
                    case 0:
                        SpenSettingStraightenLayout.initView$lambda$0(this.f5058b, compoundButton, z);
                        break;
                    case 1:
                        SpenSettingStraightenLayout.initView$lambda$1(this.f5058b, compoundButton, z);
                        break;
                    default:
                        SpenSettingStraightenLayout.initView$lambda$2(this.f5058b, compoundButton, z);
                        break;
                }
            }
        });
        SpenSwitchView spenSwitchView8 = (SpenSwitchView) linearLayout.findViewById(C7932R.id.word_spacing_switch);
        this.mWordSpacingSwitch = spenSwitchView8;
        if (spenSwitchView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWordSpacingSwitch");
            spenSwitchView8 = null;
        }
        spenSwitchView8.setText("Word spacing");
        SpenSwitchView spenSwitchView9 = this.mWordSpacingSwitch;
        if (spenSwitchView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWordSpacingSwitch");
            spenSwitchView9 = null;
        }
        spenSwitchView9.setChecked(this.mWordSpacingEnabled);
        SpenSwitchView spenSwitchView10 = this.mWordSpacingSwitch;
        if (spenSwitchView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWordSpacingSwitch");
        } else {
            spenSwitchView = spenSwitchView10;
        }
        final int i4 = 2;
        spenSwitchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: com.samsung.android.sdk.pen.setting.g

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenSettingStraightenLayout f5058b;

            {
                this.f5058b = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                switch (i4) {
                    case 0:
                        SpenSettingStraightenLayout.initView$lambda$0(this.f5058b, compoundButton, z);
                        break;
                    case 1:
                        SpenSettingStraightenLayout.initView$lambda$1(this.f5058b, compoundButton, z);
                        break;
                    default:
                        SpenSettingStraightenLayout.initView$lambda$2(this.f5058b, compoundButton, z);
                        break;
                }
            }
        });
        setContentView(linearLayout);
        setCloseButtonInfo(new ViewOnClickListenerC0157a(this, 26));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(SpenSettingStraightenLayout spenSettingStraightenLayout, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (spenSettingStraightenLayout.mLetterCorrectionEnabled == z) {
            return;
        }
        spenSettingStraightenLayout.mLetterCorrectionEnabled = z;
        StraightenInfoChangedListener straightenInfoChangedListener = spenSettingStraightenLayout.mInfoChangedListener;
        if (straightenInfoChangedListener != null) {
            straightenInfoChangedListener.onLetterCorrectionChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(SpenSettingStraightenLayout spenSettingStraightenLayout, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (spenSettingStraightenLayout.mLowSpacingEnabled == z) {
            return;
        }
        spenSettingStraightenLayout.mLowSpacingEnabled = z;
        StraightenInfoChangedListener straightenInfoChangedListener = spenSettingStraightenLayout.mInfoChangedListener;
        if (straightenInfoChangedListener != null) {
            straightenInfoChangedListener.onLowSpacingChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(SpenSettingStraightenLayout spenSettingStraightenLayout, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (spenSettingStraightenLayout.mWordSpacingEnabled == z) {
            return;
        }
        spenSettingStraightenLayout.mWordSpacingEnabled = z;
        StraightenInfoChangedListener straightenInfoChangedListener = spenSettingStraightenLayout.mInfoChangedListener;
        if (straightenInfoChangedListener != null) {
            straightenInfoChangedListener.onWordSpacingChanged(z);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPopupLayout
    public void close() {
        SpenSwitchView spenSwitchView = this.mLetterCorrectionSwitch;
        if (spenSwitchView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLetterCorrectionSwitch");
            spenSwitchView = null;
        }
        spenSwitchView.close();
        SpenSwitchView spenSwitchView2 = this.mLowSpacingSwitch;
        if (spenSwitchView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLowSpacingSwitch");
            spenSwitchView2 = null;
        }
        spenSwitchView2.close();
        SpenSwitchView spenSwitchView3 = this.mWordSpacingSwitch;
        if (spenSwitchView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWordSpacingSwitch");
            spenSwitchView3 = null;
        }
        spenSwitchView3.close();
        this.mInfoChangedListener = null;
        this.mVisibilityChangedListener = null;
        super.close();
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPopupLayout, android.view.View
    public void onVisibilityChanged(@NotNull View changedView, int visibility) {
        ViewListener viewListener;
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        if (Intrinsics.areEqual(changedView, this) && (viewListener = this.mVisibilityChangedListener) != null) {
            viewListener.onVisibilityChanged(visibility);
        }
        super.onVisibilityChanged(changedView, visibility);
    }

    public final void setLetterCorrectionEnabled(boolean enable) {
        this.mLetterCorrectionEnabled = enable;
        SpenSwitchView spenSwitchView = this.mLetterCorrectionSwitch;
        if (spenSwitchView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLetterCorrectionSwitch");
            spenSwitchView = null;
        }
        spenSwitchView.setChecked(enable);
    }

    public final void setLowSpacingEnabled(boolean enable) {
        this.mLowSpacingEnabled = enable;
        SpenSwitchView spenSwitchView = this.mLowSpacingSwitch;
        if (spenSwitchView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLowSpacingSwitch");
            spenSwitchView = null;
        }
        spenSwitchView.setChecked(enable);
    }

    public final void setStraightenInfoChangedListener(@Nullable StraightenInfoChangedListener listener) {
        this.mInfoChangedListener = listener;
    }

    public final void setVisibilityChangedListener(@Nullable ViewListener listener) {
        this.mVisibilityChangedListener = listener;
    }

    public final void setWordSpacingEnabled(boolean enable) {
        this.mWordSpacingEnabled = enable;
        SpenSwitchView spenSwitchView = this.mWordSpacingSwitch;
        if (spenSwitchView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWordSpacingSwitch");
            spenSwitchView = null;
        }
        spenSwitchView.setChecked(enable);
    }
}
