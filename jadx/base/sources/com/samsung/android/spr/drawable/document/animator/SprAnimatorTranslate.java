package com.samsung.android.spr.drawable.document.animator;

import android.animation.PropertyValuesHolder;
import com.samsung.android.spr.drawable.document.SprInputStream;
import com.samsung.android.spr.drawable.document.animator.SprAnimatorBase;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprAnimatorTranslate extends SprAnimatorBase {
    private float fromX;
    private float fromY;
    private float toX;
    private float toY;

    public SprAnimatorTranslate() {
        super((byte) 1);
    }

    private void init() {
        setValues(PropertyValuesHolder.ofFloat("x", this.fromX, this.toX), PropertyValuesHolder.ofFloat("y", this.fromY, this.toY));
    }

    @Override // com.samsung.android.spr.drawable.document.animator.SprAnimatorBase
    public void fromSPR(SprInputStream sprInputStream) throws IOException {
        super.fromSPR(sprInputStream);
        this.fromX = sprInputStream.readFloat();
        this.fromY = sprInputStream.readFloat();
        this.toX = sprInputStream.readFloat();
        this.toY = sprInputStream.readFloat();
    }

    @Override // com.samsung.android.spr.drawable.document.animator.SprAnimatorBase
    public int getSPRSize() {
        return super.getSPRSize() + 16;
    }

    public void set(float f, float f4, float f5, float f6) {
        this.fromX = f;
        this.fromY = f4;
        this.toX = f5;
        this.toY = f6;
        init();
    }

    @Override // com.samsung.android.spr.drawable.document.animator.SprAnimatorBase
    public void toSPR(DataOutputStream dataOutputStream) throws IOException {
        super.toSPR(dataOutputStream);
        dataOutputStream.writeFloat(this.fromX);
        dataOutputStream.writeFloat(this.fromY);
        dataOutputStream.writeFloat(this.toX);
        dataOutputStream.writeFloat(this.toY);
    }

    @Override // com.samsung.android.spr.drawable.document.animator.SprAnimatorBase
    public boolean updateValues(SprAnimatorBase.UpdateParameter updateParameter) {
        updateParameter.isUpdatedTranslate = true;
        if (updateParameter.isLastFrame) {
            updateParameter.translateDx = this.toX;
            updateParameter.translateDy = this.toY;
            return false;
        }
        updateParameter.translateDx = ((Float) getAnimatedValue("x")).floatValue();
        updateParameter.translateDy = ((Float) getAnimatedValue("y")).floatValue();
        return false;
    }

    public SprAnimatorTranslate(SprInputStream sprInputStream) throws IOException {
        super((byte) 1);
        fromSPR(sprInputStream);
        init();
    }
}
