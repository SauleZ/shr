package kz.dara.efc.shr.util;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Converts db column CHAR(1) to java.lang.Boolean and vice versa
 */
@Converter
public class JpaBooleanConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean aBoolean) {
        return (aBoolean != null && aBoolean) ? "Y" : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String s) {
        return "Y".equals(s);
    }
}
