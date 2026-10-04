package com.google.android.appfunctions.schema.common.p129v1.messages;

import com.google.android.appfunctions.AppFunctionContext;
import com.google.android.appfunctions.schema.common.AppFunctionSchemaDefinition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@AppFunctionSchemaDefinition(category = "messages", name = "sendMessage", version = 1)
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/messages/SendMessage;", "", "sendMessage", "Lcom/google/android/appfunctions/schema/common/v1/messages/Message;", "appFunctionContext", "Lcom/google/android/appfunctions/AppFunctionContext;", "sendMessageParams", "Lcom/google/android/appfunctions/schema/common/v1/messages/SendMessageParams;", "(Lcom/google/android/appfunctions/AppFunctionContext;Lcom/google/android/appfunctions/schema/common/v1/messages/SendMessageParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SendMessage {
    @Nullable
    Object sendMessage(@NotNull AppFunctionContext appFunctionContext, @NotNull SendMessageParams sendMessageParams, @NotNull Continuation<? super Message> continuation);
}
