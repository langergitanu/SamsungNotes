package com.samsung.android.spr.drawable.document.shape;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.samsung.android.spr.drawable.document.SprDocument;
import com.samsung.android.spr.drawable.document.SprInputStream;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeShadow;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprObjectShapeUse extends SprObjectBase {
    public int link;

    public SprObjectShapeUse() {
        super((byte) 17);
        this.link = 0;
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public void draw(SprDocument sprDocument, Canvas canvas, float f, float f4, float f5) {
        Canvas canvas2;
        canvas.save(31);
        float f6 = f5 * this.alpha;
        if (this.mAttributeList.size() > 0) {
            applyAttribute(sprDocument, canvas, f6);
        }
        SprObjectBase reference = sprDocument.getReference(this.link);
        if (reference != null) {
            canvas2 = canvas;
            reference.draw(sprDocument, canvas2, f, f4, f6);
        } else {
            canvas2 = canvas;
        }
        canvas2.restore();
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public void fromSPR(SprInputStream sprInputStream) throws IOException {
        this.link = sprInputStream.readInt();
        super.fromSPR(sprInputStream);
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public int getSPRSize() {
        return super.getSPRSize() + 4;
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public int getTotalElementCount() {
        return 1;
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public int getTotalSegmentCount() {
        return 1;
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public void preDraw(SprDocument sprDocument, Paint paint, Paint paint2, boolean z, boolean z2, SprAttributeShadow sprAttributeShadow) {
        SprObjectBase reference = sprDocument.getReference(this.link);
        if (reference != null) {
            reference.preDraw(sprDocument, paint, paint2, z, z2, sprAttributeShadow);
        }
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public void toSPR(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.link);
        super.toSPR(dataOutputStream);
    }

    public SprObjectShapeUse(SprInputStream sprInputStream) throws IOException {
        super((byte) 17);
        this.link = 0;
        fromSPR(sprInputStream);
    }
}
