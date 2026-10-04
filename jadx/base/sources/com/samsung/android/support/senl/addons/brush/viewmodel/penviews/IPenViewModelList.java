package com.samsung.android.support.senl.addons.brush.viewmodel.penviews;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/penviews/IPenViewModelList;", "", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IPenViewModelList {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/penviews/IPenViewModelList$Companion;", "", "<init>", "()V", "OBSV_VIEW_PEN_SELECTED_CHANGE", "", "getOBSV_VIEW_PEN_SELECTED_CHANGE", "()Ljava/lang/String;", "setOBSV_VIEW_PEN_SELECTED_CHANGE", "(Ljava/lang/String;)V", "OBSV_VIEW_PEN_CHANGE_OPACITY", "getOBSV_VIEW_PEN_CHANGE_OPACITY", "setOBSV_VIEW_PEN_CHANGE_OPACITY", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static String OBSV_VIEW_PEN_SELECTED_CHANGE = "pen_selected_change";

        @NotNull
        private static String OBSV_VIEW_PEN_CHANGE_OPACITY = "pen_change_opacity";

        private Companion() {
        }

        @NotNull
        public final String getOBSV_VIEW_PEN_CHANGE_OPACITY() {
            return OBSV_VIEW_PEN_CHANGE_OPACITY;
        }

        @NotNull
        public final String getOBSV_VIEW_PEN_SELECTED_CHANGE() {
            return OBSV_VIEW_PEN_SELECTED_CHANGE;
        }

        public final void setOBSV_VIEW_PEN_CHANGE_OPACITY(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            OBSV_VIEW_PEN_CHANGE_OPACITY = str;
        }

        public final void setOBSV_VIEW_PEN_SELECTED_CHANGE(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            OBSV_VIEW_PEN_SELECTED_CHANGE = str;
        }
    }
}
