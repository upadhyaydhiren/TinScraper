package com.musk.tin.application;

import com.musk.tin.scraper.TinScraper;

import java.util.Scanner;

/**
 * This is main method that execute the application
 * Created by dhiren on 17/11/16.
 * @author dhiren
 * @since 17-11-16
 */
public class MainApplication {

    public static void main(String[] args) {
        TinScraper tinScraper = new TinScraper();
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("Enter tin number for details or type exit for close application\n");
            String input = scanner.next();
            if (input.equalsIgnoreCase("exit"))
                break;
            else if (Character.isDigit(input.charAt(0)))
            {
                try {
                    if(tinScraper.scrape(input))
                        System.out.println("File uploaded checkout your dropbox app folder");
                }
                catch (Exception e)
                {
                    System.err.println("Error in file upload->\n"+e.getMessage());
                }
            }
            else
                System.out.println("Invalid option\n");
        }
        scanner.close();
    }
}
