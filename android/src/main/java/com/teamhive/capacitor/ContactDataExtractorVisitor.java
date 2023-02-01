package com.teamhive.capacitor;

import android.database.Cursor;
import android.provider.ContactsContract;
import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.teamhive.capacitor.contentQuery.ContentQueryService;
import com.teamhive.capacitor.utils.Visitor;

import java.util.Map;
import android.util.Log;

public class ContactDataExtractorVisitor implements Visitor<Cursor> {

    private Map<String, String> projectionMap;

    private JSArray phoneNumbers = new JSArray();
    
    public ContactDataExtractorVisitor(Map<String, String> projectionMap) {
        this.projectionMap = projectionMap;
    }

    @Override
    public void visit(Cursor cursor) {
        JSObject currentDataRecord = ContentQueryService.extractDataFromResultSet(cursor, projectionMap);
        String currentMimeType = currentDataRecord.getString(PluginContactFields.MIME_TYPE);

        //Log.v("HELLO", String.valueOf(currentDataRecord));

        if (ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE.equals(currentMimeType)) {
            JSObject phone = new JSObject();
            // https://developer.android.com/reference/android/provider/ContactsContract.CommonDataKinds.Phone
            if (currentDataRecord.getString(ContactsContract.Contacts.Data.DATA1) != null) {
                phone.put("phoneNumber", currentDataRecord.getString(ContactsContract.Contacts.Data.DATA1));
            }
            phoneNumbers.put(phone);
        } 
    }

    public JSArray getPhoneNumbers() { return phoneNumbers; }
