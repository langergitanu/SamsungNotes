package com.samsung.android.support.notes.bixby.bixby2.action;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.bixby2.action.ResponseCallback;
import com.samsung.android.support.notes.bixby.bixby2.aid.AbsBixby2Async;
import com.samsung.android.support.notes.bixby.bixby2.aid.ActionResponseCallback;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0002\u0011\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0014\u0010\u000e\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/action/BixbyActionHandler;", "Lcom/samsung/android/sdk/bixby2/action/ActionHandler;", "<init>", "()V", "executeAction", "", "context", "Landroid/content/Context;", "actionName", "", ActionHandler.PARAMS, "Landroid/os/Bundle;", "responseCallback", "Lcom/samsung/android/sdk/bixby2/action/ResponseCallback;", "defaultResponseCallback", "getDefaultResponseCallback", "()Lcom/samsung/android/sdk/bixby2/action/ResponseCallback;", "BixbyActionCallback", "Companion", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BixbyActionHandler extends ActionHandler {

    @NotNull
    private static final String TAG = "BixbyActionHandler";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \f2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/action/BixbyActionHandler$BixbyActionCallback;", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/ActionResponseCallback;", "", "mResponseCallback", "Lcom/samsung/android/sdk/bixby2/action/ResponseCallback;", "<init>", "(Lcom/samsung/android/sdk/bixby2/action/ResponseCallback;)V", "onPreExecuteRequest", "", "onRequestComplete", "results", "onError", "Companion", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class BixbyActionCallback implements ActionResponseCallback<Object> {

        @NotNull
        private static final String TAG = "BixbyActionCallback";

        @NotNull
        private final ResponseCallback mResponseCallback;

        public BixbyActionCallback(@NotNull ResponseCallback mResponseCallback) {
            Intrinsics.checkNotNullParameter(mResponseCallback, "mResponseCallback");
            this.mResponseCallback = mResponseCallback;
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.aid.ActionResponseCallback
        public void onError() {
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.aid.ActionResponseCallback
        public void onPreExecuteRequest() {
        }

        @Override // com.samsung.android.support.notes.bixby.bixby2.aid.ActionResponseCallback
        public void onRequestComplete(@Nullable Object results) {
            if (results == null) {
                this.mResponseCallback.onComplete(null);
                return;
            }
            if (DeviceInfo.isEngMode()) {
                Logger.m8697d(TAG, "onRequestComplete" + results);
            }
            this.mResponseCallback.onComplete(results.toString());
        }
    }

    private final ResponseCallback getDefaultResponseCallback() {
        return new ResponseCallback() { // from class: com.samsung.android.support.notes.bixby.bixby2.action.BixbyActionHandler$defaultResponseCallback$1
            @Override // com.samsung.android.sdk.bixby2.action.ResponseCallback
            public void onComplete(String s) {
                Intrinsics.checkNotNullParameter(s, "s");
                Logger.m8697d("BixbyActionHandler", "Default ResponseCallback#" + s);
            }

            @Override // com.samsung.android.sdk.bixby2.action.ResponseCallback
            public void onComplete(String s, PendingIntent pendingIntent) {
                Intrinsics.checkNotNullParameter(s, "s");
                Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
                Logger.m8697d("BixbyActionHandler", "Default ResponseCallback#" + s + SQLKeyword.COMMA + pendingIntent);
            }
        };
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.samsung.android.sdk.bixby2.action.ActionHandler
    public void executeAction(@NotNull Context context, @NotNull String actionName, @NotNull Bundle params, @Nullable ResponseCallback responseCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        Intrinsics.checkNotNullParameter(params, "params");
        Logger.m8697d(TAG, "executeAction() - context/actionName/params : " + context + "/" + actionName + "/" + params);
        if (responseCallback == null) {
            responseCallback = getDefaultResponseCallback();
        }
        AbsBixby2Async.AsyncParam asyncParam = new AbsBixby2Async.AsyncParam(context, new BixbyActionCallback(responseCallback));
        switch (actionName.hashCode()) {
            case -1827542954:
                if (actionName.equals(Bixby2Constants.BixbyActions.ACTION_UPDATE_FOLDER)) {
                    new BixbyUpdateFolderAction(params, responseCallback).execute(asyncParam);
                    break;
                }
                break;
            case -1647344712:
                if (actionName.equals(Bixby2Constants.BixbyActions.ACTION_DELETE_FOLDER)) {
                    new BixbyDeleteFolderAction(params, responseCallback).execute(asyncParam);
                    break;
                }
                break;
            case -1328848452:
                if (actionName.equals(Bixby2Constants.BixbyActions.ACTION_DELETE)) {
                    new BixbyDeleteAction(params, responseCallback).execute(asyncParam);
                    break;
                }
                break;
            case -766987787:
                if (actionName.equals(Bixby2Constants.BixbyActions.ACTION_SEARCH_FOLDER)) {
                    new BixbySearchFolderAction(params, responseCallback).execute(asyncParam);
                    break;
                }
                break;
            case 369889852:
                if (actionName.equals(Bixby2Constants.BixbyActions.ACTION_SAVE)) {
                    new BixbySaveAction(params, responseCallback).execute(asyncParam);
                    break;
                }
                break;
            case 491060025:
                if (actionName.equals(Bixby2Constants.BixbyActions.ACTION_SEARCH)) {
                    new BixbySearchAction(params, responseCallback).execute(asyncParam);
                    break;
                }
                break;
            case 648486473:
                if (actionName.equals(Bixby2Constants.BixbyActions.ACTION_CREATE_FOLDER)) {
                    new BixbyCreateFolderAction(params, responseCallback).execute(asyncParam);
                    break;
                }
                break;
            case 737928380:
                if (actionName.equals(Bixby2Constants.BixbyActions.ACTION_DIAGNOSE_TROUBLE_SHOOTING)) {
                    new BixbyDiagnoseTroubleShooting(params, responseCallback).execute(asyncParam);
                    break;
                }
                break;
            case 905598426:
                if (actionName.equals(Bixby2Constants.BixbyActions.ACTION_UPDATE)) {
                    new BixbyUpdateAction(params, responseCallback).execute(asyncParam);
                    break;
                }
                break;
            case 1368909770:
                if (actionName.equals(Bixby2Constants.BixbyActions.ACTION_SHOW_RECENT_NOTESS)) {
                    new BixbyShowRecentNotes(params, responseCallback).execute(asyncParam);
                    break;
                }
                break;
            case 1533245650:
                if (actionName.equals(Bixby2Constants.BixbyActions.ACTION_IS_NOTES_EMPTY)) {
                    new BixbyIsNoteEmptyAction(params, responseCallback).execute(asyncParam);
                    break;
                }
                break;
            case 1832709831:
                if (actionName.equals(Bixby2Constants.BixbyActions.ACTION_GET_APP_STATE)) {
                    new BixbyGetAppStateAction(params, responseCallback).execute(asyncParam);
                    break;
                }
                break;
        }
    }
}
