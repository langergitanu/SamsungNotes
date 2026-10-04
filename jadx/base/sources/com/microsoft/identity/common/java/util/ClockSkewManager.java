package com.microsoft.identity.common.java.util;

import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import java.util.Calendar;
import java.util.Date;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ClockSkewManager implements IClockSkewManager {
    private final INameValueStorage<Long> mClockSkewStorage;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class PreferencesMetadata {
        private static final String KEY_SKEW = "skew";

        private PreferencesMetadata() {
        }
    }

    public ClockSkewManager(@NonNull INameValueStorage<Long> iNameValueStorage) {
        if (iNameValueStorage == null) {
            throw new NullPointerException("storage is marked non-null but is null");
        }
        this.mClockSkewStorage = iNameValueStorage;
    }

    @Override // com.microsoft.identity.common.java.util.IClockSkewManager
    public Date getAdjustedReferenceTime() {
        return toReferenceTime(getCurrentClientTime().getTime());
    }

    @Override // com.microsoft.identity.common.java.util.IClockSkewManager
    public Date getCurrentClientTime() {
        return Calendar.getInstance().getTime();
    }

    @Override // com.microsoft.identity.common.java.util.IClockSkewManager
    public long getSkewMillis() {
        return this.mClockSkewStorage.get("skew").longValue();
    }

    @Override // com.microsoft.identity.common.java.util.IClockSkewManager
    public void onTimestampReceived(long j) {
        this.mClockSkewStorage.put("skew", Long.valueOf(getCurrentClientTime().getTime() - j));
    }

    @Override // com.microsoft.identity.common.java.util.IClockSkewManager
    public Date toClientTime(long j) {
        return new Date(getSkewMillis() + j);
    }

    @Override // com.microsoft.identity.common.java.util.IClockSkewManager
    public Date toReferenceTime(long j) {
        return new Date(j - getSkewMillis());
    }
}
