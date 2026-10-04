package com.samsung.android.support.senl.p148nt.stt.base.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0011\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0010¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/model/TextData;", "", "", "text", "", "speakerId", "", "startTime", "endTime", "<init>", "(Ljava/lang/String;III)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getSpeakerId", "()I", "getStartTime", "getEndTime", "isSpeakerLabel", "", "trimText", "", "textLength", "getTextLength", "compareTo", "another", "equals", "o", "", "hashCode", "clone", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextData.kt\ncom/samsung/android/support/senl/nt/stt/base/model/TextData\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,40:1\n108#2:41\n80#2,22:42\n*S KotlinDebug\n*F\n+ 1 TextData.kt\ncom/samsung/android/support/senl/nt/stt/base/model/TextData\n*L\n8#1:41\n8#1:42,22\n*E\n"})
public final class TextData implements Comparable<TextData>, Cloneable {
    private final int endTime;
    private final boolean isSpeakerLabel;
    private final int speakerId;
    private final int startTime;

    @NotNull
    private String text;

    public TextData(@NotNull String text, int i, int i2, int i4) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.speakerId = i;
        this.startTime = i2;
        this.endTime = i4;
    }

    @NotNull
    public Object clone() {
        return super.clone();
    }

    public boolean equals(@Nullable Object o) {
        if (!(o instanceof TextData)) {
            return false;
        }
        TextData textData = (TextData) o;
        return Intrinsics.areEqual(this.text, textData.text) && this.startTime == textData.startTime && this.endTime == textData.endTime;
    }

    public final int getEndTime() {
        return this.endTime;
    }

    public final int getSpeakerId() {
        return this.speakerId;
    }

    public final int getStartTime() {
        return this.startTime;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public final int getTextLength() {
        return this.text.length();
    }

    public int hashCode() {
        return super.hashCode();
    }

    public final void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public final void trimText() {
        String str = this.text;
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        this.text = str.subSequence(i, length + 1).toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull TextData another) {
        Intrinsics.checkNotNullParameter(another, "another");
        int i = this.startTime;
        int i2 = another.startTime;
        if (i > i2) {
            return 1;
        }
        return i < i2 ? -1 : 0;
    }
}
