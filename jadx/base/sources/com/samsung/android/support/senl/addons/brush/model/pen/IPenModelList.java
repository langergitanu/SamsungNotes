package com.samsung.android.support.senl.addons.brush.model.pen;

import com.microsoft.identity.common.java.marker.PerfConstants;
import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import com.samsung.android.support.senl.addons.base.model.pen.IBasePenModelList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00032\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/pen/IPenModelList;", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel;", "Lcom/samsung/android/support/senl/addons/base/model/pen/IBasePenModelList;", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IPenModelList extends IBaseModel, IBasePenModelList {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/pen/IPenModelList$Companion;", "", "<init>", "()V", "PEN_COUNT", "", "getPEN_COUNT", "()I", "setPEN_COUNT", "(I)V", "PEN_NAMES", "", "", "getPEN_NAMES", "()[Ljava/lang/String;", "setPEN_NAMES", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "ERASER_NAME", "getERASER_NAME", "()Ljava/lang/String;", "setERASER_NAME", "(Ljava/lang/String;)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static int PEN_COUNT = 9;

        @NotNull
        private static String[] PEN_NAMES = {"WaterColorBrush", "OilBrush", "BrushPen", "Pencil", "ColoredPencil", "Smudge", "AirBrushPen", PerfConstants.CodeMarkerParameters.MARKER, "Crayon"};

        @NotNull
        private static String ERASER_NAME = "Eraser";

        private Companion() {
        }

        @NotNull
        public final String getERASER_NAME() {
            return ERASER_NAME;
        }

        public final int getPEN_COUNT() {
            return PEN_COUNT;
        }

        @NotNull
        public final String[] getPEN_NAMES() {
            return PEN_NAMES;
        }

        public final void setERASER_NAME(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            ERASER_NAME = str;
        }

        public final void setPEN_COUNT(int i) {
            PEN_COUNT = i;
        }

        public final void setPEN_NAMES(@NotNull String[] strArr) {
            Intrinsics.checkNotNullParameter(strArr, "<set-?>");
            PEN_NAMES = strArr;
        }
    }
}
