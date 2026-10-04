package androidx.recyclerview.sesl.drawable;

import androidx.annotation.RestrictTo;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\b\u001a\u00020\tH&R\u0018\u0010\u0003\u001a\u00028\u0000X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, m13886d2 = {"Landroidx/recyclerview/sesl/drawable/SeslAutowiredDrawable;", "T", "", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "invalidateSelf", "", "recyclerview_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public interface SeslAutowiredDrawable<T> {
    T getValue();

    void invalidateSelf();

    void setValue(T t);
}
