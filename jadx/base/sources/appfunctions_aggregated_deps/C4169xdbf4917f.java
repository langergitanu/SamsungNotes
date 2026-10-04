package appfunctions_aggregated_deps;

import com.google.android.appfunctions.AppFunctionContext;
import com.samsung.android.support.senl.p148nt.app.main.appfunction.NoteFunctions;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: renamed from: appfunctions_aggregated_deps._com_samsung_android_support_senl_nt_app_main_appfunction_AppSchemaFunctions_AppFunctionInventory_Impl$functionToMetadataMap$5 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
public /* synthetic */ class C4169xdbf4917f extends FunctionReferenceImpl implements Function4<NoteFunctions, AppFunctionContext, List<? extends String>, Continuation<? super List<? extends String>>, Object>, SuspendFunction {
    public static final C4169xdbf4917f INSTANCE = new C4169xdbf4917f();

    public C4169xdbf4917f() {
        super(4, NoteFunctions.class, "deleteNotes", "deleteNotes(Lcom/google/android/appfunctions/AppFunctionContext;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(NoteFunctions noteFunctions, AppFunctionContext appFunctionContext, List<String> list, Continuation<? super List<String>> continuation) {
        return noteFunctions.deleteNotes(appFunctionContext, list, continuation);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(NoteFunctions noteFunctions, AppFunctionContext appFunctionContext, List<? extends String> list, Continuation<? super List<? extends String>> continuation) {
        return invoke2(noteFunctions, appFunctionContext, (List<String>) list, (Continuation<? super List<String>>) continuation);
    }
}
