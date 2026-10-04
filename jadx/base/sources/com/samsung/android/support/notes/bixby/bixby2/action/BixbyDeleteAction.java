package com.samsung.android.support.notes.bixby.bixby2.action;

import android.os.Bundle;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.gson.Gson;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.bixby2.action.ResponseCallback;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.notes.bixby.bixby2.aid.AbsBixby2Async;
import com.samsung.android.support.notes.bixby.bixby2.aid.ActionResult;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p066P2.RunnableC0201c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/action/BixbyDeleteAction;", "Lcom/samsung/android/support/notes/bixby/bixby2/action/AbsBixbyAction;", ActionHandler.PARAMS, "Landroid/os/Bundle;", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/sdk/bixby2/action/ResponseCallback;", "<init>", "(Landroid/os/Bundle;Lcom/samsung/android/sdk/bixby2/action/ResponseCallback;)V", "mNoteId", "", "execute", "", "asyncParam", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/AbsBixby2Async$AsyncParam;", "Companion", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBixbyDeleteAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BixbyDeleteAction.kt\ncom/samsung/android/support/notes/bixby/bixby2/action/BixbyDeleteAction\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,61:1\n1#2:62\n739#3,9:63\n37#4:72\n36#4,3:73\n*S KotlinDebug\n*F\n+ 1 BixbyDeleteAction.kt\ncom/samsung/android/support/notes/bixby/bixby2/action/BixbyDeleteAction\n*L\n45#1:63,9\n45#1:72\n45#1:73,3\n*E\n"})
public final class BixbyDeleteAction extends AbsBixbyAction {

    @NotNull
    private static final String TAG = "BixbyDeleteAction";

    @Nullable
    private String mNoteId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BixbyDeleteAction(@NotNull Bundle params, @NotNull ResponseCallback callback) {
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
            if (Intrinsics.areEqual("noteId", str)) {
                this.mNoteId = (String) list.get(0);
            }
        }
        if (this.mNoteId == null) {
            throw new IllegalArgumentException("mandatory param(s) missing.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execute$lambda$3(ActionResult actionResult, Gson gson, BixbyDeleteAction bixbyDeleteAction) {
        actionResult.setResult("success");
        actionResult.setDescription("success");
        String json = gson.toJson(actionResult);
        AbstractC4539a.m3188B("onRequestComplete", json, TAG);
        bixbyDeleteAction.mCallback.onComplete(json);
    }

    public final void execute(@NotNull AbsBixby2Async.AsyncParam asyncParam) {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(asyncParam, "asyncParam");
        Logger.m8697d(TAG, "execute() - " + this.mNoteId);
        ActionResult actionResult = new ActionResult();
        actionResult.setResult(Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
        actionResult.setDescription(Bixby2Constants.ResponseOutputResult.RESULT_FAILURE);
        Gson gson = new Gson();
        String str = this.mNoteId;
        if (str == null) {
            Logger.m8697d(TAG, "noteId is null");
            this.mCallback.onComplete(gson.toJson(actionResult));
            return;
        }
        Intrinsics.checkNotNull(str);
        List<String> listSplit = new Regex("\\,").split(str, 0);
        if (listSplit.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listSplit);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        BixbyActionNoteListController companion = BixbyActionNoteListController.INSTANCE.getInstance();
        if (companion != null) {
            companion.deleteNotes(strArr, asyncParam, new RunnableC0201c(actionResult, 21, gson, this));
        }
    }
}
