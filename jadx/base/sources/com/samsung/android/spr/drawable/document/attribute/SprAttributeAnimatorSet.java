package com.samsung.android.spr.drawable.document.attribute;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import com.samsung.android.spr.drawable.document.SprInputStream;
import com.samsung.android.spr.drawable.document.animator.SprAnimatorAlpha;
import com.samsung.android.spr.drawable.document.animator.SprAnimatorBase;
import com.samsung.android.spr.drawable.document.animator.SprAnimatorFillColor;
import com.samsung.android.spr.drawable.document.animator.SprAnimatorRotate;
import com.samsung.android.spr.drawable.document.animator.SprAnimatorScale;
import com.samsung.android.spr.drawable.document.animator.SprAnimatorStrokeColor;
import com.samsung.android.spr.drawable.document.animator.SprAnimatorTranslate;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprAttributeAnimatorSet extends SprAttributeBase {
    public int duration;
    private ArrayList<Animator> mAnimators;
    public int repeatCount;
    public int startOffset;

    public SprAttributeAnimatorSet(byte b) {
        super(SprAttributeBase.TYPE_ANIMATOR_SET);
        this.mAnimators = new ArrayList<>();
    }

    public void addAnimatorData(SprAnimatorBase sprAnimatorBase) {
        this.mAnimators.add(sprAnimatorBase.clone());
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.SprAttributeBase
    public void fromSPR(SprInputStream sprInputStream) throws IOException {
        this.startOffset = sprInputStream.readInt();
        this.duration = sprInputStream.readInt();
        this.repeatCount = sprInputStream.readInt();
        int i = sprInputStream.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            byte b = sprInputStream.readByte();
            int i4 = sprInputStream.readInt();
            switch (b) {
                case 1:
                    this.mAnimators.add(new SprAnimatorTranslate(sprInputStream));
                    break;
                case 2:
                    this.mAnimators.add(new SprAnimatorScale(sprInputStream));
                    break;
                case 3:
                    this.mAnimators.add(new SprAnimatorRotate(sprInputStream));
                    break;
                case 4:
                    this.mAnimators.add(new SprAnimatorStrokeColor(sprInputStream));
                    break;
                case 5:
                    this.mAnimators.add(new SprAnimatorFillColor(sprInputStream));
                    break;
                case 6:
                    this.mAnimators.add(new SprAnimatorAlpha(sprInputStream));
                    break;
                default:
                    sprInputStream.skip(i4);
                    break;
            }
        }
    }

    public ArrayList<Animator> getAnimators() {
        return this.mAnimators;
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.SprAttributeBase
    public int getSPRSize() {
        Iterator<Animator> it = this.mAnimators.iterator();
        int sPRSize = 16;
        while (it.hasNext()) {
            sPRSize += ((SprAnimatorBase) it.next()).getSPRSize() + 5;
        }
        return sPRSize;
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.SprAttributeBase
    public void toSPR(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.startOffset);
        dataOutputStream.writeInt(this.duration);
        dataOutputStream.writeInt(this.repeatCount);
        dataOutputStream.writeInt(this.mAnimators.size());
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            SprAnimatorBase sprAnimatorBase = (SprAnimatorBase) it.next();
            dataOutputStream.writeByte(sprAnimatorBase.mType);
            dataOutputStream.writeInt(sprAnimatorBase.getSPRSize());
            sprAnimatorBase.toSPR(dataOutputStream);
        }
    }

    public void updateAnimatorInterpolator(TimeInterpolator timeInterpolator) {
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            it.next().setInterpolator(timeInterpolator);
        }
    }

    public SprAttributeAnimatorSet(SprInputStream sprInputStream) throws IOException {
        super(SprAttributeBase.TYPE_ANIMATOR_SET);
        this.mAnimators = new ArrayList<>();
        fromSPR(sprInputStream);
    }

    @Override // com.samsung.android.spr.drawable.document.attribute.SprAttributeBase
    /* JADX INFO: renamed from: clone */
    public SprAttributeAnimatorSet mo22166clone() {
        SprAttributeAnimatorSet sprAttributeAnimatorSet = (SprAttributeAnimatorSet) super.mo22166clone();
        sprAttributeAnimatorSet.mAnimators = new ArrayList<>();
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            sprAttributeAnimatorSet.mAnimators.add(it.next().clone());
        }
        return sprAttributeAnimatorSet;
    }
}
