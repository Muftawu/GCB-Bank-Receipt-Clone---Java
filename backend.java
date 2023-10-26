package GCB;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class backend {

    private String bank_name = "GCB BANK PLC";
    private String branch = "Abeka Lapaz";
    private String deposit_by = "Muftawu Mohammed";

    private String receipt_type = "CASH DEPOSIT RECEIPT";
    private String transaction_reference = "";
    private int transaction_reference_length = 16;

    private String account_number = "";
    private int account_num_len = 13;
    private String transaction_currency = "GHS";

    Scanner scanner = new Scanner(System.in);

    public backend () {

        // Account name
        String acc_name = generate_account_name();

        // Receipt details
        System.out.println("\n```````````````````````````````````````" + bank_name + "````````````````````````");
        System.out.println("```````````````````````````````````````" + branch + "``````````````````````````");

        System.out.print("`````" + receipt_type + "`````````");
        System.out.println("Transaction Date``````````" + date_issued() + "````\n");

        // Transaction reference generation
        String trans_ref = generate_transaction_reference(transaction_reference_length);
        System.out.println("Transaction reference:  " + trans_ref);

        // Account number
        String acc_no = generate_account_number(account_num_len);
        System.out.println("Transaction Account:    " + acc_no);

        // Account name
        System.out.println("Account Name:           " + acc_name);

        // Transaction currency
        System.out.println("Transaction Currency:   " + transaction_currency);

        // Transaction Amount
        System.out.println("Transaction Amount:     " + generate_transaction_amount());

        // Transaction amount in words
        System.out.println("Amount in words:        " + generate_amount_in_words());

        // Narration
        System.out.println("\nNarration:              Cash Deposit BY " + deposit_by);

    }

    private String date_issued () {
        SimpleDateFormat date_formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        Date date = new Date();
        
        return  date_formatter.format(date);
    }   


    private String generate_transaction_reference (int id_length) {
        String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String nums = "0123456789";

        // First three numbers
        for (int a=1; a<4; a++) {
        double rand = Math.random() * 10;
        transaction_reference += nums.charAt(((int)rand));
        }

        // Next four letters [CAPS]
        for (int b=1; b<5; b++) {
            double rand = Math.random() * 10;
            transaction_reference += caps.charAt(((int)rand));
            }
        
        // Last ten numbers 
        for (int c=1; c<10; c++) {
            double rand = Math.random() * 10;
            transaction_reference += nums.charAt(((int)rand));
            }

        return transaction_reference;
    }
    
    private String generate_account_number (int account_number_length) {
        String nums = "0123456789";

        for (int c=0; c<account_number_length; c++) {
            double rand = Math.random() * 10;
            account_number += nums.charAt(((int)rand));
            }

        return account_number;
    }

    private String generate_account_name () {
        System.out.print("Account Name:  ");

        return scanner.nextLine();
    }

    private double generate_transaction_amount() {
        return  Math.random()*1000;
    }

    private String generate_amount_in_words () {
     return "Ghana Cedi(s) Only";   
    }
    
}
