package com.samsung.android.lib.galaxyfinder.search.api.payload;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.lib.galaxyfinder.search.util.SearchIntentUtils;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B3\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/lib/galaxyfinder/search/api/payload/IntentResultItemPayload;", "Lcom/samsung/android/lib/galaxyfinder/search/api/payload/ResultItemPayload;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "action", "", "packageName", SearchIndexablesContract.BaseColumns.COLUMN_CLASS_NAME, "dataUri", "flags", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", SearchIndexablesContract.BaseColumns.COLUMN_INTENT_ACTION, "intentClass", "intentDataUri", "intentFlags", "intentPackage", "intentString", "stringFromPayload", "getStringFromPayload", "()Ljava/lang/String;", "DeviceSearchLibrary_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class IntentResultItemPayload implements ResultItemPayload {

    @Nullable
    private final Intent intent;

    @Nullable
    private final String intentAction;

    @Nullable
    private final String intentClass;

    @Nullable
    private final String intentDataUri;
    private final int intentFlags;

    @Nullable
    private final String intentPackage;

    @Nullable
    private final String intentString;

    public IntentResultItemPayload(@Nullable Intent intent) {
        this.intent = intent;
        this.intentAction = null;
        this.intentPackage = null;
        this.intentClass = null;
        this.intentDataUri = null;
        this.intentFlags = 0;
        this.intentString = intent != null ? SearchIntentUtils.INSTANCE.getStringFromIntent(intent) : null;
    }

    @Override // com.samsung.android.lib.galaxyfinder.search.api.payload.ResultItemPayload
    @NotNull
    public String getStringFromPayload() {
        return AbstractC0541b.m772n("intent://", this.intentString);
    }

    public IntentResultItemPayload(@Nullable String str, @NotNull String packageName, @NotNull String className, @Nullable String str2, int i) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(className, "className");
        this.intentAction = str;
        this.intentPackage = packageName;
        this.intentClass = className;
        this.intentDataUri = str2;
        this.intentFlags = i;
        this.intent = null;
        SearchIntentUtils searchIntentUtils = SearchIntentUtils.INSTANCE;
        Intent intentAddFlags = new Intent(str).setClassName(packageName, className).setData(Uri.parse(str2)).addFlags(i);
        Intrinsics.checkNotNullExpressionValue(intentAddFlags, "Intent(intentAction)\n   …   .addFlags(intentFlags)");
        this.intentString = searchIntentUtils.getStringFromIntent(intentAddFlags);
    }
}
