package com.samsung.android.support.senl.p148nt.base.composer.text.span;

import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsStoredIntegerSpan extends AbsIntegerSpan {
    protected static final int NOT_STORED = -1;
    protected String preferenceKey;
    protected String preferenceName;
    SharedPreferencesCompat sharedPreferencesCompat;

    public AbsStoredIntegerSpan(String str, String str2, int i) {
        super(i);
        this.preferenceName = str;
        this.preferenceKey = str2;
        this.sharedPreferencesCompat = SharedPreferencesCompat.getInstance(str);
    }

    public int getStoredSpan() {
        int i = SharedPreferencesCompat.getInstance(this.preferenceName).getInt(this.preferenceKey, -1);
        if (i != -1) {
            return i;
        }
        throw new NoSuchElementException("Not stored value");
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsIntegerSpan
    public /* bridge */ /* synthetic */ int getType() {
        return super.getType();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsIntegerSpan
    public int getValue() {
        try {
            return getStoredSpan();
        } catch (Exception unused) {
            return super.getValue();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsSpan
    public /* bridge */ /* synthetic */ boolean isEnable() {
        return super.isEnable();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsSpan
    public /* bridge */ /* synthetic */ void setEnable(boolean z) {
        super.setEnable(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsIntegerSpan
    public void setValue(int i) {
        super.setValue(i);
        storeSpan(i);
    }

    public void storeSpan(int i) {
        this.sharedPreferencesCompat.putInt(this.preferenceKey, i);
    }

    public static int getStoredSpan(String str, String str2) {
        int i = SharedPreferencesCompat.getInstance(str).getInt(str2, -1);
        if (i != -1) {
            return i;
        }
        throw new NoSuchElementException("Not stored value");
    }
}
