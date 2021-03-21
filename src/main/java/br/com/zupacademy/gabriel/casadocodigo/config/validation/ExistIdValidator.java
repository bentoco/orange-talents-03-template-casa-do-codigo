package br.com.zupacademy.gabriel.casadocodigo.config.validation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistIdValidator implements ConstraintValidator<ExistId, Long> {

    private String domainAttribute;
    private Class<?> klass;

    @PersistenceContext
    private EntityManager manager;

    @Override public void initialize ( ExistId params ) {
        domainAttribute = params.fieldName();
        klass = params.domainClass();
    }

    @Override public boolean isValid ( Long value, ConstraintValidatorContext context ) {
        Query q = manager.createQuery("SELECT 1 FROM " + klass.getName() + " WHERE " + domainAttribute + " =:value");
        q.setParameter("value", value);
        List<?> resultado = q.getResultList();

        return !resultado.isEmpty();
    }
}
