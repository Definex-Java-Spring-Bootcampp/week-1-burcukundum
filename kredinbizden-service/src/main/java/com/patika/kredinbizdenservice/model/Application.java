package com.patika.kredinbizdenservice.model;


import com.patika.kredinbizdenservice.enums.ApplicationStatus;

import java.time.LocalDateTime;
import java.util.*;

import static com.patika.kredinbizdenservice.model.User.userList;

public class Application {

    static List<Application> loanlist = new ArrayList<>();
    static List<Application> allApplicationsList = new ArrayList<>();

    private Loan loan;
    private Product product;
    private User user;
    private LocalDateTime localDateTime;
    private ApplicationStatus applicationStatus;

    //private Application() {
    //}

    /*
    public Application(CreditCard creditCard, User user, LocalDateTime localDateTime) {
        this.creditCard = creditCard;
        this.user = user;
        this.localDateTime = localDateTime;
        this.applicationStatus = ApplicationStatus.INITIAL;
    }*/

    public Application(Product product, User user, LocalDateTime localDateTime) {
        this.product = product;
        this.user = user;
        this.localDateTime = localDateTime;
        this.applicationStatus = ApplicationStatus.INITIAL;
        allApplicationsList.add(this);
    }

    public Application(Loan loan, User user, LocalDateTime localDateTime) {
        this.loan = loan;
        this.user = user;
        this.localDateTime = localDateTime;
        this.applicationStatus = ApplicationStatus.INITIAL;
        loanlist.add(this);
        allApplicationsList.add(this);
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    @Override
    public String toString() {
        return "Application{" +
                "loan=" + loan +
                ", user=" + user +
                ", localDateTime=" + localDateTime +
                ", applicationStatus=" + applicationStatus +
                '}';
    }

    public static LoanInfo findHighestLoan() {
        Optional<Application> highestLoanApp = loanlist.stream()
                .filter(app -> app.getLoan() != null)
                .max(Comparator.comparing(app -> app.getLoan().getAmount()));

        if (highestLoanApp.isPresent()) {
            Application application = highestLoanApp.get();
            System.out.println(String.format("%s %s, %s", application.getUser().getName(), application.getUser().getSurname(),
                    application.getLoan().getAmount()));
            return new LoanInfo(application.getUser().getName(), application.getLoan().getAmount());
        } else {
            return null;
        }
    }

    public static List<Application> getApplicationsLastMonth() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneMonthAgo = now.minusMonths(1);

        List<Application> applicationsLastMonth = new ArrayList<>();

        for (Application application : allApplicationsList) {

            if (application.getLocalDateTime().isAfter(oneMonthAgo) && application.getLocalDateTime().isBefore(now)) {
               applicationsLastMonth.add(application);
            }
        }
        return applicationsLastMonth;
    }

    public static List<Application> getApplicationsByEmail(String email) {

        List<Application> email_applications = new ArrayList<>();
        for (Application application : allApplicationsList) {
            if (application.getUser().getEmail().equals(email)) {
                email_applications.add(application);
            }
        }
        return email_applications;

    }

}
