package com.samsung.android.support.notes.bixby;

import com.samsung.android.support.notes.bixby.bixby2.contract.IBixby2ActionBackgound;
import com.samsung.android.support.notes.bixby.bixby2.contract.IComposerFragmentBixby2;
import com.samsung.android.support.notes.bixby.bixby2.contract.IDrawerFragmentBixby2;
import com.samsung.android.support.notes.bixby.bixby2.contract.INoteFragmentBixby2;
import com.samsung.android.support.notes.bixby.bixby2.contract.INoteListActivityBixby2;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/BixbyManagerContract;", "", "IBixby2Action", "INoteListActivity", "INoteFragment", "IDrawerFragment", "IComposerFragment", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface BixbyManagerContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/BixbyManagerContract$IBixby2Action;", "", "registerBixby2Action", "Lcom/samsung/android/support/notes/bixby/bixby2/contract/IBixby2ActionBackgound;", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IBixby2Action {
        @Nullable
        IBixby2ActionBackgound registerBixby2Action();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/BixbyManagerContract$IComposerFragment;", "", "registerComposerFragmentBixby2", "Lcom/samsung/android/support/notes/bixby/bixby2/contract/IComposerFragmentBixby2;", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IComposerFragment {
        @Nullable
        IComposerFragmentBixby2 registerComposerFragmentBixby2();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/BixbyManagerContract$IDrawerFragment;", "", "registerDrawerFragmentBixby2", "Lcom/samsung/android/support/notes/bixby/bixby2/contract/IDrawerFragmentBixby2;", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IDrawerFragment {
        @Nullable
        IDrawerFragmentBixby2 registerDrawerFragmentBixby2();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/BixbyManagerContract$INoteFragment;", "", "registerNoteFragmentBixby2", "Lcom/samsung/android/support/notes/bixby/bixby2/contract/INoteFragmentBixby2;", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface INoteFragment {
        @Nullable
        INoteFragmentBixby2 registerNoteFragmentBixby2();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/BixbyManagerContract$INoteListActivity;", "", "registerNoteListActivityBixby2", "Lcom/samsung/android/support/notes/bixby/bixby2/contract/INoteListActivityBixby2;", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface INoteListActivity {
        @Nullable
        INoteListActivityBixby2 registerNoteListActivityBixby2();
    }
}
