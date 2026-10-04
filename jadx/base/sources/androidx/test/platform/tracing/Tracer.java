package androidx.test.platform.tracing;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.errorprone.annotations.MustBeClosed;
import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface Tracer {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Span extends Closeable {
        @NonNull
        @MustBeClosed
        Span beginChildSpan(@NonNull String str);

        @Override // java.io.Closeable, java.lang.AutoCloseable
        void close();
    }

    @NonNull
    @MustBeClosed
    Span beginSpan(@NonNull String str);
}
