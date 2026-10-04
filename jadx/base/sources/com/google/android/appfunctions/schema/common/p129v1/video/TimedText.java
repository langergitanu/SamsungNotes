package com.google.android.appfunctions.schema.common.p129v1.video;

import androidx.appsearch.annotation.Document;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__TimedText.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006\u001b"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/video/TimedText;", "", "namespace", "", "id", "startTimeMillis", "", "durationMills", "confidence", "", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJDLjava/lang/String;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getStartTimeMillis", "()J", "getDurationMills", "getConfidence", "()D", "getText", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class TimedText {

    @Document.DoubleProperty(required = true)
    private final double confidence;

    @Document.LongProperty(required = true)
    private final long durationMills;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.LongProperty(required = true)
    private final long startTimeMillis;

    @Document.StringProperty(required = true)
    @NotNull
    private final String text;

    public TimedText(@NotNull String namespace, @NotNull String id, long j, long j2, double d, @NotNull String text) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(text, "text");
        this.namespace = namespace;
        this.id = id;
        this.startTimeMillis = j;
        this.durationMills = j2;
        this.confidence = d;
        this.text = text;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof TimedText)) {
            return false;
        }
        TimedText timedText = (TimedText) other;
        return this.startTimeMillis == timedText.startTimeMillis && this.durationMills == timedText.durationMills && this.confidence == timedText.confidence && Intrinsics.areEqual(this.text, timedText.text);
    }

    public final double getConfidence() {
        return this.confidence;
    }

    public final long getDurationMills() {
        return this.durationMills;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    public final long getStartTimeMillis() {
        return this.startTimeMillis;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.startTimeMillis), Long.valueOf(this.durationMills), Double.valueOf(this.confidence), this.text);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TimedText(String str, String str2, long j, long j2, double d, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str4;
        double d2;
        long j3;
        long j5;
        String str5;
        str = (i & 1) != 0 ? "" : str;
        if ((i & 2) != 0) {
            str4 = str3;
            d2 = d;
            j3 = j2;
            j5 = j;
            str5 = "";
        } else {
            str4 = str3;
            d2 = d;
            j3 = j2;
            j5 = j;
            str5 = str2;
        }
        this(str, str5, j5, j3, d2, str4);
    }
}
