package com.microsoft.identity.common.java.commands;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class EmptyCommandCallback<T, U> implements CommandCallback<T, U> {
    @Override // com.microsoft.identity.common.java.commands.CommandCallback
    public void onCancel() {
    }

    @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
    public void onError(U u) {
    }

    @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
    public void onTaskCompleted(T t) {
    }
}
