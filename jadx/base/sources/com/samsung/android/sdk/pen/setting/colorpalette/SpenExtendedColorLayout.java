package com.samsung.android.sdk.pen.setting.colorpalette;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilText;
import com.samsung.android.spen.C7932R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0011\b\u0007\u0018\u0000 12\u00020\u0001:\u00011B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0016\u0010\"\u001a\u00020\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0005H\u0016J\u0012\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010&\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010\u0019H\u0016J(\u0010'\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010)\u001a\u00020\u001fH\u0002J\b\u0010*\u001a\u00020\u001cH\u0002J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u001fH\u0002J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\bH\u0002J\u0010\u00100\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenExtendedColorLayout;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorBaseLayout;", "context", "Landroid/content/Context;", "recentList", "", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "isSupportEyedropper", "", "<init>", "(Landroid/content/Context;Ljava/util/List;Z)V", "mPaletteControl", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenExtendedPaletteControl;", "mEyedropperBtn", "Landroid/widget/ImageView;", "mSettingBtn", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenRectColorView;", "mPickerBtn", "mPaletteView", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewV3;", "mRecentView", "mIsSupportEyedropper", "mActionButtonListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnActionButtonListener;", "mColorChangedListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnColorChangedListener;", "mInnerColorChangedListener", "close", "", "setColor", "uiInfo", "", "color", "", "setPaletteList", "palettes", "setOnActionButtonListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnColorChangedListener", "construct", "recentColor", "layoutId", "initButton", "notifyButtonClick", "type", "initPalette", "updatePickerSelected", "selected", "decidePickerSelected", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
public final class SpenExtendedColorLayout extends SpenColorBaseLayout {

    @NotNull
    private static final String TAG = "SpenExtendedColorLayout";

    @Nullable
    private OnActionButtonListener mActionButtonListener;

    @Nullable
    private OnColorChangedListener mColorChangedListener;
    private ImageView mEyedropperBtn;

    @NotNull
    private final OnColorChangedListener mInnerColorChangedListener;
    private final boolean mIsSupportEyedropper;
    private SpenExtendedPaletteControl mPaletteControl;
    private SpenPaletteViewV3 mPaletteView;
    private SpenRectColorView mPickerBtn;
    private SpenPaletteViewV3 mRecentView;
    private SpenRectColorView mSettingBtn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenExtendedColorLayout(@NotNull Context context, @Nullable List<SpenHSVColor> list, boolean z) {
        super(context, false);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsSupportEyedropper = z;
        OnColorChangedListener onColorChangedListener = new OnColorChangedListener() { // from class: com.samsung.android.sdk.pen.setting.colorpalette.SpenExtendedColorLayout$mInnerColorChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.OnColorChangedListener
            public void onColorChanged(int info, float[] hsvColor, int opacity) {
                Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                AbstractC6670b.m4765z(new Object[]{Integer.valueOf(info), Float.valueOf(hsvColor[0]), Float.valueOf(hsvColor[1]), Float.valueOf(hsvColor[2])}, 4, "onColorChanged() info=%d, hsvColor[%f, %f, %f]", "format(format, *args)", "SpenExtendedColorLayout");
                OnColorChangedListener onColorChangedListener2 = this.this$0.mColorChangedListener;
                if (onColorChangedListener2 != null) {
                    onColorChangedListener2.onColorChanged(info, hsvColor, opacity);
                }
                this.this$0.updatePickerSelected(SpenPaletteDefine.getFromType(info) == 4);
            }
        };
        this.mInnerColorChangedListener = onColorChangedListener;
        construct(context, list, C7932R.layout.setting_pen_color_layout_v70);
        super.setOnColorChangedListener(onColorChangedListener);
    }

    private final void construct(Context context, List<SpenHSVColor> recentColor, int layoutId) {
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ((LayoutInflater) systemService).inflate(layoutId, (ViewGroup) this, true);
        initButton();
        initPalette(context);
        List<SpenHSVColor> list = recentColor;
        if (list == null || list.isEmpty()) {
            return;
        }
        setRecentColor(recentColor);
    }

    private final boolean decidePickerSelected(int uiInfo) {
        int fromType = SpenPaletteDefine.getFromType(uiInfo);
        if (fromType == 4) {
            return true;
        }
        if (fromType == 1) {
            return false;
        }
        return (fromType == 2 && containsPalette(SpenPaletteDefine.getPaletteID(uiInfo))) ? false : true;
    }

    private final void initButton() {
        SpenRectColorView spenRectColorView;
        SpenSettingUtilText.setTypeFace(getContext(), SpenSettingUtilText.FontName.REGULAR, (TextView) findViewById(C7932R.id.color_title));
        this.mPickerBtn = (SpenRectColorView) findViewById(C7932R.id.picker_icon);
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(C7932R.dimen.setting_color_rect_chip_unselected_margin_end);
        SpenRectColorView spenRectColorView2 = this.mPickerBtn;
        ImageView imageView = null;
        if (spenRectColorView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPickerBtn");
            spenRectColorView = null;
        } else {
            spenRectColorView = spenRectColorView2;
        }
        spenRectColorView.setColorRes(C7932R.drawable.color_rect_picker_icon);
        spenRectColorView.setSelectedMargin(0, 0, 0, 0);
        spenRectColorView.setUnselectedMargin(0, 0, 0, 0);
        float f = dimensionPixelOffset;
        spenRectColorView.setRadius(dimensionPixelOffset, f, f, f, f);
        final int i = 0;
        spenRectColorView.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.setting.colorpalette.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenExtendedColorLayout f5008b;

            {
                this.f5008b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case 0:
                        this.f5008b.notifyButtonClick(1);
                        break;
                    case 1:
                        this.f5008b.notifyButtonClick(3);
                        break;
                    default:
                        this.f5008b.notifyButtonClick(2);
                        break;
                }
            }
        });
        SpenRectColorView spenRectColorView3 = (SpenRectColorView) findViewById(C7932R.id.setting_icon);
        this.mSettingBtn = spenRectColorView3;
        if (spenRectColorView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSettingBtn");
            spenRectColorView3 = null;
        }
        spenRectColorView3.setColorRes(C7932R.drawable.color_rect_setting_icon_all_round);
        spenRectColorView3.setSelectedMargin(0, 0, 0, 0);
        spenRectColorView3.setUnselectedMargin(0, 0, 0, 0);
        spenRectColorView3.setRadius(f, f, f, f);
        final int i2 = 1;
        spenRectColorView3.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.setting.colorpalette.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenExtendedColorLayout f5008b;

            {
                this.f5008b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        this.f5008b.notifyButtonClick(1);
                        break;
                    case 1:
                        this.f5008b.notifyButtonClick(3);
                        break;
                    default:
                        this.f5008b.notifyButtonClick(2);
                        break;
                }
            }
        });
        int color = SpenSettingUtil.getColor(getContext(), C7932R.color.setting_content_text_color);
        ImageView imageView2 = (ImageView) findViewById(C7932R.id.eyedropper_icon);
        this.mEyedropperBtn = imageView2;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEyedropperBtn");
            imageView2 = null;
        }
        imageView2.setImageResource(C7932R.drawable.ic_spoid);
        ImageView imageView3 = this.mEyedropperBtn;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEyedropperBtn");
            imageView3 = null;
        }
        imageView3.setColorFilter(color);
        if (this.mIsSupportEyedropper) {
            ImageView imageView4 = this.mEyedropperBtn;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEyedropperBtn");
            } else {
                imageView = imageView4;
            }
            final int i4 = 2;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.setting.colorpalette.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SpenExtendedColorLayout f5008b;

                {
                    this.f5008b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i4) {
                        case 0:
                            this.f5008b.notifyButtonClick(1);
                            break;
                        case 1:
                            this.f5008b.notifyButtonClick(3);
                            break;
                        default:
                            this.f5008b.notifyButtonClick(2);
                            break;
                    }
                }
            });
        } else {
            ImageView imageView5 = this.mEyedropperBtn;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEyedropperBtn");
            } else {
                imageView = imageView5;
            }
            imageView.setVisibility(8);
        }
        ((ImageView) findViewById(C7932R.id.recent_icon)).setColorFilter(color);
    }

    private final void initPalette(Context context) {
        this.mPaletteView = (SpenPaletteViewV3) findViewById(C7932R.id.pen_palette_view);
        this.mRecentView = (SpenPaletteViewV3) findViewById(C7932R.id.pen_recent_view);
        SpenExtendedPaletteControl spenExtendedPaletteControl = new SpenExtendedPaletteControl(context, true, false, 7);
        this.mPaletteControl = spenExtendedPaletteControl;
        SpenPaletteViewV3 spenPaletteViewV3 = this.mPaletteView;
        SpenExtendedPaletteControl spenExtendedPaletteControl2 = null;
        if (spenPaletteViewV3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPaletteView");
            spenPaletteViewV3 = null;
        }
        SpenPaletteViewV3 spenPaletteViewV32 = this.mRecentView;
        if (spenPaletteViewV32 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecentView");
            spenPaletteViewV32 = null;
        }
        if (spenExtendedPaletteControl.setPaletteView(spenPaletteViewV3, spenPaletteViewV32)) {
            SpenExtendedPaletteControl spenExtendedPaletteControl3 = this.mPaletteControl;
            if (spenExtendedPaletteControl3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPaletteControl");
            } else {
                spenExtendedPaletteControl2 = spenExtendedPaletteControl3;
            }
            setPaletteControl(spenExtendedPaletteControl2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyButtonClick(int type) {
        OnActionButtonListener onActionButtonListener = this.mActionButtonListener;
        if (onActionButtonListener != null) {
            onActionButtonListener.onButtonClick(type);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePickerSelected(boolean selected) {
        SpenRectColorView spenRectColorView = this.mPickerBtn;
        SpenRectColorView spenRectColorView2 = null;
        if (spenRectColorView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPickerBtn");
            spenRectColorView = null;
        }
        AbstractC6670b.m4758s("updatePickerSelected() selected=", " -> ", TAG, spenRectColorView.isSelected(), selected);
        SpenRectColorView spenRectColorView3 = this.mPickerBtn;
        if (spenRectColorView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPickerBtn");
            spenRectColorView3 = null;
        }
        if (spenRectColorView3.isSelected() == selected) {
            return;
        }
        SpenRectColorView spenRectColorView4 = this.mPickerBtn;
        if (spenRectColorView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPickerBtn");
        } else {
            spenRectColorView2 = spenRectColorView4;
        }
        spenRectColorView2.setSelected(selected);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenColorBaseLayout
    public void close() {
        SpenPaletteViewV3 spenPaletteViewV3 = this.mPaletteView;
        SpenExtendedPaletteControl spenExtendedPaletteControl = null;
        if (spenPaletteViewV3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPaletteView");
            spenPaletteViewV3 = null;
        }
        spenPaletteViewV3.close();
        SpenPaletteViewV3 spenPaletteViewV32 = this.mRecentView;
        if (spenPaletteViewV32 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecentView");
            spenPaletteViewV32 = null;
        }
        spenPaletteViewV32.close();
        SpenExtendedPaletteControl spenExtendedPaletteControl2 = this.mPaletteControl;
        if (spenExtendedPaletteControl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPaletteControl");
        } else {
            spenExtendedPaletteControl = spenExtendedPaletteControl2;
        }
        spenExtendedPaletteControl.close();
        super.close();
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenColorBaseLayout, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting
    public void setColor(int uiInfo, @NotNull float[] color) {
        Intrinsics.checkNotNullParameter(color, "color");
        super.setColor(uiInfo, color);
        updatePickerSelected(decidePickerSelected(uiInfo));
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenColorBaseLayout, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting
    public void setOnActionButtonListener(@Nullable OnActionButtonListener listener) {
        this.mActionButtonListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenColorBaseLayout
    public void setOnColorChangedListener(@Nullable OnColorChangedListener listener) {
        this.mColorChangedListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenColorBaseLayout, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting
    public boolean setPaletteList(@NotNull List<Integer> palettes) {
        Intrinsics.checkNotNullParameter(palettes, "palettes");
        if (!super.setPaletteList(palettes)) {
            return false;
        }
        int uiInfo = getUiInfo();
        if (uiInfo == -1) {
            return true;
        }
        updatePickerSelected(decidePickerSelected(uiInfo));
        return true;
    }
}
