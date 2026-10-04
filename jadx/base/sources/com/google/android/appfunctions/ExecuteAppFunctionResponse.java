package com.google.android.appfunctions;

import android.app.appsearch.GenericDocument;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.google.android.appfunctions.internal.GenericDocumentToPlatformConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, m13886d2 = {"Lcom/google/android/appfunctions/ExecuteAppFunctionResponse;", "", "functionResult", "Lcom/google/android/appfunctions/AppFunctionDocument;", "<init>", "(Lcom/google/android/appfunctions/AppFunctionDocument;)V", "getFunctionResult", "()Lcom/google/android/appfunctions/AppFunctionDocument;", "toPlatformClass", "Lcom/android/extensions/appfunctions/ExecuteAppFunctionResponse;", "Companion", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class ExecuteAppFunctionResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String PROPERTY_RETURN_VALUE = "androidAppfunctionsReturnValue";

    @NotNull
    private final AppFunctionDocument functionResult;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/google/android/appfunctions/ExecuteAppFunctionResponse$Companion;", "", "<init>", "()V", "PROPERTY_RETURN_VALUE", "", "fromPlatformClass", "Lcom/google/android/appfunctions/ExecuteAppFunctionResponse;", "response", "Lcom/android/extensions/appfunctions/ExecuteAppFunctionResponse;", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @RequiresApi(36)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @NotNull
        public final ExecuteAppFunctionResponse fromPlatformClass(@NotNull com.android.extensions.appfunctions.ExecuteAppFunctionResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            GenericDocumentToPlatformConverter genericDocumentToPlatformConverter = GenericDocumentToPlatformConverter.INSTANCE;
            GenericDocument resultDocument = response.getResultDocument();
            Intrinsics.checkNotNullExpressionValue(resultDocument, "getResultDocument(...)");
            androidx.appsearch.app.GenericDocument jetpackGenericDocument = genericDocumentToPlatformConverter.toJetpackGenericDocument(resultDocument);
            Bundle extras = response.getExtras();
            Intrinsics.checkNotNullExpressionValue(extras, "getExtras(...)");
            return new ExecuteAppFunctionResponse(new AppFunctionDocument(jetpackGenericDocument, extras));
        }

        private Companion() {
        }
    }

    public ExecuteAppFunctionResponse(@NotNull AppFunctionDocument functionResult) {
        Intrinsics.checkNotNullParameter(functionResult, "functionResult");
        this.functionResult = functionResult;
    }

    @NotNull
    public final AppFunctionDocument getFunctionResult() {
        return this.functionResult;
    }

    @RequiresApi(36)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public final com.android.extensions.appfunctions.ExecuteAppFunctionResponse toPlatformClass() {
        return new com.android.extensions.appfunctions.ExecuteAppFunctionResponse(GenericDocumentToPlatformConverter.INSTANCE.toPlatformGenericDocument(this.functionResult.getGenericDocument()), this.functionResult.getExtras());
    }
}
