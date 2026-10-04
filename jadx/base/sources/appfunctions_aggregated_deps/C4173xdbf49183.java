package appfunctions_aggregated_deps;

import com.google.android.appfunctions.AppFunctionContext;
import com.google.android.appfunctions.schema.common.p129v1.notes.FindFoldersParams;
import com.google.android.appfunctions.schema.common.p129v1.notes.Folder;
import com.samsung.android.support.senl.p148nt.app.main.appfunction.FolderFunctions;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: renamed from: appfunctions_aggregated_deps._com_samsung_android_support_senl_nt_app_main_appfunction_AppSchemaFunctions_AppFunctionInventory_Impl$functionToMetadataMap$9 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
public /* synthetic */ class C4173xdbf49183 extends FunctionReferenceImpl implements Function4<FolderFunctions, AppFunctionContext, FindFoldersParams, Continuation<? super List<? extends Folder>>, Object>, SuspendFunction {
    public static final C4173xdbf49183 INSTANCE = new C4173xdbf49183();

    public C4173xdbf49183() {
        super(4, FolderFunctions.class, "findFolders", "findFolders(Lcom/google/android/appfunctions/AppFunctionContext;Lcom/google/android/appfunctions/schema/common/v1/notes/FindFoldersParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FolderFunctions folderFunctions, AppFunctionContext appFunctionContext, FindFoldersParams findFoldersParams, Continuation<? super List<Folder>> continuation) {
        return folderFunctions.findFolders(appFunctionContext, findFoldersParams, continuation);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(FolderFunctions folderFunctions, AppFunctionContext appFunctionContext, FindFoldersParams findFoldersParams, Continuation<? super List<? extends Folder>> continuation) {
        return invoke2(folderFunctions, appFunctionContext, findFoldersParams, (Continuation<? super List<Folder>>) continuation);
    }
}
