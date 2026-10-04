package com.samsung.android.spr.drawable.document.shape;

import android.graphics.Canvas;
import com.samsung.android.spr.drawable.document.SprDocument;
import com.samsung.android.spr.drawable.document.SprInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprObjectShapeCircle extends SprObjectBase {

    /* JADX INFO: renamed from: cr */
    public float f5449cr;

    /* JADX INFO: renamed from: cx */
    public float f5450cx;

    /* JADX INFO: renamed from: cy */
    public float f5451cy;

    public SprObjectShapeCircle() {
        super((byte) 1);
        this.f5450cx = 0.0f;
        this.f5451cy = 0.0f;
        this.f5449cr = 0.0f;
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public void draw(SprDocument sprDocument, Canvas canvas, float f, float f4, float f5) {
        canvas.save(31);
        float f6 = f5 * this.alpha;
        if (this.mAttributeList.size() > 0) {
            applyAttribute(sprDocument, canvas, f6);
        }
        setShadowLayer();
        if (this.isVisibleFill) {
            canvas.drawCircle(this.f5450cx, this.f5451cy, this.f5449cr, this.fillPaint);
        }
        if (this.isVisibleStroke) {
            canvas.drawCircle(this.f5450cx, this.f5451cy, this.f5449cr, this.strokePaint);
        }
        clearShadowLayer();
        canvas.restore();
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public void fromSPR(SprInputStream sprInputStream) throws IOException {
        this.f5450cx = sprInputStream.readFloat();
        this.f5451cy = sprInputStream.readFloat();
        this.f5449cr = sprInputStream.readFloat();
        super.fromSPR(sprInputStream);
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public int getSPRSize() {
        return super.getSPRSize() + 12;
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public int getTotalElementCount() {
        return 1;
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public int getTotalSegmentCount() {
        return 4;
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public void toSPR(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeFloat(this.f5450cx);
        dataOutputStream.writeFloat(this.f5451cy);
        dataOutputStream.writeFloat(this.f5449cr);
        super.toSPR(dataOutputStream);
    }

    public SprObjectShapeCircle(SprInputStream sprInputStream) throws IOException {
        super((byte) 1);
        this.f5450cx = 0.0f;
        this.f5451cy = 0.0f;
        this.f5449cr = 0.0f;
        fromSPR(sprInputStream);
    }
}
