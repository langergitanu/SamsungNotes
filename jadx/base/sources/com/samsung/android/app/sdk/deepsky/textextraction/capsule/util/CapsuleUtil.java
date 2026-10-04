package com.samsung.android.app.sdk.deepsky.textextraction.capsule.util;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import com.samsung.android.app.sdk.deepsky.textextraction.C7039R;
import com.samsung.android.app.sdk.deepsky.textextraction.action.ActionConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u0018\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/util/CapsuleUtil;", "", "()V", "ENTITY_TYPE_ADDRESS", "", "ENTITY_TYPE_BANK_ACCOUNT_NUMBER", "ENTITY_TYPE_DATE", "ENTITY_TYPE_DATETIME", "ENTITY_TYPE_EMAIL", "ENTITY_TYPE_FLIGHT", "ENTITY_TYPE_PHONE", "ENTITY_TYPE_PHONE_E164", "ENTITY_TYPE_UNIT", "ENTITY_TYPE_URL", "getEntityIcon", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "entityType", "actionName", "getResourceUri", "resId", "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class CapsuleUtil {

    @NotNull
    private static final String ENTITY_TYPE_ADDRESS = "address";

    @NotNull
    private static final String ENTITY_TYPE_BANK_ACCOUNT_NUMBER = "bank_account_number";

    @NotNull
    private static final String ENTITY_TYPE_DATE = "date";

    @NotNull
    private static final String ENTITY_TYPE_DATETIME = "datetime";

    @NotNull
    private static final String ENTITY_TYPE_EMAIL = "email";

    @NotNull
    private static final String ENTITY_TYPE_FLIGHT = "flight";

    @NotNull
    private static final String ENTITY_TYPE_PHONE = "phone";

    @NotNull
    private static final String ENTITY_TYPE_PHONE_E164 = "phone_e164";

    @NotNull
    private static final String ENTITY_TYPE_UNIT = "unit";

    @NotNull
    private static final String ENTITY_TYPE_URL = "url";

    @NotNull
    public static final CapsuleUtil INSTANCE = new CapsuleUtil();

    private CapsuleUtil() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
    
        if (r3.equals("date") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0059, code lost:
    
        return getResourceUri(r2, com.samsung.android.app.sdk.deepsky.textextraction.C7039R.drawable.capsule_calendar);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a2, code lost:
    
        if (r3.equals(com.samsung.android.app.sdk.deepsky.textextraction.capsule.util.CapsuleUtil.ENTITY_TYPE_PHONE_E164) == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b2, code lost:
    
        return getResourceUri(r2, com.samsung.android.app.sdk.deepsky.textextraction.C7039R.drawable.capsule_call_phone);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0019, code lost:
    
        if (r3.equals(com.samsung.android.app.sdk.deepsky.textextraction.capsule.util.CapsuleUtil.ENTITY_TYPE_DATETIME) == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
    
        if (r3.equals("phone") == false) goto L48;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Uri getEntityIcon(@NotNull Context context, @NotNull String entityType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(entityType, "entityType");
        switch (entityType.hashCode()) {
            case -1824434085:
                break;
            case -1422091778:
                if (entityType.equals(ENTITY_TYPE_BANK_ACCOUNT_NUMBER)) {
                    return getResourceUri(context, C7039R.drawable.capsule_bank_account_transfer);
                }
                Uri EMPTY = Uri.EMPTY;
                Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
                return EMPTY;
            case -1271823248:
                if (entityType.equals(ENTITY_TYPE_FLIGHT)) {
                    return getResourceUri(context, C7039R.drawable.capsule_traveling);
                }
                Uri EMPTY2 = Uri.EMPTY;
                Intrinsics.checkNotNullExpressionValue(EMPTY2, "EMPTY");
                return EMPTY2;
            case -1147692044:
                if (entityType.equals("address")) {
                    return getResourceUri(context, C7039R.drawable.capsule_location);
                }
                Uri EMPTY22 = Uri.EMPTY;
                Intrinsics.checkNotNullExpressionValue(EMPTY22, "EMPTY");
                return EMPTY22;
            case 116079:
                if (entityType.equals("url")) {
                    return getResourceUri(context, C7039R.drawable.capsule_internet_web);
                }
                Uri EMPTY222 = Uri.EMPTY;
                Intrinsics.checkNotNullExpressionValue(EMPTY222, "EMPTY");
                return EMPTY222;
            case 3076014:
                break;
            case 3594628:
                if (entityType.equals("unit")) {
                    return getResourceUri(context, C7039R.drawable.capsule_convert_unit);
                }
                Uri EMPTY2222 = Uri.EMPTY;
                Intrinsics.checkNotNullExpressionValue(EMPTY2222, "EMPTY");
                return EMPTY2222;
            case 96619420:
                if (entityType.equals("email")) {
                    return getResourceUri(context, C7039R.drawable.capsule_email);
                }
                Uri EMPTY22222 = Uri.EMPTY;
                Intrinsics.checkNotNullExpressionValue(EMPTY22222, "EMPTY");
                return EMPTY22222;
            case 106642798:
                break;
            case 1793702779:
                break;
            default:
                Uri EMPTY222222 = Uri.EMPTY;
                Intrinsics.checkNotNullExpressionValue(EMPTY222222, "EMPTY");
                return EMPTY222222;
        }
    }

    @NotNull
    public final Uri getResourceUri(@Nullable Context context, int resId) {
        Resources resources;
        Uri uriBuild = (context == null || (resources = context.getResources()) == null) ? null : new Uri.Builder().scheme("android.resource").authority(resources.getResourcePackageName(resId)).appendPath(resources.getResourceTypeName(resId)).appendPath(resources.getResourceEntryName(resId)).build();
        if (uriBuild != null) {
            return uriBuild;
        }
        Uri EMPTY = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        return EMPTY;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
    
        if (r4.equals("phone") == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
    
        if (r4.equals(com.samsung.android.app.sdk.deepsky.textextraction.capsule.util.CapsuleUtil.ENTITY_TYPE_PHONE_E164) != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
    
        r4 = r5.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
    
        if (r4 == 2092670) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0072, code lost:
    
        if (r4 == 1412282255) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0077, code lost:
    
        if (r4 == 1515827073) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0080, code lost:
    
        if (r5.equals(com.samsung.android.app.sdk.deepsky.textextraction.action.ActionConstants.ACTION_ADD_CONTACT) != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0089, code lost:
    
        return getResourceUri(r3, com.samsung.android.app.sdk.deepsky.textextraction.C7039R.drawable.capsule_add_to_contact);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0090, code lost:
    
        if (r5.equals(com.samsung.android.app.sdk.deepsky.textextraction.action.ActionConstants.ACTION_SEND_MESSAGE) != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0099, code lost:
    
        return getResourceUri(r3, com.samsung.android.app.sdk.deepsky.textextraction.C7039R.drawable.capsule_send_to_message);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a0, code lost:
    
        if (r5.equals(com.samsung.android.app.sdk.deepsky.textextraction.action.ActionConstants.ACTION_CALL) != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a8, code lost:
    
        return getResourceUri(r3, com.samsung.android.app.sdk.deepsky.textextraction.C7039R.drawable.capsule_call_phone);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00af, code lost:
    
        return getResourceUri(r3, com.samsung.android.app.sdk.deepsky.textextraction.C7039R.drawable.capsule_call_phone);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Uri getEntityIcon(@NotNull Context context, @NotNull String entityType, @NotNull String actionName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(entityType, "entityType");
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        int iHashCode = entityType.hashCode();
        if (iHashCode != -1824434085) {
            if (iHashCode != 106642798) {
                if (iHashCode == 1793702779 && entityType.equals(ENTITY_TYPE_DATETIME)) {
                    return Intrinsics.areEqual(actionName, ActionConstants.ACTION_ADD_EVENT) ? getResourceUri(context, C7039R.drawable.capsule_calendar) : Intrinsics.areEqual(actionName, ActionConstants.ACTION_ADD_REMINDER) ? getResourceUri(context, C7039R.drawable.capsule_reminder) : getResourceUri(context, C7039R.drawable.capsule_calendar);
                }
            }
            return getEntityIcon(context, entityType);
        }
    }
}
