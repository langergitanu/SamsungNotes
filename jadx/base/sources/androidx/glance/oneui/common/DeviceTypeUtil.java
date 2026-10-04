package androidx.glance.oneui.common;

import android.content.Context;
import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Landroidx/glance/oneui/common/DeviceTypeUtil;", "", "type", "Landroidx/glance/oneui/common/DeviceType;", "(Landroidx/glance/oneui/common/DeviceType;)V", "Companion", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class DeviceTypeUtil {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static DeviceTypeUtil instance;

    @NotNull
    private final DeviceType type;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Landroidx/glance/oneui/common/DeviceTypeUtil$Companion;", "", "()V", "instance", "Landroidx/glance/oneui/common/DeviceTypeUtil;", "canBeChanged", "", "type", "Landroidx/glance/oneui/common/DeviceType;", "get", "context", "Landroid/content/Context;", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean canBeChanged(DeviceType type) {
            return type == DeviceType.FoldMain || type == DeviceType.FoldSub || type == DeviceType.MultiFoldMain || type == DeviceType.MultiFoldSub;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final DeviceType get(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (DeviceTypeUtil.instance == null) {
                DeviceTypeUtil.instance = new DeviceTypeUtil(DeviceConfigUtilsKt.getDisplayDeviceType(context));
            } else {
                DeviceTypeUtil deviceTypeUtil = DeviceTypeUtil.instance;
                if (canBeChanged(deviceTypeUtil != null ? deviceTypeUtil.type : null)) {
                }
            }
            DeviceTypeUtil deviceTypeUtil2 = DeviceTypeUtil.instance;
            Intrinsics.checkNotNull(deviceTypeUtil2);
            DeviceType deviceType = deviceTypeUtil2.type;
            GlanceLog.INSTANCE.m2297d("GWT:GlanceDeviceConfigUtils", "DeviceType is " + deviceType);
            return deviceType;
        }

        private Companion() {
        }
    }

    public DeviceTypeUtil(@NotNull DeviceType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
    }
}
