package com.hgun.sti.components;

import com.hgun.sti.models.Role;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class RoleConverter implements Converter<String, Role> {
    @Override
    public Role convert(String id){
        int convertido = Integer.parseInt(id);

        var aux1 = new Role("ADMINISTRADOR");
        var aux2 = new Role("FUNCIONARIO");

        aux1.setId(Long.valueOf("1"));
        aux1.setAtivo(true);
        aux2.setId(Long.valueOf("2"));
        aux2.setAtivo(true);

        Set<Role> roles = Stream.of(aux1,aux2).collect(Collectors.toSet());

        List<Role> rolesList = new ArrayList<Role>(roles);

        int index = convertido - 1;

        return rolesList.get(index);
    }
}
