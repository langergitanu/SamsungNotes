package androidx.constraintlayout.core.widgets;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class Rectangle {
    public int height;
    public int width;

    /* JADX INFO: renamed from: x */
    public int f1241x;

    /* JADX INFO: renamed from: y */
    public int f1242y;

    public boolean contains(int i, int i2) {
        int i4;
        int i5 = this.f1241x;
        return i >= i5 && i < i5 + this.width && i2 >= (i4 = this.f1242y) && i2 < i4 + this.height;
    }

    public int getCenterX() {
        return (this.f1241x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f1242y + this.height) / 2;
    }

    public void grow(int i, int i2) {
        this.f1241x -= i;
        this.f1242y -= i2;
        this.width = (i * 2) + this.width;
        this.height = (i2 * 2) + this.height;
    }

    public boolean intersects(Rectangle rectangle) {
        int i;
        int i2;
        int i4 = this.f1241x;
        int i5 = rectangle.f1241x;
        return i4 >= i5 && i4 < i5 + rectangle.width && (i = this.f1242y) >= (i2 = rectangle.f1242y) && i < i2 + rectangle.height;
    }

    public void setBounds(int i, int i2, int i4, int i5) {
        this.f1241x = i;
        this.f1242y = i2;
        this.width = i4;
        this.height = i5;
    }
}
