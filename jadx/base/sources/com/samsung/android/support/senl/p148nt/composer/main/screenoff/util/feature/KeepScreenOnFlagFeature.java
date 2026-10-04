package com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.feature;

import android.os.Build;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/feature/KeepScreenOnFlagFeature;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "needToAddKeepScreenOnFlag", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class KeepScreenOnFlagFeature {

    @NotNull
    public static final KeepScreenOnFlagFeature INSTANCE = new KeepScreenOnFlagFeature();

    @NotNull
    private static final String TAG = SOLogger.createTag("KeepScreenOnFlagFeature");

    private KeepScreenOnFlagFeature() {
    }

    public final boolean needToAddKeepScreenOnFlag() {
        int i = Build.VERSION.SDK_INT;
        boolean z = i < 29;
        SOLogger.INSTANCE.SOLoggerD(TAG, "needToAddKeepScreenOnFlag# SDK_INT/Q/result " + i + "/29/" + z);
        return z;
    }
}
