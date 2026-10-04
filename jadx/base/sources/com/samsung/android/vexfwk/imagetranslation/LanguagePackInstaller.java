package com.samsung.android.vexfwk.imagetranslation;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nJ\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/vexfwk/imagetranslation/LanguagePackInstaller;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "goToLangPackDownload", "", "locales", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "requestLangPackDownload", "label", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class LanguagePackInstaller {

    @NotNull
    private static final String LANGUAGE_PACK_DOWNLOAD_ACTION = "com.samsung.android.settings.action.REQUEST_LANGUAGE_PACK_DOWNLOAD";

    @NotNull
    public static final String LANGUAGE_PACK_SETTINGS_ACTION = "com.samsung.android.settings.action.LANGUAGE_PACK_SETTINGS";

    @NotNull
    private final Context context;
    private static final String TAG = "LanguagePackInstaller";

    public LanguagePackInstaller(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final void goToLangPackDownload(@NotNull ArrayList<String> locales) {
        Intrinsics.checkNotNullParameter(locales, "locales");
        Context context = this.context;
        Intent intent = new Intent("com.samsung.android.settings.action.LANGUAGE_PACK_SETTINGS");
        intent.putExtra("package", this.context.getPackageName());
        intent.putStringArrayListExtra("locales", locales);
        context.startActivity(intent);
        Log.i(TAG, "requested goToLangPackDownload " + locales);
    }

    public final void requestLangPackDownload(@NotNull String locales, @NotNull String label) {
        Intrinsics.checkNotNullParameter(locales, "locales");
        Intrinsics.checkNotNullParameter(label, "label");
        Context context = this.context;
        Intent intent = new Intent(LANGUAGE_PACK_DOWNLOAD_ACTION);
        intent.putExtra("package", this.context.getPackageName());
        intent.putExtra("function", label);
        intent.putExtra("locale", locales);
        context.startActivity(intent);
        AbstractC6670b.m4756q("requested LanguagePackDownload ", locales, TAG);
    }
}
