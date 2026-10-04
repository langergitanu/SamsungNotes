package org.apache.commons.lang3.time;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;
import org.apache.commons.beanutils.PropertyUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class GmtTimeZone extends TimeZone {
    private static final int HOURS_PER_DAY = 24;
    private static final int MILLISECONDS_PER_MINUTE = 60000;
    private static final int MINUTES_PER_HOUR = 60;
    static final long serialVersionUID = 1;
    private final int offset;
    private final String zoneId;

    public GmtTimeZone(boolean z, int i, int i2) {
        if (i >= 24) {
            throw new IllegalArgumentException(AbstractC2322a.m1615e(i, " hours out of range"));
        }
        if (i2 >= 60) {
            throw new IllegalArgumentException(AbstractC2322a.m1615e(i2, " minutes out of range"));
        }
        int i4 = ((i * 60) + i2) * 60000;
        this.offset = z ? -i4 : i4;
        StringBuilder sbM1627q = AbstractC2322a.m1627q(9, TimeZones.GMT_ID);
        sbM1627q.append(z ? '-' : '+');
        StringBuilder sbTwoDigits = twoDigits(sbM1627q, i);
        sbTwoDigits.append(':');
        this.zoneId = twoDigits(sbTwoDigits, i2).toString();
    }

    private static StringBuilder twoDigits(StringBuilder sb, int i) {
        sb.append((char) ((i / 10) + 48));
        sb.append((char) ((i % 10) + 48));
        return sb;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GmtTimeZone)) {
            return false;
        }
        GmtTimeZone gmtTimeZone = (GmtTimeZone) obj;
        return this.offset == gmtTimeZone.offset && Objects.equals(this.zoneId, gmtTimeZone.zoneId);
    }

    @Override // java.util.TimeZone
    public String getID() {
        return this.zoneId;
    }

    @Override // java.util.TimeZone
    public int getOffset(int i, int i2, int i4, int i5, int i6, int i7) {
        return this.offset;
    }

    @Override // java.util.TimeZone
    public int getRawOffset() {
        return this.offset;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.offset), this.zoneId);
    }

    @Override // java.util.TimeZone
    public boolean inDaylightTime(Date date) {
        return false;
    }

    @Override // java.util.TimeZone
    public void setRawOffset(int i) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[GmtTimeZone id=\"");
        sb.append(this.zoneId);
        sb.append("\",offset=");
        return AbstractC0000a.m13j(sb, this.offset, PropertyUtils.INDEXED_DELIM2);
    }

    @Override // java.util.TimeZone
    public boolean useDaylightTime() {
        return false;
    }
}
