package com.samsung.android.spr.drawable.document.attribute;

import com.samsung.android.spr.drawable.document.SprInputStream;
import com.samsung.android.spr.drawable.document.attribute.impl.SprGradientBase;
import com.samsung.android.spr.drawable.document.attribute.impl.SprLinearGradient;
import com.samsung.android.spr.drawable.document.attribute.impl.SprRadialGradient;
import java.io.DataOutputStream;
import java.io.IOException;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class SprAttributeColor extends SprAttributeBase {
    public static final byte TYPE_ARGB = 1;
    public static final byte TYPE_LINEAR_GRADIENT = 3;
    public static final byte TYPE_LINK = 2;
    public static final byte TYPE_NONE = 0;
    public static final byte TYPE_RADIAL_GRADIENT = 4;
    public int color;
    public byte colorType;
    public SprGradientBase gradient;

    public SprAttributeColor(byte b) {
        super(b);
        this.gradient = null;
        this.colorType = (byte) 1;
        this.color = 0;
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.SprAttributeBase
    public void fromSPR(SprInputStream sprInputStream) throws IOException {
        byte b = sprInputStream.readByte();
        this.colorType = b;
        if (b == 0) {
            sprInputStream.readInt();
            return;
        }
        if (b == 1 || b == 2) {
            this.color = sprInputStream.readInt();
            return;
        }
        if (b == 3) {
            this.gradient = new SprLinearGradient(sprInputStream);
        } else if (b == 4) {
            this.gradient = new SprRadialGradient(sprInputStream);
        } else {
            throw new RuntimeException("unknown fill type:" + ((int) this.colorType));
        }
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.SprAttributeBase
    public int getSPRSize() {
        byte b = this.colorType;
        if (b == 0) {
            return 0;
        }
        if (b == 1 || b == 2) {
            return 5;
        }
        if (b == 3 || b == 4) {
            return this.gradient.getSPRSize() + 1;
        }
        throw new RuntimeException("unknown fill type:" + ((int) this.colorType));
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.SprAttributeBase
    public void toSPR(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.colorType);
        byte b = this.colorType;
        if (b == 0) {
            dataOutputStream.writeInt(0);
            return;
        }
        if (b == 1 || b == 2) {
            dataOutputStream.writeInt(this.color);
        } else if (b == 3 || b == 4) {
            this.gradient.toSPR(dataOutputStream);
        } else {
            throw new RuntimeException("unknown fill type:" + ((int) this.colorType));
        }
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.SprAttributeBase
    /* JADX INFO: renamed from: clone */
    public SprAttributeColor mo22166clone() {
        SprAttributeColor sprAttributeColor = (SprAttributeColor) super.mo22166clone();
        SprGradientBase sprGradientBase = this.gradient;
        if (sprGradientBase != null) {
            sprAttributeColor.gradient = sprGradientBase.m22167clone();
        }
        return sprAttributeColor;
    }

    public SprAttributeColor(byte b, byte b5, int i) {
        super(b);
        this.gradient = null;
        this.colorType = b5;
        if (b5 != 0) {
            if (b5 != 1 && b5 != 2) {
                throw new RuntimeException(AbstractC0000a.m11h(b5, "unexpected stroke type:"));
            }
            this.color = i;
        }
    }

    public SprAttributeColor(byte b, byte b5, SprGradientBase sprGradientBase) {
        super(b);
        this.gradient = null;
        this.colorType = b5;
        if (b5 != 0) {
            if (b5 != 3 && b5 != 4) {
                throw new RuntimeException(AbstractC0000a.m11h(b5, "unexpected stroke type:"));
            }
            this.gradient = sprGradientBase;
        }
    }

    public SprAttributeColor(byte b, SprInputStream sprInputStream) throws IOException {
        super(b);
        this.colorType = (byte) 1;
        this.gradient = null;
        fromSPR(sprInputStream);
    }
}
