package com.samsung.android.support.senl.p148nt.app.lock.strategy;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\t\b\u0010¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J5\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/strategy/EmptyStrategy;", "Lcom/samsung/android/support/senl/nt/app/lock/strategy/LockManagerStrategy;", "<init>", "()V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "execute", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "uuidList", "", "", "returnData", "Landroid/content/Intent;", "(Landroid/app/Activity;[Ljava/lang/String;Landroid/content/Intent;)V", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class EmptyStrategy extends LockManagerStrategy {

    @JvmField
    @NotNull
    public static final Parcelable.Creator<EmptyStrategy> CREATOR = new Parcelable.Creator<EmptyStrategy>() { // from class: com.samsung.android.support.senl.nt.app.lock.strategy.EmptyStrategy$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EmptyStrategy createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            return new EmptyStrategy(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EmptyStrategy[] newArray(int size) {
            return new EmptyStrategy[size];
        }
    };

    public EmptyStrategy() {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.strategy.LockManagerStrategy
    public void execute(@Nullable Activity activity, @Nullable String[] uuidList, @Nullable Intent returnData) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyStrategy(@NotNull Parcel in) {
        super(in);
        Intrinsics.checkNotNullParameter(in, "in");
    }
}
