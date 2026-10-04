package com.samsung.android.vexfwk.metadata;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/IVexFwkMetadataConverter;", "T", "", Constants.MessagePayloadKeys.FROM, "data", "", "([B)Ljava/lang/Object;", "to", "value", "(Ljava/lang/Object;)[B", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public interface IVexFwkMetadataConverter<T> {
    T from(@NotNull byte[] data);

    @NotNull
    /* JADX INFO: renamed from: to */
    byte[] mo12821to(T value);
}
