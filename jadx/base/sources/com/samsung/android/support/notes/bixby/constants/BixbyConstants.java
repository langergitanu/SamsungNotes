package com.samsung.android.support.notes.bixby.constants;

import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/constants/BixbyConstants;", "", "<init>", "()V", "FAIL", "", CoverStickerConstants.Category.NONE.NAME, "SUCCESS", "NOTELIST_ACTIVITY", "NOTE_FRAGMENT", "BIXBY_APP_LINK", "", "BIXBY_PARAM_NOTE_ID", "BIXBY2_BASE", "OPENED_COMPOSER", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BixbyConstants {
    public static final int BIXBY2_BASE = 1000;

    @NotNull
    public static final String BIXBY_APP_LINK = "applink";

    @NotNull
    public static final String BIXBY_PARAM_NOTE_ID = "noteId";
    public static final int FAIL = -1;

    @NotNull
    public static final BixbyConstants INSTANCE = new BixbyConstants();
    public static final int NONE = 0;
    public static final int NOTELIST_ACTIVITY = 100;
    public static final int NOTE_FRAGMENT = 101;
    public static final int OPENED_COMPOSER = 1001;
    public static final int SUCCESS = 1;

    private BixbyConstants() {
    }
}
