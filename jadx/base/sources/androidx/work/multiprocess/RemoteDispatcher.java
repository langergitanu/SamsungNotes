package androidx.work.multiprocess;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"LambdaLast"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface RemoteDispatcher<T> {
    void execute(@NonNull T t, @NonNull IWorkManagerImplCallback iWorkManagerImplCallback);
}
