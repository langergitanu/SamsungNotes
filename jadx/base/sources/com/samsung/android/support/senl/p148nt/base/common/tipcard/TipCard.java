package com.samsung.android.support.senl.p148nt.base.common.tipcard;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u0000 #2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0001:\u0001#B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u001d\u001a\u00020\u0003H\u0016J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0000H\u0096\u0002J\u0013\u0010 \u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\fR\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001c¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/tipcard/TipCard;", "", "type", "", "titleResource", "bodyResource", "positiveButtonResource", "negativeButtonResource", "priority", "<init>", "(IIIIII)V", "getType", "()I", "getTitleResource", "getBodyResource", "setBodyResource", "(I)V", "getPositiveButtonResource", "getNegativeButtonResource", "getPriority", "message", "", "getMessage", "()Ljava/lang/String;", "neutralButtonResourceId", "getNeutralButtonResourceId", "isProgressTipCard", "", "()Z", "hashCode", "compareTo", "tipCard", "equals", "obj", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class TipCard implements Comparable<TipCard> {
    public static final int PRIORITY_ADDITIONAL = 5;
    public static final int PRIORITY_CRITICAL = 1;
    public static final int PRIORITY_INFORMATION = 3;
    public static final int PRIORITY_NEED_TO_FIX = 4;
    public static final int PRIORITY_NONE = 0;
    public static final int PRIORITY_USER_INTERACTION = 2;
    public static final int TIP_CARD_APP_UPDATE_FOR_SYNC = 65536;
    public static final int TIP_CARD_CAN_NOT_SYNC_OVER_1GB = 512;
    public static final int TIP_CARD_CAN_NOT_SYNC_WIFI_ONLY = 16384;
    public static final int TIP_CARD_CLOUD_SERVER_STORAGE_EXCEEDS = 8192;
    public static final int TIP_CARD_EMAIL_INVALID_ERROR = 32768;
    public static final int TIP_CARD_FAIL_TO_IMPORT_DEVICE_STORAGE_FULL = 8;
    public static final int TIP_CARD_FAIL_TO_IMPORT_NETWORK_ERROR = 4;
    public static final int TIP_CARD_FAIL_TO_IMPORT_SERVER_ERROR = 2;
    public static final int TIP_CARD_FAIL_TO_SYNC_NETWORK_ERROR = 64;
    public static final int TIP_CARD_FAIL_TO_SYNC_NOT_ENOUGH_DEVICE_STORAGE = 128;
    public static final int TIP_CARD_FAIL_TO_SYNC_SERVER_BLOCKING = 256;
    public static final int TIP_CARD_FAIL_TO_SYNC_SERVER_ERROR = 32;
    public static final int TIP_CARD_IMPORT_DOWNLOADING = 1;
    public static final int TIP_CARD_NOT_ENOUGH_CLOUD_STORAGE = 16;
    public static final int TIP_CARD_NOT_ENOUGH_CLOUD_STORAGE_IN_SETTINGS = 2048;
    public static final int TIP_CARD_PERMISSION_NOT_GRANTED = 1024;
    public static final int TIP_CARD_SHARE_FAIL_TO_SHARE_NOTE = 4096;
    public static final int TIP_CARD_UNKNOWN = 0;
    private int bodyResource;
    private final int negativeButtonResource;
    private final int positiveButtonResource;
    private final int priority;
    private final int titleResource;
    private final int type;

    public TipCard(int i, int i2, int i4, int i5, int i6, int i7) {
        this.type = i;
        this.titleResource = i2;
        this.bodyResource = i4;
        this.positiveButtonResource = i5;
        this.negativeButtonResource = i6;
        this.priority = i7;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof TipCard)) {
            return false;
        }
        TipCard tipCard = (TipCard) obj;
        if (tipCard.type == this.type && tipCard.titleResource == this.titleResource && tipCard.bodyResource == this.bodyResource && tipCard.negativeButtonResource == this.negativeButtonResource && tipCard.positiveButtonResource == this.positiveButtonResource && tipCard.priority == this.priority) {
            return super.equals(obj);
        }
        return false;
    }

    public final int getBodyResource() {
        return this.bodyResource;
    }

    @NotNull
    public String getMessage() {
        Context applicationContext;
        String string;
        return (this.bodyResource == 0 || (applicationContext = BaseUtils.getApplicationContext()) == null || (string = applicationContext.getString(this.bodyResource)) == null) ? "" : string;
    }

    public final int getNegativeButtonResource() {
        return this.negativeButtonResource;
    }

    public int getNeutralButtonResourceId() {
        return C8875R.string.tipcard_button_not_now;
    }

    public final int getPositiveButtonResource() {
        return this.positiveButtonResource;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final int getTitleResource() {
        return this.titleResource;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type;
    }

    public final boolean isProgressTipCard() {
        int i = this.type;
        return 1 == i || 21 == i || 24 == i || 26 == i;
    }

    public final void setBodyResource(int i) {
        this.bodyResource = i;
    }

    @Override // java.lang.Comparable
    public int compareTo(@Nullable TipCard tipCard) {
        if (tipCard != null) {
            return this.priority - tipCard.priority;
        }
        return 0;
    }
}
