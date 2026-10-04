package com.samsung.android.support.senl.p148nt.base.common.mcf.utils;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.provider.Settings;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u001a\u0010\u0013\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/mcf/utils/MCFUtil;", "", "<init>", "()V", "SEC_FLOATING_FEATURE_MCF_SUPPORT_CONTINUITY", "", "SETTINGS_NAME_MCF_CONTINUITY", "URI_SETTINGS_MCF_CONTINUITY", "Landroid/net/Uri;", "getURI_SETTINGS_MCF_CONTINUITY", "()Landroid/net/Uri;", "isContinuitySettingEnabled", "", "context", "Landroid/content/Context;", "registerContentObserver", "", "contentObserver", "Landroid/database/ContentObserver;", "unregisterContentObserver", "sIsMCFContinuitySupported", "Ljava/lang/Boolean;", "isMCFContinuitySupported", "()Z", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMCFUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MCFUtil.kt\ncom/samsung/android/support/senl/nt/base/common/mcf/utils/MCFUtil\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,54:1\n1#2:55\n*E\n"})
public final class MCFUtil {

    @NotNull
    public static final MCFUtil INSTANCE = new MCFUtil();

    @NotNull
    private static final String SEC_FLOATING_FEATURE_MCF_SUPPORT_CONTINUITY = "SEC_FLOATING_FEATURE_MCF_SUPPORT_CONTINUITY";

    @NotNull
    private static final String SETTINGS_NAME_MCF_CONTINUITY = "mcf_continuity";

    @NotNull
    private static final Uri URI_SETTINGS_MCF_CONTINUITY;

    @Nullable
    private static Boolean sIsMCFContinuitySupported;

    static {
        Uri uriFor = Settings.System.getUriFor("mcf_continuity");
        Intrinsics.checkNotNullExpressionValue(uriFor, "getUriFor(...)");
        URI_SETTINGS_MCF_CONTINUITY = uriFor;
    }

    private MCFUtil() {
    }

    @JvmStatic
    public static final boolean isContinuitySettingEnabled(@Nullable Context context) {
        return context != null && INSTANCE.isMCFContinuitySupported() && Settings.System.getInt(context.getContentResolver(), "mcf_continuity", 0) == 1;
    }

    private final boolean isMCFContinuitySupported() {
        Boolean bool = sIsMCFContinuitySupported;
        if (bool != null) {
            Intrinsics.checkNotNull(bool);
            return bool.booleanValue();
        }
        sIsMCFContinuitySupported = Boolean.FALSE;
        int i = FloatingFeature.INSTANCE.getInstance().getInt("SEC_FLOATING_FEATURE_MCF_SUPPORT_CONTINUITY");
        if (i > 0) {
            sIsMCFContinuitySupported = Boolean.valueOf((i & 4) != 0);
        }
        Boolean bool2 = sIsMCFContinuitySupported;
        Intrinsics.checkNotNull(bool2);
        return bool2.booleanValue();
    }

    @NotNull
    public final Uri getURI_SETTINGS_MCF_CONTINUITY() {
        return URI_SETTINGS_MCF_CONTINUITY;
    }

    public final void registerContentObserver(@Nullable Context context, @Nullable ContentObserver contentObserver) {
        if (context == null || !isMCFContinuitySupported() || contentObserver == null) {
            return;
        }
        context.getContentResolver().registerContentObserver(URI_SETTINGS_MCF_CONTINUITY, false, contentObserver);
    }

    public final void unregisterContentObserver(@Nullable Context context, @Nullable ContentObserver contentObserver) {
        if (context == null || !isMCFContinuitySupported() || contentObserver == null) {
            return;
        }
        context.getContentResolver().unregisterContentObserver(contentObserver);
    }
}
