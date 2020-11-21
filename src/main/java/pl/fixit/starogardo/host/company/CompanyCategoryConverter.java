package pl.fixit.starogardo.host.company;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.fixit.stargardo.common.company.enums.CompanyCategory;

@Component
public class CompanyCategoryConverter implements Converter<String, CompanyCategory> {
    @Override
    public CompanyCategory convert(String value) {
        return CompanyCategory.parse(Integer.valueOf(value));
    }
}