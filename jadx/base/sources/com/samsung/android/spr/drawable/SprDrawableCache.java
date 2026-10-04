package com.samsung.android.spr.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class SprDrawableCache {
    private SparseArray<WeakReference<Drawable.ConstantState>> mCache = new SparseArray<>();

    public SprDrawableCache(Resources resources) {
    }

    public Drawable.ConstantState get(int i) {
        synchronized (this) {
            try {
                WeakReference<Drawable.ConstantState> weakReference = this.mCache.get(i);
                if (weakReference == null) {
                    return null;
                }
                return weakReference.get();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Drawable getInstance(int i) {
        Drawable.ConstantState constantState = get(i);
        if (constantState != null) {
            return constantState.newDrawable();
        }
        return null;
    }

    public void put(int i, Drawable.ConstantState constantState) {
        if (constantState == null) {
            return;
        }
        synchronized (this) {
            this.mCache.put(i, new WeakReference<>(constantState));
        }
    }
}
