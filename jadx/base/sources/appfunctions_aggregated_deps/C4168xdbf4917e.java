package appfunctions_aggregated_deps;

import com.google.android.appfunctions.AppFunctionContext;
import com.google.android.appfunctions.schema.common.p129v1.notes.Note;
import com.google.android.appfunctions.schema.common.p129v1.notes.UpdateNoteParams;
import com.samsung.android.support.senl.p148nt.app.main.appfunction.NoteFunctions;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: renamed from: appfunctions_aggregated_deps._com_samsung_android_support_senl_nt_app_main_appfunction_AppSchemaFunctions_AppFunctionInventory_Impl$functionToMetadataMap$4 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
public /* synthetic */ class C4168xdbf4917e extends FunctionReferenceImpl implements Function4<NoteFunctions, AppFunctionContext, UpdateNoteParams, Continuation<? super Note>, Object>, SuspendFunction {
    public static final C4168xdbf4917e INSTANCE = new C4168xdbf4917e();

    public C4168xdbf4917e() {
        super(4, NoteFunctions.class, "updateNote", "updateNote(Lcom/google/android/appfunctions/AppFunctionContext;Lcom/google/android/appfunctions/schema/common/v1/notes/UpdateNoteParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(NoteFunctions noteFunctions, AppFunctionContext appFunctionContext, UpdateNoteParams updateNoteParams, Continuation<? super Note> continuation) {
        return noteFunctions.updateNote(appFunctionContext, updateNoteParams, continuation);
    }
}
