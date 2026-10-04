package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.RunnableC8928b;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.common.DynamicTemplateUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.DynamicTemplateLoader;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000f\u0010\u0011B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u0012\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/task/TaskLoadDynamicTemplate;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/task/SingleThreadTask;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/task/TaskLoadDynamicTemplate$InputValues;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/task/TaskLoadDynamicTemplate$ResultValues;", "<init>", "()V", "loader", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/DynamicTemplateLoader;", "executeTask", "", "inputValues", "cancel", "cancelCallback", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/task/Task$ICancelCallback;", "clear", "InputValues", "ResultValues", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TaskLoadDynamicTemplate extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createDynamicTemplateLog("TaskLoad");
    private DynamicTemplateLoader loader;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\fJ\u0010\u0010\u000f\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J8\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0016\u0010\fJ\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u0004\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u0005\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u0006\u0010\fR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\b\u0010\u0010¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/task/TaskLoadDynamicTemplate$InputValues;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/task/Task$InputValues;", "Lkotlin/collections/c;", "", "targetPage", "templateType", "templateIndex", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/DynamicTemplateLoader;", "dynamicTemplateLoader", "<init>", "(IIILcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/DynamicTemplateLoader;)V", "component1", "()I", "component2", "component3", "component4", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/DynamicTemplateLoader;", "copy", "(IIILcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/DynamicTemplateLoader;)Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/task/TaskLoadDynamicTemplate$InputValues;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/DynamicTemplateLoader;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class InputValues extends AbstractC12991c implements Task.InputValues {

        @NotNull
        private final DynamicTemplateLoader dynamicTemplateLoader;
        private final int targetPage;
        private final int templateIndex;
        private final int templateType;

        public InputValues(int i, int i2, int i4, @NotNull DynamicTemplateLoader dynamicTemplateLoader) {
            Intrinsics.checkNotNullParameter(dynamicTemplateLoader, "dynamicTemplateLoader");
            this.targetPage = i;
            this.templateType = i2;
            this.templateIndex = i4;
            this.dynamicTemplateLoader = dynamicTemplateLoader;
        }

        public static /* synthetic */ InputValues copy$default(InputValues inputValues, int i, int i2, int i4, DynamicTemplateLoader dynamicTemplateLoader, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = inputValues.targetPage;
            }
            if ((i5 & 2) != 0) {
                i2 = inputValues.templateType;
            }
            if ((i5 & 4) != 0) {
                i4 = inputValues.templateIndex;
            }
            if ((i5 & 8) != 0) {
                dynamicTemplateLoader = inputValues.dynamicTemplateLoader;
            }
            return inputValues.copy(i, i2, i4, dynamicTemplateLoader);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getTargetPage() {
            return this.targetPage;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getTemplateType() {
            return this.templateType;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getTemplateIndex() {
            return this.templateIndex;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final DynamicTemplateLoader getDynamicTemplateLoader() {
            return this.dynamicTemplateLoader;
        }

        @NotNull
        public final InputValues copy(int targetPage, int templateType, int templateIndex, @NotNull DynamicTemplateLoader dynamicTemplateLoader) {
            Intrinsics.checkNotNullParameter(dynamicTemplateLoader, "dynamicTemplateLoader");
            return new InputValues(targetPage, templateType, templateIndex, dynamicTemplateLoader);
        }

        @NotNull
        public final DynamicTemplateLoader dynamicTemplateLoader() {
            return this.dynamicTemplateLoader;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InputValues)) {
                return false;
            }
            InputValues inputValues = (InputValues) other;
            return this.targetPage == inputValues.targetPage && this.templateType == inputValues.templateType && this.templateIndex == inputValues.templateIndex && Intrinsics.areEqual(this.dynamicTemplateLoader, inputValues.dynamicTemplateLoader);
        }

        public int hashCode() {
            return this.dynamicTemplateLoader.hashCode() + AbstractC0622a.m1157c(this.templateIndex, AbstractC0622a.m1157c(this.templateType, Integer.hashCode(this.targetPage) * 31, 31), 31);
        }

        public final int targetPage() {
            return this.targetPage;
        }

        public final int templateIndex() {
            return this.templateIndex;
        }

        public final int templateType() {
            return this.templateType;
        }

        @NotNull
        public String toString() {
            int i = this.targetPage;
            int i2 = this.templateType;
            int i4 = this.templateIndex;
            DynamicTemplateLoader dynamicTemplateLoader = this.dynamicTemplateLoader;
            StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "InputValues(targetPage=", ", templateType=", ", templateIndex=");
            sbM1173s.append(i4);
            sbM1173s.append(", dynamicTemplateLoader=");
            sbM1173s.append(dynamicTemplateLoader);
            sbM1173s.append(")");
            return sbM1173s.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/task/TaskLoadDynamicTemplate$ResultValues;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/task/Task$ResultValues;", "<init>", "()V", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ResultValues implements Task.ResultValues {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeTask$lambda$1(TaskLoadDynamicTemplate taskLoadDynamicTemplate, String str, InputValues inputValues) {
        DynamicTemplateLoader dynamicTemplateLoader = taskLoadDynamicTemplate.loader;
        if (dynamicTemplateLoader == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loader");
            dynamicTemplateLoader = null;
        }
        dynamicTemplateLoader.loadTemplateData(str, inputValues.targetPage(), new RunnableC10052e(taskLoadDynamicTemplate, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeTask$lambda$1$lambda$0(TaskLoadDynamicTemplate taskLoadDynamicTemplate) {
        taskLoadDynamicTemplate.notifyCallback(true, new ResultValues());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void cancel(@Nullable Task.ICancelCallback cancelCallback) {
        Logger.m11003i(TAG, "cancel ");
        notifyCallback(false, new ResultValues());
        clear();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        super.clear();
        String str = TAG;
        Logger.m11003i(str, "clear ");
        DynamicTemplateLoader dynamicTemplateLoader = this.loader;
        if (dynamicTemplateLoader == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loader");
            dynamicTemplateLoader = null;
        }
        dynamicTemplateLoader.getSoftInputManager().blockToShow(str, false, "TaskLoadDynamicTemplate end");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(@NotNull InputValues inputValues) {
        Intrinsics.checkNotNullParameter(inputValues, "inputValues");
        DynamicTemplateLoader dynamicTemplateLoader = inputValues.dynamicTemplateLoader();
        this.loader = dynamicTemplateLoader;
        DynamicTemplateLoader dynamicTemplateLoader2 = null;
        if (dynamicTemplateLoader == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loader");
            dynamicTemplateLoader = null;
        }
        SoftInputManager softInputManager = dynamicTemplateLoader.getSoftInputManager();
        String TAG2 = TAG;
        softInputManager.blockToShow(TAG2, true, "TaskLoadDynamicTemplate start");
        DynamicTemplateLoader dynamicTemplateLoader3 = this.loader;
        if (dynamicTemplateLoader3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loader");
        } else {
            dynamicTemplateLoader2 = dynamicTemplateLoader3;
        }
        dynamicTemplateLoader2.getSoftInputManager().hide(false);
        String templatePath = DynamicTemplateUtil.getTemplatePath(inputValues.templateType(), inputValues.templateIndex());
        Logger.m11000e(TAG2, "executeTask, templateType: " + Logger.getEncode(templatePath));
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG2));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new RunnableC8928b(this, 13, templatePath, inputValues));
    }
}
