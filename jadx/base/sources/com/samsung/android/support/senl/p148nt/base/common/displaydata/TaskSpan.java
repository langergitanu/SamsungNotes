package com.samsung.android.support.senl.p148nt.base.common.displaydata;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.ParcelableSpan;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0003H\u0016J\u0016\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0005R\u001a\u0010\f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\u0005R\u001a\u0010\u000f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\u0005R\u0011\u0010\u0013\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\n¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/displaydata/TaskSpan;", "Landroid/text/ParcelableSpan;", "taskStatus", "", "<init>", "(I)V", "src", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getTaskStatus", "()I", "setTaskStatus", TextConst.KEY_PARAM_NUMBER, "getNumber", "setNumber", XMLWriter.INDENT, "getIndent", "setIndent", "getSpanTypeId", "spanTypeIdInternal", "getSpanTypeIdInternal", "describeContents", "writeToParcel", "", "dest", "flags", "writeToParcelInternal", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class TaskSpan implements ParcelableSpan {
    public static final int TASK_BULLET = 20;
    public static final int TASK_BULLET_BLACK_SQUARE = 22;
    public static final int TASK_BULLET_WHITE_CIRCLE = 21;
    public static final int TASK_BULLET_WHITE_SQUARE = 23;
    public static final int TASK_DONE = 2;
    public static final int TASK_EMPTY = 8;
    public static final int TASK_GROUP = 4;
    public static final int TASK_NUMBER = 10;
    public static final int TASK_NUMBERING_ALPHABET = 12;
    public static final int TASK_NUMBERING_ROMAN_NUMERAL = 13;
    public static final int TASK_NUMBERING_UPPERCASE_ALPHABET = 11;

    @NotNull
    public static final String TASK_SPAN_ZERO_WIDTH_SPACE = "\u200b";
    public static final int TASK_TEXT = 40;
    public static final int TASK_TODO = 1;
    private int indent;
    private int number;
    private int taskStatus;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Parcelable.Creator<TaskSpan> CREATOR = new Parcelable.Creator<TaskSpan>() { // from class: com.samsung.android.support.senl.nt.base.common.displaydata.TaskSpan$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TaskSpan createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            return new TaskSpan(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TaskSpan[] newArray(int size) {
            return new TaskSpan[size];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/displaydata/TaskSpan$Companion;", "", "<init>", "()V", "TASK_SPAN_ZERO_WIDTH_SPACE", "", "TASK_TODO", "", "TASK_DONE", "TASK_GROUP", "TASK_EMPTY", "TASK_NUMBER", "TASK_NUMBERING_UPPERCASE_ALPHABET", "TASK_NUMBERING_ALPHABET", "TASK_NUMBERING_ROMAN_NUMERAL", "TASK_BULLET", "TASK_BULLET_WHITE_CIRCLE", "TASK_BULLET_BLACK_SQUARE", "TASK_BULLET_WHITE_SQUARE", "TASK_TEXT", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/samsung/android/support/senl/nt/base/common/displaydata/TaskSpan;", "getCREATOR", "()Landroid/os/Parcelable$Creator;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Parcelable.Creator<TaskSpan> getCREATOR() {
            return TaskSpan.CREATOR;
        }

        private Companion() {
        }
    }

    public TaskSpan(int i) {
        setNumber(0);
        setIndent(0);
        setTaskStatus(i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getIndent() {
        return this.indent;
    }

    public int getNumber() {
        return this.number;
    }

    @Override // android.text.ParcelableSpan
    public int getSpanTypeId() {
        return getSpanTypeIdInternal();
    }

    public final int getSpanTypeIdInternal() {
        return 1001;
    }

    public int getTaskStatus() {
        return this.taskStatus;
    }

    public void setIndent(int i) {
        this.indent = i;
    }

    public void setNumber(int i) {
        this.number = i;
    }

    public void setTaskStatus(int i) {
        this.taskStatus = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        writeToParcelInternal(dest, flags);
    }

    public final void writeToParcelInternal(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(getTaskStatus());
        dest.writeInt(getNumber());
        dest.writeInt(getIndent());
    }

    public TaskSpan(@NotNull Parcel src) {
        Intrinsics.checkNotNullParameter(src, "src");
        setTaskStatus(src.readInt());
        setNumber(src.readInt());
        setIndent(src.readInt());
    }
}
