package com.company;

import java.util.ArrayList;



    public class Bank {
        private ArrayList<BankRekening> rekeningen = new ArrayList<>();
        public String getHTML() {
            StringBuilder sb = new StringBuilder();
            sb.append("<table>\n");
            sb.append("<thead>\n");
            sb.append("</thead>\n");
            sb.append("<tbody>\n");
            for (BankRekening rekening:rekeningen) {
                sb.append("<tr>");
                sb.append("<td>" + rekening.getRekeningnummer() + "</td>");
                sb.append("<td>" + rekening.getSaldo() + "</td>");
                sb.append("</tr>\n");
            }
            sb.append("</tbody>\n");
            sb.append("</table>\n");
            return sb.toString();

        }

        public void addRekening(BankRekening rek) {


            if (getRekening(rek.getRekeningnummer()) != null) {
                throw new IllegalArgumentException("Rekening is niet uniek");
            }
            rekeningen.add(rek);
        }


        public ArrayList <String> getRekeningnummers() {
            ArrayList<String> rekeningnummers = new ArrayList<>();
            for (BankRekening rek:rekeningen){
                String rekeningnummer = rek.getRekeningnummer();
                rekeningnummers.add(rekeningnummer);
            }

            return rekeningnummers;
        }

        public BankRekening getRekening(String rekeningnummer) {
            for (BankRekening bankRekening: rekeningen){
                if (bankRekening.getRekeningnummer().equals(rekeningnummer)){
                    return bankRekening;
                }
            }return null;


        }

        public boolean bestaatBankrekening (String rekeningnummer) {
            if (getRekening(rekeningnummer)!= null) {
                return true;
            }else return false;
        }

        public void stortGeld(String rekeningnummer, int i) {
            if (bestaatBankrekening(rekeningnummer) == false) {throw new IllegalArgumentException("Bankrekening bestaat niet."); }
            BankRekening rekening = getRekening(rekeningnummer);
            rekening.storten(i);



        }

        public void schrijfGeldOver(String bankrekening1, String bankrekening2, int bedrag) {
            BankRekening bankRekening1 = getRekening(bankrekening1) ;
            if (bankRekening1 == null) { throw new IllegalArgumentException (String.format("Bankrekening %s bestaat niet", bankRekening1.getRekeningnummer()));}
            BankRekening bankRekening2 = getRekening(bankrekening2);
            if (bankRekening2 == null){ throw new IllegalArgumentException(String.format("Bankrekening bestaat niet", bankRekening2.getRekeningnummer()));}
            bankRekening1.afhalen(bedrag);
            bankRekening2.storten(bedrag);


        }
    }

