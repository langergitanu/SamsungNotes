package com.samsung.android.support.notes.bixby.bixby2.action;

import android.os.Bundle;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.bixby2.action.ResponseCallback;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.notes.bixby.bixby2.aid.AbsBixby2Async;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/action/BixbyUpdateAction;", "Lcom/samsung/android/support/notes/bixby/bixby2/action/AbsBixbyAction;", ActionHandler.PARAMS, "Landroid/os/Bundle;", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/sdk/bixby2/action/ResponseCallback;", "<init>", "(Landroid/os/Bundle;Lcom/samsung/android/sdk/bixby2/action/ResponseCallback;)V", "mNoteId", "", "mNoteTitle", "mContent", "execute", "", "asyncParam", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/AbsBixby2Async$AsyncParam;", "Companion", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBixbyUpdateAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BixbyUpdateAction.kt\ncom/samsung/android/support/notes/bixby/bixby2/action/BixbyUpdateAction\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,40:1\n1#2:41\n*E\n"})
public final class BixbyUpdateAction extends AbsBixbyAction {

    @NotNull
    private static final String TAG = "BixbyUpdateAction";

    @Nullable
    private String mContent;

    @Nullable
    private String mNoteId;

    @Nullable
    private String mNoteTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BixbyUpdateAction(@NotNull Bundle params, @NotNull ResponseCallback callback) {
        super(callback);
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        HashMap map = (HashMap) params.getSerializable(ActionHandler.PARAMS);
        if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException("params/type cannot be null or empty.");
        }
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            int iHashCode = str.hashCode();
            if (iHashCode != -1039694675) {
                if (iHashCode != 3029410) {
                    if (iHashCode == 1770498438 && str.equals(Bixby2Constants.BIXBY_PARAM_NOTE_TITLE)) {
                        this.mNoteTitle = decodeString((String) list.get(0));
                    }
                } else if (str.equals("body")) {
                    this.mContent = decodeString((String) list.get(0));
                }
            } else if (str.equals("noteId")) {
                this.mNoteId = (String) list.get(0);
            }
        }
    }

    public final void execute(@NotNull AbsBixby2Async.AsyncParam asyncParam) {
        Intrinsics.checkNotNullParameter(asyncParam, "asyncParam");
        String str = this.mNoteId;
        String encode = Logger.getEncode(this.mNoteTitle);
        String encode2 = Logger.getEncode(this.mContent);
        StringBuilder sbM16m = AbstractC0000a.m16m("execute() - ", str, SQLKeyword.COMMA, encode, SQLKeyword.COMMA);
        sbM16m.append(encode2);
        Logger.m8697d(TAG, sbM16m.toString());
        BixbyActionNoteListController companion = BixbyActionNoteListController.INSTANCE.getInstance();
        if (companion != null) {
            companion.updateNotes(this.mNoteId, this.mNoteTitle, this.mContent, asyncParam);
        }
    }
}
