package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IConverterFactory;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/ConverterWrapperFactory;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/IConverterFactory;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mContextRef", "Ljava/lang/ref/WeakReference;", "release", "", "createDocumentConverter", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/IDocumentConverter;", "type", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ConverterWrapperFactory implements IConverterFactory {

    @Nullable
    private WeakReference<Context> mContextRef;

    public ConverterWrapperFactory(@Nullable Context context) {
        this.mContextRef = new WeakReference<>(context);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IConverterFactory
    @NotNull
    public IDocumentConverter<?> createDocumentConverter(int type) {
        WeakReference<Context> weakReference = this.mContextRef;
        Context context = weakReference != null ? weakReference.get() : null;
        if (context == null) {
            LoggerBase.INSTANCE.m7138w("ConverterWrapperFactory", "null context!");
            return new EmptyConverterWrapper();
        }
        switch (type) {
        }
        return new EmptyConverterWrapper();
    }

    public final void release() {
        WeakReference<Context> weakReference = this.mContextRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.mContextRef = null;
    }
}
