package com.samsung.android.sdk.pen.setting.common;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.common.SpenSeekBarButtonControl;
import com.samsung.android.sdk.pen.setting.common.SpenSeekBarButtonControl.RptUpdater;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\t*\u0001\u0019\b\u0000\u0018\u0000 V2\u00020\u0001:\u0004VWXYB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001f\u001a\u00020 J$\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010#\u001a\u0004\u0018\u00010\t2\b\u0010$\u001a\u0004\u0018\u00010\tJ4\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010%\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010\t2\u0006\u0010&\u001a\u00020\u0015J\u0010\u0010'\u001a\u00020 2\b\u0010(\u001a\u0004\u0018\u00010\fJ\u000e\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\u0015J\u0010\u00102\u001a\u00020 2\b\u00103\u001a\u0004\u0018\u00010\u000fJ\u0006\u00104\u001a\u00020 J\u0006\u00105\u001a\u00020 J4\u00106\u001a\u00020 2\b\u00107\u001a\u0004\u0018\u00010\t2\u0006\u00108\u001a\u00020\u00152\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020\u00152\u0006\u0010<\u001a\u00020=H\u0002J\u0012\u0010>\u001a\u00020 2\b\u00107\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010?\u001a\u00020=2\b\u0010@\u001a\u0004\u0018\u00010AH\u0002J\b\u0010B\u001a\u00020 H\u0002J \u0010C\u001a\u00020\u00112\u0006\u0010D\u001a\u00020A2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020FH\u0002J\u0018\u0010H\u001a\u00020 2\u0006\u0010D\u001a\u00020A2\u0006\u0010I\u001a\u00020\u0011H\u0002J\u0010\u0010J\u001a\u00020\u00112\u0006\u0010@\u001a\u00020AH\u0002J\u0018\u0010K\u001a\u00020\u00112\u0006\u0010@\u001a\u00020A2\u0006\u0010L\u001a\u00020\u0011H\u0002J\u0010\u0010M\u001a\u00020 2\u0006\u0010N\u001a\u00020AH\u0002J\u001a\u0010O\u001a\u00020 2\u0006\u0010D\u001a\u00020A2\b\u0010P\u001a\u0004\u0018\u00010QH\u0002J\u0010\u0010R\u001a\u00020Q2\u0006\u0010@\u001a\u00020AH\u0002J\"\u0010S\u001a\u00020 2\u0006\u0010T\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\u00112\b\u00107\u001a\u0004\u0018\u00010\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010)\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b)\u0010*R$\u0010+\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010*\"\u0004\b-\u0010.R\u0011\u0010/\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b/\u0010*¨\u0006Z"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarButtonControl;", "", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mSeekBar", "Landroid/widget/SeekBar;", "mMinusButton", "Landroid/widget/ImageButton;", "mPlusButton", "mActionListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarButtonControl$OnActionListener;", "mDisallowInterceptGroup", "", "Landroid/view/ViewGroup;", "mAutoDecrement", "", "mAutoIncrement", "mUserEvent", "mFactor", "", "mButtonLongClickListener", "Landroid/view/View$OnLongClickListener;", "mButtonOnTouchListener", "com/samsung/android/sdk/pen/setting/common/SpenSeekBarButtonControl$mButtonOnTouchListener$1", "Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarButtonControl$mButtonOnTouchListener$1;", "mButtonClickListener", "Landroid/view/View$OnClickListener;", "mButtonOnKeyListener", "Landroid/view/View$OnKeyListener;", "close", "", "initControlButton", "seekBar", "minusButton", "plusButton", "minusButtonStringId", "plusButtonStringId", "setActionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "isUserEvent", "()Z", "userEvent", "getUserEvent", "setUserEvent", "(Z)V", "isAutoChanged", "setFactorValue", "factorValue", "addDisallowTouchInterceptGroup", "group", "clearDisallowTouchInterceptGroup", "updateButtonState", "initButton", MarketingConstants.BUTTON, "resId", "stateList", "Landroid/content/res/ColorStateList;", "hoverStrId", "tagId", "Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarButtonControl$ButtonType;", "initButtonListener", "getButtonType", VPathDataCmd.RCurveTo, "Landroid/view/View;", "requestDisallowTouch", "isOutOfBounds", "view", "posX", "", "posY", "stopAutoUpdate", "playSound", "getAutoFlag", "setAutoFlag", "flag", "updateAutoSeekBar", "autoButton", "setHoverDescription", "description", "", "getHoverDescription", "setButtonState", "condition", DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "Companion", "ButtonType", "OnActionListener", "RptUpdater", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSeekBarButtonControl {
    private static final int REP_DELAY = 20;

    @NotNull
    private static final String TAG = "SpenSeekBarButtonControl";

    @Nullable
    private OnActionListener mActionListener;
    private boolean mAutoDecrement;
    private boolean mAutoIncrement;

    @NotNull
    private final View.OnClickListener mButtonClickListener;

    @NotNull
    private final View.OnLongClickListener mButtonLongClickListener;

    @NotNull
    private final View.OnKeyListener mButtonOnKeyListener;

    @NotNull
    private final SpenSeekBarButtonControl$mButtonOnTouchListener$1 mButtonOnTouchListener;

    @NotNull
    private Context mContext;

    @NotNull
    private List<ViewGroup> mDisallowInterceptGroup;
    private int mFactor;

    @Nullable
    private ImageButton mMinusButton;

    @Nullable
    private ImageButton mPlusButton;

    @Nullable
    private SeekBar mSeekBar;
    private boolean mUserEvent;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarButtonControl$ButtonType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "MINUS", "PLUS", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ButtonType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ButtonType[] $VALUES;
        public static final ButtonType UNKNOWN = new ButtonType("UNKNOWN", 0);
        public static final ButtonType MINUS = new ButtonType("MINUS", 1);
        public static final ButtonType PLUS = new ButtonType("PLUS", 2);

        private static final /* synthetic */ ButtonType[] $values() {
            return new ButtonType[]{UNKNOWN, MINUS, PLUS};
        }

        static {
            ButtonType[] buttonTypeArr$values = $values();
            $VALUES = buttonTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(buttonTypeArr$values);
        }

        private ButtonType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<ButtonType> getEntries() {
            return $ENTRIES;
        }

        public static ButtonType valueOf(String str) {
            return (ButtonType) Enum.valueOf(ButtonType.class, str);
        }

        public static ButtonType[] values() {
            return (ButtonType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarButtonControl$OnActionListener;", "", "onSizeButtonClicked", "", "type", "Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarButtonControl$ButtonType;", "onStartSizeButtonLongClick", "onStopSizeButtonLongClick", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnActionListener {
        void onSizeButtonClicked(@NotNull ButtonType type);

        void onStartSizeButtonLongClick(@NotNull ButtonType type);

        void onStopSizeButtonLongClick(@NotNull ButtonType type);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarButtonControl$RptUpdater;", "Ljava/lang/Runnable;", "<init>", "(Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarButtonControl;)V", "run", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class RptUpdater implements Runnable {
        public RptUpdater() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SeekBar seekBar = SpenSeekBarButtonControl.this.mSeekBar;
                if (seekBar != null) {
                    SpenSeekBarButtonControl spenSeekBarButtonControl = SpenSeekBarButtonControl.this;
                    if (spenSeekBarButtonControl.mAutoIncrement) {
                        seekBar.incrementProgressBy(spenSeekBarButtonControl.mFactor);
                        seekBar.postDelayed(spenSeekBarButtonControl.new RptUpdater(), 20L);
                    } else if (spenSeekBarButtonControl.mAutoDecrement) {
                        seekBar.incrementProgressBy(-spenSeekBarButtonControl.mFactor);
                        seekBar.postDelayed(spenSeekBarButtonControl.new RptUpdater(), 20L);
                    }
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.samsung.android.sdk.pen.setting.common.SpenSeekBarButtonControl$mButtonOnTouchListener$1] */
    public SpenSeekBarButtonControl(@NotNull Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.mFactor = 1;
        this.mButtonLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.setting.common.SpenSeekBarButtonControl$mButtonLongClickListener$1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                if (!this.this$0.isAutoChanged() && this.this$0.setAutoFlag(v, true)) {
                    v.setSelected(true);
                    SpenSeekBarButtonControl.OnActionListener onActionListener = this.this$0.mActionListener;
                    if (onActionListener != null) {
                        onActionListener.onStartSizeButtonLongClick(this.this$0.getButtonType(v));
                    }
                    SeekBar seekBar = this.this$0.mSeekBar;
                    if (seekBar != null) {
                        seekBar.post(this.this$0.new RptUpdater());
                    }
                }
                return true;
            }
        };
        this.mButtonOnTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.setting.common.SpenSeekBarButtonControl$mButtonOnTouchListener$1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if (v == null || event == null || !this.this$0.getAutoFlag(v)) {
                    return false;
                }
                this.this$0.requestDisallowTouch();
                int action = event.getAction();
                if (action == 1 || action == 3 || this.this$0.isOutOfBounds(v, event.getX(), event.getY())) {
                    this.this$0.stopAutoUpdate(v, true);
                }
                return false;
            }
        };
        this.mButtonClickListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.setting.common.SpenSeekBarButtonControl$mButtonClickListener$1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                SpenSeekBarButtonControl.ButtonType buttonType = this.this$0.getButtonType(v);
                if (buttonType == SpenSeekBarButtonControl.ButtonType.UNKNOWN) {
                    return;
                }
                this.this$0.setUserEvent(true);
                SeekBar seekBar = this.this$0.mSeekBar;
                if (seekBar != null) {
                    seekBar.incrementProgressBy(buttonType == SpenSeekBarButtonControl.ButtonType.PLUS ? this.this$0.mFactor : -this.this$0.mFactor);
                }
                SpenSeekBarButtonControl.OnActionListener onActionListener = this.this$0.mActionListener;
                if (onActionListener != null) {
                    onActionListener.onSizeButtonClicked(buttonType);
                }
            }
        };
        this.mButtonOnKeyListener = new ViewOnKeyListenerC7560e(this, 0);
        this.mUserEvent = false;
        this.mDisallowInterceptGroup = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getAutoFlag(View v) {
        return getButtonType(v) == ButtonType.PLUS ? this.mAutoIncrement : this.mAutoDecrement;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ButtonType getButtonType(View v) {
        if (v != null && v.getTag() != null) {
            Object tag = v.getTag();
            ButtonType buttonType = tag instanceof ButtonType ? (ButtonType) tag : null;
            if (buttonType != null) {
                return buttonType;
            }
        }
        return ButtonType.UNKNOWN;
    }

    private final CharSequence getHoverDescription(View v) {
        CharSequence contentDescription = v.getContentDescription();
        Intrinsics.checkNotNullExpressionValue(contentDescription, "getContentDescription(...)");
        return contentDescription;
    }

    private final void initButton(ImageButton button, int resId, ColorStateList stateList, int hoverStrId, ButtonType tagId) {
        if (button == null) {
            return;
        }
        button.setImageResource(resId);
        button.setImageTintList(stateList);
        String string = this.mContext.getResources().getString(hoverStrId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        setHoverDescription(button, string);
        button.setContentDescription(string);
        button.setTag(tagId);
    }

    private final void initButtonListener(ImageButton button) {
        if (button != null) {
            button.setOnClickListener(this.mButtonClickListener);
            button.setOnLongClickListener(this.mButtonLongClickListener);
            button.setOnTouchListener(this.mButtonOnTouchListener);
            button.setOnKeyListener(this.mButtonOnKeyListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isOutOfBounds(View view, float posX, float posY) {
        return !new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight()).contains(posX, posY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mButtonOnKeyListener$lambda$0(SpenSeekBarButtonControl spenSeekBarButtonControl, View view, int i, KeyEvent keyEvent) {
        if (i == 66 && keyEvent.getAction() == 1) {
            Intrinsics.checkNotNull(view);
            if (spenSeekBarButtonControl.getAutoFlag(view)) {
                spenSeekBarButtonControl.setAutoFlag(view, false);
                spenSeekBarButtonControl.updateAutoSeekBar(view);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestDisallowTouch() {
        if (this.mDisallowInterceptGroup.size() == 0) {
            return;
        }
        Iterator<ViewGroup> it = this.mDisallowInterceptGroup.iterator();
        while (it.hasNext()) {
            it.next().requestDisallowInterceptTouchEvent(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean setAutoFlag(View v, boolean flag) {
        ButtonType buttonType = getButtonType(v);
        if (buttonType == ButtonType.UNKNOWN) {
            return false;
        }
        if (buttonType == ButtonType.PLUS) {
            this.mAutoIncrement = flag;
            return true;
        }
        this.mAutoDecrement = flag;
        return true;
    }

    private final void setButtonState(boolean condition, boolean auto, ImageButton button) {
        boolean z = true;
        int i = 255;
        if (condition) {
            if (auto) {
                i = 102;
            } else {
                z = false;
            }
        }
        if (button != null) {
            button.setImageAlpha(i);
        }
        if (button != null) {
            button.setEnabled(z);
        }
    }

    private final void setHoverDescription(View view, CharSequence description) {
        view.setContentDescription(description);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopAutoUpdate(View view, boolean playSound) {
        setAutoFlag(view, false);
        updateAutoSeekBar(view);
        if (playSound) {
            view.playSoundEffect(0);
        }
        OnActionListener onActionListener = this.mActionListener;
        if (onActionListener != null) {
            onActionListener.onStopSizeButtonLongClick(getButtonType(view));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateAutoSeekBar(View autoButton) {
        boolean z = true;
        if (getButtonType(autoButton) == ButtonType.MINUS) {
            SeekBar seekBar = this.mSeekBar;
            if (seekBar == null || seekBar.getProgress() != 0) {
                z = false;
            }
        } else {
            SeekBar seekBar2 = this.mSeekBar;
            Integer numValueOf = seekBar2 != null ? Integer.valueOf(seekBar2.getProgress()) : null;
            SeekBar seekBar3 = this.mSeekBar;
            if (!Intrinsics.areEqual(numValueOf, seekBar3 != null ? Integer.valueOf(seekBar3.getMax()) : null)) {
            }
        }
        autoButton.setSelected(false);
        if (z) {
            CharSequence hoverDescription = getHoverDescription(autoButton);
            autoButton.setEnabled(false);
            setHoverDescription(autoButton, null);
            setHoverDescription(autoButton, hoverDescription);
        }
    }

    public final void addDisallowTouchInterceptGroup(@Nullable ViewGroup group) {
        if (group == null) {
            return;
        }
        this.mDisallowInterceptGroup.add(group);
    }

    public final void clearDisallowTouchInterceptGroup() {
        this.mDisallowInterceptGroup.clear();
    }

    public final void close() {
        this.mDisallowInterceptGroup.clear();
        this.mActionListener = null;
        this.mPlusButton = null;
        this.mMinusButton = null;
    }

    /* JADX INFO: renamed from: getUserEvent, reason: from getter */
    public final boolean getMUserEvent() {
        return this.mUserEvent;
    }

    public final void initControlButton(@Nullable SeekBar seekBar, @Nullable ImageButton minusButton, @Nullable ImageButton plusButton) {
        initControlButton(seekBar, minusButton, C7932R.string.pen_string_decrease, plusButton, C7932R.string.pen_string_increase);
    }

    public final boolean isAutoChanged() {
        return this.mAutoDecrement || this.mAutoIncrement;
    }

    public final boolean isUserEvent() {
        return this.mUserEvent;
    }

    public final void setActionListener(@Nullable OnActionListener listener) {
        this.mActionListener = listener;
    }

    public final void setFactorValue(int factorValue) {
        if (factorValue < 1) {
            return;
        }
        this.mFactor = factorValue;
    }

    public final void setUserEvent(boolean z) {
        this.mUserEvent = z;
    }

    public final void updateButtonState() {
        SeekBar seekBar = this.mSeekBar;
        if (seekBar != null) {
            setButtonState(seekBar.getProgress() == seekBar.getMax(), this.mAutoIncrement, this.mPlusButton);
            setButtonState(seekBar.getProgress() == 0, this.mAutoDecrement, this.mMinusButton);
        }
    }

    public final void initControlButton(@Nullable SeekBar seekBar, @Nullable ImageButton minusButton, int minusButtonStringId, @Nullable ImageButton plusButton, int plusButtonStringId) {
        this.mSeekBar = seekBar;
        ColorStateList colorStateList = ContextCompat.getColorStateList(this.mContext, C7932R.color.seek_bar_button_color);
        this.mMinusButton = minusButton;
        initButton(minusButton, C7932R.drawable.minus, colorStateList, minusButtonStringId, ButtonType.MINUS);
        ImageButton imageButton = this.mMinusButton;
        if (imageButton != null) {
            imageButton.setEnabled(false);
        }
        initButtonListener(this.mMinusButton);
        this.mPlusButton = plusButton;
        initButton(plusButton, C7932R.drawable.plus, colorStateList, plusButtonStringId, ButtonType.PLUS);
        initButtonListener(this.mPlusButton);
    }
}
