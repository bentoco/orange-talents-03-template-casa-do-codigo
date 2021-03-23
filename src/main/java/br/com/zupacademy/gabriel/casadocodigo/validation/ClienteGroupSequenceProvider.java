package br.com.zupacademy.gabriel.casadocodigo.validation;

import br.com.zupacademy.gabriel.casadocodigo.cliente.ClienteNovoRequest;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class ClienteGroupSequenceProvider implements DefaultGroupSequenceProvider<ClienteNovoRequest> {

    @Override public List<Class<?>> getValidationGroups ( ClienteNovoRequest object ) {
        List<Class<?>> groups = new ArrayList<>();
        groups.add(ClienteNovoRequest.class);

        if(isPessoaSelecionada(object)) {
            groups.add(object.getTipoPessoa().getGroup());
        }
        return groups;
    }

    protected boolean isPessoaSelecionada(ClienteNovoRequest object) {
        return object != null && object.getTipoPessoa() != null;
    }
}
