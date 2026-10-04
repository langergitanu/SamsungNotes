package com.google.android.appfunctions;

import android.app.appsearch.GenericDocument;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.android.extensions.appfunctions.ExecuteAppFunctionRequest;
import com.google.android.appfunctions.internal.GenericDocumentToPlatformConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, m13886d2 = {"Lcom/google/android/appfunctions/ExecuteAppFunctionRequest;", "", "targetPackageName", "", "functionIdentifier", "functionParameters", "Lcom/google/android/appfunctions/AppFunctionDocument;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/AppFunctionDocument;)V", "getTargetPackageName", "()Ljava/lang/String;", "getFunctionIdentifier", "getFunctionParameters", "()Lcom/google/android/appfunctions/AppFunctionDocument;", "toPlatformClass", "Lcom/android/extensions/appfunctions/ExecuteAppFunctionRequest;", "toString", "Companion", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class ExecuteAppFunctionRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String functionIdentifier;

    @NotNull
    private final AppFunctionDocument functionParameters;

    @NotNull
    private final String targetPackageName;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, m13886d2 = {"Lcom/google/android/appfunctions/ExecuteAppFunctionRequest$Companion;", "", "<init>", "()V", "fromPlatformClass", "Lcom/google/android/appfunctions/ExecuteAppFunctionRequest;", "request", "Lcom/android/extensions/appfunctions/ExecuteAppFunctionRequest;", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @RequiresApi(36)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @NotNull
        public final ExecuteAppFunctionRequest fromPlatformClass(@NotNull com.android.extensions.appfunctions.ExecuteAppFunctionRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            String targetPackageName = request.getTargetPackageName();
            Intrinsics.checkNotNullExpressionValue(targetPackageName, "getTargetPackageName(...)");
            String functionIdentifier = request.getFunctionIdentifier();
            Intrinsics.checkNotNullExpressionValue(functionIdentifier, "getFunctionIdentifier(...)");
            GenericDocumentToPlatformConverter genericDocumentToPlatformConverter = GenericDocumentToPlatformConverter.INSTANCE;
            GenericDocument parameters = request.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
            androidx.appsearch.app.GenericDocument jetpackGenericDocument = genericDocumentToPlatformConverter.toJetpackGenericDocument(parameters);
            Bundle extras = request.getExtras();
            Intrinsics.checkNotNullExpressionValue(extras, "getExtras(...)");
            return new ExecuteAppFunctionRequest(targetPackageName, functionIdentifier, new AppFunctionDocument(jetpackGenericDocument, extras));
        }

        private Companion() {
        }
    }

    public ExecuteAppFunctionRequest(@NotNull String targetPackageName, @NotNull String functionIdentifier, @NotNull AppFunctionDocument functionParameters) {
        Intrinsics.checkNotNullParameter(targetPackageName, "targetPackageName");
        Intrinsics.checkNotNullParameter(functionIdentifier, "functionIdentifier");
        Intrinsics.checkNotNullParameter(functionParameters, "functionParameters");
        this.targetPackageName = targetPackageName;
        this.functionIdentifier = functionIdentifier;
        this.functionParameters = functionParameters;
    }

    @NotNull
    public final String getFunctionIdentifier() {
        return this.functionIdentifier;
    }

    @NotNull
    public final AppFunctionDocument getFunctionParameters() {
        return this.functionParameters;
    }

    @NotNull
    public final String getTargetPackageName() {
        return this.targetPackageName;
    }

    @RequiresApi(36)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public final com.android.extensions.appfunctions.ExecuteAppFunctionRequest toPlatformClass() {
        com.android.extensions.appfunctions.ExecuteAppFunctionRequest executeAppFunctionRequestBuild = new ExecuteAppFunctionRequest.Builder(this.targetPackageName, this.functionIdentifier).setParameters(GenericDocumentToPlatformConverter.INSTANCE.toPlatformGenericDocument(this.functionParameters.getGenericDocument())).setExtras(this.functionParameters.getExtras()).build();
        Intrinsics.checkNotNullExpressionValue(executeAppFunctionRequestBuild, "build(...)");
        return executeAppFunctionRequestBuild;
    }

    @NotNull
    public String toString() {
        String str = this.targetPackageName;
        String str2 = this.functionIdentifier;
        AppFunctionDocument appFunctionDocument = this.functionParameters;
        StringBuilder sbM16m = AbstractC0000a.m16m("ExecuteAppFunctionRequest(targetPackageName=", str, ", functionIdentifier=", str2, ", functionParameters=");
        sbM16m.append(appFunctionDocument);
        sbM16m.append(")");
        return sbM16m.toString();
    }
}
