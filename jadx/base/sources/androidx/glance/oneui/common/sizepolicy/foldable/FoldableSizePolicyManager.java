package androidx.glance.oneui.common.sizepolicy.foldable;

import android.content.Context;
import android.util.Size;
import android.util.SizeF;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.DeviceType;
import androidx.glance.oneui.common.DeviceTypeUtil;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JC\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010JD\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, m13886d2 = {"Landroidx/glance/oneui/common/sizepolicy/foldable/FoldableSizePolicyManager;", "", "()V", "convertDpToSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "context", "Landroid/content/Context;", "width", "", "height", "isEasyMode", "", "isFoldSync", "screenSize", "Landroid/util/Size;", "convertDpToSize-9ovGfe8", "(Landroid/content/Context;FFZZLandroid/util/Size;)I", "convertSizeToDp", "Lkotlin/Pair;", "Landroid/util/SizeF;", "size", "convertSizeToDp-hGL1VUE", "(Landroid/content/Context;IZZLandroid/util/Size;)Lkotlin/Pair;", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class FoldableSizePolicyManager {

    @NotNull
    public static final FoldableSizePolicyManager INSTANCE = new FoldableSizePolicyManager();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceType.values().length];
            try {
                iArr[DeviceType.FoldMain.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeviceType.FoldSub.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private FoldableSizePolicyManager() {
    }

    /* JADX INFO: renamed from: convertDpToSize-9ovGfe8, reason: not valid java name */
    public final int m21638convertDpToSize9ovGfe8(@NotNull Context context, float width, float height, boolean isEasyMode, boolean isFoldSync, @NotNull Size screenSize) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(screenSize, "screenSize");
        int i = WhenMappings.$EnumSwitchMapping$0[DeviceTypeUtil.INSTANCE.get(context).ordinal()];
        return i != 1 ? i != 2 ? AppWidgetSize.INSTANCE.m21572getUnknownrx25Pp4() : FoldCoverPolicy.INSTANCE.m21630convertDpToSizeh6tS73U(context, width, height, screenSize, isEasyMode) : isFoldSync ? FoldMainSyncPolicy.INSTANCE.m21636convertDpToSizeh6tS73U(context, width, height, screenSize, isEasyMode) : FoldMainPolicy.INSTANCE.m21633convertDpToSizeh6tS73U(context, width, height, screenSize, isEasyMode);
    }

    @NotNull
    /* JADX INFO: renamed from: convertSizeToDp-hGL1VUE, reason: not valid java name */
    public final Pair<SizeF, SizeF> m21639convertSizeToDphGL1VUE(@NotNull Context context, int size, boolean isEasyMode, boolean isFoldSync, @NotNull Size screenSize) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(screenSize, "screenSize");
        int i = WhenMappings.$EnumSwitchMapping$0[DeviceTypeUtil.INSTANCE.get(context).ordinal()];
        return i != 1 ? i != 2 ? new Pair<>(new SizeF(0.0f, 0.0f), new SizeF(0.0f, 0.0f)) : FoldCoverPolicy.INSTANCE.m21631convertSizeToDpqK15sPk(context, size, screenSize, isEasyMode) : isFoldSync ? FoldMainSyncPolicy.INSTANCE.m21637convertSizeToDpqK15sPk(context, size, screenSize, isEasyMode) : FoldMainPolicy.INSTANCE.m21634convertSizeToDpqK15sPk(context, size, screenSize, isEasyMode);
    }
}
