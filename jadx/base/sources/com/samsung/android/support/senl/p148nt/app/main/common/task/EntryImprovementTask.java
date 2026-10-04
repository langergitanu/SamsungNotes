package com.samsung.android.support.senl.p148nt.app.main.common.task;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Trace;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.DrawableUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.common.view.NotesPenRecyclerView;
import com.samsung.android.support.senl.p148nt.base.common.EntryImprovementManager;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003!\"#B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0016H\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/task/EntryImprovementTask;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/EntryImprovementTask$TaskParams;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "SIMPLE_INFLATE_COUNT", "", "LIST_INFLATE_COUNT", "GRID_INFLATE_COUNT", "weakReference", "Ljava/lang/ref/WeakReference;", "Lcom/samsung/android/support/senl/nt/app/main/common/view/NotesPenRecyclerView;", "viewMode", "mTaskListener", "Lcom/samsung/android/support/senl/nt/app/main/common/task/EntryImprovementTask$TaskListener;", "execute", "", "taskParams", "inflateProcess", "entry", "", "bitmapProcess", "context", "Landroid/content/Context;", "subFolderBitmapProcess", "isSubFolderExist", "inflateHolders", "getTag", "", "getResult", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Result;", "TaskParams", "Companion", "TaskListener", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nEntryImprovementTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntryImprovementTask.kt\ncom/samsung/android/support/senl/nt/app/main/common/task/EntryImprovementTask\n+ 2 BitmapDrawable.kt\nandroidx/core/graphics/drawable/BitmapDrawableKt\n*L\n1#1,204:1\n27#2:205\n*S KotlinDebug\n*F\n+ 1 EntryImprovementTask.kt\ncom/samsung/android/support/senl/nt/app/main/common/task/EntryImprovementTask\n*L\n100#1:205\n*E\n"})
public final class EntryImprovementTask extends WorkerTask<TaskParams> {

    @NotNull
    public static final String TAG = "EntryImprovementTask";
    private final int GRID_INFLATE_COUNT;
    private final int LIST_INFLATE_COUNT;
    private final int SIMPLE_INFLATE_COUNT;

    @Nullable
    private TaskListener mTaskListener;
    private int viewMode;

    @Nullable
    private WeakReference<NotesPenRecyclerView> weakReference;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J \u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/task/EntryImprovementTask$TaskListener;", "", "needInflatedView", "", "addSubHeaderInflatedView", "", "item", "Landroid/view/View;", "addInflatedView", "addSubFolderBitmap", "count", "", "color", "drawable", "Landroid/graphics/drawable/Drawable;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface TaskListener {
        void addInflatedView(@Nullable View item);

        void addSubFolderBitmap(int count, int color, @NotNull Drawable drawable);

        void addSubHeaderInflatedView(@Nullable View item);

        boolean needInflatedView();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/task/EntryImprovementTask$TaskParams;", "", "entry", "", "recyclerView", "Lcom/samsung/android/support/senl/nt/app/main/common/view/NotesPenRecyclerView;", "viewMode", "", "isSubFolderExist", "taskListener", "Lcom/samsung/android/support/senl/nt/app/main/common/task/EntryImprovementTask$TaskListener;", "<init>", "(ZLcom/samsung/android/support/senl/nt/app/main/common/view/NotesPenRecyclerView;IZLcom/samsung/android/support/senl/nt/app/main/common/task/EntryImprovementTask$TaskListener;)V", "getEntry", "()Z", "getRecyclerView", "()Lcom/samsung/android/support/senl/nt/app/main/common/view/NotesPenRecyclerView;", "getViewMode", "()I", "getTaskListener", "()Lcom/samsung/android/support/senl/nt/app/main/common/task/EntryImprovementTask$TaskListener;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class TaskParams {
        private final boolean entry;
        private final boolean isSubFolderExist;

        @NotNull
        private final NotesPenRecyclerView recyclerView;

        @NotNull
        private final TaskListener taskListener;
        private final int viewMode;

        public TaskParams(boolean z, @NotNull NotesPenRecyclerView recyclerView, int i, boolean z2, @NotNull TaskListener taskListener) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(taskListener, "taskListener");
            this.entry = z;
            this.recyclerView = recyclerView;
            this.viewMode = i;
            this.isSubFolderExist = z2;
            this.taskListener = taskListener;
        }

        public static /* synthetic */ TaskParams copy$default(TaskParams taskParams, boolean z, NotesPenRecyclerView notesPenRecyclerView, int i, boolean z2, TaskListener taskListener, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = taskParams.entry;
            }
            if ((i2 & 2) != 0) {
                notesPenRecyclerView = taskParams.recyclerView;
            }
            if ((i2 & 4) != 0) {
                i = taskParams.viewMode;
            }
            if ((i2 & 8) != 0) {
                z2 = taskParams.isSubFolderExist;
            }
            if ((i2 & 16) != 0) {
                taskListener = taskParams.taskListener;
            }
            TaskListener taskListener2 = taskListener;
            int i4 = i;
            return taskParams.copy(z, notesPenRecyclerView, i4, z2, taskListener2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getEntry() {
            return this.entry;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final NotesPenRecyclerView getRecyclerView() {
            return this.recyclerView;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getViewMode() {
            return this.viewMode;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsSubFolderExist() {
            return this.isSubFolderExist;
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final TaskListener getTaskListener() {
            return this.taskListener;
        }

        @NotNull
        public final TaskParams copy(boolean entry, @NotNull NotesPenRecyclerView recyclerView, int viewMode, boolean isSubFolderExist, @NotNull TaskListener taskListener) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(taskListener, "taskListener");
            return new TaskParams(entry, recyclerView, viewMode, isSubFolderExist, taskListener);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskParams)) {
                return false;
            }
            TaskParams taskParams = (TaskParams) other;
            return this.entry == taskParams.entry && Intrinsics.areEqual(this.recyclerView, taskParams.recyclerView) && this.viewMode == taskParams.viewMode && this.isSubFolderExist == taskParams.isSubFolderExist && Intrinsics.areEqual(this.taskListener, taskParams.taskListener);
        }

        public final boolean getEntry() {
            return this.entry;
        }

        @NotNull
        public final NotesPenRecyclerView getRecyclerView() {
            return this.recyclerView;
        }

        @NotNull
        public final TaskListener getTaskListener() {
            return this.taskListener;
        }

        public final int getViewMode() {
            return this.viewMode;
        }

        public int hashCode() {
            return this.taskListener.hashCode() + AbstractC0622a.m1160f(this.isSubFolderExist, AbstractC0622a.m1157c(this.viewMode, (this.recyclerView.hashCode() + (Boolean.hashCode(this.entry) * 31)) * 31, 31), 31);
        }

        public final boolean isSubFolderExist() {
            return this.isSubFolderExist;
        }

        @NotNull
        public String toString() {
            return "TaskParams(entry=" + this.entry + ", recyclerView=" + this.recyclerView + ", viewMode=" + this.viewMode + ", isSubFolderExist=" + this.isSubFolderExist + ", taskListener=" + this.taskListener + ")";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntryImprovementTask(@NotNull Activity activity) {
        super(activity.hashCode(), null, 2, null);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.SIMPLE_INFLATE_COUNT = 12;
        this.LIST_INFLATE_COUNT = 5;
        this.GRID_INFLATE_COUNT = 8;
    }

    private final void bitmapProcess(Context context, boolean entry) {
        if (!entry) {
            EntryImprovementManager.INSTANCE.getInstance().saveToInternalMemory(BaseUtils.getApplicationContext());
            return;
        }
        boolean z = false;
        boolean z2 = WindowManagerCompat.INSTANCE.getInstance().getMultiWindowMode(context.getResources().getConfiguration()) == 0;
        EntryImprovementManager.Companion companion = EntryImprovementManager.INSTANCE;
        EntryImprovementManager companion2 = companion.getInstance();
        if (z2 && !DesktopModeCompat.INSTANCE.getInstance().isDexNewDexMode(BaseUtils.getApplicationContext())) {
            z = true;
        }
        companion2.setActive(z);
        companion.getInstance().loadInternalMemory(BaseUtils.getApplicationContext());
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void inflateHolders() {
        int i;
        int i2;
        WeakReference<NotesPenRecyclerView> weakReference = this.weakReference;
        Intrinsics.checkNotNull(weakReference);
        NotesPenRecyclerView notesPenRecyclerView = weakReference.get();
        if (notesPenRecyclerView == null) {
            return;
        }
        Context context = notesPenRecyclerView.getContext();
        int i4 = this.viewMode;
        if (i4 == 1) {
            i = this.LIST_INFLATE_COUNT;
            i2 = C8003R.layout.notes_list_item;
        } else if (i4 == 2) {
            i = this.GRID_INFLATE_COUNT;
            i2 = C8003R.layout.notes_grid_item;
        } else if (i4 == 3) {
            i = this.SIMPLE_INFLATE_COUNT;
            i2 = C8003R.layout.notes_simple_item;
        } else if (i4 != 4) {
            if (i4 != 6) {
                return;
            }
            i = this.SIMPLE_INFLATE_COUNT;
            i2 = C8003R.layout.notes_simple_item_no_thumbnail;
        }
        try {
            TaskListener taskListener = this.mTaskListener;
            Intrinsics.checkNotNull(taskListener);
            if (taskListener.needInflatedView()) {
                TaskListener taskListener2 = this.mTaskListener;
                Intrinsics.checkNotNull(taskListener2);
                taskListener2.addSubHeaderInflatedView(LayoutInflater.from(context).inflate((XmlPullParser) context.getResources().getLayout(C8003R.layout.notes_subheader_holder), (ViewGroup) notesPenRecyclerView, false));
            }
            for (int i5 = 0; i5 < i; i5++) {
                TaskListener taskListener3 = this.mTaskListener;
                Intrinsics.checkNotNull(taskListener3);
                if (!taskListener3.needInflatedView()) {
                    return;
                }
                View viewInflate = LayoutInflater.from(context).inflate((XmlPullParser) context.getResources().getLayout(i2), (ViewGroup) notesPenRecyclerView, false);
                if (ContentUtils.isGridViewMode(this.viewMode)) {
                    ViewModeUtils.getInflatedView(viewInflate, C8003R.id.text_only_thumbnail, C8003R.id.inflate_text_only_thumbnail_layout).setVisibility(8);
                } else if (1 == this.viewMode) {
                    ViewModeUtils.getInflatedView(viewInflate, C8003R.id.text_content, C8003R.id.inflate_text_content).setVisibility(8);
                }
                TaskListener taskListener4 = this.mTaskListener;
                Intrinsics.checkNotNull(taskListener4);
                taskListener4.addInflatedView(viewInflate);
            }
        } catch (InflateException e) {
            MainLogger.m7255e(TAG, e.getMessage());
        } catch (IllegalStateException e2) {
            MainLogger.m7255e(TAG, e2.getMessage());
        }
    }

    private final void inflateProcess(boolean entry) {
        if (entry) {
            WeakReference<NotesPenRecyclerView> weakReference = this.weakReference;
            Intrinsics.checkNotNull(weakReference);
            try {
                if (weakReference.get() != null) {
                    MainLogger.m7258i(TAG, "Inflate task doInBackground start");
                    Trace.beginSection("NotesFragment AsyncTask(MainList)");
                    inflateHolders();
                    MainLogger.m7258i(TAG, "Inflate task doInBackground end");
                }
            } catch (Exception unused) {
                MainLogger.m7258i(TAG, "Inflate task doInBackground has error");
            } finally {
                Trace.endSection();
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void subFolderBitmapProcess(Context context, boolean entry, boolean isSubFolderExist) {
        WeakReference<NotesPenRecyclerView> weakReference = this.weakReference;
        Intrinsics.checkNotNull(weakReference);
        if (weakReference.get() == null) {
            return;
        }
        if ((entry || isSubFolderExist) && !(entry && isSubFolderExist)) {
            return;
        }
        boolean zIsNightMode = ContextUtils.isNightMode(context);
        int[] intArray = context.getResources().getIntArray(C8003R.array.folder_mark_color);
        Intrinsics.checkNotNullExpressionValue(intArray, "getIntArray(...)");
        int length = intArray.length + 1;
        int[] iArr = new int[length];
        iArr[0] = -1;
        System.arraycopy(intArray, 0, iArr, 1, intArray.length);
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            int i4 = 0;
            while (i4 < 3) {
                TaskListener taskListener = this.mTaskListener;
                Intrinsics.checkNotNull(taskListener);
                Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), i4 < 1 ? zIsNightMode ? C8003R.drawable.sub_folder_icon_blur_dark_empty : C8003R.drawable.sub_folder_icon_blur_light_empty : i4 == 1 ? DrawableUtils.getFolderBlur(context, i2, zIsNightMode) : DrawableUtils.getFolderBlur(context, i2, zIsNightMode));
                Intrinsics.checkNotNullExpressionValue(bitmapDecodeResource, "decodeResource(...)");
                Resources resources = context.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, bitmapDecodeResource);
                bitmapDrawable.setAlpha(i4 < 1 ? 178 : 255);
                Unit unit = Unit.INSTANCE;
                taskListener.addSubFolderBitmap(i4, i2, bitmapDrawable);
                i4++;
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    /* JADX INFO: renamed from: getResult */
    public WorkerTask.Result getTaskResult() {
        return new WorkerTask.Result() { // from class: com.samsung.android.support.senl.nt.app.main.common.task.EntryImprovementTask.getResult.1
            @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
            public int getHashCode() {
                return 0;
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
            public String getTag() {
                return EntryImprovementTask.TAG;
            }
        };
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    public void execute(@Nullable TaskParams taskParams) {
        Intrinsics.checkNotNull(taskParams);
        this.weakReference = new WeakReference<>(taskParams.getRecyclerView());
        this.viewMode = taskParams.getViewMode();
        this.mTaskListener = taskParams.getTaskListener();
        inflateProcess(taskParams.getEntry());
        Context context = taskParams.getRecyclerView().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        bitmapProcess(context, taskParams.getEntry());
        Context context2 = taskParams.getRecyclerView().getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        subFolderBitmapProcess(context2, taskParams.getEntry(), taskParams.isSubFolderExist());
        WeakReference<NotesPenRecyclerView> weakReference = this.weakReference;
        Intrinsics.checkNotNull(weakReference);
        if (weakReference.get() != null) {
            WeakReference<NotesPenRecyclerView> weakReference2 = this.weakReference;
            Intrinsics.checkNotNull(weakReference2);
            weakReference2.clear();
        }
    }
}
