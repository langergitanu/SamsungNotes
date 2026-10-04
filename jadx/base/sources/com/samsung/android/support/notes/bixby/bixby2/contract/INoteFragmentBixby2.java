package com.samsung.android.support.notes.bixby.bixby2.contract;

import com.samsung.android.support.notes.bixby.bixby2.aid.MainListValue;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\bJ\u001f\u0010\t\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H&¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u000eH&R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/contract/INoteFragmentBixby2;", "", "shareNotes", "", "noteIds", "", "", Bixby2Constants.BIXBY_PARAM_SHARE_TYPE, "([Ljava/lang/String;Ljava/lang/String;)Z", "deleteNotes", "([Ljava/lang/String;)Z", "search", "showAllNotes", "setAction", "", "noteListInfo", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/MainListValue;", "getNoteListInfo", "()Lcom/samsung/android/support/notes/bixby/bixby2/aid/MainListValue;", "isPdfWriterActivityResumed", "()Z", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface INoteFragmentBixby2 {
    boolean deleteNotes(@Nullable String[] noteIds);

    @Nullable
    MainListValue getNoteListInfo();

    boolean isPdfWriterActivityResumed();

    boolean search();

    void setAction();

    boolean shareNotes(@NotNull String[] noteIds, @Nullable String shareType);

    boolean showAllNotes();
}
