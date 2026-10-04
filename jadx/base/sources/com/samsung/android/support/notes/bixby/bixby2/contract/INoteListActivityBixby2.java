package com.samsung.android.support.notes.bixby.bixby2.contract;

import com.samsung.android.support.notes.bixby.bixby2.aid.BixbyAiParam;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JD\u0010\b\u001a\u00020\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0003H&J:\u0010\u000e\u001a\u00020\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u001c\u0010\u0012\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/contract/INoteListActivityBixby2;", "", "bixbyAction", "", "getBixbyAction", "()Ljava/lang/String;", Bixby2Constants.BIXBY_PARAM_SHARE_TYPE, "getShareType", "openComposer", "", "noteId", Bixby2Constants.BIXBY_PARAM_KEYWORD, "packageName", Bixby2Constants.BIXBY_PARAM_ACTIVITY_NAME, "addContentToComposer", Bixby2Constants.BIXBY_PARAM_IMAGE_URI, Bixby2Constants.BIXBY_PARAM_NOTE_TITLE, "text", "sendActionToComposer", "bixbyAiParam", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/BixbyAiParam;", "actionName", "bixbyParam", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface INoteListActivityBixby2 {
    boolean addContentToComposer(@Nullable String bixbyAction, @Nullable String noteId, @Nullable String imageUri, @Nullable String noteTitle, @Nullable String text);

    @Nullable
    String getBixbyAction();

    @Nullable
    String getShareType();

    boolean openComposer(@Nullable String bixbyAction, @Nullable String noteId, @Nullable String shareType, @Nullable String keyword, @Nullable String packageName, @Nullable String activityName);

    boolean sendActionToComposer(@Nullable BixbyAiParam bixbyAiParam);

    boolean sendActionToComposer(@Nullable String actionName, @Nullable String bixbyParam);
}
