package org.apache.commons.lang3.time;

import androidx.emoji2.text.flatbuffer.C2747a;
import java.util.TimeZone;
import org.apache.commons.lang3.ObjectUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TimeZones {
    public static final String GMT_ID = "GMT";
    public static final TimeZone GMT = TimeZone.getTimeZone(GMT_ID);

    private TimeZones() {
    }

    public static TimeZone toTimeZone(TimeZone timeZone) {
        return (TimeZone) ObjectUtils.getIfNull(timeZone, new C2747a(16));
    }
}
