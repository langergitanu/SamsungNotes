package com.samsung.android.support.senl.p148nt.model.domain.note;

import android.content.Context;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.google.firebase.messaging.Constants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.DeleteType;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/domain/note/DeleteNoteUseCase;", "", "<init>", "()V", "invoke", "", "param", "Lcom/samsung/android/support/senl/nt/model/domain/note/DeleteNoteUseCase$Param;", "Param", "Companion", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DeleteNoteUseCase {
    private static final String TAG = ModelLogger.createTag("DeleteNoteUseCase");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003JA\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/domain/note/DeleteNoteUseCase$Param;", "", "context", "Landroid/content/Context;", "uuids", "", "", Constants.MessagePayloadKeys.FROM, "", "to", NotesConstants.KEY_CALLER, "<init>", "(Landroid/content/Context;Ljava/util/List;IILjava/lang/String;)V", "getContext", "()Landroid/content/Context;", "getUuids", "()Ljava/util/List;", "getFrom", "()I", "getTo", "getCaller", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class Param {

        @NotNull
        private final String caller;

        @NotNull
        private final Context context;
        private final int from;
        private final int to;

        @NotNull
        private final List<String> uuids;

        public Param(@NotNull Context context, @NotNull List<String> uuids, @DeleteType int i, @DeleteType int i2, @NotNull String caller) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uuids, "uuids");
            Intrinsics.checkNotNullParameter(caller, "caller");
            this.context = context;
            this.uuids = uuids;
            this.from = i;
            this.to = i2;
            this.caller = caller;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Param copy$default(Param param, Context context, List list, int i, int i2, String str, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                context = param.context;
            }
            if ((i4 & 2) != 0) {
                list = param.uuids;
            }
            if ((i4 & 4) != 0) {
                i = param.from;
            }
            if ((i4 & 8) != 0) {
                i2 = param.to;
            }
            if ((i4 & 16) != 0) {
                str = param.caller;
            }
            String str2 = str;
            int i5 = i;
            return param.copy(context, list, i5, i2, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Context getContext() {
            return this.context;
        }

        @NotNull
        public final List<String> component2() {
            return this.uuids;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getFrom() {
            return this.from;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getTo() {
            return this.to;
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getCaller() {
            return this.caller;
        }

        @NotNull
        public final Param copy(@NotNull Context context, @NotNull List<String> uuids, @DeleteType int from, @DeleteType int to, @NotNull String caller) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uuids, "uuids");
            Intrinsics.checkNotNullParameter(caller, "caller");
            return new Param(context, uuids, from, to, caller);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Param)) {
                return false;
            }
            Param param = (Param) other;
            return Intrinsics.areEqual(this.context, param.context) && Intrinsics.areEqual(this.uuids, param.uuids) && this.from == param.from && this.to == param.to && Intrinsics.areEqual(this.caller, param.caller);
        }

        @NotNull
        public final String getCaller() {
            return this.caller;
        }

        @NotNull
        public final Context getContext() {
            return this.context;
        }

        public final int getFrom() {
            return this.from;
        }

        public final int getTo() {
            return this.to;
        }

        @NotNull
        public final List<String> getUuids() {
            return this.uuids;
        }

        public int hashCode() {
            return this.caller.hashCode() + AbstractC0622a.m1157c(this.to, AbstractC0622a.m1157c(this.from, AbstractC0622a.m1159e(this.uuids, this.context.hashCode() * 31, 31), 31), 31);
        }

        @NotNull
        public String toString() {
            Context context = this.context;
            List<String> list = this.uuids;
            int i = this.from;
            int i2 = this.to;
            String str = this.caller;
            StringBuilder sb = new StringBuilder("Param(context=");
            sb.append(context);
            sb.append(", uuids=");
            sb.append(list);
            sb.append(", from=");
            AbstractC2821a.m2235z(sb, i, i2, ", to=", ", caller=");
            return AbstractC0622a.m1170p(str, ")", sb);
        }
    }

    public final void invoke(@NotNull Param param) {
        Intrinsics.checkNotNullParameter(param, "param");
        DataLogger.m12302d(TAG, "invoke, from: " + param.getFrom() + ", to: " + param.getTo());
        DocumentWriteResolver.delete(param.getContext(), param.getUuids(), 2, param.getCaller());
        DocumentWriteResolver.delete(param.getContext(), param.getUuids(), 1, param.getCaller());
    }
}
