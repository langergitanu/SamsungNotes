package androidx.core.view;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public interface NestedScrollingChild2 extends NestedScrollingChild {
    boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i4);

    boolean dispatchNestedScroll(int i, int i2, int i4, int i5, int[] iArr, int i6);

    boolean hasNestedScrollingParent(int i);

    boolean startNestedScroll(int i, int i2);

    void stopNestedScroll(int i);
}
