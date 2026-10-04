package androidx.glance.oneui.common.appwidgetsize;

import androidx.glance.oneui.common.AppWidgetHostType;
import androidx.glance.oneui.common.AppWidgetStyle;
import androidx.glance.oneui.common.DisplayDeviceType;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageConst;
import kotlin.Metadata;
import kotlin.Triple;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J(\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, m13886d2 = {"Landroidx/glance/oneui/common/appwidgetsize/HostKey;", "", "()V", "decodeHostKey", "Lkotlin/Triple;", "Landroidx/glance/oneui/common/AppWidgetHostType;", "Landroidx/glance/oneui/common/DisplayDeviceType;", "Landroidx/glance/oneui/common/AppWidgetStyle;", "hostKey", "", "getBitPosition", ImageConst.PARAM_MODE_WALLPAPER_MASK, "makeHostKey", "hostType", "displayDeviceType", "appWidgetStyle", "makeHostKey-C7y7hqc", "(III)I", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class HostKey {

    @NotNull
    public static final HostKey INSTANCE = new HostKey();

    private HostKey() {
    }

    private final int getBitPosition(int mask) {
        if (Integer.bitCount(mask) != 1) {
            return -1;
        }
        return Integer.numberOfTrailingZeros(mask);
    }

    @Nullable
    public final Triple<AppWidgetHostType, DisplayDeviceType, AppWidgetStyle> decodeHostKey(int hostKey) {
        int bitPosition = getBitPosition(hostKey);
        if (bitPosition < 0) {
            return null;
        }
        return new Triple<>(AppWidgetHostType.m21520boximpl(AppWidgetHostType.m21521constructorimpl(1 << (bitPosition >> 2))), DisplayDeviceType.m21590boximpl(DisplayDeviceType.m21591constructorimpl(1 << ((bitPosition >> 1) & 1))), AppWidgetStyle.m21574boximpl(AppWidgetStyle.m21575constructorimpl(1 << (bitPosition & 1))));
    }

    /* JADX INFO: renamed from: makeHostKey-C7y7hqc, reason: not valid java name */
    public final int m21620makeHostKeyC7y7hqc(int hostType, int displayDeviceType, int appWidgetStyle) {
        int bitPosition = getBitPosition(AppWidgetHostType.m21528toIntimpl(hostType));
        int bitPosition2 = getBitPosition(DisplayDeviceType.m21598toIntimpl(displayDeviceType));
        int bitPosition3 = getBitPosition(AppWidgetStyle.m21582toIntimpl(appWidgetStyle));
        if (bitPosition < 0 || bitPosition2 < 0 || bitPosition3 < 0) {
            return -1;
        }
        return 1 << (((bitPosition << 2) | (bitPosition2 << 1)) | bitPosition3);
    }
}
