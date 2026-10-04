package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class TransitionValues {

    @SuppressLint({"UnknownNullness"})
    public View view;
    public final Map<String, Object> values = new HashMap();
    final ArrayList<Transition> mTargetedTransitions = new ArrayList<>();

    @Deprecated
    public TransitionValues() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        return this.view == transitionValues.view && this.values.equals(transitionValues.values);
    }

    public int hashCode() {
        return this.values.hashCode() + (this.view.hashCode() * 31);
    }

    @NonNull
    public String toString() {
        StringBuilder sbM781w = AbstractC0541b.m781w("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        sbM781w.append(this.view);
        sbM781w.append("\n");
        String strM756B = AbstractC0541b.m756B(sbM781w.toString(), "    values:");
        for (String str : this.values.keySet()) {
            strM756B = strM756B + "    " + str + ": " + this.values.get(str) + "\n";
        }
        return strM756B;
    }

    public TransitionValues(@NonNull View view) {
        this.view = view;
    }
}
