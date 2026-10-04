package com.samsung.android.support.senl.p148nt.data.database.core.dao;

import android.util.Pair;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Transaction;
import androidx.room.Update;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface BaseDao<Entity> {
    @Delete
    int delete(Entity entity);

    @Insert(onConflict = 5)
    void insert(Entity entity);

    @Update
    int update(Entity entity);

    @Transaction
    default Pair<AtomicInteger, AtomicInteger> upsert(Entity entity) {
        Pair<AtomicInteger, AtomicInteger> pairCreate = Pair.create(new AtomicInteger(0), new AtomicInteger());
        if (update(entity) > 0) {
            ((AtomicInteger) pairCreate.second).incrementAndGet();
            return pairCreate;
        }
        insert(entity);
        ((AtomicInteger) pairCreate.first).incrementAndGet();
        return pairCreate;
    }

    @Transaction
    default void upsert(Collection<? extends Entity> collection) {
        Iterator<? extends Entity> it = collection.iterator();
        while (it.hasNext()) {
            upsert(it.next());
        }
    }
}
