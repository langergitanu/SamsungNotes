package com.samsung.android.vexfwk.sdk.common.runtime;

import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.vexfwk.VexFwkJniLoader;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataKey;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataNative;
import com.samsung.android.vexfwk.session.VexFwkUsecase;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkProvider;", "", "()V", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "VexFwkProvider";
    private static final boolean jniLoaded = VexFwkJniLoader.loadLibrary("sdk-v2-jni.vexfwk.samsung");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0011\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0083 R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkProvider$Companion;", "", "()V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "jniLoaded", "", "fetchProperties", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataNative;", "usecase", "Lcom/samsung/android/vexfwk/session/VexFwkUsecase;", "fetchPropertiesNative", "usecaseId", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkProvider.kt\ncom/samsung/android/vexfwk/sdk/common/runtime/VexFwkProvider$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,28:1\n1#2:29\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private final VexFwkMetadataNative fetchPropertiesNative(int usecaseId) {
            return VexFwkProvider.fetchPropertiesNative(usecaseId);
        }

        @JvmStatic
        @NotNull
        public final VexFwkMetadataNative fetchProperties(@NotNull VexFwkUsecase usecase) {
            Intrinsics.checkNotNullParameter(usecase, "usecase");
            if (VexFwkProvider.jniLoaded) {
                return fetchPropertiesNative(usecase.getId());
            }
            VexFwkMetadataNative vexFwkMetadataNative = new VexFwkMetadataNative();
            vexFwkMetadataNative.set(VexFwkMetadataKey.PROPERTY_IS_AVAILABLE.INSTANCE, Boolean.FALSE);
            return vexFwkMetadataNative;
        }

        private Companion() {
        }
    }

    @JvmStatic
    @NotNull
    public static final VexFwkMetadataNative fetchProperties(@NotNull VexFwkUsecase vexFwkUsecase) {
        return INSTANCE.fetchProperties(vexFwkUsecase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native VexFwkMetadataNative fetchPropertiesNative(int i);
}
