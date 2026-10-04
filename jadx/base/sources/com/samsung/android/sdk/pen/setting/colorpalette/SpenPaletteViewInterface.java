package com.samsung.android.sdk.pen.setting.colorpalette;

import android.graphics.drawable.Drawable;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0007H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH&J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H&J(\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&J(\u0010\u0017\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H&J0\u0010\u0017\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H&J4\u0010\u0017\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001a\u001a\u00020\u0007H&J(\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH&J,\u0010 \u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&J\u0018\u0010$\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H&J\u001a\u0010%\u001a\u0004\u0018\u00010#2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H&J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070'H&J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070'H&J\b\u0010)\u001a\u00020\u0007H&J\b\u0010*\u001a\u00020\u0007H\u0016J\b\u0010+\u001a\u00020\u0007H\u0016J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0007H\u0016¨\u0006."}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewInterface;", "", "setPaletteActionListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewActionListener;", "getPageCount", "", "setPaletteInfo", "totalPage", "getCurrentPage", "setPage", "pageIdx", "needAnimation", "", "setColor", "childAt", "colorInfo", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteColorInfo;", "color", "", "colorName", "", "setResource", "resId", "hoverStringId", "selectorId", "hoverDescription", "", "setSelected", "pageIndex", "selected", "setIndicator", "size", "background", "Landroid/graphics/drawable/Drawable;", "resetColor", "getSelectorDrawable", "getSwipeChildIndex", "", "getFixedChildIndex", "getVersion", "getPaletteOrientation", "getPaletteCornerRadius", "setPaletteCornerRadius", "radius", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenPaletteViewInterface {
    int getCurrentPage();

    @NotNull
    List<Integer> getFixedChildIndex();

    int getPageCount();

    int getPaletteCornerRadius();

    int getPaletteOrientation();

    @Nullable
    Drawable getSelectorDrawable(int pageIndex, int childAt);

    @NotNull
    List<Integer> getSwipeChildIndex();

    int getVersion();

    void resetColor(int pageIndex, int childAt);

    void setColor(int pageIdx, int childAt, @NotNull SpenPaletteColorInfo colorInfo);

    void setColor(int pageIdx, int childAt, @NotNull float[] color, @NotNull String colorName);

    void setIndicator(int pageIndex, int size, @Nullable Drawable background, @Nullable CharSequence hoverDescription);

    void setPage(int pageIdx, boolean needAnimation);

    void setPaletteActionListener(@Nullable SpenPaletteViewActionListener listener);

    void setPaletteCornerRadius(int radius);

    void setPaletteInfo(int totalPage);

    void setResource(int pageIdx, int childAt, int resId, int hoverStringId);

    void setResource(int pageIdx, int childAt, int resId, int hoverStringId, int selectorId);

    void setResource(int pageIdx, int childAt, int resId, @Nullable CharSequence hoverDescription, int selectorId);

    void setSelected(int pageIndex, int childAt, boolean selected, boolean needAnimation);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        public static int getPaletteCornerRadius(@NotNull SpenPaletteViewInterface spenPaletteViewInterface) {
            return 0;
        }

        public static int getPaletteOrientation(@NotNull SpenPaletteViewInterface spenPaletteViewInterface) {
            return 0;
        }

        public static /* synthetic */ void setResource$default(SpenPaletteViewInterface spenPaletteViewInterface, int i, int i2, int i4, CharSequence charSequence, int i5, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setResource");
            }
            if ((i6 & 16) != 0) {
                i5 = 0;
            }
            spenPaletteViewInterface.setResource(i, i2, i4, charSequence, i5);
        }

        public static void setPaletteCornerRadius(@NotNull SpenPaletteViewInterface spenPaletteViewInterface, int i) {
        }
    }
}
