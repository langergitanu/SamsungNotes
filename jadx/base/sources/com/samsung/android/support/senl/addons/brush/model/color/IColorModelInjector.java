package com.samsung.android.support.senl.addons.brush.model.color;

import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ\u0012\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H&J\u001a\u0010\u0005\u001a\u00020\u00062\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H&J\"\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH&¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/color/IColorModelInjector;", "", "getPaletteDatum", "", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorPaletteData;", "getColorTables", "", "tables", "getColorName", "", "color", "", "page", "index", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IColorModelInjector {
    public static final int COLOR_SET_TABLE_LIST_NUM_IN_PALETTE = 23;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int SELECTABLE_COLOR_SET_MAX = 4;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/color/IColorModelInjector$Companion;", "", "<init>", "()V", "COLOR_SET_TABLE_LIST_NUM_IN_PALETTE", "", "SELECTABLE_COLOR_SET_MAX", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int COLOR_SET_TABLE_LIST_NUM_IN_PALETTE = 23;
        public static final int SELECTABLE_COLOR_SET_MAX = 4;

        private Companion() {
        }
    }

    @Nullable
    String getColorName(int color, int page, int index);

    void getColorTables(@Nullable List<SpenColorPaletteData> tables);

    @Nullable
    List<SpenColorPaletteData> getPaletteDatum();
}
