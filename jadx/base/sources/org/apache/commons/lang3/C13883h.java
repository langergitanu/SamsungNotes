package org.apache.commons.lang3;

import com.samsung.android.app.notes.sync.network.InterfaceC6846k;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import java.util.function.Function;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.function.FailableBooleanSupplier;
import org.apache.commons.lang3.function.FailableFunction;
import org.apache.commons.lang3.function.FailableIntFunction;
import org.apache.commons.lang3.function.FailablePredicate;
import org.apache.commons.lang3.function.TriConsumer;
import org.apache.commons.lang3.function.TriFunction;
import p001A.AbstractC0000a;
import p003A1.C0012a;
import p086V.C0322h;
import p261z1.C14520a;
import p261z1.C14523d;

/* JADX INFO: renamed from: org.apache.commons.lang3.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13883h implements FailableIntFunction, FailableBooleanSupplier, Functions.FailableSupplier, Functions.FailableRunnable, TriConsumer, TriFunction, InterfaceC6846k {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9903a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f9904b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f9905c;

    public /* synthetic */ C13883h(Object obj, Object obj2, int i) {
        this.f9903a = i;
        this.f9904b = obj;
        this.f9905c = obj2;
    }

    @Override // com.samsung.android.app.notes.sync.network.InterfaceC6846k
    /* JADX INFO: renamed from: a */
    public void mo264a(int i) {
        switch (this.f9903a) {
            case 7:
                C14520a c14520a = (C14520a) this.f9904b;
                String str = (String) this.f9905c;
                C0012a c0012a = c14520a.f10356e;
                if (i == 0) {
                    C0322h.m670a().f829o.deleteCategorySync(c0012a.f262e, str);
                    if (!c0012a.f79t) {
                        c0012a.f79t = true;
                    }
                }
                break;
            case 8:
                C14523d c14523d = (C14523d) this.f9904b;
                String str2 = (String) this.f9905c;
                C0012a c0012a2 = c14523d.f10378e;
                AbstractC0000a.m17n(i, "onResponse - deleteFile = ", "SyncOldNote$SyncSDoc");
                if (i == 0) {
                    SyncState.removeDontSyncOldNote(str2);
                    C0322h.m670a().f831q.deleteSDocSync(c0012a2.f262e, str2, false, "OldLocal");
                    if (!c0012a2.f76q) {
                        c0012a2.f76q = true;
                    }
                    if (!c0012a2.f77r) {
                        c0012a2.f77r = true;
                    }
                    if (!c0012a2.f79t) {
                        c0012a2.f79t = true;
                    }
                }
                break;
            default:
                C14520a c14520a2 = (C14520a) this.f9904b;
                String str3 = (String) this.f9905c;
                if (i == 0) {
                    C0322h.m670a().f830p.deleteTagSync(str3);
                    C0012a c0012a3 = c14520a2.f10356e;
                    if (!c0012a3.f79t) {
                        c0012a3.f79t = true;
                    }
                }
                break;
        }
    }

    @Override // org.apache.commons.lang3.function.TriConsumer
    public void accept(Object obj, Object obj2, Object obj3) {
        ((TriConsumer) this.f9904b).lambda$andThen$0((TriConsumer) this.f9905c, obj, obj2, obj3);
    }

    @Override // org.apache.commons.lang3.function.FailableIntFunction
    public Object apply(int i) {
        return ArrayUtils.lambda$map$5((FailableFunction) this.f9904b, (Object[]) this.f9905c, i);
    }

    @Override // org.apache.commons.lang3.Functions.FailableSupplier
    public Object get() {
        return ((Functions.FailableFunction) this.f9904b).apply(this.f9905c);
    }

    @Override // org.apache.commons.lang3.function.FailableBooleanSupplier
    public boolean getAsBoolean() {
        switch (this.f9903a) {
            case 1:
                return ((Functions.FailablePredicate) this.f9904b).test(this.f9905c);
            default:
                return ((FailablePredicate) this.f9904b).test(this.f9905c);
        }
    }

    @Override // org.apache.commons.lang3.Functions.FailableRunnable
    public void run() {
        ((Functions.FailableConsumer) this.f9904b).accept(this.f9905c);
    }

    @Override // org.apache.commons.lang3.function.TriFunction
    public Object apply(Object obj, Object obj2, Object obj3) {
        return ((TriFunction) this.f9904b).lambda$andThen$0((Function) this.f9905c, obj, obj2, obj3);
    }
}
