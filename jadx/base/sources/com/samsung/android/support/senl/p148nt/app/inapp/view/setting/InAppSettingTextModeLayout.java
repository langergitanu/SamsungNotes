package com.samsung.android.support.senl.p148nt.app.inapp.view.setting;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.inapp.presenter.item.InAppToolbarPresenter;
import com.samsung.android.support.senl.p148nt.app.inapp.view.setting.text.InAppPaletteCreator;
import com.samsung.android.support.senl.p148nt.app.inapp.view.setting.text.InAppTextBgColorPalette;
import com.samsung.android.support.senl.p148nt.app.inapp.view.setting.text.InAppTextColorPalette;
import com.samsung.android.support.senl.p148nt.app.inapp.view.winset.palette.RoundedPaletteContainerView;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.color.ColorPicker;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.color.ColorSetting;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0019\u0018\u0000 M2\u00020\u0001:\u0003KLMB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010-\u001a\u00020.2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010/\u001a\u00020.2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u00100\u001a\u00020.2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u00101\u001a\u00020.2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u00102\u001a\u00020.2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u001a\u00103\u001a\u00020.2\u0010\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010,\u0018\u000105H\u0002J\u0017\u00106\u001a\u00020.2\b\u00107\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0002\u00108J\u0006\u00109\u001a\u00020.J\u000e\u0010=\u001a\u00020.2\u0006\u0010>\u001a\u00020,J\b\u0010?\u001a\u00020.H\u0002J&\u0010@\u001a\u00020.2\f\u00104\u001a\b\u0012\u0004\u0012\u00020,052\u0006\u0010A\u001a\u00020,2\u0006\u0010B\u001a\u00020*H\u0016J \u0010C\u001a\u00020.2\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020,\u0018\u0001052\u0006\u0010B\u001a\u00020*H\u0002J\u0010\u0010D\u001a\u00020.2\u0006\u0010B\u001a\u00020*H\u0002J\u0010\u0010E\u001a\u00020.2\u0006\u0010F\u001a\u00020,H\u0016J\u0010\u0010G\u001a\u00020.2\u0006\u0010F\u001a\u00020,H\u0016J\u0010\u0010H\u001a\u00020.2\u0006\u0010F\u001a\u00020,H\u0016J\u0010\u0010I\u001a\u00020.2\u0006\u0010B\u001a\u00020*H\u0016J\u0016\u0010J\u001a\u00020.2\f\u00104\u001a\b\u0012\u0004\u0012\u00020,05H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\"\u001a\b\u0018\u00010#R\u00020\u0000X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\u00020,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006N"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingTextModeLayout;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/richtext/setting/RtSettingContract$ISettingView;", "mActivity", "Landroid/app/Activity;", "rootView", "Landroid/view/View;", "mPresenter", "Lcom/samsung/android/support/senl/nt/app/inapp/presenter/item/InAppToolbarPresenter;", "<init>", "(Landroid/app/Activity;Landroid/view/View;Lcom/samsung/android/support/senl/nt/app/inapp/presenter/item/InAppToolbarPresenter;)V", "mTextPalette", "Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/text/InAppTextColorPalette;", "getMTextPalette", "()Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/text/InAppTextColorPalette;", "setMTextPalette", "(Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/text/InAppTextColorPalette;)V", "mTextBgPalette", "Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/text/InAppTextBgColorPalette;", "getMTextBgPalette", "()Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/text/InAppTextBgColorPalette;", "setMTextBgPalette", "(Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/text/InAppTextBgColorPalette;)V", "mColorSetting", "Lcom/samsung/android/support/senl/nt/base/winset/app/picker/color/ColorSetting;", "getMColorSetting", "()Lcom/samsung/android/support/senl/nt/base/winset/app/picker/color/ColorSetting;", "setMColorSetting", "(Lcom/samsung/android/support/senl/nt/base/winset/app/picker/color/ColorSetting;)V", "mColorPicker", "Lcom/samsung/android/support/senl/nt/base/winset/app/picker/color/ColorPicker;", "getMColorPicker", "()Lcom/samsung/android/support/senl/nt/base/winset/app/picker/color/ColorPicker;", "setMColorPicker", "(Lcom/samsung/android/support/senl/nt/base/winset/app/picker/color/ColorPicker;)V", "mColorPickerListener", "Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingTextModeLayout$ColorPickerListener;", "getMColorPickerListener", "()Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingTextModeLayout$ColorPickerListener;", "setMColorPickerListener", "(Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingTextModeLayout$ColorPickerListener;)V", "mSettingLayout", "mIsDarkTheme", "", "mBackgroundColor", "", "initLayout", "", "initTextPalette", "initTextBgPalette", "initColorSetting", "initColorPicker", "showColorSettingPopup", "paletteList", "", "showColorPickerPopup", "currentColor", "(Ljava/lang/Integer;)V", "hidePopup", "spenColorTheme", "getSpenColorTheme", "()I", "setVisibility", "visibility", "startShowAnimation", "createPalette", "backgroundColor", "isDarkTheme", "createTextPalette", "createTextBgPalette", "updateBackgroundColor", "color", "updateFontColor", "updateFontBgColor", "updateViewTheme", "onPaletteListChanged", "ColorType", "ColorPickerListener", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nInAppSettingTextModeLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InAppSettingTextModeLayout.kt\ncom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingTextModeLayout\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,333:1\n1#2:334\n*E\n"})
public final class InAppSettingTextModeLayout implements RtSettingContract.ISettingView {

    @NotNull
    private static final String TAG = "InAppSettingTextModeLayout";

    @NotNull
    private final Activity mActivity;
    private int mBackgroundColor;

    @Nullable
    private ColorPicker mColorPicker;

    @Nullable
    private ColorPickerListener mColorPickerListener;

    @Nullable
    private ColorSetting mColorSetting;
    private boolean mIsDarkTheme;

    @NotNull
    private final InAppToolbarPresenter mPresenter;

    @NotNull
    private final View mSettingLayout;

    @Nullable
    private InAppTextBgColorPalette mTextBgPalette;

    @Nullable
    private InAppTextColorPalette mTextPalette;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingTextModeLayout$ColorPickerListener;", "Lcom/samsung/android/support/senl/nt/base/winset/app/picker/color/ColorPicker$Contract;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingTextModeLayout;)V", "mColorType", "Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingTextModeLayout$ColorType;", "setColorType", "", "colorType", "release", "onColorChangedByPicker", "color", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class ColorPickerListener implements ColorPicker.Contract {

        @Nullable
        private ColorType mColorType;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ColorType.values().length];
                try {
                    iArr[ColorType.TEXT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ColorType.TEXTBG.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public ColorPickerListener() {
        }

        @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorPicker.Contract
        public void onColorChangedByPicker(int color) {
            InAppLogger.m8598i(InAppSettingTextModeLayout.TAG, "onColorChangedByPicker# color : " + color + " / colorPickerType : " + this.mColorType);
            ColorType colorType = this.mColorType;
            int i = colorType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[colorType.ordinal()];
            if (i == 1) {
                InAppTextColorPalette mTextPalette = InAppSettingTextModeLayout.this.getMTextPalette();
                if (mTextPalette != null) {
                    mTextPalette.updateColor(color);
                }
                InAppSettingTextModeLayout.this.mPresenter.getRemoteRtSettingPresenter().setTextColor(color);
                return;
            }
            if (i != 2) {
                InAppLogger.m8596e(InAppSettingTextModeLayout.TAG, "onColorChangedByPicker# wrong color picker type");
                return;
            }
            InAppTextBgColorPalette mTextBgPalette = InAppSettingTextModeLayout.this.getMTextBgPalette();
            if (mTextBgPalette != null) {
                mTextBgPalette.updateColor(color);
            }
            InAppSettingTextModeLayout.this.mPresenter.getRemoteRtSettingPresenter().setTextBgColor(color);
        }

        @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorPicker.Contract
        public void release() {
        }

        public final void setColorType(@Nullable ColorType colorType) {
            this.mColorType = colorType;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingTextModeLayout$ColorType;", "", "<init>", "(Ljava/lang/String;I)V", "TEXT", "TEXTBG", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ColorType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ColorType[] $VALUES;
        public static final ColorType TEXT = new ColorType("TEXT", 0);
        public static final ColorType TEXTBG = new ColorType("TEXTBG", 1);

        private static final /* synthetic */ ColorType[] $values() {
            return new ColorType[]{TEXT, TEXTBG};
        }

        static {
            ColorType[] colorTypeArr$values = $values();
            $VALUES = colorTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(colorTypeArr$values);
        }

        private ColorType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<ColorType> getEntries() {
            return $ENTRIES;
        }

        public static ColorType valueOf(String str) {
            return (ColorType) Enum.valueOf(ColorType.class, str);
        }

        public static ColorType[] values() {
            return (ColorType[]) $VALUES.clone();
        }
    }

    public InAppSettingTextModeLayout(@NotNull Activity mActivity, @NotNull View rootView, @NotNull InAppToolbarPresenter mPresenter) {
        Intrinsics.checkNotNullParameter(mActivity, "mActivity");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(mPresenter, "mPresenter");
        this.mActivity = mActivity;
        this.mPresenter = mPresenter;
        View viewFindViewById = rootView.findViewById(C8003R.id.in_app_text_mode_settings_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.mSettingLayout = viewFindViewById;
        mPresenter.getRemoteRtSettingPresenter().setSettingView(this);
        initLayout(rootView);
    }

    private final void createTextBgPalette(boolean isDarkTheme) {
        InAppTextBgColorPalette inAppTextBgColorPalette = this.mTextBgPalette;
        Intrinsics.checkNotNull(inAppTextBgColorPalette);
        inAppTextBgColorPalette.create(this.mBackgroundColor, isDarkTheme);
        LinearLayout linearLayout = (LinearLayout) this.mSettingLayout.findViewById(C8003R.id.in_app_text_bg_color_palette_layout);
        linearLayout.removeAllViews();
        InAppTextBgColorPalette inAppTextBgColorPalette2 = this.mTextBgPalette;
        Intrinsics.checkNotNull(inAppTextBgColorPalette2);
        linearLayout.addView(inAppTextBgColorPalette2.getPaletteContainerViewList().get(0));
        InAppTextBgColorPalette inAppTextBgColorPalette3 = this.mTextBgPalette;
        Intrinsics.checkNotNull(inAppTextBgColorPalette3);
        if (inAppTextBgColorPalette3.getCurrentColor() != null) {
            InAppTextBgColorPalette inAppTextBgColorPalette4 = this.mTextBgPalette;
            Intrinsics.checkNotNull(inAppTextBgColorPalette4);
            Integer currentColor = inAppTextBgColorPalette4.getCurrentColor();
            Intrinsics.checkNotNull(currentColor);
            updateFontBgColor(currentColor.intValue());
        }
    }

    private final void createTextPalette(List<Integer> paletteList, boolean isDarkTheme) {
        InAppTextColorPalette inAppTextColorPalette = this.mTextPalette;
        if (inAppTextColorPalette != null) {
            inAppTextColorPalette.create(paletteList, isDarkTheme);
            LinearLayout linearLayout = (LinearLayout) this.mSettingLayout.findViewById(C8003R.id.in_app_text_color_palette_layout);
            linearLayout.removeAllViews();
            int dimensionPixelSize = this.mSettingLayout.getResources().getDimensionPixelSize(C8003R.dimen.in_app_text_mode_palette_margin_bottom);
            InAppTextColorPalette inAppTextColorPalette2 = this.mTextPalette;
            Intrinsics.checkNotNull(inAppTextColorPalette2);
            for (RoundedPaletteContainerView roundedPaletteContainerView : inAppTextColorPalette2.getPaletteContainerViewList()) {
                ViewGroup.LayoutParams layoutParams = roundedPaletteContainerView.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, 0, 0, dimensionPixelSize);
                roundedPaletteContainerView.setLayoutParams(layoutParams2);
                linearLayout.addView(roundedPaletteContainerView);
            }
            InAppTextColorPalette inAppTextColorPalette3 = this.mTextPalette;
            Intrinsics.checkNotNull(inAppTextColorPalette3);
            if (inAppTextColorPalette3.getCurrentColor() != null) {
                InAppTextColorPalette inAppTextColorPalette4 = this.mTextPalette;
                Intrinsics.checkNotNull(inAppTextColorPalette4);
                Integer currentColor = inAppTextColorPalette4.getCurrentColor();
                Intrinsics.checkNotNull(currentColor);
                updateFontColor(currentColor.intValue());
            }
        }
    }

    private final int getSpenColorTheme() {
        return this.mIsDarkTheme ? 1 : 0;
    }

    private final void initColorPicker(View rootView) {
        this.mColorPickerListener = new ColorPickerListener();
        this.mColorPicker = new ColorPicker(rootView.getContext(), this.mActivity.getWindow().getDecorView().findViewById(C8003R.id.floating_layout_container_for_sub), this.mColorPickerListener);
        rootView.findViewById(C8003R.id.in_app_text_mode_text_color_picker).setOnClickListener(new ViewOnClickListenerC8077a(this, 0));
        rootView.findViewById(C8003R.id.in_app_text_mode_text_bg_color_picker).setOnClickListener(new ViewOnClickListenerC8077a(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initColorPicker$lambda$3(InAppSettingTextModeLayout inAppSettingTextModeLayout, View view) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
        if (UserInputSkipper.isValidEvent(tag)) {
            UserInputSkipper.setHoldingEventTime(300L, tag);
            ColorPickerListener colorPickerListener = inAppSettingTextModeLayout.mColorPickerListener;
            if (colorPickerListener != null) {
                colorPickerListener.setColorType(ColorType.TEXT);
            }
            InAppTextColorPalette inAppTextColorPalette = inAppSettingTextModeLayout.mTextPalette;
            if (inAppTextColorPalette != null) {
                inAppSettingTextModeLayout.showColorPickerPopup(inAppTextColorPalette.getCurrentColor());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initColorPicker$lambda$5(InAppSettingTextModeLayout inAppSettingTextModeLayout, View view) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
        if (UserInputSkipper.isValidEvent(tag)) {
            UserInputSkipper.setHoldingEventTime(300L, tag);
            ColorPickerListener colorPickerListener = inAppSettingTextModeLayout.mColorPickerListener;
            if (colorPickerListener != null) {
                colorPickerListener.setColorType(ColorType.TEXTBG);
            }
            InAppTextBgColorPalette inAppTextBgColorPalette = inAppSettingTextModeLayout.mTextBgPalette;
            if (inAppTextBgColorPalette != null) {
                inAppSettingTextModeLayout.showColorPickerPopup(inAppTextBgColorPalette.getCurrentColor());
            }
        }
    }

    private final void initColorSetting(View rootView) {
        ColorSetting colorSetting = new ColorSetting(rootView.getContext());
        this.mColorSetting = colorSetting;
        colorSetting.setColorSettingViewListener(new ColorSetting.ColorSettingViewListener() { // from class: com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingTextModeLayout.initColorSetting.1
            @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorSetting.ColorSettingViewListener
            public void onCancel() {
            }

            @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorSetting.ColorSettingViewListener
            public void onChangeSelected(List<Integer> list) {
                Intrinsics.checkNotNullParameter(list, "list");
                InAppLogger.m8598i(InAppSettingTextModeLayout.TAG, "onChangeSelected# - text color set : " + list);
                InAppSettingTextModeLayout.this.mPresenter.getRemoteRtSettingPresenter().setPaletteList(list);
            }

            @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorSetting.ColorSettingViewListener
            public void onDone() {
            }

            @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorSetting.ColorSettingViewListener
            public void onSelectItemChanged(int i, boolean b) {
            }

            @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorSetting.ColorSettingViewListener
            public void onVisibilityChanged(int visibility) {
            }
        });
        rootView.findViewById(C8003R.id.in_app_text_mode_text_color_set_setting).setOnClickListener(new ViewOnClickListenerC8077a(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initColorSetting$lambda$1(InAppSettingTextModeLayout inAppSettingTextModeLayout, View view) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
        if (UserInputSkipper.isValidEvent(tag)) {
            UserInputSkipper.setHoldingEventTime(300L, tag);
            InAppTextColorPalette inAppTextColorPalette = inAppSettingTextModeLayout.mTextPalette;
            if (inAppTextColorPalette != null) {
                inAppSettingTextModeLayout.showColorSettingPopup(inAppTextColorPalette.getPaletteList());
            }
        }
    }

    private final void initLayout(View rootView) {
        ((FrameLayout) rootView.findViewById(C8003R.id.in_app_text_mode_text_color_picker)).getChildAt(0).setClipToOutline(true);
        ((FrameLayout) rootView.findViewById(C8003R.id.in_app_text_mode_text_bg_color_picker)).getChildAt(0).setClipToOutline(true);
        initTextPalette(rootView);
        initTextBgPalette(rootView);
        initColorSetting(rootView);
        initColorPicker(rootView);
    }

    private final void initTextBgPalette(View rootView) {
        Context context = rootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        View viewFindViewById = rootView.findViewById(C8003R.id.in_app_text_mode_text_bg_color_picker_selector);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        View viewFindViewById2 = rootView.findViewById(C8003R.id.richtext_textBgColor);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.mTextBgPalette = new InAppTextBgColorPalette(context, viewFindViewById, (ImageView) viewFindViewById2, new InAppPaletteCreator.OnItemActionListener() { // from class: com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingTextModeLayout.initTextBgPalette.1
            @Override // com.samsung.android.support.senl.nt.app.inapp.view.setting.text.InAppPaletteCreator.OnItemActionListener
            public void onPaletteClicked(int paletteId, int colorIndex) {
                InAppTextBgColorPalette mTextBgPalette = InAppSettingTextModeLayout.this.getMTextBgPalette();
                if (mTextBgPalette != null) {
                    InAppSettingTextModeLayout inAppSettingTextModeLayout = InAppSettingTextModeLayout.this;
                    mTextBgPalette.setSelectedColor(0, colorIndex);
                    SpenColorPaletteData spenColorPaletteData = mTextBgPalette.getColorPaletteData().get(0);
                    if (spenColorPaletteData.values.length > colorIndex) {
                        inAppSettingTextModeLayout.mPresenter.getRemoteRtSettingPresenter().setTextBgColor(spenColorPaletteData.values[colorIndex]);
                    }
                }
            }
        });
    }

    private final void initTextPalette(View rootView) {
        Context context = rootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        View viewFindViewById = rootView.findViewById(C8003R.id.in_app_text_mode_text_color_picker_selector);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        View viewFindViewById2 = rootView.findViewById(C8003R.id.richtext_textColor);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.mTextPalette = new InAppTextColorPalette(context, viewFindViewById, (ImageView) viewFindViewById2, new InAppPaletteCreator.OnItemActionListener() { // from class: com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingTextModeLayout.initTextPalette.1
            @Override // com.samsung.android.support.senl.nt.app.inapp.view.setting.text.InAppPaletteCreator.OnItemActionListener
            public void onPaletteClicked(int paletteId, int colorIndex) {
                InAppTextColorPalette mTextPalette = InAppSettingTextModeLayout.this.getMTextPalette();
                if (mTextPalette != null) {
                    InAppSettingTextModeLayout inAppSettingTextModeLayout = InAppSettingTextModeLayout.this;
                    mTextPalette.setSelectedColor(paletteId, colorIndex);
                    SpenColorPaletteData spenColorPaletteData = mTextPalette.getColorPaletteData().get(paletteId);
                    if (spenColorPaletteData.values.length > colorIndex) {
                        inAppSettingTextModeLayout.mPresenter.getRemoteRtSettingPresenter().setTextColor(spenColorPaletteData.values[colorIndex]);
                    }
                }
            }
        });
    }

    private final void showColorPickerPopup(Integer currentColor) {
        ColorPicker colorPicker;
        if (currentColor == null || (colorPicker = this.mColorPicker) == null) {
            return;
        }
        Intrinsics.checkNotNull(colorPicker);
        if (colorPicker.isShowingColorPicker()) {
            return;
        }
        ColorPicker colorPicker2 = this.mColorPicker;
        Intrinsics.checkNotNull(colorPicker2);
        colorPicker2.showColorPickerPopup(null, currentColor.intValue(), this.mBackgroundColor, getSpenColorTheme(), true);
    }

    private final void showColorSettingPopup(List<Integer> paletteList) {
        ColorSetting colorSetting;
        if (paletteList == null || (colorSetting = this.mColorSetting) == null) {
            return;
        }
        Intrinsics.checkNotNull(colorSetting);
        if (colorSetting.isShowingColorSetting()) {
            return;
        }
        ColorSetting colorSetting2 = this.mColorSetting;
        Intrinsics.checkNotNull(colorSetting2);
        colorSetting2.showColorSettingPopup(paletteList, getSpenColorTheme());
    }

    private final void startShowAnimation() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.95f, 1.0f);
        valueAnimatorOfFloat.setDuration(250L);
        final int i = 0;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.samsung.android.support.senl.nt.app.inapp.view.setting.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ InAppSettingTextModeLayout f6109b;

            {
                this.f6109b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i) {
                    case 0:
                        InAppSettingTextModeLayout.startShowAnimation$lambda$6(this.f6109b, valueAnimator);
                        break;
                    default:
                        InAppSettingTextModeLayout.startShowAnimation$lambda$7(this.f6109b, valueAnimator);
                        break;
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setDuration(150L);
        final int i2 = 1;
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.samsung.android.support.senl.nt.app.inapp.view.setting.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ InAppSettingTextModeLayout f6109b;

            {
                this.f6109b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i2) {
                    case 0:
                        InAppSettingTextModeLayout.startShowAnimation$lambda$6(this.f6109b, valueAnimator);
                        break;
                    default:
                        InAppSettingTextModeLayout.startShowAnimation$lambda$7(this.f6109b, valueAnimator);
                        break;
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startShowAnimation$lambda$6(InAppSettingTextModeLayout inAppSettingTextModeLayout, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Float")).floatValue();
        inAppSettingTextModeLayout.mSettingLayout.setScaleX(fFloatValue);
        inAppSettingTextModeLayout.mSettingLayout.setScaleY(fFloatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startShowAnimation$lambda$7(InAppSettingTextModeLayout inAppSettingTextModeLayout, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        View view = inAppSettingTextModeLayout.mSettingLayout;
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setAlpha(((Float) animatedValue).floatValue());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingContract.ISettingView
    public void createPalette(@NotNull List<Integer> paletteList, int backgroundColor, boolean isDarkTheme) {
        Intrinsics.checkNotNullParameter(paletteList, "paletteList");
        InAppLogger.m8598i(TAG, "createPalette# " + paletteList + " / backgroundColor= " + backgroundColor + " / isDarkTheme= " + isDarkTheme);
        this.mBackgroundColor = backgroundColor;
        this.mIsDarkTheme = isDarkTheme;
        createTextPalette(paletteList, isDarkTheme);
        createTextBgPalette(isDarkTheme);
    }

    @Nullable
    public final ColorPicker getMColorPicker() {
        return this.mColorPicker;
    }

    @Nullable
    public final ColorPickerListener getMColorPickerListener() {
        return this.mColorPickerListener;
    }

    @Nullable
    public final ColorSetting getMColorSetting() {
        return this.mColorSetting;
    }

    @Nullable
    public final InAppTextBgColorPalette getMTextBgPalette() {
        return this.mTextBgPalette;
    }

    @Nullable
    public final InAppTextColorPalette getMTextPalette() {
        return this.mTextPalette;
    }

    public final void hidePopup() {
        ColorSetting colorSetting = this.mColorSetting;
        if (colorSetting != null) {
            Intrinsics.checkNotNull(colorSetting);
            if (colorSetting.isShowingColorSetting()) {
                ColorSetting colorSetting2 = this.mColorSetting;
                Intrinsics.checkNotNull(colorSetting2);
                colorSetting2.dismissColorSetting();
            }
        }
        ColorPicker colorPicker = this.mColorPicker;
        if (colorPicker != null) {
            Intrinsics.checkNotNull(colorPicker);
            if (colorPicker.isShowingColorPicker()) {
                ColorPicker colorPicker2 = this.mColorPicker;
                Intrinsics.checkNotNull(colorPicker2);
                colorPicker2.dismissColorPicker();
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingContract.ISettingView
    public void onPaletteListChanged(@NotNull List<Integer> paletteList) {
        Intrinsics.checkNotNullParameter(paletteList, "paletteList");
        InAppLogger.m8598i(TAG, "onPaletteListChanged " + paletteList);
        createTextPalette(paletteList, this.mIsDarkTheme);
    }

    public final void setMColorPicker(@Nullable ColorPicker colorPicker) {
        this.mColorPicker = colorPicker;
    }

    public final void setMColorPickerListener(@Nullable ColorPickerListener colorPickerListener) {
        this.mColorPickerListener = colorPickerListener;
    }

    public final void setMColorSetting(@Nullable ColorSetting colorSetting) {
        this.mColorSetting = colorSetting;
    }

    public final void setMTextBgPalette(@Nullable InAppTextBgColorPalette inAppTextBgColorPalette) {
        this.mTextBgPalette = inAppTextBgColorPalette;
    }

    public final void setMTextPalette(@Nullable InAppTextColorPalette inAppTextColorPalette) {
        this.mTextPalette = inAppTextColorPalette;
    }

    public final void setVisibility(int visibility) {
        if (this.mSettingLayout.getVisibility() == visibility) {
            return;
        }
        this.mSettingLayout.setVisibility(visibility);
        if (visibility == 0) {
            startShowAnimation();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingContract.ISettingView
    public void updateBackgroundColor(int color) {
        this.mBackgroundColor = color;
        InAppTextBgColorPalette inAppTextBgColorPalette = this.mTextBgPalette;
        if (inAppTextBgColorPalette != null) {
            inAppTextBgColorPalette.updatePageBgColor(color, this.mIsDarkTheme);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingContract.ISettingView
    public void updateFontBgColor(int color) {
        InAppTextBgColorPalette inAppTextBgColorPalette = this.mTextBgPalette;
        if (inAppTextBgColorPalette != null) {
            inAppTextBgColorPalette.updateColor(color);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingContract.ISettingView
    public void updateFontColor(int color) {
        InAppTextColorPalette inAppTextColorPalette = this.mTextPalette;
        if (inAppTextColorPalette != null) {
            inAppTextColorPalette.updateColor(color);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtSettingContract.ISettingView
    public void updateViewTheme(boolean isDarkTheme) {
        if (this.mIsDarkTheme != isDarkTheme) {
            InAppLogger.m8598i(TAG, "updateViewTheme# theme is updated. isDarkTheme : " + isDarkTheme);
            InAppTextColorPalette inAppTextColorPalette = this.mTextPalette;
            createTextPalette(inAppTextColorPalette != null ? inAppTextColorPalette.getPaletteList() : null, isDarkTheme);
            createTextBgPalette(isDarkTheme);
        }
        this.mIsDarkTheme = isDarkTheme;
    }
}
