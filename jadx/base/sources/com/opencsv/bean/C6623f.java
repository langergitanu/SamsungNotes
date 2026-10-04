package com.opencsv.bean;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

/* JADX INFO: renamed from: com.opencsv.bean.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C6623f implements TemporalQuery {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3682a;

    @Override // java.time.temporal.TemporalQuery
    public final Object queryFrom(TemporalAccessor temporalAccessor) {
        switch (this.f3682a) {
            case 0:
                return MonthDay.from(temporalAccessor);
            case 1:
                return LocalDate.from(temporalAccessor);
            case 2:
                return LocalTime.from(temporalAccessor);
            case 3:
                return YearMonth.from(temporalAccessor);
            case 4:
                return DayOfWeek.from(temporalAccessor);
            case 5:
                return LocalDateTime.from(temporalAccessor);
            case 6:
                return ZoneOffset.from(temporalAccessor);
            case 7:
                return Month.from(temporalAccessor);
            case 8:
                return OffsetTime.from(temporalAccessor);
            case 9:
                return Year.from(temporalAccessor);
            case 10:
                return ChronoLocalDate.from(temporalAccessor);
            case 11:
                return ZonedDateTime.from(temporalAccessor);
            case 12:
                return OffsetDateTime.from(temporalAccessor);
            default:
                return Instant.from(temporalAccessor);
        }
    }
}
