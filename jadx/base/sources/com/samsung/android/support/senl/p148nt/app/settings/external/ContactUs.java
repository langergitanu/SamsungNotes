package com.samsung.android.support.senl.p148nt.app.settings.external;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/external/ContactUs;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "SAMSUNG_MEMBERS_PACKAGE_NAME", "CONTACT_US_URL", "KEY_PACKAGE_NAME", "KEY_APP_ID", "KEY_APP_NAME", "SAMSUNG_MEMBERS_SUPPORT_VERSION", "", "REQUEST_CONTACT_US", "launchContactUs", "", "context", "Landroid/content/Context;", "isAvailableContactUs", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ContactUs {

    @NotNull
    private static final String CONTACT_US_URL = "voc://view/contactUs";

    @NotNull
    public static final ContactUs INSTANCE = new ContactUs();

    @NotNull
    private static final String KEY_APP_ID = "appId";

    @NotNull
    private static final String KEY_APP_NAME = "appName";

    @NotNull
    private static final String KEY_PACKAGE_NAME = "packageName";
    private static final int REQUEST_CONTACT_US = 10;

    @NotNull
    private static final String SAMSUNG_MEMBERS_PACKAGE_NAME = "com.samsung.android.voc";
    private static final int SAMSUNG_MEMBERS_SUPPORT_VERSION = 170001000;

    @NotNull
    private static final String TAG = "ST$ContactUs";

    private ContactUs() {
    }

    @JvmStatic
    public static final boolean isAvailableContactUs(@Nullable Context context) {
        PackageManagerCompat.Companion companion = PackageManagerCompat.INSTANCE;
        if (!companion.getInstance().isKMemoPackage(context)) {
            return companion.getInstance().isPackageInstalled(context, SAMSUNG_MEMBERS_PACKAGE_NAME, SAMSUNG_MEMBERS_SUPPORT_VERSION);
        }
        MainLogger.m7259w(TAG, "isAvailableContactUs, KMemoPackage is not support contact us");
        return false;
    }

    public final void launchContactUs(@Nullable Context context) {
        MainLogger.m7258i(TAG, "launchContactUs");
        if (context == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(CONTACT_US_URL));
        intent.putExtra("packageName", context.getPackageName());
        intent.putExtra("appId", CommonUtils.getOldNotesServiceId());
        intent.putExtra(KEY_APP_NAME, context.getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.notes_jp : C8003R.string.notes));
        if (intent.resolveActivity(context.getPackageManager()) == null) {
            MainLogger.m7259w(TAG, "launchContactUs, intent do not have component");
        } else {
            PopOverActivityWrapper.startActivityForResult(context, intent, 10, 4);
        }
    }
}
