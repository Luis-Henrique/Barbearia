/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luish.barber.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author luis
 */
public class DateUtil {

    public static Date StringToDate(String data) {

        try {

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            Date dataFinal = new Date(format.parse(data).getTime());

            return dataFinal;

        } catch (Exception ex) {
            return null;
        }
    }

}
