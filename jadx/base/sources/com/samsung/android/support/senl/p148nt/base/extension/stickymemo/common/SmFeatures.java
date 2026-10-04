package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common;

import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.java.marker.PerfConstants;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/common/SmFeatures;", "", "<init>", "()V", "DRAG_AND_DROP", "", AuthenticationConstants.IntuneContentProviderCall.APP_DATA_CLEAR_UNSUPPORTED, "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmFeatures {
    public static final boolean DRAG_AND_DROP = true;

    @NotNull
    public static final SmFeatures INSTANCE = new SmFeatures();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0006R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/common/SmFeatures$UNSUPPORTED;", "", "<init>", "()V", "HW_MENUS", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getHW_MENUS", "()Ljava/util/ArrayList;", "TEXT_MENUS", "getTEXT_MENUS", "PARAGRAPH_FILTER", "isPenSetting", "", "penSettingInfo", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "isSpenAction", "action", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class UNSUPPORTED {
        public static final int PARAGRAPH_FILTER = 4;

        @NotNull
        public static final UNSUPPORTED INSTANCE = new UNSUPPORTED();

        @NotNull
        private static final ArrayList<Integer> HW_MENUS = CollectionsKt.arrayListOf(32, 64, 128, 1024, 2048, 4096, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8192, 8388608);

        @NotNull
        private static final ArrayList<Integer> TEXT_MENUS = CollectionsKt.arrayListOf(262144, 524288, 2097152, 8192, 65536, 131072);

        private UNSUPPORTED() {
        }

        @NotNull
        public final ArrayList<Integer> getHW_MENUS() {
            return HW_MENUS;
        }

        @NotNull
        public final ArrayList<Integer> getTEXT_MENUS() {
            return TEXT_MENUS;
        }

        public final boolean isPenSetting(@NotNull SpenSettingUIPenInfo penSettingInfo) {
            Intrinsics.checkNotNullParameter(penSettingInfo, "penSettingInfo");
            return StringsKt.m14162r(penSettingInfo.name, PerfConstants.CodeMarkerParameters.MARKER) || StringsKt.m14162r(penSettingInfo.name, "Highlighter");
        }

        public final boolean isSpenAction(int action) {
            return 12 == action || 3 == action || 4 == action || 9 == action;
        }
    }

    private SmFeatures() {
    }
}
