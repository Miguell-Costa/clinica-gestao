package controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public abstract class BaseController {
    // metodo para verificar um email
    protected boolean validarEmail(String email){
        String regex = "^[\\w.-]+@([a-zA-Z-]+\\.)+[a-zA-Z]{2,}$";
        return Pattern.matches(regex, email);
    }

    // Metodo para verificar telemovel
    protected boolean validarTelemovel(String telemovel){
        String regex = "^9\\d{8}$";
        return Pattern.matches(regex, telemovel);
    }

    // Metodo para verificar a data
    protected boolean validarData(String data) {

        // Verificar formato YYYY/MM/DD
        String regex = "^\\d{4}-\\d{2}-\\d{2}$";
        if (!Pattern.matches(regex, data)) {
            return false;
        }

        // Verificar se a data existe
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate.parse(data, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // metodo para verificar a hora
    protected boolean validarHora(String hora){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            formatter.parse(hora);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // metodo para verificar hora e data futura
    public static boolean dataHoraFutura(String dataStr, String horaStr) {

        LocalDate data = LocalDate.parse(dataStr);
        LocalTime hora = LocalTime.parse(horaStr);

        LocalDate hoje = LocalDate.now();
        LocalTime agora = LocalTime.now();

        // Se a data for depois de hoje → válido
        if (data.isAfter(hoje)) {
            return true;
        }

        // Se for hoje → a hora tem de ser futura
        if (data.isEqual(hoje)) {
            return hora.isAfter(agora);
        }

        // Se for antes de hoje → inválido
        return false;
    }

    // DATA FUTURA
    protected boolean dataFutura(String data) {
        try {
            LocalDate d = LocalDate.parse(data);
            return d.isAfter(LocalDate.now());
        } catch (Exception e) {
            return false;
        }
    }



}
