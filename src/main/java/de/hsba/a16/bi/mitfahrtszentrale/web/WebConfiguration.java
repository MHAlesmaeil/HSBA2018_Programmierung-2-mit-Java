package de.hsba.a16.bi.mitfahrtszentrale.web;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.number.NumberFormatAnnotationFormatterFactory;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;

@Configuration
public class WebConfiguration {

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

   @Bean
	public FormattingConversionService formattingConversionService (){
	   DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);
	   conversionService.addFormatterForFieldAnnotation(new NumberFormatAnnotationFormatterFactory());

	   DateFormatterRegistrar registrar = new DateFormatterRegistrar();
	   registrar.setFormatter(new DateFormatter("dd.MM.yyyy hh:mm"));
	   registrar.registerFormatters(conversionService);
	   return conversionService;
   }
}
