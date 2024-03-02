package com.ealgaworks.algafoodapi.api.model;

import com.ealgaworks.algafoodapi.domain.model.Cozinha;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@JacksonXmlRootElement(localName = "cozinhas")
public class CozinhaXmlWraper {

    @JsonProperty("cozinha")
    @JacksonXmlElementWrapper(useWrapping = false)
    @NonNull
    private List<Cozinha> cozinhas;


}
