package Modelos;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

    public class TasaDeCambio {
        @SerializedName("base_code")
        private String baseCode;
        @SerializedName("conversion_rates")
        private Map<String, Double> conversionRates;

        @Override
        public String toString() {
            return "TasaDeCambio{" +"\n"+
                    ", baseCode='" + baseCode + '\n' +
                    ", conversionRates=" + conversionRates +
                    '}';
        }
        public String getBaseCode() {
            return baseCode;
        }
        public Map<String, Double> getConversionRates() {
            return conversionRates;
        }
    }

