package androidx.glance.oneui.common.sizepolicy.multifold;

import androidx.glance.oneui.common.GridSpanInfo;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, m13886d2 = {"is6x10Grid", "", "Landroidx/glance/oneui/common/GridSpanInfo;", "glance-oneui-common_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class MultiFoldMainSyncPolicyKt {
    private static final boolean is6x10Grid(GridSpanInfo gridSpanInfo) {
        return gridSpanInfo.getW() == 6 && gridSpanInfo.getH() == 10;
    }
}
