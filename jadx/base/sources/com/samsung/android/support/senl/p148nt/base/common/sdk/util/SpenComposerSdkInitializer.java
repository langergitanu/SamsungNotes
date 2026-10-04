package com.samsung.android.support.senl.p148nt.base.common.sdk.util;

import android.content.Context;
import android.os.Build;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.sdk.composer.SpenComposerSdk;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.p196io.CloseableKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sdk/util/SpenComposerSdkInitializer;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mIsInitialized", "", "initialize", "context", "Landroid/content/Context;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpenComposerSdkInitializer {

    @NotNull
    public static final SpenComposerSdkInitializer INSTANCE = new SpenComposerSdkInitializer();

    @NotNull
    private static final String TAG = "SpenComposerSdkInitializer";
    private static boolean mIsInitialized;

    private SpenComposerSdkInitializer() {
    }

    @JvmStatic
    public static final synchronized boolean initialize(@Nullable Context context) {
        if (context == null) {
            return false;
        }
        if (mIsInitialized) {
            return true;
        }
        try {
            SpenComposerSdk spenComposerSdk = SpenComposerSdk.INSTANCE;
            spenComposerSdk.initialize(context);
            mIsInitialized = true;
            if (Build.VERSION.SDK_INT > 33) {
                try {
                    InputStream inputStreamOpen = context.getResources().getAssets().open("font/SamsungKorean-Regular.ttf");
                    try {
                        spenComposerSdk.setCustomFallbackFont(LangPackConfigConstants.LANGUAGE_CODE_KO, inputStreamOpen.readAllBytes());
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(inputStreamOpen, null);
                    } finally {
                    }
                } catch (IOException e) {
                    LoggerBase.INSTANCE.m7134e(TAG, "setCustomFallbackFont IOException : ", e);
                }
            }
            LoggerBase.INSTANCE.m7137i(TAG, "initialize success ");
            return true;
        } catch (Exception e2) {
            Logger.m8699e(TAG, "Initialize# ", e2);
            return false;
        }
    }
}
