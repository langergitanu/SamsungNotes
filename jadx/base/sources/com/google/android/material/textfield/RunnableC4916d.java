package com.google.android.material.textfield;

/* JADX INFO: renamed from: com.google.android.material.textfield.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class RunnableC4916d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2403a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f2404b;

    public /* synthetic */ RunnableC4916d(Object obj, int i) {
        this.f2403a = i;
        this.f2404b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2403a) {
            case 0:
                ((ClearTextEndIconDelegate) this.f2404b).lambda$tearDown$2();
                break;
            case 1:
                ((DropdownMenuEndIconDelegate) this.f2404b).lambda$afterEditTextChanged$3();
                break;
            default:
                ((TextInputLayout) this.f2404b).lambda$onGlobalLayout$1();
                break;
        }
    }
}
