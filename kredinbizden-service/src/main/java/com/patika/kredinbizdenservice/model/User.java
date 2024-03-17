package com.patika.kredinbizdenservice.model;

import java.time.LocalDate;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger;
import java.util.stream.Collectors;

import static com.patika.kredinbizdenservice.model.Application.allApplicationsList;


public class User {

    private static final Set<String> usersEmailList = new HashSet<>();
    static List<User> userList = new ArrayList<>();

    private String name;
    private String surname;
    private LocalDate birthDate;
    private String email; //bir email ile bir kere kayıt olunabilir.
    private String hashedPassword; //hash fonskiyonlarından biri ile hashlanecek.
    private String phoneNumber;
    private Boolean isActive;
    protected List<Application> applicationList;

    public User(String name, String surname, LocalDate birthDate, String email, String password, String phoneNumber, Boolean isActive) {
        if(usersEmailList.contains(email)){
            System.out.println("A user with this email already exists.");
            return;
        }
        usersEmailList.add(email);
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.email = email;
        this.setPassword(password);
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
        this.applicationList = new ArrayList<>();
        userList.add(this);

    }

    public User(String name, String surname, String email,String password) {
        if(usersEmailList.contains(email)){
            System.out.println("A user with this email already exists.");
            return;
        }
        usersEmailList.add(email);
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.setPassword(password);
        this.applicationList = new ArrayList<>();
        userList.add(this);


    }

    public User(String name, String surname, String email, String password, String phoneNumber, Boolean isActive, List<Application> applicationList) {
        if (usersEmailList.contains(email)) {
            System.out.println("A user with this email already exists.");
            return;
        }
        usersEmailList.add(email);
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.setPassword(password);
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
        this.applicationList = new ArrayList<>();
        userList.add(this);


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String gethashedPassword() {
        return hashedPassword;
    }

    private void setPassword(String password) {
        this.hashedPassword = hashPassword(password);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Application> getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(List<Application> applicationList) {
        this.applicationList = applicationList;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", hashedPassword='" + hashedPassword + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isActive=" + isActive +
                ", applicationList=" + applicationList +
                '}';
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] hashBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));


            BigInteger hashNum = new BigInteger(1, hashBytes);
            StringBuilder hashString = new StringBuilder(hashNum.toString(16));


            while (hashString.length() < 32) {
                hashString.insert(0, "0");
            }
            return hashString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean checkPassword(String password) {
        String inputHash = hashPassword(password);
        return inputHash.equals(this.hashedPassword);
    }
    public void changePassword(String newPassword) {
        this.setPassword(newPassword);
    }
    public void addApplication(Application application) {
        if (!applicationList.contains(application)) {
            applicationList.add(application);
        }
    }
    public static User findMostAppliedUser() {
        Map<User, Integer> applicationCounts = new HashMap<>();

        // Count applications for each user
        for (Object obj : allApplicationsList) {
            if (obj instanceof Application) {
                User user = ((Application) obj).getUser();
                applicationCounts.put(user, applicationCounts.getOrDefault(user, 0) + 1);
            }
        }

        // Find the user with the highest application count
        User mostAppliedUser = null;
        int maxApplications = 0;
        for (Map.Entry<User, Integer> entry : applicationCounts.entrySet()) {
            if (entry.getValue() > maxApplications) {
                maxApplications = entry.getValue();
                mostAppliedUser = entry.getKey();
            }
        }

        return mostAppliedUser;
    }


}
