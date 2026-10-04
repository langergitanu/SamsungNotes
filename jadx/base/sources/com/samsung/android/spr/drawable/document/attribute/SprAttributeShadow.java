package com.samsung.android.spr.drawable.document.attribute;

import com.samsung.android.spr.drawable.document.SprInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprAttributeShadow extends SprAttributeBase {

    /* JADX INFO: renamed from: dx */
    public float f5440dx;

    /* JADX INFO: renamed from: dy */
    public float f5441dy;
    public float radius;
    public int shadowColor;

    public SprAttributeShadow() {
        super(SprAttributeBase.TYPE_SHADOW);
        this.f5441dy = 0.0f;
        this.f5440dx = 0.0f;
        this.radius = 0.0f;
        this.shadowColor = 0;
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.SprAttributeBase
    public void fromSPR(SprInputStream sprInputStream) {
        this.radius = sprInputStream.readFloat();
        this.f5440dx = sprInputStream.readFloat();
        this.f5441dy = sprInputStream.readFloat();
        this.shadowColor = sprInputStream.readInt();
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.SprAttributeBase
    public int getSPRSize() {
        return 16;
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.SprAttributeBase
    public void toSPR(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeFloat(this.radius);
        dataOutputStream.writeFloat(this.f5440dx);
        dataOutputStream.writeFloat(this.f5441dy);
        dataOutputStream.writeInt(this.shadowColor);
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.SprAttributeBase
    /* JADX INFO: renamed from: clone */
    public SprAttributeShadow mo22166clone() {
        SprAttributeShadow sprAttributeShadow = (SprAttributeShadow) super.mo22166clone();
        sprAttributeShadow.radius = this.radius;
        sprAttributeShadow.f5440dx = this.f5440dx;
        sprAttributeShadow.f5441dy = this.f5441dy;
        sprAttributeShadow.shadowColor = this.shadowColor;
        return sprAttributeShadow;
    }

    public SprAttributeShadow(float f, float f4, float f5, int i) {
        super(SprAttributeBase.TYPE_SHADOW);
        this.radius = f;
        this.f5440dx = f4;
        this.f5441dy = f5;
        this.shadowColor = i;
    }

    public SprAttributeShadow(SprInputStream sprInputStream) {
        super(SprAttributeBase.TYPE_SHADOW);
        this.radius = 0.0f;
        this.f5440dx = 0.0f;
        this.f5441dy = 0.0f;
        this.shadowColor = 0;
        fromSPR(sprInputStream);
    }
}
