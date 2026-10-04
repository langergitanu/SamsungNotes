package com.bumptech.glide.request.target;

import androidx.annotation.NonNull;
import androidx.glance.AbstractC2821a;
import com.bumptech.glide.util.Util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public abstract class SimpleTarget<Z> extends BaseTarget<Z> {
    private final int height;
    private final int width;

    public SimpleTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        if (Util.isValidDimensions(this.width, this.height)) {
            sizeReadyCallback.onSizeReady(this.width, this.height);
            return;
        }
        StringBuilder sb = new StringBuilder("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
        sb.append(this.width);
        sb.append(" and height: ");
        throw new IllegalArgumentException(AbstractC2821a.m2223n(sb, ", either provide dimensions in the constructor or call override()", this.height));
    }

    public SimpleTarget(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
    }
}
