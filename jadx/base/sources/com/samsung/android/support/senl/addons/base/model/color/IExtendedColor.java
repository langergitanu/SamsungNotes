package com.samsung.android.support.senl.addons.base.model.color;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0000H&J\b\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0000H&J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0000H&¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/color/IExtendedColor;", "Lcom/samsung/android/support/senl/addons/base/model/color/IBaseColorModel;", "setColor", "", "hsv", "", "color", "", "src", "getHSV", "isSame", "", "other", "isRgbSame", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IExtendedColor extends IBaseColorModel {
    @NotNull
    float[] getHSV();

    boolean isRgbSame(@NotNull IExtendedColor other);

    boolean isSame(@NotNull IExtendedColor other);

    void setColor(int color, @Nullable float[] hsv);

    void setColor(@NotNull IExtendedColor src);

    void setColor(@Nullable float[] hsv);
}
