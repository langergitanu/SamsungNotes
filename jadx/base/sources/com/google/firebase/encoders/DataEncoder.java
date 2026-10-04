package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface DataEncoder {
    @NonNull
    String encode(@NonNull Object obj);

    void encode(@NonNull Object obj, @NonNull Writer writer);
}
