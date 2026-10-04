package appfunctions_aggregated_deps;

import com.google.android.appfunctions.AppFunctionContext;
import com.google.android.appfunctions.schema.common.p129v1.notes.CreateFolderParams;
import com.google.android.appfunctions.schema.common.p129v1.notes.Folder;
import com.samsung.android.support.senl.p148nt.app.main.appfunction.FolderFunctions;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: renamed from: appfunctions_aggregated_deps._com_samsung_android_support_senl_nt_app_main_appfunction_AppSchemaFunctions_AppFunctionInventory_Impl$functionToMetadataMap$7 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
public /* synthetic */ class C4171xdbf49181 extends FunctionReferenceImpl implements Function4<FolderFunctions, AppFunctionContext, CreateFolderParams, Continuation<? super Folder>, Object>, SuspendFunction {
    public static final C4171xdbf49181 INSTANCE = new C4171xdbf49181();

    public C4171xdbf49181() {
        super(4, FolderFunctions.class, "createFolder", "createFolder(Lcom/google/android/appfunctions/AppFunctionContext;Lcom/google/android/appfunctions/schema/common/v1/notes/CreateFolderParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(FolderFunctions folderFunctions, AppFunctionContext appFunctionContext, CreateFolderParams createFolderParams, Continuation<? super Folder> continuation) {
        return folderFunctions.createFolder(appFunctionContext, createFolderParams, continuation);
    }
}
