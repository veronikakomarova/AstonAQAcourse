package org.example;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

public class TelephoneDirectory {
    private Map<String, ArrayList<String>> directory;

    TelephoneDirectory() {
        this.directory = new HashMap<>();
    }

    public void add(String lastName, String phone) {
        if (directory.containsKey(lastName)) {
            ArrayList<String> phonesForLastName = directory.get(lastName);
            phonesForLastName.add(phone);
        }
        else {

            ArrayList<String> numbersList = new ArrayList<>();
            numbersList.add(phone);
            directory.put(lastName, numbersList);
        }
    }

    public ArrayList<String> getPhones(String lastName){
        ArrayList<String> phoneNumbers = directory.get(lastName);

        if (phoneNumbers == null){
            phoneNumbers = new ArrayList<String>();
        }

        return phoneNumbers;
    }

}
