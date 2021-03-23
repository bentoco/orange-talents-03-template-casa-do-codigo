package br.com.zupacademy.gabriel.casadocodigo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint (validatedBy = UniqueStateInCountryValidator.class )
@Target ({ TYPE, FIELD })
@Retention (RUNTIME)
public @interface UniqueStateInCountry {
    String message() default "estado informado já possui cadastro para pais.";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    Class<?> estadoClass();
}

