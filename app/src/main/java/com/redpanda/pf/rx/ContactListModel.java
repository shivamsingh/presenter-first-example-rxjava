package com.redpanda.pf.rx;

import java.util.Collection;
import java.util.List;

import rx.Observable;

public interface ContactListModel {
    Observable<Void> whenContactsChanged();

    Collection<Contact> contacts();

    void selectByIndex(int index);

    void setContacts(List<Contact> contacts);

    Contact selectedContact();

    Observable<Void> whenSelectionChanged();
}
