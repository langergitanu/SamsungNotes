package com.samsung.android.sdk.scs.p142ai.text.entity;

import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.p142ai.text.entity.BasicEntityExtractor;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BasicEntity {
    private String bankAccountNumber;
    private String bankAmount;
    private String bankName;
    private Date endDate;
    private int endIndex;
    private LocalDateTime endLocalDateTime;
    private BasicEntityExtractor.EntityType entityType;
    private boolean hasDay;
    private boolean hasMonth;
    private boolean hasRecurrenceWithinRange;
    private boolean hasYear;
    private boolean isMappable;
    private boolean isRelative;
    private boolean isSpecialDay;
    private Map<BasicEntityExtractor.RecurrenceUnit, List<Integer>> recurrenceInfo;
    private String repeatInfo;
    private Date startDate;
    private int startIndex;
    private LocalDateTime startLocalDateTime;
    private String text;
    private String unitSymbol;
    private String unitValue;
    private EnumSet<BasicEntityExtractor.DateTimeUnit> unresolvedEndDateTimeUnit;
    private EnumSet<BasicEntityExtractor.DateTimeUnit> unresolvedStartDateTimeUnit;

    public static BasicEntity create() {
        return new BasicEntity();
    }

    public String getBankAccountNumber() {
        return this.bankAccountNumber;
    }

    public String getBankAmount() {
        return this.bankAmount;
    }

    public String getBankName() {
        return this.bankName;
    }

    public Date getEndDateTime() {
        return this.endDate;
    }

    public int getEndIndex() {
        return this.endIndex;
    }

    public LocalDateTime getEndLocalDateTime() {
        return this.endLocalDateTime;
    }

    public Map<BasicEntityExtractor.RecurrenceUnit, List<Integer>> getRecurrenceInfo() {
        return this.recurrenceInfo;
    }

    public String getRepeatInfo() {
        return this.repeatInfo;
    }

    public Date getStartDateTime() {
        return this.startDate;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public LocalDateTime getStartLocalDateTime() {
        return this.startLocalDateTime;
    }

    public String getString() {
        return this.text;
    }

    public BasicEntityExtractor.EntityType getType() {
        return this.entityType;
    }

    public String getUnitSymbol() {
        return this.unitSymbol;
    }

    public String getUnitValue() {
        return this.unitValue;
    }

    public EnumSet<BasicEntityExtractor.DateTimeUnit> getUnresolvedEndDateTimeUnit() {
        return this.unresolvedEndDateTimeUnit;
    }

    public EnumSet<BasicEntityExtractor.DateTimeUnit> getUnresolvedStartDateTimeUnit() {
        return this.unresolvedStartDateTimeUnit;
    }

    public boolean hasDay() {
        return this.hasDay;
    }

    public boolean hasMonth() {
        return this.hasMonth;
    }

    public boolean hasRecurrenceWithinRange() {
        return this.hasRecurrenceWithinRange;
    }

    public boolean hasYear() {
        return this.hasYear;
    }

    public boolean isMappable() {
        return this.isMappable;
    }

    public boolean isRelative() {
        return this.isRelative;
    }

    public boolean isSpecialDay() {
        return this.isSpecialDay;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setBankAccountNumber(String str) {
        this.bankAccountNumber = str;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setBankAmount(String str) {
        this.bankAmount = str;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setBankName(String str) {
        this.bankName = str;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setEndDateTime(Date date) {
        this.endDate = date;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setEndIndex(int i) {
        this.endIndex = i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setEndLocalDateTime(LocalDateTime localDateTime) {
        this.endLocalDateTime = localDateTime;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setHasDay(boolean z) {
        this.hasDay = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setHasMonth(boolean z) {
        this.hasMonth = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setHasRecurrenceWithinRange(boolean z) {
        this.hasRecurrenceWithinRange = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setHasYear(boolean z) {
        this.hasYear = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setMappable(boolean z) {
        this.isMappable = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setRecurrenceInfo(Map<BasicEntityExtractor.RecurrenceUnit, List<Integer>> map) {
        this.recurrenceInfo = map;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setRelative(boolean z) {
        this.isRelative = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setRepeatInfo(String str) {
        this.repeatInfo = str;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setSpecialDay(boolean z) {
        this.isSpecialDay = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setStartDateTime(Date date) {
        this.startDate = date;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setStartIndex(int i) {
        this.startIndex = i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setStartLocalDateTime(LocalDateTime localDateTime) {
        this.startLocalDateTime = localDateTime;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setString(String str) {
        this.text = str;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setType(BasicEntityExtractor.EntityType entityType) {
        this.entityType = entityType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setUnitSymbol(String str) {
        this.unitSymbol = str;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setUnitValue(String str) {
        this.unitValue = str;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setUnresolvedEndDateTimeUnit(EnumSet<BasicEntityExtractor.DateTimeUnit> enumSet) {
        this.unresolvedEndDateTimeUnit = enumSet;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setUnresolvedStartDateTimeUnit(EnumSet<BasicEntityExtractor.DateTimeUnit> enumSet) {
        this.unresolvedStartDateTimeUnit = enumSet;
    }
}
