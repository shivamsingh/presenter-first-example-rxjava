package com.redpanda.pf.rx;

import java.util.Collection;

import rx.Observable;

public interface ContactListView {
    Observable<Void> whenSelectionChanged();

    void setContacts(Collection<Contact> contacts);

    int selectedIndex();

    Observable<Void> whenInitialized();

    void refresh();
}
