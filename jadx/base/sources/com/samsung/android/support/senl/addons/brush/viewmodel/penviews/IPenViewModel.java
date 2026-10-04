package com.samsung.android.support.senl.addons.brush.viewmodel.penviews;

import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\fH&J\b\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/penviews/IPenViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel;", "getColor", "", "setColor", "", "color", "getPenName", "", "getPenClass", "setSelected", "selected", "", "isSelected", "getSize", "setSize", "size", "hasAlpha", "getAlpha", "", "setAlpha", "alphaColor", "getAlphaColor", "getInfo", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IPenViewModel extends IBaseViewModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/penviews/IPenViewModel$Companion;", "", "<init>", "()V", "OBSV_VM_PEN_CHANGED", "", "getOBSV_VM_PEN_CHANGED", "()Ljava/lang/String;", "setOBSV_VM_PEN_CHANGED", "(Ljava/lang/String;)V", "OBSV_VM_PEN_RESELECTED", "getOBSV_VM_PEN_RESELECTED", "setOBSV_VM_PEN_RESELECTED", "OBSV_VM_PEN_DESTORYED", "getOBSV_VM_PEN_DESTORYED", "setOBSV_VM_PEN_DESTORYED", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static String OBSV_VM_PEN_CHANGED = "pen_changed";

        @NotNull
        private static String OBSV_VM_PEN_RESELECTED = "pen_reselected";

        @NotNull
        private static String OBSV_VM_PEN_DESTORYED = "pen_destroyed";

        private Companion() {
        }

        @NotNull
        public final String getOBSV_VM_PEN_CHANGED() {
            return OBSV_VM_PEN_CHANGED;
        }

        @NotNull
        public final String getOBSV_VM_PEN_DESTORYED() {
            return OBSV_VM_PEN_DESTORYED;
        }

        @NotNull
        public final String getOBSV_VM_PEN_RESELECTED() {
            return OBSV_VM_PEN_RESELECTED;
        }

        public final void setOBSV_VM_PEN_CHANGED(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            OBSV_VM_PEN_CHANGED = str;
        }

        public final void setOBSV_VM_PEN_DESTORYED(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            OBSV_VM_PEN_DESTORYED = str;
        }

        public final void setOBSV_VM_PEN_RESELECTED(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            OBSV_VM_PEN_RESELECTED = str;
        }
    }

    float getAlpha();

    int getAlphaColor();

    int getColor();

    @Nullable
    SpenSettingUIPenInfo getInfo();

    @Nullable
    String getPenClass();

    @Nullable
    String getPenName();

    int getSize();

    boolean hasAlpha();

    boolean isSelected();

    void setAlpha(int alphaColor);

    void setColor(int color);

    void setSelected(boolean selected);

    void setSize(int size);
}
