package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
           try { 
            Scanner input=new Scanner(System.in);
            
            System.out.println( "Il client è partito" );
            Socket s = new Socket("localhost", 3000);

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            String risposta="y";
            while(risposta=="y"){
                System.out.println("dammi il primo numero");
            String N1String=input.nextLine();
            out.writeBytes(N1String+"\n");

           

             System.out.println("dammi il secondo numero");
            String N2String=input.nextLine();
            out.writeBytes(N2String+"\n");

            System.out.println("che operazione vuoi fare?");
              
            String operazione=input.nextLine();
            out.writeBytes(operazione+"\n");

           

               String risultatoString=in.readLine();
               float risultato=Float.parseFloat(risultatoString);

               System.out.println("il risultato ricevuto é "+risultato);
            s.close();

            System.out.println("vuoi effettuare un nuovo calcolo? y/n");
            
            risposta=input.nextLine();
            
            
            if(risposta=="n"){

                break;
            }
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("errore durante l'istanza del server");
            System.exit(1);
        }
    }
}
