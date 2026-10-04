package com.samsung.android.spr.drawable.document.shape;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.samsung.android.spr.drawable.document.SprDocument;
import com.samsung.android.spr.drawable.document.SprInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprObjectShapeRectangle extends SprObjectBase {
    public float bottom;
    public float left;
    public float right;

    /* JADX INFO: renamed from: rx */
    public float f5462rx;

    /* JADX INFO: renamed from: ry */
    public float f5463ry;
    public float top;

    public SprObjectShapeRectangle() {
        super((byte) 5);
        this.left = 0.0f;
        this.top = 0.0f;
        this.right = 0.0f;
        this.bottom = 0.0f;
        this.f5462rx = 0.0f;
        this.f5463ry = 0.0f;
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public void draw(SprDocument sprDocument, Canvas canvas, float f, float f4, float f5) {
        canvas.save(31);
        float f6 = f5 * this.alpha;
        if (this.mAttributeList.size() > 0) {
            applyAttribute(sprDocument, canvas, f6);
        }
        RectF rectF = new RectF(this.left, this.top, this.right, this.bottom);
        setShadowLayer();
        float f7 = this.f5462rx;
        if (f7 == 0.0f && this.f5463ry == 0.0f) {
            if (this.isVisibleFill) {
                canvas.drawRect(rectF, this.fillPaint);
            }
            if (this.isVisibleStroke) {
                canvas.drawRect(rectF, this.strokePaint);
            }
        } else {
            if (this.isVisibleFill) {
                canvas.drawRoundRect(rectF, f7, this.f5463ry, this.fillPaint);
            }
            if (this.isVisibleStroke) {
                canvas.drawRoundRect(rectF, this.f5462rx, this.f5463ry, this.strokePaint);
            }
        }
        clearShadowLayer();
        canvas.restore();
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public void fromSPR(SprInputStream sprInputStream) throws IOException {
        this.left = sprInputStream.readFloat();
        this.top = sprInputStream.readFloat();
        this.right = sprInputStream.readFloat();
        this.bottom = sprInputStream.readFloat();
        this.f5462rx = sprInputStream.readFloat();
        this.f5463ry = sprInputStream.readFloat();
        super.fromSPR(sprInputStream);
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public int getSPRSize() {
        return super.getSPRSize() + 24;
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public int getTotalElementCount() {
        return 1;
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public int getTotalSegmentCount() {
        return (this.f5462rx == 0.0f && this.f5463ry == 0.0f) ? 4 : 8;
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public void toSPR(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeFloat(this.left);
        dataOutputStream.writeFloat(this.top);
        dataOutputStream.writeFloat(this.right);
        dataOutputStream.writeFloat(this.bottom);
        dataOutputStream.writeFloat(this.f5462rx);
        dataOutputStream.writeFloat(this.f5463ry);
        super.toSPR(dataOutputStream);
    }

    public SprObjectShapeRectangle(float f, float f4, float f5, float f6) {
        super((byte) 5);
        this.f5462rx = 0.0f;
        this.f5463ry = 0.0f;
        this.left = f;
        this.top = f4;
        this.right = f5;
        this.bottom = f6;
    }

    public SprObjectShapeRectangle(SprInputStream sprInputStream) throws IOException {
        super((byte) 5);
        this.left = 0.0f;
        this.top = 0.0f;
        this.right = 0.0f;
        this.bottom = 0.0f;
        this.f5462rx = 0.0f;
        this.f5463ry = 0.0f;
        fromSPR(sprInputStream);
    }
}
