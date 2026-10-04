package com.samsung.android.support.senl.addons.executor;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.support.senl.addons.base.model.IDataHandler;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/executor/AbsExecuteIntentBuilder;", "Lcom/samsung/android/support/senl/addons/executor/IExecuteIntentBuilder;", "<init>", "()V", "mIntentFlags", "", "mDataHandler", "Ljava/lang/Class;", "Lcom/samsung/android/support/senl/addons/base/model/IDataHandler;", "setIntentFlags", "flags", "setDataHandler", "dataHandler", "build", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsExecuteIntentBuilder implements IExecuteIntentBuilder {
    private int mIntentFlags = 603979776;

    @Nullable
    private Class<? extends IDataHandler> mDataHandler = DataHandler.class;

    @Override // com.samsung.android.support.senl.addons.executor.IExecuteIntentBuilder
    @NotNull
    public Intent build(@Nullable Context context) {
        Intent intent = new Intent();
        intent.putExtra("data_handler_class", this.mDataHandler);
        intent.setFlags(this.mIntentFlags);
        return intent;
    }

    @Override // com.samsung.android.support.senl.addons.executor.IExecuteIntentBuilder
    @NotNull
    public IExecuteIntentBuilder setDataHandler(@Nullable Class<? extends IDataHandler> dataHandler) {
        this.mDataHandler = dataHandler;
        return this;
    }

    @Override // com.samsung.android.support.senl.addons.executor.IExecuteIntentBuilder
    @NotNull
    public IExecuteIntentBuilder setIntentFlags(int flags) {
        this.mIntentFlags = flags;
        return this;
    }
}
