package com.samsung.android.spr.drawable.document.shape;

import android.graphics.Canvas;
import com.samsung.android.spr.drawable.document.SprDocument;
import com.samsung.android.spr.drawable.document.SprInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprObjectShapeLine extends SprObjectBase {

    /* JADX INFO: renamed from: x1 */
    public float f5452x1;

    /* JADX INFO: renamed from: x2 */
    public float f5453x2;

    /* JADX INFO: renamed from: y1 */
    public float f5454y1;

    /* JADX INFO: renamed from: y2 */
    public float f5455y2;

    public SprObjectShapeLine() {
        super((byte) 3);
        this.f5452x1 = 0.0f;
        this.f5453x2 = 0.0f;
        this.f5454y1 = 0.0f;
        this.f5455y2 = 0.0f;
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public void draw(SprDocument sprDocument, Canvas canvas, float f, float f4, float f5) {
        Canvas canvas2;
        canvas.save(31);
        float f6 = f5 * this.alpha;
        if (this.mAttributeList.size() > 0) {
            applyAttribute(sprDocument, canvas, f6);
        }
        setShadowLayer();
        if (this.isVisibleStroke) {
            canvas2 = canvas;
            canvas2.drawLine(this.f5452x1, this.f5454y1, this.f5453x2, this.f5455y2, this.strokePaint);
        } else {
            canvas2 = canvas;
        }
        clearShadowLayer();
        canvas2.restore();
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public void fromSPR(SprInputStream sprInputStream) throws IOException {
        this.f5452x1 = sprInputStream.readFloat();
        this.f5454y1 = sprInputStream.readFloat();
        this.f5453x2 = sprInputStream.readFloat();
        this.f5455y2 = sprInputStream.readFloat();
        super.fromSPR(sprInputStream);
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public int getSPRSize() {
        return super.getSPRSize() + 16;
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public int getTotalElementCount() {
        return 1;
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public int getTotalSegmentCount() {
        return 2;
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public void toSPR(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeFloat(this.f5452x1);
        dataOutputStream.writeFloat(this.f5454y1);
        dataOutputStream.writeFloat(this.f5453x2);
        dataOutputStream.writeFloat(this.f5455y2);
        super.toSPR(dataOutputStream);
    }

    public SprObjectShapeLine(SprInputStream sprInputStream) throws IOException {
        super((byte) 3);
        this.f5452x1 = 0.0f;
        this.f5453x2 = 0.0f;
        this.f5454y1 = 0.0f;
        this.f5455y2 = 0.0f;
        fromSPR(sprInputStream);
    }
}
