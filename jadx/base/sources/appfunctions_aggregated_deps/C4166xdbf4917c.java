package appfunctions_aggregated_deps;

import com.google.android.appfunctions.AppFunctionContext;
import com.google.android.appfunctions.schema.common.p129v1.notes.CreateNoteParams;
import com.google.android.appfunctions.schema.common.p129v1.notes.Note;
import com.samsung.android.support.senl.p148nt.app.main.appfunction.NoteFunctions;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: renamed from: appfunctions_aggregated_deps._com_samsung_android_support_senl_nt_app_main_appfunction_AppSchemaFunctions_AppFunctionInventory_Impl$functionToMetadataMap$2 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
public /* synthetic */ class C4166xdbf4917c extends FunctionReferenceImpl implements Function4<NoteFunctions, AppFunctionContext, CreateNoteParams, Continuation<? super Note>, Object>, SuspendFunction {
    public static final C4166xdbf4917c INSTANCE = new C4166xdbf4917c();

    public C4166xdbf4917c() {
        super(4, NoteFunctions.class, "createNote", "createNote(Lcom/google/android/appfunctions/AppFunctionContext;Lcom/google/android/appfunctions/schema/common/v1/notes/CreateNoteParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(NoteFunctions noteFunctions, AppFunctionContext appFunctionContext, CreateNoteParams createNoteParams, Continuation<? super Note> continuation) {
        return noteFunctions.createNote(appFunctionContext, createNoteParams, continuation);
    }
}
