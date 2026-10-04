package io.opentelemetry.context;

import com.google.errorprone.annotations.MustBeClosed;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface ImplicitContextKeyed {
    @MustBeClosed
    default Scope makeCurrent() {
        return Context.current().with(this).makeCurrent();
    }

    Context storeInContext(Context context);
}
