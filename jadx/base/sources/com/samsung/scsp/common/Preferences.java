package com.samsung.scsp.common;

import android.content.SharedPreferences;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Preferences {
    final SharedPreferences sharedPreferences;

    public Preferences(String str) {
        this.sharedPreferences = ContextFactory.getBaseContext().getSharedPreferences(str, 0);
    }

    public void clear() {
        this.sharedPreferences.edit().clear().apply();
    }
}
