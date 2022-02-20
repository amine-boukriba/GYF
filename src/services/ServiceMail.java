/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author anwer
 */
public class ServiceMail {
    private List<String> list;
    public ServiceMail(List<String> list) {
        this.list = new ArrayList(list);
    }
    
    public static void sendMail(List<String> list){
        String recep = list.get(5);
        System.out.println("preparing message");

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");

        String myAdress = "getyourfan@gmail.com";
        String password ="Assassincreed2";
        
        Session session = Session.getDefaultInstance(prop, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAdress, password);
            }
        });
        Message msg = prepareMessage(session , myAdress , list);
        try {
            Transport.send(msg);
            System.out.println("message send");
        } catch (MessagingException ex) {
            Logger.getLogger(ServiceMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Message prepareMessage(Session session , String myAdress , List<String> list) {
        String id_commende= list.get(0);
        String type =list.get(1);
        String comp =list.get(2);
        String prix =list.get(3);
        String nom=list.get(4);
        String prenom = list.get(5);
        String recep = list.get(6);
        String entrep = list.get(7);
        String nomEnt="";
        String title="";
        String text="";
        if(entrep.equals("vol")){
            nomEnt ="Compagnie Aerien";
        }else if(entrep.equals("bateau")){
            nomEnt ="Compagnie Maritime";
        }else if(entrep.equals("offer")){
            nomEnt ="Titre De L'offre";
        }else if(entrep.equals("plan")){
            nomEnt="Titre De Plan";
        }
            
        
        if(type.equals("en ligne")){
            title="Merci pour votre achat!";
        }else if(type.equals("agence")){
            title="Merci pour votre reservation!";
            text="Vous pouvez vous rendre à l'agence pour le paiement";
        }
        
        try {
            Message msg = new MimeMessage( session);
            msg.setFrom(new InternetAddress(myAdress));
            msg.setSubject("Get Your Fun");
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recep));
            String html ="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" style=\"width:100%;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\n" +
" <head> \n" +
"  <meta charset=\"UTF-8\"> \n" +
"  <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\"> \n" +
"  <meta name=\"x-apple-disable-message-reformatting\"> \n" +
"  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> \n" +
"  <meta content=\"telephone=no\" name=\"format-detection\"> \n" +
"  <title>New email template 2022-02-20</title> \n" +
"  <!--[if (mso 16)]>\n" +
"    <style type=\"text/css\">\n" +
"    a {text-decoration: none;}\n" +
"    </style>\n" +
"    <![endif]--> \n" +
"  <!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]--> \n" +
"  <!--[if gte mso 9]>\n" +
"<xml>\n" +
"    <o:OfficeDocumentSettings>\n" +
"    <o:AllowPNG></o:AllowPNG>\n" +
"    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
"    </o:OfficeDocumentSettings>\n" +
"</xml>\n" +
"<![endif]--> \n" +
"  <!--[if !mso]><!-- --> \n" +
"  <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700,700i\" rel=\"stylesheet\"> \n" +
"  <!--<![endif]--> \n" +
"  <style type=\"text/css\">\n" +
"#outlook a {\n" +
"	padding:0;\n" +
"}\n" +
".ExternalClass {\n" +
"	width:100%;\n" +
"}\n" +
".ExternalClass,\n" +
".ExternalClass p,\n" +
".ExternalClass span,\n" +
".ExternalClass font,\n" +
".ExternalClass td,\n" +
".ExternalClass div {\n" +
"	line-height:100%;\n" +
"}\n" +
".es-button {\n" +
"	mso-style-priority:100!important;\n" +
"	text-decoration:none!important;\n" +
"}\n" +
"a[x-apple-data-detectors] {\n" +
"	color:inherit!important;\n" +
"	text-decoration:none!important;\n" +
"	font-size:inherit!important;\n" +
"	font-family:inherit!important;\n" +
"	font-weight:inherit!important;\n" +
"	line-height:inherit!important;\n" +
"}\n" +
".es-desk-hidden {\n" +
"	display:none;\n" +
"	float:left;\n" +
"	overflow:hidden;\n" +
"	width:0;\n" +
"	max-height:0;\n" +
"	line-height:0;\n" +
"	mso-hide:all;\n" +
"}\n" +
"[data-ogsb] .es-button {\n" +
"	border-width:0!important;\n" +
"	padding:15px 30px 15px 30px!important;\n" +
"}\n" +
"@media only screen and (max-width:600px) {p, ul li, ol li, a { line-height:150%!important } h1, h2, h3, h1 a, h2 a, h3 a { line-height:120%!important } h1 { font-size:32px!important; text-align:center } h2 { font-size:26px!important; text-align:center } h3 { font-size:20px!important; text-align:center } .es-header-body h1 a, .es-content-body h1 a, .es-footer-body h1 a { font-size:32px!important } .es-header-body h2 a, .es-content-body h2 a, .es-footer-body h2 a { font-size:26px!important } .es-header-body h3 a, .es-content-body h3 a, .es-footer-body h3 a { font-size:20px!important } .es-menu td a { font-size:16px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:16px!important } .es-content-body p, .es-content-body ul li, .es-content-body ol li, .es-content-body a { font-size:16px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:16px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:12px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:inline-block!important } a.es-button, button.es-button { font-size:16px!important; display:inline-block!important; border-width:15px 30px 15px 30px!important } .es-btn-fw { border-width:10px 0px!important; text-align:center!important } .es-adaptive table, .es-btn-fw, .es-btn-fw-brdr, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0px!important } .es-m-p0r { padding-right:0px!important } .es-m-p0l { padding-left:0px!important } .es-m-p0t { padding-top:0px!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } tr.es-desk-hidden, td.es-desk-hidden, table.es-desk-hidden { width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } tr.es-desk-hidden { display:table-row!important } table.es-desk-hidden { display:table!important } td.es-desk-menu-hidden { display:table-cell!important } .es-menu td { width:1%!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } }\n" +
"</style> \n" +
" </head> \n" +
" <body style=\"width:100%;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\"> \n" +
"  <div class=\"es-wrapper-color\" style=\"background-color:#EEEEEE\"> \n" +
"   <!--[if gte mso 9]>\n" +
"			<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
"				<v:fill type=\"tile\" color=\"#eeeeee\"></v:fill>\n" +
"			</v:background>\n" +
"		<![endif]--> \n" +
"   <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top\"> \n" +
"     <tr style=\"border-collapse:collapse\"> \n" +
"      <td valign=\"top\" style=\"padding:0;Margin:0\"> \n" +
"       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \n" +
"         <tr style=\"border-collapse:collapse\"> \n" +
"          <td align=\"center\" style=\"padding:0;Margin:0\"> \n" +
"           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"> \n" +
"             <tr style=\"border-collapse:collapse\"> \n" +
"              <td align=\"left\" style=\"Margin:0;padding-left:10px;padding-right:10px;padding-top:15px;padding-bottom:15px\"> \n" +
"               <!--[if mso]><table style=\"width:580px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:282px\" valign=\"top\"><![endif]--> \n" +
"               <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\"> \n" +
"                 <tr style=\"border-collapse:collapse\"> \n" +
"                  <td align=\"left\" style=\"padding:0;Margin:0;width:282px\"> \n" +
"                   \n" +
"                 </tr> \n" +
"               </table> \n" +
"               <!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:278px\" valign=\"top\"><![endif]--> \n" +
"               <table class=\"es-right\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\"> \n" +
"                 <tr style=\"border-collapse:collapse\"> \n" +
"                  <td align=\"left\" style=\"padding:0;Margin:0;width:278px\"> \n" +
"                    \n" +
"                 </tr> \n" +
"               </table> \n" +
"               <!--[if mso]></td></tr></table><![endif]--></td> \n" +
"             </tr> \n" +
"           </table></td> \n" +
"         </tr> \n" +
"       </table> \n" +
"       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \n" +
"         <tr style=\"border-collapse:collapse\"></tr> \n" +
"         <tr style=\"border-collapse:collapse\"> \n" +
"          <td align=\"center\" style=\"padding:0;Margin:0\"> \n" +
"           <table class=\"es-header-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#044767;width:600px\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#044767\" align=\"center\"> \n" +
"             <tr style=\"border-collapse:collapse\"> \n" +
"              <td align=\"left\" style=\"Margin:0;padding-top:35px;padding-bottom:35px;padding-left:35px;padding-right:35px\"> \n" +
"               <!--[if mso]><table style=\"width:530px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:340px\" valign=\"top\"><![endif]--> \n" +
"               <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\"> \n" +
"                 <tr style=\"border-collapse:collapse\"> \n" +
"                  <td class=\"es-m-p0r es-m-p20b\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:340px\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td class=\"es-m-txt-c\" align=\"left\" style=\"padding:0;Margin:0\"><h1 style=\"Margin:0;line-height:36px;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;font-size:36px;font-style:normal;font-weight:bold;color:#ffffff\">Get Your Fun</h1></td> \n" +
"                     </tr> \n" +
"                   </table></td> \n" +
"                 </tr> \n" +
"               </table> \n" +
"               <!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:170px\" valign=\"top\"><![endif]--> \n" +
"               <table cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                 <tr class=\"es-hidden\" style=\"border-collapse:collapse\"> \n" +
"                  <td class=\"es-m-p20b\" align=\"left\" style=\"padding:0;Margin:0;width:170px\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:5px;font-size:0\"> \n" +
"                       </td> \n" +
"                     </tr> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td style=\"padding:0;Margin:0\"> \n" +
"                       <table cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                         <tr style=\"border-collapse:collapse\"> \n" +
"                          <td align=\"center\" style=\"padding:0;Margin:0;display:none\"></td> \n" +
"                         </tr> \n" +
"                       </table></td> \n" +
"                     </tr> \n" +
"                   </table></td> \n" +
"                 </tr> \n" +
"               </table> \n" +
"               <!--[if mso]></td></tr></table><![endif]--></td> \n" +
"             </tr> \n" +
"           </table></td> \n" +
"         </tr> \n" +
"       </table> \n" +
"       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \n" +
"         <tr style=\"border-collapse:collapse\"> \n" +
"          <td align=\"center\" style=\"padding:0;Margin:0\"> \n" +
"           <table class=\"es-content-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\"> \n" +
"             <tr style=\"border-collapse:collapse\"> \n" +
"              <td align=\"left\" style=\"padding:0;Margin:0;padding-left:35px;padding-right:35px;padding-top:40px\"> \n" +
"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                 <tr style=\"border-collapse:collapse\"> \n" +
"                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:530px\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td align=\"center\" style=\"Margin:0;padding-top:25px;padding-bottom:25px;padding-left:35px;padding-right:35px;font-size:0\"><a target=\"_blank\" href=\"https://viewstripo.email/\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#ED8E20;font-size:16px\"><img src=\"https://kzuspz.stripocdn.email/content/guids/CABINET_75694a6fc3c4633b3ee8e3c750851c02/images/67611522142640957.png\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"120\"></a></td> \n" +
"                     </tr> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:10px\"><h2 style=\"Margin:0;line-height:36px;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;font-size:30px;font-style:normal;font-weight:bold;color:#333333\">"+title +"</h2></td> \n" +
"                     </tr> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:10px\"><h2 style=\"Margin:0;line-height:36px;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;font-size:17px;font-style:normal;color:#666565\">"+text+"</h2></td> \n" +
"                     </tr> \n" +
"                      \n" +
"                   </table></td> \n" +
"                 </tr> \n" +
"               </table></td> \n" +
"             </tr> \n" +
"           </table></td> \n" +
"         </tr> \n" +
"       </table> \n" +
"       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \n" +
"         <tr style=\"border-collapse:collapse\"> \n" +
"          <td align=\"center\" style=\"padding:0;Margin:0\"> \n" +
"           <table class=\"es-content-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\"> \n" +
"             <tr style=\"border-collapse:collapse\"> \n" +
"              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:35px;padding-right:35px\"> \n" +
"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                 <tr style=\"border-collapse:collapse\"> \n" +
"                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:530px\"> \n" +
"                   </td> \n" +
"                 </tr> \n" +
"               </table></td> \n" +
"             </tr> \n" +
"             <tr style=\"border-collapse:collapse\"> \n" +
"              <td align=\"left\" style=\"padding:0;Margin:0;padding-left:35px;padding-right:35px\"> \n" +
"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                 <tr style=\"border-collapse:collapse\"> \n" +
"                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:530px\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td align=\"left\" style=\"Margin:0;padding-top:10px;padding-bottom:10px;padding-left:10px;padding-right:10px\"> \n" +
"                        <td class=\"esd-block-text es-p10t es-p10b es-p10r es-p10l\" align=\"left\">\n" +
"                          <table style=\"width: 500px;\" class=\"cke_show_border\" cellspacing=\"1\" cellpadding=\"1\" border=\"0\" align=\"left\">\n" +
"                              <tbody>\n" +
"                                  <tr>\n" +
"                                      <td style=\"padding: 5px 10px 5px 0\" width=\"80%\" align=\"left\">\n" +
"                                          <p>Numero Commende</p>\n" +
"                                      </td>\n" +
"                                      <td style=\"padding: 5px 0\" width=\"20%\" align=\"left\">\n" +
"                                          <p>"+ id_commende+"</p>\n" +
"                                      </td>\n" +
"                                  </tr>\n" +
"                                  <tr>\n" +
"                                      <td style=\"padding: 5px 10px 5px 0\" width=\"80%\" align=\"left\">\n" +
"                                          <p>Nom est prenom  </p>\n" +
"                                      <td style=\"padding: 5px 0\" width=\"20%\" align=\"left\">\n" +
"                                          <p>"+ nom+" "+ prenom+"</p>\n" +
"                                      </td>\n" +
"                                  </tr>\n" +
"                                  <tr>\n" +
"                                      <td style=\"padding: 5px 10px 5px 0\" width=\"80%\" align=\"left\">\n" +
"                                          <p>"+ nomEnt+"</p>\n" +
"                                      </td>\n" +
"                                      <td style=\"padding: 5px 0\" width=\"20%\" align=\"left\">\n" +
"                                          <p>"+ comp+"</p>\n" +
"                                      </td>\n" +
"                                  </tr>\n" +
"                                  <tr>\n" +
"                                    <td style=\"padding: 5px 10px 5px 0\" width=\"80%\" align=\"left\">\n" +
"                                        <p>Email De L'utilisateur</p>\n" +
"                                    </td>\n" +
"                                    <td style=\"padding: 5px 0\" width=\"20%\" align=\"left\">\n" +
"                                        <p>"+ recep+"</p>\n" +
"                                    </td>\n" +
"                                </tr>\n" +
"                              </tbody>\n" +
"                          </table>\n" +
"                      </td> \n" +
"                      </td> \n" +
"                     </tr> \n" +
"                   </table></td> \n" +
"                 </tr> \n" +
"               </table></td> \n" +
"             </tr> \n" +
"             <tr style=\"border-collapse:collapse\"> \n" +
"              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:10px;padding-left:35px;padding-right:35px\"> \n" +
"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                 <tr style=\"border-collapse:collapse\"> \n" +
"                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:530px\"> \n" +
"                   <table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;border-top:3px solid #eeeeee;border-bottom:3px solid #eeeeee\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\"> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td align=\"left\" style=\"Margin:0;padding-left:10px;padding-right:10px;padding-top:15px;padding-bottom:15px\"> \n" +
"                       <table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;width:500px\" class=\"cke_show_border\" cellspacing=\"1\" cellpadding=\"1\" border=\"0\" align=\"left\" role=\"presentation\"> \n" +
"                         <tr style=\"border-collapse:collapse\"> \n" +
"                          <td width=\"80%\" style=\"padding:0;Margin:0\"><h4 style=\"Margin:0;line-height:120%;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif\">Prix De Commende</h4></td> \n" +
"                          <td width=\"20%\" style=\"padding:0;Margin:0\"><h4 style=\"Margin:0;line-height:120%;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif\">"+ prix+"</h4></td> \n" +
"                         </tr> \n" +
"                       </table></td> \n" +
"                     </tr> \n" +
"                   </table></td> \n" +
"                 </tr> \n" +
"               </table></td> \n" +
"             </tr> \n" +
"             <tr style=\"border-collapse:collapse\"> \n" +
"              <td align=\"left\" style=\"Margin:0;padding-left:35px;padding-right:35px;padding-top:40px;padding-bottom:40px\"> \n" +
"               <!--[if mso]><table style=\"width:530px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:255px\" valign=\"top\"><![endif]--> \n" +
"               <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\"> \n" +
"                 <tr style=\"border-collapse:collapse\"> \n" +
"                  <td class=\"es-m-p20b\" align=\"left\" style=\"padding:0;Margin:0;width:255px\"> \n" +
"                   \n" +
"                 </tr> \n" +
"               </table> \n" +
"               <!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:255px\" valign=\"top\"><![endif]--> \n" +
"               <table class=\"es-right\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\"> \n" +
"                 <tr style=\"border-collapse:collapse\"> \n" +
"                  <td align=\"left\" style=\"padding:0;Margin:0;width:255px\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td align=\"left\" style=\"padding:0;Margin:0;padding-bottom:15px\"><h4 style=\"Margin:0;line-height:120%;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif\">Contact<br></h4></td> \n" +
"                     </tr> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;line-height:24px;color:#333333;font-size:16px\">Email : getyourfan@gmail.com</p></td> \n" +
"                     </tr> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;line-height:24px;color:#333333;font-size:16px\">phone : 71456258</p></td> \n" +
"                     </tr>\n" +
"                   </table></td> \n" +
"                 </tr> \n" +
"               </table> \n" +
"               <!--[if mso]></td></tr></table><![endif]--></td> \n" +
"             </tr> \n" +
"           </table></td> \n" +
"         </tr> \n" +
"       </table> \n" +
"       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \n" +
"         <tr style=\"border-collapse:collapse\"> \n" +
"          <td align=\"center\" style=\"padding:0;Margin:0\"> \n" +
"           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"> \n" +
"             <tr style=\"border-collapse:collapse\"> \n" +
"              <td align=\"left\" style=\"Margin:0;padding-left:20px;padding-right:20px;padding-top:30px;padding-bottom:30px\"> \n" +
"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                 <tr style=\"border-collapse:collapse\"> \n" +
"                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\"> \n" +
"                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \n" +
"                     <tr style=\"border-collapse:collapse\"> \n" +
"                      <td class=\"es-infoblock made_with\" align=\"center\" style=\"padding:0;Margin:0;line-height:120%;font-size:0;color:#CCCCCC\"><a target=\"_blank\" href=\"https://viewstripo.email/?utm_source=templates&utm_medium=email&utm_campaign=accessory&utm_content=trigger_newsletter3\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#CCCCCC;font-size:12px\"></td> \n" +
"                     </tr> \n" +
"                   </table></td> \n" +
"                 </tr> \n" +
"               </table></td> \n" +
"             </tr> \n" +
"           </table></td> \n" +
"         </tr> \n" +
"       </table></td> \n" +
"     </tr> \n" +
"   </table> \n" +
"  </div>  \n" +
" </body>\n" +
"</html>";
            msg.setContent(html,"text/html");
            return msg;
        } catch (Exception ex) {
            Logger.getLogger(ServiceMail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
