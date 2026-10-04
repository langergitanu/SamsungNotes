package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.voice;

import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB/\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001f¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/model/menu/voice/VoiceMenuItem;", "", "name", "", DBSchema.DocumentThumbnail.PLAY_TIME, "date", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "summarize", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "value", "sumarize", "getSumarize", "setSumarize", "getPlayTime", "setPlayTime", "createDate", "getCreateDate", "()J", "setCreateDate", "(J)V", "deleteVisible", "", "getDeleteVisible", "()Z", "setDeleteVisible", "(Z)V", "playingVisible", "getPlayingVisible", "setPlayingVisible", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceMenuItem {
    private long createDate;
    private boolean deleteVisible;

    @Nullable
    private String name;

    @Nullable
    private String playTime;
    private boolean playingVisible;

    @Nullable
    private String sumarize;

    public VoiceMenuItem(@Nullable String str, @Nullable String str2, long j) {
        this.name = str;
        this.playTime = str2;
        this.createDate = j;
        this.deleteVisible = false;
        this.playingVisible = false;
    }

    public final long getCreateDate() {
        return this.createDate;
    }

    public final boolean getDeleteVisible() {
        return this.deleteVisible;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getPlayTime() {
        return this.playTime;
    }

    public final boolean getPlayingVisible() {
        return this.playingVisible;
    }

    @Nullable
    public final String getSumarize() {
        return this.sumarize;
    }

    public final void setCreateDate(long j) {
        this.createDate = j;
    }

    public final void setDeleteVisible(boolean z) {
        this.deleteVisible = z;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setPlayTime(@Nullable String str) {
        this.playTime = str;
    }

    public final void setPlayingVisible(boolean z) {
        this.playingVisible = z;
    }

    public final void setSumarize(@Nullable String str) {
        String strSubstring;
        if (str != null) {
            strSubstring = str.substring(0, Math.min(str.length(), 1000));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        } else {
            strSubstring = null;
        }
        this.sumarize = strSubstring;
    }

    public VoiceMenuItem(@Nullable String str, @Nullable String str2, long j, @Nullable String str3) {
        this.name = str;
        this.playTime = str2;
        this.createDate = j;
        setSumarize(str3);
        this.deleteVisible = false;
        this.playingVisible = false;
    }
}
