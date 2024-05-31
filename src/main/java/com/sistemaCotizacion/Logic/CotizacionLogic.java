package com.sistemaCotizacion.Logic;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

@Service
public class CotizacionLogic {
    public BigDecimal calcularAbonoNormal(BigDecimal precio, BigDecimal tasaNormal, int plazo) {
        return precio.multiply(tasaNormal).add(precio).divide(BigDecimal.valueOf(plazo), RoundingMode.HALF_UP);
    }

   public BigDecimal calcularAbonoPuntual(BigDecimal precio,BigDecimal tasaPuntual, int plazo) {
	   return precio.multiply(tasaPuntual).add(precio).divide(BigDecimal.valueOf(plazo), RoundingMode.HALF_UP);
	   
   }
}
