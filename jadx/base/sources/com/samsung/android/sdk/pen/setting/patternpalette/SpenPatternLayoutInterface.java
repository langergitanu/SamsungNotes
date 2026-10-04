package com.samsung.android.sdk.pen.setting.patternpalette;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001:\u0001\u0015J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J&\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nH&J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH&J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\bH&J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\bH&¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/patternpalette/SpenPatternLayoutInterface;", "", "close", "", "setOnPatternChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/patternpalette/SpenPatternLayoutInterface$OnPatternChangeListener;", "setPatternList", "", "patternRes", "", "", "sizeList", "", "setPattern", "patternResId", "", "needAnimation", "patternResName", "setPatternSize", "patternSize", "OnPatternChangeListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenPatternLayoutInterface {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/patternpalette/SpenPatternLayoutInterface$OnPatternChangeListener;", "", "onPatternChanged", "", "resName", "", "resId", "", "size", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnPatternChangeListener {
        void onPatternChanged(@Nullable String resName, int resId, float size);
    }

    void close();

    void setOnPatternChangedListener(@Nullable OnPatternChangeListener listener);

    boolean setPattern(int patternResId, boolean needAnimation);

    boolean setPattern(@NotNull String patternResName, boolean needAnimation);

    boolean setPatternList(@NotNull List<String> patternRes, @Nullable List<Float> sizeList);

    boolean setPatternSize(float patternSize, boolean needAnimation);
}
