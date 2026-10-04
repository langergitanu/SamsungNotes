package com.samsung.android.support.senl.addons.brush.model.color;

import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/color/IColorPaletteModel;", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel;", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IColorPaletteModel extends IBaseModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int INFO_MAX_SIZE = 4;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/color/IColorPaletteModel$Companion;", "", "<init>", "()V", "INFO_MAX_SIZE", "", "INFO_INDEX_ORDER_LIST", "", "getINFO_INDEX_ORDER_LIST", "()[I", "INFO_DEFAULT_LIST", "getINFO_DEFAULT_LIST", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public static final int INFO_MAX_SIZE = 4;
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final int[] INFO_INDEX_ORDER_LIST = {1, 2, 9, 7, 4, 21, 5, 3, 6, 8, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        @NotNull
        private static final int[] INFO_DEFAULT_LIST = {1, 2, 9, 7};

        private Companion() {
        }

        @NotNull
        public final int[] getINFO_DEFAULT_LIST() {
            return INFO_DEFAULT_LIST;
        }

        @NotNull
        public final int[] getINFO_INDEX_ORDER_LIST() {
            return INFO_INDEX_ORDER_LIST;
        }
    }
}
