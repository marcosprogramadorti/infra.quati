package org.quati;

import java.util.List;

import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/pessoa-fisica")
public class PessoaFisicaResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PessoaFisica> todas() {
        return PessoaFisica.listAll();
    }

    @POST
    @Transactional
    @RolesAllowed("manager")
    public void nova(PessoaFisica pf) {
        pf.persist();
    }
}
