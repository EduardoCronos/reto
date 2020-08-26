package com.crono.reto.validators;

import org.springframework.stereotype.Component;

@Component
public class Validation {
	public boolean validateQR(String qr) {
		// H1XX###XXXX#

		String value;
		boolean isValid = false;

		if (qr.length() == 12) {
			char[] caracteres = qr.toCharArray();

			if (caracteres[0] == 'H' && caracteres[1] == '1') {
				isValid = true;
			} else if (caracteres[0] == 'D' && caracteres[1] == '2') {
				isValid = true;
			}

			for (int i = 2; i < caracteres.length; i++) {
				if (isValid) {
					value = String.valueOf(caracteres[i]);

					switch (i) {
					case 2:
						isValid = (value.matches(".*[A-Z].*")) ? true : false;
						break;
					case 3:
						isValid = (value.matches(".*[A-Z].*")) ? true : false;
						break;
					case 4:
						isValid = (value.matches(".*[0-9].*")) ? true : false;
						break;
					case 5:
						isValid = (value.matches(".*[0-9].*")) ? true : false;
						break;
					case 6:
						isValid = (value.matches(".*[0-9].*")) ? true : false;
						break;
					case 7:
						isValid = (value.matches(".*[A-Z].*")) ? true : false;
						break;
					case 8:
						isValid = (value.matches(".*[A-Z].*")) ? true : false;
						break;
					case 9:
						isValid = (value.matches(".*[A-Z].*")) ? true : false;
						break;
					case 10:
						isValid = (value.matches(".*[A-Z].*")) ? true : false;
						break;
					case 11:
						isValid = (value.matches(".*[0-9].*")) ? true : false;
						break;
					default:
						break;
					}
				}
			}

		}

		return isValid;
	}
}
