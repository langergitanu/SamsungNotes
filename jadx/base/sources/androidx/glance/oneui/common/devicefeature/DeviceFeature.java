package androidx.glance.oneui.common.devicefeature;

import android.os.SemSystemProperties;
import com.samsung.android.feature.SemFloatingFeature;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0011\u0010\b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005¨\u0006\t"}, m13886d2 = {"Landroidx/glance/oneui/common/devicefeature/DeviceFeature;", "", "()V", "isFlipModel", "", "()Z", "isFoldModel", "isMultiFoldModel", "isTabletModel", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class DeviceFeature {

    @NotNull
    public static final DeviceFeature INSTANCE = new DeviceFeature();

    private DeviceFeature() {
    }

    public final boolean isFlipModel() {
        Object objM22215constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(Boolean.valueOf(SemFloatingFeature.getInstance().getBoolean("SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_FOLDABLE_TYPE_FLIP")));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
            objM22215constructorimpl = bool;
        }
        return ((Boolean) objM22215constructorimpl).booleanValue();
    }

    public final boolean isFoldModel() {
        Object objM22215constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(Boolean.valueOf(SemFloatingFeature.getInstance().getBoolean("SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_FOLDABLE_TYPE_FOLD")));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
            objM22215constructorimpl = bool;
        }
        return ((Boolean) objM22215constructorimpl).booleanValue();
    }

    public final boolean isMultiFoldModel() {
        Object objM22215constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(Boolean.valueOf(SemFloatingFeature.getInstance().getBoolean("SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_MULTI_FOLD")));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
            objM22215constructorimpl = bool;
        }
        return ((Boolean) objM22215constructorimpl).booleanValue();
    }

    public final boolean isTabletModel() {
        Object objM22215constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            String str = SemSystemProperties.get("ro.build.characteristics");
            Intrinsics.checkNotNullExpressionValue(str, "get(...)");
            objM22215constructorimpl = Result.m22215constructorimpl(Boolean.valueOf(StringsKt.m14162r(str, "tablet")));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
            objM22215constructorimpl = bool;
        }
        return ((Boolean) objM22215constructorimpl).booleanValue();
    }
}
