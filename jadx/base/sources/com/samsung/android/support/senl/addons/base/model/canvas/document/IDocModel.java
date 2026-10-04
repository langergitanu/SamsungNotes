package com.samsung.android.support.senl.addons.base.model.canvas.document;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u0016*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0016J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0015\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rH&¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rH&¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rH&¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rH&¢\u0006\u0002\u0010\u000eJ\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\bH&J\b\u0010\u0015\u001a\u00020\u0013H&¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/document/IDocModel;", "T", "", "isValidDoc", "", "isUndoable", "isRedoable", "getWidth", "", "getHeight", "getDocumentFilePath", "", "undo", "", "()[Ljava/lang/Object;", "redo", "undoAll", "redoAll", "clearAll", "", "getObjectCount", "release", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IDocModel<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int DOCUMENT_UNDO_SIZE = 50;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/document/IDocModel$Companion;", "", "<init>", "()V", "DOCUMENT_UNDO_SIZE", "", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DOCUMENT_UNDO_SIZE = 50;

        private Companion() {
        }
    }

    void clearAll();

    @Nullable
    String getDocumentFilePath();

    int getHeight();

    int getObjectCount();

    int getWidth();

    boolean isRedoable();

    boolean isUndoable();

    boolean isValidDoc();

    @Nullable
    T[] redo();

    @Nullable
    T[] redoAll();

    void release();

    @Nullable
    T[] undo();

    @Nullable
    T[] undoAll();
}
