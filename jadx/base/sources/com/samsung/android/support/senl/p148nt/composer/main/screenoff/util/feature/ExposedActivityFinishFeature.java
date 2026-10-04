package com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.feature;

import android.os.Build;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/feature/ExposedActivityFinishFeature;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "isActivityPostResumedSupported", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ExposedActivityFinishFeature {

    @NotNull
    public static final ExposedActivityFinishFeature INSTANCE = new ExposedActivityFinishFeature();

    @NotNull
    private static final String TAG = SOLogger.createTag("ExposedActivityFinishFeature");

    private ExposedActivityFinishFeature() {
    }

    public final boolean isActivityPostResumedSupported() {
        boolean z = Build.VERSION.SDK_INT >= 29;
        AbstractC8014b.m7211m("isActivityPostResumedSupported# ", z, SOLogger.INSTANCE, TAG);
        return z;
    }
}
