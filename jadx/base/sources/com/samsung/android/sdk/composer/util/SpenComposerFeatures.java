package com.samsung.android.sdk.composer.util;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0004\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/util/SpenComposerFeatures;", "", "<init>", "()V", "isSupportSmartScript", "", "isSupportSmartScript$annotations", "()Z", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenComposerFeatures {

    @NotNull
    public static final SpenComposerFeatures INSTANCE = new SpenComposerFeatures();
    private static final boolean isSupportSmartScript = false;

    private SpenComposerFeatures() {
    }

    public static final boolean isSupportSmartScript() {
        return isSupportSmartScript;
    }

    @JvmStatic
    public static /* synthetic */ void isSupportSmartScript$annotations() {
    }
}
