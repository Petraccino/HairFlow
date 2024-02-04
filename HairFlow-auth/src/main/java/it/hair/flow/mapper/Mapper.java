package it.hair.flow.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.hair.flow.dto.ClienteDTO;
import it.hair.flow.dto.UtenteDTO;
import it.hair.flow.entity.Cliente;
import it.hair.flow.entity.Utente;

@Configuration
public class Mapper {
	
	@Bean(name = "modelMapper")
	ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(Boolean.TRUE);
	    return new ModelMapper();
	}
	
	@Bean(name = "modelMapperSkypPasswordUtente")
    ModelMapper modelMapperSkypPasswordUtente() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setSkipNullEnabled(Boolean.TRUE);

        mapper.addMappings(new PropertyMap<Utente, UtenteDTO>() {
            @Override
            protected void configure() {
                skip(destination.getPassword());
            }
        });
        return mapper;
    }
	
	@Bean(name = "modelMapperSkypPasswordCliente")
    ModelMapper modelMapperSkypPasswordCliente() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setSkipNullEnabled(Boolean.TRUE);

        mapper.addMappings(new PropertyMap<Cliente, ClienteDTO>() {
            @Override
            protected void configure() {
                skip(destination.getPassword());
            }
        });
        return mapper;
    }
}