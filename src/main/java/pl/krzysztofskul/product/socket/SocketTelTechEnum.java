package pl.krzysztofskul.product.socket;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SocketTelTechEnum {

    @JsonProperty("RJ-45 (LAN)")
    LAN_RJ45 {
        @Override
        public String toString() {
            return "RJ-45 (LAN)";
        }
    },
    @JsonProperty("RJ-11 (TELEPHONE)")
    TELEPHONE_RJ11 {
        @Override
        public String toString() {
            return "RJ-11 (TELEPHONE)";
        }
    }

}
