package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.executor.executors;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceManager;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.ConfigurationModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0017J\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/executor/executors/AODPinExecutor;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/executor/executors/AbsExecutor;", "<init>", "()V", "mIntentToAOD", "Landroid/content/Intent;", "execute", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "putExtraValues", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AODPinExecutor extends AbsExecutor {

    @NotNull
    private static final String TAG = SOLogger.createTag("AODPinExecutor");
    private Intent mIntentToAOD;

    private final void putExtraValues(Context context, Intent intent) {
        Intent intent2 = null;
        Boolean boolValueOf = intent != null ? Boolean.valueOf(intent.getBooleanExtra(Constants.IntentExtraName.IS_EDITED, false)) : null;
        String packageName = context != null ? context.getPackageName() : null;
        String strM756B = AbstractC0541b.m756B(packageName, ".screenoffmemo.ScreenOffMemoService");
        if (ConfigurationModel.INSTANCE.isUseScopedStorage()) {
            Uri uri = intent != null ? (Uri) intent.getParcelableExtra(Constants.IntentExtraName.PIN_URI) : null;
            if (uri != null) {
                String string = uri.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                if (string.length() != 0 && !Intrinsics.areEqual(Uri.EMPTY, uri)) {
                    SOLogger.INSTANCE.SOLoggerD(TAG, "putExtraValues# edited/uri " + boolValueOf + "/" + Logger.getEncode(uri.toString()));
                    Intent intent3 = this.mIntentToAOD;
                    if (intent3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mIntentToAOD");
                        intent3 = null;
                    }
                    intent3.putExtra("uri", uri.toString());
                    Intent intent4 = this.mIntentToAOD;
                    if (intent4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mIntentToAOD");
                        intent4 = null;
                    }
                    intent4.putExtra(Constants.IntentExtraName.AOD_CONTENT_VIEW_DATA, uri.toString());
                }
            }
            SOLogger.INSTANCE.SOLoggerD(TAG, "putExtraValues# invalid arguments");
            return;
        }
        String stringExtra = intent != null ? intent.getStringExtra(Constants.IntentExtraName.PIN_IMAGE_PATH) : null;
        if (stringExtra == null || stringExtra.length() == 0) {
            SOLogger.INSTANCE.SOLoggerD(TAG, "putExtraValues# invalid arguments");
            return;
        }
        SOLogger.INSTANCE.SOLoggerD(TAG, "putExtraValues# edited/imagePath " + boolValueOf + "/" + Logger.getEncode(stringExtra));
        Intent intent5 = this.mIntentToAOD;
        if (intent5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIntentToAOD");
            intent5 = null;
        }
        intent5.putExtra("uri", stringExtra);
        Intent intent6 = this.mIntentToAOD;
        if (intent6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIntentToAOD");
            intent6 = null;
        }
        intent6.putExtra(Constants.IntentExtraName.AOD_CONTENT_VIEW_DATA, stringExtra);
        Intent intent7 = this.mIntentToAOD;
        if (intent7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIntentToAOD");
            intent7 = null;
        }
        intent7.putExtra("target", "memo");
        Intent intent8 = this.mIntentToAOD;
        if (intent8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIntentToAOD");
            intent8 = null;
        }
        intent8.putExtra("type", 1);
        Intent intent9 = this.mIntentToAOD;
        if (intent9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIntentToAOD");
            intent9 = null;
        }
        intent9.putExtra(Constants.IntentExtraName.EDITED, boolValueOf);
        Intent intent10 = this.mIntentToAOD;
        if (intent10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIntentToAOD");
            intent10 = null;
        }
        intent10.putExtra("version", 3);
        Intent intent11 = this.mIntentToAOD;
        if (intent11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIntentToAOD");
            intent11 = null;
        }
        intent11.putExtra(Constants.IntentExtraName.AOD_CONTENT_VIEW_ACTION, "pin_com_load");
        Intent intent12 = this.mIntentToAOD;
        if (intent12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIntentToAOD");
            intent12 = null;
        }
        intent12.putExtra(Constants.IntentExtraName.AOD_CONTENT_VIEW_PACKAGE_NAME, packageName);
        Intent intent13 = this.mIntentToAOD;
        if (intent13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIntentToAOD");
        } else {
            intent2 = intent13;
        }
        intent2.putExtra(Constants.IntentExtraName.AOD_CONTENT_VIEW_ACTIVITY_NAME, strM756B);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.executor.executors.AbsExecutor
    @SuppressLint({WarningType.NewApi})
    public void execute(@Nullable Context context, @Nullable Intent intent) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "execute#");
        Intent intent2 = new Intent("com.samsung.android.app.aodservice.settings.AODPinnedPreviewService");
        this.mIntentToAOD = intent2;
        intent2.setClassName(Constants.ExternalPackageName.AOD_SERVICE, "com.samsung.android.app.aodservice.settings.AODPinnedPreviewService");
        putExtraValues(context, intent);
        ServiceManager companion = ServiceManager.INSTANCE.getInstance();
        Intent intent3 = this.mIntentToAOD;
        if (intent3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIntentToAOD");
            intent3 = null;
        }
        companion.startServiceAsUser(context, intent3);
    }
}
