package br.senai.sc.validador;

import java.util.InputMismatchException;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateus Generoso
 * @version 1.0 26/08/2013
 */
public abstract class Validadores {
    
/**
 * Método responsável pela validação dos campos que aceitam somente letras
 * @author Mateus Generoso
 * @since 1.0 26/08/2013
 * @param text
 * @return 
 */
    public static boolean somenteLetras(String text, String msg){
        String letra;
        for (int i = 0; i < text.length();i++){
            letra = text.substring(i, i + 1); // Letra recebe caracter atual do loop
            
            if (letra.matches("\\d")){ 
                // Se a letra estiver dentro da ER retorna FALSE, pois apenas letras são suportadas.
                JOptionPane.showMessageDialog(null, msg + " inválido(a), apenas letras são suportadas!");
                return false;
            }
        }
        return true;
        
    }

/**
 * Método responsável pela validação dos campos que aceitam somente numeros
 * @author Mateus Generoso
 * @since 1.0 26/08/2013
 * @param text
 * @return 
 */
    public static boolean somenteNumeros(String text, String msg){
        String letra;
        for (int i = 0; i < text.length();i++){
            letra = text.substring(i, i + 1); // Letra recebe caracter atual do loop
            
            if (!letra.matches("\\d")){ 
                // Se a letra estiver dentro da ER retorna FALSE, pois apenas letras são suportadas.
                JOptionPane.showMessageDialog(null, msg + " inválido(a), apenas números são suportados!");
                return false;
            }
        }     
        return true;
        
    }
  
/**
 * Método responsável pela validação do e-mail
 * @author Mateus Generoso
 * @since 1.0 26/08/2013
 * @param text
 * @return 
 */
  public static boolean validaEmail(String text){
    boolean stricterFilter = true; 
    String stricterFilterString = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
    String laxString = ".+@.+\\.[A-Za-z]{2}[A-Za-z]*";
    String emailRegex = stricterFilter ? stricterFilterString : laxString;
    java.util.regex.Pattern p = java.util.regex.Pattern.compile(emailRegex);
    java.util.regex.Matcher m = p.matcher(text);
    if(m.matches()){
     return true;
    } 
    
    JOptionPane.showMessageDialog(null, "E-mail inválido!");
    return false;
    }
  
  
/**
 * Método responsável pela validação dos campos vazios
 * @author Mateus Generoso
 * @since 1.0 26/08/2013
 * @param text
 * @return 
 */
  public static boolean validaCampoVazio(String text, String msg){
       if((text == null) || (text.equals(""))){
               JOptionPane.showMessageDialog(null, msg + " inválido(a), o campo está vazio!");
               return false;
       }
       return true;
    }
  
   /**
    * Método responsável pela validação do CNPJ 
    * @author Mateus Generoso
    * @since 1.0 06/11/2013
    * @param text
    * @return 
    */
  public static boolean validaCnpj(String text){
    if (text.equals("00000000000000") || text.equals("11111111111111") ||
        text.equals("22222222222222") || text.equals("33333333333333") ||
        text.equals("44444444444444") || text.equals("55555555555555") ||
        text.equals("66666666666666") || text.equals("77777777777777") ||
        text.equals("88888888888888") || text.equals("99999999999999") ||
       (text.length() != 14)){
       JOptionPane.showMessageDialog(null, "CNPJ inválido!");
       return(false);
    }
    char dig13, dig14;
    int sm, i, r, num, peso;

    try {
      sm = 0;
      peso = 2;
      for (i=11; i>=0; i--) {
        num = (int)(text.charAt(i) - 48);
        sm = sm + (num * peso);
        peso = peso + 1;
        if (peso == 10)
           peso = 2;
      }

      r = sm % 11;
      if ((r == 0) || (r == 1))
         dig13 = '0';
      else dig13 = (char)((11-r) + 48);

      sm = 0;
      peso = 2;
      for (i=12; i>=0; i--) {
        num = (int)(text.charAt(i)- 48);
        sm = sm + (num * peso);
        peso = peso + 1;
        if (peso == 10)
           peso = 2;
      }

      r = sm % 11;
      if ((r == 0) || (r == 1))
         dig14 = '0';
      else dig14 = (char)((11-r) + 48);

      if ((dig13 == text.charAt(12)) && (dig14 == text.charAt(13)))
         return(true);
      else {
          JOptionPane.showMessageDialog(null, "CNPJ inválido!");
          return(false);
                  
                  }
    } catch (InputMismatchException erro) {
        JOptionPane.showMessageDialog(null, "CNPJ inválido!");
        return(false);
    }
  }
 /**
  * Método responsável pela validação dos campos do tipo double 
  * @author Mateus Generoso
  * @since 1.0 06/11/2013
  * @param text
  * @param msg
  * @return 
  */
    public static boolean validaDouble(String text, String msg){
       try {
           Double numero = Double.parseDouble(text);
           return true;
       } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, msg + " inválido, digite um valor no formato '999.00'");
       return false;
       }
    }
    
  /**
   * Método responsável por validar a data
   * @param text
   * @param msg
   * @return 
   */
    public static boolean validaData(String text, String msg){
       if(text.trim().length() < 10) {
               JOptionPane.showMessageDialog(null, msg + " inválido, digite um valor no formato 'XX/XX/XXXX'");
       return false;
       } else {
       return true;
       }
    }
  
} 

