package com.samsung.android.spr.drawable.document.animator;

import android.animation.ArgbEvaluator;
import com.samsung.android.spr.drawable.document.SprInputStream;
import com.samsung.android.spr.drawable.document.animator.SprAnimatorBase;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprAnimatorStrokeColor extends SprAnimatorBase {
    private int from;

    /* JADX INFO: renamed from: to */
    private int f5439to;

    public SprAnimatorStrokeColor() {
        super((byte) 4);
    }

    private void init() {
        setIntValues(this.from, this.f5439to);
        setEvaluator(new ArgbEvaluator());
    }

    @Override // com.samsung.android.spr.drawable.document.animator.SprAnimatorBase
    public void fromSPR(SprInputStream sprInputStream) throws IOException {
        super.fromSPR(sprInputStream);
        this.from = sprInputStream.readInt();
        this.f5439to = sprInputStream.readInt();
    }

    @Override // com.samsung.android.spr.drawable.document.animator.SprAnimatorBase
    public int getSPRSize() {
        return super.getSPRSize() + 8;
    }

    public void set(int i, int i2) {
        this.from = i;
        this.f5439to = i2;
        init();
    }

    @Override // com.samsung.android.spr.drawable.document.animator.SprAnimatorBase
    public void toSPR(DataOutputStream dataOutputStream) throws IOException {
        super.toSPR(dataOutputStream);
        dataOutputStream.writeInt(this.from);
        dataOutputStream.writeInt(this.f5439to);
    }

    @Override // com.samsung.android.spr.drawable.document.animator.SprAnimatorBase
    public boolean updateValues(SprAnimatorBase.UpdateParameter updateParameter) {
        updateParameter.isUpdatedStrokeColor = true;
        if (updateParameter.isLastFrame) {
            updateParameter.strokeColor = this.f5439to;
        } else {
            updateParameter.strokeColor = ((Integer) getAnimatedValue()).intValue();
        }
        return true;
    }

    public SprAnimatorStrokeColor(SprInputStream sprInputStream) throws IOException {
        super((byte) 4);
        fromSPR(sprInputStream);
        init();
    }
}
