package com.samsung.android.spr.drawable.document.animator;

import com.samsung.android.spr.drawable.document.SprInputStream;
import com.samsung.android.spr.drawable.document.animator.SprAnimatorBase;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprAnimatorRotate extends SprAnimatorBase {
    private float from;
    private float pivotX;
    private float pivotY;

    /* JADX INFO: renamed from: to */
    private float f5438to;

    public SprAnimatorRotate() {
        super((byte) 3);
    }

    private void init() {
        setFloatValues(this.from, this.f5438to);
    }

    @Override // com.samsung.android.spr.drawable.document.animator.SprAnimatorBase
    public void fromSPR(SprInputStream sprInputStream) throws IOException {
        super.fromSPR(sprInputStream);
        this.pivotX = sprInputStream.readFloat();
        this.pivotY = sprInputStream.readFloat();
        this.from = sprInputStream.readFloat();
        this.f5438to = sprInputStream.readFloat();
    }

    @Override // com.samsung.android.spr.drawable.document.animator.SprAnimatorBase
    public int getSPRSize() {
        return super.getSPRSize() + 16;
    }

    public void set(float f, float f4, float f5, float f6) {
        this.from = f;
        this.f5438to = f4;
        this.pivotX = f5;
        this.pivotY = f6;
        init();
    }

    @Override // com.samsung.android.spr.drawable.document.animator.SprAnimatorBase
    public void toSPR(DataOutputStream dataOutputStream) throws IOException {
        super.toSPR(dataOutputStream);
        dataOutputStream.writeFloat(this.pivotX);
        dataOutputStream.writeFloat(this.pivotY);
        dataOutputStream.writeFloat(this.from);
        dataOutputStream.writeFloat(this.f5438to);
    }

    @Override // com.samsung.android.spr.drawable.document.animator.SprAnimatorBase
    public boolean updateValues(SprAnimatorBase.UpdateParameter updateParameter) {
        updateParameter.isUpdatedRotate = true;
        updateParameter.rotatePivotX = this.pivotX;
        updateParameter.rotatePivotY = this.pivotY;
        if (updateParameter.isLastFrame) {
            updateParameter.rotateDegree = this.f5438to;
            return false;
        }
        updateParameter.rotateDegree = ((Float) getAnimatedValue()).floatValue();
        return false;
    }

    public SprAnimatorRotate(SprInputStream sprInputStream) throws IOException {
        super((byte) 3);
        fromSPR(sprInputStream);
        init();
    }
}
