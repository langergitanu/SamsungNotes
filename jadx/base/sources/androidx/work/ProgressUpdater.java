package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public interface ProgressUpdater {
    @NonNull
    ListenableFuture<Void> updateProgress(@NonNull Context context, @NonNull UUID uuid, @NonNull Data data);
}
