package com.samsung.android.spr.drawable.document.animator;

import com.samsung.android.spr.drawable.document.SprInputStream;
import com.samsung.android.spr.drawable.document.animator.SprAnimatorBase;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprAnimatorAlpha extends SprAnimatorBase {
    private float from;

    /* JADX INFO: renamed from: to */
    private float f5436to;

    public SprAnimatorAlpha() {
        super((byte) 6);
        this.from = 0.0f;
        this.f5436to = 0.0f;
    }

    private void init() {
        float f = this.from;
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.from = f;
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.from = f;
        float f4 = this.f5436to;
        float f5 = f4 >= 0.0f ? f4 : 0.0f;
        this.f5436to = f5;
        float f6 = f5 <= 1.0f ? f5 : 1.0f;
        this.f5436to = f6;
        setFloatValues(f, f6);
    }

    @Override // com.samsung.android.spr.drawable.document.animator.SprAnimatorBase
    public void fromSPR(SprInputStream sprInputStream) throws IOException {
        super.fromSPR(sprInputStream);
        this.from = sprInputStream.readFloat();
        this.f5436to = sprInputStream.readFloat();
    }

    @Override // com.samsung.android.spr.drawable.document.animator.SprAnimatorBase
    public int getSPRSize() {
        return super.getSPRSize() + 8;
    }

    public void set(float f, float f4) {
        this.from = f;
        this.f5436to = f4;
        init();
    }

    @Override // com.samsung.android.spr.drawable.document.animator.SprAnimatorBase
    public void toSPR(DataOutputStream dataOutputStream) throws IOException {
        super.toSPR(dataOutputStream);
        float f = this.from;
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.from = f;
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.from = f;
        float f4 = this.f5436to;
        float f5 = f4 >= 0.0f ? f4 : 0.0f;
        this.f5436to = f5;
        this.f5436to = f5 <= 1.0f ? f5 : 1.0f;
        dataOutputStream.writeFloat(f);
        dataOutputStream.writeFloat(this.f5436to);
    }

    @Override // com.samsung.android.spr.drawable.document.animator.SprAnimatorBase
    public boolean updateValues(SprAnimatorBase.UpdateParameter updateParameter) {
        if (updateParameter.isLastFrame) {
            updateParameter.alpha = this.f5436to;
            return false;
        }
        updateParameter.alpha = ((Float) getAnimatedValue()).floatValue();
        return false;
    }

    public SprAnimatorAlpha(SprInputStream sprInputStream) throws IOException {
        super((byte) 6);
        this.from = 0.0f;
        this.f5436to = 0.0f;
        fromSPR(sprInputStream);
        init();
    }
}
