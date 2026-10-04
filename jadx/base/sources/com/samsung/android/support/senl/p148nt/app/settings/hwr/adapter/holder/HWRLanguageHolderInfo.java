package com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.holder;

import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\bJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0005J\u0011\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/hwr/adapter/holder/HWRLanguageHolderInfo;", "", "locale", "", "type", "", "<init>", "(Ljava/lang/String;I)V", "(I)V", "getLocale", "()Ljava/lang/String;", "getType", "()I", "value", ImportHandler.KEY_TOTAL, "getTotal", "progress", "getProgress", "displayData", "getDisplayData", "setDisplayData", "(Ljava/lang/String;)V", "setTotal", "setProgress", "compareTo", "o", "equals", "", "obj", "", "hashCode", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class HWRLanguageHolderInfo implements Comparable<HWRLanguageHolderInfo> {
    public static final int TYPE_AVAILABLE_FOOTER = 7;
    public static final int TYPE_AVAILABLE_HEADER = 5;
    public static final int TYPE_AVAILABLE_ITEM = 6;
    public static final int TYPE_DESCRIPTION = 1;
    public static final int TYPE_DOWNLOADED_FOOTER = 4;
    public static final int TYPE_DOWNLOADED_HEADER = 2;
    public static final int TYPE_DOWNLOADED_ITEM = 3;
    public static final int TYPE_NONE = -1;
    public static final int TYPE_SWITCH = 0;

    @Nullable
    private String displayData;

    @NotNull
    private final String locale;
    private int progress;
    private int total;
    private final int type;

    public HWRLanguageHolderInfo(@NotNull String locale, int i) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.locale = locale;
        this.type = i;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof HWRLanguageHolderInfo) && compareTo((HWRLanguageHolderInfo) obj) == 0;
    }

    @Nullable
    public final String getDisplayData() {
        return this.displayData;
    }

    @NotNull
    public final String getLocale() {
        return this.locale;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final int getTotal() {
        return this.total;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public final void setDisplayData(@Nullable String str) {
        this.displayData = str;
    }

    @NotNull
    public final HWRLanguageHolderInfo setProgress(int progress) {
        this.progress = progress;
        return this;
    }

    @NotNull
    public final HWRLanguageHolderInfo setTotal(int total) {
        this.total = total;
        return this;
    }

    public HWRLanguageHolderInfo(int i) {
        this("", i);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull HWRLanguageHolderInfo o) {
        Intrinsics.checkNotNullParameter(o, "o");
        int i = this.type;
        int i2 = o.type;
        return i == i2 ? this.locale.compareTo(o.locale) : i - i2;
    }
}
