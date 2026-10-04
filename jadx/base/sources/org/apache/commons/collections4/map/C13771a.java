package org.apache.commons.collections4.map;

import java.util.ArrayList;
import java.util.function.Consumer;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.text.translate.CharSequenceTranslator;

/* JADX INFO: renamed from: org.apache.commons.collections4.map.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13771a implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9750a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ArrayList f9751b;

    public /* synthetic */ C13771a(ArrayList arrayList, int i) {
        this.f9750a = i;
        this.f9751b = arrayList;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f9750a) {
            case 0:
                this.f9751b.add(obj);
                break;
            case 1:
                ClassUtils.lambda$convertClassNamesToClasses$3(this.f9751b, (String) obj);
                break;
            default:
                this.f9751b.add((CharSequenceTranslator) obj);
                break;
        }
    }
}
