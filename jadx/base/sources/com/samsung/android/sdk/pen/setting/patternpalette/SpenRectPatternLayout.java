package com.samsung.android.sdk.pen.setting.patternpalette;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewV4;
import com.samsung.android.sdk.pen.setting.patternpalette.SpenPatternLayoutInterface;
import com.samsung.android.sdk.pen.setting.patternpalette.SpenPatternViewControl;
import com.samsung.android.spen.C7932R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0002()B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J&\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0013H\u0016J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\u0012\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u000e\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\bJ\u000e\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u0011J\u0018\u0010%\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0014H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/patternpalette/SpenRectPatternLayout;", "Landroid/widget/FrameLayout;", "Lcom/samsung/android/sdk/pen/setting/patternpalette/SpenPatternLayoutInterface;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "layoutId", "", "(Landroid/content/Context;I)V", "mViewControl", "Lcom/samsung/android/sdk/pen/setting/patternpalette/SpenPatternViewControl;", "mPaletteView", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewV4;", "close", "", "setPatternList", "", "patternResName", "", "", "patternSize", "", "setPattern", "needAnimation", "patternResId", "setPatternSize", "pattern", "getPattern", "()I", "setOnPatternChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/patternpalette/SpenPatternLayoutInterface$OnPatternChangeListener;", "setSelectorDegree", "degree", "setFlipperEnabled", "enabled", "construct", "getDrawableId", "drawable", "Companion", "OnPatternChangeListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenRectPatternLayout extends FrameLayout implements SpenPatternLayoutInterface {

    @NotNull
    private static final String TAG = "SpenRectPatternLayout";
    private SpenPaletteViewV4 mPaletteView;
    private SpenPatternViewControl mViewControl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/patternpalette/SpenRectPatternLayout$OnPatternChangeListener;", "Lcom/samsung/android/sdk/pen/setting/patternpalette/SpenPatternViewControl$OnPatternChangeListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnPatternChangeListener extends SpenPatternViewControl.OnPatternChangeListener {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenRectPatternLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        construct(context, C7932R.layout.setting_pen_color_layout_oneui70_v15);
    }

    private final void construct(Context context, int layoutId) {
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ((LayoutInflater) systemService).inflate(layoutId, (ViewGroup) this, true);
        SpenPaletteViewInterface spenPaletteViewInterface = (SpenPaletteViewInterface) findViewById(C7932R.id.pen_palette_view);
        if (spenPaletteViewInterface instanceof SpenPaletteViewV4) {
            this.mPaletteView = (SpenPaletteViewV4) spenPaletteViewInterface;
        }
        this.mViewControl = new SpenPatternViewControl(context, spenPaletteViewInterface);
    }

    private final int getDrawableId(String drawable) {
        int identifier = getContext().getResources().getIdentifier(drawable, "drawable", getContext().getPackageName());
        if (identifier == 0) {
            Log.e(TAG, "Resource is not founded");
        }
        return identifier;
    }

    @Override // com.samsung.android.sdk.pen.setting.patternpalette.SpenPatternLayoutInterface
    public void close() {
        SpenPaletteViewV4 spenPaletteViewV4 = this.mPaletteView;
        SpenPatternViewControl spenPatternViewControl = null;
        if (spenPaletteViewV4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPaletteView");
            spenPaletteViewV4 = null;
        }
        spenPaletteViewV4.close();
        SpenPatternViewControl spenPatternViewControl2 = this.mViewControl;
        if (spenPatternViewControl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewControl");
        } else {
            spenPatternViewControl = spenPatternViewControl2;
        }
        spenPatternViewControl.close();
    }

    public final int getPattern() {
        SpenPatternViewControl spenPatternViewControl = this.mViewControl;
        if (spenPatternViewControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewControl");
            spenPatternViewControl = null;
        }
        return spenPatternViewControl.getMSelectedResId();
    }

    public final void setFlipperEnabled(boolean enabled) {
        SpenPaletteViewV4 spenPaletteViewV4 = this.mPaletteView;
        if (spenPaletteViewV4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPaletteView");
            spenPaletteViewV4 = null;
        }
        spenPaletteViewV4.setFlipperEnabled(enabled);
    }

    @Override // com.samsung.android.sdk.pen.setting.patternpalette.SpenPatternLayoutInterface
    public void setOnPatternChangedListener(@Nullable SpenPatternLayoutInterface.OnPatternChangeListener listener) {
        SpenPatternViewControl spenPatternViewControl = this.mViewControl;
        if (spenPatternViewControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewControl");
            spenPatternViewControl = null;
        }
        spenPatternViewControl.setOnPatternChangedListener(listener);
    }

    @Override // com.samsung.android.sdk.pen.setting.patternpalette.SpenPatternLayoutInterface
    public boolean setPattern(@NotNull String patternResName, boolean needAnimation) {
        Intrinsics.checkNotNullParameter(patternResName, "patternResName");
        Log.d(TAG, "setPattern() resName=" + patternResName);
        return setPattern(getDrawableId(patternResName), needAnimation);
    }

    @Override // com.samsung.android.sdk.pen.setting.patternpalette.SpenPatternLayoutInterface
    public boolean setPatternList(@NotNull List<String> patternResName, @Nullable List<Float> patternSize) {
        Intrinsics.checkNotNullParameter(patternResName, "patternResName");
        SpenPatternViewControl spenPatternViewControl = this.mViewControl;
        if (spenPatternViewControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewControl");
            spenPatternViewControl = null;
        }
        return spenPatternViewControl.setPatternList(patternResName, patternSize);
    }

    @Override // com.samsung.android.sdk.pen.setting.patternpalette.SpenPatternLayoutInterface
    public boolean setPatternSize(float patternSize, boolean needAnimation) {
        SpenPatternViewControl spenPatternViewControl = this.mViewControl;
        if (spenPatternViewControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewControl");
            spenPatternViewControl = null;
        }
        return spenPatternViewControl.setPatternSize(patternSize, needAnimation);
    }

    public final boolean setSelectorDegree(int degree) {
        SpenPaletteViewV4 spenPaletteViewV4 = this.mPaletteView;
        if (spenPaletteViewV4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPaletteView");
            spenPaletteViewV4 = null;
        }
        return spenPaletteViewV4.setSelectorDegree(degree);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenRectPatternLayout(@NotNull Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        construct(context, i);
    }

    @Override // com.samsung.android.sdk.pen.setting.patternpalette.SpenPatternLayoutInterface
    public boolean setPattern(int patternResId, boolean needAnimation) {
        SpenPatternViewControl spenPatternViewControl = this.mViewControl;
        if (spenPatternViewControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewControl");
            spenPatternViewControl = null;
        }
        return spenPatternViewControl.setPattern(patternResId, needAnimation);
    }
}
