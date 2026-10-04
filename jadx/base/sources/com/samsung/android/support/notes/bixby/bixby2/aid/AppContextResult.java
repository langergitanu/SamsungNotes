package com.samsung.android.support.notes.bixby.bixby2.aid;

import com.samsung.android.sdk.bixby2.state.StateHandler;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR.\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/aid/AppContextResult;", "", "<init>", "()V", StateHandler.CONCEPTS, "Ljava/util/ArrayList;", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/Concepts;", "Lkotlin/collections/ArrayList;", "getConcepts", "()Ljava/util/ArrayList;", "setConcepts", "(Ljava/util/ArrayList;)V", StateHandler.LLM_CONTEXT, "Lcom/samsung/android/support/notes/bixby/bixby2/aid/LlmContext;", "getLlmContext", "setLlmContext", "llmCapsuleId", "", "getLlmCapsuleId", "()Ljava/lang/String;", "setLlmCapsuleId", "(Ljava/lang/String;)V", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AppContextResult {

    @Nullable
    private ArrayList<Concepts> concepts;

    @Nullable
    private String llmCapsuleId;

    @Nullable
    private ArrayList<LlmContext> llmContext;

    @Nullable
    public final ArrayList<Concepts> getConcepts() {
        return this.concepts;
    }

    @Nullable
    public final String getLlmCapsuleId() {
        return this.llmCapsuleId;
    }

    @Nullable
    public final ArrayList<LlmContext> getLlmContext() {
        return this.llmContext;
    }

    public final void setConcepts(@Nullable ArrayList<Concepts> arrayList) {
        this.concepts = arrayList;
    }

    public final void setLlmCapsuleId(@Nullable String str) {
        this.llmCapsuleId = str;
    }

    public final void setLlmContext(@Nullable ArrayList<LlmContext> arrayList) {
        this.llmContext = arrayList;
    }
}
