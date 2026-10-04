package appfunctions_aggregated_deps;

import com.google.android.appfunctions.AppFunctionContext;
import com.google.android.appfunctions.schema.common.p129v1.notes.FindNotesParams;
import com.google.android.appfunctions.schema.common.p129v1.notes.Note;
import com.samsung.android.support.senl.p148nt.app.main.appfunction.NoteFunctions;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: renamed from: appfunctions_aggregated_deps._com_samsung_android_support_senl_nt_app_main_appfunction_AppSchemaFunctions_AppFunctionInventory_Impl$functionToMetadataMap$1 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
public /* synthetic */ class C4164xdbf4917b extends FunctionReferenceImpl implements Function4<NoteFunctions, AppFunctionContext, FindNotesParams, Continuation<? super List<? extends Note>>, Object>, SuspendFunction {
    public static final C4164xdbf4917b INSTANCE = new C4164xdbf4917b();

    public C4164xdbf4917b() {
        super(4, NoteFunctions.class, "findNotes", "findNotes(Lcom/google/android/appfunctions/AppFunctionContext;Lcom/google/android/appfunctions/schema/common/v1/notes/FindNotesParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(NoteFunctions noteFunctions, AppFunctionContext appFunctionContext, FindNotesParams findNotesParams, Continuation<? super List<Note>> continuation) {
        return noteFunctions.findNotes(appFunctionContext, findNotesParams, continuation);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(NoteFunctions noteFunctions, AppFunctionContext appFunctionContext, FindNotesParams findNotesParams, Continuation<? super List<? extends Note>> continuation) {
        return invoke2(noteFunctions, appFunctionContext, findNotesParams, (Continuation<? super List<Note>>) continuation);
    }
}
