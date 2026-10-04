package androidx.databinding;

import androidx.annotation.Nullable;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class ObservableField<T> extends BaseObservableField implements Serializable {
    static final long serialVersionUID = 1;
    private T mValue;

    public ObservableField(T t) {
        this.mValue = t;
    }

    @Nullable
    public T get() {
        return this.mValue;
    }

    public void set(T t) {
        if (t != this.mValue) {
            this.mValue = t;
            notifyChange();
        }
    }

    public ObservableField() {
    }

    public ObservableField(Observable... observableArr) {
        super(observableArr);
    }
}
