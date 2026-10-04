package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.colorpalette;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0007J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0007J\"\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/colorpalette/PaletteDefine;", "", "<init>", "()V", "RECENT_PAGE_ID", "", "FROM_NONE", "FROM_RECENT", "FROM_PALETTE", "FROM_PICKER", "FROM_EYEDROPPER", "SHIFT_VALUE_PALETTE", "SHIFT_VALUE_MODE", "getColorUIInfo", "paletteID", "fromType", "getPaletteID", "uiInfo", "getFromType", "showUIInfo", "", "tag", "", "description", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PaletteDefine {
    public static final int FROM_EYEDROPPER = 8;
    public static final int FROM_NONE = 0;
    public static final int FROM_PALETTE = 2;
    public static final int FROM_PICKER = 4;
    public static final int FROM_RECENT = 1;

    @NotNull
    public static final PaletteDefine INSTANCE = new PaletteDefine();
    public static final int RECENT_PAGE_ID = 0;
    private static final int SHIFT_VALUE_MODE = 20;
    private static final int SHIFT_VALUE_PALETTE = 8;

    private PaletteDefine() {
    }

    @JvmStatic
    public static final int getColorUIInfo(int paletteID, int fromType) {
        return ((paletteID << 8) & 1048320) | ((fromType << 20) & (-1048576));
    }

    @JvmStatic
    public static final int getFromType(int uiInfo) {
        return (uiInfo >> 20) & 4095;
    }

    @JvmStatic
    public static final int getPaletteID(int uiInfo) {
        return (uiInfo >> 8) & 4095;
    }

    @JvmStatic
    public static final void showUIInfo(@Nullable String tag, @NotNull String description, int uiInfo) {
        Intrinsics.checkNotNullParameter(description, "description");
        int paletteID = getPaletteID(uiInfo);
        int fromType = getFromType(uiInfo);
        AbstractC8014b.m7214p(AbstractC0541b.m780v("### [", paletteID, description, "] PALETTEID=", " FROM="), fromType != 1 ? fromType != 2 ? fromType != 4 ? fromType != 8 ? "FROM_NONE" : "FROM_EYEDROPPER" : "FROM_PICKER" : "FROM_PALETTE" : "FROM_RECENT", " ###", tag);
    }
}
