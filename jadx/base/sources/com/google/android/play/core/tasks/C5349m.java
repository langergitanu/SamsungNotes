package com.google.android.play.core.tasks;

import androidx.annotation.Nullable;
import com.google.android.play.core.internal.C5173av;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.google.android.play.core.tasks.m */
/* JADX INFO: loaded from: classes5.dex */
final class C5349m<ResultT> extends Task<ResultT> {

    /* JADX INFO: renamed from: a */
    private final Object f3240a = new Object();

    /* JADX INFO: renamed from: b */
    private final C5344h<ResultT> f3241b = new C5344h<>();

    /* JADX INFO: renamed from: c */
    private boolean f3242c;

    /* JADX INFO: renamed from: d */
    private ResultT f3243d;

    /* JADX INFO: renamed from: e */
    private Exception f3244e;

    /* JADX INFO: renamed from: a */
    private final void m4202a() {
        C5173av.m3913a(this.f3242c, "Task is not yet complete");
    }

    /* JADX INFO: renamed from: b */
    private final void m4203b() {
        C5173av.m3913a(!this.f3242c, "Task is already complete");
    }

    /* JADX INFO: renamed from: c */
    private final void m4204c() {
        synchronized (this.f3240a) {
            try {
                if (this.f3242c) {
                    this.f3241b.m4195a(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.play.core.tasks.Task
    public final Task<ResultT> addOnCompleteListener(OnCompleteListener<ResultT> onCompleteListener) {
        this.f3241b.m4196a(new C5338b(TaskExecutors.MAIN_THREAD, onCompleteListener));
        m4204c();
        return this;
    }

    @Override // com.google.android.play.core.tasks.Task
    public final Task<ResultT> addOnFailureListener(OnFailureListener onFailureListener) {
        addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
        return this;
    }

    @Override // com.google.android.play.core.tasks.Task
    public final Task<ResultT> addOnSuccessListener(OnSuccessListener<? super ResultT> onSuccessListener) {
        addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
        return this;
    }

    @Override // com.google.android.play.core.tasks.Task
    @Nullable
    public final Exception getException() {
        Exception exc;
        synchronized (this.f3240a) {
            exc = this.f3244e;
        }
        return exc;
    }

    @Override // com.google.android.play.core.tasks.Task
    public final ResultT getResult() {
        ResultT resultt;
        synchronized (this.f3240a) {
            try {
                m4202a();
                Exception exc = this.f3244e;
                if (exc != null) {
                    throw new RuntimeExecutionException(exc);
                }
                resultt = this.f3243d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return resultt;
    }

    @Override // com.google.android.play.core.tasks.Task
    public final boolean isComplete() {
        boolean z;
        synchronized (this.f3240a) {
            z = this.f3242c;
        }
        return z;
    }

    @Override // com.google.android.play.core.tasks.Task
    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.f3240a) {
            try {
                z = false;
                if (this.f3242c && this.f3244e == null) {
                    z = true;
                }
            } finally {
            }
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    public final void m4205a(Exception exc) {
        synchronized (this.f3240a) {
            m4203b();
            this.f3242c = true;
            this.f3244e = exc;
        }
        this.f3241b.m4195a(this);
    }

    @Override // com.google.android.play.core.tasks.Task
    public final Task<ResultT> addOnCompleteListener(Executor executor, OnCompleteListener<ResultT> onCompleteListener) {
        this.f3241b.m4196a(new C5338b(executor, onCompleteListener));
        m4204c();
        return this;
    }

    @Override // com.google.android.play.core.tasks.Task
    public final Task<ResultT> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        this.f3241b.m4196a(new C5340d(executor, onFailureListener));
        m4204c();
        return this;
    }

    @Override // com.google.android.play.core.tasks.Task
    public final Task<ResultT> addOnSuccessListener(Executor executor, OnSuccessListener<? super ResultT> onSuccessListener) {
        this.f3241b.m4196a(new C5342f(executor, onSuccessListener));
        m4204c();
        return this;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m4207b(Exception exc) {
        synchronized (this.f3240a) {
            try {
                if (this.f3242c) {
                    return false;
                }
                this.f3242c = true;
                this.f3244e = exc;
                this.f3241b.m4195a(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.play.core.tasks.Task
    public final <X extends Throwable> ResultT getResult(Class<X> cls) {
        ResultT resultt;
        synchronized (this.f3240a) {
            try {
                m4202a();
                if (cls.isInstance(this.f3244e)) {
                    throw cls.cast(this.f3244e);
                }
                Exception exc = this.f3244e;
                if (exc != null) {
                    throw new RuntimeExecutionException(exc);
                }
                resultt = this.f3243d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return resultt;
    }

    /* JADX INFO: renamed from: a */
    public final void m4206a(ResultT resultt) {
        synchronized (this.f3240a) {
            m4203b();
            this.f3242c = true;
            this.f3243d = resultt;
        }
        this.f3241b.m4195a(this);
    }

    /* JADX INFO: renamed from: b */
    public final boolean m4208b(ResultT resultt) {
        synchronized (this.f3240a) {
            try {
                if (this.f3242c) {
                    return false;
                }
                this.f3242c = true;
                this.f3243d = resultt;
                this.f3241b.m4195a(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
