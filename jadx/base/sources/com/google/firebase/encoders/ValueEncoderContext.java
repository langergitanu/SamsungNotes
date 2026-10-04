package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface ValueEncoderContext {
    @NonNull
    ValueEncoderContext add(double d);

    @NonNull
    ValueEncoderContext add(float f);

    @NonNull
    ValueEncoderContext add(int i);

    @NonNull
    ValueEncoderContext add(long j);

    @NonNull
    ValueEncoderContext add(@Nullable String str);

    @NonNull
    ValueEncoderContext add(boolean z);

    @NonNull
    ValueEncoderContext add(@NonNull byte[] bArr);
}
