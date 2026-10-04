package com.samsung.android.spr.drawable.document.fileAttribute;

import com.samsung.android.spr.drawable.document.SprInputStream;
import java.io.DataOutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class SprFileAttributeBase implements Cloneable {
    public static final byte TYPE_NINE_PATCH = 1;
    public static final byte TYPE_NONE = 0;
    protected final SprFileAttributeBase mIntrinsic = this;
    public final byte mType;

    public SprFileAttributeBase(byte b) {
        this.mType = b;
    }

    public abstract void fromSPR(SprInputStream sprInputStream);

    public int getSPRSize() {
        return 0;
    }

    public boolean isValid() {
        return false;
    }

    public abstract void toSPR(DataOutputStream dataOutputStream);

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SprFileAttributeBase m22168clone() {
        return (SprFileAttributeBase) super.clone();
    }
}
