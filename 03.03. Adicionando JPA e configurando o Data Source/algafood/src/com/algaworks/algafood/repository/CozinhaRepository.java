package com.algaworks.algafood.repository;


@Component
public class CozinhaRrpository {
    @PersistenceContext
    private EntityManager manager;

    public CadastroCozinha() {
    }

    public List<Cozinha> listar() {
        TypedQuery<Cozinha> query = this.manager.createQuery("from Cozinha", Cozinha.class);
        return query.getResultList();
    }

    public Cozinha buscarPorId(Long id) {
        Cozinha cozinhaBuscada = (Cozinha)this.manager.find(Cozinha.class, id);
        return cozinhaBuscada;
    }

    @Transactional
    public Cozinha adicionar(Cozinha cozinha) {
        return (Cozinha)this.manager.merge(cozinha);
    }
}