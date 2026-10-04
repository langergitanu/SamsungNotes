package com.samsung.android.support.senl.p148nt.composer.main.screenoff.util;

import android.os.Build;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.DVFSHelperCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/DVFSHandler;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "VERSION_CODES_R", "", "requestDVFSBoost", "", "millisecond", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DVFSHandler {

    @NotNull
    public static final DVFSHandler INSTANCE = new DVFSHandler();

    @NotNull
    private static final String TAG = SOLogger.createTag("DVFSHandler");
    private static final int VERSION_CODES_R = 30;

    private DVFSHandler() {
    }

    public final void requestDVFSBoost(int millisecond) {
        AbstractC8014b.m7206h("requestDVFSBoost : ", millisecond, SOLogger.INSTANCE, TAG);
        if (Build.VERSION.SDK_INT > 30) {
            return;
        }
        new DVFSHelperCompat(BaseUtils.getApplicationContext()).doBoost(millisecond);
    }
}
