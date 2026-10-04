package com.samsung.android.support.notes.bixby.bixby2.action;

import android.os.Bundle;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.bixby2.action.ResponseCallback;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.notes.bixby.bixby2.aid.AbsBixby2Async;
import com.samsung.android.support.notes.bixby.bixby2.aid.BixbySearchParam;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/action/BixbySearchAction;", "Lcom/samsung/android/support/notes/bixby/bixby2/action/AbsBixbyAction;", ActionHandler.PARAMS, "Landroid/os/Bundle;", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/sdk/bixby2/action/ResponseCallback;", "<init>", "(Landroid/os/Bundle;Lcom/samsung/android/sdk/bixby2/action/ResponseCallback;)V", "searchParam", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/BixbySearchParam;", "execute", "", "asyncParam", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/AbsBixby2Async$AsyncParam;", "Companion", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBixbySearchAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BixbySearchAction.kt\ncom/samsung/android/support/notes/bixby/bixby2/action/BixbySearchAction\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,44:1\n1#2:45\n*E\n"})
public final class BixbySearchAction extends AbsBixbyAction {

    @NotNull
    private static final String TAG = "BixbySearchAction";

    @NotNull
    private final BixbySearchParam searchParam;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public BixbySearchAction(@NotNull Bundle params, @NotNull ResponseCallback callback) {
        super(callback);
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        HashMap map = (HashMap) params.getSerializable(ActionHandler.PARAMS);
        if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException("params/type cannot be null or empty.");
        }
        this.searchParam = new BixbySearchParam();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            switch (str.hashCode()) {
                case -814408215:
                    if (str.equals(Bixby2Constants.BIXBY_PARAM_KEYWORD)) {
                        this.searchParam.setKeyword(decodeString((String) list.get(0)));
                    } else {
                        Logger.m8697d(TAG, "unexpected key: ".concat(str));
                    }
                    break;
                case -423418668:
                    if (str.equals("isLocked")) {
                        this.searchParam.setLocked((String) list.get(0));
                    } else {
                        Logger.m8697d(TAG, "unexpected key: ".concat(str));
                    }
                    break;
                case 50511102:
                    if (str.equals("category")) {
                        this.searchParam.setCategory(decodeString((String) list.get(0)));
                    } else {
                        Logger.m8697d(TAG, "unexpected key: ".concat(str));
                    }
                    break;
                case 134991836:
                    if (str.equals("KEY_TIME_FROM")) {
                        this.searchParam.setKeyTimeFrom((String) list.get(0));
                    } else {
                        Logger.m8697d(TAG, "unexpected key: ".concat(str));
                    }
                    break;
                case 257519846:
                    if (str.equals("isFavorite")) {
                        this.searchParam.setFavorite((String) list.get(0));
                    } else {
                        Logger.m8697d(TAG, "unexpected key: ".concat(str));
                    }
                    break;
                case 1805725485:
                    if (str.equals("KEY_TIME_TO")) {
                        this.searchParam.setKeyTimeTo((String) list.get(0));
                    } else {
                        Logger.m8697d(TAG, "unexpected key: ".concat(str));
                    }
                    break;
                case 2000487475:
                    if (str.equals("isScreenOffMemo")) {
                        this.searchParam.setScreenOffMemo((String) list.get(0));
                    } else {
                        Logger.m8697d(TAG, "unexpected key: ".concat(str));
                    }
                    break;
                default:
                    Logger.m8697d(TAG, "unexpected key: ".concat(str));
                    break;
            }
        }
    }

    public final void execute(@NotNull AbsBixby2Async.AsyncParam asyncParam) {
        Intrinsics.checkNotNullParameter(asyncParam, "asyncParam");
        Logger.m8697d(TAG, "execute() - " + this.searchParam);
        BixbyActionNoteListController companion = BixbyActionNoteListController.INSTANCE.getInstance();
        if (companion != null) {
            companion.searchNotes(this.searchParam, asyncParam);
        }
    }
}
