package androidx.glance.oneui.common.sizepolicy.multifold;

import android.content.Context;
import android.util.Log;
import android.util.Size;
import android.util.SizeF;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.DeviceType;
import androidx.glance.oneui.common.DeviceTypeUtil;
import androidx.glance.oneui.common.GridSpanInfo;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JK\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012JL\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, m13886d2 = {"Landroidx/glance/oneui/common/sizepolicy/multifold/MultiFoldableSizePolicyManager;", "", "()V", "convertDpToSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "context", "Landroid/content/Context;", "width", "", "height", "isFoldSync", "", "isEasyMode", "gridSpanInfo", "Landroidx/glance/oneui/common/GridSpanInfo;", "screenSize", "Landroid/util/Size;", "convertDpToSize-TO2Bc4c", "(Landroid/content/Context;FFZZLandroidx/glance/oneui/common/GridSpanInfo;Landroid/util/Size;)I", "convertSizeToDp", "Lkotlin/Pair;", "Landroid/util/SizeF;", "size", "convertSizeToDp-pt7MXqQ", "(Landroid/content/Context;IZZLandroidx/glance/oneui/common/GridSpanInfo;Landroid/util/Size;)Lkotlin/Pair;", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class MultiFoldableSizePolicyManager {

    @NotNull
    public static final MultiFoldableSizePolicyManager INSTANCE = new MultiFoldableSizePolicyManager();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceType.values().length];
            try {
                iArr[DeviceType.MultiFoldMain.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeviceType.MultiFoldSub.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private MultiFoldableSizePolicyManager() {
    }

    /* JADX INFO: renamed from: convertDpToSize-TO2Bc4c, reason: not valid java name */
    public final int m21647convertDpToSizeTO2Bc4c(@NotNull Context context, float width, float height, boolean isFoldSync, boolean isEasyMode, @NotNull GridSpanInfo gridSpanInfo, @NotNull Size screenSize) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gridSpanInfo, "gridSpanInfo");
        Intrinsics.checkNotNullParameter(screenSize, "screenSize");
        DeviceType deviceType = DeviceTypeUtil.INSTANCE.get(context);
        Log.i("heec.choi", "convertDpToSize / " + deviceType + " " + isFoldSync + " " + gridSpanInfo + " " + screenSize + " " + width + " " + height);
        int i = WhenMappings.$EnumSwitchMapping$0[deviceType.ordinal()];
        return i != 1 ? i != 2 ? AppWidgetSize.INSTANCE.m21572getUnknownrx25Pp4() : MultiFoldCoverPolicy.INSTANCE.m21641convertDpToSizeh6tS73U(context, width, height, screenSize, isEasyMode) : isFoldSync ? MultiFoldMainSyncPolicy.INSTANCE.m21645convertDpToSizeh6tS73U(context, width, height, screenSize, gridSpanInfo) : MultiFoldMainPolicy.INSTANCE.m21643convertDpToSizeh6tS73U(context, width, height, screenSize, gridSpanInfo);
    }

    @NotNull
    /* JADX INFO: renamed from: convertSizeToDp-pt7MXqQ, reason: not valid java name */
    public final Pair<SizeF, SizeF> m21648convertSizeToDppt7MXqQ(@NotNull Context context, int size, boolean isEasyMode, boolean isFoldSync, @NotNull GridSpanInfo gridSpanInfo, @NotNull Size screenSize) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gridSpanInfo, "gridSpanInfo");
        Intrinsics.checkNotNullParameter(screenSize, "screenSize");
        int i = WhenMappings.$EnumSwitchMapping$0[DeviceTypeUtil.INSTANCE.get(context).ordinal()];
        return i != 1 ? i != 2 ? new Pair<>(new SizeF(0.0f, 0.0f), new SizeF(0.0f, 0.0f)) : MultiFoldCoverPolicy.INSTANCE.m21642convertSizeToDpqK15sPk(context, size, screenSize, isEasyMode) : isFoldSync ? MultiFoldMainSyncPolicy.INSTANCE.m21646convertSizeToDpqK15sPk(context, size, screenSize, gridSpanInfo) : MultiFoldMainPolicy.INSTANCE.m21644convertSizeToDpqK15sPk(context, size, screenSize, gridSpanInfo);
    }
}
