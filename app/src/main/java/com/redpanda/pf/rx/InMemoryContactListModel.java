package com.redpanda.pf.rx;

import java.util.Collection;
import java.util.List;

import rx.Observable;
import rx.subjects.PublishSubject;

public class InMemoryContactListModel implements ContactListModel {
    PublishSubject<Void> contactsChanged = PublishSubject.create();
    PublishSubject<Void> selectionChanged = PublishSubject.create();

    private List<Contact> contacts;
    private int selectedIndex;

    @Override
    public Observable<Void> whenContactsChanged() {
        return contactsChanged.asObservable();
    }

    @Override
    public Collection<Contact> contacts() {
        return contacts;
    }

    @Override
    public void selectByIndex(int index) {
        selectedIndex = index;
        selectionChanged.onNext(null);
    }

    @Override
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
        contactsChanged.onNext(null);
    }

    @Override
    public Contact selectedContact() {
        return contacts.get(selectedIndex);
    }

    @Override
    public Observable<Void> whenSelectionChanged() {
        return selectionChanged.asObservable();
    }

}
