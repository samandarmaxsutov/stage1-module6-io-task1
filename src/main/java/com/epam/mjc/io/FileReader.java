package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    setProfileData(profile, key, value);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return profile;
    }

    private void setProfileData(Profile profile, String key, String value) {
        switch (key) {
            case "Name":
                profile.setName(value);
                break;
            case "Age":
                profile.setAge(Integer.parseInt(value));
                break;
            case "Email":
                profile.setEmail(value);
                break;
            case "Phone":
                profile.setPhone(Long.parseLong(value));
                break;
            default:
                break;
        }
    }
}
