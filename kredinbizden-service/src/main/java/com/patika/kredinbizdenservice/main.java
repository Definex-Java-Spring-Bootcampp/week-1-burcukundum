package com.patika.kredinbizdenservice;

import com.patika.kredinbizdenservice.enums.LoanType;
import com.patika.kredinbizdenservice.model.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.patika.kredinbizdenservice.model.Application.*;
import static com.patika.kredinbizdenservice.model.CreditCard.sortCreditCardsByCampaignCount;
import static com.patika.kredinbizdenservice.model.User.findMostAppliedUser;


public class main {

        public static void main(String[] args) {
           //aynı email adresi ile bir kullanıcı kayıt olabilir.
            System.out.println("Aynİ email adresi ile bir kullanici kayit olabilir.");
            User user1 = new User("Burcu", "Kündüm", "burcu@gmail.com","pass123");
            User user2 = new User("Burcu", "hkahd", "burcu@gmail.com","pass126");

            // kullanıcının şifresi SHA512 ile şifrelenerek oluşturulmuştur.
            System.out.println(user1);

            //en çok başvuru yapan kullanıcıyı bulan method
            System.out.println(" ");
            System.out.println("En cok basvuru yapan kullaniciyi bulan method");
            User user3 = new User("Zerrin", "Özer", "zz@gmail.com","özer");
            User user4 = new User("Sezen", "Aksu", "minik@gmail.com","serce123");

            List<Campaign> campaignList = new ArrayList<>();
            Campaign campaign1 = new Campaign("campaign1");
            campaignList.add(campaign1);

            CreditCard card1 =new CreditCard(BigDecimal.valueOf(55), campaignList);

            Application app1 = new Application(card1, user3, LocalDateTime.now());
            Application app2 = new Application(card1, user3, LocalDateTime.now());
            Application app3 = new Application(card1, user4, LocalDateTime.now());
            Application app4 = new Application(card1, user4, LocalDateTime.now());
            Application app5 = new Application(card1, user4, LocalDateTime.now());

            System.out.println(findMostAppliedUser());



            // En yüksek kredi isteyen kullanıcı
            System.out.println(" ");
            System.out.println("En yuksek kredi isteyen kullanici: ");
            Bank bank1 = new Bank("Garanti");
            Loan loan1 = LoanFactory.createLoan(BigDecimal.valueOf(15000), 180, bank1, 5.4, LoanType.IHTIYAC_KREDISI);
            Loan loan2 = LoanFactory.createLoan(BigDecimal.valueOf(5000), 180, bank1, 5.4, LoanType.IHTIYAC_KREDISI);
            Loan loan3 = LoanFactory.createLoan(BigDecimal.valueOf(550000), 180, bank1, 5.4, LoanType.IHTIYAC_KREDISI);

            Application app6 = new Application(loan1, user3, LocalDateTime.now());
            Application app7 = new Application(loan2, user3, LocalDateTime.now());
            Application app8 = new Application(loan3, user4, LocalDateTime.now());

            findHighestLoan();

            // son 1 ayda yapılan başvurular
            System.out.println(" ");
            System.out.println("son 1 ayda yapilan basvurular: ");
            System.out.println(getApplicationsLastMonth());

            // Kapmanya sayısı en çoktan aza doğru olacak şekilde kart tekliflerini listele
            System.out.println(" ");
            System.out.println("Kapmanya sayisi en coktan aza doğru olacak sekilde kart tekliflerini listele ");
            List<Campaign> campaignList2 = new ArrayList<>();
            Campaign campaign2 = new Campaign("campaign2");
            Campaign campaign3 = new Campaign("campaign3");
            campaignList2.add(campaign2);
            campaignList2.add(campaign3);
            CreditCard card2 =new CreditCard(BigDecimal.valueOf(50), campaignList2);

            System.out.println(sortCreditCardsByCampaignCount());
            // spesifik bir mail adresine sahip kullanıcının bütün başvurularını listele
            System.out.println(" ");
            System.out.println("Spesifik bir mail adresine sahip kullanicinin butun basvurularini listele: ");
            System.out.println(getApplicationsByEmail("minik@gmail.com"));
        }
}



