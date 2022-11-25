package programa.banco.ultils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FormatadorBr {
    static NumberFormat formatador = new DecimalFormat(" R$ #,## 0.00 ");
    public static String conversor(double valor){
        return formatador.format(valor);
    }
}
