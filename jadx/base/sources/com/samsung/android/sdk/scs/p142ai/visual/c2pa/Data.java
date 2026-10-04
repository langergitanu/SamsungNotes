package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/visual/c2pa/Data;", "", "actions", "", "Lcom/samsung/android/sdk/scs/ai/visual/c2pa/Action;", "<init>", "(Ljava/util/List;)V", "getActions", "()Ljava/util/List;", "setActions", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class Data {

    @Nullable
    private List<Action> actions;

    public Data(@Nullable List<Action> list) {
        this.actions = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Data copy$default(Data data, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = data.actions;
        }
        return data.copy(list);
    }

    @Nullable
    public final List<Action> component1() {
        return this.actions;
    }

    @NotNull
    public final Data copy(@Nullable List<Action> actions) {
        return new Data(actions);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Data) && Intrinsics.areEqual(this.actions, ((Data) other).actions);
    }

    @Nullable
    public final List<Action> getActions() {
        return this.actions;
    }

    public int hashCode() {
        List<Action> list = this.actions;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final void setActions(@Nullable List<Action> list) {
        this.actions = list;
    }

    @NotNull
    public String toString() {
        return "Data(actions=" + this.actions + ")";
    }
}
