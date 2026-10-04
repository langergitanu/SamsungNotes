package com.samsung.android.support.notes.bixby.bixby2.aid;

import androidx.glance.AbstractC2821a;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\tR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\t¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/aid/BixbySearchParam;", "", "<init>", "()V", Bixby2Constants.BIXBY_PARAM_KEYWORD, "", "getKeyword", "()Ljava/lang/String;", "setKeyword", "(Ljava/lang/String;)V", "category", "getCategory", "setCategory", "isFavorite", "setFavorite", "isLocked", "setLocked", "isScreenOffMemo", "setScreenOffMemo", "keyTimeFrom", "getKeyTimeFrom", "setKeyTimeFrom", "keyTimeTo", "getKeyTimeTo", "setKeyTimeTo", "toString", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BixbySearchParam {

    @Nullable
    private String category;

    @Nullable
    private String isFavorite;

    @Nullable
    private String isLocked;

    @Nullable
    private String isScreenOffMemo;

    @Nullable
    private String keyTimeFrom;

    @Nullable
    private String keyTimeTo;

    @Nullable
    private String keyword;

    @Nullable
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    public final String getKeyTimeFrom() {
        return this.keyTimeFrom;
    }

    @Nullable
    public final String getKeyTimeTo() {
        return this.keyTimeTo;
    }

    @Nullable
    public final String getKeyword() {
        return this.keyword;
    }

    @Nullable
    /* JADX INFO: renamed from: isFavorite, reason: from getter */
    public final String getIsFavorite() {
        return this.isFavorite;
    }

    @Nullable
    /* JADX INFO: renamed from: isLocked, reason: from getter */
    public final String getIsLocked() {
        return this.isLocked;
    }

    @Nullable
    /* JADX INFO: renamed from: isScreenOffMemo, reason: from getter */
    public final String getIsScreenOffMemo() {
        return this.isScreenOffMemo;
    }

    public final void setCategory(@Nullable String str) {
        this.category = str;
    }

    public final void setFavorite(@Nullable String str) {
        this.isFavorite = str;
    }

    public final void setKeyTimeFrom(@Nullable String str) {
        this.keyTimeFrom = str;
    }

    public final void setKeyTimeTo(@Nullable String str) {
        this.keyTimeTo = str;
    }

    public final void setKeyword(@Nullable String str) {
        this.keyword = str;
    }

    public final void setLocked(@Nullable String str) {
        this.isLocked = str;
    }

    public final void setScreenOffMemo(@Nullable String str) {
        this.isScreenOffMemo = str;
    }

    @NotNull
    public String toString() {
        String encode = DataLogger.getEncode(this.keyword);
        String encode2 = DataLogger.getEncode(this.category);
        String str = this.isFavorite;
        String str2 = this.isLocked;
        String str3 = this.isScreenOffMemo;
        String str4 = this.keyTimeFrom;
        String str5 = this.keyTimeTo;
        StringBuilder sbM16m = AbstractC0000a.m16m("Keyword:", encode, ", Category:", encode2, ", isFavorite:");
        AbstractC2821a.m2207B(sbM16m, str, ", isLocked:", str2, ", isScreenOffMemo:");
        AbstractC2821a.m2207B(sbM16m, str3, ", TimeFrom:", str4, ", TimeTo:");
        sbM16m.append(str5);
        return sbM16m.toString();
    }
}
