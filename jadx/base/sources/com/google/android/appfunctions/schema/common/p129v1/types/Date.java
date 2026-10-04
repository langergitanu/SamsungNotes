package com.google.android.appfunctions.schema.common.p129v1.types;

import androidx.appsearch.annotation.Document;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__Date.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0016"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/types/Date;", "", "namespace", "", "id", "year", "", "month", "day", "<init>", "(Ljava/lang/String;Ljava/lang/String;III)V", "getNamespace", "()Ljava/lang/String;", "getId", "getYear", "()I", "getMonth", "getDay", "equals", "", "other", "hashCode", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class Date {

    @Document.LongProperty(required = true)
    private final int day;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.LongProperty(required = true)
    private final int month;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.LongProperty(required = true)
    private final int year;

    public Date(@NotNull String namespace, @NotNull String id, int i, int i2, int i4) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        this.namespace = namespace;
        this.id = id;
        this.year = i;
        this.month = i2;
        this.day = i4;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof Date)) {
            return false;
        }
        Date date = (Date) other;
        return this.year == date.year && this.month == date.month && this.day == date.day;
    }

    public final int getDay() {
        return this.day;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final int getMonth() {
        return this.month;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    public final int getYear() {
        return this.year;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.year), Integer.valueOf(this.month), Integer.valueOf(this.day));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Date(String str, String str2, int i, int i2, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        int i6;
        int i7;
        int i8;
        String str3;
        str = (i5 & 1) != 0 ? "" : str;
        if ((i5 & 2) != 0) {
            i6 = i4;
            i7 = i2;
            i8 = i;
            str3 = "";
        } else {
            i6 = i4;
            i7 = i2;
            i8 = i;
            str3 = str2;
        }
        this(str, str3, i8, i7, i6);
    }
}
