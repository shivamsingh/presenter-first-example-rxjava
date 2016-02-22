package com.redpanda.pf.rx;

import java.util.Arrays;

public class ContactListPresenter {
    public ContactListPresenter(ContactListModel model, ContactListView view) {
        model.whenContactsChanged().subscribe(ignored -> view.setContacts(model.contacts()));
        view.whenSelectionChanged().subscribe(ignored -> model.selectByIndex(view.selectedIndex()));
        view.whenInitialized().subscribe(ignored -> model.setContacts(Arrays.asList(ContactBook.CONTACTS)));
    }
}
