package com.natixis.cco.upconnect.rest.codes;

import javax.ws.rs.core.Response.Status.Family;
import javax.ws.rs.core.Response.StatusType;

public class UPConnectResponse {
	

	public enum UPConnectStatus implements StatusType {
		
		RACHAT_CALCUL_ERROR(420, "Problème de calcul IRA"),
		DATE_INVALIDE(421, "Date rachat invalide");
		
		private final int code;
        private final String reason;
        private Family family;
        
        

        UPConnectStatus(final int statusCode, final String reasonPhrase) {
            this.code = statusCode;
            this.reason = reasonPhrase;
            switch(code/100) {
                case 1: this.family = Family.INFORMATIONAL; break;
                case 2: this.family = Family.SUCCESSFUL; break;
                case 3: this.family = Family.REDIRECTION; break;
                case 4: this.family = Family.CLIENT_ERROR; break;
                case 5: this.family = Family.SERVER_ERROR; break;
                default: this.family = Family.OTHER; break;
            }
        }
        
        /**
         * Get the class of status code
         * @return the class of status code
         */
        public Family getFamily() {
            return family;
        }
        
        /**
         * Get the associated status code
         * @return the status code
         */
        public int getStatusCode() {
            return code;
        }
        
        /**
         * Get the reason phrase
         * @return the reason phrase
         */
        public String getReasonPhrase() {
            return toString();
        }
        
        /**
         * Get the reason phrase
         * @return the reason phrase
         */
        @Override
        public String toString() {
            return reason;
        }
        
        /**
         * Convert a numerical status code into the corresponding Status
         * @param statusCode the numerical status code
         * @return the matching Status or null is no matching Status is defined
         */
        public static UPConnectStatus fromStatusCode(final int statusCode) {
            for (UPConnectStatus s : UPConnectStatus.values()) {
                if (s.code == statusCode) {
                    return s;
                }
            }
            return null;
        }
	}

}
