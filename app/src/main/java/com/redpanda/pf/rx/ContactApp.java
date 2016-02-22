package com.redpanda.pf.rx;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

public class ContactApp extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.contact_layout);

        ContactListModel listModel = new InMemoryContactListModel();
        ContactListView listView = (ContactListView) getFragmentManager().findFragmentById(R.id.titles);

        new ContactListPresenter(listModel, listView);

        ContactEditorModel editorModel = new InMemoryContactEditorModel();
        ContactEditorView editorView = (ContactEditorView) getFragmentManager().findFragmentById(R.id.details);

        new ContactEditorPresenter(editorModel, editorView);

        listModel.whenSelectionChanged().subscribe(ignored -> editorModel.setCurrentContact(listModel.selectedContact()));

        editorModel.whenContactSaved().subscribe(ignored -> listView.refresh());
    }

}
