package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public interface GcsImpl {
    void onActivityResult(int i, int i2, @Nullable Intent intent);

    void onNewNote(String str, int i);

    void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);
}
