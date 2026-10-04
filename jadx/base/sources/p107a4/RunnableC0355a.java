package p107a4;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.samsung.android.support.senl.p148nt.app.labs.DocumentTest;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import com.samsung.android.support.senl.p148nt.base.winset.util.ButtonShapeUtil;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.DynamicTemplateLoader;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Page;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentCoverEntity;
import com.samsung.android.support.senl.p148nt.data.repository.cover.NotesDocumentCoverRepository;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: renamed from: a4.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC0355a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f885a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f886b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f887c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f888d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f889e;

    public /* synthetic */ RunnableC0355a(Object obj, Object obj2, int i, Object obj3, int i2) {
        this.f885a = i2;
        this.f887c = obj;
        this.f888d = obj2;
        this.f886b = i;
        this.f889e = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f885a) {
            case 0:
                ((NotesDocumentCoverRepository) this.f887c).lambda$insert$0((NotesDocumentCoverEntity) this.f888d, this.f886b, (String) this.f889e);
                break;
            case 1:
                ((Uploader) this.f887c).lambda$upload$1((TransportContext) this.f888d, this.f886b, (Runnable) this.f889e);
                break;
            case 2:
                ((DocumentTest) this.f887c).lambda$importData$0((Activity) this.f888d, this.f886b, (DialogUtils.ProgressDialog) this.f889e);
                break;
            case 3:
                ContentPickerUtils.isStoragePermissionGranted$lambda$5((String) this.f889e, (String[]) this.f887c, (Fragment) this.f888d, this.f886b);
                break;
            case 4:
                ContentPickerUtils.isSaveAsPermissionGranted$lambda$4((String[]) this.f887c, (Activity) this.f888d, (Fragment) this.f889e, this.f886b);
                break;
            case 5:
                DynamicTemplateLoader.initTemplateContents$lambda$0((Page) this.f887c, (DynamicTemplateLoader) this.f888d, this.f886b, (CountDownLatch) this.f889e);
                break;
            default:
                ButtonShapeUtil.updateContainedButtonLayout$lambda$0((View[]) this.f887c, this.f886b, (Context) this.f888d, (View) this.f889e);
                break;
        }
    }

    public /* synthetic */ RunnableC0355a(String str, String[] strArr, Fragment fragment, int i) {
        this.f885a = 3;
        this.f889e = str;
        this.f887c = strArr;
        this.f888d = fragment;
        this.f886b = i;
    }

    public /* synthetic */ RunnableC0355a(View[] viewArr, int i, Context context, View view) {
        this.f885a = 6;
        this.f887c = viewArr;
        this.f886b = i;
        this.f888d = context;
        this.f889e = view;
    }

    public /* synthetic */ RunnableC0355a(String[] strArr, Activity activity, Fragment fragment, int i) {
        this.f885a = 4;
        this.f887c = strArr;
        this.f888d = activity;
        this.f889e = fragment;
        this.f886b = i;
    }
}
